package utils;


public class Contenido {
	//Atributos
	//Cabeza de la lista
	private Lineas Cabeza = null;
	private int tamano ;
	
	//Creamos la clase nodo, una clase interna de lista enlazada
	private class Lineas{
		//Atributos
		private String Linea;
		private Lineas siguiente = null;
		private int Indice;
		
		//Metodos
		//Constructor
		public Lineas(String Linea) {this.setLinea(Linea);}
		
		//Setters and Getters
		public String getLinea() {return Linea;}
		public void setLinea(String Linea) {
			this.Linea = Linea;
		}
		public Lineas getSiguiente() {return siguiente;}
		public void setSiguiente(Lineas siguiente) {this.siguiente = siguiente;}
		public int getIndice() {return Indice;}
		public void setIndice(int indice) {Indice = indice;}

	}
	
	//Metodos
	public void insertarPrincipio(String linea){
		Lineas nodo = new Lineas(linea);
		//El siguiente elmenento es la cabeza
		nodo.setSiguiente(Cabeza);
		//Y la nueva cabeza es el nodo
		this.Cabeza = nodo;		
		//Seteamos el indice del nodo como 1
		nodo.setIndice(0);
		//Actualizamos el tamaño de la lista
		setTamano(tamano + 1);
	}
	
	//Insertar al final
	public void insertarFinal(String linea) {
		Lineas nodo = new Lineas(linea);
		Lineas puntero = getCabeza() ;
		if (puntero == null) {
			setCabeza(nodo);
		}else {
			int i;
			i = 1 ;
			//Mientras no llegemos al final del puntero
			while(puntero.siguiente !=null) {
				puntero = puntero.getSiguiente();
				i ++;
			}
			//Una vez llegado al final, asignamos el nuevo nodo
			puntero.setSiguiente(nodo);	
			//Seteamos el indice en donde se ecnuentra la linea
			nodo.setIndice(i);				
		}
		setTamano(tamano +1);
	}
	
	//Insertar en un indice n
	public void insertarN(int n,String linea) {
		Lineas nodo = new Lineas(linea);
		Lineas puntero = getCabeza() ;
		//Preguntamos si la cabeza no se encuenta vacía
		if (puntero == null) {
			//Si se encuentra la ingresamos al inicio, e ignoramos el n
			//Contenido vacío
			setCabeza(nodo);
			nodo.setIndice(0);
			setTamano(tamano+1);
		}else if (n > getTamano()) {
			insertarFinal(linea);
		}else if (puntero != null){
			System.out.println("Insert N \n");
			int i;
			i = 0 ;
			//Mientras no llegemos al final del puntero
			while(i < n && puntero !=null) {
				System.out.println("i :"+ i +" linea :" +puntero.getLinea());
				puntero = puntero.getSiguiente();
				i ++;
			}
			//Seteamos el siguiente valor del puntero
			nodo.setSiguiente(puntero.getSiguiente());
			if (nodo.getSiguiente()!= null) {
				nodo.getSiguiente().setIndice(i+1);
			}
			//Una vez llegado al final, asignamos el nuevo nodo
			puntero.setSiguiente(nodo);	
			//Seteamos el indice en donde se encuentra la linea
			nodo.setIndice(i);
			setTamano(tamano +1);
		}
	}
	//Metodo de mostrar contenido
	public void mostrarContenido() {
		Lineas puntero = getCabeza();
		if (puntero==null) {
			System.out.println("Sin contenido\n");
		}
		while (puntero != null) {
			System.out.println(puntero.getIndice() +" " + puntero.getLinea());
			puntero = puntero.getSiguiente();
		}
	}
	public void borrarLinea(int n) {
		if (getTamano() == 1) {
			setCabeza(null);
			setTamano(tamano -1);	
		}else if (n < tamano) {
			Lineas puntero = getCabeza() ;
			int i = 1; 
			//Mientras no llegemos al final del puntero
			while(puntero.siguiente !=null && i < n) {
				puntero = puntero.getSiguiente();
				i++;
			}
			Lineas borrar = puntero.siguiente;
			puntero.siguiente = borrar.siguiente; 
			borrar.siguiente = null;
			setTamano(tamano -1);	
		}
	}
	
	public Boolean isEmpty() {return tamano == 0;}
	
	//Setters and Getters
	public Lineas getCabeza() {return Cabeza;}
	public void setCabeza(Lineas cabeza) {
		Cabeza = cabeza;
		cabeza.setIndice(0);}
	public int getTamano() {return tamano;}
	public void setTamano(int tamano) {this.tamano = tamano;}
	

}
