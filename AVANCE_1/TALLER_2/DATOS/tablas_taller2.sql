/*
CREACION DE LA ESTRUCTURA DE TABLAS
*/
CREATE TABLE cargos(
	cod_cargo INT NOT NULL PRIMARY KEY,
	cargo VARCHAR(100) NOT NULL
);

CREATE TABLE empleados(
	identificacion INT NOT NULL PRIMARY KEY,
	tipo VARCHAR(5),
	nombre_1 VARCHAR(50),
	nombre_2 VARCHAR(50),
	apellido_1 VARCHAR(50),
	apellido_2 VARCHAR(50),
	sexo VARCHAR(1),
	fecha_n DATE,
	lugar_n VARCHAR(100),
	direccion VARCHAR(50),
	telefono VARCHAR(50),
	email VARCHAR(100),
	salario NUMERIC,
	activo VARCHAR(1)
);

CREATE TABLE historial_laboral(
	empleado INT NOT NULL,
	fecha_ingreso DATE,
	fecha_salida DATE,
	cargo INT NOT NULL,
	actual VARCHAR(2) NOT NULL,
	PRIMARY KEY(empleado,actual),
	CONSTRAINT fk_empleado FOREIGN KEY(empleado) REFERENCES empleados(identificacion),
	CONSTRAINT fk_cargo FOREIGN KEY(cargo) REFERENCES cargos(cod_cargo)
);

CREATE TABLE elementos(
	codigo INT NOT NULL PRIMARY KEY,
	elemento VARCHAR(50),
	devolutivo VARCHAR(2),
	talla VARCHAR(2),
	uso VARCHAR(12),
	materiales VARCHAR(300),
	mantenimiento VARCHAR(300),
	usos VARCHAR(300),
	norma VARCHAR(300),
	atenuacion VARCHAR(50),
	serial VARCHAR(250),
	tallas VARCHAR(250),
	unidad INT,
	ruta VARCHAR(800)
);

CREATE TABLE entrega_elementos(
	id_entrega INT NOT NULL,
	elemento INT NOT NULL,
	vigente VARCHAR(3),
	numero VARCHAR(15),
	devolutivo VARCHAR(2),
	fecha_devolucion DATE,
	empleado INT NOT NULL,
	fecha DATE,
	PRIMARY KEY(id_entrega,elemento,empleado),
	CONSTRAINT fk_elemento FOREIGN KEY(elemento) REFERENCES elementos(codigo),
	CONSTRAINT fk_entrega_empleado FOREIGN KEY(empleado) REFERENCES empleados(identificacion)
);

CREATE TABLE elementos_asignados(
	empleado INT NOT NULL,
	elemento INT NOT NULL,
	actual VARCHAR(2),
	numero VARCHAR(3),
	cantidad INT,
	duracion INT,
	PRIMARY KEY(empleado,elemento,actual),
	CONSTRAINT fk_ele_asig_empleado FOREIGN KEY(empleado) REFERENCES empleados(identificacion),
	CONSTRAINT fk_ele_asig_elemento FOREIGN KEY(elemento) REFERENCES elementos(codigo)
);