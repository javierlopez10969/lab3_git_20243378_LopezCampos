package modelo;


import java.util.Scanner;

import utils.ListaDeArchivos;
	
public class MiIndex implements Index {
	private ListaDeArchivos index = new ListaDeArchivos();
	
	//Limpiar Index
	public void limpiarIndex(){setIndex(new ListaDeArchivos());}
	//Menú gitAdd que se le entrega el workspace actual
	public void gitAdd(Workspace workspace){
		
		//Si el workspace no se encuentra vacío
		if (!workspace.isEmpty()) {
			workspace.mostrarNombreFecha();
			//Variables de múltiples entradas
			String x = "-1";
			System.out.println("Git Add\n");
			Scanner scanner = new Scanner(System.in);
			while(!x.equals("4")) {
				try {
				workspace.mostrarNombreFecha();
				System.out.println("\nQue desea hacer:\n"+
				"1.-Agregar todos los archivos \n"+
				"2.-Agregar varios archivos\n" +	
				"3.-Agregar un archivo \n"+
				"4.-Terminar Add\n" );
				System.out.println("¿Qué archivos quiere agregar al Index ?\n"+
				"Ingrese el indice del archivo : ");
				int indiceArchivo = 0;

				System.out.println(indiceArchivo);
				x = scanner.nextLine(); 
				switch (x) {
				//Git add -A
				case "1":
					//Indicamos que index ahora es igual al index
					index = workspace.getArchivos();
					x = "4";
					break;
				//Agregar un par de archivos
				case "2":{			
					
				}
				//Agregar un archivo
				case "3":
					
				default:
					System.out.println("Ingrese opción válida\n");
					break;
				}
				}catch (Exception s) {
				System.out.println("F");}
			}
			scanner.close();
		}else {
			System.out.println("Workspace vacío, no procede hacer add\n");
		}
	}
	
	//Agregar archivo del workspace
	public void agregarIndex(Workspace workspace) {
		Scanner scanner = new Scanner(System.in);
		//Procedemos a preguntamos si podemos obtener el archivo
		if (workspace.getArchivoN(indiceArchivo)!= null) {
			Archivo archivo  = index.getArchivoN(indiceArchivo);
		}else {
			System.out.println("Indice de archivo inválido");
		}
		
	}
	
	
	
	public ListaDeArchivos getIndex() {return index;}
	public void setIndex(ListaDeArchivos index) {this.index = index;}
}
