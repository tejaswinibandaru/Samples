CREATE database brsdb;

USE DATABASE brsdb;

CREATE TABLE customer(
user_id BIGINT PRIMARY KEY AUTO_INCREMENT  NOT NULL,
user_name VARCHAR(30) NOT NULL,
password VARCHAR(30) NOT NULL,
user_type VARCHAR(30) NOT NULL,
email VARCHAR(30)  NOT NULL,
phone_number BIGINT  NOT NULL,
delete_flag INT  NOT NULL);


CREATE TABLE bus(
bus_id BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
bus_name VARCHAR(30) NOT NULL,
bus_type VARCHAR(30) NOT NULL,
bus_class VARCHAR(30) NOT NULL,
no_of_seats INT NOT NULL,
source VARCHAR(30)  NOT NULL,
destination VARCHAR(30)  NOT NULL,
cost decimal  NOT NULL, 
delete_flag INT  NOT NULL);



CREATE TABLE booking(
booking_id BIGINT PRIMARY KEY AUTO_INCREMENT,
date_of_journey TIMESTAMP NOT NULL,
mode_of_payment VARCHAR(30) NOT NULL,
total_cost DECIMAL  NOT NULL ,
booking_status VARCHAR(30) NOT NULL,
delete_flag INT  NOT NULL
);


CREATE table passenger(
passenger_id BIGINT PRIMARY KEY auto_increment  NOT NULL,
passenger_name VARCHAR(30)  NOT NULL,
passenger_age INT  NOT NULL,
passenger_gender CHAR NOT NULL);

CREATE TABLE bus_transaction(
transaction_id BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
date TIMESTAMP NOT NULL,
available_seats INT NOT NULL,
delete_flag INT NOT NULL);
