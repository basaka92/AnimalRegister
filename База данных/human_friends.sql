-- Создание и использование базы данных "друзья человека"
DROP DATABASE IF EXISTS human_friends;
CREATE DATABASE human_friends;
USE human_friends;

-- Создание родительских таблиц (Животные, Домашние животные, Вьючные животные)
CREATE TABLE animals
(
	Animal_id INT AUTO_INCREMENT PRIMARY KEY, 
	Class_name VARCHAR(25)
);

INSERT INTO animals (Class_name)
VALUES ('Вьючные'),
('Домашние');  

CREATE TABLE pets
(
	Kind_id INT AUTO_INCREMENT PRIMARY KEY,
    Kind VARCHAR (25),
    Animal_id INT,
    FOREIGN KEY (Animal_id) REFERENCES animals (Animal_id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO pets (Kind, Animal_id)
VALUES ('Собака', 2),
('Кошка', 2),  
('Хомяк', 2); 


CREATE TABLE pack_animals
(
	Kind_id INT AUTO_INCREMENT PRIMARY KEY,
    Kind VARCHAR (25),
    Animal_id INT,
    FOREIGN KEY (Animal_id) REFERENCES animals (Animal_id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO pack_animals (Kind, Animal_id)
VALUES ('Осёл', 1),
('Верблюд', 1),  
('Лошадь', 1); 

-- Создание и заполнение низкоуровневых таблиц
CREATE TABLE dogs 
(       
    Dog_id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(25), 
    Birthday DATE,
    Commands VARCHAR(50),
    Kind_id int,
    Foreign KEY (Kind_id) REFERENCES pets (Kind_id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO dogs (Name, Birthday, Commands, Kind_id)
VALUES ('Джонни', '2020-10-02', 'ко мне, лежать', 1),
('Шарик', '2022-07-13', 'лежать, голос', 1),  
('Сивый', '2021-02-02', 'сидеть, голос', 1);

CREATE TABLE cats 
(       
    Cat_id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(25), 
    Birthday DATE,
    Commands VARCHAR(50),
    Kind_id INT,
    Foreign KEY (Kind_id) REFERENCES pets (Kind_id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO cats (Name, Birthday, Commands, Kind_id)
VALUES ('Мурзик', '2018-02-10', 'сидеть, мяукать', 2),
('Матроскин', '2017-12-01', 'лежать', 2),  
('Беляш', '2019-05-19', 'лежать, сидеть', 2); 

CREATE TABLE hamsters 
(       
    Hamster_id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(25), 
    Birthday DATE,
    Commands VARCHAR(50),
    Kind_id INT,
    Foreign KEY (Kind_id) REFERENCES pets (Kind_id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO hamsters (Name, Birthday, Commands, Kind_id)
VALUES ('Боря', '2022-11-22', 'ко мне', 3),
('Кругляш', '2021-06-07', 'ко мне', 3);

CREATE TABLE donkeys 
(       
    Donkey_id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(25), 
    Birthday DATE,
    Commands VARCHAR(50),
    Kind_id INT,
    Foreign KEY (Kind_id) REFERENCES pack_animals (Kind_id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO donkeys (Name, Birthday, Commands, Kind_id)
VALUES ('Стёпка', '2018-05-23', 'лежать', 1),
('Иа', '2020-03-12', 'лежать, ко мне', 1);

CREATE TABLE camels 
(       
    Camel_id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(25), 
    Birthday DATE,
    Commands VARCHAR(50),
    Kind_id INT,
    Foreign KEY (Kind_id) REFERENCES pack_animals (Kind_id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO camels (Name, Birthday, Commands, Kind_id)
VALUES ('Горбик', '2019-05-11', 'стоять', 2),
('Сэм', '2020-01-18', "лежать", 2),  
('Плевок', '2018-03-11', "плевать", 2);

CREATE TABLE horses 
(       
    Horse_id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(25), 
    Birthday DATE,
    Commands VARCHAR(50),
    Kind_id INT,
    Foreign KEY (Kind_id) REFERENCES pack_animals (Kind_id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO horses (Name, Birthday, Commands, Kind_id)
VALUES ('Буцефал', '2018-11-12', 'прыгать, бежать', 3),
('Ветер', '2017-10-11', 'лежать', 3),  
('Гнедой', '2018-07-07', 'стоять', 3);