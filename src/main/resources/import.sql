drop table movr_vw_movies;
create or replace view movr_vw_movies as select * from (select m.id, m.title, m.description, m.published_date, m.published_by_user_id, u.first_name, u.last_name,  count(case when o.opinion > 0 then 1 end) as likes, count(case when o.opinion < 0 then 1 end) as dislikes, timestampdiff(day, m.published_date, now()) as days_published from movr_movies m left join movr_opinions o on m.id = o.movie_id inner join movr_users u on m.published_by_user_id = u.id group by m.id, m.title, m.description, m.published_date, u.first_name, u.last_name) vw;