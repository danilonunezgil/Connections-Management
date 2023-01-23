--CONSULTAS
--1. Listado de empleados: Identificación, nombres y apellidos en una sola columna, fecha de nacimiento, lugar de nacimiento y salario. Los datos deben estar ordenados por la identificación.
SELECT emp.identificacion,
CONCAT_WS(' ',emp.nombre_1,emp.nombre_2,emp.apellido_1,emp.apellido_2) AS nombre_completo,
emp.fecha_n AS fecha_nacimiento, emp.lugar_n AS lugar_nacimiento, emp.salario
FROM empleados AS emp
ORDER BY emp.identificacion;

--2. Listado de empleados: Identificación, nombres y apellidos, cargo y fecha ingreso. Los datos deben estar ordenados por la identificación y la fecha de ingreso de forma descendente. 
SELECT emp.identificacion,
CONCAT_WS(' ',emp.nombre_1,emp.nombre_2,emp.apellido_1,emp.apellido_2) AS nombre_completo,
car.cargo, hist.fecha_ingreso FROM empleados AS emp
INNER JOIN historial_laboral AS hist ON hist.empleado = emp.identificacion
INNER JOIN cargos AS car ON car.cod_cargo = hist.cargo
ORDER BY emp.identificacion DESC, hist.fecha_ingreso DESC;

--3. Listado de cargos.
SELECT * FROM CARGOS;

--4. Listado de cargos que actualmente están asignados.
SELECT DISTINCT car.cod_cargo, car.cargo FROM cargos AS car
INNER JOIN historial_laboral AS hist ON hist.cargo = car.cod_cargo
AND hist.actual ='S';

--5. Listado de cargos que actualmente están asignados y la cantidad de empleados que lo tienen asignado
SELECT car.cod_cargo, car.cargo,
COUNT(hist.empleado) AS cantidad_empleados
FROM cargos AS car
INNER JOIN historial_laboral AS hist ON hist.cargo=car.cod_cargo
AND hist.actual = 'S'
GROUP BY car.cod_cargo;

--6. Historial laboral de cada empleado ordenado por empleado y la fecha de ingreso, debe incluir el nombre completo del empleado y la identificación. 
SELECT emp.identificacion,
CONCAT_WS(' ',emp.nombre_1,emp.nombre_2,emp.apellido_1,emp.apellido_2) AS nombre_completo,
hist.fecha_ingreso, hist.fecha_salida, hist.cargo, hist.actual
FROM empleados AS emp
INNER JOIN historial_laboral AS hist ON hist.empleado = emp.identificacion
ORDER BY hist.empleado, hist.fecha_ingreso;

--7. Listado de cargos que comiencen por la palabra “TECNICO”.
SELECT * FROM cargos AS car WHERE car.cargo LIKE'TECNICO%';

--8. Listado de cargos que comiencen por la palabra “AUXILIAR”.
SELECT * FROM cargos AS car WHERE car.cargo LIKE'AUXILIAR%';

--9. Listado de cargos que contenga  las letras “ADSL”.
SELECT * FROM cargos AS car WHERE car.cargo LIKE'%ADSL%'

--10. Listados de los empleados cuya fecha de salida sea nula, debe incluir el nombre completo del empleado y la identificación. 
SELECT CONCAT_WS(' ',emp.nombre_1,emp.nombre_2,emp.apellido_1,emp.apellido_2) AS nombre_completo, emp.identificacion
FROM empleados AS emp
INNER JOIN historial_laboral AS hist ON hist.empleado = emp.identificacion
WHERE hist.fecha_salida IS NULL;

--11. Elementos asignados a cada empleado que estén vigentes (actual=’S’), debe incluir el nombre completo del empleado, la identificación y el nombre del elemento asignado. Ordenar los resultados por identificación y elemento de forma ascendente. 
SELECT CONCAT_WS(' ',emp.nombre_1,emp.nombre_2,emp.apellido_1,emp.apellido_2) AS nombre_completo, emp.identificacion,
el.elemento FROM empleados AS emp
INNER JOIN elementos_asignados AS ela ON ela.empleado = emp.identificacion
INNER JOIN elementos AS el ON el.codigo = ela.elemento
WHERE ela.actual = 'S'
ORDER BY emp.identificacion ASC, el.elemento ASC;

