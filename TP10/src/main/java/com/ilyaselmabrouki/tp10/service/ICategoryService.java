package com.ilyaselmabrouki.tp10.service;

import com.ilyaselmabrouki.tp10.dao.entities.Category;

import java.util.List;

public interface ICategoryService {
    void addCategory(Category p);
    void deleteCategoryById(Integer id);
    List<Category> getAllCategory();
    Category getCategoryById(Integer id);
    Category getCategoryByName(String name);
}
