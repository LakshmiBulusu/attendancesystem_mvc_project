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

    /**@Override
    public List<StudentInterface> getAllStudents() {
        ResultSet resultSet = null;
        List<StudentInterface> listStudent = null;
        try {
            resultSet = dbc.executeQuery("SELECT email,name,password FROM management_system.student");
            if (resultSet != null) {
                listStudent = new ArrayList<StudentInterface>();
                while(resultSet.next()){
                    String email= resultSet.getString(1);
                    String name= resultSet.getString(2);
                    String password= resultSet.getString(3);
                    StudentInterface student = new Student(email,name,password);
                    listStudent.add(student);
                }
            }

        } catch(Exception e) {
            e.printStackTrace();
            throw new Error(e);
        } finally{
            try{
                resultSet.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return listStudent;
    }

    @Override
    public StudentInterface getStudentByEmail(String studentEmail) {
        ResultSet resultSet =null;
        StudentInterface studentInterface = null;
        try {
            resultSet = dbc.executeQuery("SELECT name,password FROM management_system.student where email='"+studentEmail+"'");
            if (resultSet != null) {
                studentInterface = new Student();
                while(resultSet.next()){
                    studentInterface.setName(studentEmail);
                    studentInterface.setName(resultSet.getString(1));
                    studentInterface.setPassword(resultSet.getString(2));
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
            throw new Error(e);
        }
        finally{
            try{
                if(resultSet!=null){
                    resultSet.close();
                }

            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return studentInterface;
    }

    @Override
    public Boolean validateStudent(String studentEmail, String password) {
        Boolean isStudent = false;
        ResultSet resultSet = null;

        try{
            resultSet = dbc.executeQuery(
                    "SELECT name FROM management_system.student " +
                            "where email='"+studentEmail+"' and password='"+password+"'");
            if(resultSet!=null&&resultSet.isBeforeFirst()){
                isStudent =true;
            }
        }catch(Exception e){
            e.printStackTrace();
            throw new Error(e);
        }finally{
            try{
                if(resultSet!=null){
                    resultSet.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return isStudent;
    }

    @Override
    public void registerStudentToCourse(String studentEmail, int courseId) {
        try{
            String sql="insert into management_system.student_course (email, id) values ('"+studentEmail+"','"+courseId+"')";
            dbc.executeStatement(sql);
        }catch(Exception e){
            e.printStackTrace();
            throw new Error(e);
        }finally{
        }
    }

    @Override
    public List<CourseInterface> getStudentCourses(String studentEmail) {
        ResultSet resultSet = null;
        List<CourseInterface> listStudentCourse = null;
        try {
            resultSet = dbc.executeQuery("SELECT id FROM management_system.student_course where email='"+studentEmail+"'");
            if (resultSet != null) {
                listStudentCourse = new ArrayList<CourseInterface>();
                while(resultSet.next()){
                    Course course= getCourseDetailsByID(resultSet.getInt(1));
                    listStudentCourse.add(course);
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
            throw new Error(e);
        } finally{
            try{
                if(resultSet!=null) {
                    resultSet.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return listStudentCourse;
    }

    private Course getCourseDetailsByID(int courseID){
        ResultSet courseResultSet =null;
        Course course = null;
        try {
            courseResultSet = dbc.executeQuery(
                    "SELECT id,name,instructor FROM management_system.course where id='" + courseID + "'");
            if (courseResultSet != null) {
                //only one record exist as this is primary key
                while(courseResultSet.next()){
                    course= new Course(courseResultSet.getInt(1),
                            courseResultSet.getString(2),courseResultSet.getString(3));

                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(courseResultSet!=null) {
                    courseResultSet.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return course;
    } **/

}
