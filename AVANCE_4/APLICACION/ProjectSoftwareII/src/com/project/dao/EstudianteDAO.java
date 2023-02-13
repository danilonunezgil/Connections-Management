package com.project.dao;

import com.project.database.ConexionOracle;
import com.project.database.ConexionPostgresql;
import com.project.dto.EstudianteDTO;
import com.project.dto.InfoStudentDTO;
import com.project.model.Estudiante;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * Clase EstudianteDAO encargada de comunicarse con la base de datos
 *
 * @author Edgar,Danilo y Johan
 */
public class EstudianteDAO {

    private static EstudianteDAO estudianteDAO;

    /**
     * Constructor privado de EstudianteDAO
     *
     * @author Edgar,Danilo y Johan
     */
    private EstudianteDAO() {
    }

    /**
     * Este método se encarga de crear e instanciar un unico objeto
     * EstudianteDAO
     *
     * @author Edgar,Danilo y Johan
     * @return Objeto de tipo EstudianteDAO
     */
    public static EstudianteDAO getInstance() {
        if (estudianteDAO == null) {
            estudianteDAO = new EstudianteDAO();
        }
        return estudianteDAO;
    }

    //SECCION POSTGRESQL
    /**
     * Método encargado de consultar el promedio de carrera de un estudiante de
     * en postgresql
     *
     * @author Edgar,Danilo y Johan
     * @param cod_est Integer con el indentificador del estudiante a consultar
     * @return Niumber con el valor del promedio de carrera del estudiante
     * consultado
     */
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

    /**
     * Método encargado de consultar la comparacion de dos numeros enteros en
     * postgresql
     *
     * @author Edgar,Danilo y Johan
     * @param num1 Integer con el valor del primer numero a comparar
     * @param num2 Integer con el valor del segundo numero a comparar
     * @return String con la comparacion realizada
     */
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

    /**
     * Método encargado de consultar la informacion de los estudiantes
     * almacenados en postgresql
     *
     * @author Edgar,Danilo y Johan
     * @return Lista con objetos de tipo InfoStudentDTO
     */
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

