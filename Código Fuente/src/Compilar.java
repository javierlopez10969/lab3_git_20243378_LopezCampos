import java.io.IOException;

public class Compilar {
	public static void main(String[] args) {
		String sSistemaOperativo = System.getProperty("os.name");
		System.out.println(sSistemaOperativo);
		switch (sSistemaOperativo) {
		case "Linux":
			try {
				String cmd = "halt"; //Comando de apagado en linux
				Runtime.getRuntime().exec(cmd); 
			} catch (IOException ioe) {
				System.out.println (ioe);
			}
			break;
		case "Windows":
			try {
				String [] cmd = {"shutdown","-s","-t", "10"}; //Comando de apagado en windows
				Runtime.getRuntime().exec(cmd);
			} catch (IOException ioe) {
				System.out.println (ioe);
			}
			break;

		default:
			break;
		}

	}
}
