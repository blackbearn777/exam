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
(1,'������ ���� ��������', '��������� �� � ��������'), 
(2,'������ ����� ����������', '�������� 1 ���������'), 
(3,'���� ������ �������������', '�������� 2 ���������'),
(4,'����� ��������� �������������','�������� 3 ���������'),
(5,'����� ��������� ��������','��������� ����� ��"����'),
(6,'�������� ����� ��������','��������� ֲ�'),
(7,'������ ���� ��������','��������� ���'),
(8,'����� ��������� �������������','�������� 1 ����'),
(9,'��������� ����� ���������','�������� ������ ������������'),
(10,'�������� ������ �������������','��������� ������ ����"����');

SELECT * FROM OSOBY

CREATE TABLE PIDROZDIL 
(id_pidrozdil INT PRIMARY KEY, 
name_pidrozdil VARCHAR(20), 
commandyr_pidrozdil INT,
zas_count INT);

INSERT INTO PIDROZDIL
(id_pidrozdil, name_pidrozdil, commandyr_pidrozdil,zas_count)
VALUES
(1,'1 ��������',2,2),
(2,'2 ��������',3,1),
(3,'3 ��������',4,3),
(4,'����� ��"���',5,1),
(5,'ֲ�',6,1),
(6,'���',7,1),
(7,'1 ����',8,1),
(8,'����� ������������',9,0),
(9,'����� ����"����',10,0),
(10,'������������',1,0);

CREATE TABLE ZVYAZOK
(id_zas INT PRIMARY KEY,
name_zas VARCHAR(20),
komplekt VARCHAR(10),
id_pidrozdil INT);

INSERT INTO ZVYAZOK VALUES
(10001,'Motorola 4800','������',1),
(10002,'Motorola 4800','������',1),
(10003,'Motorola 4800','��������',2),
(50507,'Motorola 4600','������',3),
(79651,'Motorola 4600','������',3),
(26548,'TK-1','������',3),
(32159,'TK-1','������',4),
(54329,'TK-4','������',5),
(99845,'Harris 150B','��������',6),
(65426,'Aselsan','��������',7);

ALTER TABLE PIDROZDIL ADD FOREIGN KEY (commandyr_pidrozdil) REFERENCES VIDPOVIDALNIY(id_osoby);
ALTER TABLE ZVYAZOK ADD FOREIGN KEY (id_pidrozdil) REFERENCES PIDROZDIL(id_pidrozdil);

UPDATE ZVYAZOK SET komplekt = '������' WHERE id_zas=10003;
SELECT * FROM ZVYAZOK;
