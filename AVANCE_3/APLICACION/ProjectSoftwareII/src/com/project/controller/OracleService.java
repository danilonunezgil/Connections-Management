package com.project.controller;

import com.project.model.Amigo;
import com.project.model.Elemento;
import com.project.model.Estudiante;
import com.project.dto.AmigoDTO;
import com.project.dto.InfoStudentDTO;
import java.util.List;

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
        return (AmigoDTO)amigo.crear(OracleService.class);
    }
    
    public List<AmigoDTO> listarAmigo(){
        List<?> listaAmigos = amigo.listar(OracleService.class);
        return (List<AmigoDTO>)listaAmigos;
    }
    
    public AmigoDTO actualizarAmigo(AmigoDTO amigo){
        return (AmigoDTO)amigo.actualizar(OracleService.class,amigo);
    }
    
    public void eliminarAmigo(Number idAmigo){
        amigo.eliminar(OracleService.class,idAmigo);
    }
    
    public AmigoDTO buscarAmigoId(Number idAmigo){
        return (AmigoDTO)amigo.buscarId(OracleService.class,idAmigo);
    }
    
    //CONTROL DE TRANSACCIONES
    /*
    public String savePoint(){
        return ConexionOracle.savePoint(ConexionOracle.getInstance().conectar());
    }
    
    public String volverSavePoint(){
        return ConexionOracle.volverSavePoint(ConexionOracle.getInstance().conectar());
    }
    
    public String rollback(){
        return ConexionOracle.rollback(ConexionOracle.getInstance().conectar());
    }
    
    public String commit(){
        return ConexionOracle.commit(ConexionOracle.getInstance().conectar());
    }
    
    public String desconectar(){
        return ConexionOracle.desconectar(ConexionOracle.getInstance().conectar());
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
