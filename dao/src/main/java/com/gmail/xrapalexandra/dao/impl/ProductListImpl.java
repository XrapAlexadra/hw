package com.gmail.xrapalexandra.dao.impl;

import com.gmail.xrapalexandra.dao.ProductList;
import com.gmail.xrapalexandra.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductListImpl implements ProductList {

    private List<Product> products = new ArrayList<>();

    private ProductListImpl() {
        products.add(new Product("Item1", 3, 2));
        products.add(new Product("Item2", 2, 10));
        products.add(new Product("Item3", 1, 23));
        products.add(new Product("Item4", 7, 15));
        products.add(new Product("Item5", 4, 6));
        products.add(new Product("Item6", 6, 1));
    }

    private static volatile ProductList instance;

    public static ProductList getInstance(){
        ProductList localInstance = instance;
        if(localInstance ==null){
            synchronized (ProductList.class){
                localInstance = instance;
                if(localInstance == null)
                    instance=localInstance= new ProductListImpl();

            }
        }
        return localInstance;
    }
    @Override
    public void addProduct(Product product) {
        int indexOfProduct = products.indexOf(product);
        if(indexOfProduct < 0)
            products.add(product);
        else {
            int allQuantity = products.get(indexOfProduct).getQuantity() + product.getQuantity();
            products.get(indexOfProduct).setQuantity(allQuantity);
        }
    }

    @Override
    public boolean isProductAlreadyExsist(Product product) {
        return false;
    }

    @Override
    public List<Product> getProductList() {
        return products;
    }
}
