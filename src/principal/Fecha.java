package principal;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Fecha {

    // Constructor vacío opcional (puede omitirse si todo es estático)
    public Fecha() {}

    // Método para obtener solo la fecha en formato dd/MM/yyyy
    public static String obtenerFechaActual() {
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return fechaHoraActual.format(formatoFecha);
    }

    // Método para obtener solo la hora en formato HH:mm:ss
    public static String obtenerHoraActual() {
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");
        return fechaHoraActual.format(formatoHora);
    }
}
