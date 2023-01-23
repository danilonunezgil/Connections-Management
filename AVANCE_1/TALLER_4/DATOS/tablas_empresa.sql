CREATE TABLE pedidos(
    id_pedido INTEGER NOT NULL,
    empleado INTEGER NOT NULL,
    elemento INTEGER NOT NULL,
    cantidad INTEGER DEFAULT 0 NOT NULL CONSTRAINT pedido_cantidad_check CHECK(cantidad>=0),
    aprobado varchar(1) DEFAULT 'N' NOT NULL CONSTRAINT pedido_aprobado_check CHECK(aprobado IN ('N','S')),
    fecha DATE DEFAULT NOW() NOT NULL,
    llego VARCHAR(1) DEFAULT 'N' NOT NULL CONSTRAINT pedido_llego_check CHECK(llego IN ('N','S')),
    CONSTRAINT pedidos_pk PRIMARY KEY(id_pedido,empleado,elemento),
    CONSTRAINT pedidos_empleado_fk FOREIGN KEY(empleado) REFERENCES empleados(identificacion),
    CONSTRAINT pedidos_elemento_fk FOREIGN KEY(elemento) REFERENCES elementos(codigo)
);

CREATE TABLE entrada_almacen(
    id_entrada INTEGER NOT NULL,
    fecha DATE DEFAULT NOW() NOT NULL,
    responsable INTEGER NOT NULL,
    concepto VARCHAR(500) DEFAULT 'COMPRA DE ELEMENTOS DE PROTECCION PERSONAL' NOT NULL,
    subtotal INTEGER DEFAULT 0 NOT NULL CONSTRAINT almacen_subtotal_check CHECK(subtotal>=0),
    iva INTEGER DEFAULT 0 NOT NULL CONSTRAINT almacen_iva_check CHECK(iva>=0),
    total INTEGER DEFAULT 0 NOT NULL CONSTRAINT almacen_total_check CHECK(total>=0),
    CONSTRAINT entrada_pk PRIMARY KEY(id_entrada),
    CONSTRAINT entrada_almacen_responsable_fk FOREIGN KEY(responsable) REFERENCES empleados(identificacion)
);

CREATE TABLE detalle_entrada(
    id_entrada INTEGER NOT NULL,
    num_detalle INTEGER NOT NULL,
    elemento INTEGER NOT NULL,
    cantidad INTEGER DEFAULT 0 NOT NULL CONSTRAINT compra_cantidad_check CHECK(cantidad>=0),
    v_unitario INTEGER DEFAULT 0 NOT NULL CONSTRAINT compra_v_unitario_check CHECK(v_unitario>=0),
    subtotal INTEGER DEFAULT 0 NOT NULL CONSTRAINT compra_subtotal_check CHECK(subtotal>=0),
    iva INTEGER DEFAULT 0 NOT NULL CONSTRAINT compra_iva_check CHECK(iva>=0),
    entregados INTEGER DEFAULT 0 NOT NULL CONSTRAINT compra_entregados_check CHECK(entregados>=0),
    id_pedido INTEGER NOT NULL,
    CONSTRAINT detalle_entrada_pk PRIMARY KEY(id_entrada,num_detalle,elemento),
    CONSTRAINT detalle_entrada_entrada_fk FOREIGN KEY(id_entrada) REFERENCES entrada_almacen(id_entrada),
    CONSTRAINT detalle_entrada_elemento_fk FOREIGN KEY(elemento) REFERENCES elementos(codigo)
);

--Adicione un campo a la tabla elemento que  tenga por nombre vida_util de tipo numérico y debe tener el valor por defecto igual a cero. 
ALTER TABLE elementos
ADD vida_util INTEGER DEFAULT 0;

--Actualice el campo vida_util  de la tabla entrega_elementos con el valor igual a 20.
UPDATE elementos SET vida_util=20;

--Actualice la fecha de devolución de los elementos en la tabla entrega_elementos. Cada elemento tiene una vida útil de 20 días.
UPDATE entrega_elementos AS entre_ele SET fecha_devolucion = fecha+(SELECT el.vida_util FROM elementos AS el WHERE el.codigo = entre_ele.elemento);

--Actualice los campos subtotal, IVA y total, de la tabla entradas_almacen, calcular el valor utilizando los datos de la tabla detalle_entradas.
UPDATE entrada_almacen as en SET subtotal = (SELECT SUM(subtotal) FROM detalle_entrada WHERE id_entrada = en.id_entrada),
iva = (SELECT SUM((subtotal*0.16)) FROM detalle_entrada WHERE id_entrada = en.id_entrada),
total = (SELECT SUM((subtotal*0.16))+SUM(subtotal) FROM detalle_entrada WHERE id_entrada = en.id_entrada);

SELECT * FROM entrada_almacen;
--Elimine los datos de la tabla TMP_EMPLEADOS y TMP_INFORME.
DELETE FROM tmp_empleados;
DELETE FROM tmp_informe;

--Elimine las tablas  TMP_EMPLEADOS y TMP_INFORME.
DROP TABLE tmp_empleados;
DROP TABLE tmp_informe;