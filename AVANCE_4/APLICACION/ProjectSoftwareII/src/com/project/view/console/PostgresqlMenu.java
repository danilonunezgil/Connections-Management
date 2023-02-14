package com.project.view.console;

import com.project.controller.OracleService;
import com.project.controller.PostgresqlService;
import com.project.dto.AmigoDTO;
import com.project.dto.EstudianteDTO;
import com.project.dto.InfoStudentDTO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class PostgresqlMenu {

    private static final Scanner leer = new Scanner(System.in);
    private static final MainMenu start = new MainMenu();

    public void menu() {
        System.out.println("|-----------------------------------------|");
        System.out.println("|-------------MENU POSTGRESQL-------------|");
        System.out.println("|1. CRUD Y TRANSACCIONES                  |");
        System.out.println("|2. FUNCIONES Y PROCEDIMIENTOS            |");
        System.out.println("|3. GESTION DE ESTUDIANTES                |");
        System.out.println("|4. REGRESAR                              |");
        System.out.println("|5. CERRAR                                |");
        System.out.println("|-----------------------------------------|");
        System.out.print("INGRESE LA OPCION: ");
        int opc = leer.nextInt();
        switch (opc) {
            case 1:
                menuTransaccion();
                break;
            case 2:
                menuFunProd();
                break;
            case 3:
                menuGestionEstu();
                break;
            case 4:
                //String mensaje = controlador.desconectar();
                //System.out.println(mensaje);
                start.menuPrincipal();
                break;
            case 5:
                //String mensaje = PostgresqlService.getInstance().desconectar();
                //System.out.println(mensaje);
                System.out.println("|-----------------------------------------|");
                System.out.println("|-----------PROGRAMA FINALIZADO-----------|");
                System.out.println("|-----------------------------------------|");
                break;
            default:
                System.out.println("DIGITE UNA OPCION VALIDA");
                menu();
                break;
        }
    }

    public void menuFoto(EstudianteDTO estudianteDTO) {
        System.out.println("|-----------------------------------------|");
        System.out.println("|---------------MENU DE FOTO--------------|");
        System.out.println("|1. VER FOTO                              |");
        System.out.println("|2. CAMBIAR FOTO                          |");
        System.out.println("|3. REGRESAR                              |");
        System.out.println("|4. CERRAR                                |");
        System.out.println("|-----------------------------------------|");
        System.out.print("INGRESE LA OPCION: ");
        int opc = leer.nextInt();
        switch (opc) {
            case 1:
                if (estudianteDTO.getFoto() != null) {
                    BufferedImage img = null;
                    try {
                        img = ImageIO.read(new ByteArrayInputStream(estudianteDTO.getFoto()));
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    ImageIcon icono = new ImageIcon(img);
                    System.out.println("VISUALIZANDO FOTO");
                    JOptionPane.showMessageDialog(null, null, "FOTO", JOptionPane.INFORMATION_MESSAGE, icono);
                    menuFoto(estudianteDTO);
                } else {
                    System.out.println("EL ESTUDIANTE NO TIENE FOTO");
                    menuFoto(estudianteDTO);
                }
                break;
            case 2:
                System.out.println("SELECCIONE LA IMAGEN");
                String ruta = null;
                JFileChooser j = new JFileChooser();
                int ap = j.showOpenDialog(j);
                if (ap == JFileChooser.APPROVE_OPTION) {
                    ruta = j.getSelectedFile().getAbsolutePath();
                    File archivo = new File(ruta);
                    estudianteDTO.setFoto(new byte[(int) archivo.length()]);
                    try {
                        InputStream inte = new FileInputStream(archivo);
                        inte.read(estudianteDTO.getFoto());
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    estudianteDTO.setFoto(PostgresqlService.getInstance().guardarFotoCarpetaPostgres(estudianteDTO));
                    estudianteDTO.setFoto(PostgresqlService.getInstance().guardarFotoBasePostgres(estudianteDTO));
                    menuFoto(estudianteDTO);
                } else {
                    System.out.println("OPERACION CANCELADA");
                    menuFoto(estudianteDTO);
                }
                break;
            case 3:
                menuGestionEstu();
                break;
            case 4:
                //String mensaje = OracleService.getInstance().desconectar();
                //System.out.println(mensaje);
                System.out.println("|-----------------------------------------|");
                System.out.println("|-----------PROGRAMA FINALIZADO-----------|");
                System.out.println("|-----------------------------------------|");
                break;
            default:
                System.out.println("DIGITE UNA OPCION VALIDA");
                menuFoto(estudianteDTO);
                break;
        }
    }

    public void menuGestionEstu() {
        System.out.println("|-----------------------------------------|");
        System.out.println("|---------GESTION DE ESTUDIANTES----------|");
        System.out.println("|1. CONSULTAR ESTUDIANTE                  |");
        System.out.println("|2. REGRESAR                              |");
        System.out.println("|3. CERRAR                                |");
        System.out.println("|-----------------------------------------|");
        System.out.print("INGRESE LA OPCION: ");
        int opc = leer.nextInt();
        switch (opc) {
            case 1:
                System.out.print("INGRESE EL CODIGO DEL ESTUDIANTE: ");
                int cod_est = leer.nextInt();
                EstudianteDTO estudianteDTO = PostgresqlService.getInstance().buscarIdEstudiantePostgres(cod_est);
                Number codigo = cod_est;
                if (codigo.equals(estudianteDTO.getCodigo())) {
                    System.out.println(estudianteDTO.toString());
                    System.out.println("|-----------------------------------------|");
                    System.out.println("|---------INFORMACION ESTUDIANTE----------|");
                    System.out.println("NOMBRES: " + estudianteDTO.getNombres());
                    System.out.println("PRIMER APELLIDO: " + estudianteDTO.getApellido1());
                    System.out.println("SEGUNDO APELLIDO: " + estudianteDTO.getApellido2());
                    System.out.println("TELEFONO: " + estudianteDTO.getTelefono());
                    System.out.println("FALCUTAD: " + estudianteDTO.getFacultad());
                    System.out.println("PROGRAMA: " + estudianteDTO.getPrograma());
                    System.out.println("FECHA INICIO: " + estudianteDTO.getFecha_inicio());
                    System.out.println("FOTO: " + estudianteDTO.getFoto());
                    menuFoto(estudianteDTO);
                } else {
                    System.out.println("NO HAY UN AMIGO CON ESE ID");
                    menuGestionEstu();
                }
                break;
            case 2:
                menu();
                break;
            case 3:
                //String mensaje = OracleService.getInstance().desconectar();
                //System.out.println(mensaje);
                System.out.println("|-----------------------------------------|");
                System.out.println("|-----------PROGRAMA FINALIZADO-----------|");
                System.out.println("|-----------------------------------------|");
                break;
            default:
                System.out.println("DIGITE UNA OPCION VALIDA");
                menuGestionEstu();
                break;
        }
    }

    public void menuFunProd() {
        System.out.println("|-----------------------------------------|");
        System.out.println("|-------FUNCIONES Y PROCEDIMIENTOS--------|");
        System.out.println("|1. PROMEDIO CARRERA                      |");
        System.out.println("|2. PRECIO PROMEDIO                       |");
        System.out.println("|3. COMPARAR NUMEROS                      |");
        System.out.println("|4. INFORMACION ESTUDIANTES               |");
        System.out.println("|5. REGRESAR                              |");
        System.out.println("|6. CERRAR                                |");
        System.out.println("|-----------------------------------------|");
        System.out.print("INGRESE LA OPCION: ");
        int opc = leer.nextInt();
        switch (opc) {
            case 1:
                System.out.print("INGRESE EL CODIGO DEL ESTUDIANTE: ");
                int cod_est = leer.nextInt();
                Number promedio = PostgresqlService.getInstance().promedioCarrera(cod_est);
                System.out.println("EL PROMEDIO DE CARRERA ES: " + promedio);
                menuFunProd();
                break;
            case 2:
                System.out.print("INGRESE EL CODIGO DEL ELEMENTO: ");
                int cod_ele = leer.nextInt();
                Integer precio_promedio = PostgresqlService.getInstance().precioPromedio(cod_ele);
                System.out.println("EL PRECIO PROMEDIO ES: " + precio_promedio);
                menuFunProd();
                break;
            case 3:
                System.out.print("INGRESE EL PRIMER NUMERO: ");
                int numero1 = leer.nextInt();
                System.out.print("INGRESE EL SEGUNDO NUMERO: ");
                int numero2 = leer.nextInt();
                String comparacion = PostgresqlService.getInstance().compararNumeros(numero1, numero2);
                System.out.println(comparacion);
                menuFunProd();
                break;
            case 4:
                System.out.println("INFORMACION ESTUDIANTES: ");
                List<InfoStudentDTO> infoEstudiantesDTO = PostgresqlService.getInstance().informacionEstudiantes();
                System.out.printf("|%12s|%22s|%36s|%22s|%12s|%12s|%12s|%12s%n", "CODIGO", "FACULTAD", "PROGRAMA", "ESTUDIANTE", "PROMEDIO", "MATRICULADO", "ANO", "PERIODO");
                for (InfoStudentDTO infoEstudianteDTO : infoEstudiantesDTO) {
                    System.out.printf("|%12s|%22s|%36s|%22s|%12s|%12s|%12s|%12s|%n", infoEstudianteDTO.getCodigo(), infoEstudianteDTO.getFacultad(), infoEstudianteDTO.getPrograma(), infoEstudianteDTO.getEstudiante(), infoEstudianteDTO.getPromedio(), infoEstudianteDTO.getMatriculado(), infoEstudianteDTO.getAno(), infoEstudianteDTO.getPeriodo());
                }
                menuFunProd();
                break;

            case 5:
                menu();
                break;
            case 6:
                //String mensaje = PostgresqlService.getInstance().desconectar();
                //System.out.println(mensaje);
                System.out.println("|-----------------------------------------|");
                System.out.println("|-----------PROGRAMA FINALIZADO-----------|");
                System.out.println("|-----------------------------------------|");
                break;
            default:
                System.out.println("DIGITE UNA OPCION VALIDA");
                menu();
                break;
        }
    }

    public void menuActualizarAmigo(AmigoDTO amigoDTO) {

        System.out.println("|-----------------------------------------|");
        System.out.println("|----------MENU ACTUALIZAR AMIGO----------|");
        System.out.println("|1. NOMBRE                                |");
        System.out.println("|2. APELLIDO                              |");
        System.out.println("|3. TELEFONO                              |");
        System.out.println("|4. DIRECCION                             |");
        System.out.println("|5. CORREO                                |");
        System.out.println("|6. GUARDAR                               |");
        System.out.println("|7. CANCELAR                              |");
        System.out.println("|-----------------------------------------|");
        System.out.print("INGRESE LA OPCION: ");
        int opc = leer.nextInt();
        switch (opc) {
            case 1:
                System.out.print("INGRESE EL NUEVO NOMBRE: ");
                String nombre = leer.next();
                amigoDTO.setNombre(nombre);
                menuActualizarAmigo(amigoDTO);
                break;

            case 2:
                System.out.print("INGRESE EL NUEVO APELLIDO: ");
                String apellido = leer.next();
                amigoDTO.setApellido(apellido);
                menuActualizarAmigo(amigoDTO);
                break;

            case 3:
                System.out.print("INGRESE EL NUEVO TELEFONO: ");
                String telefono = leer.next();
                amigoDTO.setTelefono(telefono);
                menuActualizarAmigo(amigoDTO);
                break;

            case 4:
                System.out.print("INGRESE LA NUEVA DIRECCION: ");
                String direccion = leer.next();
                amigoDTO.setDireccion(direccion);
                menuActualizarAmigo(amigoDTO);
                break;

            case 5:
                System.out.print("INGRESE EL NUEVO CORREO: ");
                String correo = leer.next();
                amigoDTO.setCorreo(correo);
                menuActualizarAmigo(amigoDTO);
                break;

            case 6:
                System.out.println("DATOS ACTUALIZADOS: ");
                PostgresqlService.getInstance().actualizarAmigo(amigoDTO);
                System.out.println(amigoDTO.toString());
                menuTransaccion();
                break;

            case 7:
                System.out.println("OPERACION CANCELADA");
                menuTransaccion();
        }
    }

    public void menuTransaccion() {
        Number idAmigo;
        System.out.println("|-----------------------------------------|");
        System.out.println("|--------SISTEMA GESTION DE DATOS---------|");
        System.out.println("|1. MOSTRAR AMIGOS                        |");
        System.out.println("|2. INSERTAR AMIGO ALEATORIO              |");
        System.out.println("|3. ACTUALIZAR DATOS AMIGO                |");
        System.out.println("|4. ELIMINAR AMIGO                        |");
        System.out.println("|5. CREAR SAVE POINT                      |");
        System.out.println("|6. CARGAR SAVE POINT                     |");
        System.out.println("|7. ROLLBACK                              |");
        System.out.println("|8. COMMIT                                |");
        System.out.println("|9. REGRESAR                              |");
        System.out.println("|0. SALIR                                 |");
        System.out.println("|-----------------------------------------|");
        try {
            System.out.print("INGRESE LA OPCION (entre 0 y 9): ");
            int opc = leer.nextInt();
            switch (opc) {
                case 0:
                    //String mensaje = PostgresqlService.getInstance().desconectar();
                    //System.out.println(mensaje);
                    System.out.println("|-----------------------------------------|");
                    System.out.println("|-----------PROGRAMA FINALIZADO-----------|");
                    System.out.println("|-----------------------------------------|");
                    break;
                case 1:
                    System.out.println("TABLA AMIGOS: ");
                    List<AmigoDTO> amigosDTO = PostgresqlService.getInstance().listarAmigo();
                    System.out.printf("|%12s|%12s|%12s|%12s|%12s|%12s%n", "ID", "NOMBRE", "APELLIDO", "TELEFONO", "DIRECCION", "CORREO");
                    for (AmigoDTO amigoDTO : amigosDTO) {
                        System.out.printf("|%12s|%12s|%12s|%12s|%12s|%12s|%n", amigoDTO.getId(), amigoDTO.getNombre(), amigoDTO.getApellido(), amigoDTO.getTelefono(), amigoDTO.getDireccion(), amigoDTO.getCorreo());
                    }
                    menuTransaccion();
                    break;

                case 2:
                    System.out.println("NUEVO REGISTRO: ");
                    AmigoDTO amigoDTO = PostgresqlService.getInstance().ingresarAmigo();
                    System.out.printf("|%12s|%12s|%12s|%12s|%12s%n", "NOMBRE", "APELLIDO", "TELEFONO", "DIRECCION", "CORREO");
                    System.out.printf("|%12s|%12s|%12s|%12s|%12s|%n", amigoDTO.getNombre(), amigoDTO.getApellido(), amigoDTO.getTelefono(), amigoDTO.getDireccion(), amigoDTO.getCorreo());
                    menuTransaccion();
                    break;

                case 3:
                    System.out.print("INGRESE EL ID DEL AMIGO A ACTUALIZAR: ");
                    idAmigo = leer.nextInt();
                    amigoDTO = PostgresqlService.getInstance().buscarAmigoId(idAmigo);
                    if (idAmigo.equals(amigoDTO.getId())) {
                        System.out.println(amigoDTO.toString());
                        menuActualizarAmigo(amigoDTO);
                    } else {
                        System.out.println("NO HAY UN AMIGO CON ESE ID");
                        menuTransaccion();
                    }
                    break;

                case 4:
                    System.out.print("INGRESE EL ID DEL AMIGO A ELIMINAR: ");
                    idAmigo = leer.nextInt();
                    amigoDTO = PostgresqlService.getInstance().buscarAmigoId(idAmigo);
                    if (idAmigo.equals(amigoDTO.getId())) {
                        PostgresqlService.getInstance().eliminarAmigo(idAmigo);
                        System.out.println("AMIGO ELIMINADO: ");
                        System.out.println(amigoDTO.toString());
                        menuTransaccion();
                    } else {
                        System.out.println("NO HAY UN AMIGO CON ESE ID");
                        menuTransaccion();
                    }
                    break;

                case 5:
                    String mensaje = PostgresqlService.getInstance().savePointAmigos();
                    System.out.println(mensaje);
                    menuTransaccion();
                    break;

                case 6:
                    mensaje = PostgresqlService.getInstance().volverSaveAmigos();
                    System.out.println(mensaje);
                    menuTransaccion();
                    break;

                case 7:
                    mensaje = PostgresqlService.getInstance().rollbackAmigos();
                    System.out.println(mensaje);
                    menuTransaccion();
                    break;

                case 8:
                    mensaje = PostgresqlService.getInstance().commitAmigos();
                    System.out.println(mensaje);
                    menuTransaccion();
                    break;
                case 9:
                    menu();
                    break;
                default:
                    System.out.println("LA OPCION NO ESTA EN EL RANGO");
                    menuTransaccion();
                    break;
            }
        } catch (InputMismatchException e) {
            e.getMessage();
            System.out.println("DEBE INGRESER COMO OPCION UN NUMERO ENTERO");
        }
    }
}
