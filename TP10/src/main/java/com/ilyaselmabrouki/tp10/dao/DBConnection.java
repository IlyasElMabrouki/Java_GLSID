package com.ilyaselmabrouki.tp10.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static Connection con;
    private static DBConnection c;

    private DBConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DBCATALOG","root","ilyas-2002");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        if (c == null) c = new DBConnection();
        return con;
    }
}
