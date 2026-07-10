package vistasPanel;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;

public class PCP_TextoBalanza extends JPanel {

	private  JEditorPane epDatosRecibidos;
	private JButton buttonLimpiarEditorPane;
	
	public PCP_TextoBalanza() {
		setLayout(new BorderLayout(0, 0));
		setMinimumSize(new Dimension(100, 50));
		
		/*-------------------------------------Contendor principal------------------------------------------------*/
				JPanel PanelCuerpoVistaTextoContenedor = new JPanel();
				PanelCuerpoVistaTextoContenedor.setLayout(new BorderLayout(0, 0));
				     
		/*-------------------------------------Contenedor encabezado------------------------------------------------*/
		        JPanel panelCuerpoVistaTextoContenedorEncabezado = new JPanel();
		      
		        JLabel lblNewLabel = new JLabel("INFORMACIÓN RECIBIDA DEL PUERTO COM");
		        
		        panelCuerpoVistaTextoContenedorEncabezado.add(lblNewLabel);
		        
		/*-------------------------------------Contenedor del editorPane----------------------------------------*/
		        JPanel panelCuerpoVistaTextoContenedorTarea = new JPanel();
		        panelCuerpoVistaTextoContenedorTarea.setLayout(new BorderLayout(0, 0));
		        
		        epDatosRecibidos = new JEditorPane();
		        panelCuerpoVistaTextoContenedorTarea.add(epDatosRecibidos, BorderLayout.CENTER);       

		/*----------Crea un JScrollPane que envuelve el JPanel (panelCuerpoVistaTextoContenedorTarea)-------------*/
		        JScrollPane scrollPane = new JScrollPane(panelCuerpoVistaTextoContenedorTarea);
	       
		/*-------------------------------------Contenedor encabezado------------------------------------------------*/
		        JPanel panelCuerpoVistaTextoContenedorPiePagina = new JPanel();
		      		        
		        // Crear un botón con un ícono y texto
		        buttonLimpiarEditorPane = new JButton("Limpiar");
		        
		        // Cargar la imagen excel
		        ImageIcon originalIconText = new ImageIcon(PCP_TextoBalanza.class.getResource("/recursos/hoja-limpia.png"));

		        // Redimensionar la imagen
		        Image imgText = originalIconText.getImage();
		        Image resizedImgText = imgText.getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH); // Ajusta el tamaño (16x16 en este caso)

		        // Crear un nuevo ImageIcon con la imagen redimensionada
		        ImageIcon resizedIconText = new ImageIcon(resizedImgText);
		        
		        // Establecer el ícono al botón
		        buttonLimpiarEditorPane.setIcon(resizedIconText);
		        
		        // Configurar la posición del ícono para que esté a la izquierda del texto
		        buttonLimpiarEditorPane.setHorizontalTextPosition(SwingConstants.RIGHT); // Texto a la derecha
		        buttonLimpiarEditorPane.setVerticalTextPosition(SwingConstants.CENTER);  // Centrado verticalmente
		           
		        panelCuerpoVistaTextoContenedorPiePagina.add(buttonLimpiarEditorPane);
		    
		/*-------------------------Agregamos los paneles al contenedor principal----------------------------------*/ 
		        PanelCuerpoVistaTextoContenedor.add(panelCuerpoVistaTextoContenedorEncabezado, BorderLayout.NORTH);
		        PanelCuerpoVistaTextoContenedor.add(scrollPane, BorderLayout.CENTER);
		        PanelCuerpoVistaTextoContenedor.add(panelCuerpoVistaTextoContenedorPiePagina, BorderLayout.SOUTH);
		        
		        add(PanelCuerpoVistaTextoContenedor);

	}

	public JButton getButtonLimpiarEditorPane() {
		return buttonLimpiarEditorPane;
	}

	public JEditorPane getEpDatosRecibidos() {
		return epDatosRecibidos;
	}
}