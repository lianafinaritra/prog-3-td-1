create table book
(
    id     serial,
    title  varchar,
    author_id int references author(id),
    page_number int not null default 0,
    release_date date,
    primary key (id)
);