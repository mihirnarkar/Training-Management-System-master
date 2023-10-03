CREATE TABLE users (
    id INT PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

Insert into users values (1, 'joel', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3');
Insert into users values (2, 'mihir','b3a8e0e1f9ab1bfe3a36f231f676f78bb30a519d2b21e6c530c0eee8ebb4a5d0');

select * from users;

drop table users;
--------------------------------------------------------------------------------------------------------------
CREATE TABLE employees (
	employee_id int primary key,
	employee_firstname varchar(255) not null,
	employee_lastname varchar(255) not null,
	employee_email varchar(255) not null unique,
	employee_department varchar(255) not null,
	employee_designation varchar(255) not null,
	employee_dob date not null,
	employee_doj date not null
);

Insert into employees values (
	3642, 'Joel', 'Dsouza', 
	'joel.dsouza@gmail.com', 
	'Project and Managed Services',
	'Associate Consultant',
	'2001-08-06',
	'2023-08-01'
);

Insert into employees values (
	3650, 'Mihir', 'Narkar', 
	'mihir.narkar@gmail.com', 
	'Project and Managed Services',
	'Associate Consultant',
	'2001-08-19',
	'2023-08-01'
);

select * from employees;
--------------------------------------------------------------------------------------------------------------
CREATE EXTENSION IF NOT EXISTS pgcrypto;

create view users as
select employee_id as username, 
	   to_char(employee_dob, 'ddmmyyyy') as dob, 
	   encode(digest(cast(to_char(employee_dob, 'ddmmyyyy') as text), 'sha256'), 'hex') 
	   as password 
  from employees;

select * from users where username = 3642;

drop view users;

--------------------------------------------------------------------------------------------------------------


