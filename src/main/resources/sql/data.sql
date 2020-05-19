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


insert into users (username, password, first_name, last_name, email)
values
('john', '{bcrypt}$2y$12$GjGnKYqityw3yMTv5beQDuyRMzASYX2ObnnxXDz1uSg8pqyz8pVdO', 'John', 'Doe', 'john@company.com'),
('mary', '{bcrypt}$2y$12$QmjaQIK/nOHWdRuF6nAxIOn8ZVQxdMQHJ8N23toWox.aYVB2.reEC', 'Mary', 'Public', 'mary@company.com'),
('susan', '{bcrypt}$2y$12$/vsaTjiTSJE0HzogXZHLauxyiXyY7HOBoGUaI/5VXmp/H3RSiFxVW', 'Susan', 'Adams', 'susan@company.com'),
('peter', '{bcrypt}$2y$12$y10KD/vLKmjM1GNYV/WJX.BBSRpuyX2yyuWLHSuXPuP5GWKgG8CU2', 'Peter', 'Johnson', 'piotr@company.com');


insert into role (name)
values
('ROLE_USER'),
('ROLE_SELLER'),
('ROLE_ADMIN');
