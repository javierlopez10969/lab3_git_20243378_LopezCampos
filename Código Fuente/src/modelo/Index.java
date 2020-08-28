package modelo;

import utils.ListaDeArchivos;

public interface Index {
	public void gitAdd(Workspace workspace);
	public ListaDeArchivos getIndex();
}
