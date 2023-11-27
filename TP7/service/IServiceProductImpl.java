package com.ilyaselmabrouki.tp8.service;

import com.ilyaselmabrouki.tp8.dao.ProductDaoImpl;
import com.ilyaselmabrouki.tp8.dao.entities.Product;

import java.util.List;

public class IServiceProductImpl implements IProductService{
    ProductDaoImpl productDao;
    public IServiceProductImpl(ProductDaoImpl productDao) {
        this.productDao = productDao;
    }
    @Override
    public void addProduct(Product p) {
        this.productDao.save(p);
    }
    @Override
    public void deleteProductById(Integer id) {
        this.productDao.removeById(id);
    }
    @Override
    public List<Product> getAllProducts() {
        return this.productDao.getAll();
    }
    @Override
    public Product getProductById(Integer id) {
        return this.productDao.getById(id);
    }

    @Override
    public List<Product> searchProductByQuery(String query) {
        return this.productDao.searchProductByQuery(query);
    }
}
