---Lab-1----- with Procedure

--1. Find all persons with their department name & code.
Create Proc SPDepartmentName_Code
as 
begin
	SELECT d2.DepartmentName, d2.departmentcode, d1.PersonName
	FROM Person AS d1
	Right JOIN department AS d2
	ON d1.DepartmentID = d2.DepartmentID;
end

exec SPDepartmentName_Code;


--2. Find person's name whose department located in C-Block.
Create Proc SPDepartmentLocated
as 
begin
	SELECT d1.PersonName,d2.location
	From Person as d1
	Left Outer Join Department As d2
	On d1.DepartmentID = d2.DepartmentID
	where Location = 'C-Block';
end

exec SPDepartmentLocated;
 
--3. Retrieve person name, salary & department name who belongs to Jamnagar city.
Create Proc SPNAME
as 
begin
	SELECT d1.PersonName,d1.Salary,d2.departmentName
	from Person as d1
	Left Outer  Join Department As d2
	On d1.DepartmentID = d2.DepartmentId
	where city='Jamnagar'
end

exec SPNAME;

--4. Retrieve person name, salary & department name who does not belongs to Rajkot city.

Create Proc SPName_Salary_notCity
as 
begin
	SELECT d1.PersonName,d1.Salary,d2.departmentName
	from Person as d1
	Left Outer  Join Department As d2
	On d1.DepartmentID = d2.DepartmentId
	where city not like'Rajkot'
end;

exec SPName_Salary_notCity;

--5. Find detail of all persons who belongs Computer department.
Create Proc SPComputer_Details
as 
begin
	SELECT d1.PersonID, d1.PersonName, d1.DepartmentID, d1.Salary, d1.JoiningDate,d1.City,d2.DepartmentName
	from Person as d1
	Left Outer Join Department As d2
	On d1.DepartmentID = d2.DepartmentID
	where DepartmentName='computer';
end;

exec SPComputer_Details;

--6. Find all persons who does not belongs to any department.
Create Proc SPDepartment_Details
as 
begin
	Select d1.PersonName
	from Department as d2
	Right Outer Join Person as d1
	On d1.DepartmentID = d2.DepartmentID
	where d2.DepartmentID is Null;
end;

exec SPComputer_Details;


--7. Retrieve person’s name who joined Civil department after 1-Aug-2001.
Create Proc SPJOIN
as
begin
	Select d1.PersonName,d2.departmentName
	from Person as d1
	Left Outer join Department as d2
	On d1.DepartmentID = d2.DepartmentID
	where DepartmentName='civil' And JoiningDate>'2001-08-01';
end;

exec SPJOIN;

--8. Display all the person's name with department whose joining dates difference with current date is more than 365 days.
Create Proc SPDepartment_Joining
as 
begin
	Select d1.PersonName , d2.DepartmentName
	from person as d1
	Join Department as d2
	on d1.DepartmentID = d2.DepartmentID
	where DATEDIFF(day,d1.JoiningDate,getdate())>365;
end;

exec SPDepartment_Joining;


--9. Find department wise person counts.
Create proc SPDepartment_count
as 
begin
	Select d2.DepartmentName , count(d1.PersonID)
	from Person as d1
	Left Outer Join Department as d2 
	On d1.departmentId = d2.departmentId
	Group by d2.DepartmentName
end;

exec SPDepartment_count;

--10. Give department wise maximum & minimum salary with department name.
Create Proc SPDepartment_max_min
as
begin
	SELECT d2.departmentName, MAX(d1.salary) AS maximum_salary, MIN(d1.salary) AS minimum_salary
	FROM Department  as d2 
	Right Outer Join Person as d1
	ON d1.departmentId = d2.departmentId
	GROUP BY d2.departmentName;
end;

exec SPDepartment_max_min;

