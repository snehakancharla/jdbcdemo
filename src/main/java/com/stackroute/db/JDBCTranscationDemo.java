package com.stackroute.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTranscationDemo {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String dburl = "jdbc:mysql://localhost/customerdb";
    static final String dbuser = "root";
    static final String dbpass = "Root@123";

    public  void transcationProcess()throws SQLException
    {
        Connection con = null;
        Statement stmt = null;

        try
        {
            //Step 1 : Connecting to server and database
            con = DriverManager.getConnection(dburl, dbuser, dbpass);
            con.setAutoCommit(false);
            //Step 2 : Initialize Statement
            stmt=con.createStatement();
            //Step 3 : SQL Query
            String query1="insert into customer(name,gender) VALUES('oliver','male')";
            String query2="insert into  customer(name,gender) VALUES('liily','female')";

            stmt.executeUpdate(query1);
            stmt.executeUpdate(query2);
            //If you run this program without con.commit you will notice that there is no insert in table1 and table2
            con.commit();
            System.out.println("Row Inserted");

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

    }
}