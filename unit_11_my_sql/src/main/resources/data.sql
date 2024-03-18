# create
insert into employees values (4, 'Павло', 'Біліневич', 25);
insert into employees values (5, 'Юрій', 'Гордієнко', 40);
insert into employees values (6, 'Вадим', 'Єфіменко', 26);

insert into dep_emp values (4, 13)
insert into dep_emp values (1, 11);
insert into dep_emp values (3, 12);

# update
update employees set age = 19 where id = 1;
update dep_emp set dep_id = 2 where emp_id = 10;

# delete
delete from employees where id = 21;
delete from employees where id in (10, 8);  -- конкретні дані (cases)
--
delete from employees where id = 1; -- якщо видаляємо працівника, то
delete from dep_emp where id = 1; -- треба і видалити з реляційної таблиці
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

select * from departments d join dep_emp de
select * from departments d join dep_emp de where de.dep_id = d.id
select name, emp_id from departments d join dep_emp de where de.dep_id = d.id
select id, name, count(dep_id) as employee_count from departments d join dep_emp de on de.dep_id = d.id group by d.id
order by employee_count desc
select * from employees join dep_emp de on employees.id = de.emp_id where de.dep_id = 1;

-- find all emp in "Java"
select id, first_name, last_name from employees join dep_emp de on employees.id = de.emp_id where de.dep_id = 1;
-- find all emp not in java, наприклад звіт для потенційних клієнтів
select id, first_name, last_name, age from employees where id not in (
            select id from employees left join dep_emp de on employees.id = de.emp_id where de.dep_id = 1
)

-- just java Department
select id from employees left join dep_emp de on employees.id = de.emp_id where de.dep_id = 1
-- not in java Department
select id, first_name, last_name, age from employees where id not in (5, 6, 8, 9, 11);

--Пагинація (з якого елемента почати, скільки елементів витащити)
select * from employees limit 5
select * from employees limit 0, 10
select * from employees limit 10, 10
select * from employees order by email asc limit 20, 10
select * from employees order by id desc limit 20, 10