package com.cashu.budgetapp.dao;


import com.cashu.budgetapp.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;
import java.util.List;
import java.util.function.Consumer;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    EntityManager entityManager;

    //@Transactional
    @Override
    public User findUserByEmail(String email) {
        Query query = entityManager.createNativeQuery("SELECT * FROM user WHERE email=?1",User.class);
        query.setParameter(1, email);

        List<User> users = query.getResultList();

        return users.isEmpty() ? null : users.get(0);
    }

    public List<User> getAll() {
        //Query query = entityManager.createQuery("SELECT e FROM user e");
        //return query.getResultList();
        return null;
    }

    @Override
    @Transactional
    public void saveUser(User user) {
       //executeInsideTransaction(entityManager -> entityManager.persist(user));
        entityManager.persist(user);

    }


    private void executeInsideTransaction(Consumer<EntityManager> action) {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            action.accept(entityManager);
            tx.commit();
        }
        catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }
    }


}
