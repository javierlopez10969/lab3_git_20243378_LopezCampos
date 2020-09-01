package modelo;

import utils.ListaDeArchivos;

public class MiRepositorio implements Repositorio{
	//Atributos
	private String nombreRepositorio;
	private String autor;
	private String fechaDeCreacion;
	private String branch = "Master";
	
	//Zonas de trabajo
	//Workspace
	private Workspace workspace;
	private Index index;
	
	//Repositories
	private Commits localRepositroy;
	private Commits remoteRepositroy;
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
	public void editarArchivo() throws InterruptedException {workspace.editarArchivo();}
	public String workspace2String() {return workspace.workspace2String();}
	public void borrarArchivo() {workspace.borrarArchivo();}
	public void crearArchivo() throws InterruptedException{workspace.crearArchivo();}
	
	//Index
	//Menú que pregunta que archivos quiere añadir al index
	public void gitAdd() throws InterruptedException{index.gitAdd(getWorkspace());}
	public String index2String() {
		if (index.isEmpty()) {
			return "Index Vacío\n";
		}
		return index.getIndex().archivos2String();
	}
	
	//Local Repository
	public void gitCommit(){
		if (!index.isEmpty()) {
			localRepositroy.Commit(index, autor);
			index.limpiarIndex();
		}else {
			System.out.println("Index vacío no procede hacer el commit\n");
		}
	}
	
	//Remote Repository	
	public void gitPush(){
		if (localRepositroy.isEmpty()) {
			System.out.println("Local repositroy vacío no procede hacer push\n");
		}else {
			System.out.println("Making push ...\n");
		}
		
	}
	public void gitPull(){
		if (remoteRepositroy.isEmpty()) {
			System.out.println("Local repositroy vacío no procede hacer pull\n");
		}
		else if (localRepositroy.getTamano() == remoteRepositroy.getTamano()) {
			System.out.println("Remote repository actualizado con commits más recientes\n");
		}else {
			System.out.println("Making pull ...\n");
		}
		
	}
	
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
		"\nRama : " + branch +
		"\nTotal de archivos en workspace : " + workspace.getTamano()+
		"\nTotal de archivos en el index  : " + index.getTamano()+
		"\nTotal de commits en el local repository : " + localRepositroy.getTamano()+
		"\nEl remote se encuentra "+remoteActualizado() );
	}
	
	public String remoteActualizado() {
		if (localRepositroy.isEmpty()) {
			return "vacío, ya que no hay ningun commit realizado";
		}
		else if (remoteRepositroy.getTamano() == localRepositroy.getTamano()) {
			return "actualizado";
		}else {
			return "desactualziado";
		}
	}
	public void gitLog() {localRepositroy.gitLog();}
	
	
	
	//Setters and Getters
	public String getNombreRepositorio() {return nombreRepositorio;}
	public void setNombreRepositorio(String nombreRepositorio) {this.nombreRepositorio = nombreRepositorio;}
	public String getAutor() {return autor;}
	public void setAutor(String autor) {this.autor = autor;}
	public String getFechaDeCreacion() {return fechaDeCreacion;}
	public void setFechaDeCreacion(String fechaDeCreacion) {this.fechaDeCreacion = fechaDeCreacion;}
	//Repositories
	public Workspace getWorkspace() {return workspace;}
	public Boolean workspaceEmpty() {return workspace.isEmpty();}
	public ListaDeArchivos getIndex() {return index.getIndex();}
	public Commits getLocalRepositroy() {return localRepositroy;}
	public Commits getRemoteRepositroy() {return remoteRepositroy;}
}
