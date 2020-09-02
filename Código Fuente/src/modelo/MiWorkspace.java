package modelo;

import java.util.Scanner;

//Importaciones
import utils.ListaDeArchivos;
/*Clase encargada de la manipulación del workspace, podría ser una lista de archivos simplemente el workspace
 * Y que esa lista sea manipulada por el mismo repositorio, pero necesitamos que una clase se ocupe enteramente del workspace
 * Que edite, cree, y borre archivos, y llame a los disitnos metodos pertenecientes a la clase lista de archivos
 * */
public class MiWorkspace{
	//Atributos
	private ListaDeArchivos archivos = new ListaDeArchivos();

	//Metodos
	//Este es el bloque de métodos complejos, ya que necesitan una itneracción fuerte con el usuario
	//Se podría relacionar a workspace como un intermediario entre los datos almacenadaos y lo que ocurre con ellos
	public void crearArchivo() throws InterruptedException {
		@SuppressWarnings("resource")
		Scanner scanner =  new Scanner(System.in);
		String nombreArchivo = "Jamon";//Inicializamos la variable nombre, por si no toma las variables de entradas
		try {
			nombreArchivo = scanner.nextLine(); 
		} catch (Exception e) {
			System.out.println("Un error ha ocurrido " + e);
		}
		//System.out.println(nombreArchivo);
		//Inicializamos un archivo a partir del nombre dado
		Archivo archivo = new MiArchivo(nombreArchivo);
		//Solo si el archivo no se encuentra en el workspace
		if (!archivos.isInside(archivo)) {
		archivos.añadirArchivo(archivo);
			//Le informamos que el archivo ha sido creado y añadido al workspace y le preguntamos si quiere editarlo
			System.out.println("Archivo : " + nombreArchivo + " añadido a workspace\n"
			+ "Desea editarlo? si "+ "\\" + " no \n");
			String respuesta = "YES";
			try {
				respuesta = scanner.nextLine(); 
			} catch (Exception e) {
				System.out.println("F");
			}
			System.out.println(respuesta);
			if (respuesta.equals("si")||respuesta.equals("YES")|| respuesta.equals("Si")
			|| respuesta.equals("oui")|| respuesta.equals("Yes") ||respuesta.equals("1")) {
				archivo.editarArchivo();
			}
		}else {
			System.out.println("Hay un archivo con el mismo nombre, no procede a crear nuevo archivo\n");
		}		
	}
	//Método encargado de borrar un archivo
	public void borrarArchivo() {
		if (!isEmpty()) {
			//Mostramos el workspace
			System.out.println(workspace2String());
			System.out.println("Ingrese el indice delarchivo que desee borrar : \n");
			int respuesta = 0;
			Scanner scanner = new Scanner(System.in);
			try {
				respuesta = scanner.nextInt(); 
			} catch (Exception e) {
				System.out.println("F");
			}
			archivos.borrarArchivo(respuesta);
			scanner.close();
		}else {
			System.out.println("No se puede borrar ningún archivo, ya que el workspace se encuentra vacío\n");
		}
		
		
	}

	public void editarArchivo() throws InterruptedException {
		//Antes de editar preguntamos si el workspace no esta vacío
		if (!isEmpty()) {
			//Primero mostramos todo el workspace
			System.out.println(workspace2String());
			//Ahora le preguntamos que archivo quiere editar
			System.out.println("Ingrese el indice del archivo que quiere editar:");
			int indiceArchivo = 0;
			@SuppressWarnings("resource")
			Scanner scanner =  new Scanner(System.in);
			try {
				indiceArchivo = scanner.nextInt(); 
			} catch (Exception e) {
				System.out.println("F");
			}
			//System.out.println(indiceArchivo);
			//Procedemos a preguntamos si podemos editar el archivo
			if (archivos.getArchivoN(indiceArchivo)!= null) {
				Archivo archivo  = archivos.getArchivoN(indiceArchivo);
				archivo.editarArchivo();
			}else {
				System.out.println("Indice de archivo inválido\n");
			}
		}else {
			System.out.println("No se puede editar, ya que el workspace se encuentra vacío\n");
		}
	}
	
	//Métodos que son operado por la lista de archivos, son metodos simples que no necesitan interacción 
	//Con el usuario

	//Mostrar todo el workspace
	public String workspace2String() {return archivos.archivos2String();}
	public String nombreFecha2String() {return archivos.nombreFechas2String();}
	//El workspace se encuentra vacío
	public boolean isEmpty() {return archivos.isEmpty();}
	public Archivo getArchivoN(int n) {return archivoN(n);}
	public Archivo archivoN(int n){return archivos.getArchivoN(n);}
	public ListaDeArchivos getArchivos() {return archivos;}
	public int getTamano() {return archivos.getTamano();}
}
