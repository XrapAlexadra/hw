package com.gmail.xrapalexandra.web;

import com.gmail.xrapalexandra.model.Product;
import com.gmail.xrapalexandra.service.ProductService;
import com.gmail.xrapalexandra.service.impl.ProductServiceImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddProductServlet extends HttpServlet {

    private ProductService productService = ProductServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Product product = new Product();
        product.setName(req.getParameter("name"));
        product.setPrice(Integer.parseInt(req.getParameter("price")));
        product.setQuantity(Integer.parseInt(req.getParameter("quantity")));

        productService.addProduct(product);

        resp.sendRedirect("/web/productlist");

    }
}
