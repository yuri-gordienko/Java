--countries, descriptions
insert into tours values (1, 'Switzerland', 'Від розкоші до бурхливих річок, скелястих зелених гір та водоспадів', 'від 15 200 грн.');
insert into tours values (2, 'Italy', 'Багата історія, багаті маршрути для активного відпочинку', 'від 12 540 грн.');
insert into tours values (3, 'Spain', 'Гарячі краєвиди, гарячі пляжі, гарячі танці, гарячі емоції', 'від 12 950 грн.');
insert into tours values (4, 'France', 'Оргомна країна з величезною різноманітною природою та місцевістю', 'від 17 860 грн.');
insert into tours values (5, 'Scotland', 'Край світу із зеленими ландшафтами та безтрашними кельтами', 'від 19 760 грн.');
insert into tours values (6, 'Norway', 'Неповторне північне сяйво, снігові гори, глибокі озера', 'від 21 660 грн.');


--tour_variants
--rout
insert into tour_variants values (1, '7 діб', '14 діб', '0001', 'Групове харчування у місті розташування', '15 200 грн.', '27 360 грн.', 'Згідно з старовинною легендою, коли Господь розподіляв багатства земних надр, на країну в самому серці Європи, Швейцарію їх не вистачило. Щоб виправити цю несправедливість, Бог подарував їй високі гори, сяючі льодовики, бурхливі водоспади, мальовничі долини, найкрасивіші річки та найчистіші блакитні озера. Надзвичайно прекрасні види Швейцарії приваблюють тисячі туристів, це ніби особливий чарівний світ, що змушує повірити в те, що рай існує.', 1);
insert into tour_variants values (2, '7 діб', '14 діб', '0002', 'Групове харчування у місті розташування', '12 540 грн.', '21 320 грн.', 'Казкова Італія, пам`ятки якої мовчазно свідчать про багату історію, викликає величезний інтерес у мандрівників. Ми представляємо найзнаменитіші та найдавніші її міста - Рим, Мілан, Флоренція, Венеція. Їхня велична краса нікого не залишає байдужим. Але щоб відчути неповторний італійський колорит, потрібно зійти з вторинних туристичних стежок та дослідити маленькі затишні містечка. Тут дбайливо зберігають справжню культуру та традиції країни.',2);
insert into tour_variants values (3, '7 діб', '14 діб', '0003', 'Групове харчування у місті розташування', '12 950 грн.', '22 100 грн.', 'Природа Іспанії дуже контрастна через рельєфні особливості. Різноманітність природних пейзажів, якими вирізняється Іспанія, вражає. Гори, ліси та долини, вулкани, дюни та пустелі, озера, а також водно-болотні угіддя, море, скелясті береги, водоспади та ущелини.',3);
insert into tour_variants values (4, '7 діб', '14 діб', '0004', 'Групове харчування у місті розташування', '17 860 грн.', '30 300 грн.', 'Франція – одна з найчарівніших і найпрекрасніших країн Європи. І окрім культурної спадщини, країна багата на рідкісні мальовничі пейзажі.  Природні умови Франції досить різноманітні. Тут можна знайти буквально все – прибережні рівнини, обширні долини річок, оточені живописними горбами, невисокі гірські ланцюги, високі гірські масиви Альп, а також старовинні замки.', 4);
insert into tour_variants values (5, '7 діб', '14 діб', '0005', 'Групове харчування у місті розташування', '19 760 грн.', '33 600 грн.', 'Шотландська природа вже давно вражає кожного туриста, що приїжджає сюди. Ця невелика країна має багату історію та дуже гарну природу. Шотландські пейзажі дуже різноманітні: гірські річки з водоспадами, чисті озера, болота, суворі гори та перевали, горбисті долини, хвойні ліси, мальовниче узбережжя, альпійські луки, фіорди, численні острови.', 5);
insert into tour_variants values (6, '7 діб', '14 діб', '0006', 'Групове харчування у місті розташування', '21 660 грн.', '36 800 грн.', 'Норвегія – неймовірна країна, яка може похвалитися незайманою природою: від розлогих фіордів та льодовиків до наймальовничіших берегів та зелених пасовищ. Природа Норвегії – це світ, повністю сформований суворим північним кліматом, північними морями та горами. Держава розташована за Полярним колом. З травня до липня в Норвегії – полярний день, з осені до ранньої весни панує полярна ніч, яку розцвічує полярне сяйво.', 6);

