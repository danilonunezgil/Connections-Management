package com.project.model.element;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class ElementoDAO {
    
    public ElementoDAO() {
    }
    
     public Integer precioPromedioElemento(Connection connection,Integer cod_ele) {
        Integer precio_promedio = null;
        try {
            String sql = "{?=call precio_promedio_elemento(?)}";
            // Se prepara el Statement
            CallableStatement statement = connection.prepareCall(sql);
            // Se indica que el primer interrogante es de salida.
            statement.registerOutParameter(1, Types.INTEGER);
            // Se pasa un parámetro en el segundo interrogante.
            statement.setInt(2,cod_ele);
            // Se hace la llamada a la función.
            statement.execute();
            precio_promedio = statement.getInt(1);
            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return precio_promedio;
    } 
    
}