--12. Historial de elementos asignados a cada empleado, debe incluir el nombre completo del empleado, la identificación, el nombre del elemento asignado, cantidad, duración y talla (es el campo numero). Ordenar los resultados por identificación y elemento de forma ascendente.
SELECT CONCAT_WS(' ',emp.nombre_1,emp.nombre_2,emp.apellido_1,emp.apellido_2) AS nombre_completo, emp.identificacion,
el.elemento, ela.cantidad, ela.duracion, ela.numero FROM elementos_asignados AS ela
INNER JOIN elementos AS el ON el.codigo = ela.elemento
INNER JOIN empleados AS emp ON emp.identificacion = ela.empleado
ORDER BY emp.identificacion ASC, el.elemento ASC;

--13. Entregas realiza, la cual debe incluir: el Id de entrega, el empleado, el elemento  y la fecha de entrega, el listado debe estar ordenado por la fecha de entrega de forma descendente. 
SELECT entre_ele.id_entrega, entre_ele.empleado, entre_ele.elemento, entre_ele.fecha
FROM entrega_elementos AS entre_ele
ORDER BY entre_ele.fecha DESC;

--14. Elementos entregados a cada trabajador. 
SELECT CONCAT_WS(' ',emp.nombre_1,emp.nombre_2,emp.apellido_1,emp.apellido_2) AS trajador, ele.elemento
FROM entrega_elementos AS entre_ele
INNER JOIN empleados AS emp ON emp.identificacion = entre_ele.empleado
INNER JOIN elementos AS ele ON ele.codigo = entre_ele.elemento;

--15. Total de elementos entregados a cada trabajador, agrupados por elemento. 
SELECT emp.identificacion, CONCAT_WS(' ',emp.nombre_1,emp.nombre_2,emp.apellido_1,emp.apellido_2) AS nombre_completo,
ele.elemento ,COUNT(entre_ele.elemento) AS total_entregado
FROM entrega_elementos AS entre_ele
INNER JOIN empleados AS emp ON emp.identificacion = entre_ele.empleado
INNER JOIN elementos AS ele ON ele.codigo = entre_ele.elemento
GROUP BY emp.identificacion,ele.elemento;

--16. Total elementos entregados, agrupados por elementos.
SELECT ele.codigo, ele.elemento, COUNT(ele.codigo) AS total_entregados
FROM elementos AS ele
INNER JOIN entrega_elementos AS entre_ele ON entre_ele.elemento = ele.codigo
GROUP BY ele.codigo, ele.elemento;

--17. Ficha técnica de cada elemento, ordenado por el nombre del elemento en orden ascendente.
SELECT * FROM elementos AS el ORDER BY el.elemento ASC;

--18. Listado de empleados y los elementos que les están pendientes por entregar.
SELECT emp.identificacion,
CONCAT_WS(' ',emp.nombre_1,emp.nombre_2,emp.apellido_1,emp.apellido_2) AS nombre_completo, e.elemento
FROM empleados AS emp
INNER JOIN elementos_asignados AS ela ON ela.empleado = emp.identificacion
INNER JOIN elementos AS e ON e.codigo = ela.elemento
left JOIN entrega_elementos AS el ON el.elemento = e.codigo
WHERE el.elemento IS NULL 
ORDER BY emp.identificacion;

--19. El elemento más solicitado.
SELECT el.codigo, el.elemento, COUNT(el.codigo) AS solicitudes
FROM elementos AS el
INNER JOIN elementos_asignados AS ela ON ela.elemento = el.codigo
GROUP BY el.codigo, el.elemento
HAVING COUNT(el.codigo) = (SELECT MAX(cantidad.total) FROM (SELECT COUNT(elemento) AS TOTAL FROM elementos_asignados GROUP BY elemento) AS cantidad);

--20. Listado de elementos entregados y la cantidad, durante el segundo periodo del año 2009. 
SELECT el.codigo, el.elemento, SUM(ela.cantidad) AS cantidad_entregada
FROM elementos AS el 
INNER JOIN elementos_asignados AS ela ON ela.elemento = el.codigo
INNER JOIN entrega_elementos AS entre_ele ON entre_ele.elemento = ela.elemento AND entre_ele.empleado = ela.empleado
WHERE entre_ele.fecha BETWEEN '01/06/2009' AND '31/12/2009'
GROUP BY el.codigo, el.elemento;

