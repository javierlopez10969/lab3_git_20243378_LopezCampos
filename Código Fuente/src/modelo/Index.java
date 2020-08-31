package modelo;

import utils.ListaDeArchivos;

public interface Index {
	public void gitAdd(Workspace workspace) throws InterruptedException;
	public ListaDeArchivos getIndex();
	public  int getTamano();
	public Boolean isEmpty();
	public void limpiarIndex();
}
