package com.ilyaselmabrouki.tp8.dao;

import com.ilyaselmabrouki.tp8.dao.entities.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao{
    @Override
    public void save(Product o) {
        try {
            PreparedStatement pstm = DBConnection.getConnection().prepareStatement(
                    "Insert into Product (name,price,quantity) values (?,?,?)");
            pstm.setString(1,o.getName());
            pstm.setDouble(2,o.getPrice());
            pstm.setInt(3,o.getQuantity());
            pstm.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void removeById(Integer id) {
        try {
            PreparedStatement pstm = DBConnection.getConnection().prepareStatement("Delete from Product where id = ?");
            pstm.setInt(1,id);
            pstm.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Product getById(Integer id) {
        Product p = new Product();
        try {
            PreparedStatement pstm = DBConnection.getConnection().prepareStatement("Select * from Product where id = ?");
            pstm.setInt(1,id);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                p.setId(rs.getInt(1));
                p.setName(rs.getString(2));
                p.setPrice(rs.getDouble(3));
                p.setQuantity(rs.getInt(4));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return p;
    }

    @Override
    public List<Product> getAll() {
        ArrayList<Product> products = new ArrayList<>();
        try {
            Statement stm = DBConnection.getConnection().createStatement();
            ResultSet rs = stm.executeQuery("Select * from Product");
            while(rs.next()){
                Product p = new Product();
                p.setId(rs.getInt(1));
                p.setName(rs.getString(2));
                p.setPrice(rs.getDouble(3));
                p.setQuantity(rs.getInt(4));
                products.add(p);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return products;
    }
    @Override
    public List<Product> searchProductByQuery(String query) {
        ArrayList<Product> products = new ArrayList<>();
        try {
            PreparedStatement pstm = DBConnection.getConnection().prepareStatement(
                    "Select * from Product where name like ?");
            pstm.setString(1,'%' + query + '%');
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                Product p = new Product();
                p.setId(rs.getInt(1));
                p.setName(rs.getString(2));
                p.setPrice(rs.getDouble(3));
                p.setQuantity(rs.getInt(4));
                products.add(p);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return products;
    }
}
