/********************************* GROUP MEMBERS *********************************
/ This is a SQL Query that is used for creating tables in the project initially.
/---------------------------------------------------------------------------------
/------ ID ------------ NAME SURNAME ------------------- MAIL --------------------
/---------------------------------------------------------------------------------
/-- 20761913234 -- Burak Güçlü				-- burak.guclu@tedu.edu.tr
/-- 11782105296 -- Hüseyin Anıl Günay		-- hanil.gunay@tedu.edu.tr
/-- 87987987987 -- Gizem Yüksel				-- gizem.yuksel@tedu.edu.tr
/-- 45654654654 -- Zeynep Bakanoğulları 	-- zeynep.bakanogullari@tedu.edu.tr
/*********************************************************************************/
SET FOREIGN_KEY_CHECKS = 0;
SET SQL_SAFE_UPDATES = 0;
DROP TABLE if exists Author;
DROP TABLE if exists Book;
DROP TABLE if exists Lecture;
DROP TABLE if exists Librarian;
DROP TABLE if exists Publisher;
DROP TABLE if exists Student;
DROP TABLE if exists Teacher;
SET FOREIGN_KEY_CHECKS = 1;



/******************* BOOK TABLE **********************/
CREATE TABLE Book (
  Title VARCHAR(255),
  ISBN VARCHAR(15) PRIMARY KEY,
  Num_of_Pages INT,
  Year INT,
  Date DATE,
  Type VARCHAR(50),
  Department VARCHAR(100),
  Author_Name VARCHAR(255),
  Publisher_Name VARCHAR(100),
  Librarian_ID VARCHAR(15),
  Teacher_ID VARCHAR(15),
  Student_ID VARCHAR(15)
);
/******************** BOOK TABLE *********************/

/******************** AUTHOR TABLE *********************/
CREATE TABLE Author (
  Name VARCHAR(255) PRIMARY KEY,
  Gender VARCHAR(10),
  Date_of_Birth DATE,
  Num_of_Books INT,
  Name_Publisher VARCHAR(100)
);
/******************** AUTHOR TABLE *********************/

/******************** STUDENT TABLE *********************/
CREATE TABLE Student (
  Name VARCHAR(255),
  ID VARCHAR(15) PRIMARY KEY,
  Department VARCHAR(100),
  ID_Lecture VARCHAR(15),
  ISBN_Book VARCHAR(15),
  Date_of_Birth DATE,
  Gender VARCHAR(10)
);
/******************** STUDENT TABLE *********************/

/******************** LECTURE TABLE *********************/
CREATE TABLE Lecture (
  ID VARCHAR(15) PRIMARY KEY,
  Title VARCHAR(255),
  Num_of_Hours_Per_Week INT,
  Credits INT,
  Department VARCHAR(100)
  );
/******************** LECTURE TABLE *********************/

/******************** TEACHER TABLE *********************/
CREATE TABLE Teacher (
  Name VARCHAR(255),
  ID VARCHAR(15) PRIMARY KEY,
  Department VARCHAR(100),
  ID_Lecture VARCHAR(15),
  ISBN_Book VARCHAR(15),
  Date_of_Birth DATE,
  Gender VARCHAR(10)
);
/******************** TEACHER TABLE *********************/

/******************** LIBRARIAN TABLE *********************/
CREATE TABLE Librarian (
    ID VARCHAR(15) PRIMARY KEY,
    Name VARCHAR(100),
    Date_of_Birth VARCHAR(100),
    Gender VARCHAR(50)
);
/******************** LIBRARIAN TABLE *********************/

/******************** PUBLISHER TABLE *********************/
CREATE TABLE Publisher (
    Name VARCHAR(100) PRIMARY KEY,
    Address VARCHAR(100),
    Type VARCHAR(50)
);
/******************** PUBLISHER TABLE *********************/





/******************** BOOK FOREIGN KEYS *********************/
ALTER TABLE Book
ADD FOREIGN KEY (Librarian_ID) REFERENCES Librarian (ID);
ALTER TABLE Book
ADD FOREIGN KEY (Teacher_ID) REFERENCES Teacher (ID);
ALTER TABLE Book
ADD FOREIGN KEY (Author_Name) REFERENCES Author (Name);
ALTER TABLE Book
ADD FOREIGN KEY (Publisher_Name) REFERENCES Publisher (Name);
ALTER TABLE Book
ADD FOREIGN KEY (Student_ID) REFERENCES Student (ID);
/******************** BOOK FOREIGN KEYS *********************/

