CREATE TABLE Product_Info
(
	Product_id	Int	Primary Key,
	Product_Name Varchar(250) Not Null,
	Price Decimal(10,2)	Not Null
)
CREATE TABLE NewProducts
(
	Product_id	Int	Primary Key,
	Product_Name Varchar(250) Not Null,
	Price Decimal(10,2)	Not Null
)
INSERT INTO Product_Info VALUES(1,'Smartphone',35000);
INSERT INTO Product_Info VALUES(2,'Laptop',65000);
INSERT INTO Product_Info VALUES(3,'Headphones',5500);
INSERT INTO Product_Info VALUES(4,'Television',85000);
INSERT INTO Product_Info VALUES(5,'Gaming Console',32000);

--LAB-7--
--From the above given tables perform the following queries: 
-----Part - A------
--1. Create a cursor Product_Cursor to fetch all the rows from a products table.
Declare @Product_id int,
		@Product_name varchar(250),
		@Price Decimal(10,2)
Declare Product_Cursor cursor
For select * from Product_Info;
Open Product_Cursor;
Fetch Next From Product_Cursor Into
		@Product_id,
		@Product_name,
		@Price
While @@FETCH_STATUS = 0
		Begin
		Print 'Product ID: ' + Cast(@Product_id as varchar(10)) + ', Product Name: ' + @Product_name + ', Price: ' + Cast(@Price as varchar(10))
		Fetch next from Product_cursor Into
		@Product_id,
		@Product_name,
		@Price
		End;
Close Product_Cursor;
Deallocate Product_cursor;


--2. Create a cursor Product_Cursor_Fetch to fetch the records in form of ProductID_ProductName.
--(Example: 1_Smartphone)
Declare @Product_id int,
		@Product_name varchar(250)
Declare Product_Cursor_Fetch cursor
For select Product_id,Product_Name from Product_Info;
Open Product_Cursor_Fetch;
Fetch Next From Product_Cursor_Fetch Into
		@Product_id,
		@Product_name
While @@FETCH_STATUS = 0
		Begin
		Print Cast(@Product_id as varchar(10)) + '_' + @Product_name 
		Fetch next from Product_cursor_Fetch Into
		@Product_id,
		@Product_name
		End;
Close Product_Cursor_Fetch;
Deallocate Product_cursor_Fetch;



--3. Create a cursor Product_CursorDelete that deletes all the data from the Products table.
Declare @Product_id int
Declare Product_CursorDelete cursor
For Select Product_id from Product_Info;
Open Product_CursorDelete;
Fetch Next From Product_CursorDelete Into
		@Product_id
While @@FETCH_STATUS = 0
		Begin
			Delete from Product_Info
			Where @Product_id = Product_id
		Fetch Next From Product_CursorDelete Into
		@Product_id
		End;
Close Product_CursorDelete;
Deallocate Product_cursorDelete;

Select * from Product_Info;



-----Part – B-------
--4. Create a cursor Product_CursorUpdate that retrieves all the data from the products table and increases the price by 10%.
Declare @Product_id int,
		@Product_name varchar(250),
		@Price Decimal(10,2)
Declare Product_CursorUpdate Cursor
For Select * from Product_Info;
Open Product_CursorUpdate;
Fetch Next From Product_CursorUpdate Into
		@Product_id,
		@Product_name,
		@Price 
While @@FETCH_STATUS = 0 
Begin 
		update Product_Info
		set Price = @price * 1.1
		Where Product_id = @Product_id

		Fetch Next From Product_CursorUpdate Into
		@Product_id,
		@Product_name,
		@Price
End;
Close Product_CursorUpdate;
Deallocate Product_CursorUpdate;

-----Part – C------

--5. Create a cursor to insert details of Products into the NewProducts table if the product is “Laptop” 
--(Note: Create NewProducts table first with same fields as Products table)

Declare @Product_id int,
		@Product_name varchar(250),
		@Price Decimal(10,2)
Declare Product_CursorInsert Cursor
For Select * from Product_Info;
Open Product_CursorInsert;
Fetch Next From Product_CursorInsert Into
		@Product_id,
		@Product_name,
		@Price 
While @@FETCH_STATUS = 0 
Begin 
if(@Product_name = 'Laptop')
begin
		insert into NewProducts
		values (
			@Product_id,
			@Product_name,
			@Price
		)
end
		Fetch Next From Product_CursorInsert Into
		@Product_id,
		@Product_name,
		@Price
End;
Close Product_CursorInsert;
Deallocate Product_CursorInsert;

--Extra
--1. Create a cursor Product_Cursor to fetch all the rows from a products table and sum of all the price.
Declare @Product_id int,
		@Product_name varchar(250),
		@Price Decimal(10,2),
		@total int
		set @total = 0
Declare Product_Cursor_Extra cursor
For select * from Product_Info;
Open Product_Cursor_Extra;
Fetch Next From Product_Cursor_Extra Into
		@Product_id,
		@Product_name,
		@Price
While @@FETCH_STATUS = 0
		Begin
		set @total = @total+ @price
		print ('Product ID: ' + Cast(@Product_id as varchar(10)) + ', Product Name: ' + @Product_name + ', Price: ' + Cast(@Price as varchar(10)))
		Fetch next from Product_Cursor_Extra Into
		@Product_id,
		@Product_name,
		@Price
		End;
		print 'Total: '+Cast(@total as varchar(250))
Close Product_Cursor_Extra;
Deallocate Product_Cursor_Extra;



