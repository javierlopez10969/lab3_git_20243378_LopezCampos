package modelo;

import java.util.Scanner;

//Importaciones
import utils.ListaDeArchivos;

public class MiWorkspace implements Workspace {
	//Atributos
	private ListaDeArchivos archivos = new ListaDeArchivos();

	//Metodos
	public void crearArchivo() {
		@SuppressWarnings("resource")
		Scanner scanner =  new Scanner(System.in);
		String nombreArchivo = "Jamon";
		try {
			nombreArchivo = scanner.nextLine(); 
			System.out.println(nombreArchivo);
		} catch (Exception e) {
			System.out.println("F");
		}
		//System.out.println(nombreArchivo);
		Archivo archivo = new MiArchivo(nombreArchivo);
		if (archivos.isEmpty()) {
			//Lo añadimos al principio
			System.out.println("No hay ningún archivo se procederá a crear el primer archivo");
			archivos.insertarPrincipio(archivo);
		}else {
			System.out.println("Creando nuevo archivo");
			//Lo añadimos al final
			archivos.insertarFinal(archivo);
		}
		System.out.println("Archivo : " + nombreArchivo + " añadido a workspace\n"
		+ "Desea editarlo? si '\' no \n");
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
	}
	@Override
	public void borrarArchivo() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mostrarWorkspace() {archivos.mostrarArchivos();}
	
	@Override
	public void mostrarArchivo() {}
	@Override
	public void editarArchivo() {
		//Antes de editar preguntamos si el workspace no esta vacío
		if (!isEmpty()) {
			//Primero mostramos todo el workspace
			mostrarWorkspace();
			//Ahora le preguntamos que archivo quiere editar
			System.out.println("Ingrese el indice del archivo que quiere editar:");
			@SuppressWarnings("resource")
			Scanner scanner =  new Scanner(System.in);
			int indiceArchivo = 0;
			try {
				indiceArchivo = scanner.nextInt(); 
				System.out.println(indiceArchivo);
			} catch (Exception e) {
				System.out.println("F");
			}
			System.out.println(indiceArchivo);
			//Procedemos a preguntamos si podemos editar el archivo
			if (archivos.getArchivoN(indiceArchivo)!= null) {
				Archivo archivo  = archivos.getArchivoN(indiceArchivo);
				archivo.editarArchivo();
			}
		}else {
			System.out.println("No se puede editar, ya que el workspace se encuentra vacío");
		}
	}

	public void editarLineaN() { }

	public boolean isEmpty() {return archivos.isEmpty();}
	
}
