package principal;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.CellStyle;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Excel {

    public static void crearExcelXlsx(ArrayList<Object[]> datosFiltrados, String nomArchivoExcel, String path) {
        try (XSSFWorkbook workbook = new XSSFWorkbook()) {
            // Crear una hoja dentro del libro
            XSSFSheet sheet = workbook.createSheet("Datos");

            // Crear un estilo para los encabezados (negrita)
            Font negritaFont = workbook.createFont();
            negritaFont.setBold(true);  // Poner la fuente en negrita
            CellStyle headerStyle = workbook.createCellStyle();
            headerStyle.setFont(negritaFont);

            // Crear la primera fila para los encabezados (fila 0)
            XSSFRow headerRow = sheet.createRow(0);

            // Definir los encabezados (titulos de las columnas)
            String[] encabezados = {"Contador", "Nombre Cápsula", "Tipo", "ID Muestra", "Ensayo", "Medio", "Identificación", "Volumen", "Peso Neto", "Temperatura", "Fecha", "Hora", "Usuario", "Serial Balanza"};

            // Crear las celdas de la fila de encabezado y aplicar el estilo
            for (int i = 0; i < encabezados.length; i++) {
                headerRow.createCell(i).setCellValue(encabezados[i]);
                headerRow.getCell(i).setCellStyle(headerStyle);
            }

            // Crear las filas y columnas a partir de los datos filtrados
            for (int i = 0; i < datosFiltrados.size(); i++) {
                XSSFRow row = sheet.createRow(i + 1); // Crear una nueva fila (empezando desde la fila 1)

                Object[] filaDatos = datosFiltrados.get(i);

                for (int j = 0; j < filaDatos.length; j++) {
                    Object dato = filaDatos[j];
                    if (dato instanceof Number) {
                        row.createCell(j).setCellValue(((Number) dato).doubleValue());
                    } else if (dato instanceof Boolean) {
                        row.createCell(j).setCellValue((Boolean) dato);
                    } else {
                        row.createCell(j).setCellValue(dato.toString());
                    }
                }
            }

            // Ajustar el ancho de las columnas automáticamente
            for (int i = 0; i < sheet.getRow(0).getPhysicalNumberOfCells(); i++) {
                sheet.autoSizeColumn(i);
            }

            // Guardar el archivo Excel
            try (FileOutputStream fileOut = new FileOutputStream(path)) {
                workbook.write(fileOut);
                JOptionPane.showMessageDialog(null, "Archivo Excel creado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Hubo un error al crear el archivo", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
	public static boolean eliminarArchivo(String rutaArchivo) {
		File archivo = new File(rutaArchivo);

		// Verificar si el archivo existe
		if (archivo.exists()) {
			// Intentar eliminar el archivo
			if (archivo.delete()) {
				//System.out.println("Archivo eliminado exitosamente: " + rutaArchivo);
				return true;
			} else {
				//System.err.println("No se pudo eliminar el archivo: " + rutaArchivo);
				return false;
			}
		} else {
			//System.out.println("El archivo no existe: " + rutaArchivo);
			return false;
		}
	}
}