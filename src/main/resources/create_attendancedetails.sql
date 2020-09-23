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

ALTER TABLE attendance_system.attendancedetails
ADD CONSTRAINT `FK_attendencedetails_studentdetails` FOREIGN KEY (`studentid`) REFERENCES `attendance_system`.`studentdetails` (`studentid`)

INSERT INTO `attendancedetails` (`ID`, `studentid`, `teacherid`, `attendancedate`, `is_present`, `createdby`, `createdate`, `updateddate`, `updatedby`) VALUES (1, 1001, 5000, '2020-09-21 12:33:28', 1, 'TEST1', '2020-09-21 12:33:44', NULL, NULL);




