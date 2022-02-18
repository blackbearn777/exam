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
(1,'������ ���� ��������', '��������� Ͳ � ��������'), 
(2,'������ ����� ����������', '��������� 26 �����'), 
(3,'���� ������ �������������', '��������� 28 �����'),
(4,'����� ��������� �������������','��������� 25 �����'),
(5,'����� ��������� ��������','��������� 27 �����'),
(6,'�������� ����� ��������','��������� 20 �����'),
(7,'������ ���� ��������','��������� 16 �����'),
(8,'����� ��������� �������������','��������� 15 �����'),
(9,'��������� ����� ���������','��������� 36 �����'),
(10,'�������� ������ �������������','��������� 30 �����');

SELECT * FROM OSOBY

CREATE TABLE PIDROZDIL 
(id_pidrozdil INT PRIMARY KEY, 
name_pidrozdil VARCHAR(20), 
commandyr_pidrozdil INT,
wpn_count INT);

INSERT INTO PIDROZDIL
(id_pidrozdil, name_pidrozdil, commandyr_pidrozdil,wpn_count)
VALUES
(1,'26 ����',2,2),
(2,'28 ����',3,1),
(3,'25 ����',4,3),
(4,'27 ����',5,1),
(5,'20',6,1),
(6,'16',7,1),
(7,'15',8,1),
(8,'36',9,0),
(9,'30',10,0),
(10,'������������',1,0);

CREATE TABLE ZBROYA
(id_wpn INT PRIMARY KEY,
name_wpn VARCHAR(20),
komplekt VARCHAR(10),
id_pidrozdil INT);

INSERT INTO ZBROYA VALUES
(10001,'AK-74','������',1),
(10002,'AK-74','������',1),
(10003,'AK-74','��������',2),
(50507,'���','������',3),
(79651,'���','������',3),
(26548,'���','������',3),
(32159,'��','������',4),
(54329,'��','������',5),
(99845,'���','��������',6),
(65426,'���','��������',7);

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
(8888,'AK-74','������',10);

SELECT * FROM PIDROZDIL;
