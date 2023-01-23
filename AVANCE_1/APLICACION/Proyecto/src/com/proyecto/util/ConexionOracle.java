package com.proyecto.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Savepoint;
import javax.swing.JOptionPane;


public class ConexionOracle {
    private static Connection con;
    private static Savepoint save;
    
    public static Connection conectar() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@beelz:1521:XE","edgar","4023");
            con.setAutoCommit(false);
            if(con != null){
                save = con.setSavepoint();
                System.out.println("CONECTADO A ORACLE CON EXITO");
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar a la bd", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("No se pudo conectar a la bd");
        }
        return con;
    }
    
    public static String desconectar(Connection connection){
        String mensaje;
        try {
            connection.close();
            mensaje = "CONEXION A ORACLE CERRADA";
        } catch (SQLException ex) {
            mensaje = "ERROR:"+ ex.getMessage();
       }
       return mensaje;
    }
    
    public static String commit(Connection connection){
        String mensaje;
        try {
            connection.commit();
            mensaje = "CAMBIOS APLICADOS CON EXITO";
        } catch (SQLException ex) {
            mensaje = "ERROR:"+ ex.getMessage();
       }
       return mensaje;
    }
    
    public static String rollback(Connection connection){
        String mensaje;
        try {
            connection.rollback();
            mensaje = "ROLLBACK APLICADO CON EXITO";
        } catch (SQLException ex) {
            mensaje = "ERROR:"+ ex.getMessage();
       }
       return mensaje;
    }
    
    public static String savePoint(Connection connection){
        String mensaje;
        try {
            save = connection.setSavepoint();
            mensaje = "PUNTO CREADO CON EXITO";
        } catch (SQLException ex) {
            mensaje = "ERROR:"+ ex.getMessage();
       }
       return mensaje;
    }
    
    public static String volverSavePoint(Connection connection){
        String mensaje;
        try {
            connection.rollback(save);
            mensaje = "PUNTO CARGADO CON EXITO";
        } catch (SQLException ex) {
            mensaje = "ERROR:"+ ex.getMessage();
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                mensaje = "ERROR:"+ ex1.getMessage();
            }
       }
       return mensaje;
    } 
}
