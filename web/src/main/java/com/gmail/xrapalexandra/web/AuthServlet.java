package com.gmail.xrapalexandra.web;


import com.gmail.xrapalexandra.model.Role;
import com.gmail.xrapalexandra.model.User;
import com.gmail.xrapalexandra.service.UserService;
import com.gmail.xrapalexandra.service.impl.UserServiceImpl;
import com.gmail.xrapalexandra.web.utils.Utils;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthServlet extends HttpServlet {

    private UserService userService = UserServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        Utils.forward("index", req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String login = req.getParameter("login");
        User user = new User(login, Role.USER, req.getParameter("pass"));
        if (userService.isAlreadyExists(login)) {
            req.setAttribute("alreadyexsist", login);
            Utils.forward("pages/auth", req, resp);
        } else {
            userService.saveUserInRepository(user);
            req.getSession().setAttribute("user", user);
            Utils.forward("index", req, resp);
        }
    }
}
