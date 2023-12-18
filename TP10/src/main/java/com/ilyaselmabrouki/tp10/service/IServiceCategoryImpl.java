package com.ilyaselmabrouki.tp10.service;

import com.ilyaselmabrouki.tp10.dao.CategoryDaoImpl;
import com.ilyaselmabrouki.tp10.dao.ProductDaoImpl;
import com.ilyaselmabrouki.tp10.dao.entities.Category;

import java.util.List;

public class IServiceCategoryImpl implements ICategoryService{

    private CategoryDaoImpl categoryDao;

    public IServiceCategoryImpl(CategoryDaoImpl categoryDao) {
        this.categoryDao = categoryDao;
    }
    @Override
    public void addCategory(Category p) {
        this.categoryDao.save(p);
    }

    @Override
    public void deleteCategoryById(Integer id) {
        this.categoryDao.removeById(id);
    }

    @Override
    public List<Category> getAllCategory() {
        return this.categoryDao.getAll();
    }

    @Override
    public Category getCategoryById(Integer id) {
        return this.categoryDao.getById(id);
    }

    @Override
    public Category getCategoryByName(String name) {
        return this.categoryDao.getCategoryByName(name);
    }
}
