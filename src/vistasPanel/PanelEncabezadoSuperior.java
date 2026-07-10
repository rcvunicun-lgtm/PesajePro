package vistasPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.LineBorder;
import layoutPersonalizado.MyCustomLayout;

public class PanelEncabezadoSuperior extends JPanel {
	
    private JLabel labelArchivo;
    private JLabel labelEditar;
    private JLabel labelAyuda;
    
    private JPopupMenu popupMenuArchivo;
    private JPopupMenu popupMenuEditar;
    private JPopupMenu popupMenuAyuda;
    
    private JMenuItem jMIEstablecerConexion;
    private JMenuItem jMICerrarConexion;
    private JMenuItem jMIExportar;
    private JMenuItem jMIExportarComo;
    private JMenuItem jMILimpiarPaneles;

    private JMenuItem jMICerrar;
    
    private JMenuItem jMIFormatoMedicion;
    private JMenuItem jMIEditarPath;
    private JMenuItem jMIReiniciarPath;
    private JMenuItem jMICargarPuertos;
    private JMenuItem jMIEditarPaneles;
    private JMenuItem jMIDatosPredeterminados;
    
    private JMenuItem jMISobreMi;
    
    public PanelEncabezadoSuperior() {
    	
        setLayout(new MyCustomLayout());
        setBackground(new Color(255, 255, 255));  // Un color rojo claro

        labelArchivo = new JLabel(" Archivo ");
        labelArchivo.setOpaque(true);
        labelArchivo.setBackground(Color.WHITE);

        labelArchivo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                labelArchivo.setBackground(new Color(173, 216, 230)); // Azul claro
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                labelArchivo.setBackground(Color.WHITE);
            }
        });

        popupMenuArchivo = new JPopupMenu();
        popupMenuArchivo.setBorder(new LineBorder(Color.BLUE, 1));
       
        // Cargar la imagen Conectar
        ImageIcon originalIconConectar = new ImageIcon(PanelEncabezadoInferior.class.getResource("/recursos/usb_conectada_3.png"));
        Image imgConectar = originalIconConectar.getImage();
        Image resizedImgConectar = imgConectar.getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH);
        ImageIcon resizedIconConectar = new ImageIcon(resizedImgConectar);
        jMIEstablecerConexion = new JMenuItem("  Establecer conexión"); 
        jMIEstablecerConexion.setPreferredSize(new Dimension(200, 20));
        jMIEstablecerConexion.setBackground(new Color(233, 233, 233));
        jMIEstablecerConexion.setIcon(resizedIconConectar);
        
        // Crear y redimensionar el icono para "Cerrar conexión"
        ImageIcon originalIconDesconectar = new ImageIcon(PanelEncabezadoSuperior.class.getResource("/recursos/usb_desconectada_3.png"));
        Image imgDesconectar = originalIconDesconectar.getImage();
        Image resizedImgDesconectar = imgDesconectar.getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH);
        ImageIcon resizedIconDesconectar = new ImageIcon(resizedImgDesconectar);
        jMICerrarConexion = new JMenuItem("  Cerrar conexión");
        jMICerrarConexion.setPreferredSize(new Dimension(200, 20));
        jMICerrarConexion.setBackground(new Color(233, 233, 233));
        jMICerrarConexion.setIcon(resizedIconDesconectar);
   
        // Agregar un separador vertical personalizado
        JPanel verticalSeparator1 = new JPanel();
        verticalSeparator1.setPreferredSize(new Dimension(1, 1)); // Ancho 1px, altura 50px
        verticalSeparator1.setBackground(Color.GRAY);
             
        // Crear y redimensionar el icono para "Exportar xlms"
        ImageIcon originalIconExportar = new ImageIcon(PanelEncabezadoSuperior.class.getResource("/recursos/excel.png"));
        Image imgExportar = originalIconExportar.getImage();
        Image resizedImgExportar = imgExportar.getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH);
        ImageIcon resizedIconExportar = new ImageIcon(resizedImgExportar);
        jMIExportar = new JMenuItem("  Exportar xlms");
        jMIExportar.setPreferredSize(new Dimension(200, 20));
        jMIExportar.setBackground(new Color(233, 233, 233));
        jMIExportar.setIcon(resizedIconExportar);
      
        // Crear y redimensionar el icono para "Exportar como xlms"
        ImageIcon originalIconExportarComo = new ImageIcon(PanelEncabezadoSuperior.class.getResource("/recursos/carpeta.png"));
        Image imgExportarComo = originalIconExportarComo.getImage();
        Image resizedImgExportarComo = imgExportarComo.getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH);
        ImageIcon resizedIconExportarComo = new ImageIcon(resizedImgExportarComo);
        jMIExportarComo = new JMenuItem("  Exportar como xlms");
        jMIExportarComo.setPreferredSize(new Dimension(200, 20));
        jMIExportarComo.setBackground(new Color(233, 233, 233));
        jMIExportarComo.setIcon(resizedIconExportarComo);
      
        // Agregar un separador vertical personalizado
        JPanel verticalSeparator2 = new JPanel();
        verticalSeparator2.setPreferredSize(new Dimension(1, 1)); // Ancho 1px, altura 50px
        verticalSeparator2.setBackground(Color.GRAY);
        
        // Crear y redimensionar el icono para "Limpiar páneles"
        ImageIcon originalIconLimpiar = new ImageIcon(PanelEncabezadoSuperior.class.getResource("/recursos/hoja-limpia.png"));
        Image imgLimpiar = originalIconLimpiar.getImage();
        Image resizedImgLimpiar = imgLimpiar.getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH);
        ImageIcon resizedIconLimpiar = new ImageIcon(resizedImgLimpiar);
        jMILimpiarPaneles = new JMenuItem("  Limpiar páneles");
        jMILimpiarPaneles.setPreferredSize(new Dimension(200, 20));
        jMILimpiarPaneles.setBackground(new Color(233, 233, 233));
        jMILimpiarPaneles.setIcon(resizedIconLimpiar);
       
        // Agregar un separador vertical personalizado
        JPanel verticalSeparator3 = new JPanel();
        verticalSeparator3.setPreferredSize(new Dimension(1, 1)); // Ancho 1px, altura 50px
        verticalSeparator3.setBackground(Color.GRAY);
        
        // Crear y redimensionar el icono para "Cerrar"
        ImageIcon originalIconCerrar = new ImageIcon(PanelEncabezadoSuperior.class.getResource("/recursos/cerrar.png"));
        Image imgCerrar = originalIconCerrar.getImage();
        Image resizedImgCerrar = imgCerrar.getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH);
        ImageIcon resizedIconCerrar = new ImageIcon(resizedImgCerrar);
        jMICerrar = new JMenuItem("  Salir");
        jMICerrar.setPreferredSize(new Dimension(200, 20));
        jMICerrar.setBackground(new Color(233, 233, 233));
        jMICerrar.setIcon(resizedIconCerrar);
       
        popupMenuArchivo.add(jMIEstablecerConexion);
        popupMenuArchivo.add(jMICerrarConexion);
        popupMenuArchivo.add(verticalSeparator1);
        popupMenuArchivo.add(jMIExportar);
        popupMenuArchivo.add(jMIExportarComo);
        popupMenuArchivo.add(verticalSeparator2);
        popupMenuArchivo.add(jMILimpiarPaneles);
        popupMenuArchivo.add(verticalSeparator3);
        popupMenuArchivo.add(jMICerrar);
        
        labelArchivo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {                    
                    // Mostrar el popup justo debajo de la etiqueta
                    popupMenuArchivo.show(labelArchivo, 0, labelArchivo.getHeight());
                }
            }
        });
        
        
        /////////////////////////////////////////////////////////
        
        labelEditar = new JLabel(" Configuración ");
        labelEditar.setOpaque(true);
        labelEditar.setBackground(Color.WHITE);

        labelEditar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	labelEditar.setBackground(new Color(173, 216, 230)); // Azul claro
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
            	labelEditar.setBackground(Color.WHITE);
            }
        });

        popupMenuEditar = new JPopupMenu();
        popupMenuEditar.setBorder(new LineBorder(Color.BLUE, 1));
        
        // Crear y redimensionar el icono para "Editar ruta"
        ImageIcon originalIconFormatoMedicion = new ImageIcon(PanelEncabezadoSuperior.class.getResource("/recursos/balanza2.png"));
        Image imgFormatoMedicion = originalIconFormatoMedicion.getImage();
        Image resizedImgFormatoMedicion = imgFormatoMedicion.getScaledInstance(16, 16, Image.SCALE_SMOOTH);
        ImageIcon resizedIconFormatoMedicion = new ImageIcon(resizedImgFormatoMedicion);
        jMIFormatoMedicion = new JMenuItem("  Formato de medición");
        jMIFormatoMedicion.setPreferredSize(new Dimension(200, 20));
        jMIFormatoMedicion.setBackground(new Color(233, 233, 233));
        jMIFormatoMedicion.setIcon(resizedIconFormatoMedicion);
        
        // Agregar un separador vertical personalizado
        JPanel verticalSeparator4 = new JPanel();
        verticalSeparator4.setPreferredSize(new Dimension(1, 1)); // Ancho 1px, altura 50px
        verticalSeparator4.setBackground(Color.GRAY);
        
        // Crear y redimensionar el icono para "Editar ruta"
        ImageIcon originalIconEditarRuta = new ImageIcon(PanelEncabezadoSuperior.class.getResource("/recursos/ruta2.png"));
        Image imgEditarRuta = originalIconEditarRuta.getImage();
        Image resizedImgEditarRuta = imgEditarRuta.getScaledInstance(16, 16, Image.SCALE_SMOOTH);
        ImageIcon resizedIconEditarRuta = new ImageIcon(resizedImgEditarRuta);
        jMIEditarPath = new JMenuItem("  Editar ruta");
        jMIEditarPath.setPreferredSize(new Dimension(200, 20));
        jMIEditarPath.setBackground(new Color(233, 233, 233));
        jMIEditarPath.setIcon(resizedIconEditarRuta);

        // Crear y redimensionar el icono para "Reiniciar ruta"
        ImageIcon originalIconReiniciarRuta = new ImageIcon(PanelEncabezadoSuperior.class.getResource("/recursos/reset.png"));
        Image imgReiniciarRuta = originalIconReiniciarRuta.getImage();
        Image resizedImgReiniciarRuta = imgReiniciarRuta.getScaledInstance(16, 16, Image.SCALE_SMOOTH);
        ImageIcon resizedIconReiniciarRuta = new ImageIcon(resizedImgReiniciarRuta);
        jMIReiniciarPath = new JMenuItem("  Reiniciar ruta");
        jMIReiniciarPath.setPreferredSize(new Dimension(200, 20));
        jMIReiniciarPath.setBackground(new Color(233, 233, 233));
        jMIReiniciarPath.setIcon(resizedIconReiniciarRuta);
        
        // Agregar un separador vertical personalizado
        JPanel verticalSeparator5 = new JPanel();
        verticalSeparator5.setPreferredSize(new Dimension(1, 1)); // Ancho 1px, altura 50px
        verticalSeparator5.setBackground(Color.GRAY);
        
        // Crear y redimensionar el icono para "Reiniciar ruta"
        ImageIcon originalIconCargarPuertos = new ImageIcon(PanelEncabezadoSuperior.class.getResource("/recursos/recargar.png"));
        Image imgCargarPuertos = originalIconCargarPuertos.getImage();
        Image resizedImgCargarPuertos= imgCargarPuertos.getScaledInstance(16, 16, Image.SCALE_SMOOTH);
        ImageIcon resizedIconCargarPuertos = new ImageIcon(resizedImgCargarPuertos);
        jMICargarPuertos = new JMenuItem("  Cargar Puertos");
        jMICargarPuertos.setPreferredSize(new Dimension(200, 20));
        jMICargarPuertos.setBackground(new Color(233, 233, 233));
        jMICargarPuertos.setIcon(resizedIconCargarPuertos);
        
        // Agregar un separador vertical personalizado
        JPanel verticalSeparator6 = new JPanel();
        verticalSeparator6.setPreferredSize(new Dimension(1, 1)); // Ancho 1px, altura 50px
        verticalSeparator6.setBackground(Color.GRAY);
        
        // Crear y redimensionar el icono para "Páneles"
        ImageIcon originalIconPaneles = new ImageIcon(PanelEncabezadoSuperior.class.getResource("/recursos/layut.png"));
        Image imgPaneles = originalIconPaneles.getImage();
        Image resizedImgPaneles = imgPaneles.getScaledInstance(16, 16, Image.SCALE_SMOOTH);
        ImageIcon resizedIconPaneles = new ImageIcon(resizedImgPaneles);
        jMIEditarPaneles = new JMenuItem("  Páneles");
        jMIEditarPaneles.setPreferredSize(new Dimension(200, 20));
        jMIEditarPaneles.setBackground(new Color(233, 233, 233));
        jMIEditarPaneles.setIcon(resizedIconPaneles);
                
        // Crear y redimensionar el icono para "Páneles"
        ImageIcon originalIconDatosRecibidos = new ImageIcon(PanelEncabezadoSuperior.class.getResource("/recursos/ascii.png"));
        Image imgDatosRecibidos = originalIconDatosRecibidos.getImage();
        Image resizedDatosRecibidos = imgDatosRecibidos.getScaledInstance(16, 16, Image.SCALE_SMOOTH);
        ImageIcon resizedIconDatosRecibidos = new ImageIcon(resizedDatosRecibidos);
        jMIDatosPredeterminados = new JMenuItem("  Datos predeterminados");
        jMIDatosPredeterminados.setPreferredSize(new Dimension(200, 20));
        jMIDatosPredeterminados.setBackground(new Color(233, 233, 233));
        jMIDatosPredeterminados.setIcon(resizedIconDatosRecibidos);
      
     
        popupMenuEditar.add(jMIFormatoMedicion);
        popupMenuEditar.add(verticalSeparator4);
        popupMenuEditar.add(jMIEditarPath);
        popupMenuEditar.add(jMIReiniciarPath);
        popupMenuEditar.add(verticalSeparator5);
        popupMenuEditar.add(jMICargarPuertos);
        popupMenuEditar.add(verticalSeparator6);
        popupMenuEditar.add(jMIEditarPaneles);
        popupMenuEditar.add(jMIDatosPredeterminados);
        
        labelEditar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {                              
                    // Mostrar el popup justo debajo de la etiqueta
                    popupMenuEditar.show(labelEditar, 0, labelEditar.getHeight());
                }
            }
        });
        
        //////////////////////////////////////////////////////////////
        
        labelAyuda = new JLabel(" Ayuda ");
        labelAyuda.setOpaque(true);
        labelAyuda.setBackground(Color.WHITE);

        labelAyuda.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	labelAyuda.setBackground(new Color(173, 216, 230)); // Azul claro
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
            	labelAyuda.setBackground(Color.WHITE);
            }
        });

        popupMenuAyuda = new JPopupMenu();
        popupMenuAyuda.setBorder(new LineBorder(Color.BLUE, 1));
        
        // Cargar la imagen Conectar
        ImageIcon originalIconSobreMi= new ImageIcon(PanelEncabezadoInferior.class.getResource("/recursos/sobre_mi.png"));
        Image imgSobreMi = originalIconSobreMi.getImage();
        Image resizedImgSobreMi = imgSobreMi.getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH);
        ImageIcon resizedIconSobreMi = new ImageIcon(resizedImgSobreMi);
        jMISobreMi= new JMenuItem("  Sobre mí"); 
        jMISobreMi.setPreferredSize(new Dimension(200, 20));
        jMISobreMi.setBackground(new Color(233, 233, 233));
        jMISobreMi.setIcon(resizedIconSobreMi);
        
        popupMenuAyuda.add(jMISobreMi);
        
        labelAyuda.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {                              
                    // Mostrar el popup justo debajo de la etiqueta
                	popupMenuAyuda.show(labelAyuda, 0, labelAyuda.getHeight());
                }
            }
        });
 
        ////////////////////////////////////////////////////////////////////////
        
        add(labelArchivo);
        add(labelEditar);
        add(labelAyuda);
    }



	public JMenuItem getjMIFormatoMedicion() {
		return jMIFormatoMedicion;
	}

	public JMenuItem getjMICargarPuertos() {
		return jMICargarPuertos;
	}

	public JMenuItem getjMIReiniciarPath() {
		return jMIReiniciarPath;
	}

	public JMenuItem getjMIEstablecerConexion() {
		return jMIEstablecerConexion;
	}

	public JMenuItem getjMIExportar() {
		return jMIExportar;
	}

	public JLabel getLabelArchivo() {
		return labelArchivo;
	}

	public JLabel getLabelEditar() {
		return labelEditar;
	}

	public JMenuItem getjMICerrarConexion() {
		return jMICerrarConexion;
	}

	public JMenuItem getjMIExportarComo() {
		return jMIExportarComo;
	}

	public JMenuItem getjMILimpiarPaneles() {
		return jMILimpiarPaneles;
	}

	public JMenuItem getjMICerrar() {
		return jMICerrar;
	}

	public JMenuItem getjMIEditarPaneles() {
		return jMIEditarPaneles;
	}
	
	public JMenuItem getjMIDatosPredeterminados() {
		return jMIDatosPredeterminados;
	}

	public JMenuItem getjMIEditarPath() {
		return jMIEditarPath;
	}
	
	public JMenuItem getjMISobreMi() {
		return jMISobreMi;
	}
}
