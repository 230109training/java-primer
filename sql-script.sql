DROP TABLE IF EXISTS users;

CREATE TABLE users (
	username VARCHAR(50) PRIMARY KEY,
	password VARCHAR(50) NOT NULL,
	first_name VARCHAR(100) NOT NULL,
	last_name VARCHAR(100) NOT NULL,
	email VARCHAR(100) UNIQUE NOT NULL,
	age INTEGER CHECK(age > 0) NOT NULL,
	role VARCHAR(50) DEFAULT 'employee' NOT NULL
);

INSERT INTO users (username, password, first_name, last_name, email, age)
VALUES
('bach_tran123', 'password123', 'Bach', 'Tran', 'bach_tran@email.com', 25),
('john_doe', 'pass12345', 'John', 'Doe', 'john_doe@email.com', 40);

INSERT INTO users (username, password, first_name, last_name, email, age, role)
VALUES
('jane_smith', 'jane123', 'Jane', 'Smith', 'jane_smith@email.com', 30, 'finance_manager'),
('mike_jordan', 'mikepass789', 'Mike', 'Jordan', 'mike_jordan@email.com', 28, 'finance_manager');

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
-- 1. Scalar functions
-- 2. Aggregate functions

-- === SCALAR FUNCTION EXAMPLES ---
-- Character lengths of first names + last names
SELECT username, first_name, last_name, LENGTH(first_name) as fn_length, LENGTH(last_name) as ln_length
FROM users;

SELECT CONCAT(first_name, ' ', last_name) as full_name -- as <alias>
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

