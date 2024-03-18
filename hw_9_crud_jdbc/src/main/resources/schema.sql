CREATE SCHEMA `java_5` DEFAULT CHARACTER SET utf8;

create table pupils
(
    id bigint auto_increment primary key,
    first_name varchar(255) not null,
    last_name varchar(255),
    class int not null,
    email varchar(255) not null
);

--insert into pupils values (default, 'Андрей', '', 5, 'andrey@ukr.net');
--insert into pupils values (default, 'Боря', 'Борисов', 9, 'bor@ukr.net');
--insert into pupils values (default, 'Серёжа', 'Андреев', 3, 'ser@ukr.net');
--insert into pupils values (default, 'Николай', 'Николаев', 11, 'nik@ukr.net');
--insert into pupils values (default, 'Александр', 'Александров', 11, 'alex@ukr.net');
--insert into pupils values (default, 'Димочка', '', 3, 'dim@ukr.net');

create table electives
(
    id bigint auto_increment primary key,
    name varchar(255) not null
);

--insert into electives values (default, 'Математика');
--insert into electives values (default, 'Інформатика');
--insert into electives values (default, 'Фізкультура');
--insert into electives values (default, 'Образотворче мистецтво');
--insert into electives values (default, 'Поезія');


create table relation_el_pup
(
   el_id bigint not null,
   pup_id bigint not null,
   primary key (el_id, pup_id),
   foreign key (el_id) references electives(id),
   foreign key (pup_id) references pupils(id)
);

--insert into relation_el_pup value (1, 2);
--insert into relation_el_pup value (1, 5);
--insert into relation_el_pup value (2, 5);
--insert into relation_el_pup value (2, 2);
--insert into relation_el_pup value (5, 2);
--insert into relation_el_pup value (3, 6);
--insert into relation_el_pup value (3, 3);
--insert into relation_el_pup value (3, 1);
--insert into relation_el_pup value (4, 1);
--insert into relation_el_pup value (5, 3);
--insert into relation_el_pup value (5, 5);
--insert into relation_el_pup value (3, 2);






