CREATE DATABASE IF NOT EXISTS `BD89_06_aulamaster`;
USE `BD89_06_aulamaster`;

DROP TABLE IF EXISTS `Users`;
DROP TABLE IF EXISTS `UserSessions`;
DROP TABLE IF EXISTS `Courses`;
DROP TABLE IF EXISTS `Students`;
DROP TABLE IF EXISTS `EnrolledStudent`;

CREATE TABLE `Users` (
  `idusers` varchar(50) NOT NULL,
  `password` varchar(45) NOT NULL,
  `name` varchar(45) DEFAULT '',
  `surname` varchar(45) DEFAULT '',
  PRIMARY KEY (`idusers`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `UserSessions` (
	`id_user` varchar(50) NOT NULL,
    `start_date_time` DATETIME,
    `end_date_time` DATETIME,
    PRIMARY KEY (`id_user`, `start_date`, `start_time`),
    KEY `FK_user` (`id_user`),
    CONSTRAINT `FK_user` FOREIGN KEY (`id_user`) REFERENCES `Users` (`idusers`) 
);

CREATE TABLE `Courses` (
  `id_course` INT NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `description` varchar(500) NOT NULL,
  `academic_course` varchar(45) NOT NULL,
  PRIMARY KEY (`id_course`)
  );
  
  CREATE TABLE `Students` (
	`nie` varchar(11) NOT NULL,
    `name` varchar(45) NOT NULL,
	`surname` varchar(45) NOT NULL,
    `date_of_birth` DATE,
    PRIMARY KEY (`nie`)
  );
  
    CREATE TABLE `EnrolledStudent` (
    `id_course` INT NOT NULL,
    `nie_student` varchar(11) NOT NULL,
    PRIMARY KEY (`id_course`, `nie_student`),
    KEY `FK_course` (`id_course`),
    KEY `FK_student` (`nie_student`),
    CONSTRAINT `FK_course` FOREIGN KEY (`id_course`) REFERENCES `Courses` (`id_course`),
    CONSTRAINT `FK_student` FOREIGN KEY (`nie_student`) REFERENCES `Students` (`nie`) 
    );
    
    
INSERT INTO `Students` (nie, name, surname, date_of_birth) VALUES ('X-1234567-A', 'Penèlope', 'Cruz', '1974-04-28');
INSERT INTO `Students` (nie, name, surname, date_of_birth) VALUES ('X-2345678-B', 'Javier', 'Bardem', '1969-03-01');
INSERT INTO `Students` (nie, name, surname, date_of_birth) VALUES ('Y-3456789-C', 'Antonio', 'Banderas', '1960-08-10');
INSERT INTO `Students` (nie, name, surname, date_of_birth) VALUES ('Y-4567890-D', 'Mario', 'Casas', '1986-06-12');

INSERT INTO `Courses` (id_course, name, school, academic_course, description) VALUES (1,
'Computing technologies for the web', 'Leganés', 'Computer Science and Engineering'
'In this class you will learn about development of distributed components, 
web programming, web application desgin patterns, Techniques for asynchronous 
communications with servers, MVC architectures, Persistence engines and Web 
development for specific platforms'
);
INSERT INTO `Courses` (id_course, name, school, academic_course, description) VALUES (2,
'Advanced Software Design','Leganés', 'Computer Science and Engineering'
'Generic techniques for modeling, design and implementation of modular 
software, focussing on industrial techniques and domains. Component-based 
design, component-based architectures and frameworks, distributed 
component-based systems. Model-driven development of software, 
code generation and domain-specific languages. Testing, continuous 
integration, deployment and governance.'
);
INSERT INTO `Courses` (id_course, name, school, academic_course, description) VALUES (3,
'Managerial Economics and Accounting','Getafe', 'Buisness Administration'
'Managerial accounting: - Introduction to managerial accounting - 
Costs and cost structures - Cost allocation - Costing - Short-term 
decision making - Cost-, volume-, profitanalysis - Introduction to 
management science - Pricing decisions - Long-term decisions Financial 
accounting: - Purpose and use of financial accounts - 
Double entry bookkeeping - Basic bookkeeping - Introduction to accrual 
accounting - Closing the books'
);

INSERT INTO `Courses` (id_course, name, school, academic_course, description) VALUES (4,
'Marketing - Basic Course','Getafe', 'Buisness Administration'
'The course aims to provide students with key basic skills through 
a broad presentation of the marketing discipline, develop students 
understanding of the topics presented and to develop students ability 
to apply knowledge in realistic marketing situations. There will also 
be an emphasis on developing a market-oriented attitude among students.'
);

INSERT INTO `Courses` (id_course, name, school, academic_course, description) VALUES (5,
'Data Modelling, Database Managment Systems','Leganés', 'Computer Science and Engineering'
'Basic introduction to data modelling with emphasis on Entitity Relationship 
modelling. The relational model, relational algebra and SQL. Database construction.
 Normalization as a design theory for relational databases. Other database 
 models. Storage technologies, file organization and index structures. 
 Query processing. Database management systems (DBMS). Transactions, 
 concurrency and recovery. Data integrity.'
);

INSERT INTO `EnrolledStudent` (nie_student, id_course) VALUES ('X-1234567-A', 1);
INSERT INTO `EnrolledStudent` (nie_student, id_course) VALUES ('X-1234567-A', 2);
INSERT INTO `EnrolledStudent` (nie_student, id_course) VALUES ('X-1234567-A', 5);
INSERT INTO `EnrolledStudent` (nie_student, id_course) VALUES ('X-2345678-B', 2);
INSERT INTO `EnrolledStudent` (nie_student, id_course) VALUES ('X-2345678-B', 5);
INSERT INTO `EnrolledStudent` (nie_student, id_course) VALUES ('Y-3456789-C', 2);
INSERT INTO `EnrolledStudent` (nie_student, id_course) VALUES ('Y-3456789-C', 3);

INSERT INTO `Users` (idusers, password, name, surname) VALUES ('admin', 'admin', 'John', 'Johnsen');
  
  
