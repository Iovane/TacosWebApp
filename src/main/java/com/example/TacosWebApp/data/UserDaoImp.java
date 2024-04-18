package com.example.TacosWebApp.data;

import com.example.TacosWebApp.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImp implements UserDao{

    private final EntityManager entityManager;

    public UserDaoImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public User findByUsername(String username) {
        TypedQuery<User> theQuery = entityManager.createQuery("from User where username = :username", User.class);
        theQuery.setParameter("username", username);

        User theUser = null;

        try {
            theUser = theQuery.getSingleResult();
        } catch (Exception e) {
        }

        return theUser;
    }

    @Override
    @Transactional
    public void save(User user) {
        entityManager.merge(user);
    }
}
