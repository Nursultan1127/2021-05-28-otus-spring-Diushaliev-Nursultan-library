INSERT INTO genres (name, name_ru)
values ('FANTASY', 'фэнтези'),
       ('SCI_FI', 'научная фантастика'),
       ('MYSTERY', 'таинственное'),
       ('THRILLER', 'триллер'),
       ('ROMANCE', 'роман'),
       ('WESTERNS', 'вестерны'),
       ('DYSTOPIAN','антиутопия'),
       ('CONTEMPORARY', 'современное');

INSERT INTO authors(first_name, middle_name, last_name)
values ('Jerome', 'David', 'Salinger'),
       ('Jane', null, 'Austen'),
       ('Margaret', null, 'Mitchell');

INSERT INTO books(name, genre_id, year, author_id)
values ('The Catcher in the Rye', 5, 1951, 1)