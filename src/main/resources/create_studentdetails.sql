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
