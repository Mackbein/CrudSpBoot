package com.app.CrudSpBoot.service;

import com.app.CrudSpBoot.models.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    Object getUserById(int id);

    void saveUser(User user);

    void updateUser(int id, User user);

    void deleteUser(int id);
}
