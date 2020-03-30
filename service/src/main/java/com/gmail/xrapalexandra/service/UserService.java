package com.gmail.xrapalexandra.service;


import com.gmail.xrapalexandra.model.User;

public interface UserService {

    void saveUserInRepository(User user);

    User login(String login, String pass);

    boolean isAlreadyExists(String login);

    User getUserByLogin(String login);

    User delUserFromRepository(String login);

}
