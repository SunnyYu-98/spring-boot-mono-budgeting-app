package com.cashu.budgetapp.Service;

import com.cashu.budgetapp.model.User;
import com.cashu.budgetapp.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserService {

    @Resource(name = "userRepository")
    private UserRepository userRepository;

    @Resource(name = "bCryptPasswordEncoder")
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User getUserByEmail(String email){
        return userRepository.findUserByEmail(email);
    }

    public void saveUser(User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }


}
