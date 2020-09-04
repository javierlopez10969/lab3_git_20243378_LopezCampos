package modelo;

import java.util.Scanner;

public class Branches {
	//Rama master o rama 
	private MiRepositorio master;
	//Total de ramas
	private int tamano;
	
	/**
	 * Constructor de las distitnas ramas a partir 
	 * @param master
	 */
	public Branches(MiRepositorio master){
		setMaster(master);
		//Decimos que el tamaño total de branches es uno
		setTamano(1);
	}
	
	public MiRepositorio gitBranch() {
		System.out.println("¿Cuál es el nombre de su rama nueva a crear a partir de master ? \n");
		String respueString = "";
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		try {
			respueString = scanner.nextLine();
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error "+ e + "\n");
		}
		//Decimos que la nueva Branch es exactamente igual a como ha quedado master
		MiRepositorio newBranch = getMaster();
		//Seteamos el nombre de la nueva branch
		newBranch.setBranch(respueString);
		//Y preguntamos si quiere seguir con el mismo autor o uno nuevo
		System.out.println("¿Quiere cambiar de autor? \n"+
		"Sí / no \n");
		try {
			respueString = scanner.nextLine();
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error \n"+ e);
		}
		if (respueString.equals("si") || respueString.equals("Si") || respueString.equals("YES")
		|| respueString.equals("1") || respueString.equals("SIPO") || respueString.equals("yes")
		|| respueString.equals("YES") || respueString.equals("Sí") ) {
			System.out.println("Ingrese el nombre de su autor :\n");
			try {
				respueString = scanner.nextLine();
			} catch (Exception e) {
				System.out.println("Ha ocurrido un error \n"+ e);
			}
			newBranch.setAutor(respueString);
		}
		System.out.println("Autor : " + newBranch.getBranch() + "\n" +
		"Nueva Branch creada : \n" + newBranch.gitStatus());
		insertarBranch(newBranch);
		//Devolvemos la ultima branch
		return getBranchN(getTamano()-1) ;
	}
	
	public void insertarBranch(MiRepositorio newBranch) {
		if (getTamano() == 1) {
			master.setSiguiente(newBranch);
			setTamano(getTamano() + 1);
		}else {
			//Iniciamos un iterador en 0 y un puntero de los distintos repositorios
			int i = 1;
			MiRepositorio punteroMiRepositorio = getMaster();
			while (i<getTamano() && punteroMiRepositorio !=null) {
				punteroMiRepositorio = punteroMiRepositorio.getSiguiente();
				i++;
			}
			punteroMiRepositorio.setSiguiente(newBranch);
			setTamano(getTamano() + 1);
		}
	}
	
	public MiRepositorio gitCheckOut() {
		if (getTamano() == 1) {
			System.out.println("Actualmente solo hay una rama, para hacer checkout, deberá crear una rama nueva\n");
			return getMaster();
		}else {
			System.out.println("Estás son sus ramas : \n" +
			branches2String() +
			"\n Eliga el indice : de la branch que quiere cambiarse ");
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			int n = 0;
			try {
				n = scanner.nextInt();
			} catch (Exception e) {
				System.out.println("Ha ocurrido un error"+ e +"\n");
			}
			if (n > getTamano() || n < 0) {
				System.out.println("El indice ingresado supera los limites \n" + 
				"Volviendo a Maste \n");
				return getMaster();
			}
			return getBranchN(n);

		}
	}
	
	
	public MiRepositorio getBranchN(int n) {
		if (n == 0) {
			return getMaster();
		}else {
			int i = 0 ;
			//Obtener el repositori segun la branch
			MiRepositorio punteroMiRepositorio = getMaster();
			while (i < n && i < getTamano() && punteroMiRepositorio != null) {
				punteroMiRepositorio = punteroMiRepositorio.getSiguiente();
				i++;
			}
			return punteroMiRepositorio;
		}
	}
	
	public String branches2String() {
		int i = 0; String salidaString ="";
		MiRepositorio punteroMiRepositorio = getMaster();
		while (i < getTamano() && punteroMiRepositorio!= null) {
			salidaString = salidaString + i + ".-\n" +  punteroMiRepositorio.gitStatus(); 
			punteroMiRepositorio = punteroMiRepositorio.getSiguiente();
			i++;
			
		}
		return salidaString;
	}
	
	
	
	//Getters and Setters
	public MiRepositorio getMaster() {return master;}
	public void setMaster(MiRepositorio master) {this.master = master;}
	public int getTamano() {return tamano;}
	public void setTamano(int tamano) {this.tamano = tamano;}
}
