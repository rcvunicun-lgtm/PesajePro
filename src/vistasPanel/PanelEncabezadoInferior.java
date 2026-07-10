package vistasPanel;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import layoutPersonalizado.MyCustomLayout;

public class PanelEncabezadoInferior extends JPanel {
	
	private JLabel lblExportarExcel;
	private JLabel lblLimpiarPaneles;
	private JLabel lblConectar;
	private JLabel lblDesconectar;
	
	public PanelEncabezadoInferior() {
	       setLayout(new MyCustomLayout());
	       setBackground(new Color(238, 235, 235));  // Un color claro

	        // Cargar la imagen Excel
	        ImageIcon originalIconExcel = new ImageIcon(PanelEncabezadoInferior.class.getResource("/recursos/excel.png"));
	        Image imgExcel = originalIconExcel.getImage();
	        Image resizedImgExcel = imgExcel.getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH);
	        ImageIcon resizedIconExcel = new ImageIcon(resizedImgExcel);
	        lblExportarExcel = new JLabel("");
	        lblExportarExcel.setIcon(resizedIconExcel);
	        lblExportarExcel.setToolTipText("Exportar datos a Excel"); // Tooltip para Excel
	        
	        // Cargar la imagen Hoja Limpia
	        ImageIcon originalIconHojaLimpia = new ImageIcon(PanelEncabezadoInferior.class.getResource("/recursos/hoja-limpia.png"));
	        Image imgHojaLimpia = originalIconHojaLimpia.getImage();
	        Image resizedImgHojaLimpia = imgHojaLimpia.getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH);
	        ImageIcon resizedIconHojaLimpia = new ImageIcon(resizedImgHojaLimpia);
	        lblLimpiarPaneles = new JLabel("");
	        lblLimpiarPaneles.setIcon(resizedIconHojaLimpia);
	        lblLimpiarPaneles.setToolTipText("Limpiar todos los paneles"); // Tooltip para limpiar paneles

	        // Cargar la imagen Conectar
	        ImageIcon originalIconConectar = new ImageIcon(PanelEncabezadoInferior.class.getResource("/recursos/usb_conectada_3.png"));
	        Image imgConectar = originalIconConectar.getImage();
	        Image resizedImgConectar = imgConectar.getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH);
	        ImageIcon resizedIconConectar = new ImageIcon(resizedImgConectar);
	        lblConectar = new JLabel("");
	        lblConectar.setIcon(resizedIconConectar);
	        lblConectar.setEnabled(true);
	        lblConectar.setToolTipText("Establecer conexión"); // Tooltip para conectar

	        // Cargar la imagen Desconectar
	        ImageIcon originalIconDesconectar = new ImageIcon(PanelEncabezadoInferior.class.getResource("/recursos/usb_desconectada_3.png"));
	        Image imgDesconectar = originalIconDesconectar.getImage();
	        Image resizedImgDesconectar = imgDesconectar.getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH);
	        ImageIcon resizedIconDesconectar = new ImageIcon(resizedImgDesconectar);
	        lblDesconectar = new JLabel("");
	        lblDesconectar.setIcon(resizedIconDesconectar);
	        lblDesconectar.setEnabled(false);
	        lblDesconectar.setToolTipText("Desconectar dispositivo"); // Tooltip para desconectar

	        // Agregar los labels al panel
	        add(lblConectar);
	        add(lblDesconectar);
	        add(lblExportarExcel);
	        add(lblLimpiarPaneles);
	}

	public JLabel getLblConectar() {
		return lblConectar;
	}

	public JLabel getLblDesconectar() {
		return lblDesconectar;
	}

	public JLabel getLblExportarExcel() {
		return lblExportarExcel;
	}

	public JLabel getLblLimpiarPaneles() {
		return lblLimpiarPaneles;
	}
}