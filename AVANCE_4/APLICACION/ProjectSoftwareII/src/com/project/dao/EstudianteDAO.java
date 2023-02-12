package com.project.dao;

import com.project.database.ConexionOracle;
import com.project.database.ConexionPostgresql;
import com.project.dto.InfoStudentDTO;
import com.project.model.Estudiante;
import java.sql.Blob;
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

    private EstudianteDAO() {
    }

    public static EstudianteDAO getInstance() {
        if (estudianteDAO == null) {
            estudianteDAO = new EstudianteDAO();
        }
        return estudianteDAO;
    }
  
    public Number promedioCarreraPostgres(Integer cod_est) {

        Number promedio = null;
        Connection connection = ConexionPostgresql.getInstance().conexion();

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

    public String compararNumerosPostgres(Integer num1, Integer num2) {
        String comparacion = null;
        Connection connection = ConexionPostgresql.getInstance().conexion();
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

    public List<InfoStudentDTO> informacionEstudiantesPostgres() {

        ArrayList<InfoStudentDTO> listadoInfoEstudiantes = new ArrayList<>();
        String consulta = "select codigo, facultad, programa, estudiante, promedio, matriculado, ano, periodo from tmp_estudiantes";
        String sql = "call informacion_estudiantes()";
        Connection connection = ConexionPostgresql.getInstance().conexion();
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
    
    public Estudiante buscarIdEstudiantePostgres(Number idEstudiante) {
        Estudiante estudiante = new Estudiante();
        Connection connection = ConexionPostgresql.getInstance().conexion();
        try {
            String consulta = "select * from estudiante where id = " + idEstudiante;
            PreparedStatement statement = connection.prepareStatement(consulta);
            ResultSet resultado = statement.executeQuery();
            if (resultado.next()) {
                estudiante.setCodigo(resultado.getInt(1));
                estudiante.setNombres(resultado.getString(2));
                estudiante.setApellido1(resultado.getString(3));
                estudiante.setApellido2(resultado.getString(4));
                estudiante.setTelefono(resultado.getString(5));
                estudiante.setFacultad(resultado.getString(6));
                estudiante.setPrograma(resultado.getString(7));
                estudiante.setFecha_inicio(resultado.getDate(8));
                Blob blob = resultado.getBlob(9);
                estudiante.setFoto(blob.getBytes(1, (int)blob.length()));
            }
            resultado.close();
            statement.close();
        } catch (SQLException e) {
            e.getMessage();
        }
        return estudiante;
    }
    
    public Number promedioCarreraOracle(Integer cod_est) {

        Number promedio = null;
        Connection connection = ConexionOracle.getInstance().conexion();

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

    public String compararNumerosOracle(Integer num1, Integer num2) {
        String comparacion = null;
        Connection connection = ConexionOracle.getInstance().conexion();
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

    public List<InfoStudentDTO> informacionEstudiantesOracle() {

        ArrayList<InfoStudentDTO> listadoInfoEstudiantes = new ArrayList<>();
        String consulta = "select codigo, facultad, programa, estudiante, promedio, matriculado, ano, periodo from tmp_estudiantes";
        String sql = "call informacion_estudiantes()";
        Connection connection = ConexionOracle.getInstance().conexion();
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
    
    public Estudiante buscarIdEstudianteOracle(Number idEstudiante) {
        Estudiante estudiante = new Estudiante();
        Connection connection = ConexionOracle.getInstance().conexion();
        try {
            String consulta = "select * from estudiante where id = " + idEstudiante;
            PreparedStatement statement = connection.prepareStatement(consulta);
            ResultSet resultado = statement.executeQuery();
            if (resultado.next()) {
                estudiante.setCodigo(resultado.getInt(1));
                estudiante.setNombres(resultado.getString(2));
                estudiante.setApellido1(resultado.getString(3));
                estudiante.setApellido2(resultado.getString(4));
                estudiante.setTelefono(resultado.getString(5));
                estudiante.setFacultad(resultado.getString(6));
                estudiante.setPrograma(resultado.getString(7));
                estudiante.setFecha_inicio(resultado.getDate(8));
                Blob blob = resultado.getBlob(9);
                estudiante.setFoto(blob.getBytes(1, (int)blob.length()));
            }
            resultado.close();
            statement.close();
        } catch (SQLException e) {
            e.getMessage();
        }
        return estudiante;
    }
}
