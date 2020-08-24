package modelo;

public interface Workspace {
	//Crear archivo
	public void crearArchivo(String nombreArchivo);
	//Borrar Archivo
	public void borrarArchivo();
	//Mostrar Workspace
	public void mostrarWorkspace () ;
	//Mostrar archivo particular
	public void mostrarArchivo (Archivo archivo) ;
	//Editar Archivo
	public void editarArchivo();
	//Editar N linea
	public void editarLineaN();
}
