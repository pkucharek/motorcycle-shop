drop database if exists motorcycle_shop;
create database motorcycle_shop;

use motorcycle_shop;

create table motorcycle (
	 id int(11) not null primary key auto_increment
    ,model varchar(25) not null
    ,color varchar(25) not null
    ,type varchar(25) not null
    ,production_year year not null 
		check (production_year between
			year("1885-01-01") and year(current_date())
		)
	,cylinders int(2) check (cylinders between 1 and 12)
    ,engine_capacity int(5) check (engine_capacity between 1 and 3000)
);