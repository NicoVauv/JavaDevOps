create table products
(
    id bigint auto_increment,
    constraint users_pk
        primary key (id),
    category TEXT not null,
    name TEXT not null,
    number int null,
    selected int null
);
