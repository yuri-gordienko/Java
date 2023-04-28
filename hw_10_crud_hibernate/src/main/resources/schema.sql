CREATE SCHEMA `java_5` DEFAULT CHARACTER SET utf8;

create table pupils
(
    id bigint auto_increment primary key,
    first_name varchar(255) not null,
    last_name varchar(255),
    class int not null,
    email varchar(255) not null
);

--insert into pupils values (default, 'Андрей', 'Андреев', 5, 'andrey@ukr.net');
--insert into pupils values (default, 'Борис', 'Борисов', 3, 'bor@ukr.net');
--insert into pupils values (default, 'Сергей', 'Серый', 3, 'ser@ukr.net');
--insert into pupils values (default, 'Николай', 'Николаев', 2, 'nik@ukr.net');
--insert into pupils values (default, 'Александр', 'Александров', 4, 'alex@ukr.net');
--insert into pupils values (default, 'Дмитрий', 'Ананасов', 2, 'dim@ukr.net');


create table electives
(
    id bigint auto_increment primary key,
    name varchar(255) not null
);

--insert into electives values (default, 'Golang');
--insert into electives values (default, '.NET/C#');
--insert into electives values (default, 'Основи програмування');
--insert into electives values (default, 'Java');
--insert into electives values (default, 'Python');
--insert into electives values (default, 'Front-end');


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
--insert into relation_el_pup value (6, 1);
--insert into relation_el_pup value (4, 1);
--insert into relation_el_pup value (5, 3);
--insert into relation_el_pup value (5, 6);
--insert into relation_el_pup value (3, 2);






