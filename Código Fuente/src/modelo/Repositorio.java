package modelo;

public interface Repositorio {
	//Getters
	public String getAutor();
	public String getNombreRepositorio();
	public String getFechaDeCreacion();
	public void mostrarWorkspace();
	
	//Metodos
	//Constructor
	public void gitInit(String autor , String nombreRepositorio );
	//Edición y creación de archivos
	public void crearArchivo();
	public void borrarArchivo();
	public void editarArchivo();
	public void mostrarArchivo();
	
	
}
