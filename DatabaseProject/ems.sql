CREATE DATABASE testdb;

USE testdb;

CREATE TABLE IF NOT EXISTS employee (
emp_id BIGINT AUTO_INCREMENT,
emp_name VARCHAR(50) NOT NULL,
emp_sal DOUBLE NOT NULL,
CONSTRAINT pk_employee PRIMARY KEY(emp_id)
);