package com.project.controller;

import com.project.model.Amigo;
import com.project.model.Elemento;
import com.project.model.Estudiante;
import com.project.dto.AmigoDTO;
import com.project.dto.InfoStudentDTO;
import java.util.List;
import java.util.stream.Collectors;

public class PostgresqlService {

    private static PostgresqlService postgresqlSingleton;
    private final Amigo amigo;
    private final Estudiante estudiante;
    private final Elemento elemento;

    private PostgresqlService() {
        this.amigo = new Amigo();
        this.estudiante = new Estudiante();
        this.elemento = new Elemento();
    }

    public static PostgresqlService getInstance() {
        if (postgresqlSingleton == null) {
            postgresqlSingleton = new PostgresqlService();
        }
        return postgresqlSingleton;
    }

   //CRUD PARA TABLA AMIGO
    public AmigoDTO ingresarAmigo(){
        AmigoDTO amigoDTO = new AmigoDTO( amigo.crear(PostgresqlService.class));
        return amigoDTO;
    }
    
    public List<AmigoDTO> listarAmigo(){
        List<Amigo> lista = amigo.listar(PostgresqlService.class);
        return lista.stream().map(AmigoDTO::new).collect(Collectors.toList());
    }
    
    public AmigoDTO actualizarAmigo(AmigoDTO amigo){
        AmigoDTO amigoDTO = new AmigoDTO(amigo.actualizar(PostgresqlService.class,amigo));
        return amigoDTO ;
    }
    
    public void eliminarAmigo(Number idAmigo){
        amigo.eliminar(PostgresqlService.class,idAmigo);
    }
    
    public AmigoDTO buscarAmigoId(Number idAmigo){
        AmigoDTO amigoDTO = new AmigoDTO(amigo.buscarId(PostgresqlService.class,idAmigo));
        return amigoDTO;
    }
     //CONTROL DE TRANSACCIONES
    public String savePointAmigos(){
        return amigo.savePointAmigos(PostgresqlService.class);
    }
    
    public String volverSaveAmigos(){
        return amigo.volverSaveAmigos(PostgresqlService.class);
    }
    
    public String rollbackAmigos(){
        return amigo.rollbackAmigos(PostgresqlService.class);
    }
    
    public String commitAmigos(){
        return amigo.commitAmigos(PostgresqlService.class);
    }
    /*
    public String desconectar(){
        return ConexionOracle.desconectar(PostgresqlService.class);
    }
    */
    //CONTROL DE FUNCIONES
    public Number promedioCarrera(Integer cod_est) {
        return estudiante.promedioCarrera(PostgresqlService.class, cod_est);
    }

    public Integer precioPromedio(Integer cod_ele) {
        return elemento.precioPromedio(PostgresqlService.class, cod_ele);
    }

    public String compararNumeros(Integer numero1, Integer numero2) {
        return estudiante.compararNumeros(PostgresqlService.class, numero1, numero2);
    }

    public List<InfoStudentDTO> informacionEstudiantes() {
        return estudiante.informacionEstudiantes(PostgresqlService.class);
    }
}
