package com.project.controller;

import com.project.model.Amigo;
import com.project.model.Elemento;
import com.project.model.Estudiante;
import com.project.dto.AmigoDTO;
import com.project.dto.InfoStudentDTO;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Clase que representa los servicios ofrecidos para el motor de PostgreSQL
 * @author Edgar,Danilo y Johan
 */
public class PostgresqlService {

    private static PostgresqlService postgresqlSingleton;
    private final Amigo amigo;
    private final Estudiante estudiante;
    private final Elemento elemento;
    
    /**
    * Constructor privado de PostgresqlService
    * @author Edgar,Danilo y Johan
    */
    private PostgresqlService() {
        this.amigo = new Amigo();
        this.estudiante = new Estudiante();
        this.elemento = new Elemento();
    }
    
    /**
    * Este método se encarga de crear e instanciar un unico objeto PostgresqlService
    * @author Edgar,Danilo y Johan
    * @return Objeto de tipo PostgresqlService
    */
    public static PostgresqlService getInstance() {
        if (postgresqlSingleton == null) {
            postgresqlSingleton = new PostgresqlService();
        }
        return postgresqlSingleton;
    }

    /**
    * Método encargado de ofrecer el servicio crearAmigoPostgres de la clase Amigo
    * @author Edgar,Danilo y Johan
    * @return Objeto de tipo AmigoDTO creado
    */
    public AmigoDTO ingresarAmigo(){
        AmigoDTO amigoDTO = new AmigoDTO( amigo.crearAmigoPostgres());
        return amigoDTO;
    }
    
    /**
    * Método encargado de ofrecer el servicio listarAmigoPostgres de la clase Amigo
    * @author Edgar,Danilo y Johan
    * @return Lista de objetos de tipo AmigoDTO
    */
    public List<AmigoDTO> listarAmigo(){
        List<Amigo> lista = amigo.listarAmigoPostgres();
        return lista.stream().map(AmigoDTO::new).collect(Collectors.toList());
    }
    
    /**
    * Método encargado de ofrecer el servicio actualizarAmigoPostgres de la clase Amigo
    * @author Edgar,Danilo y Johan
    * @param amigo Objeto AmigoDTO que se actualizara
    * @return Objeto de tipo AmigoDTO actualizado 
    */
    public AmigoDTO actualizarAmigo(AmigoDTO amigo){
        AmigoDTO amigoDTO = new AmigoDTO(amigo.actualizarAmigoPostgres(amigo));
        return amigoDTO ;
    }
    
    /**
    * Método encargado de ofrecer el servicio eliminarAmigoPostgres de la clase Amigo
    * @param idAmigo Identificador del amigo a eliminar 
    * @author Edgar,Danilo y Johan 
    */
    public void eliminarAmigo(Number idAmigo){
        amigo.eliminarAmigoPostgres(idAmigo);
    }
    
    /**
    * Método encargado de ofrecer el servicio buscarIdAmigoPostgres de la clase Amigo
    * @author Edgar,Danilo y Johan
    * @param idAmigo Identificador del amigo a buscar
    * @return Objeto de tipo AmigoDTO encontrado
    */
    public AmigoDTO buscarAmigoId(Number idAmigo){
        AmigoDTO amigoDTO = new AmigoDTO(amigo.buscarIdAmigoPostgres(idAmigo));
        return amigoDTO;
    }
    
    /**
    * Método encargado de ofrecer el servicio savePointPostgres de la clase Amigo
    * @author Edgar,Danilo y Johan
    * @return String con el mensaje de exito o error de savepoint
    */
    public String savePointAmigos(){
        return amigo.savePointPostgres();
    }
    
    /**
    * Método encargado de ofrecer el servicio volverSavePostgres de la clase Amigo
    * @author Edgar,Danilo y Johan
    * @return String con el mensaje de exito o error de rollback(savepoint)
    */
    public String volverSaveAmigos(){
        return amigo.volverSavePostgres();
    }
    
    /**
    * Método encargado de ofrecer el servicio rollbackPostgres de la clase Amigo
    * @author Edgar,Danilo y Johan
    * @return String con el mensaje de exito o error de rollback
    */
    public String rollbackAmigos(){
        return amigo.rollbackPostgres();
    }
    
    /**
    * Método encargado de ofrecer el servicio commitPostgres de la clase Amigo
    * @author Edgar,Danilo y Johan
    * @return String con el mensaje de exito o error de commit
    */
    public String commitAmigos(){
        return amigo.commitPostgres();
    }
    
    /*
    public String desconectar(){
        return ConexionOracle.desconectar(PostgresqlService.class);
    }
    */
    
    /**
    * Método encargado de ofrecer el servicio promedioCarreraPostgres de la clase Estudiante
    * @author Edgar,Danilo y Johan
    * @param cod_est Indetificador del estudiante al cual consultar el promedio
    * @return Number con el promedio del estudiante consultado
    */
    public Number promedioCarrera(Integer cod_est) {
        return estudiante.promedioCarreraPostgres(cod_est);
    }
    
    /**
    * Método encargado de ofrecer el servicio precioPromedioPostgres de la clase Elemento
    * @author Edgar,Danilo y Johan
    * @param cod_ele Identificador del elemento al cual consultar el precio promedio
    * @return Integer con el precio promedio del elemento consultado
    */
    public Integer precioPromedio(Integer cod_ele) {
        return elemento.precioPromedioPostgres(cod_ele);
    }
    
    /**
    * Método encargado de ofrecer el servicio compararNumerosPostgres de la clase Estudiante
    * @author Edgar,Danilo y Johan
    * @param numero1 Primer numero a comparar
    * @param numero2 Segundo numero a comparar
    * @return String con el mensaje de comparacion de los numeros
    */
    public String compararNumeros(Integer numero1, Integer numero2) {
        return estudiante.compararNumerosPostgres(numero1, numero2);
    }
    
    /**
    * Método encargado de ofrecer el servicio informacionEstudiantesPostgres de la clase Estudiante
    * @author Edgar,Danilo y Johan
    * @return Lista con objetos de tipo InfoStudentDTO
    */
    public List<InfoStudentDTO> informacionEstudiantes() {
        return estudiante.informacionEstudiantesPostgres();
    }
}