/******************** AUTHOR FOREIGN KEYS *********************/
ALTER TABLE Author
ADD FOREIGN KEY (Name_Publisher) REFERENCES Publisher (Name);
/******************** AUTHOR FOREIGN KEYS *********************/

/******************** TEACHER FOREIGN KEYS *********************/
ALTER TABLE Teacher
ADD FOREIGN KEY (ID_Lecture) REFERENCES Lecture (ID);
ALTER TABLE Teacher
ADD FOREIGN KEY (ISBN_Book) REFERENCES Book (ISBN);
/******************** TEACHER FOREIGN KEYS *********************/

/******************** STUDENT FOREIGN KEYS *********************/
ALTER TABLE Student
ADD FOREIGN KEY (ID_Lecture) REFERENCES Lecture (ID);
ALTER TABLE Student
ADD FOREIGN KEY (ISBN_Book) REFERENCES Book (ISBN);
/******************** STUDENT FOREIGN KEYS *********************/





/******************** PUBLISHER VALUE INSERTION *********************/
INSERT INTO Publisher (Name, Address, Type)
VALUES
('ABC Publications', '123 Main Street', 'Education'),
('XYZ Books', '456 Elm Avenue', 'Textbook'),
('EFG Publishing', '789 Oak Road', 'Fiction'),
('123 Publishers', '567 Pine Street', 'Science'),
('LMN Press', '890 Cedar Lane', 'History'),
('PQR Books', '901 Maple Avenue', 'Biography'),
('UVW Publications', '234 Cherry Lane', 'Art'),
('RST Publishers', '345 Walnut Street', 'Business'),
('GHI Press', '678 Oakwood Drive', 'Health'),
('JKL Books', '789 Elmwood Avenue', 'Technology'),
('Sunrise Publications', '123 Main Street'	,	'Fiction')	,
('Moonlight Books'	, '456 Elm Avenue'	, 'Fiction')	,
('Star Publishing'	,	'789 Oak Road'	,'Fiction')	,
('Galaxy Press'	,'567 Pine Street'	,'Fiction')	,
('Supreme Publishers'	,'890 Cedar Lane'	,'Fiction'	)	,
('Enlighten Books'	,'901 Maple Avenue'	,'Fiction'	)	,
('Wonderful Publications'	,'234 Cherry Lane'	,'Fiction'	)	,
('Majestic Press'	,'345 Walnut Street'	,'Fiction')	,
('Eternal Publishers'	,'678 Oakwood Drive'	,'Classical Literature')	,
('Legendary Books'	,'789 Elmwood Avenue'	,'Drama');
/******************** PUBLISHER VALUE INSERTION *********************/

/******************** AUTHOR VALUE INSERTION *********************/
INSERT INTO Author (Name, Gender, Date_of_Birth, Num_of_Books, Name_Publisher)
VALUES
('John Smith', 'Male', '1980-02-15', 2, 'ABC Publications'),
('Emily Johnson', 'Female', '1992-07-08', 1, 'XYZ Books'),
('Michael Davis', 'Male', '1985-12-10', 5, 'EFG Publishing'),
('Sophia Wilson', 'Female', '1998-05-22', 3, 'XYZ Books'),
('David Thompson', 'Male', '1977-09-03', 4, 'ABC Publications'),
('Olivia Miller', 'Female', '1991-11-18', 2, 'LMN Press'),
('Daniel Anderson', 'Male', '1982-04-27', 6, 'PQR Books'),
('Ava Martinez', 'Female', '1995-08-05', 3, 'UVW Publications'),
('William Harris', 'Male', '1979-01-12', 2, 'ABC Publications'),
('Isabella Taylor', 'Female', '1987-06-25', 4, 'JKL Books'),
('F. Scott Fitzgerald'	,	 'Male'	,	 '1896-09-24'	,	1	,	 'Sunrise Publications')	,
('Harper Lee'	,	 'Female'	,	 '1926-04-28'	,	1	,	 'Moonlight Books')	,
('George Orwell'	,	 'Male'	,	 '1903-06-25'	,	1	,	 'Star Publishing')	,
('Jane Austen'	,	 'Female'	,	 '1775-12-16'	,	1	,	 'Galaxy Press')	,
('J.D. Salinger'	,	 'Male'	,	 '1919-01-01'	,	1	,	 'Supreme Publishers')	,
('Virginia Woolf'	,	 'Female'	,	 '1882-01-25'	,	1	,	 'Enlighten Books')	,
('Aldous Huxley'	,	 'Male'	,	 '1894-07-26'	,	1	,	 'Wonderful Publications')	,
('Herman Melville'	,	 'Male'	,	 '1819-08-01'	,	1	,	 'Majestic Press')	,
('Homer'	,	 'Unknown'	,	 '1021-04-05'	,	1	,	 'Eternal Publishers')	,
('William Shakespeare'	,	 'Male'	,	 '1564-04-26'	,	1	,	 'Legendary Books');
/******************** AUTHOR VALUE INSERTION *********************/

