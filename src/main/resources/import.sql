INSERT INTO public.ingredient (id, name, type) VALUES ('FLTO', 'Flour Tortilla', 'WRAP');
INSERT INTO public.ingredient (id, name, type) VALUES ('COTO', 'Corn Tortilla', 'WRAP');
INSERT INTO public.ingredient (id, name, type) VALUES ('GRBF', 'Ground Beef', 'PROTEIN');
INSERT INTO public.ingredient (id, name, type) VALUES ('CARN', 'Carnitas', 'PROTEIN');
INSERT INTO public.ingredient (id, name, type) VALUES ('DITM', 'Diced Tomatoes', 'VEGGIES');
INSERT INTO public.ingredient (id, name, type) VALUES ('LETC', 'Lettuce', 'VEGGIES');
INSERT INTO public.ingredient (id, name, type) VALUES ('CHED', 'Cheddar', 'CHEESE');
INSERT INTO public.ingredient (id, name, type) VALUES ('MOJA', 'Monterrey Jack', 'CHEESE');
INSERT INTO public.ingredient (id, name, type) VALUES ('SLSA', 'Salsa', 'SAUCE');
INSERT INTO public.ingredient (id, name, type) VALUES ('SRCR', 'Sour Cream', 'SAUCE');
INSERT INTO public.ingredient (id, name, type) VALUES ('RNCH', 'Ranch', 'SAUCE');
INSERT INTO public.ingredient (id, name, type) VALUES ('LEMO', 'Lemon', 'CITRON');
INSERT INTO public.ingredient (id, name, type) VALUES ('LIME', 'Lime', 'CITRON');
INSERT INTO public.ingredient (id, name, type) VALUES ('ORNG', 'Orange', 'CITRON');



INSERT INTO public.users (id, city, full_name, password, phone_number, username, zip) VALUES (1, 'Tbilisi', 'admin', '$2a$10$K7gGiEcJcD1Zt8urHfUjM.7MMQQHsgl6GB4Q09.r80flt67PnZryS', '-', 'admin', '10001');
INSERT INTO public.users (id, city, full_name, password, phone_number, username, zip) VALUES (2, 'Batumi', 'user', '$2a$10$4eNavQ8KOrTtlQiu7JNcG.5dZ.CMeJEqZaFiaufN5SzYY0r.Ud7rm', '123456789', 'user', '20002');


INSERT INTO public.taco (created_at, id, name) VALUES ('2024-03-02 18:11:22.456000', 1, 'Meeeeeeeh');
INSERT INTO public.taco (created_at, id, name) VALUES ('2024-03-02 18:11:43.357000', 2, 'Salata');
INSERT INTO public.taco (created_at, id, name) VALUES ('2024-03-02 18:11:58.884000', 3, 'SAUKETESO TACO');
INSERT INTO public.taco (created_at, id, name) VALUES ('2024-03-02 18:12:57.192000', 4, 'Meat (taco)');
INSERT INTO public.taco (created_at, id, name) VALUES ('2024-03-02 18:13:46.788000', 5, 'TACO ELITE');


INSERT INTO public.taco_order (id, placed_at, user_id, cc_expiration, cc_number, cccvv, delivery_city, delivery_name, delivery_state, delivery_street, delivery_zip) VALUES (2, '2024-03-02 18:13:24.246000', 2, '02/25', '43157040846021522', '123', 'Kutaisi', 'user', '-', 'Tamar mefe str.', '30003');
INSERT INTO public.taco_order (id, placed_at, user_id, cc_expiration, cc_number, cccvv, delivery_city, delivery_name, delivery_state, delivery_street, delivery_zip) VALUES (1, '2024-03-02 18:12:37.440000', 2, '02/26', '4315704085014313', '123', 'Batumi', 'user', '-', 'Davit mefe str.', '20002');
INSERT INTO public.taco_order (id, placed_at, user_id, cc_expiration, cc_number, cccvv, delivery_city, delivery_name, delivery_state, delivery_street, delivery_zip) VALUES (3, '2024-03-02 18:14:02.973000', 1, '05/25', '4315704085014313', '123', 'Tbilisi', 'ADMIN', '-', 'Mirian mefe str.', '10001');


