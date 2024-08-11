Create Database Worker_Info
CREATE TABLE [dbo].[Department](
	[DepartmentID] [int] IDENTITY(1,1) NOT NULL,
	[DepartmentName] [varchar](100) NULL,
 CONSTRAINT [PK_Department] PRIMARY KEY CLUSTERED 
(
	[DepartmentID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Designation]    Script Date: 04-07-2023 08:18:47 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Designation](
	[DesignationID] [int] IDENTITY(11,1) NOT NULL,
	[DesignationName] [varchar](100) NULL,
 CONSTRAINT [PK_Designation] PRIMARY KEY CLUSTERED 
(
	[DesignationID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Person]    Script Date: 04-07-2023 08:18:47 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Person](
	[WorkerID] [int] IDENTITY(101,1) NOT NULL,
	[FirstName] [varchar](100) NULL,
	[LastName] [varchar](100) NULL,
	[Salary] [decimal](8, 2) NULL,
	[JoiningDate] [datetime] NULL,
	[DepartmentID] [int] NULL,
	[DesignationID] [int] NULL,
 CONSTRAINT [PK_Person] PRIMARY KEY CLUSTERED 
(
	[WorkerID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[Department] ON 

INSERT [dbo].[Department] ([DepartmentID], [DepartmentName]) VALUES (4, N'Account')
INSERT [dbo].[Department] ([DepartmentID], [DepartmentName]) VALUES (1, N'Amin')
INSERT [dbo].[Department] ([DepartmentID], [DepartmentName]) VALUES (3, N'HR')
INSERT [dbo].[Department] ([DepartmentID], [DepartmentName]) VALUES (2, N'It')
SET IDENTITY_INSERT [dbo].[Department] OFF
SET IDENTITY_INSERT [dbo].[Designation] ON 

INSERT [dbo].[Designation] ([DesignationID], [DesignationName]) VALUES (15, N'CEO')
INSERT [dbo].[Designation] ([DesignationID], [DesignationName]) VALUES (13, N'Clerk')
INSERT [dbo].[Designation] ([DesignationID], [DesignationName]) VALUES (11, N'Jobber')
INSERT [dbo].[Designation] ([DesignationID], [DesignationName]) VALUES (14, N'Manager')
INSERT [dbo].[Designation] ([DesignationID], [DesignationName]) VALUES (12, N'Welder')
SET IDENTITY_INSERT [dbo].[Designation] OFF
SET IDENTITY_INSERT [dbo].[Person] ON 

INSERT [dbo].[Person] ([WorkerID], [FirstName], [LastName], [Salary], [JoiningDate], [DepartmentID], [DesignationID]) VALUES (101, N'Rahul', N'Anshu', CAST(56000.00 AS Decimal(8, 2)), CAST(N'1990-01-01 00:00:00.000' AS DateTime), 1, 12)
INSERT [dbo].[Person] ([WorkerID], [FirstName], [LastName], [Salary], [JoiningDate], [DepartmentID], [DesignationID]) VALUES (102, N'Hardik', N'Hinsu', CAST(18000.00 AS Decimal(8, 2)), CAST(N'1990-09-25 00:00:00.000' AS DateTime), 2, 11)
INSERT [dbo].[Person] ([WorkerID], [FirstName], [LastName], [Salary], [JoiningDate], [DepartmentID], [DesignationID]) VALUES (103, N'Bhavin', N'Kamani', CAST(25000.00 AS Decimal(8, 2)), CAST(N'1991-05-14 00:00:00.000' AS DateTime), NULL, 11)
INSERT [dbo].[Person] ([WorkerID], [FirstName], [LastName], [Salary], [JoiningDate], [DepartmentID], [DesignationID]) VALUES (104, N'Bhoomi', N'Patel', CAST(39000.00 AS Decimal(8, 2)), CAST(N'2014-02-20 00:00:00.000' AS DateTime), 1, 13)
INSERT [dbo].[Person] ([WorkerID], [FirstName], [LastName], [Salary], [JoiningDate], [DepartmentID], [DesignationID]) VALUES (105, N'Rohit', N'Rajgor', CAST(17000.00 AS Decimal(8, 2)), CAST(N'1990-07-23 00:00:00.000' AS DateTime), 2, 15)
INSERT [dbo].[Person] ([WorkerID], [FirstName], [LastName], [Salary], [JoiningDate], [DepartmentID], [DesignationID]) VALUES (106, N'Priya', N'Mehta', CAST(25000.00 AS Decimal(8, 2)), CAST(N'1990-10-18 00:00:00.000' AS DateTime), 2, NULL)
INSERT [dbo].[Person] ([WorkerID], [FirstName], [LastName], [Salary], [JoiningDate], [DepartmentID], [DesignationID]) VALUES (107, N'Neha', N'Trivedi', CAST(18000.00 AS Decimal(8, 2)), CAST(N'2014-02-20 00:00:00.000' AS DateTime), 3, 15)
SET IDENTITY_INSERT [dbo].[Person] OFF
SET ANSI_PADDING ON

GO
/****** Object:  Index [IX_Department_1]    Script Date: 04-07-2023 08:18:47 ******/
ALTER TABLE [dbo].[Department] ADD  CONSTRAINT [IX_Department_1] UNIQUE NONCLUSTERED 
(
	[DepartmentName] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [IX_Department]    Script Date: 04-07-2023 08:18:47 ******/
CREATE NONCLUSTERED INDEX [IX_Department] ON [dbo].[Department]
(
	[DepartmentID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [IX_Designation]    Script Date: 04-07-2023 08:18:47 ******/
ALTER TABLE [dbo].[Designation] ADD  CONSTRAINT [IX_Designation] UNIQUE NONCLUSTERED 
(
	[DesignationName] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [IX_Person]    Script Date: 04-07-2023 08:18:47 ******/
CREATE NONCLUSTERED INDEX [IX_Person] ON [dbo].[Person]
(
	[WorkerID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Person]  WITH CHECK ADD  CONSTRAINT [FK_Person_Department] FOREIGN KEY([DepartmentID])
REFERENCES [dbo].[Department] ([DepartmentID])
GO
ALTER TABLE [dbo].[Person] CHECK CONSTRAINT [FK_Person_Department]
GO
ALTER TABLE [dbo].[Person]  WITH CHECK ADD  CONSTRAINT [FK_Person_Designation] FOREIGN KEY([DesignationID])
REFERENCES [dbo].[Designation] ([DesignationID])
GO
ALTER TABLE [dbo].[Person] CHECK CONSTRAINT [FK_Person_Designation]
GO
USE [master]
GO
ALTER DATABASE [Worker_Info] SET  READ_WRITE 
GO


