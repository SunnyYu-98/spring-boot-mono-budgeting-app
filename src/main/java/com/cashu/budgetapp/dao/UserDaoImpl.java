package com.cashu.budgetapp.dao;


import com.cashu.budgetapp.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public User findUserByEmail(String email) {
        return null;
    }
}
