
-- DATABASE MEDICAL STORE BILLING
-- GROUP 1, CLASS CODE : C0711I.
------------------------------------------------------------------
			--CREATE DATABASE MSBDB
------------------------------------------------------------------
CREATE DATABASE MSBDB
GO
USE MSBDB
GO

------------------------------------------------------------------
-- CHECK TABLE EXISTS IN  DATABASE. IF EXIST DO DROP TABLE
------------------------------------------------------------------
IF EXISTS
	(	SELECT NAME FROM sysobjects 
		WHERE NAME = 'Users' AND TYPE = 'U') 
		DROP TABLE Users
GO

IF EXISTS
	(	SELECT NAME FROM sysobjects
		WHERE NAME = 'UserType' AND TYPE = 'U') 
		DROP TABLE UserType
GO

IF EXISTS
	(	SELECT NAME FROM sysobjects
		WHERE NAME = 'Supplier' AND TYPE = 'U') 
		DROP TABLE Supplier
GO

IF EXISTS
	(	SELECT NAME FROM sysobjects
		WHERE NAME = 'MedicineType' AND TYPE = 'U') 
		DROP TABLE MedicineType
GO

IF EXISTS
	(	SELECT NAME FROM sysobjects
		WHERE NAME = 'Measure' AND TYPE = 'U')
		DROP TABLE Measure
GO

IF EXISTS
	(	SELECT NAME FROM sysobjects
		WHERE NAME = 'PaypedReport' AND TYPE = 'U')
		DROP TABLE PaypedReport
GO

IF EXISTS
	(	SELECT NAME FROM sysobjects
		WHERE NAME = 'Medicine' AND TYPE = 'U')
		DROP TABLE Medicine
GO

IF EXISTS
	(	SELECT name from sysobjects
		WHERE NAME = 'MedicineDetails' AND TYPE = 'U')
		DROP TABLE MedicineDetails
GO

IF EXISTS
	(	SELECT NAME FROM sysobjects
		WHERE NAME = 'Bill' AND TYPE = 'U')
		DROP TABLE Bill
GO

IF EXISTS
	(	SELECT NAME FROM sysobjects
		WHERE NAME = 'BillDetails' AND TYPE = 'U')
		DROP TABLE BillDetails
GO

IF EXISTS
	(	SELECT NAME FROM sysobjects
		WHERE NAME = 'Orders' AND TYPE = 'U')
		DROP TABLE Orders
GO

IF EXISTS
	(	SELECT NAME FROM sysobjects
		WHERE NAME = 'OrderDetails' AND TYPE = 'U')
		DROP TABLE OrderDetails
GO

IF EXISTS
	(	SELECT NAME FROM sysobjects
		WHERE NAME = 'Customer' AND TYPE = 'U')
		DROP TABLE Customer
GO
------------------------------------------------------------------
					-- CREATE TABLES --
------------------------------------------------------------------


-------------------- CREATE TABLE UserID --------------------------
CREATE TABLE Users
(
	userCode int identity(1,1) NOT NULL,
	nameLogin nvarchar(50) NOT NULL,
	password nvarchar(20) NOT NULL,
	fullName nvarchar(100) NOT NULL,
	userType nvarchar(100),
	userAddress nvarchar(100),
	userphone nvarchar(15),
	userEmail nvarchar(100),
	userActive bit,
	userAva nvarchar(100),
	firstName nvarchar(20),	
	lastName nvarchar(100),	
)
GO

------------------- CREATE TABLE Supplier -------------------------
CREATE TABLE Supplier
(
	supplierCode int identity(1,1) NOT NULL,
	supplierName nvarchar(30) NOT NULL,
	fullName nvarchar(100) NOT NULL,
	supplierAddress nvarchar(100),
	supplierPhone nvarchar(15),
	supplierFax nvarchar(15),
	supplierEmail nvarchar(100),
	supplierWebsite nvarchar(100),
)
GO

------------------ CREATE TABLE MedicineType ----------------------
CREATE TABLE MedicineType
(
	medicineTypeCode int identity(1,1) NOT NULL,
	medicineTypeName nvarchar(100) NOT NULL,	
)
GO

------------------ CREATE TABLE Customer --------------------------
CREATE TABLE Customer
(
	customerCode int identity(1,1) NOT NULL,
	customerName nvarchar(100) NOT NULL,
	customerType nvarchar(30) NOT NULL,	
	customerPhone nvarchar(15),
	customerFax nvarchar(15),
	customerEmail nvarchar(100),
	customerAddress nvarchar(100),	
	customerRelationship nvarchar(20),
)
GO

------------------ CREATE TABLE Measure ---------------------------
CREATE TABLE Measure
(
	measureCode int identity(1,1) NOT NULL,	
	measureName nvarchar(50) NOT NULL,
)
GO

------------------ CREATE TABLE Medicine --------------------------
CREATE TABLE Medicine
(
	medicineCode int identity(1,1) NOT NULL,
	medicineName nvarchar(100) NOT NULL,
	medicineTypeCode int NOT NULL,
	supplierCode int NOT NULL,
)
GO

------------------ CREATE TABLE MedicineDetails -------------------
CREATE TABLE MedicineDetails
(
	medicineCode int NOT NULL,
	measureCode int NOT NULL,
	pricePerUnit float,		
	avaiableAmount int,
	registerNumber nvarchar(50) NOT NULL,
	Origin nvarchar(30),
	used nvarchar(100),
	termsOfUse datetime,
	userGuide nvarchar(100),	
)
GO

------------------ CREATE TABLE Orders ---------------------------
CREATE TABLE Orders
(
	orderCode int identity(1,1) NOT NULL,
	customerCode int NOT NULL,
	dateOrder datetime NOT NULL,
	userCode int NOT NULL,
	addressToDeliver nvarchar(100),	
	price float default(0),
)
GO

------------------ CREATE TABLE OrderDetails ----------------------
CREATE TABLE OrderDetails
(
	orderCode int NOT NULL,
	medicineCode int NOT NULL,
	measureCode int NOT NULL,
	quantity int,
)
GO

