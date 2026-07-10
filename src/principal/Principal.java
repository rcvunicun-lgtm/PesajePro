package principal;

import java.awt.EventQueue;
import java.io.IOException;
import java.net.ServerSocket;

import vistasFrame.Frame;

public class Principal {
	
	private static ServerSocket socket;
	private static final int PUERTO_UNICO = 54321;


	private static boolean yaEstaCorriendo() {
		try {
			socket = new ServerSocket(PUERTO_UNICO); // Usa un puerto no reservado
			return false;
		} catch (IOException e) {
			return true;
		}
	}
	
	public static void main(String[] args) {
		
		if (yaEstaCorriendo()) {
			//System.out.println("Ya hay una instancia en ejecución.");
			return;
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();	
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

/*
  ##### Este es el comando que estoy usando en VM arguments de eclipse #####
  
  --module-path "src\lib\openjfx-11.0.2_windows-x64_bin-sdk\javafx-sdk-11.0.2\lib" 
  --add-modules javafx.base,javafx.controls,javafx.fxml,javafx.graphics,javafx.media,javafx.swing,javafx.web,javafx.swt
 
 
  ##### Para que el comando de ejecucion de java funcione el archivo .jar debe estar extraido #####
 
 	Este comando se debe usar cuando ejecutamos la aplicación desde CMD
 
 		java --module-path "lib\openjfx-11.0.2_windows-x64_bin-sdk\javafx-sdk-11.0.2\lib" --add-modules javafx.base,javafx.controls,javafx.fxml,javafx.graphics,javafx.media,javafx.swing,javafx.web -classpath "lib/jSerialComm-2.11.0.jar;lib/poi-3.16.jar" -jar AplicacionDePesaje.jar 
 	
 		java --module-path "D:\Descargas\Eclipse Complementos\javaFX\JavaFx11.0.2\openjfx-11.0.2_windows-x64_bin-sdk\javafx-sdk-11.0.2\lib" --add-modules javafx.base,javafx.controls,javafx.fxml,javafx.graphics,javafx.media,javafx.swing,javafx.web -classpath "lib/jSerialComm-2.11.0.jar;lib/poi-3.16.jar" -jar AplicacionDePesaje.jar 
 
 
  ##### Este comando se debe usar cuando estemos pasando el parametro de JVM options en Launch4j #####
 
 	--module-path "lib\openjfx-11.0.2_windows-x64_bin-sdk\javafx-sdk-11.0.2\lib" 
	--add-modules javafx.base,javafx.controls,javafx.fxml,javafx.graphics,javafx.media,javafx.swing,javafx.web,javafx.swt
 
 */


/*
 
 -Djava.library.path=src\lib\jacob-1.21\
 
 
String rutaRelativa = "src/lib/jacob-1.21/jacob.dll";
File dll = new File(rutaRelativa);
System.load(dll.getAbsolutePath());

 */
