package modelo;

import utils.ListaDeArchivos;

public class MiRepositorio implements Repositorio{
	//Atributos
	private String nombreRepositorio;
	private String autor;
	private String fechaDeCreacion;
	
	//Zonas de trabajo
	//Workspace
	private Workspace workspace;
	private Index index;
	
	//Repositories
	private Commit localRepositroy;
	private Commit remoteRepositroy;
	//Metodos
	
	//Constructor del repositorio
	public void gitInit(String autor,String nombreRepositorio ) {
		setAutor(autor);
		setNombreRepositorio(nombreRepositorio);
		setFechaDeCreacion(Tiempo.getActualTime() );
		workspace = new MiWorkspace();
		index = new MiIndex();
		localRepositroy = new MiCommit();
		remoteRepositroy = new MiCommit();
	}

	//Metodos del Workspace
	public void editarArchivo() {workspace.editarArchivo();}
	public void mostrarWorkspace() {workspace.mostrarWorkspace();}
	public void borrarArchivo() {workspace.borrarArchivo();}
	public void crearArchivo(){workspace.crearArchivo();}
	
	//Index
	//Menú que pregunta que archivos quiere añadir al index
	public void gitAdd(){index.gitAdd(getWorkspace());}
	public void mostrarIndex() {index.getIndex().mostrarArchivos();}
	
	//Local Repository
	public void gitPush(){}
	
	//Remote Repository	
	public void gitPull(){}
	
	//git Status
	//i. Información del repositorio (nombre y autor)
	//ii. Número de archivos en el Workspace
	//iii. Número de archivos en el Index
	//iv. Número de commits en el Local Repository
	//v. SI el Remote Repository está al día (o no) con los cambios del Local Repository
	public void gitStatus() {
		System.out.println(
		"\nAutor : " + getAutor()+
		"\nNombre Repositorio  : " + getNombreRepositorio() +
		"\nFecha de creación  : " + getFechaDeCreacion() +
		"\nTotal de archivos en workspace : " + workspace.getTamano()+
		"\nTotal de archivos en el index  : " + index.getTamano()+
		"\nTotal de commits en el local repository : " + localRepositroy.getTamano()+
		remoteActualizado() );
	}
	
	public String remoteActualizado() {
		return "si";	}
	public void gitLog() {
		
	}
	
	
	//Setters and Getters
	public String getNombreRepositorio() {return nombreRepositorio;}
	public void setNombreRepositorio(String nombreRepositorio) {this.nombreRepositorio = nombreRepositorio;}
	public String getAutor() {return autor;}
	public void setAutor(String autor) {this.autor = autor;}
	public String getFechaDeCreacion() {return fechaDeCreacion;}
	public void setFechaDeCreacion(String fechaDeCreacion) {this.fechaDeCreacion = fechaDeCreacion;}
	//Repositories
	public Workspace getWorkspace() {return workspace;}
	public ListaDeArchivos getIndex() {return index.getIndex();}
	public Commit getLocalRepositroy() {return localRepositroy;}
	public Commit getRemoteRepositroy() {return remoteRepositroy;}
}
