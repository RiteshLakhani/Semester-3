-- CREATE TABLE Department
CREATE TABLE Department(
DepartmentID Int Primary Key,
DepartmentName Varchar(100)	Not Null Unique)

-- CREATE TABLE Designation
CREATE TABLE Designation(
DesignationID Int Primary Key,
DesignationName	Varchar(100) Not Null Unique)

-- CREATE TABLE Person
CREATE TABLE Person(
WorkerID Int IDENTITY(101,1) PRIMARY KEY,
FirstName Varchar(100) Not Null,
LastName Varchar(100) Not Null,
Salary Decimal(8,2)	Not Null,
JoiningDate	Datetime Not Null,	
DepartmentID Int Null FOREIGN KEY REFERENCES Department(DepartmentID),
DesignationID Int Null FOREIGN KEY REFERENCES Designation(DesignationID))


--1.All Table Insert---

--1.department--

Alter Proc SPDesignation_insert
	@departmentID int,
	@departmentName varchar(100)
as 
begin 
	Insert into Department(departmentId,departmentName) 
	values(@departmentID,@departmentName)
end

exec SPDesignation_insert 1,'Admin';
exec SPDesignation_insert 2,'IT';
exec SPDesignation_insert 3,'HR';
exec SPDesignation_insert 4,'Account';


--2.designation--

Create Proc SPDepartment_insert
	@designationID int,
	@designationName varchar(100)
as 
begin 
	Insert into Designation(designationID,designationName) 
	values(@designationID,@designationName)
end

exec SPDepartment_insert 11,'Jobber';
exec SPDepartment_insert 12,'Welder';
exec SPDepartment_insert 13,'Clerk';
exec SPDepartment_insert 14,'Manager';
exec SPDepartment_insert 15,'CEO';


--3.Person--

Alter Proc SPPERSON_insert
	@FirstName varchar(100),
	@LastName varchar(100),
	@Salary Decimal(8,2),
	@JoiningDate DateTime,
	@departmentID int,
	@designationID int
as 
begin 
		Insert into Person(FirstName,LastName,Salary,JoiningDate,departmentID,designationID)
		values(@FirstName,@LastName,@Salary,@JoiningDate,@departmentID,@designationID)
end;

exec SPPERSON_insert 'Rahul','Anshu',56000,'1990-01-01',1,12;
exec SPPERSON_insert 'Hardik','Hinsu',18000,'1990-09-25',2,11;
exec SPPERSON_insert 'Bhavin','Kamani',25000,'1991-05-14',NULL,11;
exec SPPERSON_insert 'Bhoomi','Patel',39000,'2004-02-20',1,13;
exec SPPERSON_insert 'Rohit','Rajgor',17000,'1990-07-23',2,15;
exec SPPERSON_insert 'Priya','Mehta',25000,'1990-10-18',2,NULL;
exec SPPERSON_insert 'Neha','Trivedi',18000,'2014-02-20',3,15;


--All Tables Update----

--1. Department--
Create Proc SPDesignation_update
	@departmentID int,
	@departmentName varchar(100)
as 
begin
	Update Department
	set departmentName=@departmentName
	where departmentId=@departmentID
end

exec SPDesignation_update 3,'ME';


--2. Designation--
Create Proc SPDepartment_update
	@designationID int,
	@designationName varchar(100)
as 
begin
	Update Designation
	set DesignationName=@designationName
	where designationID=@designationID
end

exec SPDepartment_update 13,'Owner';

--3 Person---
Alter Proc SPPERSON_update
	@WorkerID int,
	@FirstName varchar(100),
	@LastName varchar(100),
	@Salary Decimal(8,2),
	@JoiningDate DateTime,
	@departmentID int,
	@designationID int
as
begin
	Update Person
	Set FirstName=@FirstName,
		LastName=@LastName,
		Salary=@Salary,
		JoiningDate=@JoiningDate,
		departmentID=@departmentID,
		designationID=@designationID
	Where WorkerID = @WorkerID
end;
	
exec SPPERSON_update 101,'Ritesh','Lakhani',56000,'2005-07-15',2,15;


--3.All Tables Delete--

--1.Person--

Create Proc SPPerson_delete
	@personID int
as
begin
		delete from Person
		where WorkerID = @personID
end  

exec SPPerson_delete 101
exec SPPerson_delete 104


--2.Department--

Create Proc SPDesignation_delete
	@DepartmentID int
as
begin
		delete from Department
		where DepartmentID = @DepartmentID
end  

exec SPDesignation_delete 1;

--3.Desigantion--

Create Proc SPDepartment_delete
	@DesignationID int
as
begin
		delete from Designation
		where DesignationID = @DesignationID
end  

exec SPDepartment_delete  13; 


--All Tables SelectPK--

--Person PK--

Create proc pr_person_pk
	@WorkerID int
as 
begin
	select * from Person
	where WorkerID=@WorkerID
end

exec pr_person_pk 103

--Department--
create proc pr_Department_pk
	@DepartmentID int
as
begin
	select * from Department
	where DepartmentID=@DepartmentID
end

exec pr_Department_pk 3

--Designation--

create proc pr_DesignationID_pk
	@DesignationID int
as
begin
	select * from Designation
	where DesignationID=@DesignationID
end

exec pr_DesignationID_pk 15

--Select ALL----

--Person--
Create proc pr_person_all
as
begin
	select * from person 
	inner join Department
	on Person.DepartmentID=Department.DepartmentID
	left outer join Designation
	on Person.DesignationID=Designation.DesignationID
end

exec pr_person_all

--Department----
create proc pr_Department_all
as
begin
	select * from Department
end

exec pr_Department_all

--Designation--
create proc pr_Designation_all
as
begin
	select * from Designation
end

exec pr_Designation_all

Select * from Person;