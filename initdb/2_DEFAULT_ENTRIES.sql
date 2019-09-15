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


INSERT INTO defaultdb.myfridge (id, id_product, onfridge) VALUES (1, 1, 2);
INSERT INTO defaultdb.myfridge (id, id_product, onfridge) VALUES (2, 3, 1);
INSERT INTO defaultdb.myfridge (id, id_product, onfridge) VALUES (3, 5, 4);
INSERT INTO defaultdb.myfridge (id, id_product, onfridge) VALUES (4, 7, 3);
INSERT INTO defaultdb.myfridge (id, id_product, onfridge) VALUES (5, 9, 2);
INSERT INTO defaultdb.myfridge (id, id_product, onfridge) VALUES (6, 11, 1);
INSERT INTO defaultdb.myfridge (id, id_product, onfridge) VALUES (7, 13, 4);

INSERT INTO defaultdb.mylist (id, id_product2, onlist) VALUES (1, 2, 3);
INSERT INTO defaultdb.mylist (id, id_product2, onlist) VALUES (2, 4, 1);
INSERT INTO defaultdb.mylist (id, id_product2, onlist) VALUES (3, 6, 2);
INSERT INTO defaultdb.mylist (id, id_product2, onlist) VALUES (4, 8, 4);
INSERT INTO defaultdb.mylist (id, id_product2, onlist) VALUES (5, 10, 2);
INSERT INTO defaultdb.mylist (id, id_product2, onlist) VALUES (6, 12, 3);
INSERT INTO defaultdb.mylist (id, id_product2, onlist) VALUES (7, 14, 1);