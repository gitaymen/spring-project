package com.app.service;

import com.app.model.User;

import java.util.List;

public interface UserService {
    String upsert(User user);

    User getById(Integer id);

    List<User> getAllUsers();

    String deleteById(Integer id);
}
