package com.project.view.console;

import java.util.Scanner;

public class MainMenu {

    private static OracleMenu oracle;
    private static PostgresqlMenu postgresql;
    private static final Scanner leer = new Scanner(System.in);
    
    public void menuPrincipal(){
        System.out.println("|-----------------------------------------|");
        System.out.println("|--------------MENU PRINCIPAL-------------|");
        System.out.println("|1. ORACLE                                |");
        System.out.println("|2. POSTGRESQL                            |");
        System.out.println("|3. CERRAR                                |");
        System.out.println("|-----------------------------------------|");
        System.out.print("INGRESE LA OPCION: ");
        int opc = leer.nextInt();
        switch (opc) {
            case 1:
                oracle = new OracleMenu();
                oracle.menu();
                break;
            case 2:
                postgresql= new PostgresqlMenu();
                postgresql.menu();
                break;
            case 3:
                System.out.println("|-----------------------------------------|");
                System.out.println("|-----------PROGRAMA FINALIZADO-----------|");
                System.out.println("|-----------------------------------------|");
                break;
            default:
                System.out.println("DIGITE UNA OPCION VALIDA");
                menuPrincipal();
                break;
        }
    }
}
