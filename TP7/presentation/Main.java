package com.ilyaselmabrouki.tp8.presentation;

import com.ilyaselmabrouki.tp8.dao.ProductDaoImpl;
import com.ilyaselmabrouki.tp8.dao.entities.Product;
import com.ilyaselmabrouki.tp8.service.IServiceProductImpl;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        IServiceProductImpl pi = new IServiceProductImpl(new ProductDaoImpl());

        Product p = new Product();
        p.setName("LENOVO");
        p.setPrice(4500.0);
        p.setQuantity(10);

        //Add Product
        pi.addProduct(p);

        //Delete Product
        pi.deleteProductById(5);

        //Get Product
        Product p1 = pi.getProductById(6);
        System.out.println(p1);

        //Get All Products
        ArrayList<Product> Products = (ArrayList<Product>) pi.getAllProducts();
        for (Product p2:Products) {
            System.out.println(p2);
        }

        // Search Products
        ArrayList<Product> searchedProducts = (ArrayList<Product>) pi.searchProductByQuery("L");
        for (Product p3:searchedProducts) {
            System.out.println(p3);
        }
    }
}