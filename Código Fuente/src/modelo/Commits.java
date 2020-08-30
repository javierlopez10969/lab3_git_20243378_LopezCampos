package modelo;

// Esta es una interfaz la cuál permite implementar el TDA pila
public interface Commits {
	//Metodos
	public void pushCommit(Index index);
	public void popCommit();
	public int getTamano();
	public Index  getCommit();
	public boolean isEmpty();
}
