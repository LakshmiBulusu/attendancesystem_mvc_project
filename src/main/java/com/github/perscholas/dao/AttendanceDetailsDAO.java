package com.github.perscholas.dao;

import com.github.perscholas.DatabaseConnection;
import com.github.perscholas.JdbcConfigurator;
import com.github.perscholas.model.AttendanceDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Iterator;
import java.util.List;


public class AttendanceDetailsDAO {

    private final DatabaseConnection dbc;

    public AttendanceDetailsDAO(DatabaseConnection dbc) {

        this.dbc = dbc;
    }

    public AttendanceDetailsDAO() {

        this(DatabaseConnection.ATTENDANCE_SYSTEM);
    }

    public void createAttendanceDetails(List<AttendanceDetails> attendanceDetailsList) {
        try{
            System.out.println("Im' AttendanceDetailsDAO"+attendanceDetailsList.size());
            JdbcConfigurator.initialize();
            Connection con  = dbc.getDatabaseConnection();
            Iterator<AttendanceDetails> iterator = attendanceDetailsList.iterator();
            while(iterator.hasNext())
            {
                AttendanceDetails attendanceDetails = iterator.next();
                System.out.println("Attendance Details"+attendanceDetails.toString());
                String insertSQL =
                        "INSERT INTO attendance_system.attendancedetails " +
                                "(`studentid`, `teacherid`, `attendancedate`, `is_present`, `createdby`, `createdate`) VALUES (?,?,?,?,?,?);";
                PreparedStatement insertAccount = con.prepareStatement(insertSQL);
                insertAccount.setInt(1, attendanceDetails.getStudenid().intValue());
                insertAccount.setString(2, attendanceDetails.getTeacherid());
                insertAccount.setDate(3, new java.sql.Date(System.currentTimeMillis()));
                insertAccount.setBoolean(4, true);
                insertAccount.setString(5, attendanceDetails.getTeacherid());
                insertAccount.setDate(6, new java.sql.Date(System.currentTimeMillis()));
                insertAccount.executeUpdate();
            }

        }catch(Exception e){
            e.printStackTrace();
            throw new Error(e);
        }finally{
            //   con.close();

        }
    }

}