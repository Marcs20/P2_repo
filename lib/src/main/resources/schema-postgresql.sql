CREATE TABLE IF NOT EXISTS cliente (
	id serial PRIMARY KEY,
	nome varchar(50),
	marca varchar(20),
	modelo varchar(50),
	país varchar(20),
	email varchar(50)

);

CREATE TABLE IF NOT EXISTS carros_br (
	id serial PRIMARY KEY,
	marca varchar(20),
	modelo varchar(50),
	ano varchar(04),
	pais varchar(20)

);

CREATE TABLE IF NOT EXISTS carros_eu (
	id serial PRIMARY KEY,
	marca varchar(20),
	modelo varchar(50),
	ano varchar(04),
	pais varchar(20)

);


CREATE TABLE IF NOT EXISTS carros_as (
	id serial PRIMARY KEY,
	marca varchar(20),
	modelo varchar(50),
	ano varchar(04),
	pais varchar(20)

);


