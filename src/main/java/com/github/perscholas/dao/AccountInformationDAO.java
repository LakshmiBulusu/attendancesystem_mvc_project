package com.github.perscholas.dao;

import com.github.perscholas.DatabaseConnection;
import com.github.perscholas.JdbcConfigurator;
import com.github.perscholas.model.AccountInformation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class AccountInformationDAO {

    private final DatabaseConnection dbc;

    public AccountInformationDAO(DatabaseConnection dbc) {

        this.dbc = dbc;
    }

    public AccountInformationDAO() {

        this(DatabaseConnection.ATTENDANCE_SYSTEM);
    }

    public void createAccountInformation(AccountInformation accountInformation) {
        try{
            JdbcConfigurator.initialize();
            System.out.println("Im'm Account Information Dao"+accountInformation.toString());
            Connection con  = dbc.getDatabaseConnection();
            String insertSQL="insert into attendance_system.accountinformation (username, PASSWORD, lastlogindate) values (?, ?,?)";
            PreparedStatement insertAccount = con.prepareStatement(insertSQL);
            insertAccount.setString(1,accountInformation.getUsername());
            insertAccount.setString(2,accountInformation.getPassword());
            insertAccount.setDate(3, new java.sql.Date(System.currentTimeMillis()));
            insertAccount.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
            throw new Error(e);
        }finally{
            //TBD Need to close connection/result set

        }
    }

    public boolean isValidLogin(AccountInformation accountInformation) {

        try{
            JdbcConfigurator.initialize();
            System.out.println("I'm  Account Information Dao"+accountInformation.toString());
            Connection con  = dbc.getDatabaseConnection();
            String selectSQL="select lastlogindate from attendance_system.accountinformation where username=? and password=?";
            PreparedStatement insertAccount = con.prepareStatement(selectSQL);
            insertAccount.setString(1,accountInformation.getUsername());
            insertAccount.setString(2,accountInformation.getPassword());
            ResultSet resultSet=insertAccount.executeQuery();
            if (resultSet != null) {
                while(resultSet.next()){
                    String lastLogindate= resultSet.getString(1);
                    accountInformation.setLastloginDate(lastLogindate);
                     return true;
                }
            }
            return false;
        }catch(Exception e){
            e.printStackTrace();
            throw new Error(e);
        }finally{
             //TBD Need to close connection/result set
        }
    }
}