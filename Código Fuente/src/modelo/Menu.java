package modelo;

import java.io.IOException;
import java.util.Scanner;


public interface Menu {
	//Declaramos el repositorio
    public static Repositorio repositorio = new MiRepositorio();
	public static void main(String[]args){
		Scanner entradaEscaner = new Scanner (System.in);
		int x = -1;
		System.out.println("Bienvenido a la simulacion de git\n");/*
		+"Para inicializar su repositorio, ingrese su nombre de usuario");
		String autor = entradaEscaner.nextLine();
		System.out.println("Ahora ingrese el nombre de su repositorio");
		String nombreRepositorio = entradaEscaner.nextLine();*/
		String autor = "Mohamed";String nombreRepositorio = "Ali";
		repositorio.gitInit(autor, nombreRepositorio);
        while(x != 12){
        	try{
        	entradaEscaner = new Scanner (System.in);
    		Thread.sleep(1500);
    		limpiarPantalla();
            System.out.println("### SIMULACIÓN DE GIT ###\n"
            //+  "Autor : " + repositorio.getAutor()
            //+ "\nNombre Repositorio : "+ repositorio.getNombreRepositorio()
            //+ "\nFecha de creación: " + repositorio.getFechaDeCreacion()
            + "\nEscoja su opción:\n"
            + "1.  add\n"
            + "2.  commit\n"
            + "3.  pull\n"
            + "4.  push\n"
            + "5.  status\n"
            + "6.  Crear nuevo archivo\n"
            + "7.  Ver Workspace\n"
            + "8.  Editar Archivo\n"
            + "9.  Borrar Archivo\n"
            + "10. Ver Archivos en el index\n"
            + "11. log\n"
            + "12. Salir\n"  
            +"INTRODUZCA SU OPCIÓN:"
            + " _\n");
            x = entradaEscaner.nextInt();
            //System.out.println ("Entrada recibida por teclado es: \"" + x +"\n");
            switch(x){
            	//Add
                case 1:{
                    repositorio.gitAdd();
                    break;
                }
                case 2:{
                    System.out.println("Commit\n");
                    repositorio.gitCommit();
                    break;
                }
                //pull
                case 3:{
                    System.out.println("Pull\n");
                    repositorio.gitPull();
                    break;
                }
                //push
                case 4:{
                    System.out.println("Push\n");
                    repositorio.gitPush();
                    break;
                }
                //Satus
                case 5:{
                    System.out.println("Status\n");
                    repositorio.gitStatus();
                    break;
                }
                //Crear archivo
                case 6:{
                	System.out.println("Crear archivo\n");
                	System.out.println("Ingrese el nombre de su archivo a crear : ");
                    repositorio.crearArchivo();
                    break;
                }
                //Mostrar el workspace actual con todo
                case 7:{
                	System.out.println("Workspace actualmente\n");
                	repositorio.mostrarWorkspace();
                	//Solo si el workspace no esta vacío esperamos 4 segundos para que el usuario observe el workspace
                	if (!repositorio.workspaceEmpty()) {
                		Thread.sleep(4000);
					}                	
                	break;
                }
                //Editar archivo
                case 8:{
                	System.out.println("Editar Archivo\n");
                	repositorio.editarArchivo();
                	break;
                }
                //Borrar archivo
                case 9:{
                	System.out.println("Borrar Archivo\n");
                	repositorio.borrarArchivo();
                	break;
                }
                //Ver index
                case 10:{
                	System.out.println("Ver Index\n");
                	repositorio.mostrarIndex();
                	break;
                }
                //Log
                case 11:{
                	System.out.println("Log \n");
                	repositorio.gitLog();
                	break;
                }
                //Salir
                case 12:{
                    System.out.println("Adiós\n\n");
                    System.out.println("Simulación de Git terminada .");
                    break;
                }   
                default :{
                	System.out.println("Ingrese opción válida\n");
    				break;
                }
				
            }
        	}catch (Exception s) {
        		System.out.println("Algo salió mal" + s);
			}
        }
        entradaEscaner.close();

    }
	public static void limpiarPantalla() throws IOException {
		String sSistemaOperativo = System.getProperty("os.name");
		//System.out.println(sSistemaOperativo);
		if (sSistemaOperativo.equals("Windows")) {
			System.out.flush();
			Runtime.getRuntime().exec("clear");
		}else {
			System.out.print("\033[H\033[2J");  
			System.out.flush(); 
			Runtime.getRuntime().exec("clear");
		}		
		
	   } 
}
