package modelo;

import utils.ListaDeArchivos;

public class MiCommit implements PilaCommit {
	//Los commit se comportan como pilas
	private Commit cima = null ;
	private int Tamano ;
	
	//Cada commit realizado se guardará en un elemento llamado Commit
	private class Commit{
		private ListaDeArchivos archivos;
		private Commit siguiente = null;
		public Commit(ListaDeArchivos archivos) {this.setArchivos(archivos);}
		public ListaDeArchivos getArchivos() {return archivos;}
		public void setArchivos(ListaDeArchivos archivos) {this.archivos = archivos;}
		public Commit getSiguiente() {return siguiente;}
		public void setSiguiente(Commit siguiente) {this.siguiente = siguiente;}
		
	}
	//Insertar commit
	@Override
	public void pushCommit(ListaDeArchivos archivos) {
		Commit nodo = new Commit(archivos);
		nodo.setSiguiente(cima);
		setCima(nodo);
		setTamano(Tamano +1 );
	}
	@Override
	public void popCommit() {
		Commit puntero = getCima() ;
		if (puntero != null) {
			setCima(puntero.getSiguiente());
			puntero.setSiguiente(null);
			setTamano(Tamano +1 );
		}
	}

	@Override
	public ListaDeArchivos getCommit() {
		Commit puntero = getCima() ;
		if (puntero == null) {
			return null;
		}else {
			return puntero.getArchivos();
		}
	}

	@Override
	public boolean isEmpty() {
		return Tamano == 0;
	}
	
	@Override
	public int longitud() {
		return Tamano;
	}
	
	//Setters and Getters
	public Commit getCima() {return cima;}
	public void setCima(Commit cima) {this.cima = cima;}
	public int getTamano() {return Tamano;}
	public void setTamano(int tamano) {Tamano = tamano;}
}
