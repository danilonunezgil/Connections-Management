package com.project.dto;

import com.project.model.Amigo;

public class AmigoDTO extends Amigo{

    public AmigoDTO() {
    }

    public AmigoDTO(Number id, String nombre, String apellido, String telefono, String direccion, String correo) {
        super(id, nombre, apellido, telefono, direccion, correo);
    }

    public AmigoDTO(String nombre, String apellido, String telefono, String direccion, String correo) {
        super(nombre, apellido, telefono, direccion, correo);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void setCorreo(String correo) {
        super.setCorreo(correo);
    }

    @Override
    public String getCorreo() {
        return super.getCorreo();
    }

    @Override
    public void setDireccion(String direccion) {
        super.setDireccion(direccion);
    }

    @Override
    public String getDireccion() {
        return super.getDireccion();
    }

    @Override
    public void setTelefono(String telefono) {
        super.setTelefono(telefono);
    }

    @Override
    public String getTelefono() {
        return super.getTelefono();
    }

    @Override
    public void setApellido(String apellido) {
        super.setApellido(apellido);
    }

    @Override
    public String getApellido() {
        return super.getApellido();
    }

    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre);
    }

    @Override
    public String getNombre() {
        return super.getNombre();
    }

    @Override
    public void setId(Number id) {
        super.setId(id);
    }

    @Override
    public Number getId() {
        return super.getId();
    }
}
