package com.github.perscholas;

import java.sql.Connection;

public interface DatabaseConnectionInterface {
    String getDatabaseName();
    Connection getDatabaseConnection();
    Connection getDatabaseEngineConnection();
   // void drop();
    //void create();
   // void use();
    //void executeStatement(String sqlStatement);
    //ResultSet executeQuery(String sqlQuery);
}