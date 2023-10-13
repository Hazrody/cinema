-- Actor
INSERT INTO actor(id, name, first_name, birth_day)
values (1, 'SMITH', 'Will', '1968-09-25');
INSERT INTO actor(id, name, first_name, birth_day)
values (2, 'GARFIELD', 'Andrew', '1983-08-20');

-- Director
INSERT INTO director(id, name, first_name, birth_day)
values (1, 'WEBB', 'Marc', '1974-08-31');
INSERT INTO director(id, name, first_name, birth_day)
values (2, 'BAY', 'Michael', '1965-02-17');

-- Movie
INSERT INTO movie(id,name, description, release_date, id_director)
values (1,
        'The Amazing Spider-man 2',
        'The Amazing Spider-Man 2 ou L’Extraordinaire Spider-Man au Québec est un film américain fantastique en 3-D réalisé par Marc Webb, sorti en 2014',
        '2014-04-16',
        1);
INSERT INTO movie(id,name, description, release_date, id_director)
values (2,
        'Bad Boys',
        'Bad Boys : Flics de choc ou Mauvais Garçons au Québec (Bad Boys) est une comédie policière américaine réalisée par Michael Bay et sortie en 1995. C''est le premier film réalisé par Michael Bay.',
        '1995-07-05',
        2);

-- Play role
INSERT INTO play_role(id_movie, id_actor)
values (1,2);
INSERT INTO play_role(id_movie, id_actor)
values (2,1);
