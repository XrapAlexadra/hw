package com.gmail.xrapalexandra.service.impl;

import com.gmail.xrapalexandra.model.Role;
import com.gmail.xrapalexandra.model.User;
import com.gmail.xrapalexandra.service.UserService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    private static UserService userService;


    @BeforeAll
    public static void iniTest() {
        userService = UserServiceImpl.getInstance();
        User user = new User("polot", Role.USER, "re123rt");
        userService.saveUserInRepository(user);
    }

    @Test
    void loginTestOne() {
        assertNull(userService.login("polot", "123456"));
    }
    @Test
    void loginTestTwo() {
        assertNotNull(userService.login("polot", "re123rt"));
    }
    @Test
    void loginTestThree() {
        assertNull(userService.login("userone", "12345"));
    }

    @Test
    void isAlreadyExists() {
    }

    @AfterAll
    public static void afterTest() {
        userService.delUserFromRepository("polot");
        userService = null;
    }
}
