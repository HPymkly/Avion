package com.main.demo.authentification.service;

import java.util.List;

import com.main.demo.authentification.model.User;

public interface UserService {
    public User login(String email, String mdp) throws Exception;

    public void create(String email, String mdp);

    public List<User> getAll();
}
