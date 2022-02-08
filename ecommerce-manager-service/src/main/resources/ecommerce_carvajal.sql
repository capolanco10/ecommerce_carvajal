--BEGIN;

--SET AUTOCOMMIT = ON;

SET client_encoding = 'UTF8';

CREATE DATABASE ecommercemanager;

--GRANT ALL PRIVILEGES ON DATABASE ecommercemanager TO postgres;

CREATE TABLE IF NOT EXISTS customers (
	id serial NOT NULL,
	document_type int2 NOT NULL,
	document_number varchar(15) NOT NULL,
	"name" varchar(50) NOT NULL,
	CONSTRAINT customers_pk PRIMARY KEY (id),
	CONSTRAINT customers_un UNIQUE (document_type, document_number)
);

CREATE TABLE IF NOT EXISTS products (
	id serial NOT NULL,
	code varchar(100) NOT NULL,
	"name" varchar(50) NOT NULL,
	description varchar(200) NULL,
	unit_price numeric(15,2) NOT NULL,
	amount smallint NOT NULL,
	CONSTRAINT products_pk PRIMARY KEY (id),
	CONSTRAINT products_un UNIQUE (code)
);
CREATE UNIQUE INDEX products_id_idx ON products USING btree (id, code);

CREATE TABLE IF NOT EXISTS shoppingcart (
	id serial NOT NULL,
	id_customer integer NOT NULL,
	shoppingcart_date timestamp(0) NOT NULL,
	total_invoice numeric(15,2) NOT NULL DEFAULT 0.00,
	total_iva numeric(15,2) NOT NULL DEFAULT 0.00,
	CONSTRAINT shoppingcart_pk PRIMARY KEY (id),
	CONSTRAINT shoppingcart_un UNIQUE (id_customer,shoppingcart_date),
	CONSTRAINT shoppingcart_fk FOREIGN KEY (id_customer) REFERENCES customers(id)
);

CREATE TABLE IF NOT EXISTS shoppingcart_detail (
	id serial NOT NULL,
	id_shoppingcart integer NOT NULL,
	id_product integer NOT NULL,
	amount smallint NOT NULL,
	subtotal numeric(15,2) NOT NULL DEFAULT 0.00,
	total numeric(15,2) NOT NULL DEFAULT 0.00,
	CONSTRAINT shoppingcart_detail_pk PRIMARY KEY (id),
	CONSTRAINT shoppingcart_detail_un UNIQUE (id_shoppingcart,id_product),
	CONSTRAINT shoppingcart_detail_fk FOREIGN KEY (id_shoppingcart) REFERENCES shoppingcart(id),
	CONSTRAINT shoppingcart_detail_fk_1 FOREIGN KEY (id_product) REFERENCES products(id)
);

CREATE TABLE IF NOT EXISTS shoppingcarthistory (
	id serial NOT NULL,
	id_customer integer NOT NULL,
	shoppingcart_date timestamp(0) NOT NULL,
	id_product integer NOT NULL,
	amount smallint NOT NULL,
	CONSTRAINT shoppingcarthistory_pk PRIMARY KEY (id),
	CONSTRAINT shoppingcarthistory_un UNIQUE (id_customer,shoppingcart_date),
	CONSTRAINT shoppingcarthistory_fk FOREIGN KEY (id_customer) REFERENCES customers(id),
	CONSTRAINT shoppingcarthistory_fk_2 FOREIGN KEY (id_product) REFERENCES products(id)
);
