package principal;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DynamicExcelReader {

    public static List<Object[]> leerExcel(String filePath) {
        List<Object[]> filasExcel = new ArrayList<>();
        File file = new File(filePath);

        if (!file.exists()) {
            return filasExcel; // Retorna una lista vacía si el archivo no existe
        }

        try (FileInputStream fis = new FileInputStream(file)) {
            try (Workbook workbook = new XSSFWorkbook(fis)) {
                Sheet sheet = workbook.getSheetAt(0);  // Leer la primera hoja

                // Si no hay filas, retorna lista vacía
                if (sheet.getLastRowNum() == 0) {
                    return filasExcel;
                }

                // Iterar sobre las filas, empezando desde la segunda (índice 1)
                for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                    Row row = sheet.getRow(i);
                    if (row == null)
                        continue;

                    Object[] nuevaFila = new Object[15];  // 14 columnas esperadas
                    for (int j = 0; j < 15; j++) {  // Recorrer cada celda
                        Cell cell = row.getCell(j);
                        if (cell == null) {
                            nuevaFila[j] = null;
                            continue;
                        }
                        switch (cell.getCellType()) {
                            case STRING:
                                nuevaFila[j] = cell.getStringCellValue();
                                break;
                            case NUMERIC:
                                if (j == 0) { // Supongamos que la primera columna es para un registro que debería ser un entero
                                    // Verificamos si el valor es un número entero y lo convertimos
                                    if (cell.getNumericCellValue() == Math.floor(cell.getNumericCellValue())) {
                                        nuevaFila[j] = (int) cell.getNumericCellValue(); // Convertir a Integer si es un número entero
                                    } else {
                                        nuevaFila[j] = (int) cell.getNumericCellValue(); // Si no, convertir a Integer también
                                    }
                                } else if (j == 7) { // Suponiendo que el peso está en la columna 7, que debe ser un Double
                                    nuevaFila[j] = cell.getNumericCellValue(); // Mantener como Double
                                } else {
                                    nuevaFila[j] = cell.getNumericCellValue(); // Para otras columnas numéricas
                                }
                                break;
                            case BOOLEAN:
                                nuevaFila[j] = cell.getBooleanCellValue();
                                break;
                            case FORMULA:
                                nuevaFila[j] = cell.getCellFormula();
                                break;
                            case BLANK:
                                nuevaFila[j] = null;
                                break;
                            default:
                                nuevaFila[j] = null;
                        }
                    }

                    filasExcel.add(nuevaFila);  // Agregar fila procesada
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return filasExcel;
    }
}