------------------ CREATE TABLE Bill ------------------------------
CREATE TABLE Bill
(
	billCode int identity(1,1) NOT NULL,
	billType nvarchar(30) NOT NULL,
	customerCode int NOT NULL,
	addressToDeliver nvarchar(100),
	dateStart datetime NOT NULL,
	expiredTime datetime NOT NULL,		
	tax float,
	price float default(0),
	status nvarchar(50),
	userCode int,
)
GO

------------------ CREATE TABLE BillDetails -----------------------
CREATE TABLE BillDetails
(	
	billCode int NOT NULL,
	medicineCode int NOT NULL,
	measureCode int NOT NULL,
	quantity int,
)
GO

------------------ CREATE TABLE PaypedReport ----------------------
CREATE TABLE PaypedReport
(
	paypedReportCode int identity(1,1) NOT NULL,
	billCode int NOT NULL,
	datePay datetime,
	payedMoney float default(0),
)
GO

-------------------------------------------------------------------
-- ADD CONSTRAINT PRIMARY KEY AND FOREIGN KEY FOR TABLES IN DATABASE			
-------------------------------------------------------------------
				-- ADD PRIMARY KEY
-------------------------------------------------------------------
ALTER TABLE Supplier
	ADD CONSTRAINT PK_supplierCode
	primary key(supplierCode)
GO

ALTER TABLE Users
	ADD CONSTRAINT PK_userCode
	primary key(userCode)
GO


ALTER TABLE MedicineType
	ADD CONSTRAINT PK_medicineTypeCode
	primary key(medicineTypeCode)
GO

ALTER TABLE Measure
	ADD CONSTRAINT PK_measureCode
	primary key(measureCode)
GO

ALTER TABLE Customer
	ADD CONSTRAINT PK_customerCode
	primary key(customerCode)
GO

ALTER TABLE PaypedReport
	ADD CONSTRAINT PK_paypedReportCode 
	primary key(paypedReportCode)
GO

ALTER TABLE Medicine
	ADD CONSTRAINT PK_medicineCode 
	primary key(medicineCode)
GO

ALTER TABLE MedicineDetails
	ADD CONSTRAINT PK_medicineCode_measureCode 
	primary key(medicineCode,measureCode)
GO

ALTER TABLE Orders
	ADD CONSTRAINT PK_orderCode
	primary key(orderCode)
GO

ALTER TABLE OrderDetails
	ADD CONSTRAINT PK_medicineCode_orderCode_measureCode 
	primary key(medicineCode,orderCode,measureCode)
GO

ALTER TABLE Bill
	ADD CONSTRAINT PK_billCode primary key(billCode)
GO

ALTER TABLE BillDetails
	ADD CONSTRAINT PK_medicineCode_billCode_measureCode
	primary key(medicineCode,billCode,measureCode)
GO

-------------------------------------------------------------------
				-- ADD FOREIGN KEY
-------------------------------------------------------------------

ALTER TABLE Bill
	ADD CONSTRAINT FK_customerCode_Bill
	foreign key(customerCode)
	references Customer(customerCode)
GO

ALTER TABLE Bill
	ADD CONSTRAINT FK_userCode_Bill
	foreign key(userCode)
	references Users(userCode)
GO

ALTER TABLE BillDetails
	ADD CONSTRAINT FK_billCode
	foreign key(billCode)
	references Bill(billCode)
GO

ALTER TABLE BillDetails
	ADD CONSTRAINT FK_measureCode
	foreign key(measureCode)
	references Measure(measureCode)
GO

ALTER TABLE BillDetails
	ADD CONSTRAINT FK_medicineCode_HD
	foreign key(medicineCode)
	references Medicine(medicineCode)
GO

ALTER TABLE Orders
	ADD CONSTRAINT FK_customerCode
	foreign key(customerCode)
	references Customer(customerCode)
GO

ALTER TABLE Orders
	ADD CONSTRAINT FK_userCode_Orders
	foreign key(userCode)
	references Users(userCode)
GO

ALTER TABLE OrderDetails
	ADD CONSTRAINT FK_medicineCode_Orders
	foreign key(medicineCode)
	references Medicine(medicineCode)
GO

ALTER TABLE OrderDetails
	ADD CONSTRAINT FK_orderCode
	foreign key(orderCode)
	references Orders(orderCode)
GO

ALTER TABLE OrderDetails
	ADD CONSTRAINT FK_measureCode_Orders
	foreign key(measureCode)
	references Measure(measureCode)
GO

ALTER TABLE Medicine
	ADD CONSTRAINT FK_medicineTypeCode
	foreign key(medicineTypeCode)
	references MedicineType(medicineTypeCode)
GO

ALTER TABLE Medicine
	ADD CONSTRAINT FK_supplierCode
	foreign key(supplierCode)
	references Supplier(supplierCode)
GO

ALTER TABLE MedicineDetails
	ADD CONSTRAINT FK_medicineCode_Medicine
	foreign key(medicineCode)
	references Medicine(medicineCode)
GO

ALTER TABLE MedicineDetails
	ADD CONSTRAINT FK_measureCode_Measure
	foreign key(measureCode)
	references Measure(measureCode)
GO

ALTER TABLE PaypedReport
	ADD CONSTRAINT FK_billCode_Bill
	foreign key(billCode)
	references Bill(billCode)
GO
-------------------------------------------------------------------
			-- INSERT DATA EXAMPLE FOR TABLE IN DATABASE

-------------------------------------------------------------------
					-- INSERT DATA INTO TABLE Users
-------------------------------------------------------------------
INSERT INTO Users
	VALUES(	'chiennv','chiennv',
			'Nguyen Van Chien','M','Phu Tho',
			'0986255384','chien.nv235@gmail.com',1)
INSERT INTO Users
	VALUES(	'hientv','hientv',
			'Tran Van Hien','M','Bac Ninh',
			'0975382234','tranhien121@gmail.com',1)
INSERT INTO Users
	VALUES(	'accountant','accountant',
			'Dao Trong Duy','A','Hà N?i',
			'0167839433','duydt204@gmail.com',1)
INSERT INTO Users
	VALUES(	'seller','seller',
			'Pham huu tung','S','H?i Phòng',
			'0983686056','tungph@gmail.com',1)
