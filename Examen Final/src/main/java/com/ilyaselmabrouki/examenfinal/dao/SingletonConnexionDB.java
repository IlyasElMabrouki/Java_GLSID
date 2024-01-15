package com.ilyaselmabrouki.examenfinal.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingletonConnexionDB {
    private static Connection con;
    private static SingletonConnexionDB c;

    private SingletonConnexionDB(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_entreprise","root","ilyas-2002");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnexion(){
        if (c == null) c = new SingletonConnexionDB();
        return con;
    }
}