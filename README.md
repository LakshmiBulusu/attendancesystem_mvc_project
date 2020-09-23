# Welcome to Class room Attendance System Project  #

Thanks to perscholas for giving me this opportunity.This was a great learning experience  to me  taught by my instructors Leon,Haseeb regarding the in-depth java programming knowledge.Thanks to their continuous support in training as a full-stack java software developer.

## ***Project Objective:*** ##

-  Teacher can track the presence of a student by taking attendance and mark him in the school records. 
-  Teacher/Student can create personal account to access this application at any time.
-  Student can login and update personal details along with parent email ID.

### ***User Stories*** ###

User stories are created in [Trello](https://trello.com/en-US). You have to create an account in Trello.com to access user stories and access to project in Trello. You can access [wireframes](https://github.com/LakshmiBulusu/attendancesystem_mvc_project/blob/master/classroomattendancesystem-wireframes.pdf).

#### ***Usecase Diagram:***  ####
![Usecase diagram](https://github.com/LakshmiBulusu/attendancesystem_mvc_project/blob/master/Usecase.jpg)

 
#### ***Technologies used:*** ####

This project is developed based on MVC architecture and Java/J2EE. 

- Frontend: HTML5/CSS/JS
- Controllers:Servlets 
- Model:POJO objects
- DB: Maria DB- MySQL
- Web/Application Server: Tomcat
- Design/IDE Tools:
	- Intellij IDEA for Java development
	- Lucidchart/Balsamiq for wireframes/use-case diagram
	- Trello for userstories
	- HeidiSQL - MySQL DB

	#### ***Sequence Diagram for one sample flow (Attendance)*** ####
![Sequence diagram](https://github.com/LakshmiBulusu/attendancesystem_mvc_project/blob/master/SampleSequence(Attendance).png)


	#### Database Entity Relationship Diagram ####
![Database diagram](https://github.com/LakshmiBulusu/attendancesystem_mvc_project/blob/master/attendancesystem_ERDiagram.PNG)

###   ***How to download and run this application:*** 

####  Part 1 - Clone the project ####
* Begin by _forking_ this project into a personal repository.
   * To do this, click the `Fork` button located at the top right of this page.
* Navigate to your github profile to find the _newly forked repository_.
* Clone the repository from **your account** into the `~/dev` directory.
* Open the newly cloned project in a code editor (Intellij, for example).
* Create a Database "attendance_system" using SQL in "\dev\attendancesystem_mvc_project\src\main\resources\createdatabase-attedancesystem.sql" 
* Create Tables using SQL in "\dev\attendancesystem_mvc_project\src\main\resources\createtable-attedancesystem.sql"  

####  Part 2 - Run the project ####
* The project/module name is defined as 'attendancesystem'.
* Begin building the project/module based on code editor(ex: Build module 'attendancesystem' project in Intellij)
* Check your JDK version is same as in .pom.xml. If you have different version then    update JDK version in pom.xml.
* RunTomcat :run application
* Access application:http://localhost:8080/classattendance/
 

*********************************************

