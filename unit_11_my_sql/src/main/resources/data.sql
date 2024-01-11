# create
insert into employees values (4, 'Павло', 'Біліневич', 25);
insert into employees values (5, 'Юрій', 'Гордієнко', 40);
insert into employees values (6, 'Вадим', 'Єфіменко', 26);

insert into dep_emp values (1, 5)
insert into dep_emp values (1, 6);
insert into dep_emp values (2, 9);

# update
update employees set age = 19 where id = 1;

# delete
delete from employees where id = 1;
delete from employees where id in (10, 8);  -- конкретні дані (cases)
--
delete from employees where id = 1; -- якщо видаляємо працівника, то
delete from dep_emp where ud = 1; -- треба і видалити з реляційної таблиці
--


# read
select * from employees;
select id from employees;
select id, last_name, age from employees;
select * from employees where id = 2;
select first_name from employees where id = 2;
select * from employees where age < 29;
select * from employees where age > 25 and age < 39;
--select * from employees where age > 25 and age < 39 and .... and .....;
select * from employees where age in (21, 22);
select * from employees where first_name like 'м%';
select * from employees where first_name like '%а';
select * from employees where first_name like '%р%';    -- має таку букву будь де у слові
select * from employees where first_name like '%р%' and first_name not like '%р';
select * from employees where upper(first_name) = 'EVA';
select * from employees where first_name like 'Юрій' or last_name like 'Єфіменко';
select count(*) as count_of_employee from employees where first_name like 'Юрій' or last_name like 'Єфіменко';

