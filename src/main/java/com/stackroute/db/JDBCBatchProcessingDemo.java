package com.stackroute.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCBatchProcessingDemo {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String dburl = "jdbc:mysql://localhost/customerdb";
    static final String dbuser = "root";
    static final String dbpass = "Root@123";

    public void batchProcess() throws SQLException
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
            String query1="insert into customer(NAME,GENDER) VALUES('MALAR','FEMALE')";
            String query2="insert into customer(NAME,GENDER) VALUES('RAMESH','MALE')";


            //Step 4 : Adding query to Batch
            stmt.addBatch(query1);
            stmt.addBatch(query2);


            //Step 5 : Execute Batch
            stmt.executeBatch();

            con.commit();
            System.out.println("Batch Update Successful");

        }

        catch (SQLException e)
        {
            System.err.println("Cannot connect ! ");
            con.rollback();
            e.printStackTrace();
        }

        finally {
            System.out.println("Closing the connection.");
            if (con != null) try { con.close(); } catch (SQLException ignore) {}
        }

    }

}