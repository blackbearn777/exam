CREATE DATABASE medichna_slushba;

USE medichna_slushba;

 

CREATE TABLE hvoroba(
id_hvorobi INT PRIMARY KEY, 
nazva_hvoroby VARCHAR(30),
simptomi_hvoroby varchar(255)
);
CREATE TABLE liki(
id_likiv INT PRIMARY KEY ,
nazva_likiv VARCHAR(30),
cina_likiv decimal
); 
CREATE TABLE hvoriy(
id_hvoroho INT PRIMARY KEY, 
pib_hvoroho VARCHAR(30),
vik_hvoroho INT,
hvoroba_id INT REFERENCES hvoroba(id_hvorobi),
liki_id INT REFERENCES liki(id_likiv)
);

INSERT INTO hvoroba VALUES 
(1,'Covid-19','Температу, кашель'), 
(2,'Діарея','Симптоми отруєння'),
(3,'Бронхіт','Сухий кашель'),
(4,'Гайморит','Закладеність носу, біль в голові'),
(5,'ГРВІ','Висока температура, кашель'),
(6,'Пневмонія','Дуже висока температура, біль в легенях'),
(7,'Пульпіт зуба','Біль у зубі'),
(8,'Тахікардія','Зміна ритму серця'),
(9,'Гастрит','Біль після прийому їжі'),
(10,'Шлункова виразка','Біль у животі')
;

INSERT INTO liki VALUES 
(1,'Парацетамол-500',22.30),
(2,'Креон-10000',253.56), 
(3,'Мефенамінова кислота',300), 
(4,'Димедрол',2430), 
(5,'Лідокаїн',250.30), 
(6,'Доктор-мом',12.50), 
(7,'Спазмалгон',120), 
(8,'Септефрил',10), 
(9,'Діамантовий зелений',100), 
(10,'Вугілля активоване',20)
;

INSERT INTO hvoriy VALUES 
(1,'Іванов Іван',37,1,10),
(2,'Петров Петро',21,1,9),
(3,'Шевченко Олег',45,7,5),
(4,'Морозов Микола',27,6,1),
(5,'Сидоров Данило',75,10,7),
(6,'Проценко Дмитро',22,1,1),
(7,'Бурий Олександр',35,4,8),
(8,'Білий Максим',47,7,5),
(9,'Фролов Олексій',41,1,1),
(10,'Комаров Іван',35,3,6);

delimiter //
CREATE PROCEDURE ShowAll()
Begin 	
	select pib_hvoroho, nazva_hvoroby, nazva_likiv  
    from hvoriy, hvoroba, liki 
    where hvoroba.id_hvorobi=hvoriy.hvoroba_id 
    and liki.id_likiv=hvoriy.liki_id;
end//
delimiter ;
call ShowAll();