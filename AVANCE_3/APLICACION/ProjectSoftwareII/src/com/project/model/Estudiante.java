package com.project.model;

import java.util.Date;

public class Estudiante {
    private Integer codigo;
    private String nombres;
    private String apellido1;
    private String apellido2;
    private String telefono;
    private String facultad;
    private String programa;
    private Date fecha_inicio;

    public Estudiante() {
    }

    public Estudiante(Integer codigo, String nombres, String apellido1, String apellido2, String telefono, String facultad, String programa, Date fecha_inicio) {
        this.codigo = codigo;
        this.nombres = nombres;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.telefono = telefono;
        this.facultad = facultad;
        this.programa = programa;
        this.fecha_inicio = fecha_inicio;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "codigo=" + codigo + ", nombres=" + nombres + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", telefono=" + telefono + ", facultad=" + facultad + ", programa=" + programa + ", fecha_inicio=" + fecha_inicio + '}';
    }
}
