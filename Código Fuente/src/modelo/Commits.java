package modelo;

// Esta es una interfaz la cuál permite implementar el TDA pila
public interface Commits {
	//Metodos
	public void Commit(Index index, String autor);
	public void gitPush(Commits localRepository);
	public void gitPull(Commits localRepository);
	public void gitLog();
	public int getTamano();
	public boolean isEmpty();
}
