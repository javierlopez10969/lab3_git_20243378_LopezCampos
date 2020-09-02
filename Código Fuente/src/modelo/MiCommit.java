package modelo;

import java.util.Scanner;

import utils.ListaDeArchivos;

public class MiCommit {
	/*
	 Commit: Debe contener la representación de un commit en el programa,
	respetando la lista que lo enlaza con commits anteriores o posteriores (esta lista
	ordenada de commits puede estar representada dentro del mismo commit o en la
	zona de trabajo que lo contiene) . Como mínimo debiese tener un autor, una
	marca de tiempo, un mensaje descriptivo y una representación de los cambios
	generados por ese commit. 
	 */
	//Los commit se comportan como pilas y a la vez como listas doblemente enlazadas, ya que hay un anterior
	//Y un siguiente
	//Commit más reciente
	private Commit cima = null ;
	//Total de commits
	private int tamano ;
	
	/**
	 * Cada commit realizado se guardará en una clase tipo nodo para lista enlazada llamada Commit
	 * Contiene una lista de archivos con index
	*/
	private class Commit{
		//Lista de archivos o index con los archivos con cambios
		private ListaDeArchivos workspace;
		private String autor;
		private String fecha;
		private String mensajeDescriptivoString;
		private Commit siguiente = null;

		/**
		 * Metodo constructor que a partir de una lista de archivos dada, en este caso el index
		 * Un autor, y un comentario respecto al commit generar un commit
		 */
		//Generar commit a partir de un index y un a
		public Commit(MiIndex  index,String Autor, String Mensaje) {
			//Asignamos el index entregado 
			this.setWorkspace(index.getIndex());
			//Asignamos el autor entregado
			setAutor(Autor);
			setFecha();
			setMensajeDescriptivoString(Mensaje);
		}
		
		//Mostrar el commit a traves 
		public String commit2String() {
			String salidaString = "" ;
			salidaString = salidaString +("Autor : " + getAutor()+ "\n");
			salidaString = salidaString +("Fecha del commit : " + getFecha() + "\n");
			salidaString = salidaString +("Comentario : " + getMensajeDescriptivoString() + "\n");
			salidaString = salidaString + getWorkspace().archivos2String();
			return salidaString;
		}
		
		//Setters and getters
		public String getAutor() {return autor;}
		public void setAutor(String Autor) {this.autor = Autor;}
		public String getFecha() {return fecha;}
		public void setFecha() {this.fecha = Tiempo.getActualTime();}
		public String getMensajeDescriptivoString() {return mensajeDescriptivoString;}
		public void setMensajeDescriptivoString(String mensajeDescriptivoString) {this.mensajeDescriptivoString = mensajeDescriptivoString;}
		public ListaDeArchivos  getWorkspace() {return workspace;}
		public void setWorkspace(ListaDeArchivos  workspace) {this.workspace = workspace;}
		public Commit getSiguiente() {return siguiente;}
		public void setSiguiente(Commit siguiente) {this.siguiente = siguiente;}
	}
	
	//Insertar commit en el local repository
	@SuppressWarnings("resource")
	public void Commit(MiIndex index, String autor) {
		//Para que se ejecute el push primero el index entregado no debe estar vacío
		//Además que debe ser distinto al último index entregado
		if (!index.getIndex().isEmpty() && existenCambios(index.getIndex())) {
			String comentrario;
			Scanner scanner;
			scanner = new Scanner(System.in);
			System.out.println("Ingrese el comentario a su commit : ");
			comentrario = scanner.nextLine();
			System.out.println("Desea  usar el autor predeterminado o cambiar el nombre del autor\n"
			+ "1.- Autor Predeterminado\n"
			+ "2.- Autor Distinto\n");
			int x = scanner.nextInt();
			if (x==2) {
				System.out.println("Ingrese el nombre de su autor\n");
				autor = scanner.nextLine();
			}
			System.out.println("Autor : " + autor+ "\n");
			//Creamos un nuevo commit a partir del index actual
			if (comentrario == "") {
				comentrario = "Sin comentario\n";
			}
			Commit nodo = new Commit(index,autor,comentrario);
			insertarCommit(nodo);
			System.out.println("Commit creado\n");
		}else {
			System.out.println("El index entregado no posee nuevos cambios con respecto al index anterior\n");
		}
	}
	/*Función que revisa que todos los commits no se encuentren en el remote sean insertados
	 * Esta función se llama desde la instancia de un remote repository
	 * Además que tiene como parametro de entrada
	 * */
	public void gitPush(MiCommit localRepository) {
		//Solo si el tamaño de local repository es distinto que el del repositorio actual
		if (getTamano() != localRepository.getTamano()) {
			System.out.println("Pusheando ...\n");
			//Se actualiza el local repository insertando cada commit uno por uno
			//Se actualiza el local repository asignandole el valor de la cima de local repository
			setCima(localRepository.getCima());
		}else {
			System.out.println("El remote repository se encuentra actualizado\n");
		}
	}
	
	public void gitPull(MiCommit localRepositoy) {
		//Toma el valor
	}
	
	//Siempre se inserta en la cima el último commit añadido
	public void insertarCommit(Commit commit) {
		commit.setSiguiente(getCima());
		setCima(commit);
		setTamano(getTamano() +1 );
	}
	//Por implementar, revisar si hay cambios realizados con respecto al commit anterior
	public Boolean existenCambios(ListaDeArchivos archivos) {
		//Si el repositorio esta vacío, si existen cambios
		if (isEmpty()) {
			return true;
		}else {
			//Obtenemos el último commit del repositorio
			Commit puntero = getCima();
			//Pregunto si los index son iguales
			if (puntero.getWorkspace() == archivos) {
				//No hay cambios
				return false;
			}
		}
		//Si hay cambios
		return true;
	}	

	/* gitLog
	 * Esta funcionalidad debe mostrar una lista con los últimos 5 commits del local repository por medio de un string
	 * (indicando fecha, mensaje descriptivo y archivos añadidos). Si hay
	 * menos de 5 commits, muestra todos los que estén disponibles.
	 * */
	public String gitLog() {
		String salidaString = "";
		Commit puntero = getCima();
		int i = 0;
		if (puntero!=null) {
			//Mientras el puntero sea un valor existente y además el indice sea menor a 5
			while (puntero!=null && i < 5) {
				salidaString = salidaString + puntero.commit2String() + "\n";
				puntero = puntero.getSiguiente();
				i ++ ;
			}
			System.out.println("Sus últimos " + i +" commits son  : \n");
		}else {
			salidaString = "Repositorio vacío";
		}
		return salidaString;
	}

	/* repositorio2String
	 * Esta funcionalidad debe mostrar una lista con todos los commits del local repository por medio de un string
	 * (indicando fecha, mensaje descriptivo y archivos añadidos)
	 * */
	public String repositorio2String() {
		String salidaString = "";
		Commit puntero = getCima();
		if (puntero!=null) {
			//Mientras el puntero sea un valor existente y además el indice sea menor a 5
			while (puntero!=null) {
				salidaString = salidaString + puntero.commit2String() + "\n";
				puntero = puntero.getSiguiente();
			}
		}else {
			salidaString = "Repositorio vacío";
		}
		return salidaString;
	}
	
	//Metodo que verifica si actualmente esta vacío el repositorio
	public boolean isEmpty() {return getTamano() == 0;}
	//Setters and Getters
	public Commit getCima() {return cima;}
	public void setCima(Commit cima) {this.cima = cima;}
	public int getTamano() {return tamano;}
	public void setTamano(int Tamano) {tamano = Tamano;}
}
