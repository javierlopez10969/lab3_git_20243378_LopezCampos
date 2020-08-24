package modelo;
import java.text.SimpleDateFormat;
import java.util.Date; 


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
