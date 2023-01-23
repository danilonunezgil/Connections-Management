package com.project.controller;

import com.project.database.Connexion;
import com.project.model.item.ItemBO;
import com.project.model.friend.FriendBO;
import com.project.model.friend.Friend;
import com.project.model.student.StudentBO;
import com.project.model.student.InfoStudentDTO;
import java.sql.Connection;
import java.util.List;
public class OracleService {
    
    private final FriendBO friendBO;
    private final StudentBO studentBO;
    private final ItemBO itemBO;
    private final Connection connection = Connexion.conectar("oracle.jdbc.driver.OracleDriver","jdbc:oracle:thin:@beelz:1521:XE","edgar","4023");
    
    
    public OracleService() {
        this.friendBO = new FriendBO();
        this.studentBO = new StudentBO();
        this.itemBO = new ItemBO();
    }

    //CRUD PARA TABLA AMIGO
    public Friend ingresarAmigo(){
        return friendBO.insertar(connection);
    }
    
    public List<Friend> listarAmigo(){
        return friendBO.listar(connection);
    }
    
    public Friend actualizarAmigo(Friend amigo){
        return friendBO.actualizar(connection,amigo);
    }
    
    public void eliminarAmigo(Number idAmigo){
        friendBO.eliminar(connection,idAmigo);
    }
    
    public Friend buscarAmigoId(Number idAmigo){
        return friendBO.buscarId(connection,idAmigo);
    }
    
    //CONTROL DE TRANSACCIONES
    
    public String savePoint(){
        return Connexion.savePoint(connection);
    }
    
    public String volverSavePoint(){
        return Connexion.volverSavePoint(connection);
    }
    
    public String rollback(){
        return Connexion.rollback(connection);
    }
    
    public String commit(){
        return Connexion.commit(connection);
    }
    
    public String desconectar(){
        return Connexion.desconectar(connection);
    }
    
    //CONTROL DE FUNCIONES
    
    public Number promedioCarrera(Integer cod_est){
        return studentBO.promedioCarrera(connection, cod_est);
    }
    
    public Integer precioPromedio(Integer cod_ele){
        return itemBO.precioPromedioElemento(connection, cod_ele);
    }
    
    public String compararNumeros(Integer numero1, Integer numero2){
        return studentBO.compararNumeros(connection,numero1,numero2);
    }
    
    public List<InfoStudentDTO> informacionEstudiantes(){
        return studentBO.informacionEstudiantes(connection);
    }
}
