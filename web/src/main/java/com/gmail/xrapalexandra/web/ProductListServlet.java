package com.gmail.xrapalexandra.web;

import com.gmail.xrapalexandra.service.ProductService;
import com.gmail.xrapalexandra.service.impl.ProductServiceImpl;
import com.gmail.xrapalexandra.web.utils.Utils;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductListServlet extends HttpServlet {

    private ProductService productService = ProductServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("productlist", productService.getProductList());
        Utils.forward("pages/productlist", req, resp);

    }
}