GO

-------------------------------------------------------------------
					-- INSERT DATA INTO TABLE Supplier
-------------------------------------------------------------------
INSERT INTO Supplier
VALUES
	('HAPHACO','HA NOI PHARMACEUTICAL AND MEDICAL JOIN STOCK COMPANY',
	 '2. Hang Bai. Ha Noi','84048258775','840211862778',
	 'hapharco@gmail.com','www.hapharco.com.vn')
INSERT INTO Supplier
VALUES
	('TRAPHACO','TRAPHACO PHARMACEUTICAL JOIN STOCK COMPANY',
	 '75. Yen Ninh. Ba Dinh. Ha Noi','84048430076','840211862777',
	 'traphaco@fpt.com','www.traphaco.com.vn')
INSERT INTO Supplier
VALUES
	('VINPHACO','VINH PHUC PHARMACEUTICAL JOIN STOCK COMPANY',
	 '10. To Hieu. Dong Da. Vinh Yen. Vinh Phuc','840211861233 ',
	 '840211862774','traphaco@fpt.com','www.traphaco.com.vn')
INSERT INTO Supplier
VALUES
	('BAOLONG','VINH PHUC HERB MEDICAL GROUP',
	 '54. Chua Lang. Ha Noi','840437755994 ',
	 '840437755995','sales@balok.com.vn','www.balok.com.vn')
INSERT INTO Supplier
VALUES
	('AlCON','ALCON VIET NAM',
	 '43. Ninh Hiep. Ha Noi','84049781685 ',
	 '84049781684','sales@alconvn.com.vn','www.alcon.com.vn')
INSERT INTO Supplier
VALUES
	('AUSTRAPHARM','AUSTRAPHARM VIET NAM',
	 '73. O Cho Dua. Dong Da. Ha Noi','84049781686 ',
	 '84049781687','sales@austrapharm.com.vn','www.austrapharm.com.vn')
GO

-------------------------------------------------------------------
					-- INSERT DATA INTO TABLE Customer
-------------------------------------------------------------------
INSERT INTO Customer
VALUES
	('HIEN LINH PAHRMACY','Dealers','8404432351','8404432353',
	'hienlinh@gmail.com','38. Cau Dien. Ha Noi','familiar')
INSERT INTO Customer
VALUES
	('VIET CUONG PAHRMACY','Retailers','8404432354','8404432356',
	'vietcuong@gmail.com','128. Vien E. Ha Noi','unfamiliar')
INSERT INTO Customer
VALUES
	('VIET ANH PAHRMACY','Retailers','8404432356','8404432357',
	'vietanh@gmail.com','79. Vien E. Ha Noi','unfamiliar')

INSERT INTO Customer
VALUES
	('DUY HUNG PAHRMACY','Distributors','8404432356','8404432357',
	'duyhung@gmail.com','129. Chua Boc . Vinh Phuc','familiar')

INSERT INTO Customer
VALUES
	('PHUC AN PAHRMACY','Dealers','8404432356','8404432357',
	'phucan@gmail.com','79. Kham Thien. Ha Noi','unfamiliar')
GO

-------------------------------------------------------------------
					-- INSERT DATA INTO TABLE MedicinType
-------------------------------------------------------------------
INSERT INTO MedicineType
	VALUES('Cardiovascular')
INSERT INTO MedicineType
	VALUES('Nervous')
INSERT INTO MedicineType
	VALUES('Digestive')
INSERT INTO MedicineType
	VALUES('Hocmon')
INSERT INTO MedicineType
	VALUES('Cancer')
INSERT INTO MedicineType
	VALUES('Touches the skin')
INSERT INTO MedicineType
	VALUES('Vitamin and Minerals')
INSERT INTO MedicineType
	VALUES('Germicide')
INSERT INTO MedicineType
	VALUES('respiratory')
GO

-------------------------------------------------------------------
					-- INSERT DATA INTO TABLE Measure
-------------------------------------------------------------------
INSERT INTO Measure
VALUES ('Pill')
INSERT INTO Measure
VALUES ('Box')
INSERT INTO Measure
VALUES ('Blisters')
INSERT INTO Measure
VALUES ('Pipe')
INSERT INTO Measure
VALUES ('Bottle')
GO

-------------------------------------------------------------------
					-- INSERT DATA INTO TABLE Medicine
-------------------------------------------------------------------
INSERT INTO Medicine
VALUES ('Aspirin 100mg',1,2)

INSERT INTO Medicine
VALUES ('Dimenhydrinat 50mg',2,2)

INSERT INTO Medicine
VALUES ('Berberin 100mg',1,3)

INSERT INTO Medicine
VALUES ('Bisacodyl',1,3)

INSERT INTO Medicine
VALUES ('Dexamethason 0,5mg',3,4)

GO
-------------------------------------------------------------------
					-- INSERT DATA INTO TABLE MedicineDetails
-------------------------------------------------------------------
INSERT INTO MedicineDetails
VALUES( 1,1,2500,500,'VNB-0825-03','Domestic',
		'Backup Blood for heart & stroke','2010/10/10',
		'Adults: 81 mg-325 mg / day, taken every day or date.'
		)
INSERT INTO MedicineDetails
VALUES( 2,1,2500,500,'VD-1048-06','Domestic',
		'Backup Securities say the train car.','2010/10/10',
		'Adults: 50 - 100 mg take half an hour before you go, then 50 mg / 4 hours.'
		)

INSERT INTO MedicineDetails
VALUES( 3,1,2500,500,'V17-H12-05','Domestic',
		'Road bowel infection. Diarrhea.','2010/10/10',
		'Adults: 4 - 6 Vienna 50 mg or 1 - 2 tablets 100 mg / 2 times x times / day.'
		)
INSERT INTO MedicineDetails
VALUES( 4,1,2500,500,'VNB-1275-02','Domestic',
		'Constipation','2010/10/10',
		'Adults: 50 - 100 mg take half an hour before you go, then 50 mg / 4 hours.'
		)
INSERT INTO MedicineDetails
VALUES( 5,1,2500,500,'VD-1048-06','Domestic',
		'Backup Securities say the train car.','2010/10/10',
		'Pharmacy is located 1 Vienna, 10-40 minutes of time daily.'
		)
