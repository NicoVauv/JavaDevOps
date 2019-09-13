create table products
(
    id bigint auto_increment,
    constraint products_pk
        primary key (id),
    category TEXT not null,
    name TEXT not null
);

create table users
(
    id bigint auto_increment,
    constraint users_pk
        primary key (id),
    pseudo TEXT not null,
    mail TEXT not null,
    password int not null
);

create table myfridge
(
    id bigint auto_increment,
    constraint myfridge_pk
        primary key (id),
    id_product bigint not null,
    constraint fk_products
        foreign key (id_product) references products(id),
    onfridge int not null
);

create table mylist
(
    id bigint auto_increment,
    constraint mylist_pk
        primary key (id),
    id_product2 bigint not null,
    constraint products2_fk
        foreign key (id_product2) references products(id),
    onlist int not null
);
