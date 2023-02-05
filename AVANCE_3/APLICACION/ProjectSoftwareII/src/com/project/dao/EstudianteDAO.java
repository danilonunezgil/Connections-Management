package com.project.dao;

import com.project.database.ConexionOracle;
import com.project.database.ConexionPostgresql;
import com.project.dto.InfoStudentDTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDAO {

    private static EstudianteDAO estudianteDAO;
    private static final String postgresql = "com.project.controller.PostgresqlService";
    private static final String oracle = "com.project.controller.OracleService";
    
    private EstudianteDAO() {
    }

    public static EstudianteDAO getInstance() {
        if (estudianteDAO == null) {
            estudianteDAO = new EstudianteDAO();
        }
        return estudianteDAO;
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
    
    public Number promedioCarrera(String servicio, Integer cod_est) {

        Number promedio = null;
        Connection connection = validaMotor(servicio);

        try {
            String sql = "{?=call promedio_carrera(?)}";
            // Se prepara el Statement
            CallableStatement statement = connection.prepareCall(sql);
            // Se indica que el primer interrogante es de salida.
            statement.registerOutParameter(1, Types.NUMERIC);
            // Se pasa un parámetro en el segundo interrogante.
            statement.setInt(2, cod_est);
            // Se hace la llamada a la función.
            statement.execute();
            promedio = statement.getBigDecimal(1);
            statement.close();
            System.out.println(connection);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return promedio;
    }

    public String compararNumeros(String servicio, Integer num1, Integer num2) {
        String comparacion = null;
        Connection connection = validaMotor(servicio);
        try {
            String sql = "call comparar_numeros(?,?,?)";
            // Se prepara el Statement
            CallableStatement statement = connection.prepareCall(sql);
            // Se indica que el primer interrogante es de salida.
            statement.registerOutParameter(1, Types.VARCHAR);
            // Se pasa un parámetro en el segundo interrogante.
            statement.setString(1, "");
            statement.setInt(2, num1);
            statement.setInt(3, num2);
            // Se hace la llamada a la función.
            statement.execute();
            comparacion = statement.getString(1);
            statement.close();
            System.out.println(connection);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return comparacion;
    }

    public List<InfoStudentDTO> informacionEstudiantes(String servicio) {

        ArrayList<InfoStudentDTO> listadoInfoEstudiantes = new ArrayList<>();
        String consulta = "select codigo, facultad, programa, estudiante, promedio, matriculado, ano, periodo from tmp_estudiantes";
        String sql = "call informacion_estudiantes()";
        Connection connection = validaMotor(servicio);
        try {
            CallableStatement st = connection.prepareCall(sql);
            st.execute();
            connection.commit();
            st.close();
            PreparedStatement statement = connection.prepareStatement(consulta);
            ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {
                InfoStudentDTO infoEstudiante = new InfoStudentDTO();
                infoEstudiante.setCodigo(resultado.getInt(1));
                infoEstudiante.setFacultad(resultado.getString(2));
                infoEstudiante.setPrograma(resultado.getString(3));
                infoEstudiante.setEstudiante(resultado.getString(4));
                infoEstudiante.setPromedio(resultado.getDouble(5));
                infoEstudiante.setMatriculado(resultado.getString(6));
                infoEstudiante.setAno(resultado.getInt(7));
                infoEstudiante.setPeriodo(resultado.getInt(8));
                listadoInfoEstudiantes.add(infoEstudiante);
            }
            resultado.close();
            statement.close();
            System.out.println(connection);
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return listadoInfoEstudiantes;
    }
}