GO


-------------------------------------------------------------------
			-- CREATE PROC FOR TABLES
-------------------------------------------------------------------	
					
-------------------------------------------------------------------

				-- CREATE PROC FOR TABLE Users

------------------ CREATE PROC spGetAllUser -----------------------
CREATE PROC spGetAllUser
AS
SELECT * FROM Users
GO

------------------ CREATE PROC spGetNameLogin ---------------------
CREATE PROC spGetNameLogin
AS
SELECT nameLogin FROM Users
GO

------------------ CREATE PROC spGetCodeByName --------------------
CREATE PROC spGetCodeByName
	@nameLogin nvarchar(50)
AS
SELECT userCode FROM Users
WHERE nameLogin = @nameLogin
GO

------------------ CREATE spChangePassword ------------------------
CREATE PROC spChangePassword
(	@userCode int,
	@password nvarchar(20))
AS
UPDATE Users
SET password = @password
WHERE userCode = @userCode
GO

------------------ CREATE PROC spInsertUser -----------------------
CREATE PROC spInsertUser
(   @nameLogin nvarchar(50),
	@password nvarchar(20),
	@fullName nvarchar(100),
	@userTypeCode nvarchar(30),
	@userADDress nvarchar(100),
	@userPhone nvarchar(15),
	@userEmail nvarchar(100),
	@userActive int)
AS
INSERT INTO Users
VALUES(	@nameLogin,@password,
		@fullName,@userTypeCode,
		@userADDress,@userPhone,
		@userEmail,@userActive)
GO

------------------ CREATE PROC spUpdateUser -----------------------
CREATE PROC spUpdateUser
(	@userCode int,
	@nameLogin nvarchar(50),
	@password nvarchar(20),
	@fullName nvarchar(100),
	@userTypeCode nvarchar(30),
	@userADDress nvarchar(100),
	@userPhone nvarchar(15),
	@userEmail nvarchar(100),
	@userActive int)
AS 
UPDATE Users
SET nameLogin = @nameLogin,
	password = @password,
	fullName = @fullName,
	userTypeCode = @userTypeCode,
	userADDress = @userADDress,
	userPhone = @userPhone,
	userEmail = @userEmail,
	userActive = @userActive
WHERE userCode = @userCode
GO

------------------ CREATE PROC spDeleteUser -----------------------
CREATE PROC spDeleteUser
	@nameLogin varchar(100)
AS
DELETE FROM Users
WHERE nameLogin = @nameLogin
GO

-------------------------------------------------------------------

				-- CREATE PROC FOR TABLE Supplier

------------------ CREATE PROC spGetAllSupplier -------------------
CREATE PROC spGetAllSupplier
AS
SELECT * FROM Supplier
GO

------------------ CREATE PROC spGetSupplierName ------------------
CREATE PROC spGetSupplierName
AS
SELECT supplierName FROM Supplier
GO

------------------ CREATE PROC spSearchSupplierByName -------------
CREATE PROC spSearchSupplierByName
	@supplierName nvarchar(100)
AS
SELECT supplierCode,supplierName,
	   supplierAddress,supplierPhone,supplierEmail
FROM Supplier
WHERE supplierName LIKE '%'+@supplierName+'%'
GO

------------------ CREATE PROC spSearchSupplierByAddress ----------
CREATE PROC spSearchSupplierByAddress
	@supplierAddress nvarchar(100)
AS
SELECT supplierCode,supplierName,
	   supplierAddress,supplierPhone,supplierEmail
FROM Supplier
WHERE 
	  supplierAddress LIKE '%'+@supplierAddress+'%'
GO


------------------ CREATE PROC spSearchAdvancedSupplier -----------
CREATE PROC spSearchAdvancedSupplier
(	@supplierName nvarchar(100),
	@supplierAddress nvarchar(100))
AS
SELECT supplierCode,supplierName,
	   supplierAddress,supplierPhone,supplierEmail
FROM Supplier
WHERE supplierName LIKE '@'+@supplierName+'@'
	  AND supplierAddress LIKE '%'+@supplierAddress+'@'
GO


------------------ CREATE PROC spInsertSupplier--------------------
CREATE PROC spInsertSupplier
(	@supplierName nvarchar(100),
	@fullName nvarchar(400),
	@supplierADDress nvarchar(400),
	@supplierPhone nvarchar(30),
	@supplierFax nvarchar(30),
	@supplierEmail nvarchar(200),
	@supplierWebsite nvarchar(200))
AS
INSERT INTO Supplier 
VALUES(	@supplierName,
		@fullName,@supplierADDress,
		@supplierPhone,@supplierFax,
		@supplierEmail,@supplierWebsite)
GO

------------------ CREATE PROC spUpdateSupplier -------------------
CREATE PROC spUpdateSupplier
(	@supplierCode int,
	@supplierName nvarchar(100),
	@fullName nvarchar(400),
	@supplierADDress nvarchar(400),
	@supplierPhone nvarchar(30),
	@supplierFax nvarchar(30),
	@supplierEmail nvarchar(200),
	@supplierWebsite nvarchar(200))
AS
UPDATE Supplier
SET supplierName = @supplierName,
	fullName = @fullName,
	supplierADDress = @supplierADDress,
	supplierPhone = @supplierPhone,
	supplierFax = @supplierFax,
	supplierEmail = @supplierEmail,
	supplierWebsite = @supplierWebsite
WHERE supplierCode = @supplierCode
GO

------------------ CREATE PROC spDeleteSupplier -------------------
CREATE PROC spDeleteSupplier
	@supplierName nvarchar(100)
AS
DELETE Supplier
WHERE supplierName = @supplierName
GO

-------------------------------------------------------------------

				-- CREATE PROC FOR TABLE Customer

------------------ CREATE PROC spGetAllCustomer -------------------
CREATE PROC spGetAllCustomer
AS 
SELECT * FROM Customer
GO

------------------ CREATE PROC spCustomerName ---------------------
CREATE PROC spCustomerName
AS
SELECT customerName FROM Customer
GO

