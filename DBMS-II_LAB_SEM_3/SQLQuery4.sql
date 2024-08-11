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

--5.Write a function to compare two integers and returns the comparison result. (Using Case statement).Create Function fun_compare(@a int , @b int)returns varchar(100)as begin 	declare @ans varchar(100)	set @ans =  CASE					When @a > @b then 'a is grater than b'					When @a < @b then 'a is less than b'					ELSE 'a is equal to b'				END		Return @ansendSelect dbo.fun_compare(4,10);--6. Write a function to print number from 1 to N. (Using while loop)Alter Function fun_printNum(@num int)returns varchar(100)as begin	declare @ans varchar(100)	declare @i int	set @i=1			WHILE(@i<=@num)			begin			set @ans= CONCAT(@ans,' ',@i)			set @i = @i+1			end	return @ansENDSelect dbo.fun_printNum(10);--7. Write a function to print sum of even numbers between 1 to 20.Alter Function fun_printSum()returns intas begin	declare @ans int = 0	declare @i int	set @i=1			WHILE(@i<=20)			begin			if(@i%2=0)			set @ans = @ans + @i			set @i = @i+1			end		return @ansEndSelect dbo.fun_printSum();--8.Write a function to check weather given number is prime or not.Create Function fun_Prime(@a int)returns varchar(100)as begin	declare @i int	set @i=2	WHILE(@i<=@a/2)	begin	if(@a%@i=0)	begin	return 'Not prime'	end	set @i = @i + 1	end	return 'Prime'ENDSelect dbo.fun_Prime(7);Select dbo.fun_Prime(9);--9. Write a function which accepts two parameters start date & end date, and returns a difference in days.
Create Function fun_CheckDate(@sdate dateTime,@edate Datetime)
returns int
as 
begin
	declare @ans int = DateDIFF(day,@sdate,@edate)
	return @ans
end

Select dbo.fun_CheckDate('2023-06-28','2023-07-15');

--10. Write a function which accepts year & month in integer and returns total days in given month & year.Alter Function fun_CheckDay(@year int,@month int)returns intas begin		Declare @Date DateTime = concat(@year,'-',@month,'-','1') 		return Day(EOMONTH(@Date))EndSelect dbo.fun_CheckDay(2023,6)


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

