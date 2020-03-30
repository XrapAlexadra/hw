package com.gmail.xrapalexandra.web;

import com.gmail.xrapalexandra.model.User;
import com.gmail.xrapalexandra.service.UserService;
import com.gmail.xrapalexandra.service.impl.UserServiceImpl;
import com.gmail.xrapalexandra.web.utils.Utils;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

    private UserService userService = UserServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        Object user = req.getSession().getAttribute("user");
        if (user == null)
            Utils.forward("login", req, resp);
        else
            Utils.forward("index", req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String login = req.getParameter("login");
        String pass = req.getParameter("pass");
        User user = userService.login(login, pass);
        if (user == null){
            req.setAttribute("error", "Неправильный логин или пароль!");
            Utils.forward("pages/login", req, resp);
        }
        else {
            req.getSession().setAttribute("user", user);
            Utils.forward("index", req, resp);
        }
    }
}