------------------ CREATE PROC spSearchCustomerByName -------------
CREATE PROC spSearchCustomerByName
(	@customerRelationship nvarchar(100),
	@customerName nvarchar(100))
AS
SELECT customerCode,customerName,customerType,
	   customerPhone,customerAddress,
	   customerRelationship
FROM Customer
WHERE customerRelationship = @customerRelationship
	  AND customerName LIKE '%'+@customerName+'%'
GO


------------------ CREATE PROC spSearchCustomerByType -------------
CREATE PROC spSearchCustomerByType
(	@customerRelationship nvarchar(100),
	@customerType nvarchar(100))
AS
SELECT customerCode,customerName,customerType,
	   customerPhone,customerAddress,
	   customerRelationship
FROM Customer
WHERE customerRelationship = @customerRelationship
	  AND customerType = @customerType
GO

------------------ CREATE PROC spSearchCustomerByRelation ---------
CREATE PROC spSearchCustomerByRelation
	@customerRelationship nvarchar(100)
AS
SELECT customerCode,customerName,customerType,
	   customerPhone,customerAddress,
	   customerRelationship
FROM Customer
WHERE customerRelationship = @customerRelationship
GO

------------------ CREATE PROC spSearchCustomerByAddress ----------
CREATE PROC spSearchCustomerByAddress
(	@customerRelationship nvarchar(100),
	@customerAddress nvarchar(100))
AS
SELECT customerCode,customerName,customerType,
	   customerPhone,customerAddress,
	   customerRelationship
FROM Customer
WHERE  customerRelationship = @customerRelationship
	   AND customerAddress LIKE '%'+@customerAddress+'%'
GO

------------------ CREATE PROC spSearchCustomerByNameAndType ------
CREATE PROC spSearchCustomerByNameAndType
(	@customerRelationship nvarchar(100),
	@customerName nvarchar(100),
	@customerType nvarchar(100)
)
AS
SELECT customerCode,customerName,customerType,
	   customerPhone,customerAddress,
	   customerRelationship
FROM Customer
WHERE  customerRelationship = @customerRelationship
	   AND customerName LIKE '%'+@customerName+'%'
	   AND customerType LIKE '%'+@customerType+'%'
GO


------------------ CREATE PROC spSearchCustomerByNameAndAddress ----
CREATE PROC spSearchCustomerByNameAndAddress
(	@customerRelationship nvarchar(100),
	@customerName nvarchar(100),
	@customerAddress nvarchar(100)
)
AS
SELECT customerCode,customerName,customerType,
	   customerPhone,customerAddress,
	   customerRelationship
FROM Customer
WHERE  customerRelationship = @customerRelationship
	   AND customerName LIKE '%'+@customerName+'%'
	   AND customerAddress LIKE '%'+@customerAddress+'%'
GO

------------------ CREATE PROC spSearchCustomerByTypeAndAddress ----
CREATE PROC spSearchCustomerByTypeAndAddress
(	@customerRelationship nvarchar(100),
	@customerType nvarchar(100),
	@customerAddress nvarchar(100)
)
AS
SELECT customerCode,customerName,customerType,
	   customerPhone,customerAddress,
	   customerRelationship
FROM Customer
WHERE  customerRelationship = @customerRelationship
	   AND customerType LIKE '%'+@customerType+'%'
	   AND customerAddress LIKE '%'+@customerAddress+'%'
GO

------------------ CREATE PROC spSearchAdvancedCustomer -----------
CREATE PROC spSearchAdvancedCustomer
(	@customerRelationship nvarchar(50),
	@customerName nvarchar(100),
	@customerType nvarchar(50),
	@customerAddress nvarchar(100))
AS
SELECT customerCode,customerName,customerType,
	   customerPhone,customerAddress,
	   customerRelationship
FROM Customer
WHERE (customerRelationship = @customerRelationship
	  AND customerType = @customerType)
	  AND (customerName LIKE '%'+@customerName+'%' 
			or customerAddress LIKE '%'+@customerAddress+'%')
GO


------------------ CREATE PROC spInsertCustomer -------------------
CREATE PROC spInsertCustomer
(	@customerName nvarchar(400),
	@customerType nvarchar(200),
	@customerPhone nvarchar(30),
	@customerFax nvarchar(30),
	@customerEmail nvarchar(100),
	@customerADDress nvarchar(400),
	@customerRelationship nvarchar(100))
AS
INSERT INTO Customer
VALUES(	@customerName,@customerType,
	@customerPhone,@customerFax,
	@customerEmail,@customerADDress,
	@customerRelationship)
GO

------------------ CREATE PROC spUpdateCustomer -------------------
CREATE PROC spUpdateCustomer
(	@customerCode int,
	@customerName nvarchar(400),
	@customerType nvarchar(200),
	@customerPhone nvarchar(30),
	@customerFax nvarchar(30),
	@customerEmail nvarchar(100),
	@customerADDress nvarchar(400),
	@customerRelationship nvarchar(100))
AS
UPDATE Customer
SET customerName = @customerName,
	customerType = @customerType,
	customerPhone = @customerPhone,
	customerFax = @customerFax,
	customerEmail = @customerEmail,
	customerADDress = @customerADDress,
	customerRelationship = @customerRelationship
WHERE customerCode = @customerCode
GO

------------------ CREATE PROC spDeleteCustomer -------------------
CREATE PROC spDeleteCustomer
@customerName nvarchar(100)
AS
DELETE Customer
WHERE customerName = @customerName
GO

-------------------------------------------------------------------

				-- CREATE PROC FOR TABLE MedicineType

------------------ CREATE PROC spInsertMedicineType ---------------
CREATE PROC spInsertMedicineType
	@medicineTypeName nvarchar(100)
AS
INSERT INTO MedicineType
VALUES(	@medicineTypeName)
GO

------------------ CREATE PROC spGetAllMedicineType ---------------
CREATE PROC spGetAllMedicineType
AS
SELECT * FROM MedicineType
GO

------------------ CREATE PROC spGetMedicineTypeName --------------
CREATE PROC spGetMedicineTypeName
AS
SELECT medicineTypeName FROM MedicineType
GO

