package com.app.service;

import com.app.model.User;

import java.util.List;

public interface UserService {
    public String upsert(User user);

    public User getById(Integer id);

    public List<User> getAllUsers();

    public String deleteById(Integer id);
}
