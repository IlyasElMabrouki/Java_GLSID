package com.ilyaselmabrouki.tp8.dao;

import com.ilyaselmabrouki.tp8.dao.entities.Product;
import java.util.List;

public interface ProductDao extends DAO<Product, Integer> {
    List<Product> searchProductByQuery(String query);
}
