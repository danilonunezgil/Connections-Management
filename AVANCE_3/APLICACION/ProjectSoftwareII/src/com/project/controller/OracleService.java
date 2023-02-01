package com.project.controller;

import com.project.database.ConexionOracle;
import com.project.dao.ElementoDAO;
import com.project.dao.AmigoDAO;
import com.project.dto.AmigoDTO;
import com.project.dao.EstudianteDAO;
import com.project.dto.InfoStudentDTO;
import java.util.List;

public class OracleService {
    
    private static OracleService oracleSingleton;
    private final AmigoDAO amigoDAO;
    private final EstudianteDAO estudianteDAO;
    private final ElementoDAO elementoDAO;

    private OracleService() {
        this.amigoDAO = new AmigoDAO();
        this.estudianteDAO = new EstudianteDAO();
        this.elementoDAO = new ElementoDAO();
    }
    
    public static OracleService getInstance(){
        if(oracleSingleton == null){
            oracleSingleton = new OracleService();
        }
        return oracleSingleton;
    }
    
    //CRUD PARA TABLA AMIGO
    public AmigoDTO ingresarAmigo(){
        return amigoDAO.insertar(ConexionOracle.getInstance().conectar());
    }
    
    public List<AmigoDTO> listarAmigo(){
        return amigoDAO.listar(ConexionOracle.getInstance().conectar());
    }
    
    public AmigoDTO actualizarAmigo(AmigoDTO amigo){
        return amigoDAO.actualizar(ConexionOracle.getInstance().conectar(),amigo);
    }
    
    public void eliminarAmigo(Number idAmigo){
        amigoDAO.eliminar(ConexionOracle.getInstance().conectar(),idAmigo);
    }
    
    public AmigoDTO buscarAmigoId(Number idAmigo){
        return amigoDAO.buscarId(ConexionOracle.getInstance().conectar(),idAmigo);
    }
    
    //CONTROL DE TRANSACCIONES
    
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
    
    //CONTROL DE FUNCIONES
    
    public Number promedioCarrera(Integer cod_est){
        return estudianteDAO.promedioCarrera(ConexionOracle.getInstance().conectar(), cod_est);
    }
    
    public Integer precioPromedio(Integer cod_ele){
        return elementoDAO.precioPromedioElemento(ConexionOracle.getInstance().conectar(), cod_ele);
    }
    
    public String compararNumeros(Integer numero1, Integer numero2){
        return estudianteDAO.compararNumeros(ConexionOracle.getInstance().conectar(),numero1,numero2);
    }
    
    public List<InfoStudentDTO> informacionEstudiantes(){
        return estudianteDAO.informacionEstudiantes(ConexionOracle.getInstance().conectar());
    }
}
