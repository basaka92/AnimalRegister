USE human_friends;

-- Удаление верблюдов
SET SQL_SAFE_UPDATES = 0;
DELETE FROM camels;

-- Объединение таблиц лошадей и ослов
DROP TABLE IF EXISTS new_packanimals;
CREATE TABLE new_packanimals AS 
SELECT Name, Birthday, Commands, Kind_id from horses
UNION
SELECT Name, Birthday, Commands, Kind_id from donkeys;

-- Создание таблицы молодых животных
DROP TABLE IF EXISTS temp_table;
CREATE TEMPORARY TABLE temp_table AS
SELECT Name, Birthday, Commands, Kind_id FROM dogs
UNION SELECT Name, Birthday, Commands, Kind_id FROM cats
UNION SELECT Name, Birthday, Commands, Kind_id FROM hamsters
UNION SELECT Name, Birthday, Commands, Kind_id FROM horses 
UNION SELECT Name, Birthday, Commands, Kind_id FROM donkeys;

DROP TABLE IF EXISTS young_animals;
CREATE TABLE young_animals (Young_id INT AUTO_INCREMENT PRIMARY KEY) AS
SELECT *, TIMESTAMPDIFF(MONTH, Birthday, CURDATE()) AS Age_in_months
FROM temp_table WHERE TIMESTAMPDIFF(MONTH, Birthday, CURDATE()) BETWEEN 12 and 36;

-- Объединение созданных ранее таблиц в одну
DROP TABLE IF EXISTS new_animals;
CREATE TABLE new_animals AS
SELECT dogs.Name, dogs.Birthday, dogs.Commands, pets.Kind, young_animals.Age_in_months
FROM dogs
LEFT JOIN young_animals ON young_animals.Name = dogs.Name
LEFT JOIN pets ON pets.Kind_id = dogs.Kind_id
LEFT JOIN animals ON pets.Animal_id = animals.Animal_id
UNION
SELECT cats.Name, cats.Birthday, cats.Commands, pets.Kind, young_animals.Age_in_months
FROM cats
LEFT JOIN young_animals ON young_animals.Name = cats.Name
LEFT JOIN pets ON pets.Kind_id = cats.Kind_id
UNION
SELECT hamsters.Name, hamsters.Birthday, hamsters.Commands, pets.Kind, young_animals.Age_in_months 
FROM hamsters
LEFT JOIN young_animals ON young_animals.Name = hamsters.Name
LEFT JOIN pets ON pets.Kind_id = hamsters.Kind_id
UNION
SELECT horses.Name, horses.Birthday, horses.Commands, pack_animals.Kind, young_animals.Age_in_months 
FROM horses
LEFT JOIN young_animals ON young_animals.Name = horses.Name
LEFT JOIN pack_animals ON pack_animals.Kind_id = horses.Kind_id
UNION 
SELECT donkeys.Name, donkeys.Birthday, donkeys.Commands, pack_animals.Kind, young_animals.Age_in_months
FROM donkeys
LEFT JOIN young_animals ON young_animals.Name = donkeys.Name
LEFT JOIN pack_animals ON pack_animals.Kind_id = donkeys.Kind_id;

