package com.gmail.xrapalexandra.dao;


import com.gmail.xrapalexandra.model.User;

public interface AuthUser {

    void saveUser(User user);

    User getByLogin(String login);

    User delUserByLogin(String login);
}
