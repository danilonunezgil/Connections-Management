package com.project.controller;

import com.project.database.ConexionPostgresql;
import com.project.dao.ElementoDAO;
import com.project.dao.EstudianteDAO;
import com.project.dao.AmigoDAO;
import com.project.dto.AmigoDTO;
import com.project.dto.InfoStudentDTO;
import java.util.List;
import java.sql.Connection;

public class PostgresqlService{
    
    private static PostgresqlService postgresqlSingleton;
    private final AmigoDAO amigoDAO;
    private final EstudianteDAO estudianteDAO;
    private final ElementoDAO elementoDAO;
    
    private PostgresqlService(){
        this.amigoDAO = new AmigoDAO();
        this.estudianteDAO = new EstudianteDAO();
        this.elementoDAO = new ElementoDAO();
    }
    
    public static PostgresqlService getInstance(){
        if(postgresqlSingleton == null){
            postgresqlSingleton = new PostgresqlService();
        }
        return postgresqlSingleton;
    }
    
    public static Connection conectarPostgres(){
        return ConexionPostgresql.getInstance().conectar();
    }
    
    //CRUD PARA TABLA AMIGO
    public AmigoDTO ingresarAmigo(){
        return amigoDAO.insertar(ConexionPostgresql.getInstance().conectar());
    }
    
    public List<AmigoDTO> listarAmigo(){
        return amigoDAO.listar(ConexionPostgresql.getInstance().conectar());
    }
    
    public AmigoDTO actualizarAmigo(AmigoDTO amigo){
        return amigoDAO.actualizar(ConexionPostgresql.getInstance().conectar(),amigo);
    }
    
    public void eliminarAmigo(Number idAmigo){
        amigoDAO.eliminar(ConexionPostgresql.getInstance().conectar(),idAmigo);
    }
    
    public AmigoDTO buscarAmigoId(Number idAmigo){
        return amigoDAO.buscarId(ConexionPostgresql.getInstance().conectar(),idAmigo);
    }
    //CONTROL DE TRANSACCIONES
    
    public String savePoint(){
        return ConexionPostgresql.savePoint(ConexionPostgresql.getInstance().conectar());
    }
    
    public String volverSavePoint(){
        return ConexionPostgresql.volverSavePoint(ConexionPostgresql.getInstance().conectar());
    }
    
    public String rollback(){
        return ConexionPostgresql.rollback(ConexionPostgresql.getInstance().conectar());
    }
    
    public String commit(){
        return ConexionPostgresql.commit(ConexionPostgresql.getInstance().conectar());
    }
    
    public String desconectar(){
        return ConexionPostgresql.desconectar(ConexionPostgresql.getInstance().conectar());
    }
    
     //CONTROL DE FUNCIONES
    public Number promedioCarrera(Integer cod_est){
        return estudianteDAO.promedioCarrera(ConexionPostgresql.getInstance().conectar(), cod_est);
    }
    
    public Integer precioPromedio(Integer cod_ele){
        return elementoDAO.precioPromedioElemento(ConexionPostgresql.getInstance().conectar(), cod_ele);
    }
    
    public String compararNumeros(Integer numero1, Integer numero2){
        return estudianteDAO.compararNumeros(ConexionPostgresql.getInstance().conectar(),numero1,numero2);
    }
    
    public List<InfoStudentDTO> informacionEstudiantes(){
        return estudianteDAO.informacionEstudiantes(ConexionPostgresql.getInstance().conectar());
    }
}
