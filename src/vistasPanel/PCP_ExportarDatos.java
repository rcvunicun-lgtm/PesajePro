package vistasPanel;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import renderizarBotonJTable.TablaPersonalizada;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.util.ArrayList;

public class PCP_ExportarDatos extends JPanel {

	private TablaPersonalizada tablaDatos;
	private JButton btnExportar;

	public PCP_ExportarDatos(ArrayList<Object[]> datosFiltrados) {
		setLayout(new BorderLayout(0, 0));
		setMinimumSize(new Dimension(100, 50));

		/*-------------------------------------Contendor principal------------------------------------------------*/
		JPanel PanelCuerpoVistaTextoContenedor = new JPanel();
		PanelCuerpoVistaTextoContenedor.setLayout(new BorderLayout(0, 0));

		/*-------------------------------------Contenedor encabezado------------------------------------------------*/
		JPanel panelCuerpoVistaTextoContenedorEncabezado = new JPanel();

		JLabel lblTitulo_pan_CVTCE = new JLabel("DATOS A  EXPORTAR");

		panelCuerpoVistaTextoContenedorEncabezado.add(lblTitulo_pan_CVTCE);

		/*-------------------------------------Contenedor de la tabla----------------------------------------*/
		JPanel panelCuerpoVistaTextoContenedorTabla = new JPanel();
		panelCuerpoVistaTextoContenedorTabla.setLayout(new BorderLayout(10, 100));

		tablaDatos = new TablaPersonalizada(datosFiltrados);
		
		panelCuerpoVistaTextoContenedorTabla.add(tablaDatos, BorderLayout.CENTER);

		/*----------Crea un JScrollPane que envuelve el JPanel (panelCuerpoVistaTextoContenedorTabla)-------------*/
		JScrollPane scrollPane = new JScrollPane(panelCuerpoVistaTextoContenedorTabla);

		/*-------------------------Agregamos los paneles al contenedor principal----------------------------------*/
		PanelCuerpoVistaTextoContenedor.add(panelCuerpoVistaTextoContenedorEncabezado, BorderLayout.NORTH);
		PanelCuerpoVistaTextoContenedor.add(scrollPane, BorderLayout.CENTER);

		add(PanelCuerpoVistaTextoContenedor);

		JPanel panelPiePagina_CVTE = new JPanel();
		PanelCuerpoVistaTextoContenedor.add(panelPiePagina_CVTE, BorderLayout.SOUTH);

		// Crear un botón con un ícono y texto
		btnExportar = new JButton("Exportar");

		// Cargar la imagen excel
		ImageIcon originalIconExcel = new ImageIcon(PCP_ExportarDatos.class.getResource("/recursos/excel.png"));

		// Redimensionar la imagen
		Image imgExcel = originalIconExcel.getImage();
		Image resizedImgExcel = imgExcel.getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH); // Ajusta el tamaño
																									// (16x16 en este
																									// caso)
		// Crear un nuevo ImageIcon con la imagen redimensionada
		ImageIcon resizedIconExcel = new ImageIcon(resizedImgExcel);

		// Establecer el ícono al botón
		btnExportar.setIcon(resizedIconExcel);

		// Configurar la posición del ícono para que esté a la izquierda del texto
		btnExportar.setHorizontalTextPosition(SwingConstants.RIGHT); // Texto a la derecha
		btnExportar.setVerticalTextPosition(SwingConstants.CENTER); // Centrado verticalmente

		panelPiePagina_CVTE.add(btnExportar);

	}

	public TablaPersonalizada getTablaDatos() {
		return tablaDatos;
	}

	public JButton getBtnExportar() {
		return btnExportar;
	}
}