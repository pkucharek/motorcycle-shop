# motorcycle-shop

This project is a simple motorcycle shop where you can buy, sell or view motorcycles.

## How to run project

Here are requirements you need to meet before running this project:
1. Have MySQL installed and running on your computer. This project is using version 8.0.21.
2. Have database named `motorcycle_shop`.
3. Have username with `motorcycle` name and `motorcycle` password with `ALL PRIVILEGES` granted.

You can accomplish steps 2 and 3 opening `mysql` commandline and inserting this commands:
```sql
CREATE DATABASE motorcycle_shop;
CREATE USER 'motorcycle'@'localhost' IDENTIFIED BY 'motorcycle';
GRANT ALL PRIVILEGES ON *.* TO 'motorcycle'@'localhost';
```

Here are steps you need to follow to run this project:
1. Download source code of this project using method you prefer most.
2. Open command line and change directory to root directory of this project.
3. Run command `mvnw spring-boot:run`.
 
