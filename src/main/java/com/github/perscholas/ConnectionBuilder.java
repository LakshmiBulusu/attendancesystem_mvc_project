package com.github.perscholas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by leon on 3/13/18.
 */
public class ConnectionBuilder {
    private Integer portNumber;
    private String userName;
    private String userPass;
    private String databaseVendor;
    private String hostName;
    private String databaseName;

    public ConnectionBuilder setPort(Integer portNumber) {
        this.portNumber = portNumber;
        return this;
    }


    public ConnectionBuilder setDatabaseVendor(String databaseVendor) {
        this.databaseVendor = databaseVendor;
        return this;
    }


    public ConnectionBuilder setHost(String hostName) {
        this.hostName = hostName;
        return this;
    }


    public ConnectionBuilder setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
        return this;
    }


    public ConnectionBuilder setUser(String userName) {
        this.userName = userName;
        return this;
    }


    public ConnectionBuilder setPassword(String userPass) {
        this.userPass = userPass;
        return this;
    }


    public Connection build() {
        String jdbcUrl = this.toString();
        jdbcUrl="jdbc:mysql://localhost:3306/mysql";
        try {
            System.out.println("JDBC URL "+jdbcUrl);
            System.out.println("USer Name "+this.userName);
            System.out.println("Password "+this.userPass);
            //return DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306//attendance_system?user=root&password=maria");
            return DriverManager.getConnection(jdbcUrl, this.userName, this.userPass);
        } catch (SQLException e) {
            String errorMessage = String.format("Failed to connect to `%s`", jdbcUrl);
            throw new Error(errorMessage, e);
        }
    }

    @Override
    public String toString() {
        Boolean isHostNull = this.hostName == null;
        Boolean isPortNull = portNumber == null;
        Boolean hasPortBeenSet = !isPortNull && !Integer.valueOf(3306).equals(portNumber);

        String jdbcUrl = new StringBuilder()
                .append("jdbc:")
                .append(this.databaseVendor != null ? this.databaseVendor : "")
                .append("://")
                .append(isHostNull ? "localhost" : "")
                .append(!isHostNull ? this.hostName : "")
                .append(hasPortBeenSet ? ":" : "")
                .append(hasPortBeenSet ? portNumber : "")
                .append("/")
                //.append(databaseName != null ? databaseName : "")
                .toString();
        return jdbcUrl;
    }
}