insert into book (id, title, page_number, author_id)
values (1, 'The Girl ...', 120, 1);
insert into book (id, title, page_number, author_id)
values (2, 'Until I Found You', 75, 2);
insert into book (id, title, page_number, author_id)
values (3, 'Indro', 600, 3);
insert into book (id, title, page_number, author_id)
values (4, 'La bataille commence ici', 254, 4);
insert into book (id, title, page_number, author_id)
values (5, 'No time for toxic people', 468, 5);

alter sequence book_id_seq restart with 6;
