package com.gmail.xrapalexandra.service.impl;

import com.gmail.xrapalexandra.model.Role;
import com.gmail.xrapalexandra.model.User;
import com.gmail.xrapalexandra.service.UserService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class getUserByLoginTest {
    private static UserService userService;

    @BeforeAll
    public static void iniTest() {
        userService = UserServiceImpl.getInstance();
        User user = new User("login", Role.USER, "12345");
        userService.saveUserInRepository(user);
    }

    @Test
    void getUserByLoginOne() {
        assertNotNull(userService.getUserByLogin("login"));
    }

    @Test
    void getUserByLoginTwo() {
        assertNull(userService.getUserByLogin("qwert"));
    }

    @Test
    void getUserByLoginThree() {
        assertNull(userService.getUserByLogin(""));
    }

    @AfterAll
    public static void afterTest() {
        userService.delUserFromRepository("login");
        userService = null;
    }
}
