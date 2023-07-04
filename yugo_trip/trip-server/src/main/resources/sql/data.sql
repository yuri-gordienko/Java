--countries
insert into tours values (1, 'Switzerland', 'Very different...');
insert into tours values (2, 'Italy', 'Very old inerestin history');
insert into tours values (3, 'Spain', 'Hot country and girls');
insert into tours values (4, 'France', 'Big different country');
insert into tours values (5, 'Ireland', 'Puzzle country');

--tour_variants
insert into tour_variants values (1, 'moutains, rivers', 1);
insert into tour_variants values (2, 'beaches, foods',2);
insert into tour_variants values (3, 'dunes at see and rocks',3);
insert into tour_variants values (4, 'castles', 4);
insert into tour_variants values (5, 'ice', 5);

--tour_images
insert into tour_images values (1, 'https://www.intrepidtravel.com/adventures/wp-content/uploads/2015/09/gimmelwald-switz.jpg', true);
insert into tour_images values (2, 'https://i.ytimg.com/vi/J6-W0BW9odU/maxresdefault.jpg', false);
insert into tour_images values (3, 'https://www.planavac.com/wp-content/uploads/2017/05/Switzerland-Things-To-Do.jpg', false);

insert into tour_images values (4, 'https://cdn.britannica.com/82/195482-050-2373E635/Amalfi-Italy.jpg', true);
insert into tour_images values (5, 'https://d2rdhxfof4qmbb.cloudfront.net/wp-content/uploads/20180301194244/Rome-Tile.jpg', false);
insert into tour_images values (6, 'https://www.flavoursholidays.co.uk/wp-content/uploads/2022/02/18-fun-facts-you-didnt-know-about-italy-BI-3-1.jpg', false);

insert into tour_images values (7, 'https://delivery.gfobcontent.com/api/public/content/84db648ffef84c26a4ddedd60e13145e?v=2e4d4e49', true);
insert into tour_images values (8, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRnBIFZrD1PebciSK71MirtL_vtLZ8PuBIXbA&usqp=CAU', false);
insert into tour_images values (9, 'https://www.afdb.org/sites/default/files/spain.jpg', false);

insert into tour_images values (10, 'https://travelpassionate.com/wp-content/uploads/2019/08/Menton-beach.jpg', true);
insert into tour_images values (11, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQmlafAIvgIkyOa2FYRR4dp-JZuPeVWOzrf8w&usqp=CAU', false);
insert into tour_images values (12, 'https://media.cntraveler.com/photos/5d31ecfc56e5d10008e44f1c/1:1/w_2667,h_2667,c_limit/Etretat,-Normandy_GettyImages-685331049.jpg', false);

insert into tour_images values (13, 'https://www.wesleyjohnston.com/users/ireland/images/historical/spitzbergen.jpg', true);
insert into tour_images values (14, 'https://ichef.bbci.co.uk/news/976/cpsprodpb/2EE5/production/_128950021_newcastle.jpg', false);
insert into tour_images values (15, 'https://i.insider.com/55ba7a3c2acae78b0e8bb849?width=700', false);


--tour_image
insert into tour_image values (1, 1);
insert into tour_image values (1, 2);
insert into tour_image values (1, 3);

insert into tour_image values (2, 4);
insert into tour_image values (2, 5);
insert into tour_image values (2, 6);

insert into tour_image values (3, 7);
insert into tour_image values (3, 8);
insert into tour_image values (3, 9);

insert into tour_image values (4, 10);
insert into tour_image values (4, 11);
insert into tour_image values (4, 12);

insert into tour_image values (5, 13);
insert into tour_image values (5, 14);
insert into tour_image values (5, 15);

--update
update tours set country = 'Ireland' where id = 5;


