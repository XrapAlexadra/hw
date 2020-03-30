package com.gmail.xrapalexandra.service.impl;

import com.gmail.xrapalexandra.model.Role;
import com.gmail.xrapalexandra.model.User;
import com.gmail.xrapalexandra.service.UserService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SaveUserInRepositoryTest {

    private static UserService userService;

    @BeforeAll
    public static void iniTest() {
        userService = UserServiceImpl.getInstance();
    }

    @Test
    void saveTestSimpleOne() {
        User user = new User("login", Role.USER, "12345");
        userService.saveUserInRepository(user);
        assertEquals(user, userService.getUserByLogin("login"));
    }

    @Test
    void saveTestSimpleTwo() {
        User user = new User("qwerty",Role.ADMIN, "jdhgjf");
        userService.saveUserInRepository(user);
        assertEquals(user, userService.getUserByLogin("qwerty"));
    }
    @Test
    void saveTestSimpleThree() {
        User user = new User("123456",Role.USER, "kjgjhkj");
        userService.saveUserInRepository(user);
        assertEquals(user, userService.getUserByLogin("123456"));
    }
    @Test
    void saveTestSimpleFour() {
        User user = new User("Qazxcv",Role.ADMIN, "polo546");
        userService.saveUserInRepository(user);
        assertEquals(user, userService.getUserByLogin("Qazxcv"));
    }

    @AfterAll
    public static void afterTest() {
        userService.delUserFromRepository("Qazxcv");
        userService.delUserFromRepository("123456");
        userService.delUserFromRepository("qwerty");
        userService.delUserFromRepository("login");
        userService = null;
    }
}