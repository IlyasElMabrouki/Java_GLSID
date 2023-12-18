package com.ilyaselmabrouki.tp10.dao;

import com.ilyaselmabrouki.tp10.dao.entities.Category;
import com.ilyaselmabrouki.tp10.dao.entities.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao{
    @Override
    public void save(Category o) {
        try {
            PreparedStatement pstm = DBConnection.getConnection().prepareStatement(
                    "Insert into Category (name) values (?)");
            pstm.setString(1,o.getName());
            pstm.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void removeById(Integer id) {

    }

    @Override
    public Category getById(Integer id) {
        return null;
    }

    @Override
    public List<Category> getAll() {
        ArrayList<Category> categories = new ArrayList<>();
        try {
            Statement stm = DBConnection.getConnection().createStatement();
            ResultSet rs = stm.executeQuery("Select * from Category");
            while(rs.next()){
                Category c = new Category();
                c.setId(rs.getInt(1));
                c.setName(rs.getString(2));
                categories.add(c);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public Category getCategoryByName(String name) {
        Category c = new Category();
        try {
            PreparedStatement pstm = DBConnection.getConnection().prepareStatement("Select * from Category where name = ?");
            pstm.setString(1,name);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                c.setId(rs.getInt(1));
                c.setName(rs.getString(2));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return c;
    }
}
