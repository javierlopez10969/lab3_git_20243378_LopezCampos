package modelo;

import java.io.IOException;
import java.util.Scanner;

/**
 * Una clase para mostrar y gestionar los distintos comandos 
 * de la clase repositorio, y que estos interactuen con el usuario
 * @version 1.0, 31/08/2020
 * @author Javier López
 */
public interface Menu {
	static MiRepositorio repositorio = new MiRepositorio(); //Declaramos el repositorio
	
	
    /** 
     * Mostrar los distintos comandos de la simulación de git
     * @param void
     */
	public static void main(String[]args){
		Scanner entradaEscaner = new Scanner (System.in);
		int x = -1;//La entrada la incicializamos en -1
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
                //Commit
                case 2:{
                    System.out.println("Commit\n");
                    repositorio.gitCommit();
                    Thread.sleep(2000);
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
                    //Solo si no se encuentra actualizado hacemos como que esperamos el push
                    if (!repositorio.remoteActualizadoBoolean()) {
                    	Thread.sleep(2000);
                    	System.out.println("Commits actualizados\n");
					}
                                     
                    break;
                }
                //Satus
                case 5:{
                    System.out.println("Status\n");
                    repositorio.gitStatus();
                    Thread.sleep(4000);
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
                	System.out.println(repositorio.workspace2String());
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
                	System.out.println(repositorio.index2String());
                	if (!repositorio.getIndex().isEmpty()) {
                		Thread.sleep(4000);
					}
                    break;
                }
                //Log
                case 11:{
                	System.out.println("Log \n");
                	repositorio.gitLog();
                	Thread.sleep(4000);
                	break;
                }
                //Git Branch
                case 13:{
                	System.out.println("Git Branch\n");
                	break;
                }
                //Git CheckOut
                case 14:{
                	System.out.println("Git CheckOut\n");
                	break;
                }
                //Git Merge
                case 15:{
                	System.out.println("Git Merge\n");
                	break;
                }
                //Salir
                case 16:{
                    System.out.println("Adiós\n\n");
                    System.out.println("Simulación de Git terminada .");
                    break;
                } 
                
                
                //FUNCIONES SECRETAS
                //Mostrar local repository
                case 18:{
                	System.out.println("Función secreta mostrar toodo Local Repository\n");
                	repositorio.mostrarRepositorioLocal();
                	Thread.sleep(4000);
                	break;
                }
                //Log de remote repository
                case 19:{
                	System.out.println("Log de Remote Repository\n");
                	repositorio.gitLogRemote();
                	Thread.sleep(4000);
                	break;
                }
                //Mostrar remote repository
                case 20:{
                	System.out.println("Función secreta mostrar toodo Remote Repository\n");
                	repositorio.mostrarRepositorioRemoto();
                	Thread.sleep(4000);
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
    /** 
     * Metodo paraantener limpia la pantalla
     * @param void
     */
	public static void limpiarPantalla(){
		String sSistemaOperativo = System.getProperty("os.name");
		//System.out.println("Su sistema operativo es : "+sSistemaOperativo);
		//SPliteamos el sSistema ya que puede haber más de un tipo de windows o Linux
        String[] arrOfStr = sSistemaOperativo.split(" ", 1);
        //System.out.println("System Real : " + arrOfStr[0]+ "\n");
		if (arrOfStr[0].equals("Windows")) { 
		    System.out.flush(); 
		    try {
		    	Runtime.getRuntime().exec("cls");
			} catch (IOException e) {
				System.out.println(e);
			}
		}else if (arrOfStr[0].equals("Linux")){
			System.out.print("\033[H\033[2J");  
			System.out.flush(); 
		    try {
		    	Runtime.getRuntime().exec("clear");
			} catch (IOException e) {
				System.out.println(e);
			}
		}		
		
	   } 
}
