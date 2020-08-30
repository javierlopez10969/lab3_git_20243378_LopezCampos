package modelo;

public interface Repositorio {
	//Getters
	public String getAutor();
	public String getNombreRepositorio();
	public String getFechaDeCreacion();
	public void mostrarWorkspace();
	public void mostrarIndex();
	
	//Metodos
	//Constructor
	public void gitInit(String autor , String nombreRepositorio );
	
	//Operaciones del Workspace
	//Edición y creación de archivos 
	public void crearArchivo();
	public void borrarArchivo();
	public void editarArchivo();

	//Operaciones del index
	public void gitAdd();
	public void gitPush();
	public void gitPull();
	public void gitStatus();
	public void gitLog();
}
