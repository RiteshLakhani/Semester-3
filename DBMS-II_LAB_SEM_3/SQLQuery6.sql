--Lab-6--

--Part-A-- 

--1. Create a trigger that fires on INSERT, UPDATE and DELETE operation on the Person table to display a message “Record is Affected.”
alter Trigger TR_Person_Insert
on Person
After Insert
as 
begin 
		declare @p_id int,
				@p_name varchar(100)
		
		select @p_id = inserted.personId ,
			   @p_name = inserted.PersonName
			   from inserted

		insert into PersonLog
		values(@p_id,@p_name,'insert',getdate());
		select 'Row is affected'
end;

alter Trigger TR_Person_Update
on Person
After Update
as 
begin 
		declare @p_id int,
				@p_name varchar(100)
		
		select @p_id = inserted.personId ,
			   @p_name = inserted.PersonName
			   from inserted

		insert into PersonLog
		values(@p_id,@p_name,'update',getdate());
		select 'Row is affected'
end;

alter Trigger TR_Person_delete
on Person
After Delete
as 
begin 
		declare @p_id int,
				@p_name varchar(100)
		
		select @p_id = deleted.personId ,
			   @p_name = deleted.PersonName
			   from deleted

		insert into PersonLog
		values(@p_id,@p_name,'deleted',getdate());
		select 'Row is affected'
end;

insert into Person
values(101,'Het',10000,'07-10-2004','Upleta',18,'07-10-2004')

update Person
set Salary = 200000
where PersonID = 101

delete from Person
where PersonID = 101

--2.Create a trigger that fires on INSERT, UPDATE and DELETE operation on the Person table. For that, log all operations performed on the person table into PersonLog.--as per above----3.Create an INSTEAD OF trigger that fires on INSERT, UPDATE and DELETE operation on the Person table. For that, log all operations performed on the person table into PersonLog.Create Trigger TR_Person_Insert_instead_of
on Person
INSTEAD OF Update,delete
as 
begin 
		declare @p_id int,
				@p_name varchar(100)
		
		select @p_id = inserted.personId ,
			   @p_name = inserted.PersonName
			   from inserted

		insert into PersonLog
		values(@p_id,@p_name,'insert',getdate());
		select 'Row is affected'
end;

drop trigger TR_Person_Insert_instead_of;

Alter Trigger TR_Person_Update_instead_of
on Person
INSTEAD OF INSERT,delete
as 
begin 
		declare @p_id int,
				@p_name varchar(100)
		
		select @p_id = inserted.personId ,
			   @p_name = inserted.PersonName
			   from inserted

		insert into PersonLog
		values(@p_id,@p_name,'update',getdate());
		select 'Row is affected'
end;

drop trigger TR_Person_Update_instead_of;

create Trigger TR_Person_delete_instead_of
on Person
instead of insert,update
as 
begin 
		declare @p_id int,
				@p_name varchar(100)
		
		select @p_id = deleted.personId ,
			   @p_name = deleted.PersonName
			   from deleted

		insert into PersonLog
		values(@p_id,@p_name,'deleted',getdate());
		select 'Row is affected'
end;

drop trigger TR_Person_delete_instead_of;

--4.Create a trigger that fires on INSERT operation on the Person table to convert person name into uppercase whenever the record is inserted.
alter Trigger TR_Person_uppercase
on Person
after Insert
as 
begin 
		declare @p_id int,
				@p_name varchar(100)
		
		select @p_id = inserted.personId ,
			   @p_name = Upper(inserted.PersonName)
			   from inserted
		update Person
		set PersonName = @p_name
		where @p_id = PersonID;

		--insert into PersonLog
		--values(@p_id,@p_name,'insert',getdate());
end;

--Part-B--

--5.Create a trigger that fires on INSERT operation on person table, which calculates the age and update that age in Person table.Alter trigger TR_PERSON_AGEon PersonAfter insert as begin		declare @age int,			    @p_id int		Select @age = datediff(year,age,getdate()) from inserted		Select @p_id = PersonID from inserted		update Person		set age = @age		where PersonID = @p_idend;--Part-c----6. Create DELETE trigger on PersonLog table, when we delete any record of PersonLog table it prints ‘Record deleted successfully from PersonLog’.CREATE TRIGGER trg_DeletePersonLog
ON PersonLog
AFTER DELETE
AS
BEGIN
    PRINT 'Record deleted successfully from PersonLog';
END;
