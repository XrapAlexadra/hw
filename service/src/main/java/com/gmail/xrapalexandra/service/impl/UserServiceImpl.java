package com.gmail.xrapalexandra.service.impl;


import com.gmail.xrapalexandra.service.UserService;
import com.gmail.xrapalexandra.dao.AuthUser;
import com.gmail.xrapalexandra.model.User;
import com.gmail.xrapalexandra.dao.impl.AuthUserImpl;

public class UserServiceImpl implements UserService {

    private AuthUser authUser = AuthUserImpl.getInstance();

    private UserServiceImpl() {
    }

    private static UserService instance;

    public static UserService getInstance(){
        UserService localInstance = instance;
        if (localInstance == null){
            synchronized (UserService.class){
                localInstance = instance;
                if ( localInstance == null)
                    localInstance = instance = new UserServiceImpl();
            }
        }
        return localInstance;
    }

    @Override
    public void saveUserInRepository(User user) {
        authUser.saveUser(user);
    }

    @Override
    public User login(String login, String pass) {
        User user = authUser.getByLogin(login);
        if (user == null)
           return null;
        if (user.getPass().equals(pass))
            return user;
        return null;
    }

    @Override
    public boolean isAlreadyExists(String login) {
        return authUser.getByLogin(login) != null;
    }

    @Override
    public User getUserByLogin(String login) {
        return authUser.getByLogin(login);
    }

    @Override
    public User delUserFromRepository(String login) {
        return authUser.delUserByLogin(login);
    }

    private void NothingToDo(){

    }
}