------------------ CREATE PROC spGetMedicineTypeNameByCode --------
CREATE PROC spGetMedicineTypeNameByCode
	@medicineTypeCode int
AS
SELECT medicineTypeName FROM MedicineType
WHERE medicineTypeCode = @medicineTypeCode
GO

------------------ CREATE PROC spGetMedicineTypeCodeByName --------
CREATE PROC spGetMedicineTypeCodeByName
	@medicineTypeName nvarchar(100)
AS
SELECT medicineTypeCode FROM MedicineType
WHERE medicineTypeName = @medicineTypeName
GO

------------------ CREATE PROC spUpdateMedicineType ---------------
CREATE PROC spUpdateMedicineType
(	@medicineTypeCode int,
	@medicineTypeName nvarchar(100))
AS
UPDATE MedicineType
SET medicineTypeName = @medicineTypeName
WHERE medicineTypeCode = @medicineTypeCode
GO

------------------ CREATE PROC spDeleteMedicineType ---------------
CREATE PROC spDeleteMedicineType
	@medicineTypeName nvarchar(100)
AS
DELETE MedicineType
WHERE medicineTypeName = @medicineTypeName;
GO

-------------------------------------------------------------------

				-- CREATE PROC FOR TABLE Measure

------------------ CREATE PROC spInsertMeasure ---------------
CREATE PROC spInsertMeasure
	@measureName nvarchar(100)
AS
INSERT INTO Measure
VALUES(	@measureName)
GO

------------------ CREATE PROC spGetAllMeasure ---------------
CREATE PROC spGetAllMeasure
AS
SELECT * FROM Measure
GO

------------------ CREATE PROC spGetMeasureName --------------
CREATE PROC spGetMeasureName
AS
SELECT measureName FROM Measure
GO

------------------ CREATE PROC spGetMeasureCodeByName --------
CREATE PROC spGetMeasureCodeByName
	@measureName nvarchar(50)
AS
SELECT measureCode FROM Measure
WHERE measureName = @measureName
GO

------------------ CREATE PROC spUpdateMeasure ---------------
CREATE PROC spUpdateMeasure
(	@measureCode int,
	@measureName nvarchar(100))
AS
UPDATE Measure
SET measureName = @measureName
WHERE measureCode = @measureCode
GO

------------------ CREATE PROC spDeleteMeasure ---------------
CREATE PROC spDeleteMeasure
	@measureName nvarchar(100)
AS
DELETE Measure
WHERE measureName = @measureName;
GO


-------------------------------------------------------------------

				-- CREATE PROC FOR TABLE Medicine, MedicineDetails

------------------ CREATE PROC spInsertMedicine ---------------
CREATE PROC spInsertMedicine
(	
	@medicineName nvarchar(100),
	@medicineTypeCode int,
	@supplierCode int
	)
AS
INSERT INTO Medicine
VALUES(	@medicineName,
		@medicineTypeCode,
		@supplierCode)
GO

------------------ CREATE PROC spGetAllMedicine ---------------
CREATE PROC spGetAllMedicine
AS
SELECT * FROM Medicine
GO

------------------ CREATE PROC spGetMedicineByCode ------------
CREATE PROC spGetMedicineByCode
	@medicineCode int
AS
SELECT * FROM Medicine
WHERE medicineCode = @medicineCode
GO

------------------ CREATE VIEW vGetMedicineForOrder -----------
CREATE VIEW vGetMedicineForOrder
AS
SELECT  me.medicineCode,medicineName,medicineTypeName,
		measureName,pricePerUnit
FROM	Medicine me,MedicineDetails md,
		Measure ms,MedicineType mt
WHERE	me.medicineCode = md.medicineCode
	    AND	md.measureCode = ms.measureCode
		AND me.medicineTypeCode = mt.medicineTypeCode
GO

------------------ CREATE PROC vspGetMedicineByCodeForOrder---
CREATE PROC vspGetMedicineByCodeForOrder
	@medicineCode int
AS
SELECT * FROM vGetMedicineForOrder
WHERE medicineCode = @medicineCode
GO

------------------ CREATE PROC spGetMedicineName --------------
CREATE PROC spGetMedicineName
AS
SELECT medicineName FROM Medicine
GO

------------------ CREATE PROC spUpdateMedicine ---------------
CREATE PROC spUpdateMedicine
(	@medicineCode int,
	@medicineName nvarchar(100),
	@medicineTypeCode int,
	@supplierCode int)
AS
UPDATE Medicine
SET medicineName = @medicineName,
	medicineTypeCode = @medicineTypeCode,
	supplierCode = @supplierCode
WHERE medicineCode = @medicineCode
GO


------------------ CREATE TRIGGER tgDeleteMedicine ------------
CREATE TRIGGER tgDeleteMedicine ON Medicine
INSTEAD OF DELETE
AS
BEGIN
	DELETE FROM MedicineDetails WHERE medicineCode IN 
			(SELECT medicineCode FROM deleted)
	DELETE FROM Medicine WHERE medicineCode IN 
			(SELECT medicineCode FROM deleted)
END
GO


------------------ CREATE PROC spDeleteMedicine ---------------
CREATE PROC spDeleteMedicine
	@medicineName nvarchar(100)
AS
DELETE Medicine
WHERE medicineName = @medicineName
GO

-------------------------------------------------------------------

				-- CREATE PROC FOR TABLE MedicineDetails

------------------ CREATE PROC spInsertMedicineDetails ------------
CREATE PROC spInsertMedicineDetails
(	@medicineCode int,
	@measureCode int,
	@pricePerUnit float,
	@avaiableAmount int,
	@registerNumber nvarchar(100),
	@Origin nvarchar(60),
	@used nvarchar(200),
	@termsOfUse datetime,
	@userGuide nvarchar(200)
	)
AS
INSERT INTO MedicineDetails
VALUES(	@medicineCode,@measureCode,
		@pricePerUnit,@avaiableAmount,
		@registerNumber,@Origin,
		@used,@termsOfUse,
		@userGuide
		)
GO

------------------ CREATE PROC spGetAllMedicineDetails ------------
CREATE PROC spGetAllMedicineDetails
AS
SELECT * FROM MedicineDetails
GO


