CREATE TABLE IF NOT EXISTS authors
(
    id          SERIAL primary key,
    first_name  varchar(50) not null,
    middle_name varchar(50),
    last_name   varchar(50) not null
);

CREATE TABLE IF NOT EXISTS genres
(
    id      SERIAL primary key,
    name    varchar(25) not null,
    name_ru varchar(25) not null
);

CREATE TABLE IF NOT EXISTS books
(
    id          SERIAL primary key,
    name        varchar(100) not null,
    genre_id    int          not null REFERENCES genres (id),
    year        int          not null,
    author_id   int          not null REFERENCES authors (id)
);