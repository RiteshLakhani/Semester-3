--Lab-4--- User Define Function 

--(i) Scalar valued Function:-

--1. Write a function to print "hello world".
Create Function fun_PrintString(@message nvarchar(100))
returns nvarchar(100)
as 
begin
	return @message
end

Select dbo.fun_PrintString('Hello Wolrd');

--2.Write a function which returns addition of two numbers.
Create Function fun_AddNumber(@num1 int , @num2 int)
returns int 
as
begin 
	return @num1+@num2
end

Select dbo.fun_AddNumber(2,3);


--3.Write a function to print cube of given number.
Create Function fun_CubeNumber(@num1 int)
returns int
as 
begin 
	return power(@num1,3)
end

Select dbo.fun_CubeNumber(2);

--4.Write a function to check where given number is ODD or EVEN.
Alter Function fun_check(@num int)
returns nvarchar(100)
as 
begin 
	 if(@num%2=0)
	 return 'even'
	 else
	 return 'odd'
	 return 0
end

Select dbo.fun_check(8);

--5.Write a function to compare two integers and returns the comparison result. (Using Case statement).
Create Function fun_CheckDate(@sdate dateTime,@edate Datetime)
returns int
as 
begin
	declare @ans int = DateDIFF(day,@sdate,@edate)
	return @ans
end

Select dbo.fun_CheckDate('2023-06-28','2023-07-15');

--10. Write a function which accepts year & month in integer and returns total days in given month & year.


 --Table valued functions (Use tables of lab-2)--

--11. Write a function which returns a table with detail of person whose first name starts with B.
Alter FUNCTION fun_RetriveName()
RETURNS TABLE
AS
RETURN
(
    SELECT *
    FROM Persons
    WHERE FirstName LIKE 'B%'
);

SELECT * FROM dbo.fun_RetriveName();

--12. Write a function which returns a table with unique first names from person table.
CREATE FUNCTION fun_UniqueFirstNames()
RETURNS TABLE
AS
RETURN
(
    SELECT DISTINCT FirstName
    FROM Persons
);

SELECT * FROM dbo.fun_UniqueFirstNames();

--13. Write a function which accepts department ID as a parameter & returns a detail of the persons.
CREATE FUNCTION fun_GetPersonsByDepartmentID
(
    @DepartmentID int
)
RETURNS TABLE
AS
RETURN
(
    SELECT *
    FROM Persons
    WHERE DepartmentID = @DepartmentID
);

SELECT * FROM dbo.fun_GetPersonsByDepartmentID(1);
SELECT * FROM dbo.fun_GetPersonsByDepartmentID(2);
SELECT * FROM dbo.fun_GetPersonsByDepartmentID(3);
SELECT * FROM dbo.fun_GetPersonsByDepartmentID(4);
