-- DROP SCHEMA public;

CREATE SCHEMA public;

-- public.pieza definition

-- Drop table

-- DROP TABLE public.pieza;

CREATE TABLE public.pieza (
	id serial4 NOT NULL,
	precio float4 NULL,
	descripcion varchar NULL,
	cod_pieza varchar NOT NULL,
	CONSTRAINT pieza_pk PRIMARY KEY (id)
);


-- public.almacen definition

-- Drop table

-- DROP TABLE public.almacen;

CREATE TABLE public.almacen (
	id serial4 NOT NULL,
	direccion varchar NULL,
	descripcion varchar NULL,
	CONSTRAINT almacen_pk PRIMARY KEY (id)
);


-- public.pieza_comp definition

-- Drop table

-- DROP TABLE public.pieza_comp;

CREATE TABLE public.pieza_comp (
	id serial4 NOT NULL,
	id_pieza int4 NOT NULL,
	id_pieza_comp int4 NOT NULL,
	CONSTRAINT pieza_comp_pk PRIMARY KEY (id),
	CONSTRAINT pieza_comp_fk FOREIGN KEY (id_pieza) REFERENCES public.pieza(id) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT pieza_comp_fk_1 FOREIGN KEY (id_pieza_comp) REFERENCES public.pieza(id) ON DELETE CASCADE ON UPDATE CASCADE
);


-- public.estanteria definition

-- Drop table

-- DROP TABLE public.estanteria;

CREATE TABLE public.estanteria (
	id serial4 NOT NULL,
	cod_estanteria varchar NULL,
	id_almacen int4 NULL,
	CONSTRAINT estanteria_pk PRIMARY KEY (id),
	CONSTRAINT estanteria_fk FOREIGN KEY (id_almacen) REFERENCES public.almacen(id) ON DELETE CASCADE ON UPDATE CASCADE
);


-- public.stoke definition

-- Drop table

-- DROP TABLE public.stoke;

CREATE TABLE public.stoke (
	id serial4 NOT NULL,
	cantidad int4 NOT NULL,
	id_pieza int4 NOT NULL,
	id_estanteria int4 NOT NULL,
	CONSTRAINT stoke_pk PRIMARY KEY (id),
	CONSTRAINT stoke_fk FOREIGN KEY (id_pieza) REFERENCES public.pieza(id) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT stoke_fk_1 FOREIGN KEY (id_estanteria) REFERENCES public.estanteria(id) ON DELETE CASCADE ON UPDATE CASCADE
);
