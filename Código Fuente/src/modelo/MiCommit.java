package modelo;

import java.util.Scanner;

public class MiCommit implements Commits {
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
	
	//Cada commit realizado se guardará en un elemento llamado Commit
	private class Commit{
		//Lista de archivos o index con los archivos con cambios
		private Index index;
		private String autor;
		private String fecha;
		private String mensajeDescriptivoString;
		private Commit siguiente = null;

		
		//Generar commit a partir de un index y un 
		public Commit(Index index,String Autor, String Mensaje) {
			//Asignamos el index entregado 
			this.setIndex(index);
			//Asignamos el autor entregado
			setAutor(Autor);
			setFecha();
			setMensajeDescriptivoString(Mensaje);
		}
		
		//Mostrar el commit
		public String commit2String() {
			String salidaString = "" ;
			salidaString = salidaString +("Autor : " + getAutor()+ "\n");
			salidaString = salidaString +("Fecha del commit : " + getFecha() + "\n");
			salidaString = salidaString +("Comentario : " + getMensajeDescriptivoString() + "\n");
			salidaString = salidaString + getIndex().getIndex().archivos2String();
			return salidaString;
		}
		
		//Setters and getters
		public String getAutor() {return autor;}
		public void setAutor(String Autor) {this.autor = Autor;}
		public String getFecha() {return fecha;}
		public void setFecha() {this.fecha = Tiempo.getActualTime();}
		public String getMensajeDescriptivoString() {return mensajeDescriptivoString;}
		public void setMensajeDescriptivoString(String mensajeDescriptivoString) {this.mensajeDescriptivoString = mensajeDescriptivoString;}
		public Index getIndex() {return index;}
		public void setIndex(Index index) {this.index = index;}
		public Commit getSiguiente() {return siguiente;}
		public void setSiguiente(Commit siguiente) {this.siguiente = siguiente;}
	}
	
	//Insertar commit en el local repository
	@SuppressWarnings("resource")
	public void Commit(Index index, String autor) {
		//Para que se ejecute el push primero el index entregado no debe estar vacío
		if (!index.getIndex().isEmpty()) {
			String comentrario;
			Scanner scanner;
			scanner = new Scanner(System.in);
			System.out.println("Ingrese el comentario a su commit : ");
			comentrario = scanner.nextLine();
			//Creamos un nuevo commit a partir del index actual
			if (comentrario == "") {
				comentrario = "Sin comentario\n";
			}
			Commit nodo = new Commit(index,autor,comentrario);
			insertarCommit(nodo);
		}
	}
	//Función que revisa que todos los commits no se encuentren en el remote sean insertado
	public void gitPush(Commits localRepository) {
		
	}
	
	public void gitPull(Commits localRepositoy) {
		
	}
	
	//Siempre se inserta en la cima el último commit añadido
	public void insertarCommit(Commit commit) {
		commit.setSiguiente(getCima());
		setCima(commit);
		setTamano(getTamano() +1 );
	}
	//Por implementar, revisar si hay cambios realizados con respecto al commit anterior
	public Boolean cambios() {
		
		return true;
	}


	public Index getCommit() {
		Commit puntero = getCima() ;
		if (puntero == null) {
			return null;
		}else {
			return puntero.getIndex();
		}
	}

	public boolean isEmpty() {
		return getTamano() == 0;
	}
	
	public void mostrarRepositorio() {
		Commit puntero = getCima();
		while (puntero!=null) {
			System.out.println(puntero.commit2String());
			puntero = puntero.getSiguiente();
		}
	}
	//Git log 
	/*Esta funcionalidad debe mostrar una lista con los últimos 5 commits del
	Local Repository (indicando fecha, mensaje descriptivo y archivos añadidos). Si hay
	menos de 5 commits, muestra todos los que estén disponibles.*/
	public void gitLog() {
		System.out.println("Sus últimos 5 commits son  : ");
		Commit puntero = getCima();
		int i = 0;
		while (puntero!=null && i < 5) {
			System.out.println(puntero.commit2String());
			puntero = puntero.getSiguiente();
			i ++ ;
		}
	}
	
	
	//Setters and Getters
	public Commit getCima() {return cima;}
	public void setCima(Commit cima) {this.cima = cima;}
	public int getTamano() {return tamano;}
	public void setTamano(int Tamano) {tamano = Tamano;}
}
