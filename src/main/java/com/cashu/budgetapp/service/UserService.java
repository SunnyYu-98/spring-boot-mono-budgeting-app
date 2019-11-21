package com.cashu.budgetapp.service;

import com.cashu.budgetapp.dao.UserDao;
import com.cashu.budgetapp.model.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("userService")
public class UserService {

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

}
