create database test;
use test;
create table card(id INT PRIMARY KEY AUTO_INCREMENT,title VARCHAR(50),subtitle VARCHAR(50),description VARCHAR(1000),
				picture VARCHAR(50),cardtype VARCHAR(50),person VARCHAR(30),ext VARCHAR(500),status VARCHAR(10),
				gmtcreate DATE,gmtupdate DATE);
