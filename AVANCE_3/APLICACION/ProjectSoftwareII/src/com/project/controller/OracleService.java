package com.project.controller;

import com.project.database.ConexionOracle;
import com.project.model.element.ElementoDAO;
import com.project.model.friend.AmigoDAO;
import com.project.model.friend.Amigo;
import com.project.model.friend.AmigoDTO;
import com.project.model.student.EstudianteDAO;
import com.project.model.student.InfoStudentDTO;
import java.util.List;
public class OracleService {
    
    private final AmigoDAO friendBO;
    private final EstudianteDAO studentBO;
    private final ElementoDAO itemBO;
    
    public OracleService() {
        this.friendBO = new AmigoDAO();
        this.studentBO = new EstudianteDAO();
        this.itemBO = new ElementoDAO();
    }

    //CRUD PARA TABLA AMIGO
    public AmigoDTO ingresarAmigo(){
        return friendBO.insertar(ConexionOracle.getInstance().conectar());
    }
    
    public List<AmigoDTO> listarAmigo(){
        return friendBO.listar(ConexionOracle.getInstance().conectar());
    }
    
    public AmigoDTO actualizarAmigo(AmigoDTO amigo){
        return friendBO.actualizar(ConexionOracle.getInstance().conectar(),amigo);
    }
    
    public void eliminarAmigo(Number idAmigo){
        friendBO.eliminar(ConexionOracle.getInstance().conectar(),idAmigo);
    }
    
    public AmigoDTO buscarAmigoId(Number idAmigo){
        return friendBO.buscarId(ConexionOracle.getInstance().conectar(),idAmigo);
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
        return studentBO.promedioCarrera(ConexionOracle.getInstance().conectar(), cod_est);
    }
    
    public Integer precioPromedio(Integer cod_ele){
        return itemBO.precioPromedioElemento(ConexionOracle.getInstance().conectar(), cod_ele);
    }
    
    public String compararNumeros(Integer numero1, Integer numero2){
        return studentBO.compararNumeros(ConexionOracle.getInstance().conectar(),numero1,numero2);
    }
    
    public List<InfoStudentDTO> informacionEstudiantes(){
        return studentBO.informacionEstudiantes(ConexionOracle.getInstance().conectar());
    }
}
