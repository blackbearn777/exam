create database RAO;
use RAO;
ALTER DATABASE RAO COLLATE Cyrillic_General_CI_AS;

CREATE TABLE OSOBY 
( id_osoby INT PRIMARY KEY, 
name_osoby VARCHAR(50), 
posada_osoby VARCHAR(30));

INSERT INTO OSOBY
(id_osoby, name_osoby, posada_osoby) 
VALUES 
(1,'Іванов Іван Іванович', 'Заступник НІ з озброєння'), 
(2,'Фарбей Артур Русланович', 'Начальник 26 курсу'), 
(3,'Влох Сервгій Володимирович', 'Начальник 28 курсу'),
(4,'Голуб Олександр Олександрович','Начальник 25 курсу'),
(5,'Яшник Владислав Олегович','Начальник 27 курсу'),
(6,'Бондарук Тарас Іванович','Начальник 20 курсу'),
(7,'Стозуб Іван Петрович','Начальник 16 курсу'),
(8,'Тислів Володимир Володимирович','Начальник 15 курсу'),
(9,'Лазаренко Євген Сергійович','Начальник 36 курсу'),
(10,'Степанов Микита Олександрович','Начальник 30 курсу');

SELECT * FROM OSOBY

CREATE TABLE PIDROZDIL 
(id_pidrozdil INT PRIMARY KEY, 
name_pidrozdil VARCHAR(20), 
commandyr_pidrozdil INT,
wpn_count INT);

INSERT INTO PIDROZDIL
(id_pidrozdil, name_pidrozdil, commandyr_pidrozdil,wpn_count)
VALUES
(1,'26 курс',2,2),
(2,'28 курс',3,1),
(3,'25 курс',4,3),
(4,'27 курс',5,1),
(5,'20',6,1),
(6,'16',7,1),
(7,'15',8,1),
(8,'36',9,0),
(9,'30',10,0),
(10,'Командування',1,0);

CREATE TABLE ZBROYA
(id_wpn INT PRIMARY KEY,
name_wpn VARCHAR(20),
komplekt VARCHAR(10),
id_pidrozdil INT);

INSERT INTO ZBROYA VALUES
(10001,'AK-74','повний',1),
(10002,'AK-74','повний',1),
(10003,'AK-74','неповний',2),
(50507,'РПК','повний',3),
(79651,'РПК','повний',3),
(26548,'РПК','повний',3),
(32159,'ПМ','повний',4),
(54329,'ПМ','повний',5),
(99845,'СВД','неповний',6),
(65426,'СВД','неповний',7);

ALTER TABLE PIDROZDIL ADD FOREIGN KEY (commandyr_pidrozdil) REFERENCES OSOBY(id_osoby);
ALTER TABLE ZBROYA ADD FOREIGN KEY (id_pidrozdil) REFERENCES PIDROZDIL(id_pidrozdil);

GO
CREATE TRIGGER kilkist_zbroi
ON ZBROYA
AFTER INSERT
AS
BEGIN
DECLARE @kist_zbr INT
SELECT @kist_zbr =(SELECT id_pidrozdil FROM INSERTED) 
UPDATE PIDROZDIL SET wpn_count = wpn_count +1 WHERE id_pidrozdil = @kist_zbr
END

INSERT INTO ZBROYA VALUES
(8888,'AK-74','повний',10);

SELECT * FROM PIDROZDIL;
