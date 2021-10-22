CREATE DATABASE IF NOT EXISTS `BD89_06_aulamaster`;
USE `BD89_06_aulamaster`;

DROP TABLE IF EXISTS `Users`;
DROP TABLE IF EXISTS `UserSessions`;
DROP TABLE IF EXISTS `Courses`;
DROP TABLE IF EXISTS `Students`;
DROP TABLE IF EXISTS `EnrolledStudent`;

CREATE TABLE `Users` (
  `idusers` int(11) NOT NULL,
  `password` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `surname` varchar(45) NOT NULL,
  PRIMARY KEY (`idusers`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `UserSessions` (
	`id_user` int(11) NOT NULL,
    `start_date` DATE NOT NULL,
    `start_time` TIMESTAMP NOT NULL,
    `end_date` DATE,
    `end_time` TIMESTAMP,
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
	`nie` varchar(9) NOT NULL,
    `name` varchar(45) NOT NULL,
	`surname` varchar(45) NOT NULL,
    `date_of_birth` DATE,
    PRIMARY KEY (`nie`)
  );
  
    CREATE TABLE `EnrolledStudent` (
    `id_course` INT NOT NULL,
    `nie_student` varchar(9) NOT NULL,
    PRIMARY KEY (`id_course`, `nie_student`),
    KEY `FK_course` (`id_course`),
    KEY `FK_student` (`nie_student`),
    CONSTRAINT `FK_course` FOREIGN KEY (`id_course`) REFERENCES `Courses` (`id_course`),
    CONSTRAINT `FK_student` FOREIGN KEY (`nie_student`) REFERENCES `Students` (`nie`) 
    );
  
  
