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
    password TEXT not null
);

create table myfridge
(
    id bigint auto_increment,
    constraint myfridge_pk
        primary key (id),
    reference TEXT not null
);

create table mylist
(
    id bigint auto_increment,
    constraint mylist_pk
        primary key (id),
    id_list_fridge bigint not null,
    constraint fk_list_fridge
        foreign key (id_list_fridge) references myfridge(id)
);


create table productslist
(
    id bigint auto_increment,
    constraint productslist_pk
        primary key (id),
    id_list_product bigint not null,
    constraint fk_list_product
        foreign key (id_list_product) references mylist(id),
    id_product_list bigint not null,
    constraint fk_product_list
        foreign key (id_product_list) references products(id),
    unique (id_product_list, id_list_product),
    onlist int not null
);

create table productsfridge
(
    id bigint auto_increment,
    constraint productsfridge_pk
        primary key (id),
    id_product_fridge bigint not null,
    constraint fk_product_fridge
        foreign key (id_product_fridge) references products(id),
    id_fridge_product bigint not null,
    constraint fk_fridge_product
        foreign key (id_fridge_product) references myfridge(id),
    unique (id_product_fridge, id_fridge_product),
    onfridge int not null
);

create table userslist
(
    id bigint auto_increment,
    constraint users_pk
        primary key (id),
    id_user_list bigint not null,
    constraint fk_user_list
        foreign key (id_user_list) references users(id),
    id_list_user bigint not null,
    constraint fk_list_user
        foreign key (id_list_user) references mylist(id),
    unique (id_user_list, id_list_user)
);
