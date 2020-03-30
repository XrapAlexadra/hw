package com.gmail.xrapalexandra.web;

import com.gmail.xrapalexandra.web.utils.Utils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FilterProductList implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        if(req.getSession().getAttribute("user") != null){
            filterChain.doFilter(servletRequest, servletResponse);
        }
        else {
            req.setAttribute("error", "Чтобы просмотреть список товаров, нужно сначала выполнить вход.");
            Utils.forward("pages/login", req, resp);
        }
    }
}
