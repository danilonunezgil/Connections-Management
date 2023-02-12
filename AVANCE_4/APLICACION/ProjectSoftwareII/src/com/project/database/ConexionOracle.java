package com.project.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Savepoint;
import javax.swing.JOptionPane;

/**
* Clase ConexionOracle encargada de realizar la conexion con oracle
* @author Edgar,Danilo y Johan
*/
public class ConexionOracle {
    
    private static ConexionOracle connectInstance;
    private static Connection con;
    private static Savepoint save;
    
    private final String classname = "oracle.jdbc.driver.OracleDriver";
    private final String url = "jdbc:oracle:thin:@localhost:1521:XE";
    private final String user = "admin";
    private final String pass = "password";
    
   /**
   * Constructor privado de ConexionOracle
   * @author Edgar,Danilo y Johan
   */ 
   private ConexionOracle() {
        try {
            try {
                Class.forName(classname);
            } catch (ClassNotFoundException ex) {
                System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
            }
            
            con = DriverManager.getConnection(url,user,pass);
            con.setAutoCommit(false);
            if(con != null){
                save = con.setSavepoint();
                //System.out.println(con);
                System.out.println("CONECTADO A ORACLE CON EXITO");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar a la bd", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("No se pudo conectar a la bd");
        }
    }
    
    /**
    * Este método se encarga de crear e instanciar un unico objeto ConexionOracle
    * @author Edgar,Danilo y Johan
    * @return Objeto de tipo ConexionOracle
    */
    public static ConexionOracle getInstance(){
        if(connectInstance == null){
            connectInstance = new ConexionOracle();
        }
      return connectInstance;
    }
    
    /**
    * Este método se encarga de retornar la conexion con la base de datos
    * @author Edgar,Danilo y Johan
    * @return Objeto de tipo Connection
    */
    public Connection conexion() {
        return con;
    }
    
    /**
    * Este método se encarga de finalizar la conexion con la base de datos
    * @author Edgar,Danilo y Johan
    * @param connection Connection contiene la conexion que se desea finalizar
    * @return String con mensaje de exito o error de la desconexion
    */
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
    
    /**
    * Este método se encarga de confirmar los cambios realizados en la base de datos
    * @author Edgar,Danilo y Johan
    * @param connection Connection contiene la conexion a la base de datos que se desea confirmar los cambios
    * @return String con mensaje de exito o error del commit
    */
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
    
    /**
    * Este método se encarga de deshacer los cambios realizados en la base de datos
    * @author Edgar,Danilo y Johan
    * @param connection Connection contiene la conexion a la base de datos a que se quiere deshacer los cambios
    * @return String con mensaje de exito o error del rollback
    */
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
    
    /**
    * Este método se encarga de crear un punto de guardado con los cambios realizados hasta ese momento en la base de datos
    * @author Edgar,Danilo y Johan
    * @param connection Connection contiene la conexion a la base de datos que se quiere aplicar un savepoint
    * @return String con mensaje de exito o error del savePoint
    */
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
    
    /**
    * Este método se encarga de cargar un punto de guardado existente en la base de datos
    * @author Edgar,Danilo y Johan
    * @param connection Connection contiene la conexion a la base de datos a la cual se quiere cargar el punto de guardado
    * @return String con mensaje de exito o error del rollback(save)
    */
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