--tour_images
--Switzerland
insert into tour_images values (1, 'https://www.intrepidtravel.com/adventures/wp-content/uploads/2015/09/gimmelwald-switz.jpg', true);
insert into tour_images values (2, 'https://www.telegraph.co.uk/content/dam/travel/Spark/swiss-tb-2020/_switzerland-lake-oeschinen-credit-switzerland-tourism.jpg', false);
insert into tour_images values (3, 'https://ychef.files.bbci.co.uk/1280x720/p09pgt8j.jpg', false);
insert into tour_images values (4, 'https://media.myswitzerland.com/image/fetch/c_lfill,g_auto,w_3200,h_1800/f_auto,q_80,fl_keep_iptc/https://www.myswitzerland.com/-/media/dam/resources/experience/r/u/ruinaulta%20%20switzerlands%20grand%20canyon/images%20summer/27964_32001800.jpeg', false);
insert into tour_images values (5, 'https://cdn.tourradar.com/s3/serp/original/4466_HVQt6zmv.jpg', false);
insert into tour_images values (6, 'https://livingnomads.com/wp-content/uploads/2020/10/10/switzerland-travel-blog.jpg', false);
insert into tour_images values (7, 'https://www.intrepidtravel.com/adventures/wp-content/uploads/2018/09/shutterstock_719299507-800.jpg', false);
insert into tour_images values (8, 'https://roadtripeuroguide.com/wp-content/uploads/2022/07/Wide-Image-58-1024x683.jpg', false);

--Italy
insert into tour_images values (9, 'https://cdn.britannica.com/82/195482-050-2373E635/Amalfi-Italy.jpg', true);
insert into tour_images values (10, 'https://images.movehub.com/wp-content/uploads/2019/12/17-TTK-italy-A.jpg', false);
insert into tour_images values (11, 'https://d3dqioy2sca31t.cloudfront.net/Projects/cms/production/000/033/273/slideshow/fe4b9c40eeb71b3290d068a92061770a/slide-italy-main-cinque-terre-manarola.jpg', false);
insert into tour_images values (12, 'https://www.tripsavvy.com/thmb/_al1RbqVrheYkXAdg7W6LQT9B4Q=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/gardena-pass--a-high-mountain-pass-in-the-dolomites-of-the-south-tyrol-in-italy-1168875336-19b2f964c6794e93ae24d9555ec36467.jpg', false);
insert into tour_images values (13, 'https://www.flydubai.com/en/media/Italy-710x473_tcm8-112753.jpg', false);
insert into tour_images values (14, 'https://a.storyblok.com/f/53624/1600x720/94957de25d/vfr_venice_italy_canal.jpg', false);
insert into tour_images values (15, 'https://planetofhotels.com/guide/sites/default/files/styles/node__blog_post__bp_banner/public/2021-10/Manarola.jpg', false);
insert into tour_images values (16, 'https://i.natgeofe.com/n/e808d332-f4f2-4e34-a597-755bed0e86d8/unesco-site-dolomites-alps-mountains-missurina-lake-italy_2x1.jpg', false);

