DROP DATABASE IF EXISTS `myautopark`;
CREATE SCHEMA IF NOT EXISTS `myautopark` character set utf8;
USE `myautopark` ;

/***********************
 ********* bus ********
 ***********************/
CREATE TABLE IF NOT EXISTS `bus` (
    `bus_id`		BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, -- sql:BIGINT <-> java:long
    `number`		LONGTEXT NOT NULL,
    `route_id`		BIGINT NOT NULL
);

/***********************
 ***** driver *****
 ***********************/
CREATE TABLE IF NOT EXISTS `driver` (
    `driver_id`		BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name`			LONGTEXT NOT NULL,
    `surname`		LONGTEXT NOT NULL,
	`age`			INT NOT NULL
);

/***********************
 ******* route *******
 ***********************/
CREATE TABLE IF NOT EXISTS `route` (
    `route_id`		BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name`			LONGTEXT NOT NULL,
    `number`		INT NOT NULL
);

/***********************
 ******** BusDriver ********
 ***********************/
CREATE TABLE IF NOT EXISTS `bus_driver`
(
    `bus_id`		BIGINT NOT NULL, -- sql:BIGINT <-> java:long
    `driver_id`		BIGINT NOT NULL
);
