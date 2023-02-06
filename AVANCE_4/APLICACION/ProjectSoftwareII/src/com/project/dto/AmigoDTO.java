package com.project.dto;

import com.project.model.Amigo;

public class AmigoDTO extends Amigo{
    
    private Number id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String direccion;
    private String correo;
    
    public AmigoDTO() {
    }

    public AmigoDTO(Number id, String nombre, String apellido, String telefono, String direccion, String correo) {
        super(id, nombre, apellido, telefono, direccion, correo);
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
    }

    public AmigoDTO(String nombre, String apellido, String telefono, String direccion, String correo) {
        super(nombre, apellido, telefono, direccion, correo);
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
    }

    public AmigoDTO(Amigo amigo){
        this.id = amigo.getId();
        this.nombre = amigo.getNombre();
        this.apellido = amigo.getApellido();
        this.telefono = amigo.getTelefono();
        this.direccion = amigo.getDireccion();
        this.correo = amigo.getCorreo();
    }
    
    @Override
    public Number getId() {
        return id;
    }

    @Override
    public void setId(Number id) {
        this.id = id;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getApellido() {
        return apellido;
    }

    @Override
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String getTelefono() {
        return telefono;
    }

    @Override
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String getDireccion() {
        return direccion;
    }

    @Override
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String getCorreo() {
        return correo;
    }

    @Override
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "AmigoDTO{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono + ", direccion=" + direccion + ", correo=" + correo + '}';
    }
    
}
