package utils;
import modelo.Archivo;

/*
 * Clase del tipo lista enlazada, la cual guarda todos los archivos posibles sin un limite
 * Sus atributos son el primer archivo de la lista
 * */
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
		setCabeza(nodo);		
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
	
	//Añadir archivo
	public void añadirArchivo(Archivo myArchivo) {
		if (isEmpty()) {
			insertarPrincipio(myArchivo);
		}else {
			insertarFinal(myArchivo);
		}
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
	
	public Boolean isEmpty() {return tamano == 0;}
	
	public String archivos2String() {
		if (!isEmpty()) {
			nodoArchivo puntero =  getCabeza();
			String salidaString = "";
			int i = 0 ;
			while (puntero != null) {
				salidaString = salidaString +"i :"+ i +".-";
				salidaString = salidaString + puntero.myArchivo.Archivo2String();
				puntero = puntero.getSiguiente();
				i++;
			}
			return (salidaString +"\n");
		}else {
			return("Lista de archivos vacía\n");
		}
	}
	
	public String nombreFechas2String() {
		if (!isEmpty()) {
			String salidaString ="";
			nodoArchivo puntero =  getCabeza();
			int i = 0 ;
			while (puntero != null) {
				salidaString = salidaString + "i :"+ i;
				salidaString = salidaString + puntero.myArchivo.nombresFechas2String();
				puntero = puntero.getSiguiente();
				i++;
			}
			return (salidaString +"\n");
		}else {
			return ("Workspace vacío\n");
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
	//Metodo que consulta si un archivos se encuentra dentro de otra lista de archivos
	public Boolean isInside(Archivo archivo) {
		nodoArchivo puntero = getCabeza();
		while (puntero != null) {
			//Comparamos solo con el nombre
			System.out.println("Name archivo : " + archivo.getNombre());
			System.out.println("Name puntero : " + puntero.myArchivo.getNombre()+ "\n");
			if (archivo.getNombre().equals(puntero.myArchivo.getNombre())) {
				System.out.println("El archivo ya se encuentra en la lista de archivos\n");
				return true;
			}else {
				puntero = puntero.getSiguiente();	
			}	
		}
		return false;
	}
	//Setter and getters
	public nodoArchivo getCabeza() {return cabeza;}
	public void setCabeza(nodoArchivo cabeza) {	this.cabeza = cabeza;}
	public int getTamano() {return tamano;}
	public void setTamano(int tamano) {this.tamano = tamano;}
}
