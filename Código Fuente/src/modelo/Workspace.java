package modelo;

public interface Workspace {
	//Crear archivo
	public void crearArchivo();
	//Borrar Archivo
	public void borrarArchivo();
	//Mostrar Workspace
	public void mostrarWorkspace () ;
	//Mostrar archivo particular
	public void mostrarArchivo () ;
	//Editar Archivo
	public void editarArchivo();
	//Editar N linea
	public void editarLineaN();
	//Esta vacío el workspace
	public boolean isEmpty();
}
