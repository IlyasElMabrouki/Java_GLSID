package com.ilyaselmabrouki.tp10.dao;

import com.ilyaselmabrouki.tp10.dao.entities.Category;
import com.ilyaselmabrouki.tp10.dao.entities.Product;

import java.util.List;

public interface CategoryDao extends DAO<Category, Integer> {
    Category getCategoryByName(String name);
}
