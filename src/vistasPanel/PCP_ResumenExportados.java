package vistasPanel;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class PCP_ResumenExportados extends JPanel {

	private DefaultTableModel modeloTablaResultados;
	private JTable tablaResultados;
	
	public PCP_ResumenExportados() {
		setLayout(new BorderLayout(0, 0));
		setMinimumSize(new Dimension(200, 100));

		/*-------------------------------------Contendor principal------------------------------------------------*/
		JPanel PanelCuerpoVistaTextoContenedor = new JPanel();
		PanelCuerpoVistaTextoContenedor.setLayout(new BorderLayout(0, 0));
		     
/*-------------------------------------Contenedor encabezado------------------------------------------------*/
        JPanel panelCuerpoVistaTextoContenedorEncabezado = new JPanel();
      
        JLabel lblNewLabel = new JLabel("ARCHIVOS DE EXCEL CREADOS");
        
        panelCuerpoVistaTextoContenedorEncabezado.add(lblNewLabel);
        
/*-------------------------------------Contenedor de la tabla----------------------------------------*/
        JPanel panelCuerpoVistaTextoContenedorTabla = new JPanel();
        panelCuerpoVistaTextoContenedorTabla.setLayout(new BorderLayout(10,100));
        
     // Datos de la tabla
        String[] columnNames = {"Numero", "Nombre fichero texto", "Nombre archivo excel exportado", "Ruta", "Fecha de creación"};

        // Datos de la tabla
        Object[][] data = {{" ", "Nombre archivo excel exportado", "Ruta", "Fecha de creación"}};

        // Modelo de tabla
        modeloTablaResultados = new DefaultTableModel(data, columnNames);
        tablaResultados = new JTable(modeloTablaResultados);

        // Ajustes de apariencia de la tabla
        tablaResultados.setFont(new Font("Arial", Font.PLAIN, 12));  // Fuente más similar a Excel
        tablaResultados.setRowHeight(25);  // Altura de fila similar a Excel
        tablaResultados.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));  // Fuente de encabezado más grande
        tablaResultados.getTableHeader().setBackground(new Color(221, 235, 247));  // Color azul claro de Excel
        tablaResultados.getTableHeader().setForeground(new Color(0, 51, 102));  // Color oscuro para el texto del encabezado

        // Renderizado de celdas
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(SwingConstants.CENTER);  // Alineación centrada como en Excel
        cellRenderer.setBackground(new Color(245, 245, 245));  // Color gris claro de fondo de las celdas
        cellRenderer.setForeground(Color.BLACK);  // Texto negro

        // Aplicamos el renderer a todas las columnas
        for (int i = 0; i < tablaResultados.getColumnCount(); i++) {
            tablaResultados.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
        }

        // Bordes de las celdas
        tablaResultados.setGridColor(new Color(204, 204, 204));  // Bordes finos y claros similares a los de Excel
        tablaResultados.setShowGrid(true);  // Asegúrate de que se muestren los bordes

        // Añadir una pequeña sombra al borde de la tabla para darle un aspecto más realista
        tablaResultados.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204), 1));
        

	     // Ajustar el ancho de la primera columna (columna 0)
	     tablaResultados.getColumnModel().getColumn(0).setPreferredWidth(50);  // Establecer el ancho de la primera columna
	     tablaResultados.getColumnModel().getColumn(1).setPreferredWidth(450);  // Establecer el ancho de la primera columna
	     tablaResultados.getColumnModel().getColumn(2).setPreferredWidth(500);  // Establecer el ancho de la primera columna
	     tablaResultados.getColumnModel().getColumn(3).setPreferredWidth(450);  // Establecer el ancho de la primera columna
	     tablaResultados.getColumnModel().getColumn(4).setPreferredWidth(10);  // Establecer el ancho de la primera columna

        panelCuerpoVistaTextoContenedorTabla.add(tablaResultados, BorderLayout.CENTER);
        

/*----------Crea un JScrollPane que envuelve el JPanel (panelCuerpoVistaTextoContenedorTarea)-------------*/
        JScrollPane scrollPane = new JScrollPane(panelCuerpoVistaTextoContenedorTabla);

    
/*-------------------------Agregamos los paneles al contenedor principal----------------------------------*/ 
        PanelCuerpoVistaTextoContenedor.add(panelCuerpoVistaTextoContenedorEncabezado, BorderLayout.NORTH);
        PanelCuerpoVistaTextoContenedor.add(scrollPane, BorderLayout.CENTER);
        
        add(PanelCuerpoVistaTextoContenedor);
	}
	
	public DefaultTableModel getModeloTablaResultados() {
		return modeloTablaResultados;
	}

	public JTable getTablaResultados() {
		return tablaResultados;
	}

}
