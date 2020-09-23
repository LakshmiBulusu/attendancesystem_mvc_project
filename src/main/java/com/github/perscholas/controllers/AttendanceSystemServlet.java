package com.github.perscholas.controllers;

import com.github.perscholas.model.AccountInformation;
import com.github.perscholas.model.AttendanceDetails;
import com.github.perscholas.model.StudentDetails;
import com.github.perscholas.service.AccountService;
import com.github.perscholas.service.AttendanceDetailsService;
import com.github.perscholas.service.StudentDetailsService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/AttendanceSystemServlet")
public class AttendanceSystemServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("I'm in Init method");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("I'm in doGet method");
       // doPost(req,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response)
            throws ServletException, IOException {
        // Convert request to Java object
        System.out.println("I'm in doPost method");
        if(null!=req) {
            invokeBusinessService(req,response);
        }
    }

     public void invokeBusinessService(HttpServletRequest request,HttpServletResponse response)
             throws ServletException, IOException {

            String pagename= request.getParameter("pagename");
            System.out.println("The value of pagename   "+pagename);

           if ("teacherlogin".equals(pagename) || "studentlogin".equals(pagename)) {

               String userName = request.getParameter("username");
               String password = request.getParameter("password");
               System.out.println("I'm in Login " + userName + "    " + password);

               AccountInformation accountInformation = new AccountInformation();
               accountInformation.setUsername(userName);
               accountInformation.setPassword(password);

               //Calling AccountService
               AccountService service = new AccountService();
               boolean b = service.isValidLogin(accountInformation);

               System.out.println("The value of isValidLogin" + b);

               if (b && "teacherlogin".equals(pagename)) {
                   //Calling student details service
                   StudentDetailsService studentDetailsService = new StudentDetailsService();
                   List<StudentDetails> studentList = studentDetailsService.getStudentDetails();
                   System.out.println("Student List size" + studentList.size());
                   request.getSession(true).setAttribute("StudentList", studentList);
                   RequestDispatcher requestDispatcher = request.getRequestDispatcher("/attendance.jsp");
                   requestDispatcher.forward(request, response);
               } else if (b && "studentlogin".equals(pagename)) {
                   RequestDispatcher requestDispatcher = request.getRequestDispatcher("/studentdetails.jsp");
                   requestDispatcher.forward(request, response);
               } else if (!b) {
                   RequestDispatcher requestDispatcher = request.getRequestDispatcher("/loginfailure.jsp");
                   requestDispatcher.forward(request, response);
               }
           } else if ("accountcreation".equals(pagename)) {
               String userName = request.getParameter("username");
               String password = request.getParameter("password");
               System.out.println("I'm in AccountCreation " + userName + password);
               AccountInformation accountInformation = new AccountInformation();
               accountInformation.setUsername(userName);
               accountInformation.setPassword(password);

               //Calling AccountService
               AccountService service = new AccountService();
               service.createAccountInformation(accountInformation);
               RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.html");
               requestDispatcher.forward(request, response);

           } else if ("attendance".equals(pagename)) {
               String[] s = request.getParameterValues("checkedrows");
               if (s != null && s.length != 0) {
                   System.out.println("The Total student attended" + s.length);

                   //Calling AttendanceDetailsService
                   AttendanceDetailsService attendanceDetailsService = new AttendanceDetailsService();
                   List<AttendanceDetails> attendenanceDetailsList = new ArrayList();

                   for (int i = 0; i < s.length; i++) {
                       System.out.println("The student attended" + s[i]);
                       AttendanceDetails attendanceDetails = new AttendanceDetails();
                       attendanceDetails.setStudenid(Integer.valueOf(s[i]));
                       attendanceDetails.setTeacherid("5000");
                       attendenanceDetailsList.add(attendanceDetails);
                   }
                   attendanceDetailsService.createAttendanceDetails(attendenanceDetailsList);
                   RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.html");
                   requestDispatcher.forward(request, response);
               }else{
                   request.setAttribute("Message", "Please access again and select a student.");
                   RequestDispatcher requestDispatcher = request.getRequestDispatcher("/error.jsp");
                   requestDispatcher.forward(request, response);
               }
           } else if ("studentdetails".equals(pagename)) {
               String studentid = request.getParameter("studentid");
               String address = request.getParameter("address");
               String emergencycontact = request.getParameter("emergencycontact");
               String parentemailid = request.getParameter("parentemailid");
               System.out.println("I'm in Student Details " + studentid + " " + address + emergencycontact + parentemailid);

               StudentDetails studentDetails = new StudentDetails();
               studentDetails.setStudentid(Integer.parseInt(studentid));
               studentDetails.setAddress(address);
               studentDetails.setEmergencycontact(emergencycontact);
               studentDetails.setParentemailid(parentemailid);

               StudentDetailsService studentDetailsService = new StudentDetailsService();
               studentDetailsService.updateStudentdetails(studentDetails);
               RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.html");
               requestDispatcher.forward(request, response);

           }
       }
 }



