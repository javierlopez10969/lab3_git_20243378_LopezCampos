//Importaciones
package modelo;
import java.util.Scanner;

import utils.Contenido;

public class MiArchivo implements Archivo{
	//Atributos
	private String nombre;
	private String fechaCreacion;
	private String fechaUltimaModificacion;
	private Contenido contenido;
	
	//Constructor
	public MiArchivo(String name){
		setNombre(name);
		setFechaCreacion();
		setFechaUltimaModificacion();
		contenido = new Contenido();
	}

	public void mostrarNombreFechas() {
		System.out.println("Nombre Archivo : \n" + getNombre()  
		+ "Fecha de cración : " + getFechaCreacion()
		+ "Última fecha de modifcación : " + getFechaUltimaModificacion());
		
	}
	
	public void mostrar() {
		System.out.println("Nombre Archivo : " + getNombre()  
		+ "\n Fecha de creación : " + getFechaCreacion()
		+ "\n Última fecha de modifcación : " + getFechaUltimaModificacion());
		contenido.mostrarContenido();
		System.out.println("\n");
	}
	
	//Edición de archivo
	public void editarArchivo() {
		//Variables de múltiples entradas
		String x = "-1";
		String linea = "line";
		int entero = 0;
		System.out.println("Edición de Archivo");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		while(!x.equals("4")) {
			try {
			System.out.println("Su archivo es :\n");
			contenido.mostrarContenido();
			System.out.println("\nQue desea hacer:\n"+
			"1.-Insertar línea \n"+
			"2.-Insertar Línea N \n" +	
			"3.-Borrar Línea \n"+
			"4.- Terminar Edición\n" );
			x = scanner.nextLine(); 
			switch (x) {
			case "1":
				System.out.println("Ingrese su linea");
				try {
					linea= scanner.nextLine(); 
				} catch (Exception s) {
					System.out.println("F");
				}
				contenido.insertarFinal(linea);
				break;
			case "2":{			
				System.out.println("Ingrese su linea");
				try {
					linea= scanner.nextLine(); 
				} catch (Exception s) {
					System.out.println("F");
				}
				System.out.println("Ingrese el indice su linea");
				try {
					entero = scanner.nextInt();
				} catch (Exception s) {
					System.out.println("F");
				}
				contenido.insertarN(entero, linea);
				break;
			}
			case "3":
				//Solo si el contenido no esta vacío
				if(!contenido.isEmpty()) {
					System.out.println("Ingrese el indice su linea que quiere borrar");
					try {
						entero = scanner.nextInt();
					} catch (Exception s) {
						System.out.println("F");
					}
					contenido.borrarLinea(entero);
					break;
				}else {
					System.out.println("El Archivo esta vacío, ¿Qué quiere borrar?\n");
				}
			default:
				System.out.println("Ingrese opción válida\n");
				break;
			}
			}catch (Exception s) {
			System.out.println("F");}
		}
		System.out.println("Su archivo editado quedó como:");
		setFechaUltimaModificacion();
		mostrar();
	}
	//Editar varias líneas
	public void ingresarVariasLineas() {
		System.out.println("Cuantas líneas quiere ingresar : ");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int n = 0;
		try {n = scanner.nextInt(); 
		} catch (Exception e) {
			System.out.println("F");
		}
		//Comenzamos un cilco while
		int i =  0;
		while (i < n) {
			String linea = "halo";
			try {
				linea= scanner.nextLine(); 
			} catch (Exception e) {
				System.out.println("F");
			}
			contenido.insertarFinal(linea);
			i++;
		}
	}
	
	
	//Setters and Getters
	//Nombre
	public String getNombre() {return nombre;}
	public void setNombre(String nombre) {this.nombre = nombre;}
	//Fecha creacion
	public String getFechaCreacion() {return fechaCreacion;}
	public void setFechaCreacion() {this.fechaCreacion = Tiempo.getActualTime();}
	//Fecha modificacion
	public String getFechaUltimaModificacion() {return fechaUltimaModificacion;}
	public void setFechaUltimaModificacion() {this.fechaUltimaModificacion = Tiempo.getActualTime() ;}
	//Editar contenido
	public Contenido getContenido() {return contenido;}
	public void setContenido(Contenido contenido) {this.contenido = contenido;}


}
