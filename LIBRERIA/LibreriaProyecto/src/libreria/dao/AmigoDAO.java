package libreria.dao;

import libreria.database.ConexionOracle;
import libreria.database.ConexionPostgresql;
import java.sql.Connection;
import libreria.model.Amigo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase AmigoDAO encargada de comunicarse con la base de datos
 * @author Edgar,Danilo y Johan
 */
public class AmigoDAO {
    
    private static AmigoDAO amigoDAO;
  
    /**
    * Constructor privado de AmigoDAO
    * @author Edgar,Danilo y Johan
    */
    private AmigoDAO() {
    }
    
    /**
    * Este método se encarga de crear e instanciar un unico objeto AmigoDAO
    * @author Edgar,Danilo y Johan
    * @return Objeto de tipo AmigoDAO
    */
    public static AmigoDAO getInstance() {
        if (amigoDAO == null) {
            amigoDAO = new AmigoDAO();
        }
        return amigoDAO;
    }

    //SECCION DE ORACLE
    
    /**
    * Método encargado de listar los amigos guardados en la base de datos de oracle
    * @author Edgar,Danilo y Johan
    * @return Lista de objetos de tipo Amigo
    */
    public List<Amigo> listarAmigosOracle() {

        ArrayList<Amigo> listadoAmigos = new ArrayList<>();
        String consulta = "select id, nombre, apellido, telefono, direccion, correo from amigos";
        Connection connection = ConexionOracle.getInstance().conexion();
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
    
    /**
    * Método encargado de insertar un objeto de tipo Amigo en la base de datos de oracle 
    * @author Edgar,Danilo y Johan
    * @param amigo Objeto de tipo Amigo que se desea ingresar en la base de datos
    * @return Objeto de tipo Amigo que fue ingresado en la base datos
    */
    public Amigo insertarAmigoOracle(Amigo amigo) {
        String consulta = "insert into amigos(nombre,apellido, telefono, direccion, correo) values(?,?,?,?,?)";
        Connection connection = ConexionOracle.getInstance().conexion();
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
    
     /**
    * Método encargado de buscar un amigo en la base de datos de oracle
    * @author Edgar,Danilo y Johan
    * @param idAmigo Number que contiene el identificador del amigo a buscar
    * @return Objeto de tipo Amigo que fue encontrado en la base datos
    */
    public Amigo buscarIdAmigoOracle(Number idAmigo) {
        Amigo amigo = new Amigo();
        Connection connection = ConexionOracle.getInstance().conexion();
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
    
    /**
    * Método encargado de actualizar la informacion de un amigo en la base de datos de oracle
    * @author Edgar,Danilo y Johan
    * @param amigo Objeto de tipo amigo al cual se quiere actualizar informacion 
    * @return Objeto de tipo Amigo con las actualizaciones agregadas en la base datos
    */
    public Amigo actualizarAmigoOracle(Amigo amigo) {
        Connection connection = ConexionOracle.getInstance().conexion();
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
    
    /**
    * Método encargado de eliminar un amigo en la base de datos de oracle
    * @author Edgar,Danilo y Johan
    * @param idAmigo Number que contiene el identificador del amigo a eliminar
    */
    public void eliminarAmigoOracle(Number idAmigo) {
        Connection connection = ConexionOracle.getInstance().conexion();
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
    
    /**
    * Método encargado de realizar savepoint para control de transacciones en oracle
    * @author Edgar,Danilo y Johan
    * @return String que contiene mensaje de exito o falla al realizar savepoint
    */
    public String savePointOracle() {
        Connection connection = ConexionOracle.getInstance().conexion();
        return ConexionOracle.savePoint(connection);
    }
    
    /**
    * Método encargado de cargar savepoint creado en oracle
    * @author Edgar,Danilo y Johan
    * @return String que contiene mensaje de exito o falla al cargar el savepoint
    */
    public String volverSaveOracle() {
        Connection connection = ConexionOracle.getInstance().conexion();
        return  ConexionOracle.volverSavePoint(connection);
    }

    /**
    * Método encargado de realizar rollback en oracle
    * @author Edgar,Danilo y Johan
    * @return String que contiene mensaje de exito o falla del rollback
    */
    public String rollbackOracle() {
        Connection connection = ConexionOracle.getInstance().conexion();
        return  ConexionOracle.rollback(connection);
    }
    
    /**
    * Método encargado de realizar commit en oracle 
    * @author Edgar,Danilo y Johan
    * @return String que contiene mensaje de exito o falla al realizar commit
    */
    public String commitOracle() {
        Connection connection = ConexionOracle.getInstance().conexion();
        return  ConexionOracle.commit(connection);
    }
    
    //SECCION DE POSTGRESQL
    
    /**
    * Método encargado de insertar un objeto de tipo Amigo en la base de datos de postgresql 
    * @author Edgar,Danilo y Johan
    * @param amigo Objeto de tipo Amigo que se desea ingresar en la base de datos
    * @return Objeto de tipo Amigo que fue ingresado en la base datos
    */
    public Amigo insertarAmigoPostgres(Amigo amigo) {
        String consulta = "insert into amigos(nombre,apellido, telefono, direccion, correo) values(?,?,?,?,?)";
        Connection connection = ConexionPostgresql.getInstance().conexion();
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
   
    /**
    * Método encargado de listar los amigos guardados en la base de datos de postgresql
    * @author Edgar,Danilo y Johan
    * @return Lista de objetos de tipo Amigo
    */
    public List<Amigo> listarAmigosPostgres() {

        ArrayList<Amigo> listadoAmigos = new ArrayList<>();
        String consulta = "select id, nombre, apellido, telefono, direccion, correo from amigos";
        Connection connection = ConexionPostgresql.getInstance().conexion();
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
  
    /**
    * Método encargado de buscar un amigo en la base de datos de postgresql
    * @author Edgar,Danilo y Johan
    * @param idAmigo Number que contiene el identificador del amigo a buscar
    * @return Objeto de tipo Amigo que fue encontrado en la base datos
    */
    public Amigo buscarIdAmigoPostgres(Number idAmigo) {
        Amigo amigo = new Amigo();
        Connection connection = ConexionPostgresql.getInstance().conexion();
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
    
    /**
    * Método encargado de actualizar la informacion de un amigo en la base de datos de postgresql
    * @author Edgar,Danilo y Johan
    * @param amigo Objeto de tipo amigo al cual se quiere actualizar informacion 
    * @return Objeto de tipo Amigo con las actualizaciones agregadas en la base datos
    */
    public Amigo actualizarAmigoPostgres(Amigo amigo) {
        Connection connection = ConexionPostgresql.getInstance().conexion();
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
    
    /**
    * Método encargado de eliminar un amigo en la base de datos de postgresql
    * @author Edgar,Danilo y Johan
    * @param idAmigo Number que contiene el identificador del amigo a eliminar
    */
    public void eliminarAmigoPostgres(Number idAmigo) {
        Connection connection = ConexionPostgresql.getInstance().conexion();
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
    
    /**
    * Método encargado de realizar savepoint para control de transacciones en postgresql
    * @author Edgar,Danilo y Johan
    * @return String que contiene mensaje de exito o falla al realizar savepoint
    */
    public String savePointPostgres() {
        Connection connection = ConexionPostgresql.getInstance().conexion();
        return ConexionPostgresql.savePoint(connection);
    }
    
    /**
    * Método encargado de cargar savepoin creado en postgresql
    * @author Edgar,Danilo y Johan
    * @return String que contiene mensaje de exito o falla al cargar el savepoint
    */
    public String volverSavePostgres() {
        Connection connection = ConexionPostgresql.getInstance().conexion();
        return  ConexionPostgresql.volverSavePoint(connection);
    }

    /**
    * Método encargado de realizar rollback en postgresql
    * @author Edgar,Danilo y Johan
    * @return String que contiene mensaje de exito o falla del rollback
    */
    public String rollbackPostgres() {
        Connection connection = ConexionPostgresql.getInstance().conexion();
        return  ConexionPostgresql.rollback(connection);
    }
    
    /**
    * Método encargado de realizar commit en postgresql 
    * @author Edgar,Danilo y Johan
    * @return String que contiene mensaje de exito o falla al realizar commit
    */
    public String commitPostgres() {
        Connection connection = ConexionPostgresql.getInstance().conexion();
        return  ConexionPostgresql.commit(connection);
    }
}
