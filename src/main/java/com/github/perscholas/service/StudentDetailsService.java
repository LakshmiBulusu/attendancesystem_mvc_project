package com.github.perscholas.service;

import com.github.perscholas.dao.StudentDetailsDAO;
import com.github.perscholas.model.StudentDetails;

import java.util.List;


public class StudentDetailsService {

    StudentDetailsDAO studentDetailsDAO = new StudentDetailsDAO();

    public List<StudentDetails> getStudentDetails() {
        try{
            System.out.println("I'm StudentDetailsService...getStudentDetails");
            return studentDetailsDAO.getStudentDetails();
        }catch(Exception e){
            e.printStackTrace();
            throw new Error(e);
        }finally{
        }
    }


    public void updateStudentdetails(StudentDetails studentDetails) {
        try{
            System.out.println("I'm StudentDetailsService...updateStudentdetails");
            studentDetailsDAO.updateStudentdetails(studentDetails);
        }catch(Exception e){
            e.printStackTrace();
            throw new Error(e);
        }finally{
        }
    }

}
