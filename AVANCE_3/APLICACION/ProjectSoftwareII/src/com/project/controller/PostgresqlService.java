package com.project.controller;

import com.project.database.ConexionPostgresql;
import com.project.model.element.ElementoDAO;
import com.project.model.student.EstudianteDAO;
import com.project.model.friend.AmigoDAO;
import com.project.model.friend.Amigo;
import com.project.model.friend.AmigoDTO;
import com.project.model.student.InfoStudentDTO;
import java.util.List;

public class PostgresqlService{
    
    private final AmigoDAO friendBO;
    private final EstudianteDAO studentBO;
    private final ElementoDAO itemBO;
   
    public PostgresqlService() {
        this.friendBO = new AmigoDAO();
        this.studentBO = new EstudianteDAO();
        this.itemBO = new ElementoDAO();
    }

    //CRUD PARA TABLA AMIGO
    public AmigoDTO ingresarAmigo(){
        return friendBO.insertar(ConexionPostgresql.getInstance().conectar());
    }
    
    public List<AmigoDTO> listarAmigo(){
        return friendBO.listar(ConexionPostgresql.getInstance().conectar());
    }
    
    public AmigoDTO actualizarAmigo(AmigoDTO amigo){
        return friendBO.actualizar(ConexionPostgresql.getInstance().conectar(),amigo);
    }
    
    public void eliminarAmigo(Number idAmigo){
        friendBO.eliminar(ConexionPostgresql.getInstance().conectar(),idAmigo);
    }
    
    public AmigoDTO buscarAmigoId(Number idAmigo){
        return friendBO.buscarId(ConexionPostgresql.getInstance().conectar(),idAmigo);
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
        return studentBO.promedioCarrera(ConexionPostgresql.getInstance().conectar(), cod_est);
    }
    
    public Integer precioPromedio(Integer cod_ele){
        return itemBO.precioPromedioElemento(ConexionPostgresql.getInstance().conectar(), cod_ele);
    }
    
    public String compararNumeros(Integer numero1, Integer numero2){
        return studentBO.compararNumeros(ConexionPostgresql.getInstance().conectar(),numero1,numero2);
    }
    
    public List<InfoStudentDTO> informacionEstudiantes(){
        return studentBO.informacionEstudiantes(ConexionPostgresql.getInstance().conectar());
    }
}
