package com.project.view.console;

import com.project.controller.OracleService;
import com.project.dto.AmigoDTO;
import com.project.dto.InfoStudentDTO;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class OracleMenu {

    private static final Scanner leer = new Scanner(System.in);
    private static final MainMenu start = new MainMenu();

    public void menu() {
        System.out.println("|-----------------------------------------|");
        System.out.println("|---------------MENU ORACLE---------------|");
        System.out.println("|1. CRUD Y TRANSACCIONES                  |");
        System.out.println("|2. FUNCIONES Y PROCEDIMIENTOS            |");
        System.out.println("|3. REGRESAR                              |");
        System.out.println("|4. CERRAR                                |");
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
                //String mensaje = controlador.desconectar();
                //System.out.println(mensaje);
                start.menuPrincipal();
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
                menu();
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
                Number promedio = OracleService.getInstance().promedioCarrera(cod_est);
                System.out.println("EL PROMEDIO DE CARRERA ES: " + promedio);
                menuFunProd();
                break;
            case 2:
                System.out.print("INGRESE EL CODIGO DEL ELEMENTO: ");
                int cod_ele = leer.nextInt();
                Integer precio_promedio = OracleService.getInstance().precioPromedio(cod_ele);
                System.out.println("EL PRECIO PROMEDIO ES: " + precio_promedio);
                menuFunProd();
                break;
            case 3:
                System.out.print("INGRESE EL PRIMER NUMERO: ");
                int numero1 = leer.nextInt();
                System.out.print("INGRESE EL SEGUNDO NUMERO: ");
                int numero2 = leer.nextInt();
                String comparacion = OracleService.getInstance().compararNumeros(numero1, numero2);
                System.out.println(comparacion);
                menuFunProd();
                break;
            case 4:
                System.out.println("INFORMACION ESTUDIANTES: ");
                List<InfoStudentDTO> infoEstudiantesDTO = OracleService.getInstance().informacionEstudiantes();
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
                //String mensaje = OracleService.getInstance().desconectar();
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
                OracleService.getInstance().actualizarAmigo(amigoDTO);
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
                    //String mensaje = OracleService.getInstance().desconectar();
                    //System.out.println(mensaje);
                    System.out.println("|-----------------------------------------|");
                    System.out.println("|-----------PROGRAMA FINALIZADO-----------|");
                    System.out.println("|-----------------------------------------|");
                    break;
                case 1:
                    System.out.println("TABLA AMIGOS: ");
                    List<AmigoDTO> amigos = OracleService.getInstance().listarAmigo();
                    System.out.printf("|%12s|%12s|%12s|%12s|%12s|%12s%n", "ID", "NOMBRE", "APELLIDO", "TELEFONO", "DIRECCION", "CORREO");
                    for (AmigoDTO amigo : amigos) {
                        System.out.printf("|%12s|%12s|%12s|%12s|%12s|%12s|%n", amigo.getId(), amigo.getNombre(), amigo.getApellido(), amigo.getTelefono(), amigo.getDireccion(), amigo.getCorreo());
                    }
                    menuTransaccion();
                    break;

                case 2:
                    System.out.println("NUEVO REGISTRO: ");
                    AmigoDTO amigoDTO = OracleService.getInstance().ingresarAmigo();
                    System.out.printf("|%12s|%12s|%12s|%12s|%12s%n", "NOMBRE", "APELLIDO", "TELEFONO", "DIRECCION", "CORREO");
                    System.out.printf("|%12s|%12s|%12s|%12s|%12s|%n", amigoDTO.getNombre(), amigoDTO.getApellido(), amigoDTO.getTelefono(), amigoDTO.getDireccion(), amigoDTO.getCorreo());
                    menuTransaccion();
                    break;

                case 3:
                    System.out.print("INGRESE EL ID DEL AMIGO A ACTUALIZAR: ");
                    idAmigo = leer.nextInt();
                    amigoDTO = OracleService.getInstance().buscarAmigoId(idAmigo);
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
                    amigoDTO = OracleService.getInstance().buscarAmigoId(idAmigo);
                    if (idAmigo.equals(amigoDTO.getId())) {
                        OracleService.getInstance().eliminarAmigo(idAmigo);
                        System.out.println("AMIGO ELIMINADO: ");
                        System.out.println(amigoDTO.toString());
                        menuTransaccion();
                    } else {
                        System.out.println("NO HAY UN AMIGO CON ESE ID");
                        menuTransaccion();
                    }
                    break;

                case 5:
                    String mensaje = OracleService.getInstance().savePointAmigos();
                    System.out.println(mensaje);
                    menuTransaccion();
                    break;

                case 6:
                    mensaje = OracleService.getInstance().volverSaveAmigos();
                    System.out.println(mensaje);
                    menuTransaccion();
                    break;

                case 7:
                    mensaje = OracleService.getInstance().rollbackAmigos();
                    System.out.println(mensaje);
                    menuTransaccion();
                    break;

                case 8:
                    mensaje = OracleService.getInstance().commitAmigos();
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
