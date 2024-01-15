CREATE DATABASE LECTURE_DB;
USE LECTURE_DB;



CREATE TABLE ADDRESS (
ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
CITY VARCHAR(255),
ZIP_CODE VARCHAR(255)
);

-- CRUD operations
-- Store a record into the address table = Create
INSERT INTO ADDRESS(CITY, ZIP_CODE) VALUES('Växjö', '35592');
INSERT INTO ADDRESS(CITY, ZIP_CODE) VALUES('Växjö', '35593');
INSERT INTO ADDRESS(CITY, ZIP_CODE) VALUES('Växjö', '35594');

-- Rertive data from address table = Read
SELECT * FROM ADDRESS;
SELECT ID, ZIP_CODE FROM ADDRESS;
SELECT ID AS address_id, ZIP_CODE AS zp FROM ADDRESS;

-- Modify table content = Update
UPDATE ADDRESS SET ZIP_CODE ='11111' WHERE id = 1;

-- Remove table row = Delete
DELETE FROM ADDRESS WHERE id = 2;

-- Remove table contents or table rows
TRUNCATE TABLE address;

DROP TABLE address;


-- Modify table fields + types
ALTER TABLE ADDRESS ADD STREET VARCHAR(255) NOT NULL default '-';
ALTER TABLE ADDRESS MODIFY CITY VARCHAR(40);
ALTER TABLE ADDRESS DROP STREET;

# ----------------------------------


CREATE TABLE PERSON(
id int not null primary key auto_increment,
first_name varchar(255) not null,
last_name varchar(255) not null,
email varchar(255) not null unique,
birthdate date,
create_date datetime default now(),
_active tinyint default false,
address_id int not null,
foreign key(address_id) references ADDRESS(ID)
);

INSERT INTO PERSON (first_name, last_name, email, address_id) VALUES('Simon', 'Elbrink', 'simon@lexicon.se', 1);
INSERT INTO PERSON (first_name, last_name, email, address_id) VALUES('Mehrdad', 'Javan', 'mehrdad@lexicon.se', 2);


# ---------- CREATING ONE-TO-MANY RELATIONSHIP ----------
# ONE Person can have MANY Tasks

CREATE TABLE TASK(
id int not null primary key auto_increment,
title varchar(100),
_description varchar(500),
person_id int,
foreign key(person_id) references person(id)
);


INSERT INTO TASK(title, _description, person_id) VALUES('Task1','DO THIS', 2);
INSERT INTO TASK(title, _description, person_id) VALUES('Task2','DO THIS', 2);
INSERT INTO TASK(title, _description, person_id) VALUES('Task3','DO THIS', 2);
INSERT INTO TASK(title, _description, person_id) VALUES('Task4','DO THIS', 2);
INSERT INTO TASK(title, _description, person_id) VALUES('Task5','DO THIS', 1);
INSERT INTO TASK(title, _description, person_id) VALUES('BUY FOOD','DO THIS NOW', 1);


# ---------------- SELECT ----------------

SELECT * FROM task;
SELECT * FROM task WHERE id = 5;
SELECT * FROM task WHERE id in(1,2);
SELECT * FROM task WHERE title LIKE "%sk%";
SELECT person_id, count(person_id) as number_of_tasks from task group by person_id;


# ---------- CREATING MANY-TO-MANY RELATIONSHIP ----------
# Actually 2 one-to-many relationships with assosiation table
# ONE person can be part of MANY Groups.
# ONE Group can have many persons assigned.

CREATE TABLE _GROUP(
id int not null primary key auto_increment,
group_name varchar(100) not null
);

INSERT INTO _GROUP (group_name) VALUES('JAVA GROUP 43');
INSERT INTO _GROUP (group_name) VALUES('JAVA GROUP 45');
INSERT INTO _GROUP (group_name) VALUES('JAVA GROUP 46');
INSERT INTO _GROUP (group_name) VALUES('JAVA GROUP 48');

select * FROM _GROUP;

CREATE TABLE PERSONS_GROUPS(
id int not null primary key auto_increment,
person_id int not null,
group_id int not null,
foreign key (person_id) references PERSON(id),
foreign key (group_id) references _GROUP(id)
);


INSERT INTO PERSONS_GROUPS(person_id, group_id) VALUES(1,1);
INSERT INTO PERSONS_GROUPS(person_id, group_id) VALUES(1,2);
INSERT INTO PERSONS_GROUPS(person_id, group_id) VALUES(1,4);

INSERT INTO PERSONS_GROUPS(person_id, group_id) VALUES(2,1);
INSERT INTO PERSONS_GROUPS(person_id, group_id) VALUES(2,3);

# ----------------SELECT----------------

SELECT * FROM TASK ORDER BY PERSON_ID ;
SELECT * FROM TASK ORDER BY PERSON_ID desc;
SELECT COUNT(*) AS NUMBER_OF_TASKS FROM TASK;
SELECT person_id, count(person_id) as number_of_tasks from task group by person_id;

SELECT distinct _description FROM TASK;