/******************** LIBRARIAN VALUE INSERTION *********************/
INSERT INTO Librarian (Name, ID, Date_of_Birth, Gender)
VALUES
    ('Emma Johnson', 'LS011', '1984-07-15', 'Female'),
    ('James Wilson', 'LS012', '1976-02-10', 'Male'),
    ('Sophie Davis', 'LS013', '1990-11-28', 'Female'),
    ('Benjamin Thompson', 'LS014', '1988-09-22', 'Male'),
    ('Lily Anderson', 'LS015', '1983-04-05', 'Female'),
    ('Samuel Miller', 'LS016', '1979-12-18', 'Male'),
    ('Chloe Martinez', 'LS017', '1994-08-03', 'Female'),
    ('Daniel Harris', 'LS018', '1982-01-25', 'Male'),
    ('Grace Taylor', 'LS019', '1997-05-17', 'Female'),
    ('Henry Smith', 'LS020', '1986-03-08', 'Male');
/******************** LIBRARIAN VALUE INSERTION *********************/

/******************** LECTURE VALUE INSERTION *********************/
INSERT INTO Lecture (ID, Title, Num_of_Hours_Per_Week, Credits, Department)
VALUES
(1, 'Introduction to Computer Science', 4, 3, 'Computer Science'),
(2, 'Calculus I', 5, 4, 'Mathematics'),
(3, 'English Composition', 3, 3, 'English'),
(4, 'Introduction to Psychology', 3, 3, 'Psychology'),
(5, 'Principles of Marketing', 4, 3, 'Business'),
(6, 'General Biology', 4, 4, 'Biology'),
(7, 'World History', 3, 3, 'History'),
(8, 'Introduction to Sociology', 3, 3, 'Sociology'),
(9, 'Digital Design', 4, 4, 'Electrical Engineering'),
(10, 'Introduction to Philosophy', 3, 3, 'Philosophy');
/******************** LECTURE VALUE INSERTION *********************/

/******************** TEACHER VALUE INSERTION *********************/
INSERT INTO Teacher (Name, ID, Department, Date_of_Birth, Gender)
VALUES
('x', '-', 'x', '1000-01-01', 'x'),
('Sarah Johnson', 'T001', 'Computer Science', '1983-08-15', 'Female'),
('Robert Davis', 'T002', 'Mathematics', '1975-04-20', 'Male'),
('Jennifer Smith', 'T003', 'English', '1990-02-28', 'Female'),
('Michael Thompson', 'T004', 'Electrical Engineering', '1988-11-10', 'Male'),
('Emily Wilson', 'T005', 'Business', '1982-06-03', 'Female'),
('David Johnson', 'T006', 'History', '1979-09-25', 'Male'),
('Jessica Anderson', 'T007', 'Psychology', '1993-03-12', 'Female'),
('Daniel Miller', 'T008', 'Biology', '1985-12-05', 'Male'),
('Alexa Martinez', 'T009', 'Sociology', '1996-07-17', 'Female'),
('Matthew Harris', 'T010', 'Philosophy', '1981-01-08', 'Male');
/******************** TEACHER VALUE INSERTION *********************/

