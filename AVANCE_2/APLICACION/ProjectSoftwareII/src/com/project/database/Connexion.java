package com.project.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Savepoint;
import javax.swing.JOptionPane;

public class Connexion {
    
    private static Connection con;
    private static Savepoint save;

    public static Connection conectar(String className,String url,String user,String password) {
        try {
            Class.forName(className);
            con = DriverManager.getConnection(url,user,password);
            con.setAutoCommit(false);
            if(con != null){
                save = con.setSavepoint();
                System.out.println("CONECTADO A LA BASE DE DATOS CON EXITO");
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "NO SE PUDO CONECTAR A LA BASE DATOS", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("NO SE PUDO CONECTAR A LA BD");
        }
        return con;
    }
       
    public static String desconectar(Connection connection){
        String mensaje;
        try {
            connection.close();
            mensaje = "CONEXION A LA BASE DE DATOS CERRADA";
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