    /**
     * Método encargado de buscar un estudiante en postgresql
     *
     * @author Edgar,Danilo y Johan
     * @param idEstudiante Number con el identificador del estudiante que se
     * quiere buscar
     * @return Objeto de tipo Estudiante con toda la informacion del mismo
     */
    public Estudiante buscarIdEstudiantePostgres(Number idEstudiante) {
        Estudiante estudiante = new Estudiante();
        Connection connection = ConexionPostgresql.getInstance().conexion();
        try {
            String consulta = "select * from estudiante where codigo = " + idEstudiante;
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
                byte[] blob = resultado.getBytes(9);
                if (blob != null) {
                    estudiante.setFoto(blob);
                } else {
                    estudiante.setFoto(null);
                }
            }
            resultado.close();
            statement.close();
        } catch (SQLException e) {
            e.getMessage();
        }
        return estudiante;
    }

    //SECCION ORACLE
    /**
     * Método encargado de consultar el promedio de carrera de un estudiante de
     * en oracle
     *
     * @author Edgar,Danilo y Johan
     * @param cod_est Integer con el indentificador del estudiante a consultar
     * @return Niumber con el valor del promedio de carrera del estudiante
     * consultado
     */
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

    /**
     * Método encargado de consultar la comparacion de dos numeros enteros en
     * oracle
     *
     * @author Edgar,Danilo y Johan
     * @param num1 Integer con el valor del primer numero a comparar
     * @param num2 Integer con el valor del segundo numero a comparar
     * @return String con la comparacion realizada
     */
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

    /**
     * Método encargado de consultar la informacion de los estudiantes
     * almacenados en oracle
     *
     * @author Edgar,Danilo y Johan
     * @return Lista con objetos de tipo InfoStudentDTO
     */
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

    /**
     * Método encargado de buscar un estudiante en oracle
     *
     * @author Edgar,Danilo y Johan
     * @param idEstudiante Number con el identificador del estudiante que se
     * quiere buscar
     * @return Objeto de tipo Estudiante con toda la informacion del mismo
     */
    public Estudiante buscarIdEstudianteOracle(Number idEstudiante) {
        Estudiante estudiante = new Estudiante();
        Connection connection = ConexionOracle.getInstance().conexion();
        try {
            String consulta = "select * from estudiante where codigo = " + idEstudiante;
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
                if (blob != null) {
                    estudiante.setFoto(blob.getBytes(1, (int) blob.length()));
                } else {
                    estudiante.setFoto(null);
                }
            }
            resultado.close();
            statement.close();
        } catch (SQLException e) {
            e.getMessage();
        }
        return estudiante;
    }

    /**
    * Método encargado de guardar la foto de un estudiante en oracle
    * @author Edgar,Danilo y Johan
    * @param estudiante Number con el identificador del estudiante al que se
    * quiere cambiar la foto
    * @return byte[] arreglo de bytes con la informacion de la foto guardada
    */
    public byte[] guardarFotoBaseOracle(Estudiante estudiante) {
        byte[] img = null;
        InputStream imagen = new ByteArrayInputStream(estudiante.getFoto());
        Connection connection = ConexionOracle.getInstance().conexion();
        try {
            String consulta = "update estudiante set foto = ? where codigo = ?";
            PreparedStatement statement = connection.prepareStatement(consulta);
            statement.setBinaryStream(1, imagen);
            statement.setInt(2, estudiante.getCodigo());
            statement.executeUpdate();
            statement.close();
            connection.commit();
            img = estudiante.getFoto();
            System.out.println(connection);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return img;
    }
    
    /**
    * Método encargado de guardar la foto de un estudiante en la carpeta de oracle
    * @author Edgar,Danilo y Johan
    * @param estudiante Number con el identificador del estudiante al que se
    * quiere cambiar la foto
    * @return byte[] arreglo de bytes con la informacion de la foto guardada
    */
    public byte[] guardarFotoCarpetaOracle(Estudiante estudiante) {
        String ruta = "C:\\ProjectSoftware\\Fotos\\Estudiantes\\Oracle";
        int newW = 210;
        int newH = 210;
        byte[] img = null;
        try {
            File directorio = new File(ruta);
            if (!directorio.exists()) {
                if (directorio.mkdirs()) {
                    System.out.println("DIRECTORIO CREADO");
                } else {
                    System.out.println("ERROR AL CREAR DIRECTORIO");
                }
            }
            String tituloFoto = estudiante.getNombres() + estudiante.getApellido1() + estudiante.getCodigo();
            InputStream in = new ByteArrayInputStream(estudiante.getFoto());
            BufferedImage image = ImageIO.read(in);
            int w = image.getWidth();
            int h = image.getHeight();
            BufferedImage foto = new BufferedImage(newW, newH, image.getType());
            Graphics2D g = foto.createGraphics();
            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g.drawImage(image, 0, 0, newW, newH, 0, 0, w, h, null);
            g.dispose();
            ImageIO.write(foto, "jpg", new File(ruta + "\\" + tituloFoto + ".jpg"));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(foto, "jpg", baos);
            img = baos.toByteArray();
            System.out.println("FOTO ALMACENADA");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return img;
    }

    /**
    * Método encargado de guardar la foto de un estudiante en postgresql
    * @author Edgar,Danilo y Johan
    * @param estudiante Number con el identificador del estudiante al que se
    * quiere cambiar la foto
    * @return byte[] arreglo de bytes con la informacion de la foto guardada
    */
    public byte[] guardarFotoBasePostgres(Estudiante estudiante) {
        byte[] img = null;
        InputStream imagen = new ByteArrayInputStream(estudiante.getFoto());
        Connection connection = ConexionPostgresql.getInstance().conexion();
        try {
            String consulta = "update estudiante set foto = ? where codigo = ?";
            PreparedStatement statement = connection.prepareStatement(consulta);
            statement.setBinaryStream(1, imagen);
            statement.setInt(2, estudiante.getCodigo());
            statement.executeUpdate();
            statement.close();
            connection.commit();
            img = estudiante.getFoto();
            System.out.println(connection);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return img;
    }
    
    /**
    * Método encargado de guardar la foto de un estudiante en la carpeta de postgres
    * @author Edgar,Danilo y Johan
    * @param estudiante Number con el identificador del estudiante al que se
    * quiere cambiar la foto
    * @return byte[] arreglo de bytes con la informacion de la foto guardada
    */
    public byte[] guardarFotoCarpetaPostgres(Estudiante estudiante) {
        String ruta = "C:\\ProjectSoftware\\Fotos\\Estudiantes\\Postgres";
        int newW = 210;
        int newH = 210;
        byte[] img = null;
        try {
            File directorio = new File(ruta);
            if (!directorio.exists()) {
                if (directorio.mkdirs()) {
                    System.out.println("DIRECTORIO CREADO");
                } else {
                    System.out.println("ERROR AL CREAR DIRECTORIO");
                }
            }
            String tituloFoto = estudiante.getNombres() + estudiante.getApellido1() + estudiante.getCodigo();
            InputStream in = new ByteArrayInputStream(estudiante.getFoto());
            BufferedImage image = ImageIO.read(in);
            int w = image.getWidth();
            int h = image.getHeight();
            BufferedImage foto = new BufferedImage(newW, newH, image.getType());
            Graphics2D g = foto.createGraphics();
            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g.drawImage(image, 0, 0, newW, newH, 0, 0, w, h, null);
            g.dispose();
            ImageIO.write(foto, "jpg", new File(ruta + "\\" + tituloFoto + ".jpg"));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(foto, "jpg", baos);
            img = baos.toByteArray();
            System.out.println("FOTO ALMACENADA");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return img;
    }
}
