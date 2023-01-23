package com.proyecto.controlador;

import com.proyecto.modelo.AmigoBO;
import com.proyecto.modelo.AmigoVO;
import com.proyecto.modelo.FuncionBO;
import com.proyecto.modelo.ProcedimientoBO;
import com.proyecto.util.ConexionOracle;
import java.sql.Connection;
import java.util.List;

public class ControladorOracle {
    
    private final AmigoBO amigoBO;
    private final FuncionBO funcionBO;
    private final ProcedimientoBO procedimientoBO;
    private final Connection connection = ConexionOracle.conectar();
    
    public ControladorOracle() {
        this.amigoBO = new AmigoBO();
        this.funcionBO = new FuncionBO();
        this.procedimientoBO = new ProcedimientoBO();
    }
    
    //CRUD PARA TABLA AMIGO
    public AmigoVO ingresarAmigo(){
        return amigoBO.insertar(connection);
    }
    
    public List<AmigoVO> listarAmigo(){
        return amigoBO.listar(connection);
    }
    
    public AmigoVO actualizarAmigo(AmigoVO amigo){
        return amigoBO.actualizar(connection,amigo);
    }
    
    public void eliminarAmigo(Number idAmigo){
        amigoBO.eliminar(connection,idAmigo);
    }
    
    public AmigoVO buscarAmigoId(Number idAmigo){
        return amigoBO.buscarId(connection,idAmigo);
    }
    
    //CONTROL DE TRANSACCIONES
    
    public String savePoint(){
        return ConexionOracle.savePoint(connection);
    }
    
    public String volverSavePoint(){
        return ConexionOracle.volverSavePoint(connection);
    }
    
    public String rollback(){
        return ConexionOracle.rollback(connection);
    }
    
    public String commit(){
        return ConexionOracle.commit(connection);
    }
    
    public String desconectar(){
        return ConexionOracle.desconectar(connection);
    }
    
    //CONTROL DE FUNCIONES
    
    public Number promedioCarrera(Integer cod_est){
        return funcionBO.promedioCarrera(connection, cod_est);
    }
    
    public Integer precioPromedio(Integer cod_ele){
        return funcionBO.precioPromedioElemento(connection, cod_ele);
    }
    
    public String compararNumeros(Integer numero1, Integer numero2){
        return procedimientoBO.compararNumeros(connection,numero1,numero2);
    }
}
