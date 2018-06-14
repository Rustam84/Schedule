package com.springapp.mvc.dao;

import com.springapp.mvc.database.User;

import java.util.Optional;

public interface UserDAO {
    public Optional<User> getUserByName(String username);
}
