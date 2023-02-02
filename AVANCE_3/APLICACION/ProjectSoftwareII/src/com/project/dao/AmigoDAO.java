package com.project.dao;

import com.project.controller.OracleService;
import com.project.controller.PostgresqlService;
import com.project.database.ConexionOracle;
import com.project.database.ConexionPostgresql;
import com.project.dto.AmigoDTO;
import java.sql.Connection;
import com.project.model.Amigo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AmigoDAO {
    
    private static AmigoDAO amigoDAO;

    private AmigoDAO() { 
    }
    
    public static AmigoDAO getInstance(){
        if(amigoDAO == null){
            amigoDAO = new AmigoDAO();
        }
        return amigoDAO;
    }
   
    public List<Amigo> listar(Class servicio) {

        ArrayList<Amigo> listadoAmigos = new ArrayList<>();
        String consulta = "select id, nombre, apellido, telefono, direccion, correo from amigos";
        Connection connection = null;
        if (servicio.equals(PostgresqlService.class)) {
            connection = ConexionPostgresql.getInstance().conexion();
        } else if (servicio.equals(OracleService.class)) {
            connection = ConexionOracle.getInstance().conexion();
        }
        try {
            PreparedStatement statement = connection.prepareStatement(consulta);
            ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {
                Amigo amigo = new Amigo();
                amigo.setId(resultado.getInt(1));
                amigo.setNombre(resultado.getString(2));
                amigo.setApellido(resultado.getString(3));
                amigo.setTelefono(resultado.getString(4));
                amigo.setDireccion(resultado.getString(5));
                amigo.setCorreo(resultado.getString(6));
                listadoAmigos.add(amigo);
            }
            resultado.close();
            statement.close();
            System.out.println(connection);
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return listadoAmigos;
    }

    public Amigo insertar(Class servicio,Amigo amigo) {
        String consulta = "insert into amigos(nombre,apellido, telefono, direccion, correo) values(?,?,?,?,?)";
        Connection connection = null;
        if (servicio.equals(PostgresqlService.class)) {
            connection = ConexionPostgresql.getInstance().conexion();
        } else if (servicio.equals(OracleService.class)) {
            connection = ConexionOracle.getInstance().conexion();
        }
        try {
            PreparedStatement statement = connection.prepareStatement(consulta);
            statement.setString(1, amigo.getNombre());
            statement.setString(2, amigo.getApellido());
            statement.setString(3, amigo.getTelefono());
            statement.setString(4, amigo.getDireccion());
            statement.setString(5, amigo.getCorreo());
            statement.executeUpdate();
            statement.close();
            System.out.println(connection);
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return amigo;
    }

    public Amigo buscarId(Class servicio, Number idAmigo) {
        Amigo amigo = new Amigo();
        Connection connection = null;
        if (servicio.equals(PostgresqlService.class)) {
            connection = ConexionPostgresql.getInstance().conexion();
        } else if (servicio.equals(OracleService.class)) {
            connection = ConexionOracle.getInstance().conexion();
        }
        try {
            String consulta = "select * from amigos where id = " + idAmigo;
            PreparedStatement statement = connection.prepareStatement(consulta);
            ResultSet resultado = statement.executeQuery();
            if (resultado.next()) {
                amigo.setId(resultado.getInt(1));
                amigo.setNombre(resultado.getString(2));
                amigo.setApellido(resultado.getString(3));
                amigo.setTelefono(resultado.getString(4));
                amigo.setDireccion(resultado.getString(5));
                amigo.setCorreo(resultado.getString(6));
            }
            resultado.close();
            statement.close();
        } catch (SQLException e) {
            e.getMessage();
        }
        return amigo;
    }

    public Amigo actualizar(Class servicio, Amigo amigo) {
        Connection connection = null;
        if (servicio.equals(PostgresqlService.class)) {
            connection = ConexionPostgresql.getInstance().conexion();
        } else if (servicio.equals(OracleService.class)) {
            connection = ConexionOracle.getInstance().conexion();
        }
        try {
            String consulta = "update amigos set nombre = '" + amigo.getNombre() + "', apellido = '" + amigo.getApellido()
                    + "', telefono = '" + amigo.getTelefono() + "', direccion = '" + amigo.getDireccion() + "', correo = '" + amigo.getCorreo()
                    + "' where id = " + amigo.getId();
            PreparedStatement statement = connection.prepareStatement(consulta);
            statement.executeUpdate();
            statement.close();
            System.out.println(connection);
        } catch (SQLException e) {
            e.getMessage();
        }
        return amigo;
    }

    public void eliminar(Class servicio, Number idAmigo) {
        Connection connection = null;
        if (servicio.equals(PostgresqlService.class)) {
            connection = ConexionPostgresql.getInstance().conexion();
        } else if (servicio.equals(OracleService.class)) {
            connection = ConexionOracle.getInstance().conexion();
        }
        try {
            String consulta = "delete from amigos where id = " + idAmigo;
            PreparedStatement statement = connection.prepareStatement(consulta);
            statement.executeUpdate();
            statement.close();
            System.out.println(connection);
        } catch (SQLException e) {
            e.getMessage();
        }
    }
    
    public String savePoint(Class servicio){
        Connection connection = null;
        String rt = null;
        if (servicio.equals(PostgresqlService.class)) {
            connection = ConexionPostgresql.getInstance().conexion();
            rt = ConexionPostgresql.savePoint(connection);
        } else if (servicio.equals(OracleService.class)) {
            connection = ConexionOracle.getInstance().conexion();
            rt = ConexionOracle.savePoint(connection);
        }
        return rt;
    }
    
    public String volverSave(Class servicio){
        Connection connection = null;
        String rt = null;
        if (servicio.equals(PostgresqlService.class)) {
            connection = ConexionPostgresql.getInstance().conexion();
            rt = ConexionPostgresql.volverSavePoint(connection);
        } else if (servicio.equals(OracleService.class)) {
            connection = ConexionOracle.getInstance().conexion();
            rt = ConexionOracle.volverSavePoint(connection);
        }
        return rt;
    }
    
    public String rollback(Class servicio){
        Connection connection = null;
        String rt = null;
        if (servicio.equals(PostgresqlService.class)) {
            connection = ConexionPostgresql.getInstance().conexion();
            rt = ConexionPostgresql.rollback(connection);
        } else if (servicio.equals(OracleService.class)) {
            connection = ConexionOracle.getInstance().conexion();
            rt = ConexionOracle.rollback(connection);
        }
        return rt;
    }
    
    public String commit(Class servicio){
        Connection connection = null;
        String rt = null;
        if (servicio.equals(PostgresqlService.class)) {
            connection = ConexionPostgresql.getInstance().conexion();
            rt = ConexionPostgresql.savePoint(connection);
        } else if (servicio.equals(OracleService.class)) {
            connection = ConexionOracle.getInstance().conexion();
            rt = ConexionOracle.commit(connection);
        }
        return rt;
    }

}
