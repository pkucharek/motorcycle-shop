use motorcycle_shop;
insert into motorcycle
	(brand, model, color, type, production_year, cylinders, engine_capacity)
values 
	("Yamaha", "Fazer", "black", "standard", 1999, 4, 600);
    
insert into motorcycle
	(brand, model, color, type, production_year, cylinders, engine_capacity)
values 
	("Honda", "Cbr", "orange", "sport bike", 2018, 6, 1000);
    
insert into motorcycle
	(brand, model, color, type, production_year, cylinders, engine_capacity)
values 
	("Harley-Davidson", "Street Rod", "black", "cruiser", 2020, 6, 800);
    
insert into motorcycle
	(brand, model, color, type, production_year, cylinders, engine_capacity)
values 
	("Suzuki", "Gladius", "white-blue", "naked", 2016, 4, 650);

insert into motorcycle
	(brand, model, color, type, production_year, cylinders, engine_capacity)
values 
	("Romet", "ZXT125", "red", "naked", 2020, 4, 125); 


insert into users
values
('john', '{noop}john', 1),
('mary', '{noop}mary', 1),
('susan', '{noop}susan', 1);


insert into authorities
values
('john', 'ROLE_USER'),
('mary', 'ROLE_USER'),
('susan', 'ROLE_USER');