/******************** STUDENT VALUE INSERTION *********************/
INSERT INTO Student (Name, ID, Department, Date_of_Birth, Gender)
VALUES
('x', '-', 'x', '1000-01-01', 'x'),
('Emily Wilson', 'ST001', 'English', '2000-02-15', 'Female'),
('James Thompson', 'ST002', 'History', '1999-07-28', 'Male'),
('Abigail Davis', 'ST003', 'Computer Science', '2001-04-10', 'Female'),
('Benjamin Martinez', 'ST004', 'Philosophy', '2000-09-22', 'Male'),
('Charlotte Miller', 'ST005', 'Business', '1999-03-08', 'Female'),
('Daniel Johnson', 'ST006', 'Mathematics', '2001-11-18', 'Male'),
('Ella Anderson', 'ST007', 'Psychology', '2000-06-27', 'Female'),
('William Smith', 'ST008', 'Sociology', '1999-10-05', 'Male'),
('Grace Harris', 'ST009', 'Biology', '2001-01-12', 'Female'),
('Henry Taylor', 'ST010', 'Electrical Engineering', '2000-05-25', 'Male');
/******************** STUDENT VALUE INSERTION *********************/

/******************** BOOK VALUE INSERTION *********************/
INSERT INTO Book (Title	,	 ISBN	,	 Num_of_Pages	,	 Year	,	 Date	, Department,	 Type	,	Author_Name	,	Publisher_Name	,	Librarian_ID	)	
VALUES
('', '-', 0, 1000, '1000-01-01', 'x', 'x',	'F. Scott Fitzgerald'	,	'Sunrise Publications'	,	'LS016'	)	,																	
('The Great Gatsby'	,	 '9780743273565'	,	218	,	1925	,	 '2021-05-12'	,	'Fiction'	, 'General',	'F. Scott Fitzgerald'	,	'Sunrise Publications'	,	'LS016'	)	,
('To Kill a Mockingbird'	,	 '9780061120084'	,	324	,	1960	,	 '2022-02-18'	,	'Fiction'	, 'General',	'Harper Lee'	,	'Moonlight Books'	,	'LS020'	)	,
('1984'	,	 '9780451524935'	,	328	,	1949	,	 '2023-01-05'	,	'Fiction'	,'General',	'George Orwell'	,	'Star Publishing'	,	'LS018'	)	,
('Pride and Prejudice'	,	 '9780486284736'	,	279	,	1813	,	 '2024-06-30'	,'General',	'Fiction'	,	'Jane Austen'	,	'Galaxy Press'	,	'LS019'	)	,
('The Catcher in the Rye'	,	 '9780316769488'	,	224	,	1951	,	 '2025-03-15'	,'General',	'Fiction'	,	'J.D. Salinger'	,	'Supreme Publishers'	,	'LS011'	)	,
('To the Lighthouse'	,	 '9780156907392'	,	209	,	1927	,	 '2026-09-22'	,'General',	'Fiction'	,	'Virginia Woolf'	,	'Enlighten Books'	,	'LS015'	)	,
('Brave New World'	,	 '9780060850524'	,	288	,	1932	,	 '2027-07-11'	,'General',	'Fiction'	,	'Aldous Huxley'	,	'Wonderful Publications'	,	'LS017'	)	,
('Moby-Dick'	,	 '9780142437247'	,	720	,	1851	,	 '2028-11-04'	,'General',	'Fiction'	,	'Herman Melville'	,	'Majestic Press'	,	'LS012'	)	,
('The Odyssey'	,	 '9780140268867'	,	541	,	1038	,	 '2029-08-19'	,'General',	'Classical Literature'	,	'Homer'	,	'Eternal Publishers'	,	'LS013'	)	,
('Hamlet'	,	 '9780141013077'	,	288	,	1603	,	 '2030-12-01'	,'General',	'Drama'	,	'William Shakespeare'	,	'Legendary Books'	,	'LS014'	)	,																
('Introduction to Programming'	,	 '9781234567890'	,	300	,	2020	,	 '2020-06-15'	,'Computer Science',	 'Educational'	,	'Ava Martinez'	,	'ABC Publications'	,	'LS011'	)	,
('Advanced Mathematics'	,	 '9780987654321'	,	400	,	2019	,	 '2019-09-20'	, 'Mathematics',	 'Textbook'	,	'Daniel Anderson'	,	'XYZ Books'	,	'LS019'	)	,
('Database Management'	,	 '9785678901234'	,	250	,	2021	,	 '2021-03-10'	, 'Computer Science',	 'Educational'	,	'David Thompson'	,	'EFG Publishing'	,	'LS015'	)	,
('History of Art'	,	 '9784321098765'	,	150	,	2018	,	 '2018-07-05'	,'History',	 'Textbook'	,	'Emily Johnson'	,	'123 Publishers'	,	'LS012'	)	,
('English Literature'	,	 '9786543210987'	,	350	,	2022	,	 '2022-11-30'	,'English',	 'Educational'	,	'Isabella Taylor'	,	'LMN Press'	,	'LS014'	)	,
('Chemistry Basics'	,	 '9789876543210'	,	200	,	2019	,	 '2019-10-15'	,'Biology',	 'Textbook'	,	'John Smith'	,	'PQR Books'	,	'LS013'	)	,
('Introduction to Psychology'	,	 '9780123456789'	,	280	,	2020	,	 '2020-04-25'	,'Psychology',	 'Educational'	,	'Michael Davis'	,	'UVW Publications'	,	'LS020'	)	,
('Physics Fundamentals'	,	 '9785432109876'	,	320	,	2018	,	 '2018-09-12'	,'Mathematics',	 'Textbook'	,	'Olivia Miller'	,	'RST Publishers'	,	'LS016'	)	,
('Computer Networks'	,	 '9780987658821'	,	400	,	2021	,	 '2021-02-28'	,'Computer Science',	 'Educational'	,	'Sophia Wilson'	,	'GHI Press'	,	'LS013'	)	,
('Business Economics'	,	 '9788765432109'	,	280	,	2019	,	 '2019-11-20'	,'Business',	 'Textbook'	,	'William Harris'	,	'JKL Books'	,	'LS017'	)	,
('Introduction to Sociology'	,	 '9785678977234'	,	320	,	2022	,	 '2022-08-10'	,'Sociology',	 'Educational'	,	'Ava Martinez'	,	'LMN Press'	,	'LS012'	)	,
('Philosophy of Mind'	,	 '9784321488765'	,	200	,	2018	,	 '2018-05-07'	,'Philosophy',	 'Textbook'	,	'Aldous Huxley'	,	'PQR Books'	,	'LS015'	)	,
('Environmental Science'	,	 '9786543265987'	,	400	,	2023	,	 '2023-01-18'	, 'Biology' ,	 'Educational'	,	'William Shakespeare'	,	'XYZ Books'	,	'LS011'	)	,
('Introduction to Literature'	,	 '9787890195456'	,	250	,	2021	,	 '2021-07-02'	,'English' ,	 'Textbook'	,	'Michael Davis'	,	'EFG Publishing'	,	'LS011'	)	,
('Software Engineering'	,	 '9780987644321'	,	350	,	2019	,	 '2019-12-15'	,'Computer Science' ,	 'Educational'	,	'John Smith'	,	'GHI Press'	,	'LS020'	)	;
UPDATE Book
SET Teacher_ID = '-';
UPDATE Book
SET Student_ID = '-';
UPDATE Teacher
SET ISBN_Book = '-';
UPDATE Student
SET ISBN_Book = '-';
/******************** BOOK VALUE INSERTION *********************/





/******************** STUDENT EMPTY FIELDS FILLING *********************/    
UPDATE Student
JOIN Lecture ON Lecture.Department = Student.Department
SET Student.ID_Lecture = Lecture.ID;
UPDATE Student
JOIN Book ON Book.Student_ID = Student.ID
SET Student.ISBN_Book = Book.ISBN;
/******************** STUDENT EMPTY FIELDS FILLING *********************/   

/******************** TEACHER EMPTY FIELDS FILLING *********************/    
UPDATE Teacher
JOIN Lecture ON Lecture.Department = Teacher.Department
SET Teacher.ID_Lecture = Lecture.ID;
/******************** TEACHER EMPTY FIELDS FILLING *********************/