--Cree la siguiente tabla e inserte en ella los datos de la tabla empleado utilizando para ello la instrucción insert into mitabla_destino  (select * from mitabla_origen);
CREATE TABLE TMP_EMPLEADOS
(
  IDENTIFICACION  INTEGER                 NOT NULL,
  TIPO            VARCHAR(5)              NOT NULL,
  NOMBRE_1        VARCHAR(50)             NOT NULL,
  NOMBRE_2        VARCHAR(50)             DEFAULT NULL,
  APELLIDO_1      VARCHAR(50)             NOT NULL,
  APELLIDO_2      VARCHAR(50)             DEFAULT NULL,
  SEXO            VARCHAR(1)              NOT NULL,
  FECHA_N         DATE                    NOT NULL,
  LUGAR_N         VARCHAR(100)            NOT NULL,
  DIRECCION       VARCHAR(50)             NOT NULL,
  TELEFONO        VARCHAR(50)             NOT NULL,
  EMAIL           VARCHAR(100)            NOT NULL,
  SALARIO         INTEGER                 NOT NULL,
  ACTIVO          VARCHAR(1)              NOT NULL 
);

INSERT INTO tmp_empleados (SELECT * FROM empleados);

--Cree la siguiente tabla e inserte en ella los datos requeridos, utilizando para ello la instrucción    insert into mitabla_destino  (select * from mitabla_origen);  .
CREATE TABLE TMP_INFORME
(
  IDENTIFICACION   INTEGER                NOT NULL,
  TIPO             VARCHAR(5)             NOT NULL,
  EMPLEADO         VARCHAR(100)           NOT NULL,
  CARGO            VARCHAR(50)            NOT NULL,
  FECHA_INGRESO    DATE                   NOT NULL,
  TIEMPO_EN_CARGO  INTEGER                NOT NULL,
  SALARIO          INTEGER                NOT NULL 
);

INSERT INTO tmp_informe  (
SELECT emp.identificacion, emp.tipo, CONCAT_WS(' ',emp.nombre_1,emp.nombre_2,emp.apellido_1,emp.apellido_2) as empleado,
car.cargo, hs.fecha_ingreso,
CASE WHEN hs.fecha_salida 
	IS NOT NULL THEN
		ROUND(hs.fecha_salida-hs.fecha_ingreso)
	ELSE 
		ROUND(CURRENT_DATE-hs.fecha_ingreso)
END AS duracion
, emp.salario
FROM empleados AS emp
INNER JOIN historial_laboral AS hs ON hs.empleado = emp.identificacion
INNER JOIN  cargos AS car ON car.cod_cargo = hs.cargo
);

SELECT * FROM tmp_informe;

--Escriba la instrucción sql necesaria para eliminar los datos de los empleados de la tabla TMP_INFORME Donde el cargo sea igual a “SUPERVISOR TELEFONIA PUBLICA”. 
DELETE FROM tmp_informe WHERE cargo = 'SUPERVISOR TELEFONIA PUBLICA';

--Escriba la instrucción sql necesaria para actualizar la columna serial de la tabla elementos con el valor “S”.
UPDATE elementos SET serial = 'S';

--Escriba las instrucciones sql necesarias para actualizar la columna email de la tabla empleados con  la nueva dirección de correo asignada por la empresa. La nueva dirección asignada debe estar conformada por: La inicial del primer nombre + el primer apellido + el segundo apellido + unillanos.edu.co, esta actualización debe hacerla  a los empleados con identificación 86072892, 82787309 y 46762330.  Ejemplo: Ricardo Andrés Sandoval Morales -> rsandovalmorales@unillanos.edu.co  
UPDATE empleados SET email = CONCAT(SUBSTR(nombre_1,0,1),apellido_1,apellido_2,'@unillanos.edu.co')
WHERE identificacion = 86072892 OR identificacion = 82787309 OR identificacion = 46762330;

SELECT email FROM empleados WHERE identificacion = 86072892 OR identificacion = 82787309 OR identificacion = 46762330;