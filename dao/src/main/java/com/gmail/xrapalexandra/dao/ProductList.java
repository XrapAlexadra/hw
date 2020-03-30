package com.gmail.xrapalexandra.dao;

import com.gmail.xrapalexandra.model.Product;

import java.util.List;

public interface ProductList {

    void addProduct(Product product);

    boolean isProductAlreadyExsist(Product product);

    List<Product> getProductList();


}
