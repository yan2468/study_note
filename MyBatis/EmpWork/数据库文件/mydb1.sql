/*
SQLyog Ultimate - MySQL GUI v8.2 
MySQL - 8.0.18 : Database - mydb1
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mydb1` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `mydb1`;

/*Table structure for table `dept` */

DROP TABLE IF EXISTS `dept`;

CREATE TABLE `dept` (
  `deptno` int(11) DEFAULT NULL,
  `dname` varchar(14) DEFAULT NULL,
  `loc` varchar(13) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `dept` */

insert  into `dept`(`deptno`,`dname`,`loc`) values (10,'ACCOUNTING','NEW YORK'),(20,'RESEARCH','DALLAS'),(30,'SALES','CHICAGO'),(40,'OPERATIONS','BOSTON');

/*Table structure for table `emp` */

DROP TABLE IF EXISTS `emp`;

CREATE TABLE `emp` (
  `empno` int(11) DEFAULT NULL,
  `ename` varchar(50) DEFAULT NULL,
  `job` varchar(50) DEFAULT NULL,
  `mgr` int(11) DEFAULT NULL,
  `hiredate` date DEFAULT NULL,
  `sal` decimal(7,2) DEFAULT NULL,
  `comm` decimal(7,2) DEFAULT NULL,
  `deptno` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `emp` */

insert  into `emp`(`empno`,`ename`,`job`,`mgr`,`hiredate`,`sal`,`comm`,`deptno`) values (7369,'lisi','CLERK',7902,'2010-12-15','1200.00','0.00',20),(7499,'ALLEN','SALESMAN',7698,'2011-02-20','1600.00','300.00',30),(7521,'WARD','SALESMAN',7698,'2011-02-22','1250.00','500.00',30),(7566,'JONES','MANAGER',7839,'2011-04-02','2975.00',NULL,20),(7654,'MARTIN','SALESMAN',7698,'2011-09-28','1250.00','1400.00',30),(7698,'BLAKE','MANAGER',7839,'2011-05-01','2850.00',NULL,30),(7782,'CLARK','MANAGER',7839,'2011-06-09','2450.00',NULL,10),(7788,'SCOTT','ANALYST',7566,'2017-04-19','3000.00',NULL,20),(7839,'KING','PRESIDENT',NULL,'2011-11-17','5000.00',NULL,10),(7844,'TURNER','SALESMAN',7698,'2011-09-08','1500.00','0.00',30),(7876,'ADAMS','CLERK',7788,'2017-05-23','1100.00',NULL,20),(7900,'JAMES','CLERK',7698,'2011-12-03','950.00',NULL,30),(7902,'FORD','ANALYST',7566,'2011-12-03','3000.00',NULL,20),(7934,'MILLER','CLERK',7782,'2012-01-23','1300.00',NULL,10),(7935,'张三','CLERK',7782,'2021-01-01','1500.00',NULL,50),(1000,'ww','wewe',2000,'2020-01-20','2000.00','200.00',30),(1002,'wu','wow',2020,'2000-02-01','200.00','21.00',40),(1004,'we','wei',3030,'2020-02-12','300.00','20.00',90);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) DEFAULT NULL,
  `username` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`) values (1,'admin','123'),(2,'seehope','123456');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