--11. Find city wise total, average, maximum and minimum salary.
Create proc SPCITY_MAX_MIN_AVG
as
begin
	SELECT d1.City,
		   SUM(d1.Salary) AS total_salary,
		   AVG(d1.Salary) AS average_salary,
		   MAX(d1.Salary) AS maximum_salary,
		   MIN(d1.Salary) AS minimum_salary
	FROM person as d1
	Left Outer JOIN department as d2 
	ON d1.DepartmentID = d2.DepartmentID
	GROUP BY d1.City;
end;

exec SPCITY_MAX_MIN_AVG;

--12. Find all departments whose total salary is exceeding 100000.
Create Proc SPSalary
as 
begin
	SELECT d2.DepartmentName, SUM(d1.Salary) AS total_salary
	FROM Department as d2
	Right Outer JOIN Person as d1 
	ON d1.DepartmentID = d2.DepartmentID
	GROUP BY d2.DepartmentName
	HAVING SUM(d1.Salary) > 100000;
end;

exec SPSalary;

--13. Find average salary of person who belongs to Ahmedabad city.
Create Proc SPAVG_Salary
as 
begin
	SELECT AVG(d1.Salary) AS average_salary
	FROM person as d1
	LEFT JOIN department as d2 
	ON d1.DepartmentID = d2.DepartmentID
	WHERE d1.City = 'Ahmedabad';
end;

exec SPAVG_Salary;

--14. List all departments who have no person.
Create Proc SPDepartment_WithNoPerson
as 
begin
	SELECT d2.DepartmentName
	FROM department d2
	LEFT Outer JOIN person d1 
	ON d1.DepartmentID = d2.DepartmentID
	WHERE d1.DepartmentID IS NULL;
end;

exec SPDepartment_WithNoPerson;

--15. List out department names in which more than two persons are working.
Create Proc SPDepartment_withPerson
as 
begin
	SELECT d2.DepartmentName
	FROM department as d2
	JOIN(
		SELECT DepartmentID, COUNT(*) AS person_count
		FROM person
		GROUP BY DepartmentID
		HAVING COUNT(*) > 2
	)d1 ON d1.DepartmentID = d2.DepartmentID;
end;

exec SPDepartment_withPerson;

--16. Produce Output Like: <PersonName> lives in <City> and works in <DepartmentName> Department. (In single column)
Create Proc SPPersonName
as 
begin
	SELECT CONCAT(d1.PersonName, ' lives in ', d1.City, ' and works in ', d2.DepartmentName, ' Department.') AS output_text
	FROM person as d1
	Left outer JOIN department d2 
	ON d1.DepartmentID = d2.DepartmentID;
end;
---Most IMP QUERY IN THIS LAB 16---
exec SPPersonName;

--17. Produce Output Like: <PersonName> earns <Salary> from department <DepartmentName> monthly.(In single column)
Create Proc SPSalary_Eren
as 
begin
	SELECT CONCAT(d1.PersonName, ' earns ', d1.Salary, ' from department ', d2.DepartmentName, ' monthly.') AS output_text
	FROM department as d2
	RIGHT OUTER JOIN person as d1 
	ON d1.DepartmentID = d2.DepartmentID;
end;

exec SPSalary_Eren;

--18. Find city & department wise total, average & maximum salaries.
Create Proc SPCity_Departmetn
as 
begin
	SELECT d1.City, d2.DepartmentName,
		   SUM(d1.Salary) AS total_salary,
		   AVG(d1.Salary) AS average_salary,
		   MAX(d1.Salary) AS maximum_salary
	FROM person as d1
	Left Outer JOIN department d2 
	ON d1.DepartmentID = d2.DepartmentID
	GROUP BY d1.City, d2.DepartmentName;
end;

exec SPCity_Departmetn;
--19. Give 10% increment in Computer department employee’s salary. (Use Update)
Create Proc SPCom_increase
as 
begin
	UPDATE person
	SET Salary = Salary * 1.1
	WHERE DepartmentID IN (
		SELECT DepartmentID
		FROM department
		WHERE DepartmentCode = 'CE'
	);
end;

exec SPCom_increase;
