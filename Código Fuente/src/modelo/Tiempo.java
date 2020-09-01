package modelo;
import java.text.SimpleDateFormat;
import java.util.Date; 
/*
 * Clase global que no es para instanciar nunca, es solo para obtener la fecha actual en un determinado formato
 * 
 * */

public class Tiempo {
	private static String actualTime;
	
	public static String getActualTime() {
		Tiempo.setActualTime() ;
		return actualTime;
	}
	public static void setActualTime() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		Tiempo.actualTime = formato.format(date);
	}
}
