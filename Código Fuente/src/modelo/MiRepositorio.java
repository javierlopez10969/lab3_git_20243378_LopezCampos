package modelo;

import java.util.Scanner;

import utils.ListaDeArchivos;

public class MiRepositorio {
	//Atributos
	private String nombreRepositorio;
	private String autor;
	private String fechaDeCreacion;
	
	//Zonas de trabajo
	//Workspace
	private Workspace workspace;
	private ListaDeArchivos index;
	
	//Repositories
	private PilaCommit localRepositroy;
	
	private PilaCommit remoteRepositroy;
	//Metodos
	
	//Constructor del repositorio
	public void gitInit(String autor , String nombreRepositorio ) {
		setAutor(autor);
		setNombreRepositorio(nombreRepositorio);
		setFechaDeCreacion(Tiempo.getActualTime() );
		workspace = new MiWorkspace();
		index = new ListaDeArchivos();
		localRepositroy = new MiCommit();
		remoteRepositroy = new MiCommit();
	}
	
	public void crearArchivo(){
		@SuppressWarnings("resource")
		Scanner scanner =  new Scanner(System.in);
		try {
			String nombreArchivo = scanner.nextLine(); 
			System.out.println(nombreArchivo);
			workspace.crearArchivo(nombreArchivo);
		} catch (Exception e) {
			
		}
		
	}
	//Limpiar Index
	
	//Setters and Getters
	public String getNombreRepositorio() {return nombreRepositorio;}
	public void setNombreRepositorio(String nombreRepositorio) {this.nombreRepositorio = nombreRepositorio;}
	public String getAutor() {return autor;}
	public void setAutor(String autor) {this.autor = autor;}
	public String getFechaDeCreacion() {return fechaDeCreacion;}
	public void setFechaDeCreacion(String fechaDeCreacion) {this.fechaDeCreacion = fechaDeCreacion;}
	
	//Repositories
	public Workspace getWorkspace() {return workspace;}
	public void setWorkspace(Workspace workspace) {this.workspace = workspace;}
	public ListaDeArchivos getIndex() {return index;}
	public void setIndex(ListaDeArchivos index) {this.index = index;}
	public PilaCommit getLocalRepositroy() {return localRepositroy;}
	public void setLocalRepositroy(PilaCommit localRepositroy) {this.localRepositroy = localRepositroy;}
	public PilaCommit getRemoteRepositroy() {return remoteRepositroy;}
	public void setRemoteRepositroy(PilaCommit remoteRepositroy) {this.remoteRepositroy = remoteRepositroy;}
}
