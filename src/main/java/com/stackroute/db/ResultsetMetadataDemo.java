package com.stackroute.db;

import java.sql.*;
public class ResultsetMetadataDemo{
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String dburl = "jdbc:mysql://localhost/customerdb";
    static final String dbuser = "root";
    static final String dbpass = "Root@123";

    public void resultMeta(){
        Connection con = null;
        Statement stmt = null;

        try
        {
            //Step 1 : Connecting to server and database
            con = DriverManager.getConnection(dburl, dbuser, dbpass);
            //Step 2 : Initialize Statement
            stmt=con.createStatement();
            //Step 3 : Initialize ResultSet
            ResultSet rset=stmt.executeQuery("select *from customer");

            //Step 4 : ResultSetMetaData
            ResultSetMetaData rsmeta =(ResultSetMetaData) rset.getMetaData();

            System.out.println("Total Column : " + rsmeta.getColumnCount());
            System.out.println("First Column Name : " + rsmeta.getColumnName(1));
            System.out.println("First Column Type : " + rsmeta.getColumnTypeName(1));
            System.out.println("First Table Name : " + rsmeta.getTableName(1));
        }

        catch (SQLException e)
        {
            System.err.println("Cannot connect ! ");
            e.printStackTrace();
        }

        finally {
            System.out.println("Closing the connection.");
            if (con != null) try { con.close(); } catch (SQLException ignore) {}
        }

    }}