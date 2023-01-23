CREATE TABLE AMIGOS(
    ID NUMBER NOT NULL PRIMARY KEY,
    NOMBRE VARCHAR(20) NOT NULL,
    APELLIDO VARCHAR(20) NOT NULL,
    TELEFONO VARCHAR(20) NOT NULL,
    DIRECCION VARCHAR(20)NOT NULL,
    CORREO VARCHAR(50) NOT NULL
);

CREATE SEQUENCE INCREMENTO
    START WITH 1
    INCREMENT BY 1;

CREATE OR REPLACE TRIGGER TRI_AMIGOS BEFORE INSERT ON AMIGOS
FOR EACH ROW
BEGIN
    SELECT INCREMENTO.NEXTVAL INTO :NEW.ID FROM DUAL;
END;
/
insert into amigos values(null,'Danno','Nunez','3144596646','Villa Samper','carlos.nunez@unillanos.edu.co');
insert into amigos values(null,'Edgar','Lozada','3228190672','Catumare','edgar.lozada@unillanos.edu.co');
insert into amigos values(null,'Johan','Albarracin','3219294561','Villavicencio','johan.albarracin@unillanos.edu.co');

