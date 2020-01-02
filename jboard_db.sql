/*
SQLyog Community Edition- MySQL GUI v6.51
MySQL - 5.0.37-community-nt : Database - jboard_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

create database if not exists `jboard_db`;

USE `jboard_db`;

/*Table structure for table `auth_code_details` */

DROP TABLE IF EXISTS `auth_code_details`;

CREATE TABLE `auth_code_details` (
  `auth_code_details_id` bigint(20) NOT NULL auto_increment,
  `auth_code` varchar(32) NOT NULL,
  `login_time` datetime NOT NULL,
  `logout_time` datetime NOT NULL,
  `status` varchar(1) NOT NULL,
  `user_details_id` bigint(20) default NULL,
  PRIMARY KEY  (`auth_code_details_id`),
  KEY `FKbn21rot9b002326sdmu1eynw2` (`user_details_id`),
  CONSTRAINT `FKbn21rot9b002326sdmu1eynw2` FOREIGN KEY (`user_details_id`) REFERENCES `user_details` (`user_details_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


/*Table structure for table `exception_details` */

DROP TABLE IF EXISTS `exception_details`;

CREATE TABLE `exception_details` (
  `exception_details_id` bigint(20) NOT NULL auto_increment,
  `activity` varchar(255) NOT NULL,
  `created_at` datetime NOT NULL,
  `exception_message` text,
  `exception_type` varchar(255) NOT NULL,
  `stack_trace` text NOT NULL,
  `user_details_id` bigint(20) default NULL,
  PRIMARY KEY  (`exception_details_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `exception_details` */

/*Table structure for table `role_details` */

DROP TABLE IF EXISTS `role_details`;

CREATE TABLE `role_details` (
  `role_id` bigint(20) NOT NULL auto_increment,
  `role` varchar(50) NOT NULL,
  `status` varchar(1) NOT NULL,
  PRIMARY KEY  (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `role_details` */

insert  into `role_details`(`role_id`,`role`,`status`) values (1,'ADMIN','1');

/*Table structure for table `user_details` */

DROP TABLE IF EXISTS `user_details`;

CREATE TABLE `user_details` (
  `user_details_id` bigint(20) NOT NULL auto_increment,
  `address_line1` varchar(150) NOT NULL,
  `address_line2` varchar(150) default NULL,
  `city` varchar(100) default NULL,
  `country` varchar(5) default NULL,
  `created_at` datetime NOT NULL,
  `date_of_birth` date default NULL,
  `email` varchar(150) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `middle_name` varchar(50) default NULL,
  `password` varchar(150) NOT NULL,
  `phone_number` varchar(25) NOT NULL,
  `postal_code` varchar(10) default NULL,
  `state` varchar(100) default NULL,
  `status` varchar(1) NOT NULL,
  `user_name` varchar(32) NOT NULL,
  `role_id` bigint(20) default NULL,
  PRIMARY KEY  (`user_details_id`),
  KEY `FKsnq2d1fwx180hmo2ute2pu5t7` (`role_id`),
  CONSTRAINT `FKsnq2d1fwx180hmo2ute2pu5t7` FOREIGN KEY (`role_id`) REFERENCES `role_details` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_details` */

insert  into `user_details`(`user_details_id`,`address_line1`,`address_line2`,`city`,`country`,`created_at`,`date_of_birth`,`email`,`first_name`,`last_name`,`middle_name`,`password`,`phone_number`,`postal_code`,`state`,`status`,`user_name`,`role_id`) values (2,'Venkata Ramana Colony','KPHB 9th Phase','Hyderabad','India','2019-11-05 12:56:52','1980-07-15','jayaprakash.manne1@gmail.com','Jaya Prakash1','Manne1','','Welcome_1','9876543211','530072','Telangana','1','jpmanne1',1),(3,'Venkata Ramana Colony','KPHB 9th Phase','Hyderabad','India','2019-11-05 13:07:08','2019-11-04','jayaprakash.manne3@gmail.com','Jaya Prakash3','Manne3','','Welcome_3','9876543213','530072','Telangana','1','jpmanne3',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
