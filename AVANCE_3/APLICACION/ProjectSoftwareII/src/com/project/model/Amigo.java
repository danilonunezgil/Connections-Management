package com.project.model;

import com.project.dao.AmigoDAO;
import com.project.dto.AmigoDTO;
import java.util.List;

public class Amigo {

    private Number id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String direccion;
    private String correo;

    public Amigo() {
    }
    
    public Amigo(Number id, String nombre, String apellido, String telefono, String direccion, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
    }

    public Amigo(String nombre, String apellido, String telefono, String direccion, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
    }

    public Number getId() {
        return id;
    }

    public void setId(Number id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Amigo{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono + ", direccion=" + direccion + ", correo=" + correo + '}';
    }
    
    //CRUD PARA TABLA AMIGO
    public Amigo crear(Class servicio){
        AmigoDAO amigoDAO = new AmigoDAO();
        return amigoDAO.insertar(servicio,generarRandom());
    }
    
    public Amigo generarRandom() {
        String[] nombresRand = {"Javier", "Manuel", "Rodrigo", "Camilo", "Lucrecia", "Manuela", "Juliana", "Paola", "Pandy", "Fernanda"};
        String[] apellidosRand = {"Lozada", "Gonzalez", "Nunez", "Gil", "Botero", "Perez", "Reyes", "Gomez", "Hernandez", "Pabon"};
        String[] telefonos = {"3102823922", "3102823921", "3102823923", "3102823925", "3102823920", "3102823929", "3102823927", "3102823925", "3102823926", "3102823900"};
        String[] direcciones = {"Calle 2", "calle 1", "calle13", "Calle principal", "calle 98", "calle 67", "calle 79", "Calle 09", "calle 21", "calle 314"};
        String[] correos = {"1@unillanos.edu.co", "2@unillanos.edu.co", "3@unillanos.edu.co", "4@unillanos.edu.co", "5@unillanos.edu.co", "6@unillanos.edu.co", "7@unillanos.edu.co", "8@unillanos.edu.co", "9@unillanos.edu.co", "12@unillanos.edu.co"};
        Amigo amigo = new Amigo(nombresRand[(int) (Math.random() * 10)], apellidosRand[(int) (Math.random() * 10)], telefonos[(int) (Math.random() * 10)], direcciones[(int) (Math.random() * 10)], correos[(int) (Math.random() * 10)]);

        return amigo;
    }

    public List<Amigo> listar(Class servicio){
        AmigoDAO amigoDAO = new AmigoDAO();
        return amigoDAO.listar(servicio);
    }
    
    public Amigo actualizar(Class servicio,AmigoDTO amigo){
        AmigoDAO amigoDAO = new AmigoDAO();
        return amigoDAO.actualizar(servicio,(Amigo)amigo);
    }
    
    public void eliminar(Class servicio,Number idAmigo){
        AmigoDAO amigoDAO = new AmigoDAO();
        amigoDAO.eliminar(servicio,idAmigo);
    }
    
    public Amigo buscarId(Class servicio,Number idAmigo){
        AmigoDAO amigoDAO = new AmigoDAO();
        return amigoDAO.buscarId(servicio,idAmigo);
    }
  
}
