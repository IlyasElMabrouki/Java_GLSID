package com.ilyaselmabrouki.tp10.dao;

import com.ilyaselmabrouki.tp10.dao.entities.Category;
import com.ilyaselmabrouki.tp10.dao.entities.Product;

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
                    "Insert into Product (name,price,quantity, category) values (?,?,?,?)");
            pstm.setString(1,o.getName());
            pstm.setDouble(2,o.getPrice());
            pstm.setInt(3,o.getQuantity());
            pstm.setInt(4,o.getCategory().getId());
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

            PreparedStatement pstm1 = DBConnection.getConnection().prepareStatement("Delete from Category where id = ?");
            pstm1.setInt(1,this.getById(id).getId());

            pstm1.executeUpdate();
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
                PreparedStatement pstm = DBConnection.getConnection().prepareStatement(
                        "Select * from Category where id = ?");
                pstm.setInt(1,rs.getInt(5));
                ResultSet rs1 = pstm.executeQuery();
                Category c = new Category();
                if (rs1.next()){
                    c.setId(rs1.getInt(1));
                    c.setName(rs1.getString(2));
                }
                Product p = new Product();
                p.setId(rs.getInt(1));
                p.setName(rs.getString(2));
                p.setPrice(rs.getDouble(3));
                p.setQuantity(rs.getInt(4));
                p.setCategory(c);
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
                PreparedStatement pstm2 = DBConnection.getConnection().prepareStatement(
                        "Select * from Category where id = ?");
                pstm.setInt(1,rs.getInt(5));
                ResultSet rs1 = pstm2.executeQuery();
                Category c = new Category();
                if (rs1.next()){
                    c.setId(rs1.getInt(1));
                    c.setName(rs1.getString(2));
                }
                Product p = new Product();
                p.setId(rs.getInt(1));
                p.setName(rs.getString(2));
                p.setPrice(rs.getDouble(3));
                p.setQuantity(rs.getInt(4));
                p.setCategory(c);
                products.add(p);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return products;
    }
}
