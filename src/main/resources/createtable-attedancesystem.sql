create table attendance_system.studentdetails
(
	studentid INT NOT NULL PRIMARY KEY,
	firstname varchar(50) NOT NULL,
	lastname varchar(50) NOT NULL,
	address varchar(1000) NOT NULL,
	emergencycontact varchar(50),
	parentemailid varchar(50),
	createdby varchar(50) NOT NULL,
	createdate DATETIME NOT NULL,
	updateddate DATETIME,
	updatedby varchar(50),
	photoname varchar(50)
);


create table attendance_system.teacherdetails
(
	teacherid varchar(50) NOT NULL PRIMARY KEY,
	firstname varchar(50) NOT NULL,
	lastname varchar(50) NOT NULL,
	emailid varchar(50),
	createdby varchar(50) NOT NULL,
	createdate DATETIME NOT NULL,
	updateddate DATETIME,
	updatedby varchar(50)
);


create table attendance_system.attendancedetails
(
   ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	studentid INT NOT NULL,
	teacherid INT NOT NULL,
	attendancedate DATETIME NOT NULL,
	is_present BOOLEAN NOT NULL,
	createdby varchar(50) NOT NULL,
	createdate DATETIME NOT NULL,
	updateddate DATETIME,
	updatedby varchar(50)
);

create table attendance_system.accountinformation
(
	username varchar(50) NOT NULL PRIMARY KEY ,
	password varchar(50) NOT NULL,
	lastloginDate DATETIME NOT NULL
	
);

ALTER TABLE attendance_system.attendancedetails
ADD CONSTRAINT `FK_attendencedetails_studentdetails` FOREIGN KEY (`studentid`) REFERENCES `attendance_system`.`studentdetails` (`studentid`)

ALTER TABLE attendance_system.attendancedetails
ADD CONSTRAINT `FK_attendencedetails_teacherdetails` FOREIGN KEY (`createdby`) REFERENCES `attendance_system`.`teacherdetails` (`teacherid`)