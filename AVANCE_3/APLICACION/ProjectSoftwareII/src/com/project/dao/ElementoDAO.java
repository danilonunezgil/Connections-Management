package com.project.dao;

import com.project.database.ConexionOracle;
import com.project.database.ConexionPostgresql;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class ElementoDAO {
    
    private static ElementoDAO elementoDAO;
    private static final String postgresql = "com.project.controller.PostgresqlService";
    private static final String oracle = "com.project.controller.OracleService";

    
    private ElementoDAO() {
    }
    
    public static ElementoDAO getInstance(){
        if(elementoDAO == null){
            elementoDAO = new ElementoDAO();
        }
        return elementoDAO;
    }
    
    
    public Connection validaMotor(String servicio) {
        Connection connection = null;
        if (postgresql.equals(servicio)) {
            connection = ConexionPostgresql.getInstance().conexion();
        } else if (oracle.equals(servicio)) {
            connection = ConexionOracle.getInstance().conexion();
        }
        return connection;
    }
    
    public Integer precioPromedioElemento(String servicio, Integer cod_ele) {
        Integer precio_promedio = null;
        Connection connection = validaMotor(servicio);
        try {
            String sql = "{?=call precio_promedio_elemento(?)}";
            // Se prepara el Statement
            CallableStatement statement = connection.prepareCall(sql);
            // Se indica que el primer interrogante es de salida.
            statement.registerOutParameter(1, Types.INTEGER);
            // Se pasa un parámetro en el segundo interrogante.
            statement.setInt(2, cod_ele);
            // Se hace la llamada a la función.
            statement.execute();
            precio_promedio = statement.getInt(1);
            statement.close();
            System.out.println(connection);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return precio_promedio;
    }

}
