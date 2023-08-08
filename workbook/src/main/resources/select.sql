    -- create
insert into employees values (1, 'Юрій', 'Гордієнко', 40); -- записать, название табл., (id назначаемый, филды)
insert into employees values (default, 'Юрій', 'Гордієнко', 40); -- записать, название табл., (id генерируемый, филды)

-- read
-- find all
-- select всегда возвращает табличку с мин 1 колоночкой (не объект)
-- and можно писать сколько угодно
select * from employees;    -- показать всех
select id, age from employees;  -- показать колонки с id и возрастом
select * from employees where id = 1;   -- показать по id
select * from employees where age < 30 and age > 25;    -- показать по возрасту в рамках...
select * from employees where age in (21, 22);  -- показать по конкретному возрасту
select * from employees where first_name like 'ю%'; -- показать, где имя начинается на "Ю"
select * from employees where first_name like '%м'; -- показать, где имя заканчивается на "м"
select * from employees where first_name like '%р%' and first_name not like '%р';   -- показать все имена, где присутствует буква "р" и не заканчиваются на "р"
select * from employees where first_name like 'Юрий' or last_name like 'Иванов' -- возвращает объекты с именами 'Юрий' и фимилиями 'Иванов'
-- count(*) - не всех (конкретных); as "..." - называем получаемую табличку как захотим; distinct - убрать дубликаты
select count(*) as count_of_pupils from pupils where first_name like ? or last_name like ?

-- update
update employees set age = 19 where id = 1; -- обновить возраст по id

-- delete
delete from employees where id = 10; -- удалить по конкретному id
delete from employees where id in (10, 8);  -- удалить по заданным id

-- insert into dep_emp values ();  -- реляционная таблица
delete from employees where id = 10; -- удалии элемент из основной табл.
delete  from dep_emp where emp_id = 10; -- удалили этот элемент из реаляционной табл.
-- весь департамент соединяем с dep_emp de (de - даем краткое название таблице), где id смежной таблицы = id департамента
select * from departments join dep_emp where dep_emp.dep_id = departments.id

-- additional Selects
select count(*) as count_of_pupils from pupils where first_name like ? or last_name like ?
select * from departments as d join dep_emp de where de.dep_id = d.id -- дали название департаменту d и далее так к нему обращаемся
select * from departments as d join dep_emp as de where de.dep_id = d.id -- дали имена таблицам и дальше их используем, можно без "as" через пробел
select * from departments d join dep_emp de where de.dep_id = d.id -- (без "as") - вернет полностью табл d и dе, получится дублирование id департамента
select id, name, emp_id from departments d join dep_emp de where de.dep_id = d.id -- получаем тоже, но без дублирования колонок id департамента, если много колонок, придется их перечислять
select * from departments as d left join dep_emp as de on d.id = de.dep_id -- к левой таблице присоединяет правую и берет только то, чего нет в левой, чтоб не дублировалась инфо

-- count(dep_id) подсчитывает кол-во dep_id, group by группируем по d.id (получим название департамента и кол-во чел. в нем, as employeer_count - называем колонку как удобно)
select d.id, d.name, count(dep_id) as employeer_count from departments as d join dep_emp de on d.id = de.dep_id group by d.id-- получаем тоже, но без дублирования колонок id департамента, если много колонок, придется их перечислять
-- добавляем сортировку (order by) от меньшего к большему (asc) - но можно не писать, если от большего к меньшему то (desc), можно сортировать по любой колонке
select d.id, d.name, count(dep_id) as employeer_count from departments as d join dep_emp de on d.id = de.dep_id group by d.id order by employeer_count asc

-- кол-во учеников по имени/фамилии
select count(*) as count_of_pupils from pupils where first_name like 'Боря' or last_name like '';
-- рейтинг посещаемости факультативов
select e.id, e.name, count(el_id) as pupils_count from electives as e join relation_el_pup as rep on e.id = rep.el_id group by e.id order by pupils_count desc;
-- ученики по id факультатива
select * from pupils left join relation_el_pup as rep on pupils.id = rep.pup_id where rep.el_id = 3;
-- ученики которые не в этом id факультатива, но выведит при этом ученика, который и в этом фак-ве если он еще и в др.факультативах
select * from pupils left join relation_el_pup as rep on pupils.id = rep.pup_id where rep.el_id != 3;

-- Select in Select, точно знать что список учеников не в группе 3, при условии что они есть в других группах
-- вывести всех учеников по тем ихним id, которые в таблице relation_el_pup не лежат на против el_id (in это коллекция, в неее передаем массив чисел)
-- верни весь список id учеников, которые в табл relation_el_pup равны группе 3, потом верни всех учеников, кроме тех id которых был в группе 3
select * from pupils where id not in {select id from pupils left join relation_el_pup rep on pupils.id = rep.pup_id where rep.el_id = 3};
-- ученики по всем факультативам (выводится id)
select * from pupils left join relation_el_pup as rep on pupils.id = rep.pup_id;
-- все факультативы по id ученика
select * from electives left join relation_el_pup as rep on electives.id = rep.el_id where rep.pup_id = 2;
-- все факультативы по всем ученикам
select * from electives left join relation_el_pup as rep on electives.id = rep.el_id;
-- переименование
select * from relation_el_pup where el_id = 'elective_id' and pup_id = 'pupil_id';

-- выводит 3 первых в таблице
select * from pupils limit 3;
-- пагинация, от первого до 10
select * from pupils limit 0, 10;
-- пагинация, второй десяток, т.е. начиная от 10гоэлемента + 10 елементов
select * from pupils limit 10, 10;
-- второй десяток с конца по id
select * from pupils order by id desc limit 10, 10;

-- Транзакция
start transaction; -- начали транзакцию
select * from pupils    -- цепочка запросов
select * from pupils
select * from pupils
commit; -- транзакцию закончили. Чревато потерянным обновлением

start transaction; -- начали транзакцию
lock tables pupils  -- лочим, чтоб не было потерянного обновления (можно на read or wright или одновременно)
select * from pupils    -- цепочка запросов
select * from pupils
select * from pupils
unlock tables pupils
commit; -- транзакцию закончили

start transaction; -- начали транзакцию
lock tables pupils  -- лочим, чтоб не было потерянного обновления (можно на read or wright или одновременно)
select * from pupils    -- цепочка запросов
select * from pupils
select * from pupils
unlock tables pupils
commit; -- транзакцию закончили
rollback -- откатили к исходному состоянию

delete from pupils where first_name like '%н%';
select count(id) from pupil where first_name like "%r%" and class < 30 and last_name like 'gordienko';
select count(id) from pupil where first_name like "%r%" and class < 30 and email in ('', '', '');






