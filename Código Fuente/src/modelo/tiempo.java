package modelo;
import java.text.SimpleDateFormat;
import java.util.Date; 


public class tiempo {
	public String actualTime;
    public String getTime(){
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        System.out.println(formato.format(date));
        return (formato.format(date));
    }
	public String getActualTime() {
		return actualTime;
	}
	public void setActualTime(String actualTime) {
		this.actualTime = actualTime;
	}
}
