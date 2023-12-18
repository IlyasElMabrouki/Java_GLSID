package com.ilyaselmabrouki.tp10.dao;

import com.ilyaselmabrouki.tp10.dao.entities.Product;

import java.util.List;

public interface ProductDao extends DAO<Product, Integer> {
    List<Product> searchProductByQuery(String query);
}
