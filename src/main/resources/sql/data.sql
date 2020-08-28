use motorcycle_shop;
insert into motorcycle
	(brand, model, color, type, production_year, cylinders, engine_capacity)
values
	("Yamaha", "Fazer", "czarny", "szosowo-turystyczny", 1999, 4, 600);

insert into motorcycle
	(brand, model, color, type, production_year, cylinders, engine_capacity)
values
	("Honda", "Cbr", "pomarańczowy", "sportowy", 2018, 6, 1000);

insert into motorcycle
	(brand, model, color, type, production_year, cylinders, engine_capacity)
values
	("Harley-Davidson", "Street Rod", "czarno-biały", "cruiser", 2020, 6, 800);

insert into motorcycle
	(brand, model, color, type, production_year, cylinders, engine_capacity)
values
	("Suzuki", "Gladius", "biało-niebieski", "naked", 2016, 4, 650);

insert into motorcycle
	(brand, model, color, type, production_year, cylinders, engine_capacity)
values
	("Romet", "ZXT125", "zielony", "naked", 2020, 4, 125);


insert into user (username, password, first_name, last_name, email, phone_number, balance)
values
('jan', '$2y$12$TsEAMCX.eWcfRR6R1NHMDenK.q4dyM3aAOdyIILE4dbWLuxpMkY7m', 'Jan', 'Adamski', 'jan@company.com', '123456789', 500),
('anna', '$2y$12$6FWT/Bm.bBBDzUodXmmi.uaZXijwD/U5ViiBU4RfB9h84U9lE4mCW', 'Anna', 'Nowak', 'anna@organizacja.com', '456123789', 10000),
('tomek', '$2y$12$xO2mraOyGwhJjMa1hNNQhe.CMYNF6WdzcTTYdkPqIECisTtFRjNtu', 'Tomek', 'Kowalczyk', 'tomek@firma.com', '789123456', 15000),
('karolina', '$2y$12$WHt5L/kmSmTiqFrbOVxpAeH0WjkZp1oFBqBhXt9BzLuRyP5GKfJ4S', 'Karolina', 'Wiśniewska', 'karolina@praca.com', '654321789', 25000);


insert into role (name)
values
('ROLE_USER'),
('ROLE_SELLER'),
('ROLE_ADMIN');

INSERT INTO users_roles (user_id, role_id)
VALUES
(1, 1),
(1, 2),
(1, 3),
(2, 1),
(2, 2),
(3, 1),
(4, 1);


insert into offer (owner_id,  buyer_id, motorcycle_id, submission_date, purchase_date, price, expire_date, expired, image_name)
values (1, null, 1, curdate(), null, 6000, curdate() + interval 30 day, false, "yamaha-fazer.jpg");

insert into offer (owner_id,  buyer_id, motorcycle_id, submission_date, purchase_date, price, expire_date, expired, image_name)
values (1, null, 2, curdate() - interval 2 day, null, 15000, curdate() + interval 28 day, false, "honda-cbr.jpg");

insert into offer (owner_id,  buyer_id, motorcycle_id, submission_date, purchase_date, price, expire_date, expired, image_name)
values (2, null, 3, curdate() - interval 5 day, null, 20000, curdate() + interval 25 day, false, "harley-davidson.jpg");

insert into offer (owner_id,  buyer_id, motorcycle_id, submission_date, purchase_date, price, expire_date, expired, image_name)
values (3, null, 4, curdate() - interval 10 day, null, 1500, curdate() + interval 20 day, false, "suzuki-gladius.jpg");

insert into offer (owner_id,  buyer_id, motorcycle_id, submission_date, purchase_date, price, expire_date, expired, image_name)
values (3, null, 5, curdate() - interval 8 day, null, 4000, curdate() + interval 22 day, false, "romet-zxt-125.jpg");
