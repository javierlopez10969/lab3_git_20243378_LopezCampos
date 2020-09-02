package modelo;


import java.util.Scanner;

import utils.ListaDeArchivos;
	
public class MiIndex{
	private ListaDeArchivos index = new ListaDeArchivos();
	//Limpiar Index
	public void limpiarIndex(){setIndex(new ListaDeArchivos());}
	//Menú gitAdd que se le entrega el workspace actual
	public void gitAdd(MiWorkspace workspace) throws InterruptedException{
		//Solo si el workspace no se encuentra vacío
		if (!workspace.isEmpty()) {
			//Variables de múltiples entradas
			int x = -1;
			System.out.println("Git Add\n");
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			while(x < 5) {
					//Mostramos los archivos en el workspace
					System.out.println("Workspace actual : ");
					System.out.println(workspace.nombreFecha2String());
					//Mostramos los archivos en el index
					System.out.println("Index Actualmente : \n");
					if (index.isEmpty()) {
						System.out.println("Index vacío\n");
					}else {
						System.out.println(index.nombreFechas2String());
					}
					System.out.println( );
					Thread.sleep(2000);
					System.out.println("\nQue desea hacer:\n"+
					"1.-Agregar todos los archivos \n"+
					"2.-Agregar varios archivos\n" +	
					"3.-Agregar un archivo \n"+
					"4.-Mostrar archivos en Index\n"+
					"5.-Terminar Add\n"+
					"Ingrese una opción : ");
					try {
						x = scanner.nextInt();
					} catch (Exception e) {
						System.out.println("Ha ocurrido un error" + e);
					}
					 
					System.out.println("Entrada : " + x);
					//Git add -All
					if (x== 1) {
						//Indicamos que index ahora es igual al index
						agregarVariosIndex(workspace, workspace.getTamano());
					}
					//Agregar varios archivos
					else if (x== 2){
						System.out.println("Ingrese cuantos archivos quiere ingresar");
						int tamano = 0;
						try {
							tamano = scanner.nextInt();
						} catch (Exception e) {
							System.out.println("Algo salio mal");
						}
						agregarVariosIndex(workspace, tamano);
					}
					//Agregar un archivo
					else if (x== 3){
						System.out.println("Ingrese el indice del archivo que quiere agregar al index");
						int indice = 0;
						try {
							indice = scanner.nextInt();
						} catch (Exception e) {
							System.out.println("Algo salió mal");
						}
						agregarIndex(workspace,indice);
					}
					else if (x== 4){
						System.out.println("Index Actualmente : \n");
						System.out.println(index.archivos2String());
						Thread.sleep(4000);
					}
					else if (x== 5){
						System.out.println("Add Terminado\n");
						break;
					}
					else{
						System.out.println("Ingrese opción válida\n X : " + x);
						x = -1;
					}
			}
		}else {
			System.out.println("Workspace vacío, no procede hacer add\n");
		}
	}
	
	//Agregar archivo del workspace
	public int agregarIndex(MiWorkspace workspace, int indice) {
		//Procedemos a preguntamos si podemos obtener el archivo
		if (workspace.getArchivoN(indice)!= null) {
			//Creamos el archivo a partir de otro archivo
			Archivo archivo = new MiArchivo(workspace.getArchivoN(indice));
			//System.out.println("El archivo original es :");
			//workspace.getArchivoN(indice).mostrar();
			//System.out.println("El archivo copiado es :");
			//archivo.mostrar();
			//Solo si el archivo no se encuentra dentro del index
			if (!index.isInside(archivo)) {
				index.añadirArchivo(archivo);
				return 1;
			}else {
				return 0;
			}

		}else {
			System.out.println("Indice de archivo inválido");
			return 0;
		}
	}
	
	//Agregar varios archivo del workspace al index
	public void agregarVariosIndex(MiWorkspace workspace,int tamano) {
		System.out.println("total : " + tamano);
		//Si el tamaño es mayor que los archivos totales del workspace
		if (tamano > workspace.getTamano() || tamano <= 0 ) {
			System.out.println("Indice supera el total de archivos");
		}
		//Si es igual
		else if(tamano == workspace.getTamano()) {
			System.out.println("Add all\n");
			//git add all
			int indice = 0;
			System.out.println("Tamaño workspace : " + workspace.getTamano() + "\n");
			while ( indice < tamano) {
				System.out.println("i:"+indice+"\n");
				agregarIndex(workspace, indice);
				indice++;
			}
		}
		else {
			Scanner scanner = new Scanner(System.in);
			//git add algunos
			while ( tamano >0) {
				System.out.println("Ingrese el indice del archivo que quiere agregar al index");
				int indice = 0;
				try {
					indice = scanner.nextInt();
				} catch (Exception e) {
					System.out.println("Algo salió mal");
				}
				agregarIndex(workspace, indice);
				tamano --;
			}
			scanner.close();
		}
		
		//Si es menor o igual a 
	}
	
	public Boolean isEmpty() {return index.isEmpty();}
	public int getTamano() {return index.getTamano();}
	public ListaDeArchivos getIndex() {return index;}
	public void setIndex(ListaDeArchivos index) {this.index = index;}
}
