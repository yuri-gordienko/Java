CREATE SCHEMA `java_5` DEFAULT CHARACTER SET utf8; -- ценрт.хранилище табл-ц, только название схемы, если в сессии

mysql -u root -p -- подключение к БД через консоль
mysql> show databases -- покажи все таблички через консоль, когда уже подключены к БД
mysql> use java_5 -- какую Скему использовать

create table `java_5.pupils` -- создаем таблицу, даем название, емли мы не в сессии
create table pupils -- создаем таблицу, даем название, если мы в сессии
(
    id bigint auto_increment primary key,   -- тип значения, авто генерация (increment - шаг итерации 1), первичный (основной) ключ
    first_name varchar(255) not null,   -- поле не может быть пустым
    last_name varchar(255), -- может быть пустым
    class int not null,
    email varchar(255) not null
);

create table relation_el_pup    -- создаем смежную таблицу
(
   el_id bigint not null,
   pup_id bigint not null,
   primary key (el_id, pup_id),
   foreign key (el_id) references electives(id),    -- ссылка на primary key это foreign key, который ссылается на табл-цу в колонке id
   foreign key (pup_id) references pupils(id)
);