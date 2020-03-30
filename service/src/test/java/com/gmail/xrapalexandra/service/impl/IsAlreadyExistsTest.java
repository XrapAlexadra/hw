package com.gmail.xrapalexandra.service.impl;

import com.gmail.xrapalexandra.model.Role;
import com.gmail.xrapalexandra.model.User;
import com.gmail.xrapalexandra.service.UserService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class IsAlreadyExistsTest {

    private static UserService userService;

    @BeforeAll
    public static void iniTest() {
        userService = UserServiceImpl.getInstance();
        User user = new User("login", Role.USER, "12345");
        userService.saveUserInRepository(user);
    }

    @Test
    void isExsistsTestOne() {
        assertTrue(userService.isAlreadyExists("login"));
    }

    @Test
    void isExsistsTestTwo() {
        assertFalse(userService.isAlreadyExists("pololo"));
    }

    @Test
    void isExsistsTestThree() {
        assertFalse(userService.isAlreadyExists("asdfg"));
    }
    @AfterAll
    public static void afterTest() {
        userService.delUserFromRepository("polot");
        userService = null;
    }
}