------------------ CREATE PROC spGetMedicineDetailsByCode ---------
CREATE PROC spGetMedicineDetailsByCode
	@medicineCode int
AS
SELECT * FROM MedicineDetails
WHERE medicineCode = @medicineCode
GO


------------------ CREATE PROC spUpdateMedicineDetails ------------
CREATE PROC spUpdateMedicineDetails
(	@medicineCode int,
	@measureCode int,
	@pricePerUnit float,
	@avaiableAmount int,
	@registerNumber nvarchar(100),
	@Origin nvarchar(60),
	@used nvarchar(200),
	@termsOfUse datetime,
	@userGuide nvarchar(200)
	)
AS UPDATE MedicineDetails
SET measureCode = @measureCode,
	pricePerUnit = @pricePerUnit,
	avaiableAmount = @avaiableAmount,
	registerNumber = @registerNumber,
	Origin = @Origin,
	used = @used,
	termsOfUse = @termsOfUse,
	userGuide = @userGuide
WHERE medicineCode = @medicineCode
GO

------------------ CREATE PROC spDeleteMedicineDetails -----------
CREATE PROC spDeleteMedicineDetails
	@medicineCode int
AS
DELETE MedicineDetails
WHERE medicineCode = @medicineCode
GO



--**************************************************************--
------------------ CREATE VIEW	vspMedicineDetails ---------------
CREATE VIEW vMedicines
AS
SELECT	me.medicineCode,medicineName,
		medicineTypeName,ms.measureName,
		pricePerUnit,avaiableAmount,
		Origin,supplierName
FROM Medicine me,MedicineDetails md,
	 Measure ms,MedicineType mt,Supplier s
WHERE me.medicineCode = md.medicineCode
	  AND me.medicineTypeCode = mt.medicineTypeCode
	  AND ms.measureCode = md.measureCode
	  AND me.supplierCode = s.supplierCode
GO

------------------ CREATE PROC vspGetAllMedicines ----------------
CREATE PROC vspGetAllMedicines
AS
SELECT * FROM vMedicines
GO

------------------ CREATE PROC	vspSearchMedicineByOrigin --------
CREATE PROC vspSearchMedicineByOrigin
	@Origin nvarchar(50)
AS
SELECT * FROM vMedicines
WHERE Origin = @Origin
GO

------------------ CREATE PROC	vspSearchMedicineByName ----------
CREATE PROC vspSearchMedicineByName
(	@Origin nvarchar(50),
	@medicineName nvarchar(100))
AS
SELECT * FROM vMedicines
WHERE Origin = @Origin AND medicineName LIKE '%'+@medicineName+'%'
GO

------------------ CREATE PROC	vspSearchMedicineByType ----------
CREATE PROC vspSearchMedicineByType
(	@Origin nvarchar(50),
	@medicineTypeName nvarchar(50))
AS
SELECT * FROM vMedicines
WHERE Origin = @Origin AND medicineTypeName LIKE '%'+@medicineTypeName+'%'
GO

------------------ CREATE PROC	vspSearchMedicineBySupplier ------
CREATE PROC vspSearchMedicineBySupplier
(	@Origin nvarchar(50),
	@supplierName nvarchar(100))
AS
SELECT * FROM vMedicines
WHERE Origin = @Origin AND supplierName = @supplierName
GO

------------------ CREATE PROC vspSearchMedicineByNameAndType ----
CREATE PROC vspSearchMedicineByNameAndType
(	@Origin nvarchar(50),
	@medicineName nvarchar(100),
	@medicineTypeName nvarchar(100))
AS
SELECT * FROM vMedicines
WHERE (Origin = @Origin AND medicineTypeName = @medicineTypeName)
	  AND medicineName LIKE '%'+@medicineName+'%'
GO

------------------ CREATE PROC vspSearchMedicineByTypeAndSupplier --
CREATE PROC vspSearchMedicineByTypeAndSupplier
(	@Origin nvarchar(50),
	@medicineTypeName nvarchar(100),
	@supplierName nvarchar(100))
AS
SELECT * FROM vMedicines
WHERE (Origin = @Origin AND medicineTypeName = @medicineTypeName)
	  AND supplierName = @supplierName
GO

------------------ CREATE PROC vspSearchMedicineByNameAndSupplier --
CREATE PROC vspSearchMedicineByNameAndSupplier
(	@Origin nvarchar(50),
	@medicineName nvarchar(100),
	@supplierName nvarchar(100))
AS
SELECT * FROM vMedicines
WHERE (Origin = @Origin AND supplierName = @supplierName)
	  AND medicineName LIKE '%'+@medicineName+'%'
GO

-------------------------------------------------------------------
-------------------------------------------------------------------

				-- CREATE PROC FOR TABLE Orders
------------------ CREATE PROC spInsertOrders ---------------------
CREATE PROC spInsertOrders
(	@customerCode int,
	@dateOrder datetime,
	@userCode int,
	@addressToDeliver nvarchar(100))
AS
INSERT INTO Orders
VALUES(@customerCode,@dateOrder,@userCode,@addressToDeliver,0)
GO

------------------ CREATE PROC spGetAllOrders ---------------------
CREATE PROC spGetAllOrders
AS
SELECT * FROM Orders
GO

--------------------------------------------------------------
create view vOrderDetails
as
select o.orderCode,o.medicineCode,medicineName,medicineTypeName,measureName,pricePerUnit,quantity
from vGetMedicineForOrder v, OrderDetails o
where o.medicineCode = v.medicineCode

go
---------------------------------------------------------------
create proc vspOrderDetailsByOrderCode
@orderCode int
as
select * from vOrderDetails
where orderCode = @orderCode

go
---------------------------------------------------------------
-- tao view chua nhung hoa don chua ton tao trong bang chi tiet
create view vOrderNotDetails
as
select o.orderCode,customerCode,dateOrder,addressToDeliver
from Orders o left join OrderDetails od
on o.orderCode = od.orderCode
where o.orderCode not in (select orderCode from OrderDetails)
go
-----------------------------------------------------------------
-- create proc vspGetOrderNotDetails
create proc vspGetOrderNotDetails
as
select * from vOrderNotDetails

