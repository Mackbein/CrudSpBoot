package com.app.CrudSpBoot.dao;

import com.app.CrudSpBoot.models.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDaolmpl implements UserDao{


    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public List<User> getAllUsers() {
        try {
            return entityManager.createQuery("FROM User", User.class).getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Transactional
    public User getUserById(int id) {
        try {
            return entityManager.find(User.class, id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Transactional
    public void saveUser(User user) {
        try {
            entityManager.persist(user);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Transactional
    public void updateUser(int id, User user) {
        try {
            User userResult = entityManager.find(User.class, id);
            userResult.setAge(user.getAge());
            userResult.setName(user.getName());
            userResult.setEmail(user.getEmail());
            entityManager.merge(userResult);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Transactional
    public void deleteUser(int id) {
        try {
            User user = entityManager.find(User.class, id);
            entityManager.remove(user);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}


