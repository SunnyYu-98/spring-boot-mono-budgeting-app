package com.cashu.budgetapp.dao;

import com.cashu.budgetapp.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public User findUserByEmail(String email) {
        Query query = entityManager.createNativeQuery("SELECT * FROM user WHERE email=?1",User.class);
        query.setParameter(1, email);

        List<User> users = query.getResultList();

        return users.isEmpty() ? null : users.get(0);
    }

    public List<User> getAllUsers() {
        Query query = entityManager.createNativeQuery("SELECT * FROM user",User.class);
        return (List<User>) query.getResultList();
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    public User createUser() {
        return new User();
    }
}
