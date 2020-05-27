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
	("Harley-Davidson", "Street Rod", "czarny", "cruiser", 2020, 6, 800);
    
insert into motorcycle
	(brand, model, color, type, production_year, cylinders, engine_capacity)
values 
	("Suzuki", "Gladius", "biało-niebieski", "naked", 2016, 4, 650);

insert into motorcycle
	(brand, model, color, type, production_year, cylinders, engine_capacity)
values 
	("Romet", "ZXT125", "czerwony", "naked", 2020, 4, 125); 


insert into user (username, password, first_name, last_name, email)
values
('jan', '$2y$12$TsEAMCX.eWcfRR6R1NHMDenK.q4dyM3aAOdyIILE4dbWLuxpMkY7m', 'Jan', 'Adamski', 'jan@company.com'),
('maria', '$2y$12$iFoZb5xxjNIVBNfyq4RkCeJ4bWoPd6RpscrwOOFtJ.o6V82TqyrOS', 'Maria', 'Curie', 'maria@company.com'),
('sandra', '$2y$12$XAmI9mYySg8Z7xsIGCuXouyTQpC00iDfAdCYCAf.Bal0C1YSsQAU6', 'Sandra', 'Malczyk', 'sandra@company.com'),
('piotr', '$2y$12$FhERKd4oTbb3YR8lIi3TU.ACU35dDEmz.zoOKAzmngdz9ZnTnQNje', 'Piotr', 'Kucharek', 'piotr@company.com');


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
