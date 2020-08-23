//Importaciones
package modelo;
//import control.tiempo;

public class archivo {
	//Atributos
	private String nombre;
	private String fechaCreacion;
	private String fechaUltimaModificacion;
	private String[] contenido;
	
	//Constructores
	public archivo() {
		
	}
	//Setters and Getters
	//Nombre
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	//Fecha creacion
	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		tiempo fecha = new tiempo();
		this.fechaCreacion = fecha.actualTime;
	}
	
	public String getFechaUltimaModificacion() {
		return fechaUltimaModificacion;
	}
	public void setFechaUltimaModificacion(String fechaUltimaModificacion) {
		this.fechaUltimaModificacion = fechaUltimaModificacion;
	}

	public String [] getContenido() {
		return contenido;
	}

	public void setContenido(String[] contenido) {
		this.contenido = contenido;
	}
	

}
