package utils;
import modelo.Archivo;

public class ListaDeArchivos {
	//Atributos
	//Cabeza de la lista
	private nodoArchivo cabeza = null;
	private int tamano ;
	
	//Creamos la clase nodo, una clase interna de lista enlazada
	private class nodoArchivo{
		@SuppressWarnings("unused")
		private Archivo myArchivo;
		private nodoArchivo siguiente = null;
		
		public nodoArchivo(Archivo myArchivo ) {this.setMyArchivo(myArchivo);}
		//public archivo getMyArchivo() {return myArchivo;}
		public void setMyArchivo(Archivo myArchivo) {this.myArchivo = myArchivo;}
		public nodoArchivo getSiguiente() {return siguiente;}
		public void setSiguiente(nodoArchivo siguiente) {this.siguiente = siguiente;}
	}
	
	//Metodos
	public void insertarPrincipio(Archivo myArchivo){
		nodoArchivo nodo = new nodoArchivo(myArchivo);
		//El siguiente elmenento es la cabeza
		nodo.siguiente = cabeza;
		//Y la nueva cabeza es el nodo
		cabeza = nodo;		
		//Actualizamos el tamaño de la lista
		setTamano(tamano + 1);
	}
	
	//Insertar al final
	public void insertarFinal(Archivo myArchivo) {
		nodoArchivo nodo = new nodoArchivo(myArchivo) ;
		nodoArchivo puntero = getCabeza() ;
		//Mientras no llegemos al final del puntero
		while(puntero.siguiente !=null) {
			puntero = puntero.getSiguiente();}
		//Una vez llegado al final, asignamos el nuevo nodo
		puntero.setSiguiente(nodo);	
		setTamano(tamano +1);		
	}
	
	public boolean isEmpty() {
		return tamano == 0;
	}
	
	//Setter and getters
	public nodoArchivo getCabeza() {return cabeza;}
	public void setCabeza(nodoArchivo cabeza) {	this.cabeza = cabeza;}
	public int getTamano() {return tamano;}
	public void setTamano(int tamano) {this.tamano = tamano;}
}
