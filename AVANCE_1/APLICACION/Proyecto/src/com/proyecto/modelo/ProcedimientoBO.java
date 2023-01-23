package com.proyecto.modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class ProcedimientoBO {

    public ProcedimientoBO() {
    }
    
    public String compararNumeros(Connection connection,Integer num1,Integer num2) {
        String comparacion = null;
        try {
            String sql = "call comparar_numeros(?,?,?)";
            // Se prepara el Statement
            CallableStatement statement = connection.prepareCall(sql);
            // Se indica que el primer interrogante es de salida.
            statement.registerOutParameter(1, Types.VARCHAR);
            // Se pasa un parámetro en el segundo interrogante.
            statement.setString(1, "");
            statement.setInt(2,num1);
            statement.setInt(3,num2);
            // Se hace la llamada a la función.
            statement.execute();
            comparacion = statement.getString(1);
            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return comparacion;
    }
    
}
