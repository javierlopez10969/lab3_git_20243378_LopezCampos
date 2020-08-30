import java.io.IOException;

public class Compilar {
	public static void main(String[] args) {
		String sSistemaOperativo = System.getProperty("os.name");
		System.out.println(sSistemaOperativo);
		switch (sSistemaOperativo) {
		case "Linux":
			try {
				System.out.println("Compilando .. \n");
				String compilar = "javac ./utils/Contenido.java ./utils/ListaDeArchivos.java ./modelo/Menu.java ./modelo/Index.java ./modelo/Archivo.java ./modelo/MiArchivo.java ./modelo/MiCommit.java ./modelo/MiIndex.java ./modelo/MiRepositorio.java ./modelo/MiWorkspace.java ./modelo/PilaCommit.java ./modelo/Repositorio.java ./modelo/Tiempo.java ./modelo/Workspace.java";
				Runtime.getRuntime().exec(compilar); 
				String ejecutar = "java .modelo.Main";
				Runtime.getRuntime().exec(ejecutar); 
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
