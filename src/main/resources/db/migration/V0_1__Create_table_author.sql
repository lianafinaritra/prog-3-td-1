create table author
(
    id     serial,
    name varchar,
    birth_date  date,
    particularity varchar,
    primary key (id),
    constraint name_Author UNIQUE(name)
);