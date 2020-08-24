package modelo;

//Importaciones
import utils.ListaDeArchivos;

public class MiWorkspace implements Workspace {
	//Atributos
	private ListaDeArchivos archivos = new ListaDeArchivos();
	
	//Metodos
	public ListaDeArchivos getArchivos() {return archivos;}
	public void setArchivos(ListaDeArchivos archivos) {this.archivos = archivos;}
	@Override
	public void crearArchivo(String nombreArchivo) {
		System.out.println(nombreArchivo);
		Archivo archivo = new MiArchivo(nombreArchivo);
		if (archivos.isEmpty()) {
			//Lo añadimos al principio
			System.out.println("No hay ningún archivo\n");
			archivos.insertarPrincipio(archivo);
		}else {
			//Lo añadimos al final
			archivos.insertarFinal(archivo);
		}
		System.out.println("Archivo " + nombreArchivo + " añadido a workspace\n"
		+ "Desea editarlo?\n");
	}
	@Override
	public void borrarArchivo() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mostrarWorkspace() {
		if (archivos.isEmpty()) {
			System.out.println("No hay ningún archivo");
		}
		
	}
	@Override
	public void mostrarArchivo(Archivo archivo) {
		
		
	}
	@Override
	public void editarArchivo() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void editarLineaN() {
		// TODO Auto-generated method stub
		
	}
	
}