go
------------------------------------------------------------------
-- create proc spDeleteOrder
create proc spDeleteOrder
	@orderCode int
as
delete from Orders
where orderCode = @orderCode
go


-------------------------------------------------------------------

				-- CREATE PROC FOR TABLE OrdersDetails
------------------ CREATE PROC spInsertOrderDetails ---------------
Create proc spInsertOrderDetails
(
	@orderCode int,
	@medicineCode int,
	@measureCode int,
	@quantity int
)
as
insert into orderDetails
values(@orderCode,@medicineCode,@measureCode,@quantity)
go
---------------------------------------------------------------
create proc spUpdatePriceForOrder
	@orderCode int,
	@price float
as
update Orders
set price = @price
where orderCode = @orderCode
go
---------------------------------------------------------------
-- tao thu tuc update avaiableAmount cho bang medicineDetails
create proc spUpdateAvaiableAmountForMedicineDetails
@medicineCode int,
@avaiableAmount int
as
update MedicineDetails
set avaiableAmount =  avaiableAmount - @avaiableAmount
where medicineCode = @medicineCode
go
---------------------------------------------------------------
go
---------------------------------------------------------------
create proc spGetAvaiableAmountByCode
@medicneCode int
as
select avaiableAmount from MedicineDetails
where medicineCode = @medicneCode
---------------------------------------------------------------
go

------------------ CREATE TRIGGER tgDeleteOrders ------------
CREATE TRIGGER tgDeleteOrders ON Orders
INSTEAD OF DELETE
AS
BEGIN
	DELETE FROM OrderDetails WHERE orderCode IN 
			(SELECT orderCode FROM deleted)
	DELETE FROM Orders WHERE orderCode IN 
			(SELECT orderCode FROM deleted)
END
GO

--------------------------------------------------------------
create proc spGetOrderByCustomerCode
	@customerCode int
as
select * from Orders
where customerCode = @customerCode
go
---------------------------------------------------------------


create proc spGetOrderDetailByOrderCode
@orderCode int
as
select * from OrderDetails
where orderCode = @orderCode
go

-----phan nay de test
---------------------------------------------------------------
-- tao cac thu tuc cho bang bill
create proc spInsertNewBill
(	@billType nvarchar(50),
	@customerCode int,
	@addressToDeliver nvarchar(100),
	@dateStart datetime,
	@expiredTime datetime,
	@tax float,
	@status nvarchar(50),
	@userCode int
)
as
insert into Bill
values(@billType,@customerCode,@addressToDeliver,
		@dateStart,@expiredTime,@tax,0,@status,@userCode)
go
--------------------------------------------------------------
create proc spGetAllBill
as
select * from Bill
go
--------------------------------------------------------------
-- tao view chua nhung bill chua ton tao trong bang chi tiet
create view vBillNotDetails
as
select b.billCode,billType,customerCode,dateStart,expiredTime,tax,addressToDeliver
from Bill b left join BillDetails bd
on b.billCode = bd.billCode
where b.billCode not in (select billCode from BillDetails)
go
--------------------------------------------------------------
create proc vspGetAllBillNotDetails
as
select * from vBillNotDetails
go
----------------------------------------------------------------
create proc spInsertBillDetails
(	@billCode int,
	@medicineCode int,
	@measureCode int,
	@quantity int
)
as
insert into billDetails
values(@billCode,@medicineCode,@measureCode,@quantity)
go
---------------------------------------------------------------
create proc spDeleteBill
@billCode int
as
delete bill
where billCode=@billCode

---------------------------------------------------------------
go
create proc spUpdatePriceForBill
	@billCode int,
	@price float
as
update Bill
set price = @price
where billCode = @billCode
go
---------------------------------------------------------------
create view vBillsWaitting
as
select billCode,customerCode,billType,price,status
from Bill
where status ='waitting'
go
---------------------------------------------------------------
create proc spGetAllBillWaitting 
@customerCode int
as
select * from vBillsWaitting
where customerCode = @customerCode
go
-------------------------------------------------------------
go
------------------------------------------------------------
create proc spGetPayedMoney
@billCode int
as
select sum(payedmoney)
from bill b, paypedReport pr
where b.billCode = pr.billCode
	and b.billCode = 2
go
------------------------------------------------------------
create proc spInsertPaypedReport
(	@billCode int,
	@datePay datetime,
	@payedMoney float	
)
as
insert into PaypedReport
values(@billCode,@datePay,@payedMoney)
go
-----------------------------------------------------------
create proc spUpdateStatusForBill
(	@billCode int,
	@status nvarchar(50)
)
as
update Bill
set status = @status
where billCode = @billCode
go
------------------------------------------------------------
create view vBillWaitting
as
select b.billType,customerName,customerRelationship,expiredTime,price,status,fullName
from bill b,Customer c,users u
where	b.customerCode = c.customerCode
		and b.userCode = u.userCode
		and status = 'waitting'
go
------------------------------------------------------------
create proc vspGetAllBillWaitting
as
select * from vBillWaitting
go
------------------------------------------------------------
create view vBillComplete
as
select	b.billCode,billType,customerName,customerRelationship,
		expiredTime,price,status,fullName
from bill b,Customer c,users u
where	b.customerCode = c.customerCode
		and b.userCode = u.userCode
		and status = 'complete'
go
-------------------------------------------------------------
create proc vspGetAllBillComplete
as
select * from vBillComplete
go
----------------------------------------------------------------------
create view vBillOverdue
as
select * from vBillWaitting
where expiredTime <  getdate()
go
---------------------------------------------------------------------
create proc vspGetAllBillOverdue
as
select * from vBillOverdue
go

---------------------------------------------------------------------

------------------ CREATE TRIGGER tgDeleteBill ------------
CREATE TRIGGER tgDeleteBill ON Bill
INSTEAD OF DELETE
AS
BEGIN
	DELETE FROM BillDetails WHERE billCode IN 
			(SELECT billCode FROM deleted)
	DELETE FROM PaypedReport WHERE billCode IN 
			(SELECT billCode FROM deleted)
	DELETE FROM Bill WHERE billCode IN 
			(SELECT billCode FROM deleted)
END
GO
---------------------------------------------------------------------
