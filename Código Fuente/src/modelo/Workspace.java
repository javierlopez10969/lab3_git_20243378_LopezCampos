package modelo;

import utils.ListaDeArchivos;

public interface Workspace {
	//Métodos necesarios para la implementación de workspace
	//Crear archivo
	public void crearArchivo() throws InterruptedException;
	//Borrar Archivo
	public void borrarArchivo();
	//Mostrar Workspace mediante strings
	public String workspace2String();
	public String nombreFecha2String();
	//Editar Archivo
	public void editarArchivo() throws InterruptedException;
	//Esta vacío el workspace
	public boolean isEmpty();
	//Setters and getters
	public Archivo getArchivoN(int n);
	//Metodo que devuelve todos los archivos presentes en el workspace
	public ListaDeArchivos getArchivos();
	//Getter del total de archivos en el workspace
	public int getTamano();
	
}
