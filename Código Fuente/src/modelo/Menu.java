package modelo;

import java.util.Scanner;

public interface Menu {
	//Declaramos el repositorio
    public static MiRepositorio repositorio = new MiRepositorio();
	public static void main(String[]args){
		Scanner entradaEscaner = new Scanner (System.in);
		int x = -1;
		System.out.println("Bienvenido a la simulacion de git\n"
		+"Para inicializar su repositorio, ingrese su nombre de usuario");
		String autor = entradaEscaner.nextLine();
		System.out.println("Ahora ingrese el nombre de su repositorio");
		String nombreRepositorio = entradaEscaner.nextLine();
		repositorio.gitInit(autor, nombreRepositorio);
        while(x != 12){
        	try{
        	entradaEscaner = new Scanner (System.in);
            System.out.println("### SIMULACIÓN DE GIT ###\n"
            +  "Autor : " + repositorio.getAutor()
            + "\nNombre Repositorio : "+ repositorio.getNombreRepositorio()
            + "\nFecha de creación: " + repositorio.getFechaDeCreacion()
            + "\nEscoja su opción:\n"
            + "1. add\n"
            + "2. commit\n"
            + "3. pull\n"
            + "4. push\n"
            + "5. status\n"
            + "6. Crear nuevo archivo\n"
            + "7. Ver Workspace\n"
            + "8. Editar Archivo\n"
            + "9. log\n"
            + "12. Salir\n"  
            +"INTRODUZCA SU OPCIÓN:"
            + " _\n");
            x = entradaEscaner.nextInt();
            System.out.println ("Entrada recibida por teclado es: \"" + x +"\"");
            limpiarPantalla();
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
                    repositorio.crearArchivo();
                    break;
                }
                case 12:{
                    System.out.println("Adiós\n");
                    break;
                }                
            }
        	}catch (Exception s) {
        		System.out.println("INTRODUZCA SU OPCIÓN:");
			}
        }
     
        entradaEscaner.close();

    }
	public static void limpiarPantalla() {   
		System.out.print("\033[H\033[2J");
		System.out.flush();  
	   } 
}
