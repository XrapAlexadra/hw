package com.gmail.xrapalexandra.service.impl;

import com.gmail.xrapalexandra.dao.ProductList;
import com.gmail.xrapalexandra.dao.impl.ProductListImpl;
import com.gmail.xrapalexandra.model.Product;
import com.gmail.xrapalexandra.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    private ProductList productList = ProductListImpl.getInstance();

    private ProductServiceImpl() {
    }

    private static ProductService instance;

    public static ProductService getInstance() {
        ProductService localInstance = instance;
        if (localInstance == null) {
            synchronized (ProductService.class) {
                localInstance = instance;
                if (localInstance == null)
                    localInstance = instance = new ProductServiceImpl();
            }
        }
        return localInstance;
    }

    @Override
    public List<Product> getProductList() {
        return productList.getProductList();
    }

    @Override
    public void addProduct(Product product) {
        productList.addProduct(product);
    }
}
