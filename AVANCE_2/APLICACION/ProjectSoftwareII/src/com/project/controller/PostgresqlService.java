package com.project.controller;

import com.project.database.ConexionPostgresql;
import com.project.model.item.ItemBO;
import com.project.model.student.StudentBO;
import com.project.model.friend.FriendBO;
import com.project.model.friend.Friend;
import com.project.model.student.InfoStudentDTO;
import java.sql.Connection;
import java.util.List;

public class PostgresqlService{
    
    private final FriendBO friendBO;
    private final StudentBO studentBO;
    private final ItemBO itemBO;
   
    public PostgresqlService() {
        this.friendBO = new FriendBO();
        this.studentBO = new StudentBO();
        this.itemBO = new ItemBO();
    }

    //CRUD PARA TABLA AMIGO
    public Friend ingresarAmigo(){
        return friendBO.insertar(ConexionPostgresql.getInstance().conectar());
    }
    
    public List<Friend> listarAmigo(){
        return friendBO.listar(ConexionPostgresql.getInstance().conectar());
    }
    
    public Friend actualizarAmigo(Friend amigo){
        return friendBO.actualizar(ConexionPostgresql.getInstance().conectar(),amigo);
    }
    
    public void eliminarAmigo(Number idAmigo){
        friendBO.eliminar(ConexionPostgresql.getInstance().conectar(),idAmigo);
    }
    
    public Friend buscarAmigoId(Number idAmigo){
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
