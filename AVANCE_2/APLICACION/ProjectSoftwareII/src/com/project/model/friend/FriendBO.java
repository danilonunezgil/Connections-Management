package com.project.model.friend;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class FriendBO {
    
 
    public FriendBO() {
    }
    
    public List<Friend> listar(Connection connection){
        
        ArrayList<Friend> listadoAmigos = new ArrayList<>();
        String consulta = "select id, nombre, apellido, telefono, direccion, correo from amigos";
        try {
            PreparedStatement statement = connection.prepareStatement(consulta);
            ResultSet resultado = statement.executeQuery();

            while (resultado.next()) {
                Friend amigoVO = new Friend();
                amigoVO.setId(resultado.getInt(1));
                amigoVO.setNombre(resultado.getString(2));
                amigoVO.setApellido(resultado.getString(3));
                amigoVO.setTelefono(resultado.getString(4));
                amigoVO.setDireccion(resultado.getString(5));
                amigoVO.setCorreo(resultado.getString(6));
                listadoAmigos.add(amigoVO);
            }
            resultado.close();
            statement.close();
        } catch (SQLException ex) {
            ex.getMessage();
        }
        System.out.println(connection);
        return listadoAmigos;
    }

    public Friend insertar(Connection connection){
        Friend amigo = generarRandom();
        String consulta = "insert into amigos(nombre,apellido, telefono, direccion, correo) values(?,?,?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(consulta);
            statement.setString(1, amigo.getNombre());
            statement.setString(2, amigo.getApellido());
            statement.setString(3, amigo.getTelefono());
            statement.setString(4, amigo.getDireccion());
            statement.setString(5, amigo.getCorreo());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException ex) { 
            ex.getMessage();
        }
        return amigo;
    }
   
    public Friend generarRandom(){
        String[] nombresRand = {"Javier", "Manuel", "Rodrigo", "Camilo", "Lucrecia", "Manuela", "Juliana", "Paola", "Pandy", "Fernanda"};
        String[] apellidosRand = {"Lozada", "Gonzalez", "Nunez", "Gil", "Botero", "Perez", "Reyes", "Gomez", "Hernandez", "Pabon"};
        String[] telefonos = {"3102823922", "3102823921", "3102823923", "3102823925", "3102823920", "3102823929", "3102823927", "3102823925", "3102823926", "3102823900"};
        String[] direcciones = {"Calle 2", "calle 1", "calle13", "Calle principal", "calle 98", "calle 67", "calle 79", "Calle 09", "calle 21", "calle 314"};
        String[] correos = {"1@unillanos.edu.co", "2@unillanos.edu.co", "3@unillanos.edu.co", "4@unillanos.edu.co", "5@unillanos.edu.co", "6@unillanos.edu.co", "7@unillanos.edu.co", "8@unillanos.edu.co", "9@unillanos.edu.co", "12@unillanos.edu.co"};
        Friend amigo = new Friend(nombresRand[(int) (Math.random() * 10)], apellidosRand[(int) (Math.random() * 10)], telefonos[(int) (Math.random() * 10)], direcciones[(int) (Math.random() * 10)], correos[(int) (Math.random() * 10)]);

        return amigo;
    }

    public Friend buscarId(Connection connection,Number idAmigo) {
   
        Friend amigoVO = new Friend();
        try {
            String consulta = "select * from amigos where id = " + idAmigo;
            PreparedStatement statement = connection.prepareStatement(consulta);
            ResultSet resultado = statement.executeQuery();
            if (resultado.next()) {
                amigoVO.setId(resultado.getInt(1));
                amigoVO.setNombre(resultado.getString(2));
                amigoVO.setApellido(resultado.getString(3));
                amigoVO.setTelefono(resultado.getString(4));
                amigoVO.setDireccion(resultado.getString(5));
                amigoVO.setCorreo(resultado.getString(6));
            }
            resultado.close();
            statement.close();
        } catch (SQLException e) {
            e.getMessage();
        }
        return amigoVO;
    }

    public Friend actualizar(Connection connection,Friend amigoVO) {
        
        try {
            String consulta = "update amigos set nombre = '" + amigoVO.getNombre() + "', apellido = '" + amigoVO.getApellido()
                    + "', telefono = '" + amigoVO.getTelefono() + "', direccion = '" + amigoVO.getDireccion() + "', correo = '" + amigoVO.getCorreo()
                    + "' where id = " + amigoVO.getId();
            PreparedStatement statement = connection.prepareStatement(consulta);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.getMessage();
        }
        return amigoVO;
    }

    public void eliminar(Connection connection,Number idAmigo) {
        try {
            String consulta = "delete from amigos where id = " + idAmigo;
            PreparedStatement statement = connection.prepareStatement(consulta);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.getMessage();
        }
    }
    
    
}
