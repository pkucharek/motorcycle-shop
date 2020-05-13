drop database if exists motorcycle_shop;
create database motorcycle_shop;

use motorcycle_shop;

create table color (
	 id int(3) not null primary key
    ,color varchar(25) not null
);

create table brand (
	 id int(5) not null primary key
    ,brand varchar(25) not null
);

create table model (
	 id int(8) not null primary key
    ,brand_id int(5) not null references brand(id)
    ,name varchar(25) not null
);

create table type (
	 id int(2) not null primary key
    ,name varchar(25) not null
);

create table motorcycle (
	 id int(11) not null primary key
    ,model_id int(8) not null references model (id)
    ,color_id int(3) not null references color (id)
    ,type_id int(2) not null references type (id)
    ,production_year year not null 
		check (production_year between
			year("1885-01-01") and year(current_date())
		)
	,cylinders int(2) check (cylinders between 1 and 12)
    ,engine_capacity int(5) check (engine_capacity between 1 and 3000)
);