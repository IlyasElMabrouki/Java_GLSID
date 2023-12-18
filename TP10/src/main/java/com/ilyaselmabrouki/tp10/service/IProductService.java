package com.ilyaselmabrouki.tp10.service;

import com.ilyaselmabrouki.tp10.dao.entities.Product;

import java.util.List;

public interface IProductService {
    void addProduct(Product p);
    void deleteProductById(Integer id);
    List<Product> getAllProducts();
    Product getProductById(Integer id);
    List<Product> searchProductByQuery(String query);
}
