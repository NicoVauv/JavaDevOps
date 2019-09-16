INSERT INTO defaultdb.products (id, category, name) VALUES (1, 'Drink', 'Coca');
INSERT INTO defaultdb.products (id, category, name) VALUES (2, 'Drink', 'Fanta');
INSERT INTO defaultdb.products (id, category, name) VALUES (3, 'Drink', 'Oasis');
INSERT INTO defaultdb.products (id, category, name) VALUES (4, 'Drink', 'Redbull');
INSERT INTO defaultdb.products (id, category, name) VALUES (5, 'Drink', 'Jus de pomme');
INSERT INTO defaultdb.products (id, category, name) VALUES (6, 'Drink', 'Orangina');
INSERT INTO defaultdb.products (id, category, name) VALUES (7, 'Drink', 'Sprite');
INSERT INTO defaultdb.products (id, category, name) VALUES (8, 'Food', 'Guacamole');
INSERT INTO defaultdb.products (id, category, name) VALUES (9, 'Food', 'Chips');
INSERT INTO defaultdb.products (id, category, name) VALUES (10, 'Food', 'Carpaccio');
INSERT INTO defaultdb.products (id, category, name) VALUES (11, 'Food', 'Foie gras');
INSERT INTO defaultdb.products (id, category, name) VALUES (12, 'Food', 'Pates');
INSERT INTO defaultdb.products (id, category, name) VALUES (13, 'Food', 'Frites');
INSERT INTO defaultdb.products (id, category, name) VALUES (14, 'Food', 'Steack haché');

INSERT INTO defaultdb.myfridge (id, reference) VALUES (1, 'R9Uv3f');
INSERT INTO defaultdb.myfridge (id, reference) VALUES (2, 'K6v10a');

INSERT INTO defaultdb.mylist (id, id_list_fridge) VALUES (1, 1);
INSERT INTO defaultdb.mylist (id, id_list_fridge) VALUES (2, 2);

INSERT INTO defaultdb.users (id, pseudo, mail, password) VALUES (1, 'Quentin', 'quentin.bonnefond@epfedu.fr', 'qb');
INSERT INTO defaultdb.users (id, pseudo, mail, password) VALUES (2, 'Théo', 'theo.geniesse@epfedu.fr', 'tg');
INSERT INTO defaultdb.users (id, pseudo, mail, password) VALUES (3, 'Nico', 'nicolas.vauvillier@epfedu.fr', 'nv');

INSERT INTO defaultdb.productslist (id, id_product_list, id_list_product, onlist) VALUES (1, 1, 1, 2);
INSERT INTO defaultdb.productslist (id, id_product_list, id_list_product, onlist) VALUES (2, 3, 1, 1);
INSERT INTO defaultdb.productslist (id, id_product_list, id_list_product, onlist) VALUES (3, 5, 1, 4);
INSERT INTO defaultdb.productslist (id, id_product_list, id_list_product, onlist) VALUES (4, 7, 1, 3);
INSERT INTO defaultdb.productslist (id, id_product_list, id_list_product, onlist) VALUES (5, 9, 1, 2);
INSERT INTO defaultdb.productslist (id, id_product_list, id_list_product, onlist) VALUES (6, 11, 1, 1);
INSERT INTO defaultdb.productslist (id, id_product_list, id_list_product, onlist) VALUES (7, 13, 1, 4);

INSERT INTO defaultdb.productsfridge (id, id_product_fridge, id_fridge_product, onfridge) VALUES (1, 2, 1, 3);
INSERT INTO defaultdb.productsfridge (id, id_product_fridge, id_fridge_product, onfridge) VALUES (2, 4, 1, 1);
INSERT INTO defaultdb.productsfridge (id, id_product_fridge, id_fridge_product, onfridge) VALUES (3, 6, 1, 2);
INSERT INTO defaultdb.productsfridge (id, id_product_fridge, id_fridge_product, onfridge) VALUES (4, 8, 1, 4);
INSERT INTO defaultdb.productsfridge (id, id_product_fridge, id_fridge_product, onfridge) VALUES (5, 10, 1, 2);
INSERT INTO defaultdb.productsfridge (id, id_product_fridge, id_fridge_product, onfridge) VALUES (6, 12, 1, 3);
INSERT INTO defaultdb.productsfridge (id, id_product_fridge, id_fridge_product, onfridge) VALUES (7, 14, 1, 1);

INSERT INTO defaultdb.userslist (id, id_user_list, id_list_user) VALUES (1, 1, 1);
INSERT INTO defaultdb.userslist (id, id_user_list, id_list_user) VALUES (2, 2, 1);
INSERT INTO defaultdb.userslist (id, id_user_list, id_list_user) VALUES (3, 3, 1);