package com.dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String DB_DRIVER="org.h2.Driver";
    private static final String DB_URL="jdbc:h2:D:\\Учеба\\программирование\\Java_projects\\AccountingSystem\\repository";
    private static final String DB_USERNAME="";
    private static final String DB_PASSWORD="";

    public Connection getConnection(){
        Connection connection=null;
        try{
            Class.forName(DB_DRIVER);
            connection=DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
            System.out.println("Get connection");
        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
            System.err.println("Connection error");
        }
        return connection;
    }
}