--Spain
insert into tour_images values (17, 'https://dynamic-media-cdn.tripadvisor.com/media/photo-o/26/4a/c8/4b/caption.jpg?w=1200&h=-1&s=1&cx=1920&cy=1080&chk=v1_cad5a636ac09c2268d99', true);
insert into tour_images values (18, 'https://www.telegraph.co.uk/content/dam/eip/spain-2023/underrated-destinations/spain-hidden-places-6-segovia-getty.jpg', false);
insert into tour_images values (19, 'https://cdn.images.express.co.uk/img/dynamic/25/590x/Spain-top-pic-1479134.jpg?r=1630045112250', false);
insert into tour_images values (20, 'https://www.usnews.com/object/image/0000015b-67f3-d5af-a37f-7ff772aa0000/bcspain-profile-editorial.spain_profile?update-time=1502913441728&size=superhero-medium', false);
insert into tour_images values (21, 'https://joinuplviv.com/wp-content/uploads/2016/04/dyuny-dyu-pylat.jpg', false);
insert into tour_images values (22, 'https://media.product.which.co.uk/prod/images/ar_2to1_1500x750/7c5e4ab783e8-costa-blanca-beach.jpg', false);
insert into tour_images values (23, 'https://www.migratingmiss.com/wp-content/uploads/2017/03/Alpujarras-Mountain-Villages-Spain-34.jpg', false);
insert into tour_images values (24, 'https://www.fodors.com/wp-content/uploads/2019/11/BestHiddenVillagesSpain__HERO_panoramica-cudillero-atardecer.jpg', false);

--France
insert into tour_images values (25, 'https://image.cnbcfm.com/api/v1/image/107083533-1656642957063-gettyimages-1297070972-gty_bre-35-saintmalo-17-dji_0434.jpeg?v=1656643265', true);
insert into tour_images values (26, 'https://media.timeout.com/images/105237848/image.jpg', false);
insert into tour_images values (27, 'https://i.insider.com/540e03aa69bedd9366255d1c?width=1000&format=jpeg&auto=webp', false);
insert into tour_images values (28, 'https://media.timeout.com/images/105678752/image.jpg', false);
insert into tour_images values (29, 'https://handluggageonly.co.uk/wp-content/uploads/2018/04/Hand-Luggage-Only-17.jpg', false);
insert into tour_images values (30, 'https://www.tripsavvy.com/thmb/8g729moR3pXSq6I3Xcol-7CNvcU=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/MontBlancGettyIWestend61-59329c745f9b589eb44e83cf-07d76a7883454947b4e37ff3d1dbcefc.jpg', false);
insert into tour_images values (31, 'https://a-z-animals.com/media/2022/09/Mont-Blanc-1024x683.jpg', false);
insert into tour_images values (32, 'https://www.planetware.com/photos-large/F/france-french-alps-grenoble.jpg', false);

--Scotland
insert into tour_images values (33, 'https://deih43ym53wif.cloudfront.net/scotland-540119_89be5fa890.jpeg', true);
insert into tour_images values (34, 'https://s27363.pcdn.co/wp-content/uploads/2020/05/Scotland-Itinerary.jpg.optimal.jpg', false);
insert into tour_images values (35, 'https://cdn.britannica.com/17/99617-050-59E1B89B/Eilean-Donan-Castle-Scottish-Highlands.jpg', false);
insert into tour_images values (36, 'https://d3dqioy2sca31t.cloudfront.net/Projects/cms/production/000/030/333/original/99f3a44e4f292ced4d17017905f35369/article-scotland-isle-of-skye-sheep.jpg', false);
insert into tour_images values (37, 'https://api.time.com/wp-content/uploads/2014/09/highlander.jpg', false);
insert into tour_images values (38, 'https://www.planetware.com/wpimages/2019/02/scotland-best-places-to-visit-isle-of-skye.jpg', false);
insert into tour_images values (39, 'https://media.vietravel.com/images/NewsPicture/loch-ness_1.jpg', false);
insert into tour_images values (40, 'https://lp-cms-production.imgix.net/2022-05/Scotland-Edinburgh-Andrew-Merry-GettyImages-1058297160-RFC.jpg?auto=format&q=75', false);

