package com.project.dao;

import com.project.controller.OracleService;
import com.project.controller.PostgresqlService;
import com.project.database.ConexionOracle;
import com.project.database.ConexionPostgresql;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class ElementoDAO {

    public ElementoDAO() {
    }

    public Integer precioPromedioElemento(Class servicio, Integer cod_ele) {
        Integer precio_promedio = null;
        Connection connection = null;
        if (servicio.equals(PostgresqlService.class)) {
            connection = ConexionPostgresql.getInstance().conexion();
        } else if (servicio.equals(OracleService.class)) {
            connection = ConexionOracle.getInstance().conexion();
        }
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
