package com.gmail.xrapalexandra.dao.impl;

import com.gmail.xrapalexandra.dao.AuthUser;
import com.gmail.xrapalexandra.model.Role;
import com.gmail.xrapalexandra.model.User;
import java.util.HashMap;
import java.util.Map;


public class AuthUserImpl implements AuthUser {

    Map<String, User> users = new HashMap<>();

    private AuthUserImpl() {
        this.users.putIfAbsent("admin", new User("admin", Role.ADMIN, "admin"));
        this.users.putIfAbsent("userpass", new User("userpass", Role.USER, "userlog"));
    }

    private static volatile AuthUser instance;

    public static AuthUser getInstance() {
        AuthUser localInstance = instance;
        if (localInstance == null) {
            synchronized (AuthUser.class) {
                localInstance = instance;
                if (localInstance == null) localInstance = instance = new AuthUserImpl();
            }
        }
        return localInstance;
    }

    @Override
    public void saveUser(User user) {
        users.putIfAbsent(user.getLogin(), user);
    }

    @Override
    public User getByLogin(String login) {
        return users.get(login);
    }

    @Override
    public User delUserByLogin(String login) {
        User user = users.get(login);
        if (user != null)
            users.remove(login);
        return user;
    }
}
