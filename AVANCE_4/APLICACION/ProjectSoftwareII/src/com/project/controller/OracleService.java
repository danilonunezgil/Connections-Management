package com.project.controller;

import com.project.model.Amigo;
import com.project.model.Elemento;
import com.project.model.Estudiante;
import com.project.dto.AmigoDTO;
import com.project.dto.InfoStudentDTO;
import java.util.List;
import java.util.stream.Collectors;

public class OracleService {
    
    private static OracleService oracleSingleton;
    private final Amigo amigo;
    private final Estudiante estudiante;
    private final Elemento elemento;

    private OracleService() {
        this.amigo = new Amigo();
        this.estudiante = new Estudiante();
        this.elemento = new Elemento();
    }
    
    public static OracleService getInstance(){
        if(oracleSingleton == null){
            oracleSingleton = new OracleService();
        }
        return oracleSingleton;
    }
    
    //CRUD PARA TABLA AMIGO
    public AmigoDTO ingresarAmigo(){
        AmigoDTO amigoDTO = new AmigoDTO( amigo.crear(OracleService.class));
        return amigoDTO;
    }
    
    public List<AmigoDTO> listarAmigo(){
        List<Amigo> lista = amigo.listar(OracleService.class);
        return lista.stream().map(AmigoDTO::new).collect(Collectors.toList());
    }
    
    public AmigoDTO actualizarAmigo(AmigoDTO amigo){
        AmigoDTO amigoDTO = new AmigoDTO(amigo.actualizar(OracleService.class,amigo));
        return amigoDTO ;
    }
    
    public void eliminarAmigo(Number idAmigo){
        amigo.eliminar(OracleService.class,idAmigo);
    }
    
    public AmigoDTO buscarAmigoId(Number idAmigo){
        AmigoDTO amigoDTO = new AmigoDTO(amigo.buscarId(OracleService.class,idAmigo));
        return amigoDTO;
    }
    
    //CONTROL DE TRANSACCIONES
    public String savePointAmigos(){
        return amigo.savePointAmigos(OracleService.class);
    }
    
    public String volverSaveAmigos(){
        return amigo.volverSaveAmigos(OracleService.class);
    }
    
    public String rollbackAmigos(){
        return amigo.rollbackAmigos(OracleService.class);
    }
    
    public String commitAmigos(){
        return amigo.commitAmigos(OracleService.class);
    }
    /*
    public String desconectar(){
        return ConexionOracle.desconectar(OracleService.class);
    }
    */
    //CONTROL DE FUNCIONES
    
    public Number promedioCarrera(Integer cod_est){
        return estudiante.promedioCarrera(OracleService.class, cod_est);
    }
    
    public Integer precioPromedio(Integer cod_ele){
        return elemento.precioPromedio(OracleService.class, cod_ele);
    }
    
    public String compararNumeros(Integer numero1, Integer numero2){
        return estudiante.compararNumeros(OracleService.class,numero1,numero2);
    }
    
    public List<InfoStudentDTO> informacionEstudiantes(){
        return estudiante.informacionEstudiantes(OracleService.class);
    }
}
