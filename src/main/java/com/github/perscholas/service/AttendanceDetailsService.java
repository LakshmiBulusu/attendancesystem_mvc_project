package com.github.perscholas.service;

import com.github.perscholas.dao.AttendanceDetailsDAO;
import com.github.perscholas.model.AttendanceDetails;

import java.util.List;


public class AttendanceDetailsService {

    public void createAttendanceDetails(List<AttendanceDetails> attendanceDetailsList) {
        try{
            AttendanceDetailsDAO attendanceDetailsDAO = new AttendanceDetailsDAO();
            attendanceDetailsDAO.createAttendanceDetails(attendanceDetailsList);
        }catch(Exception e){
            e.printStackTrace();
            throw new Error(e);
        }finally{
        }
    }
}
