package principal;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class RutaGuardada {

    // Método para guardar la ruta seleccionada en un archivo de texto
	public static void guardarRuta(String ruta) {
	    // Verificar si la carpeta "archivosComplementarios" existe
	    File carpeta = new File("archivosComplementarios");
	    if (!carpeta.exists()) {
	        // Si no existe, crearla
	        if (!carpeta.mkdir()) {
	            // Si no se puede crear la carpeta, no se hace nada más.
	            return;
	        }
	    }

	    // Crear el archivo "ruta_guardada.txt" dentro de la carpeta
	    try (BufferedWriter writer = new BufferedWriter(new FileWriter("archivosComplementarios/ruta_guardada.txt"))) {
	        writer.write(ruta); // Guardar la ruta en el archivo
	    } catch (IOException e) {
	        // En caso de error, puedes registrar o manejar el error aquí si es necesario.
	        e.printStackTrace(); // O bien, podrías registrar el error en un archivo de log.
	    }
	}


    // Método para leer la ruta guardada desde el archivo
    public static String leerRuta() {
        File archivo = new File("archivosComplementarios/ruta_guardada.txt");
        if (archivo.exists()) {
            try {
                return new String(java.nio.file.Files.readAllBytes(archivo.toPath())); // Leer el contenido del archivo
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ""; // Si no existe el archivo, devolver vacío
    }

    // Método para eliminar el archivo de la ruta guardada
    public static boolean eliminarFichero() {
        File fichero = new File("archivosComplementarios/ruta_guardada.txt");

        // Verifica si el archivo existe antes de intentar eliminarlo
        if (fichero.exists()) {
            boolean eliminado = fichero.delete();
            return eliminado; // Retorna true si se eliminó, false si no
        } else {
            return false; // Retorna false si el archivo no existe
        }
    }
}
