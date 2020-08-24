package modelo;

import utils.ListaDeArchivos;

// Esta es una interfaz la cuál permite implementar el TDA pila
public interface PilaCommit {
	//Metodos
	public void pushCommit(ListaDeArchivos archivos);
	public void popCommit();
	public int longitud();
	public ListaDeArchivos getCommit();
	public boolean isEmpty();
}
