DROP DATABASE IF EXISTS `myautopark`;
CREATE SCHEMA IF NOT EXISTS `myautopark` character set utf8;
USE `myautopark` ;

/***********************
 ********* bus ********
 ***********************/
CREATE TABLE IF NOT EXISTS `bus` (
    `id`		BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, -- sql:BIGINT <-> java:long
    `number`		LONGTEXT NOT NULL,
    `route_id`		BIGINT NOT NULL
);

/***********************
 ***** driver *****
 ***********************/
CREATE TABLE IF NOT EXISTS `driver` (
    `id`		BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name`			LONGTEXT NOT NULL,
    `surname`		LONGTEXT NOT NULL,
	`age`			INT NOT NULL
);

/***********************
 ******* route *******
 ***********************/
CREATE TABLE IF NOT EXISTS `route` (
    `id`		BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name`			LONGTEXT NOT NULL,
    `number`		INT NOT NULL
);

/***********************
 ******** BusDriver Many-To-many ********
 ***********************/
CREATE TABLE IF NOT EXISTS `bus_driver`
(
    `bus_id`		BIGINT NOT NULL, -- sql:BIGINT <-> java:long
    `driver_id`		BIGINT NOT NULL
);




-- This file encoded in UTF-8
/* If you use mysql> source filldb.sql
 * then charset of this file myst be equals charset of
 * character_set_client, character_set_connection,
 * character_set_results (это можно одной командой:
 * SET NAMES {кодировка})
 */


-- SET NAMES cp1251; -- Устанавливаем character_set_client cp1251 --> в кодировку этого файла. Мы вынуждены делать это через set names, т. к. set character_set_client не работает по каким-то причинам.

USE `myautopark` ;

/***********************
 ********* busses ********
 ***********************/
INSERT INTO `bus` (`id`, `number`, `route_id`)
	VALUES	(1, "1б", 1),
			(2, '666ф', 1),
			(3, 'ЩЩЩ', 2),
			(4, 'АШАН-2', 3),
			(5, 'АШАН-3', 2),
			(6, '73д', 1),
			(7, '123', 2),
			(8, '124', '2'),
			(9, '600', '4'),
			(10, '601', '4'),
			(11, '601ы', '4'),
			(12, '601ю', '4'),
			(13, '602', '4')
;

/***********************
 ********* drivers ********
 ***********************/
INSERT INTO `driver` (`id`, `name`, `surname`, `age`)
	VALUES	(1, 'Иван','Петрович', 80),
			(2, 'Владимир','Хутин', 60),
			(3, 'Граф','Дракула', 150),
			(4, 'Фхтанг','Осьминог', 300),
			(5, 'Сидор','Сидорич', 32),
			(6, 'Арнольд','Шварцнегер', 58),
			(7, 'Карлсон','Крлснч', 40)
;

/***********************
 ********* routes ********
 ***********************/
INSERT INTO `route` (`id`, `name`, `number`)
	VALUES	(1, 'Золотое кольцо', 1001),
			(2, 'АШАН Красногорск', 1002),
			(3, 'АШАН Мытищи', 1003),
			(4, 'АШАН Гагаринский', 1004)
;

/***********************
 ********* BusDriver ********
 ***********************/
INSERT INTO `bus_driver` (`bus_id`, `driver_id`)
	VALUES	(1, 1),
			(2, 2),
			(3, 3),
			(4, 4),
			(5, 5),
			(6, 6),
			(7, 7),
			(8, 1),
			(9, 2),
			(10, 3),
			(11, 4),
			(12, 5),
			(13, 6),
			(1, 7),
			(2, 1),
			(3, 2),
			(4, 3),
			(5, 4),
			(6, 5),
			(7, 6),
			(8, 7)
;

-- SET NAMES cp866; -- Устанавливаем character_set_client обратно в дефолтную виндовую кодировку для совпадения с кодировкой виндовой консоли, иначе запросы select будут выдавать крякозябры
