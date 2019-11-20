package com.cashu.budgetapp.dao;

import com.cashu.budgetapp.model.User;

public interface UserDao {
    User findUserByEmail(String email);
}
