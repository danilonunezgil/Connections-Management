package com.project.model;

import com.project.dao.ElementoDAO;

public class Elemento {

    private Integer codigo;
    private String elemento;
    private String devolutivo;
    private String talla;
    private String uso;
    private String materiales;
    private String mantenimiento;
    private String usos;
    private String norma;
    private String atenuacion;
    private String serial;
    private String tallas;
    private String unidad;
    private String ruta;
    private String precio_actual;
    private String cantidad_elementos;

    public Elemento() {
    }

    public Elemento(Integer codigo, String elemento, String devolutivo, String talla, String uso, String materiales, String mantenimiento, String usos, String norma, String atenuacion, String serial, String tallas, String unidad, String ruta, String precio_actual, String cantidad_elementos) {
        this.codigo = codigo;
        this.elemento = elemento;
        this.devolutivo = devolutivo;
        this.talla = talla;
        this.uso = uso;
        this.materiales = materiales;
        this.mantenimiento = mantenimiento;
        this.usos = usos;
        this.norma = norma;
        this.atenuacion = atenuacion;
        this.serial = serial;
        this.tallas = tallas;
        this.unidad = unidad;
        this.ruta = ruta;
        this.precio_actual = precio_actual;
        this.cantidad_elementos = cantidad_elementos;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getElemento() {
        return elemento;
    }

    public void setElemento(String elemento) {
        this.elemento = elemento;
    }

    public String getDevolutivo() {
        return devolutivo;
    }

    public void setDevolutivo(String devolutivo) {
        this.devolutivo = devolutivo;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }

    public String getMateriales() {
        return materiales;
    }

    public void setMateriales(String materiales) {
        this.materiales = materiales;
    }

    public String getMantenimiento() {
        return mantenimiento;
    }

    public void setMantenimiento(String mantenimiento) {
        this.mantenimiento = mantenimiento;
    }

    public String getUsos() {
        return usos;
    }

    public void setUsos(String usos) {
        this.usos = usos;
    }

    public String getNorma() {
        return norma;
    }

    public void setNorma(String norma) {
        this.norma = norma;
    }

    public String getAtenuacion() {
        return atenuacion;
    }

    public void setAtenuacion(String atenuacion) {
        this.atenuacion = atenuacion;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getTallas() {
        return tallas;
    }

    public void setTallas(String tallas) {
        this.tallas = tallas;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getPrecio_actual() {
        return precio_actual;
    }

    public void setPrecio_actual(String precio_actual) {
        this.precio_actual = precio_actual;
    }

    public String getCantidad_elementos() {
        return cantidad_elementos;
    }

    public void setCantidad_elementos(String cantidad_elementos) {
        this.cantidad_elementos = cantidad_elementos;
    }

    @Override
    public String toString() {
        return "Elemento{" + "codigo=" + codigo + ", elemento=" + elemento + ", devolutivo=" + devolutivo + ", talla=" + talla + ", uso=" + uso + ", materiales=" + materiales + ", mantenimiento=" + mantenimiento + ", usos=" + usos + ", norma=" + norma + ", atenuacion=" + atenuacion + ", serial=" + serial + ", tallas=" + tallas + ", unidad=" + unidad + ", ruta=" + ruta + ", precio_actual=" + precio_actual + ", cantidad_elementos=" + cantidad_elementos + '}';
    }

    public Integer precioPromedio(Class servicio, Integer cod_ele) {
        ElementoDAO elementoDAO = new ElementoDAO();
        return elementoDAO.precioPromedioElemento(servicio, cod_ele);
    }
}
