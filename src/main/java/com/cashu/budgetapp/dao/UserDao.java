package com.cashu.budgetapp.dao;

import com.cashu.budgetapp.model.User;

import java.util.List;

public interface UserDao {
    User findUserByEmail(String email);
    void saveUser(User user);
    User createUser();
    List<User> getAllUsers();
}
