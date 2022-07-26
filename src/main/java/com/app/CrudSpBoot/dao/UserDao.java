package com.app.CrudSpBoot.dao;


import com.app.CrudSpBoot.models.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();

    User getUserById(int id);

    void saveUser(User user);

    void updateUser(int id, User user);

    void deleteUser(int id);
}

