//Importaciones
package modelo;
import utils.Contenido;

public class MiArchivo implements Archivo{
	//Atributos
	private String nombre;
	private String fechaCreacion;
	private String fechaUltimaModificacion;
	private Contenido contenido;
	
	//Constructor
	public MiArchivo(String name){
		setNombre(name);
		setFechaCreacion();
		setFechaUltimaModificacion();
		contenido = new Contenido();
	}
	@Override
	public void ingresarLinea(String linea) {
		contenido.insertarFinal(linea);
	}
	@Override
	public void ingresarLineaN(String linea) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mostrarNombreFechas() {
		System.out.println("Nombre Archivo : " + getNombre()  
		+ "\n Fecaha de cración : " + getFechaCreacion()
		+ "\n Última fecha de modifcación : " + getFechaUltimaModificacion());
		
	}
	@Override
	public void mostrarTodo() {
		System.out.println("Nombre Archivo : " + getNombre()  
		+ "\n Fecaha de cración : " + getFechaCreacion()
		+ "\n Última fecha de modifcación : " + getFechaUltimaModificacion());
		contenido.mostrarContenido();
		
	}
	//Setters and Getters
	//Nombre
	public String getNombre() {return nombre;}
	public void setNombre(String nombre) {this.nombre = nombre;}
	//Fecha creacion
	public String getFechaCreacion() {return fechaCreacion;}
	public void setFechaCreacion() {this.fechaCreacion = Tiempo.getActualTime();}
	//Fecha modificacion
	public String getFechaUltimaModificacion() {return fechaUltimaModificacion;}
	public void setFechaUltimaModificacion() {this.fechaUltimaModificacion = Tiempo.getActualTime() ;}
	//Editar contenido
	public Contenido getContenido() {return contenido;}
	public void setContenido(Contenido contenido) {this.contenido = contenido;}
}
