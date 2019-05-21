package com.stackroute.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;


public class RowsetDemo {

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        //Creating and Executing RowSet
        JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();
        rowSet.setUrl("jdbc:mysql://localhost:3306/customerdb");
        rowSet.setUsername("root");
        rowSet.setPassword("Root@123");

        rowSet.setCommand("select * from customer");
        rowSet.execute();

        while (rowSet.next()) {
            // Generating cursor Moved event
            System.out.println("Id: " + rowSet.getInt(1));
            System.out.println("Name: " + rowSet.getString(2));
            System.out.println("Age: " + rowSet.getInt(3));
            System.out.println("Gender: " + rowSet.getString(4));

        }
    }
}