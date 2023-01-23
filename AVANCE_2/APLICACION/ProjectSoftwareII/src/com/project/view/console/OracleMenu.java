package com.project.view.console;

import com.project.controller.OracleService;
import com.project.model.friend.Friend;
import com.project.model.student.InfoStudentDTO;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class OracleMenu {

    private final OracleService controlador = new OracleService();
    private static final Scanner leer = new Scanner(System.in);
    private static final MainMenu start = new MainMenu();
    
    public void menu(){
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
                String mensaje = controlador.desconectar();
                System.out.println(mensaje);
                start.menuPrincipal();
                break;
            case 4:
                mensaje = controlador.desconectar();
                System.out.println(mensaje);
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
    
    public void menuFunProd(){
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
                Number promedio = controlador.promedioCarrera(cod_est);
                System.out.println("EL PROMEDIO DE CARRERA ES: "+promedio);
                menuFunProd();
                break;
            case 2:
                System.out.print("INGRESE EL CODIGO DEL ELEMENTO: ");
                int cod_ele = leer.nextInt();
                Integer precio_promedio = controlador.precioPromedio(cod_ele);
                System.out.println("EL PRECIO PROMEDIO ES: "+precio_promedio);
                menuFunProd();
                break;
            case 3:
                System.out.print("INGRESE EL PRIMER NUMERO: ");
                int numero1 = leer.nextInt();
                System.out.print("INGRESE EL SEGUNDO NUMERO: ");
                int numero2 = leer.nextInt();
                String comparacion = controlador.compararNumeros(numero1,numero2);
                System.out.println(comparacion);
                menuFunProd();
                break;
            case 4:
                System.out.println("INFORMACION ESTUDIANTES: ");
                List<InfoStudentDTO> infoEstudiantes = controlador.informacionEstudiantes();
                System.out.printf("|%12s|%22s|%36s|%22s|%12s|%12s|%12s|%12s%n", "CODIGO", "FACULTAD", "PROGRAMA", "ESTUDIANTE", "PROMEDIO", "MATRICULADO","ANO","PERIODO");
                for (InfoStudentDTO infoEstudiante : infoEstudiantes) {
                    System.out.printf("|%12s|%22s|%36s|%22s|%12s|%12s|%12s|%12s|%n", infoEstudiante.getCodigo(),infoEstudiante.getFacultad() , infoEstudiante.getPrograma(),infoEstudiante.getEstudiante(),infoEstudiante.getPromedio(),infoEstudiante.getMatriculado(),infoEstudiante.getAno(),infoEstudiante.getPeriodo());
                }
                menuFunProd();
                break;
            case 5:
                menu();
                break;
            case 6:
                String mensaje = controlador.desconectar();
                System.out.println(mensaje);
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
    public void menuActualizarAmigo(Friend amigoVO){
        
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
                amigoVO.setNombre(nombre);
                menuActualizarAmigo(amigoVO);
                break;

            case 2:
                System.out.print("INGRESE EL NUEVO APELLIDO: ");
                String apellido = leer.next();
                amigoVO.setApellido(apellido);
                menuActualizarAmigo(amigoVO);
                break;

            case 3:
                System.out.print("INGRESE EL NUEVO TELEFONO: ");
                String telefono = leer.next();
                amigoVO.setTelefono(telefono);
                menuActualizarAmigo(amigoVO);
                break;

            case 4:
                System.out.print("INGRESE LA NUEVA DIRECCION: ");
                String direccion = leer.next();
                amigoVO.setDireccion(direccion);
                menuActualizarAmigo(amigoVO);
                break;

            case 5:
                System.out.print("INGRESE EL NUEVO CORREO: ");
                String correo = leer.next();
                amigoVO.setCorreo(correo);
                menuActualizarAmigo(amigoVO);
                break;

            case 6:
                System.out.println("DATOS ACTUALIZADOS: ");
                controlador.actualizarAmigo(amigoVO);
                System.out.println(amigoVO.toString());
                menuTransaccion();
                break;

            case 7:
                System.out.println("OPERACION CANCELADA");
                menuTransaccion();
        }
    }

    public void menuTransaccion(){
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
                    String mensaje = controlador.desconectar();
                    System.out.println(mensaje);
                    System.out.println("|-----------------------------------------|");
                    System.out.println("|-----------PROGRAMA FINALIZADO-----------|");
                    System.out.println("|-----------------------------------------|");
                    break;
                case 1:
                    System.out.println("TABLA AMIGOS: ");
                    List<Friend> amigos = controlador.listarAmigo();
                    System.out.printf("|%12s|%12s|%12s|%12s|%12s|%12s%n", "ID", "NOMBRE", "APELLIDO", "TELEFONO", "DIRECCION", "CORREO");
                    for (Friend amigo : amigos) {
                        System.out.printf("|%12s|%12s|%12s|%12s|%12s|%12s|%n", amigo.getId(), amigo.getNombre(), amigo.getApellido(), amigo.getTelefono(), amigo.getDireccion(), amigo.getCorreo());
                    }
                    menuTransaccion();
                    break;

                case 2:
                    System.out.println("NUEVO REGISTRO: ");
                    Friend amigo = controlador.ingresarAmigo();
                    System.out.printf("|%12s|%12s|%12s|%12s|%12s%n", "NOMBRE", "APELLIDO", "TELEFONO", "DIRECCION", "CORREO");
                    System.out.printf("|%12s|%12s|%12s|%12s|%12s|%n", amigo.getNombre(), amigo.getApellido(), amigo.getTelefono(), amigo.getDireccion(), amigo.getCorreo());
                    menuTransaccion();
                    break;

                case 3:
                    System.out.print("INGRESE EL ID DEL AMIGO A ACTUALIZAR: ");
                    idAmigo = leer.nextInt();
                    amigo = controlador.buscarAmigoId(idAmigo);
                    if (idAmigo.equals(amigo.getId())) {
                        System.out.println(amigo.toString());
                        menuActualizarAmigo(amigo);
                    } else {
                        System.out.println("NO HAY UN AMIGO CON ESE ID");
                        menuTransaccion();
                    }
                    break;
                    
                case 4:
                    System.out.print("INGRESE EL ID DEL AMIGO A ELIMINAR: ");
                    idAmigo = leer.nextInt();
                    amigo = controlador.buscarAmigoId(idAmigo);
                    if (idAmigo.equals(amigo.getId())) {
                        controlador.eliminarAmigo(idAmigo);
                        System.out.println("AMIGO ELIMINADO: ");
                        System.out.println(amigo.toString());
                        menuTransaccion();
                    } else {
                        System.out.println("NO HAY UN AMIGO CON ESE ID");
                        menuTransaccion();
                    }
                    break;

                case 5:
                    mensaje = controlador.savePoint();
                    System.out.println(mensaje);
                    menuTransaccion();
                    break; 
                    
                case 6:
                    mensaje = controlador.volverSavePoint();
                    System.out.println(mensaje);
                    menuTransaccion();
                    break;
                
                    
                case 7:
                    mensaje = controlador.rollback();
                    System.out.println(mensaje);
                    menuTransaccion();
                    break;    
                    
                case 8:
                    mensaje = controlador.commit();
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
