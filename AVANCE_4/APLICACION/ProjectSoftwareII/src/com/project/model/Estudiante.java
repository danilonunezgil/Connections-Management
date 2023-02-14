package com.project.model;

import com.project.dao.EstudianteDAO;
import com.project.dto.EstudianteDTO;
import com.project.dto.InfoStudentDTO;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
* Clase Estudiante encargada de comunicarse con el controlador y la clase EstudianteDAO
* @author Edgar,Danilo y Johan
*/
public class Estudiante {
    private Integer codigo;
    private String nombres;
    private String apellido1;
    private String apellido2;
    private String telefono;
    private String facultad;
    private String programa;
    private Date fecha_inicio;
    private byte[] foto;
            
    public Estudiante() {
    }

    public Estudiante(Integer codigo, String nombres, String apellido1, String apellido2, String telefono, String facultad, String programa, Date fecha_inicio, byte[] foto) {
        this.codigo = codigo;
        this.nombres = nombres;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.telefono = telefono;
        this.facultad = facultad;
        this.programa = programa;
        this.fecha_inicio = fecha_inicio;
        this.foto = foto;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
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
        return "Estudiante{" + "codigo=" + codigo + ", nombres=" + nombres + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", telefono=" + telefono + ", facultad=" + facultad + ", programa=" + programa + ", fecha_inicio=" + fecha_inicio + ", foto=" + Arrays.toString(foto) + '}';
    }
    
    /**
    * Método encargado de consultar el promedio de carrera de un estudiante de en postgresql
    * @author Edgar,Danilo y Johan
    * @param cod_est Integer con el indentificador del estudiante a consultar
    * @return Niumber con el valor del promedio de carrera del estudiante consultado
    */
    public Number promedioCarreraPostgres(Integer cod_est){
        return EstudianteDAO.getInstance().promedioCarreraPostgres(cod_est);
    }
    
    /**
    * Método encargado de consultar la informacion de los estudiantes almacenados en postgresql
    * @author Edgar,Danilo y Johan
    * @return Lista con objetos de tipo InfoStudentDTO
    */
    public List<InfoStudentDTO> informacionEstudiantesPostgres(){
        return EstudianteDAO.getInstance().informacionEstudiantesPostgres();
    }
    
    /**
    * Método encargado de consultar la comparacion de dos numeros enteros en postgresql
    * @author Edgar,Danilo y Johan
    * @param numero1 Integer con el valor del primer numero a comparar    
    * @param numero2 Integer con el valor del segundo numero a comparar
    * @return String con la comparacion realizada
    */
    public String compararNumerosPostgres(Integer numero1, Integer numero2){
        return EstudianteDAO.getInstance().compararNumerosPostgres(numero1,numero2);
    }
    
    /**
    * Método encargado de buscar un estudiante en postgresql
    * @author Edgar,Danilo y Johan
    * @param idEstudiante Number con el identificador del estudiante que se quiere buscar
    * @return Objeto de tipo Estudiante con toda la informacion del mismo
    */
    public Estudiante buscarIdEstudiantePostgres(Number idEstudiante){
        return EstudianteDAO.getInstance().buscarIdEstudiantePostgres(idEstudiante);
    }
    
    /**
    * Método encargado de consultar el promedio de carrera de un estudiante de en oracle
    * @author Edgar,Danilo y Johan
    * @param cod_est Integer con el indentificador del estudiante a consultar
    * @return Niumber con el valor del promedio de carrera del estudiante consultado
    */
    public Number promedioCarreraOracle(Integer cod_est){
        return EstudianteDAO.getInstance().promedioCarreraOracle(cod_est);
    }
    
    /**
    * Método encargado de consultar la informacion de los estudiantes almacenados en oracle
    * @author Edgar,Danilo y Johan
    * @return Lista con objetos de tipo InfoStudentDTO
    */
    public List<InfoStudentDTO> informacionEstudiantesOracle(){
        return EstudianteDAO.getInstance().informacionEstudiantesOracle();
    }
    
    /**
    * Método encargado de consultar la comparacion de dos numeros enteros en oracle
    * @author Edgar,Danilo y Johan
    * @param numero1 Integer con el valor del primer numero a comparar    
    * @param numero2 Integer con el valor del segundo numero a comparar
    * @return String con la comparacion realizada
    */
    public String compararNumerosOracle(Integer numero1, Integer numero2){
        return EstudianteDAO.getInstance().compararNumerosOracle(numero1,numero2);
    }
    
    /**
    * Método encargado de buscar un estudiante en oracle
    * @author Edgar,Danilo y Johan
    * @param idEstudiante Number con el identificador del estudiante que se quiere buscar
    * @return Objeto de tipo Estudiante con toda la informacion del mismo
    */
    public Estudiante buscarIdEstudianteOracle(Number idEstudiante){
        return EstudianteDAO.getInstance().buscarIdEstudianteOracle(idEstudiante);
    }
   
    /**
    * Método encargado de guardar la foto del estudiante en una ruta determinada para oracle
    * @author Edgar,Danilo y Johan
    * @param estudianteDTO Objeto de tipo estudiante con la informacion del codigo del estudiante y la foto a guardar
    * @return Arreglo de bytes con toda la informacion de la foto guardada en la carpeta
    */
    public byte[] guardarFotoCarpetaOracle(EstudianteDTO estudianteDTO){
        return EstudianteDAO.getInstance().guardarFotoCarpetaOracle(estudianteDTO);
    }
    
    /**
    * Método encargado de guardar la foto del estudiante en la base de datos oracle
    * @author Edgar,Danilo y Johan
    * @param estudianteDTO Objeto de tipo estudiante con la informacion del codigo del estudiante y la foto a guardar
    * @return Arreglo de bytes con toda la informacion de la foto guardada en la base de datos
    */
    public byte[] guardarFotoBaseOracle(EstudianteDTO estudianteDTO){
        return EstudianteDAO.getInstance().guardarFotoBaseOracle(estudianteDTO);
    }
    
    /**
    * Método encargado de guardar la foto del estudiante en una rutra determinada para postgres
    * @author Edgar,Danilo y Johan
    * @param estudianteDTO Objeto de tipo estudiante con la informacion del codigo del estudiante y la foto a guardar
    * @return Arreglo de bytes con toda la informacion de la foto guardada en la base de datos
    */
    public byte[] guardarFotoCarpetaPostgres(EstudianteDTO estudianteDTO){
       return EstudianteDAO.getInstance().guardarFotoCarpetaPostgres(estudianteDTO);
    }
    
    /**
    * Método encargado de guardar la foto del estudiante en la base de datos postgres
    * @author Edgar,Danilo y Johan
    * @param estudianteDTO Objeto de tipo estudiante con la informacion del codigo del estudiante y la foto a guardar
    * @return Arreglo de bytes con toda la informacion de la foto guardada en la base de datos
    */
    public byte[] guardarFotoBasePostgres(EstudianteDTO estudianteDTO){
        return EstudianteDAO.getInstance().guardarFotoBasePostgres(estudianteDTO);
    }
}
