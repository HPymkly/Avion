package com.main.demo.authentification.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.main.demo.authentification.model.User;

public interface UserRepos extends JpaRepository<User, Integer> {

    @Query(value = "select * from users where email= :email and password = :mdp", nativeQuery = true)
    public List<User> login(@Param(value = "email") String email, @Param(value = "mdp") String mdp);
}
