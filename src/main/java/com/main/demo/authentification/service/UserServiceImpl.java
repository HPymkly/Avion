package com.main.demo.authentification.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.demo.authentification.model.User;
import com.main.demo.authentification.repos.UserRepos;

import lombok.Data;

@Service
@Data
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepos ur;

    public User login(String email, String mdp) throws Exception {
        List<User> ans = this.getUr().login(email, mdp);
        if (ans.size() > 0) {
            
            return ans.get(0);
        }
        throw new Exception();
    }

    public void create(String email, String mdp) {
        User user = new User(email, mdp);
        this.getUr().save(user);
    }

    public List<User> getAll() {
        // TODO Auto-generated method stub
        return this.getUr().findAll();
    }

}
