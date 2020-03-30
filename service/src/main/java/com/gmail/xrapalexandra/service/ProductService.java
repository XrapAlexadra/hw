package com.gmail.xrapalexandra.service;

import com.gmail.xrapalexandra.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProductList();

    void addProduct(Product product);
}
