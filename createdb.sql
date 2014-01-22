DROP DATABASE IF EXISTS `myautopark`;
CREATE SCHEMA IF NOT EXISTS `myautopark` character set utf8;
USE `myautopark` ;

/***********************
 ********* busses ********
 ***********************/
CREATE TABLE IF NOT EXISTS `busses` (
    `bus_id`		BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, -- sql:BIGINT <-> java:long
    `number`		LONGTEXT NOT NULL,
    `route_id`		BIGINT NOT NULL
);

/***********************
 ***** drivers *****
 ***********************/
CREATE TABLE IF NOT EXISTS `drivers` (
    `driver_id`		BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name`			LONGTEXT NOT NULL,
    `surname`		LONGTEXT NOT NULL,
	`age`			INT NOT NULL
);

/***********************
 ******* routes *******
 ***********************/
CREATE TABLE IF NOT EXISTS `routes` (
    `route_id`		BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name`			LONGTEXT NOT NULL,
    `number`		INT NOT NULL
);

/***********************
 ******** BusDriver ********
 ***********************/
CREATE TABLE IF NOT EXISTS `BusDriver`
(
    `bus_id`		BIGINT NOT NULL, -- sql:BIGINT <-> java:long
    `driver_id`		BIGINT NOT NULL
);
