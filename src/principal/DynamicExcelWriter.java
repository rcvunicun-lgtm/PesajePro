package principal;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.nio.file.*;
import java.util.List;

public class DynamicExcelWriter {

    private static final String OUTPUT_PATH = "archivosComplementarios/datos_incrementales.xlsx";

    public static int appendRowToExcel(String filePath, List<Object> rowData) {
        InputStream inputStream = DynamicExcelWriter.class.getClassLoader().getResourceAsStream(filePath);
        File tempFile = new File(OUTPUT_PATH);

        try {
            // Crear carpeta si no existe
            File directory = new File("archivosComplementarios");
            if (!directory.exists()) {
                directory.mkdir();
            }

            // Si el archivo no está en recursos
            if (inputStream == null) {
                if (!tempFile.exists()) {
                    Workbook workbook = new XSSFWorkbook(); // Crear workbook sin try-with-resources
                    
                    // Crear hoja y encabezado
                    Sheet sheet = workbook.createSheet("Datos");

                    // Crear encabezado
                    String[] headers = { "# ", "N Capsula", "Tipo", "ID Muestra", "Ensayo", "Medio", "Identificación", "Volumen", 
                                         "Peso Neto", "Temperatura", "Fecha", "Hora", "Usuario", "Balanza" };
                    Row headerRow = sheet.createRow(0); // Fila 0 para encabezado

                    for (int i = 0; i < headers.length; i++) {
                        Cell cell = headerRow.createCell(i);
                        cell.setCellValue(headers[i]);
                    }

                    // Guardar el archivo en el sistema de archivos
                    try (FileOutputStream fileOut = new FileOutputStream(tempFile)) {
                        workbook.write(fileOut);
                    }

                    // Cerrar workbook explícitamente
                    workbook.close(); // Esto previene la advertencia
                }
                return appendRowToExistingFile(rowData, tempFile); // devolver fila
            } else {
                // Copiar desde recursos
                Files.copy(inputStream, tempFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                return appendRowToExistingFile(rowData, tempFile); // devolver fila
            }

        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }



    private static int appendRowToExistingFile(List<Object> rowData, File file) {
        try (FileInputStream fileIn = new FileInputStream(file);
             Workbook workbook = new XSSFWorkbook(fileIn)) { // <-- aquí lo metemos en el try

            Sheet sheet = workbook.getSheetAt(0);
            int newRowNum = sheet.getLastRowNum() + 1;
            Row newRow = sheet.createRow(newRowNum);

            for (int i = 0; i < rowData.size(); i++) {
                Object value = rowData.get(i);
                Cell newCell = newRow.createCell(i);

                if (value instanceof Double) {
                    newCell.setCellValue((Double) value);
                } else if (value instanceof String) {
                    newCell.setCellValue((String) value);
                } else if (value instanceof Integer) {
                    newCell.setCellValue((Integer) value);
                } else {
                    newCell.setCellValue(value != null ? value.toString() : "");
                }
            }

            try (FileOutputStream fileOut = new FileOutputStream(file)) {
                workbook.write(fileOut);
            }

            return newRowNum;

        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }


    public static void eliminarFilaExcel(int fila) {
        File file = new File(OUTPUT_PATH);

        try (FileInputStream fileIn = new FileInputStream(file)) {
            Workbook workbook = new XSSFWorkbook(fileIn); // Usamos XSSFWorkbook para formato .xlsx
            Sheet sheet = workbook.getSheetAt(0);

            int lastRowNum = sheet.getLastRowNum();

            if (fila >= 0 && fila <= lastRowNum) {
                if (fila < lastRowNum) {
                    sheet.shiftRows(fila + 1, lastRowNum, -1);
                } else {
                    Row row = sheet.getRow(fila);
                    if (row != null) sheet.removeRow(row);
                }

                try (FileOutputStream fileOut = new FileOutputStream(file)) {
                    workbook.write(fileOut);
                }

                workbook.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void recrearArchivoExcelSinFilasVacias(String filePath, List<Object[]> datos) {
        try (Workbook workbook = new XSSFWorkbook()) { // Usamos XSSFWorkbook para formato .xlsx
            Sheet sheet = workbook.createSheet("Datos");

            // ✅ Escribir la cabecera fija (ajustá según tus columnas)
            Row headerRow = sheet.createRow(0);
            String[] headers =  { "# ", "N Capsula", "Tipo", "ID Muestra", "Ensayo", "Medio", "Identificación", "Volumen", "Peso Neto", "Temperatura", "Fecha", "Hora", "Usuario", "Balanza"};

            for (int i = 0; i < headers.length; i++) {
                headerRow.createCell(i).setCellValue(headers[i]);
            }

            // 🧠 Agregamos datos desde la fila 1 en adelante (dejando fila 0 para cabecera)
            for (int i = 0; i < datos.size(); i++) {
                Object[] fila = datos.get(i);
                Row row = sheet.createRow(i + 1);

                for (int j = 0; j < fila.length; j++) {
                    Cell cell = row.createCell(j);

                    if (fila[j] instanceof String) {
                        cell.setCellValue((String) fila[j]);
                    } else if (fila[j] instanceof Double) {
                        cell.setCellValue((Double) fila[j]);
                    } else if (fila[j] instanceof Integer) {
                        cell.setCellValue((Integer) fila[j]);
                    } else if (fila[j] != null) {
                        cell.setCellValue(fila[j].toString());
                    }
                }
            }

            try (FileOutputStream out = new FileOutputStream(filePath)) {
                workbook.write(out);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
