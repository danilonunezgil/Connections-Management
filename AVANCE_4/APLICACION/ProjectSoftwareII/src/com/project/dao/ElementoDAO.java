package com.project.dao;

import com.project.database.ConexionOracle;
import com.project.database.ConexionPostgresql;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

/**
 * Clase ElementoDAO encargada de comunicarse con la base de datos
 * @author Edgar,Danilo y Johan
 */
public class ElementoDAO {
    
    private static ElementoDAO elementoDAO;

    /**
    * Constructor privado de ElementoDAO
    * @author Edgar,Danilo y Johan
    */
    private ElementoDAO() {
    }
    
    /**
    * Este método se encarga de crear e instanciar un unico objeto ElementoDAO
    * @author Edgar,Danilo y Johan
    * @return Objeto de tipo ElementoDAO
    */
    public static ElementoDAO getInstance(){
        if(elementoDAO == null){
            elementoDAO = new ElementoDAO();
        }
        return elementoDAO;
    }

    public Integer precioPromedioElementoOracle(Integer cod_ele) {
        Integer precio_promedio = null;
        Connection connection = ConexionOracle.getInstance().conexion();
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
    
    public Integer precioPromedioElementoPostgres(Integer cod_ele) {
        Integer precio_promedio = null;
        Connection connection = ConexionPostgresql.getInstance().conexion();
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
