CREATE TABLE AMIGOS(
    ID SERIAL NOT NULL PRIMARY KEY,
    NOMBRE VARCHAR(20) NOT NULL,
    APELLIDO VARCHAR(20) NOT NULL,
    TELEFONO VARCHAR(20) NOT NULL,
    DIRECCION VARCHAR(20)NOT NULL,
    CORREO VARCHAR(50) NOT NULL
);


insert into amigos(nombre,apellido,telefono,direccion,correo) values('Danno','Nunez','3144596646','Villa Samper','carlos.nunez@unillanos.edu.co');
insert into amigos(nombre,apellido,telefono,direccion,correo) values('Edgar','Lozada','3228190672','Catumare','edgar.lozada@unillanos.edu.co');
insert into amigos(nombre,apellido,telefono,direccion,correo) values('Johan','Albarracin','3219294561','Villavicencio','johan.albarracin@unillanos.edu.co');
