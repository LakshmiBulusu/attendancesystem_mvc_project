package com.github.perscholas.dao;


import com.github.perscholas.DatabaseConnection;
import com.github.perscholas.JdbcConfigurator;
import com.github.perscholas.model.StudentDetails;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDetailsDAO {

    private final DatabaseConnection dbc;

    public StudentDetailsDAO(DatabaseConnection dbc) {

        this.dbc = dbc;
    }

    public StudentDetailsDAO() {

        this(DatabaseConnection.ATTENDANCE_SYSTEM);
    }

    public List<StudentDetails> getStudentDetails() {

        List listStudent = null;

        try{
            JdbcConfigurator.initialize();
            System.out.println("Im'm StudentDetailsDAO getStudentDetails");
            Connection con  = dbc.getDatabaseConnection();
            String selectSQL="SELECT studentid,firstname,lastname,photoname,emergencycontact FROM attendance_system.studentdetails;";
            Statement insertAccount = con.createStatement();
            ResultSet resultSet=insertAccount.executeQuery(selectSQL);
                if (resultSet != null) {
                    listStudent = new ArrayList();
                    while (resultSet.next()) {
                        StudentDetails student = new StudentDetails();
                        int studentId = resultSet.getInt(1);
                        String firstName = resultSet.getString(2);
                        String lastName = resultSet.getString(3);
                        String photoName = resultSet.getString(4);
                        String emergencycontact = resultSet.getString(5);
                        student.setStudentid(studentId);
                        student.setFirstname(firstName);
                        student.setLastname(lastName);
                        student.setPhotoname(photoName);
                        student.setEmergencycontact(emergencycontact);
                        //System.out.println(student.toString());
                        listStudent.add(student);
                    }
               }
            }catch(SQLException e){
            e.printStackTrace();
            throw new Error(e);
        }finally{
            //   con.close();

        }
        return listStudent;
    }

    public void updateStudentdetails(StudentDetails studentDetails) {
        try{
            JdbcConfigurator.initialize();
            System.out.println("Im'm Account Information Dao"+studentDetails.toString());
            Connection con  = dbc.getDatabaseConnection();
            String updateSQL
                    ="UPDATE  attendance_system.studentdetails SET address =?,emergencycontact =?,parentemailid =?," +
                    "updatedby =?,updateddate =? WHERE studentid =?";
            PreparedStatement udpateStudentdetails = con.prepareStatement(updateSQL);
            udpateStudentdetails.setString(1,studentDetails.getAddress());
            udpateStudentdetails.setString(2,studentDetails.getEmergencycontact());
            udpateStudentdetails.setString(3,studentDetails.getParentemailid());
            udpateStudentdetails.setString(4,String.valueOf(studentDetails.getStudentid()));
            udpateStudentdetails.setDate(5,new java.sql.Date(System.currentTimeMillis()));
            udpateStudentdetails.setInt(6,studentDetails.getStudentid());
            udpateStudentdetails.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
            throw new Error(e);
        }finally{
            //   con.close();

        }
    }



}
