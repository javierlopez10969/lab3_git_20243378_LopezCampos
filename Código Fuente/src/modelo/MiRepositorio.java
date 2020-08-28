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
	private PilaCommit localRepositroy;
	private PilaCommit remoteRepositroy;
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
	
	//Local Repository
	public void gitPush(){}
	
	//Remote Repository	
	public void gitPull(){}
	
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
	public PilaCommit getLocalRepositroy() {return localRepositroy;}
	public PilaCommit getRemoteRepositroy() {return remoteRepositroy;}
}
