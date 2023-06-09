DROP TABLE IF EXISTS reimbursements;
DROP TABLE IF EXISTS users;

-- Multiplicity (relationships between tables)
-- One to many
	-- Foreign key is on the "many" table referring to the "one" table
-- One to one
	-- Foreign key can be on either side (or both), with the foreign keys required to be unique
-- Many to many

-- one table
CREATE TABLE users (
	username VARCHAR(50) PRIMARY KEY,
	password VARCHAR(50) NOT NULL,
	first_name VARCHAR(100) NOT NULL,
	last_name VARCHAR(100) NOT NULL,
	email VARCHAR(100) UNIQUE NOT NULL,
	age INTEGER CHECK(age > 0) NOT NULL,
	role VARCHAR(50) DEFAULT 'employee' NOT NULL
);

-- many table
CREATE TABLE reimbursements (
	id SERIAL PRIMARY KEY, -- SERIAL = autoincrementing
	description VARCHAR(200) NOT NULL,
	submitter VARCHAR(50) NOT NULL REFERENCES users(username), -- submitter is a foreign key
	-- linked to the username primary key in the users table
	status VARCHAR(50) NOT NULL DEFAULT 'pending'
);

-- In effect, we have established a one to many relationship between users and reimbursements

INSERT INTO users (username, password, first_name, last_name, email, age)
VALUES
('bach_tran123', 'password123', 'Bach', 'Tran', 'bach_tran@email.com', 25),
('john_doe', 'pass12345', 'John', 'Doe', 'john_doe@email.com', 40);

INSERT INTO users (username, password, first_name, last_name, email, age, role)
VALUES
('jane_smith', 'jane123', 'Jane', 'Smith', 'jane_smith@email.com', 30, 'finance_manager'),
('mike_jordan', 'mikepass789', 'Mike', 'Jordan', 'mike_jordan@email.com', 28, 'finance_manager');

INSERT INTO reimbursements (description, submitter)
VALUES 
('Team building lunch', 'john_doe'),
('AWS Certification reimbursement', 'bach_tran123'),
('Business travel', 'john_doe');

-- Example of a violation of "referential integrity"
-- We are trying to reference a username (primary key of users)
-- that does not exist
--INSERT INTO reimbursements (description, submitter)
--VALUES 
--('testing', 'user_that_does_not_exist');

SELECT *
FROM users;


-- 
SELECT *
FROM users 
WHERE age > 20;

SELECT *
FROM users 
WHERE age > 30;

SELECT *
FROM users
WHERE username = 'bach_tran123';

-- Functions
-- 1. Scalar functions: operates individually on each row of data
-- 2. Aggregate functions: combine data from all rows into one summary statistic

-- === SCALAR FUNCTION EXAMPLES ---
-- Character lengths of first names + last names
SELECT username, first_name, last_name, LENGTH(first_name) as fn_length, LENGTH(last_name) as ln_length
FROM users;

SELECT first_name, last_name, CONCAT(first_name, ' ', last_name) as full_name -- as <alias>
FROM users;

-- === AGGREGATE FUNCTION EXAMPLES ===
--- Average age
SELECT AVG(age) as average_age -- AVG is an example of an aggregate function
FROM users;

--- Average age of each role
SELECT role, AVG(age)
FROM users
GROUP BY role;

-- The AVG aggregate function operates on each group independently
-- finance_manager group: 
-- ('jane_smith', 'jane123', 'Jane', 'Smith', 'jane_smith@email.com', 30, 'finance_manager')
-- ('mike_jordan', 'mikepass789', 'Mike', 'Jordan', 'mike_jordan@email.com', 28, 'finance_manager')

-- employee group:
-- ('bach_tran123', 'password123', 'Bach', 'Tran', 'bach_tran@email.com', 25)
-- ('john_doe', 'pass12345', 'John', 'Doe', 'john_doe@email.com', 40)

SELECT role, MAX(age)
FROM users
GROUP BY role;

SELECT role, MIN(age)
FROM users
GROUP BY role;

SELECT role, SUM(age)
FROM users
GROUP BY role;

SELECT COUNT(*)
FROM users;

SELECT role, COUNT(*)
FROM users
GROUP BY role;



-- 
SELECT *
FROM users u
WHERE u.username = 'bach_tran123' AND u.password = 'password123';


SELECT *
FROM reimbursements;

UPDATE reimbursements 
SET status = 'approved'
WHERE id = 1;

DELETE 
FROM reimbursements
WHERE id = 1;

--
-- JOINS
SELECT *
FROM users u
INNER JOIN reimbursements r 
ON u.username = r.submitter;

-- WRite a query that displays the user who reimbursement id 2
-- belongs to
SELECT u.*
FROM users u
INNER JOIN reimbursements r
ON u.username = r.submitter
WHERE r.id = 2;

-- Write a query that displays the user who reimbursement id 1
-- belongs to
SELECT u.*
FROM users u
INNER JOIN reimbursements r
ON u.username = r.submitter
WHERE r.id = 1;

-- INNER, LEFT, RIGHT, OUTER (FULL OUTER)

-- INNER JOIN: a join that retains only the matches between
-- both the left table and the right table

-- LEFT JOIN: a join that retains the matches between both the
-- left table and the right table, but also retains 
-- records in the left table that don't have a match with the
-- right table
SELECT *
FROM users u
LEFT JOIN reimbursements r 
ON u.username = r.submitter;

-- RIGHT JOIN is the same as a left join, but flipped around
SELECT *
FROM reimbursements r -- Flipped reimbursements to be the "left"
-- table and users to be the right table
RIGHT JOIN users u
ON u.username = r.submitter;

-- OUTER JOIN: a join that retains the matches between both tables
-- but also retains records in both the left and right table 
-- that don't have matches with the other table

-- DBeaver is NOT the database
-- It is a program to connect to the database
-- JDBC does not connect to DBeaver
-- JDBC is analagous with DBeaver
-- They are the "same" thing
-- JDBC connects to the database
-- DBeaver also connects to the database


