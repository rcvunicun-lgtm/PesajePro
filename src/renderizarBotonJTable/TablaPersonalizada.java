package renderizarBotonJTable;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class TablaPersonalizada extends JTable {

    private DefaultTableModel modelo;


    public TablaPersonalizada(ArrayList<Object[]> datosFiltrados) {
    	   	
        // Encabezados de columnas
    	String[] columnNames = {
    		    "0", "A", "B", "C", "D", "E", "F", "G",
    		    "H", "I", "J", "K", "L","M", "Actualizar", "Eliminar"
    		};

        // Filas de encabezado (dos primeras filas de referencia visual)
    	Object[][] data = {
    		    { " ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L","M", "Actualizar", "Eliminar" },
    		    { "# ", "N Capsula", "Tipo", "ID Muestra", "Ensayo", "Medio", "Identificación", "Volumen", "Peso Neto", "Temperatura", "Fecha", "Hora", "Usuario", "Balanza", "", "" }
    		};

        modelo = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 14 || column == 15;
            }

        };

        setModel(modelo);

        // Estilo tipo Excel
        getTableHeader().setReorderingAllowed(false);
        getTableHeader().setResizingAllowed(true);
        getTableHeader().setBackground(new Color(169, 169, 169));
        getTableHeader().setForeground(Color.WHITE);

        // Color de cuadrícula suave
        setGridColor(new Color(220, 220, 220));

        // Alineación centrada
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < getColumnCount(); i++) {
            getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        // Tamaño de columnas
        setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        getColumnModel().getColumn(0).setPreferredWidth(30);
        getColumnModel().getColumn(1).setPreferredWidth(80);
        getColumnModel().getColumn(2).setPreferredWidth(80);
        getColumnModel().getColumn(3).setPreferredWidth(120);
        getColumnModel().getColumn(4).setPreferredWidth(120);
        getColumnModel().getColumn(6).setPreferredWidth(120);
        getColumnModel().getColumn(7).setPreferredWidth(80);
        getColumnModel().getColumn(8).setPreferredWidth(80);
        getColumnModel().getColumn(9).setPreferredWidth(80);
        getColumnModel().getColumn(10).setPreferredWidth(80);
        getColumnModel().getColumn(11).setPreferredWidth(120);
        getColumnModel().getColumn(12).setPreferredWidth(120);
        getColumnModel().getColumn(13).setPreferredWidth(120);
        // Altura de filas
        setRowHeight(25);


        // Al final del constructor de TablaPersonalizada
        getColumnModel().getColumn(14).setCellRenderer(new BotonActualizarRenderer());
        getColumnModel().getColumn(14).setCellEditor(new BotonActualizarEditor(new JCheckBox(), datosFiltrados));

        getColumnModel().getColumn(15).setCellRenderer(new BotonEliminarRenderer());
        getColumnModel().getColumn(15).setCellEditor(new BotonEliminarEditor(new JCheckBox(), datosFiltrados));

    }

    public void addRow(Object[] nuevaFila) {
        modelo.addRow(nuevaFila);
    }

    public void limpiarFilas() {
        // Elimina todas las filas excepto las dos primeras (encabezados)
        int totalFilas = modelo.getRowCount();
        for (int i = totalFilas - 1; i >= 2; i--) {
            modelo.removeRow(i);
        }
    }

    public DefaultTableModel getModelo() {
        return modelo;
    }
}