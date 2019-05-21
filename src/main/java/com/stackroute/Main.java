package com.stackroute;

import com.stackroute.db.*;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        CrudOperation crudOperation = new CrudOperation();
        crudOperation.displayData();
        crudOperation.displayCustomrerByName("mano","male");
        System.out.println("\n");
        ResultsetMetadataDemo resultSetMetaDataDemo=new ResultsetMetadataDemo();
        resultSetMetaDataDemo.resultMeta();
        System.out.println("\n");
        JDBCBatchProcessingDemo jdbcBatchProcessingDemo=new JDBCBatchProcessingDemo();
        jdbcBatchProcessingDemo.batchProcess();
        System.out.println("\n");
        JDBCTranscationDemo jdbcTransactionDemo=new JDBCTranscationDemo();
        jdbcTransactionDemo.transcationProcess();
        System.out.println("\n");
        DatabaseMetadataDemo databaseMetaDataDemo=new DatabaseMetadataDemo();
        databaseMetaDataDemo.databaseMetaData();
    }
}