--Norway
insert into tour_images values (41, 'https://cdn.britannica.com/64/94864-050-223C3FE6/Northern-lights-sky-Kautokeino.jpg', true);
insert into tour_images values (42, 'https://cdn.kimkim.com/files/a/content_articles/featured_photos/0b0380328634337d807c971ee73c92fadbc51cdd/big-9a58778640ae1199f127401b5400e01a.jpg', false);
insert into tour_images values (43, 'https://www.state.gov/wp-content/uploads/2018/11/Norway-2560x1300.jpg', false);
insert into tour_images values (44, 'https://media.timeout.com/images/105237855/image.jpg', false);
insert into tour_images values (45, 'https://s27363.pcdn.co/wp-content/uploads/2020/05/Northern-Norway-Itinerary.jpg.optimal.jpg', false);
insert into tour_images values (46, 'https://cdn.theatlantic.com/media/img/photo/2017/09/landscapes-of-norway/n01_699932404-1/original.jpg', false);
insert into tour_images values (47, 'https://cdn.britannica.com/40/59040-050-BEAE1332/fjords-North-Sea-coast-Norway.jpg', false);
insert into tour_images values (48, 'https://www.thediscoveriesof.com/wp-content/uploads/2022/11/Norway-shutterstock_1504345343-720x540.jpg.webp', false);

--tour_image
insert into tour_image values (1, 1);
insert into tour_image values (1, 2);
insert into tour_image values (1, 3);
insert into tour_image values (1, 4);
insert into tour_image values (1, 5);
insert into tour_image values (1, 6);
insert into tour_image values (1, 7);
insert into tour_image values (1, 8);

insert into tour_image values (2, 9);
insert into tour_image values (2, 10);
insert into tour_image values (2, 11);
insert into tour_image values (2, 12);
insert into tour_image values (2, 13);
insert into tour_image values (2, 14);
insert into tour_image values (2, 15);
insert into tour_image values (2, 16);

insert into tour_image values (3, 17);
insert into tour_image values (3, 18);
insert into tour_image values (3, 19);
insert into tour_image values (3, 20);
insert into tour_image values (3, 21);
insert into tour_image values (3, 22);
insert into tour_image values (3, 23);
insert into tour_image values (3, 24);

insert into tour_image values (4, 25);
insert into tour_image values (4, 26);
insert into tour_image values (4, 27);
insert into tour_image values (4, 28);
insert into tour_image values (4, 29);
insert into tour_image values (4, 30);
insert into tour_image values (4, 31);
insert into tour_image values (4, 32);

insert into tour_image values (5, 33);
insert into tour_image values (5, 34);
insert into tour_image values (5, 35);
insert into tour_image values (5, 36);
insert into tour_image values (5, 37);
insert into tour_image values (5, 38);
insert into tour_image values (5, 39);
insert into tour_image values (5, 40);

insert into tour_image values (6, 41);
insert into tour_image values (6, 42);
insert into tour_image values (6, 43);
insert into tour_image values (6, 44);
insert into tour_image values (6, 45);
insert into tour_image values (6, 46);
insert into tour_image values (6, 47);
insert into tour_image values (6, 48);


--tour_videos
insert into tour_videos values (1, 'https://www.youtube.com/embed/OY0M8FYeYas');
insert into tour_videos values (2, 'https://www.youtube.com/embed/JKSFr-jDzL4');
insert into tour_videos values (3, 'https://www.youtube.com/embed/aOWWOM_BCeU');
insert into tour_videos values (4, 'https://www.youtube.com/embed/dHETNfXZw-E');
insert into tour_videos values (5, 'https://www.youtube.com/embed/F6qYKrTPiVU');
insert into tour_videos values (6, 'https://www.youtube.com/embed/F6qYKrTPiVU');

--tour_video
insert into tour_video values (1, 1);
insert into tour_video values (2, 2);
insert into tour_video values (3, 3);
insert into tour_video values (4, 4);
insert into tour_video values (5, 5);
insert into tour_video values (6, 6);


