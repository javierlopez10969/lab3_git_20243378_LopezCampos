package modelo;

import java.util.Scanner;

public interface menu {
    Scanner entradaEscaner = new Scanner (System.in);
	public static void main(String[]args){
		boolean bandera = true;
        while(bandera == true){
            System.out.println("### SIMULACIÓN DE GIT ###\n");
            System.out.println("Escoja su opción:\n");
            System.out.println("1. add\n");
            System.out.println("2. commit\n");
            System.out.println("3. pull\n");
            System.out.println("4. push\n");
            System.out.println("5. status\n");
            System.out.println("6. Crear nuevo archivo\n");
            System.out.println("7. Salir\n");  
            System.out.println("INTRODUZCA SU OPCIÓN: _\n");
            int x;
            x = entradaEscaner.nextInt();
            System.out.println ("Entrada recibida por teclado es: \"" + x +"\"");
            switch(x){
                default:{
                    System.out.println("Ingrese una opción válida\n");
                }
                case 1:{
                    System.out.println("Add\n");
                    break;
                }
                case 2:{
                    System.out.println("Commit\n");
                    break;
                }
                case 3:{
                    System.out.println("Pull\n");
                    break;
                }
                case 4:{
                    System.out.println("Push\n");
                    break;
                }
                case 5:{
                    System.out.println("Status\n");
                    break;
                }
                case 6:{
                    System.out.println("Crear nuevo archivo\n");
                    break;
                }
                case 7:{
                    bandera = false;
                    break;
                }
            }
        }
        entradaEscaner.close();

    }
}
