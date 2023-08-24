create DATABASE avecoder -- создание БД из консоли SQL Shell, либо создаем в приложении pg Admin через интерфейс

-- использование терминала postgres:
\l -- посмотреть все БД через консоль
\c avecoder -- подсоединиться к БД через консоль (это мы внутри postgres=#)
\conninfo -- детали по конекшену (это мы уже внутри avecoder=#)
\d -- посмотреть таблицы
\dt pupils -- сколько строк в таблице
\! cls -- очистить экран

create schema pupils -- создание схемы
drop SCHEMA pupils -- удаляем схему
avecoder=# create table pupils ( -- создание таб. через консоль
avecoder(# id bigserial, -- bigserial последовательность id
avecoder(# first_name varchar(50),
avecoder(# last_name varchar(50),
avecoder(# email varchar(150)
avecoder(# );
create table -- подтвердило создание табл.
avecoder=# \d -- посмотреть таблицы
\d pupils -- посмотреть что внутри табл.

https://www.mockaroo.com/ -- сайт для автоматической рандомной генерации таблицы (наполнение таблицы случайными данными)
-- сохраняем файл в формате .sql и открываем с поможью Visual Studio Code, оттуда можно скопировать в Идею sql файл
-- или можно запустить через терминал постгре:
avecoder=# \i C:/Users/User/Downloads/pupils.sql -- указываем путь откуда закачать случайно сгенерированную таблицу
create table -- подтверждение созданной нагенерированной таблицы
avecoder=# select * from pupils; -- можно просмотреть табличку
\copy (select * from pupils) to 'C:/Users/User/Downloads/Pupilssss' delimiter ',' CSV HEADER; -- копируем табл. в csv

avecoder=# select * from pg_available_extensions; -- смлтрим какие расширения у нас установлены
create extension if not exists "uuid-ossp"; -- устанавливаем какое необходимо
select * from pg_available_extensions; -- проверяем что установилось
\df -- смотрим какие версии в себя включает
select uuid_generate_v4(); -- устанавливаем необходимую версию

avecoder=# create table passport ( -- создаем новую табличку проверить как работает генерация id
avecoder(# passport_serial uuid not null primary key,
avecoder(# issue_date date not null,
avecoder(# expire_date date not null,
avecoder(# country_of_issue varchar(150) not null
avecoder(# );
CREATE TABLE
avecoder=# d
avecoder-# \d
          List of relations
 Schema |   Name   | Type  |  Owner
--------+----------+-------+----------
 public | passport | table | postgres
 public | pupils   | table | postgres
(2 rows)

-- наполняем табличку и генерируем uuid
avecoder=# insert into passport values (uuid_generate_v4(), '2023-05-05', '2033-05-04', 'Ukraine');
INSERT 0 1
avecoder=# select * from passport;
           passport_serial            | issue_date | expire_date | country_of_issue
--------------------------------------+------------+-------------+------------------
 e543cdf9-568e-4d35-9da2-17466444802c | 2023-05-05 | 2033-05-04  | Ukraine
(1 row)


_________________________________________________________________________________________________________________
-- использование Идеи, через файл .sql, но некоторые команды не отрабатывают а через терминал postgres работают:
create table pupils -- создаем таблицу, даем название, если мы в сессии, через консоль Идеи
(
    id bigserial not null primary key, -- bigserial последовательность id
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    class int,
    email varchar(255),
    date_of_birth date not null
);

insert into pupils values (default , 'fn', 'ln', 11, 'ko@mail.com', '2000/01/01');
insert into pupils values (default , 'fn2', 'ln2', 10, 'ko2@mail.com', '2000/02/01');

SELECT FROM pupils; -- кол-во строк в таблице, через постгре
select first_name from pupils; -- все имена из таблицы
select first_name, email from pupils;
select * from pupils order by date_of_birth desc;
select distinct "class" from pupils order by "class";
select * from pupils offset 3 limit 4;
select * from pupils offset 3 fetch first 4 row only;
select * from pupils where first_name ilike 'c%'; -- ilike игнорирует регистр
select country, count(*) from pupils group by country having count(*) >10 order by count desc; -- в стране живет больше 10 чел.
select coalesce(email, 'not applicable') from  pupils; -- coalesce у тех кого поле email пустое, подставляет значение 'not applicable' (можно любое)
select max(age) from pupils;
select avg(age) from pupils;
select round(avg(age)) from pupils; -- round убирает дробные числа после запятой
select last_name, max(age) from pupils group by last_name, age order by age desc; -- отббирать с мах возрастом
select sum(age) from pupils; -- суммировать все значения по определенной колонке
select country_destination, sum(price) from countries group by country_destination; -- получим страны с сумарной стоимостью всех туров по городам конкретной страны
select 100 + 5;
select 100 - 4;
select 100 / 4;
select now();
select NOW()::DATE;
select now() - interval '1 year'; -- год  назад
select now() + interval '1 year'; -- год  впперед
select extract(month from now()); -- извлечь только месяц



