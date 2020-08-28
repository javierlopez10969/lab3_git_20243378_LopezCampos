package utils;
import modelo.Archivo;

public class ListaDeArchivos {
	//Atributos
	//Cabeza de la lista
	private nodoArchivo cabeza = null;
	private int tamano ;
	
	//Creamos la clase nodo, una clase interna de lista enlazada
	private class nodoArchivo{
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
	//Metodo que permite borrar una archivo n
	//Entradas : indice n
	//Dominio : {0,tamano}
	public void borrarArchivo(int n) {
		if (n < tamano && n > -1) {
			nodoArchivo puntero = getCabeza() ;
			int i = 1; 
			//Mientras no llegemos al final del puntero
			while(puntero.siguiente !=null && i < n) {
				puntero = puntero.getSiguiente();
				i++;
			}
			nodoArchivo borrar = puntero.siguiente;
			puntero.siguiente = borrar.siguiente; 
			borrar.siguiente = null;
			setTamano(tamano -1);	
		}else {
			System.out.println("Indice supera los limites");
		}

	}
	
	public boolean isEmpty() {return tamano == 0;}
	
	public void mostrarArchivos() {
		if (!isEmpty()) {
			nodoArchivo puntero =  getCabeza();
			int i = 0 ;
			while (puntero != null) {
				System.out.println("i :"+ i +".-");
				puntero.myArchivo.mostrar();
				puntero = puntero.getSiguiente();
				i++;
			}
			System.out.println("\n");
		}else {
			System.out.println("Workspace vacío\n");
		}
	}
	
	public void mostrarNombreFechas() {
		if (!isEmpty()) {
			nodoArchivo puntero =  getCabeza();
			int i = 0 ;
			while (puntero != null) {
				System.out.println("i :"+ i +".-");
				puntero.myArchivo.mostrarNombreFechas();
				puntero = puntero.getSiguiente();
				i++;
			}
			System.out.println("\n");
		}else {
			System.out.println("Workspace vacío\n");
		}
	}

	
	
	//Metodo que dado un indice n, devuelva el archivo correspondiente en la lista
	//De archivos
	//Entradas : indice n 
	public Archivo getArchivoN(int n){
		//Si el n ingresado no supera el tamaño total de archivos
		if (n > tamano || n < 0) {
			System.out.println("El indice excede el total de archivos");
			return null;
		}else{
			nodoArchivo puntero =  getCabeza();
			int i = 0 ;
			//Mientras el puntero no sea nulo
			while (i < n && puntero != null) {
				System.out.println(i+".-");
				puntero = puntero.getSiguiente();
				i++;
			}if (i!= n) {
				System.out.println("No hay archivos disponibles");
				return null;
			}else {
				return puntero.myArchivo;
			}
		}
	}
	
	//Setter and getters
	public nodoArchivo getCabeza() {return cabeza;}
	public void setCabeza(nodoArchivo cabeza) {	this.cabeza = cabeza;}
	public int getTamano() {return tamano;}
	public void setTamano(int tamano) {this.tamano = tamano;}
}
