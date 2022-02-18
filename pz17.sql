create database ZVYAZOK;
use ZVYAZOK;
ALTER DATABASE ZVYAZOK COLLATE Cyrillic_General_CI_AS;

CREATE TABLE VIDPOVIDALNIY 
( id_osoby INT PRIMARY KEY, 
name_osoby VARCHAR(50), 
posada_osoby VARCHAR(30));

INSERT INTO VIDPOVIDALNIY
(id_osoby, name_osoby, posada_osoby) 
VALUES 
(1,'Іванов Іван Іванович', 'Заступник КЧ з озброєння'), 
(2,'Фарбей Артур Русланович', 'Командир 1 батальону'), 
(3,'Влох Сервгій Володимирович', 'Командир 2 батальону'),
(4,'Голуб Олександр Олександрович','Командир 3 батальону'),
(5,'Яшник Владислав Олегович','Начальник Вузла зв"язку'),
(6,'Бондарук Тарас Іванович','Начальник ЦІС'),
(7,'Стозуб Іван Петрович','Начальник ЦЕЖ'),
(8,'Тислів Володимир Володимирович','Командир 1 роти'),
(9,'Лазаренко Євген Сергійович','Командир взводу забезпечення'),
(10,'Степанов Микита Олександрович','Начальник центру прив"язки');

SELECT * FROM OSOBY

CREATE TABLE PIDROZDIL 
(id_pidrozdil INT PRIMARY KEY, 
name_pidrozdil VARCHAR(20), 
commandyr_pidrozdil INT,
zas_count INT);

INSERT INTO PIDROZDIL
(id_pidrozdil, name_pidrozdil, commandyr_pidrozdil,zas_count)
VALUES
(1,'1 батальон',2,2),
(2,'2 батальон',3,1),
(3,'3 батальон',4,3),
(4,'Вузол зв"яку',5,1),
(5,'ЦІС',6,1),
(6,'ЦЕЖ',7,1),
(7,'1 рота',8,1),
(8,'Взвод забезпечення',9,0),
(9,'Центр прив"язки',10,0),
(10,'Командування',1,0);

CREATE TABLE ZVYAZOK
(id_zas INT PRIMARY KEY,
name_zas VARCHAR(20),
komplekt VARCHAR(10),
id_pidrozdil INT);

INSERT INTO ZVYAZOK VALUES
(10001,'Motorola 4800','повний',1),
(10002,'Motorola 4800','повний',1),
(10003,'Motorola 4800','неповний',2),
(50507,'Motorola 4600','повний',3),
(79651,'Motorola 4600','повний',3),
(26548,'TK-1','повний',3),
(32159,'TK-1','повний',4),
(54329,'TK-4','повний',5),
(99845,'Harris 150B','неповний',6),
(65426,'Aselsan','неповний',7);

ALTER TABLE PIDROZDIL ADD FOREIGN KEY (commandyr_pidrozdil) REFERENCES VIDPOVIDALNIY(id_osoby);
ALTER TABLE ZVYAZOK ADD FOREIGN KEY (id_pidrozdil) REFERENCES PIDROZDIL(id_pidrozdil);

UPDATE ZVYAZOK SET komplekt = 'повний' WHERE id_zas=10003;
SELECT * FROM ZVYAZOK;
