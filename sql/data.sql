-- Include table data insertion, updation, deletion and select scripts
-- -------------------------------------------------------------------
-- inserting the Movie List  into the table
-- -------------------------------------------------------------------

insert into movie_item 
values (1, 'Avatar', 278796508, 'Yes', '2017-03-15','Science Fiction','Yes'),
(2, 'The Avengers', 1518812988, 'Yes', '2017-12-23','Superher', 'No'),
(3, "TItanic", 218746394,'Yes','2017-08-21','Romance','No'),
(4, 'Jurassic World', 1671713208,'No','2017-07-02','Science Fiction','Yes'),
(5, 'Avengers: End Game', 275076034, 'Yes','2020-11-02','Superher','No');

select 
me_title as Title,
me_boxOffice as Box_Office,
me_active as Active,
me_date_of_launch as Date_Of_Launch,
me_genre as Genre,
me_hasTeaser as HasTeaser
from movie_item;
-- -------------------------------------------------------------------
-- updating the movie List values into the table
-- -------------------------------------------------------------------
update movie_item 
set me_title='Bigil',
me_boxOffice='1234567890',
me_active='No',
me_date_of_launch='2019-03-15',
me_genre='Thiller',
me_hasTeaser='No' where me_id=1;



-- -------------------------------------------------------------------
-- inserting the user values into the table
-- -------------------------------------------------------------------

insert into user
values(1,'Ravimal'),
(2,'Yuva'),(3,'Ani');

-- -------------------------------------------------------------------
-- inserting the favorite values into the table
-- -------------------------------------------------------------------

insert into favorite(ft_us_id,ft_mv_id)
values(1,2),(1,1),
(1,3),(2,5),(3,3);

-- -------------------------------------------------------------------
-- getting the movie items
-- -------------------------------------------------------------------

select 
me_title as Title,
me_boxOffice as Box_Office,
me_genre as Genre,
me_hasTeaser as HasTeaser
from movie_item
 where me_active='Yes' and me_date_of_launch < current_date();
-- -------------------------------------------------------------------
--  getting the movie Item Favorite list
-- -------------------------------------------------------------------

select 
me_title as Title,
me_boxOffice as Box_Office,
me_genre as Genre
from movie_item mv 
join favorite ft on(mv.me_id = ft.ft_id)
where  ft.ft_us_id=1;

-- -------------------------------------------------------------------
--  count the title names into the movie Item table
-- -------------------------------------------------------------------

select count(me_title)
from 
movie_item mv join favorite ft on(mv.me_id = ft.ft_id)
where  ft.ft_us_id=1;

-- -------------------------------------------------------------------
-- deleting the favorite movie from the favorite table
-- -------------------------------------------------------------------

delete from favorite
where ft_mv_id=3 and ft_us_id=1;

-- -------------------------------------------------------------------
--  retriving the  Favorite list  after deeleted
-- -------------------------------------------------------------------

select 
me_title as Title,
me_boxOffice as Box_Office,
me_genre as Genre
from movie_item mv 
join favorite ft on(mv.me_id = ft.ft_id)
where  ft.ft_us_id=1;
