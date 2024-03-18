--mysql

--Централізоване зберіганння таблиць, яку якусь предметну область, згрупованих по визначеному признаку
CREATE SCHEMA `test` DEFAULT CHARACTER SET utf8;

--Якщо ми не в сесії -
--Входимо у сесію через консоль (тобто попадаємо в Схему, сесію: use "test" - тобто вказуємо назву конкретної таблиці):
$mysql -u root -p
mysql> show databases;
mysql> use test;
mysql> create table `employees`
--Або через консоль в Ідеї заходимо в сесію таким чином - назва "таблиці.назва під таблиці":
create table `test.employees`
(
);

--Якщо ми в контексті конкретної Database або Схеми, то команда зменшується:
--id - назва колонки;
--bigint - тип змінних в колонці;
--auto_increment - БД сама генерує значення в колонці по методу додавання +1 до попереднього і воно є число,
--якщо перший видаляється, то попередній не займається, залишається порожнім;
--primary key - пояснюємо що це саме буде айдішнік;
--null - може бути наловим, але можна не ставити
create table employees
(
    id bigint auto increment primary key,
    first_name varchar(255) null,
    last_name varchar(255) null,
    email varchar(255) not null,
    age int null
);

create table departments
(
    id bigint auto_increment primary key,
    name varchar(255) not null
);

--primary key (dep_id, emp_id), - вказуємо, які ключи є основними і це айдішніки
--foreign key - додатковий ключ для(emp_id), це посилання тобто references на табличку employees на колонку (id)
create table dep_emp
(
    dep_id bigint not null,
    emp_id bigint not null,
    primary key (dep_id, emp_id),
    foreign key (dep_id) references departments(id),
    foreign key (emp_id) references employees(id)
)




