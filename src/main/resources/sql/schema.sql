use motorcycle_shop;

drop table if exists motorcycle;

create table motorcycle (
   id int(11) not null primary key auto_increment
  ,brand varchar(25) not null
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

drop table if exists user;
create table user (
  id int(11) not null auto_increment primary key
  ,username varchar(50) not null
  ,password char(68) not null
  ,first_name varchar(50) not null
  ,last_name varchar(50) not null
  ,email varchar(50) not null
);

drop table if exists role;
create table role (
   id int(11) not null auto_increment primary key
  ,name varchar(50) default null
);

