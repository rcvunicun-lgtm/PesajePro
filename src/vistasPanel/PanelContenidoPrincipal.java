package vistasPanel;

import javax.swing.JPanel;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

public class PanelContenidoPrincipal extends JPanel {

	private PCP_DatosBalanza pcp_datosBalanza;
	private PCP_TextoBalanza pcp_textBalanza;
	private PCP_ExportarDatos pcp_exportarDatos;
	private PCP_ResumenExportados pcp_resumenExportados;
	
	private JSplitPane splitPaneHorizontal;
	private JSplitPane splitPaneHorizontal2;
	private JSplitPane splitPaneVertical;
	

	public PanelContenidoPrincipal(ArrayList<Object[]> datosFiltrados) {
				
		   // Obtener tamaño de pantalla
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width / 3; // Dividir en tres partes iguales para un diseño equilibrado
        int height = screenSize.height / 4;

        // Instanciar los paneles
        pcp_datosBalanza = new PCP_DatosBalanza();
        pcp_textBalanza = new PCP_TextoBalanza();
        pcp_exportarDatos = new PCP_ExportarDatos(datosFiltrados);
        pcp_resumenExportados = new PCP_ResumenExportados();
  

        // Crear un panel horizontal para pcp_datosBalanza y pcp_textBalanza
        splitPaneHorizontal = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pcp_datosBalanza, pcp_textBalanza);
        splitPaneHorizontal.setDividerLocation(width / 2); // Ajustar para hacer pcp_datosBalanza más pequeño
        splitPaneHorizontal.setResizeWeight(0); // Asignar más espacio inicial a pcp_textBalanza, Por defecto tiene el tamaño de setMinimumSize de la clase PCP_DatosBalanza
        // Establecer el tamaño mínimo para pcp_textBalanza (esto evitará que se reduzca más allá de cierto punto)
      
    
        // Crear un panel horizontal para agregar pcp_exportarDatos
        splitPaneHorizontal2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, splitPaneHorizontal, pcp_exportarDatos);
        splitPaneHorizontal2.setDividerLocation(width * 2); // Ajustar para incluir exportarDatos
        splitPaneHorizontal2.setResizeWeight(0.47); // Más espacio inicial al lado izquierdo

        // Crear un panel vertical para colocar splitPaneHorizontal2 y pcp_resumenExportados
        splitPaneVertical = new JSplitPane(JSplitPane.VERTICAL_SPLIT, splitPaneHorizontal2, pcp_resumenExportados);
        splitPaneVertical.setDividerLocation(height); // Ajusta según necesidad
        splitPaneVertical.setResizeWeight(0.72); // 72% para la parte superior

        // Agregar splitPaneVertical al panel principal
        setLayout(new BorderLayout());
        add(splitPaneVertical, BorderLayout.CENTER);
	}
	
	public PCP_DatosBalanza getPCP_DatosBalanza() {
		return this.pcp_datosBalanza;
	}
	
	public PCP_TextoBalanza getPCP_TextoBalanza() {
		return this.pcp_textBalanza;
	}
	
	public PCP_ExportarDatos getPCP_ExportarDatos() {
		return this.pcp_exportarDatos;
	}

	public PCP_ResumenExportados getPCP_ResumenExportados() {
		return this.pcp_resumenExportados;
	}
	
	public JSplitPane getSplitPaneHorizontal() {
		return splitPaneHorizontal;
	}

	public JSplitPane getSplitPaneHorizontal2() {
		return splitPaneHorizontal2;
	}

	public JSplitPane getSplitPaneVertical() {
		return splitPaneVertical;
	}
}