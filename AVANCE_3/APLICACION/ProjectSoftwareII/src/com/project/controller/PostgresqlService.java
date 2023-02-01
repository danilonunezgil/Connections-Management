package com.project.controller;

import com.project.dao.ElementoDAO;
import com.project.dao.EstudianteDAO;
import com.project.dao.AmigoDAO;
import com.project.dto.AmigoDTO;
import com.project.dto.InfoStudentDTO;
import java.util.List;

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
    
    //CRUD PARA TABLA AMIGO
    public AmigoDTO ingresarAmigo(){
        return amigoDAO.insertar(PostgresqlService.class);
    }
    
    public List<AmigoDTO> listarAmigo(){
        return amigoDAO.listar(PostgresqlService.class);
    }
    
    public AmigoDTO actualizarAmigo(AmigoDTO amigo){
        return amigoDAO.actualizar(PostgresqlService.class,amigo);
    }
    
    public void eliminarAmigo(Number idAmigo){
        amigoDAO.eliminar(PostgresqlService.class,idAmigo);
    }
    
    public AmigoDTO buscarAmigoId(Number idAmigo){
        return amigoDAO.buscarId(PostgresqlService.class,idAmigo);
    }
    //CONTROL DE TRANSACCIONES
    /*
    public String savePoint(){
        return ConexionPostgresql.savePoint(PostgresqlService.class);
    }
    
    public String volverSavePoint(){
        return ConexionPostgresql.volverSavePoint(PostgresqlService.class);
    }
    
    public String rollback(){
        return ConexionPostgresql.rollback(PostgresqlService.class);
    }
    
    public String commit(){
        return ConexionPostgresql.commit(PostgresqlService.class);
    }
    
    public String desconectar(){
        return ConexionPostgresql.desconectar(PostgresqlService.class);
    }*/
    
     //CONTROL DE FUNCIONES
    public Number promedioCarrera(Integer cod_est){
        return estudianteDAO.promedioCarrera(PostgresqlService.class, cod_est);
    }
    
    public Integer precioPromedio(Integer cod_ele){
        return elementoDAO.precioPromedioElemento(PostgresqlService.class, cod_ele);
    }
    
    public String compararNumeros(Integer numero1, Integer numero2){
        return estudianteDAO.compararNumeros(PostgresqlService.class,numero1,numero2);
    }
    
    public List<InfoStudentDTO> informacionEstudiantes(){
        return estudianteDAO.informacionEstudiantes(PostgresqlService.class);
    }
}
