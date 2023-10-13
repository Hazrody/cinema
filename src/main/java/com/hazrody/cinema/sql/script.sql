CREATE TABLE actor
(
    id         serial PRIMARY KEY,
    name       varchar(20) NOT NULL,
    first_name varchar(20) NOT NULL,
    birth_day  DATE        NOT NULL
);

CREATE TABLE director
(
    id         serial PRIMARY KEY,
    name       varchar(20) NOT NULL,
    first_name varchar(20) NOT NULL,
    birth_day  DATE        NOT NULL
);

CREATE TABLE movie
(
    id           serial PRIMARY KEY,
    name         varchar(20)  NOT NULL,
    description  varchar(200) NOT NULL,
    release_date DATE         NOT NULL,
    id_director  serial,
    FOREIGN KEY (id_director) REFERENCES director (id)
);

CREATE TABLE play_role
(
    id       serial PRIMARY KEY,
    id_actor serial NOT NULL,
    id_movie serial NOT NULL,
    FOREIGN KEY (id_actor) REFERENCES actor (id),
    FOREIGN KEY (id_movie) REFERENCES movie (id)
);
