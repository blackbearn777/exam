create database avto;
use avto;

CREATE TABLE OSOBY 
( id_osoby INT PRIMARY KEY, 
name_osoby VARCHAR(50), 
category VARCHAR(30));

INSERT INTO OSOBY
(id_osoby, name_osoby, category) 
VALUES 
(1,'Іванов Іван Іванович', 'D,B,C'), 
(2,'Фарбей Артур Русланович', 'C'), 
(3,'Влох Сервгій Володимирович', 'D,C'),
(4,'Голуб Олександр Олександрович','C'),
(5,'Яшник Владислав Олегович','A,B,C'),
(6,'Бондарук Тарас Іванович','D,C'),
(7,'Стозуб Іван Петрович','B,C'),
(8,'Тислів Володимир Володимирович','D,C'),
(9,'Лазаренко Євген Сергійович','C,D'),
(10,'Степанов Микита Олександрович','A,B,C,D');

CREATE TABLE BOX 
(id_box INT PRIMARY KEY, 
name_box VARCHAR(20), 
car_count INT);

INSERT INTO BOX
(id_box,name_box,car_count)
VALUES
(1,'БОКС №1',2),
(2,'БОКС №2',1),
(3,'БОКС №3',3),
(4,'БОКС №4',1),
(5,'БОКС №5',1),
(6,'БОКС №6',1),
(7,'БОКС №7',1),
(8,'БОКС №8',0),
(9,'БОКС №9',0),
(10,'БОКС №10',0);

CREATE TABLE AVTO
(id_car INT PRIMARY KEY,
name_car VARCHAR(20),
id_box INT,
id_osoby INT);

INSERT INTO AVTO VALUES
(10001,'ГАЗ-66',1,1),
(10002,'ВАЗ-131',1,2),
(10003,'ВАЗ-131',2,3),
(50507,'ВАЗ-66',3,4),
(79651,'КОЗАК',3,5),
(26548,'КОЗАК',3,6),
(32159,'ГАЗ-66',4,7),
(54329,'КРАЗ',5,8),
(99845,'УРАЛ',6,9),
(65426,'УРАЛ',7,10);

ALTER TABLE AVTO ADD FOREIGN KEY (id_box) REFERENCES BOX(id_box);
ALTER TABLE AVTO ADD FOREIGN KEY (id_osoby) REFERENCES OSOBY(id_osoby);



DELIMITER $$

CREATE TRIGGER car_count
AFTER INSERT 
ON AVTO for each row
BEGIN 
SELECT COUNT(id_car) FROM AVTO WHERE id_box=NEW.id_box INTO @car_count;
UPDATE BOX SET BOX.car_count = @car_count WHERE BOX.id_box=NEW.id_box;
END
$$
DELIMITER ;

DROP trigger car_count;

INSERT INTO AVTO VALUES
(77778,'ГАЗ-66',10,1);

SELECT * FROM BOX;

