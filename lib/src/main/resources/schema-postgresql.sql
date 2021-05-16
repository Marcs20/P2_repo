CREATE TABLE IF NOT EXISTS cliente (
	id serial PRIMARY KEY,
	nome varchar(50),
	marca varchar(20),
	modelo varchar(50),
	país varchar(20),
	email varchar(50)

);