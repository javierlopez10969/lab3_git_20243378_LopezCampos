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
	public void crearArchivo() throws InterruptedException;
	public void borrarArchivo();
	public void editarArchivo() throws InterruptedException;

	//Operaciones del index
	public void gitAdd() throws InterruptedException;
	
	//Operaciones de local repository
	public void gitCommit();
	
	//Operaciones del remote y local
	public void gitPush();
	
	//Operaciones del workspace y el remote repository
	public void gitPull();
	
	public void gitStatus();
	public void gitLog();
	
	//Preguntas de estado
	public Boolean workspaceEmpty();
}
