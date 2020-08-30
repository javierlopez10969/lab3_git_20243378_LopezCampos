package modelo;

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
		private Commit siguiente = null;
		private String Autor;
		private String Fecha;
		private String mensajeDescriptivoString;
		
		public Commit(Index index) {
			this.setIndex(index);
		}
		//Setters and getters
		public String getAutor() {return Autor;}
		public void setAutor(String autor) {Autor = autor;}
		public String getFecha() {return Fecha;}
		public void setFecha(String fecha) {Fecha = fecha;}
		public String getMensajeDescriptivoString() {return mensajeDescriptivoString;}
		public void setMensajeDescriptivoString(String mensajeDescriptivoString) {this.mensajeDescriptivoString = mensajeDescriptivoString;}
		public Index getIndex() {return index;}
		public void setIndex(Index index) {this.index = index;}
		public Commit getSiguiente() {return siguiente;}
		public void setSiguiente(Commit siguiente) {this.siguiente = siguiente;}
		
	}
	//Insertar commit
	@Override
	public void pushCommit(Index index) {
		Commit nodo = new Commit(index);
		nodo.setSiguiente(cima);
		setCima(nodo);
		setTamano(getTamano() +1 );
	}
	@Override
	public void popCommit() {
		Commit puntero = getCima() ;
		if (puntero != null) {
			setCima(puntero.getSiguiente());
			puntero.setSiguiente(null);
			setTamano(getTamano() +1 );
		}
	}

	@Override
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
	
	
	//Setters and Getters
	public Commit getCima() {return cima;}
	public void setCima(Commit cima) {this.cima = cima;}
	public int getTamano() {return tamano;}
	public void setTamano(int Tamano) {tamano = Tamano;}
}
