package modelo;

import utils.ListaDeArchivos;

public interface Workspace {
	//Métodos necesarios para la implementación de workspace
	//Crear archivo
	public void crearArchivo();
	//Borrar Archivo
	public void borrarArchivo();
	//Mostrar Workspace
	public void mostrarWorkspace () ;
	public void mostrarNombreFecha();
	//Editar Archivo
	public void editarArchivo();
	//Esta vacío el workspace
	public boolean isEmpty();
	//Setters and getters
	public Archivo getArchivoN(int n);
	//Función que devuelve todos los archivos presentes en el workspace
	public ListaDeArchivos getArchivos();
	
}
