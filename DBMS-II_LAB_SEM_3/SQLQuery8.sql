--From the above given tables perform the following queries: 
--Part – A
--1. Handle Divide by Zero Error and Print message like: Error occurs that is - Divide by zero error.
Begin TRY
			Select 1 / 0;
End TRY
Begin Catch
		select 'Error Occurs that is'+Error_Message(),
		 ''+cast(Error_Line() as varchar),
		 ''+cast(Error_Severity() as varchar),
		 ''+cast(Error_state() as varchar),
		 ''+cast(Error_Number() as varchar);
End Catch
--2. Try to convert string to integer and handle the error using try…catch block.
Begin TRY
			declare @str varchar(100)
			set @str = 'Ritesh'

			declare @myInt int
			set @myInt = @str
End TRY
Begin Catch
		select 'Error Occurs that is '+Error_Message() as ErrorMessage,
		 ''+cast(Error_Line() as varchar) as Line,
		 ''+cast(Error_Severity() as varchar) as Severity,
		 ''+cast(Error_state() as varchar) as errorState,
		 ''+cast(Error_Number() as varchar) as Number;
End Catch


--3. Create a procedure that prints the sum of two numbers: take both numbers as integer & handle exception with all error functions if any one enters string value in numbers otherwise print result.
Create Proc SP_Sum 
		@No1 varchar(215),
		@No2 varchar(50)
As 
Begin 
	Begin TRY
			declare @Result int
			set @Result = cast(@No1 as int) + cast(@No2 as int)
			PRINT @Result
	End TRY
	Begin CATCH
			select 'Error Occurs that is '+Error_Message() as ErrorMessage,
										''+cast(Error_Line() as varchar) as Line,
										''+cast(Error_Severity() as varchar) as Severity,
										''+cast(Error_state() as varchar) as ErrorState,
										''+cast(Error_Number() as varchar) as Number,
										''+Error_Procedure() as ProcedureName
	END CATCH
END

exec SP_Sum 10,15 
exec SP_Sum 10,'Het' 

--4. Handle a Primary Key Violation while inserting data into customers table and print the error details such as the error message, error number, severity, and state.
Begin TRY
		Insert into Customers
		values (1,'Ritesh','xyz@gmail.com'),
			   (1,'Het','het@gmail.com')
End TRY
BEGIN CATCH
		select 'Error Occurs that is '+Error_Message() as ErrorMessage,
										''+cast(Error_Line() as varchar) as Line,
										''+cast(Error_Severity() as varchar) as Severity,
										''+cast(Error_state() as varchar) as ErrorState,
										''+cast(Error_Number() as varchar) as Number,
										''+Error_Procedure() as ProcedureName
END CATCH
--5. Throw custom exception using stored procedure which accepts Customer_id as input & that throws Error like no Customer_id is available in database.
Alter Proc SP_Insert 
		@Cid int
As
Begin 
	Begin Try
			if exists (Select * from Customers 
			Where Customer_id =  @Cid)
				print 'Id is found'
			else
				Throw 50001,'Error like no Customer_id is available in database',2
	End Try
	Begin Catch
					
					select 'Error Occurs that is '+Error_Message() as ErrorMessage,
										''+cast(Error_Line() as varchar) as Line,
										''+cast(Error_Severity() as varchar) as Severity,
										''+cast(Error_state() as varchar) as ErrorState,
										''+cast(Error_Number() as varchar) as Number,
										''+Error_Procedure() as ProcedureName
	End Catch
End

exec SP_Insert 1
exec SP_Insert 5

--Part – B
--6. Handle a Foreign Key Violation while inserting data into Orders table and print appropriate error message.
Begin TRY
		Insert into Orders
		values ( 10 , 5 ,'2023-08-16')
		       --( 2 , 5 ,getdate())
End TRY
BEGIN CATCH
		select 'Error Occurs that is '+Error_Message() as ErrorMessage,
										''+cast(Error_Line() as varchar) as Line,
										''+cast(Error_Severity() as varchar) as Severity,
										''+cast(Error_state() as varchar) as ErrorState,
										''+cast(Error_Number() as varchar) as Number,
										''+Error_Procedure() as ProcedureName
END CATCH

--7. Throw custom exception that throws error if the id is invalid.
alter Proc SP_invalid_customer 
		@Cid int
As
Begin 
	Begin Try
			if(@Cid < 0)
				Throw 50001,'Error like no Customer_id is invalid',2
			else if not exists(select * from Customers where @Cid = Customer_id)
					Throw 50001,'Data not found',2
			else
				begin
					select * from Customers
					where @Cid = Customer_id
				end
				
	End Try
	Begin Catch
					
					select 'Error Occurs that is '+Error_Message() as ErrorMessage,
										''+cast(Error_Line() as varchar) as Line,
										''+cast(Error_Severity() as varchar) as Severity,
										''+cast(Error_state() as varchar) as ErrorState,
										''+cast(Error_Number() as varchar) as Number,
										''+Error_Procedure() as ProcedureName
	End Catch
End

exec SP_invalid_customer 1

--Part - C
--8. Create a procedure which prints the error message that “The Customer_id is already taken. Try another one”.
create proc SP_insert_cid
			@Cid int,
			@Cname varchar(50),
			@Email varchar(100)
As
Begin
	Begin try
		Insert into Customers
		values (@Cid,@Cname,@Email)
End TRY
BEGIN CATCH
		print 'The customer_id is already taken.Try onther one'
END CATCH
end

exec SP_insert_cid 3,'meet','meet@gmail.com'
exec SP_insert_cid 1,'Ritesh','xyz@gmail.com'
