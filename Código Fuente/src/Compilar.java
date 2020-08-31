import java.io.IOException;

public class Compilar {
	public static void main(String[] args) {
		String compilar = "javac ./modelo/Menu.java";
		String compilar2 = "javac ./utils/Contenido.java ./utils/ListaDeArchivos.java ./modelo/Menu.java ./modelo/Index.java ./modelo/Archivo.java ./modelo/MiArchivo.java ./modelo/MiCommit.java ./modelo/MiIndex.java ./modelo/MiRepositorio.java ./modelo/MiWorkspace.java ./modelo/Commits.java ./modelo/Repositorio.java ./modelo/Tiempo.java ./modelo/Workspace.java";
		String sSistemaOperativo = System.getProperty("os.name");
		System.out.println("Su sistema operativo es : "+sSistemaOperativo);
		switch (sSistemaOperativo) {
		case "Linux":
			try {
				System.out.println("Compilando ..");
				Runtime.getRuntime().exec(compilar); 
				Runtime.getRuntime().exec(compilar2); 
				System.out.println("Programa Compilado");
			} catch (IOException ioe) {
				System.out.println ("Algo salio mal :C" + ioe);
			}
			break;
		case "Windows":
			try {
				//String [] cmd = {"shutdown","-s","-t", "10"}; //Comando de apagado en windows
				Runtime.getRuntime().exec(compilar);
				Runtime.getRuntime().exec(compilar2); 
			} catch (IOException ioe) {
				System.out.println ("Algo salio mal :C" + ioe);
			}
			break;

		default:
			break;
		}

	}
}
