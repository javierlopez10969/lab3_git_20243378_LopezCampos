package modelo;

import utils.Contenido;

public interface Archivo {
	public String nombresFechas2String();
	public String Archivo2String();
	public void editarArchivo() throws InterruptedException;
	//Setters and getters
	//Nombre del archivo
	public String getNombre();
	public void setNombre(String nombre) ;
	//Fecha creacion
	public String getFechaCreacion();
	public void setFechaCreacion();
	public void setFechaCreacion(String newFecha);
	//Fecha modificacion
	public String getFechaUltimaModificacion() ;
	public void setFechaUltimaModificacion();
	public void setFechaUltimaModificacion(String newFecha);
	//Editar contenido
	public Contenido getContenido() ;
	public void setContenido(Contenido contenido);
}
