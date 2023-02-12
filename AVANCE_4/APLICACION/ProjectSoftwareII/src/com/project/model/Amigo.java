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
    
    /**
    * Método encargado de crear un objeto de tipo Amigo y llenarlo de forma aleatoria con datos establecidos en arreglos
    * @author Edgar,Danilo y Johan
    * @return Objeto de tipo Amigo creado
    */
    public Amigo generarRandom() {
        String[] nombresRand = {"Javier", "Manuel", "Rodrigo", "Camilo", "Lucrecia", "Manuela", "Juliana", "Paola", "Pandy", "Fernanda"};
        String[] apellidosRand = {"Lozada", "Gonzalez", "Nunez", "Gil", "Botero", "Perez", "Reyes", "Gomez", "Hernandez", "Pabon"};
        String[] telefonos = {"3102823922", "3102823921", "3102823923", "3102823925", "3102823920", "3102823929", "3102823927", "3102823925", "3102823926", "3102823900"};
        String[] direcciones = {"Calle 2", "calle 1", "calle13", "Calle principal", "calle 98", "calle 67", "calle 79", "Calle 09", "calle 21", "calle 314"};
        String[] correos = {"1@unillanos.edu.co", "2@unillanos.edu.co", "3@unillanos.edu.co", "4@unillanos.edu.co", "5@unillanos.edu.co", "6@unillanos.edu.co", "7@unillanos.edu.co", "8@unillanos.edu.co", "9@unillanos.edu.co", "12@unillanos.edu.co"};
        Amigo amigo = new Amigo(nombresRand[(int) (Math.random() * 10)], apellidosRand[(int) (Math.random() * 10)], telefonos[(int) (Math.random() * 10)], direcciones[(int) (Math.random() * 10)], correos[(int) (Math.random() * 10)]);

        return amigo;
    }

    //CRUD PARA TABLA AMIGO ORACLE
    
    /**
    * Método encargado de crear un objeto de tipo Amigo en oracle
    * @author Edgar,Danilo y Johan
    * @return Objeto de tipo Amigo creado
    */
    public Amigo crearAmigoOracle(){
        return AmigoDAO.getInstance().insertarAmigoOracle(generarRandom());
    }
    
    
    /**
    * Método encargado de listar objetos de tipo Amigo almacenados en oracle
    * @author Edgar,Danilo y Johan
    * @return Lista de objetos de tipo Amigo
    */
    public List<Amigo> listarAmigoOracle(){
        return AmigoDAO.getInstance().listarAmigosOracle();
    }
    
    /**
    * Método encargado de actualizar informacion de objetos de tipo Amigo almacenados en oracle
    * @author Edgar,Danilo y Johan
    * @param amigoDTO objeto de tipo AmigoDTO con la informacion que se requiere actualizar
    * @return Objeto de tipo Amigo con la informacion actualizada
    */
    public Amigo actualizarAmigoOracle(AmigoDTO amigoDTO){
        return AmigoDAO.getInstance().actualizarAmigoOracle(amigoDTO);
    }
    
    /**
    * Método encargado de eliminar un objeto de tipo Amigo almacenado en oracle
    * @author Edgar,Danilo y Johan
    * @param idAmigo Number con el numero identificador del amigo a eliminar
    */
    public void eliminarAmigoOracle(Number idAmigo){
        AmigoDAO.getInstance().eliminarAmigoOracle(idAmigo);
    }
    
    /**
    * Método encargado de buscar por id un objeto de tipo Amigo almacenado en oracle
    * @author Edgar,Danilo y Johan
    * @param idAmigo Number con el numero identificador del amigo a buscar
    * @return Objeto de tipo Amigo encontrado apartir del numero de identificador
    */
    public Amigo buscarIdAmigoOracle(Number idAmigo){
        return AmigoDAO.getInstance().buscarIdAmigoOracle(idAmigo);
    }
    
    /**
    * Método encargado de realizar savepoint para control de transacciones en oracle
    * @author Edgar,Danilo y Johan
    * @return String que contiene mensaje de exito o falla al realizar savepoint
    */
    public String savePointOracle(){
        return AmigoDAO.getInstance().savePointOracle();
    }
    
    /**
    * Método encargado de cargar savepoin creado en oracle
    * @author Edgar,Danilo y Johan
    * @return String que contiene mensaje de exito o falla al cargar el savepoint
    */
    public String volverSaveOracle(){
        return AmigoDAO.getInstance().volverSaveOracle();
    }
    
    /**
    * Método encargado de realizar rollback en oracle
    * @author Edgar,Danilo y Johan
    * @return String que contiene mensaje de exito o falla del rollback
    */
    public String rollbackOracle(){
        return AmigoDAO.getInstance().rollbackOracle();
    }
    
    /**
    * Método encargado de realizar commit en oracle 
    * @author Edgar,Danilo y Johan
    * @return String que contiene mensaje de exito o falla al realizar commit
    */
    public String commitOracle(){
        return AmigoDAO.getInstance().commitOracle();
    }
    
    //CRUD PARA TABLA AMIGO POSTGRESQL
    
    /**
    * Método encargado de ingresar un objeto de tipo Amigo en postgresql
    * @author Edgar,Danilo y Johan
    * @return Objeto de tipo Amigo creado
    */
    public Amigo crearAmigoPostgres(){
        return AmigoDAO.getInstance().insertarAmigoPostgres(generarRandom());
    }
    
    
    /**
    * Método encargado de listar objetos de tipo Amigo almacenados en postgresql
    * @author Edgar,Danilo y Johan
    * @return Lista de objetos de tipo Amigo
    */
    public List<Amigo> listarAmigoPostgres(){
        return AmigoDAO.getInstance().listarAmigosPostgres();
    }
    
    /**
    * Método encargado de actualizar informacion de objetos de tipo Amigo almacenados en postgresql
    * @author Edgar,Danilo y Johan
    * @param amigoDTO objeto de tipo AmigoDTO con la informacion que se requiere actualizar
    * @return Objeto de tipo Amigo con la informacion actualizada
    */
    public Amigo actualizarAmigoPostgres(AmigoDTO amigoDTO){
        return AmigoDAO.getInstance().actualizarAmigoPostgres(amigoDTO);
    }
    
    /**
    * Método encargado de eliminar un objeto de tipo Amigo almacenado en postgresql
    * @author Edgar,Danilo y Johan
    * @param idAmigo Number con el numero identificador del amigo a eliminar
    */
    public void eliminarAmigoPostgres(Number idAmigo){
        AmigoDAO.getInstance().eliminarAmigoPostgres(idAmigo);
    }
    
    /**
    * Método encargado de buscar por id un objeto de tipo Amigo almacenado en postgresql
    * @author Edgar,Danilo y Johan
    * @param idAmigo Number con el numero identificador del amigo a buscar
    * @return Objeto de tipo Amigo encontrado apartir del numero de identificador
    */
    public Amigo buscarIdAmigoPostgres(Number idAmigo){
        return AmigoDAO.getInstance().buscarIdAmigoPostgres(idAmigo);
    }
    
    /**
    * Método encargado de realizar savepoint para control de transacciones en postgresql
    * @author Edgar,Danilo y Johan
    * @return String que contiene mensaje de exito o falla al realizar savepoint
    */
    public String savePointPostgres(){
        return AmigoDAO.getInstance().savePointPostgres();
    }
    
    /**
    * Método encargado de cargar savepoin creado en postgresql
    * @author Edgar,Danilo y Johan
    * @return String que contiene mensaje de exito o falla al cargar el savepoint
    */
    public String volverSavePostgres(){
        return AmigoDAO.getInstance().volverSavePostgres();
    }
    
    /**
    * Método encargado de realizar rollback en postgresql
    * @author Edgar,Danilo y Johan
    * @return String que contiene mensaje de exito o falla del rollback
    */
    public String rollbackPostgres(){
        return AmigoDAO.getInstance().rollbackPostgres();
    }
    
    /**
    * Método encargado de realizar commit en postgresql 
    * @author Edgar,Danilo y Johan
    * @return String que contiene mensaje de exito o falla al realizar commit
    */
    public String commitPostgres(){
        return AmigoDAO.getInstance().commitPostgres();
    }
}