INSERT INTO public.taco_order_tacos (taco_order_id, tacos_id) VALUES (1, 1);
INSERT INTO public.taco_order_tacos (taco_order_id, tacos_id) VALUES (1, 2);
INSERT INTO public.taco_order_tacos (taco_order_id, tacos_id) VALUES (1, 3);
INSERT INTO public.taco_order_tacos (taco_order_id, tacos_id) VALUES (2, 4);
INSERT INTO public.taco_order_tacos (taco_order_id, tacos_id) VALUES (3, 5);


INSERT INTO public.taco_ingredients (taco_id, ingredients_id) VALUES (1, 'FLTO');
INSERT INTO public.taco_ingredients (taco_id, ingredients_id) VALUES (2, 'DITM');
INSERT INTO public.taco_ingredients (taco_id, ingredients_id) VALUES (2, 'LETC');
INSERT INTO public.taco_ingredients (taco_id, ingredients_id) VALUES (2, 'MOJA');
INSERT INTO public.taco_ingredients (taco_id, ingredients_id) VALUES (2, 'SLSA');
INSERT INTO public.taco_ingredients (taco_id, ingredients_id) VALUES (2, 'LIME');
INSERT INTO public.taco_ingredients (taco_id, ingredients_id) VALUES (3, 'FLTO');
INSERT INTO public.taco_ingredients (taco_id, ingredients_id) VALUES (3, 'COTO');
INSERT INTO public.taco_ingredients (taco_id, ingredients_id) VALUES (3, 'GRBF');
INSERT INTO public.taco_ingredients (taco_id, ingredients_id) VALUES (3, 'CARN');
INSERT INTO public.taco_ingredients (taco_id, ingredients_id) VALUES (3, 'DITM');
INSERT INTO public.taco_ingredients (taco_id, ingredients_id) VALUES (3, 'LETC');
INSERT INTO public.taco_ingredients (taco_id, ingredients_id) VALUES (3, 'CHED');
INSERT INTO public.taco_ingredients (taco_id, ingredients_id) VALUES (3, 'MOJA');
INSERT INTO public.taco_ingredients (taco_id, ingredients_id) VALUES (3, 'SLSA');
INSERT INTO public.taco_ingredients (taco_id, ingredients_id) VALUES (3, 'SRCR');
INSERT INTO public.taco_ingredients (taco_id, ingredients_id) VALUES (3, 'RNCH');
INSERT INTO public.taco_ingredients (taco_id, ingredients_id) VALUES (3, 'LEMO');
INSERT INTO public.taco_ingredients (taco_id, ingredients_id) VALUES (3, 'LIME');
INSERT INTO public.taco_ingredients (taco_id, ingredients_id) VALUES (3, 'ORNG');
INSERT INTO public.taco_ingredients (taco_id, ingredients_id) VALUES (4, 'GRBF');
INSERT INTO public.taco_ingredients (taco_id, ingredients_id) VALUES (4, 'CARN');
INSERT INTO public.taco_ingredients (taco_id, ingredients_id) VALUES (4, 'SLSA');
INSERT INTO public.taco_ingredients (taco_id, ingredients_id) VALUES (4, 'LIME');
INSERT INTO public.taco_ingredients (taco_id, ingredients_id) VALUES (5, 'COTO');
INSERT INTO public.taco_ingredients (taco_id, ingredients_id) VALUES (5, 'GRBF');
INSERT INTO public.taco_ingredients (taco_id, ingredients_id) VALUES (5, 'DITM');
INSERT INTO public.taco_ingredients (taco_id, ingredients_id) VALUES (5, 'CHED');
INSERT INTO public.taco_ingredients (taco_id, ingredients_id) VALUES (5, 'SLSA');
INSERT INTO public.taco_ingredients (taco_id, ingredients_id) VALUES (5, 'LIME');