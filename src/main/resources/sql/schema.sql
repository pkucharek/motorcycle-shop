drop database if exists motorcycle_shop;
drop user if exists 'motorcycle'@'localhost';

CREATE USER 'motorcycle'@'localhost' IDENTIFIED BY 'motorcycle';
GRANT ALL PRIVILEGES ON * . * TO 'motorcycle'@'localhost';
ALTER USER 'motorcycle'@'localhost' IDENTIFIED WITH mysql_native_password BY 'motorcycle';

create table motorcycle (
	 id int(11) NOT NULL auto_increment
	,brand varchar(30) not null
    ,model varchar(30) not null
    ,production_year year not null
    ,


     check(production_year between(year("1885-01-01"), year(current_date()))
)