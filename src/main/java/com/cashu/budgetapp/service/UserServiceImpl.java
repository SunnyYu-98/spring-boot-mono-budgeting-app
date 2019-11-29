package com.cashu.budgetapp.service;

import com.cashu.budgetapp.dao.UserDao;
import com.cashu.budgetapp.model.Role;
import com.cashu.budgetapp.model.User;
import com.cashu.budgetapp.model.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.security.auth.login.AccountLockedException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service("userService")
public class UserServiceImpl implements UserDetailsService {

    @Resource(name = "userDao")
    private UserDao userDao;

    @Resource(name = "bCryptPasswordEncoder")
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User getUserByEmail(String email){
        return userDao.findUserByEmail(email);
    }

    @Transactional
    public void saveUser(User user){
        userDao.saveUser(user);
    }

    @Transactional
    public void lockUser(String username) {
        //username = email
        User user = getUserByEmail(username);

        if (user != null) {
            int failedCount = user.getNumberOfFailedLogins() + 1;
            user.setNumberOfFailedLogins(failedCount);

            if (failedCount > 5) {
                user.setLocked(true);
            }

            saveUser(user);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = getUserByEmail(username);

        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password");
        }
        /*else if (user.isLocked())
            throw new AccountLockedException("Account is locked");
         */

        return new org.springframework.security.core.userdetails.User(username, user.getPassword(), user.isEnabled(),
                true, true, !user.isLocked(), getAuthorities(user));
    }

    private List<GrantedAuthority> getAuthorities(User user) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for (UserRole role : user.getUserRole()) {
            authorities.add(new SimpleGrantedAuthority(role.getRole().getRole()));
        }
        return authorities;
    }
}
