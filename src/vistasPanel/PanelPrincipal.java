package vistasPanel;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;

import javafx.application.Platform;
import javafx.stage.DirectoryChooser;
import principal.Balanzas;
import principal.ConectarsePuertoCOM;
import principal.DynamicExcelReader;
import principal.DynamicExcelWriter;
import principal.Excel;
import principal.Fecha;
import principal.RutaGuardada;
import renderizarBotonJTable.TablaPersonalizada;
import vistasFrame.FrameDatosPredeterminados;
import vistasFrame.FrameEstablecerConexion;
import vistasFrame.FrameSistemaMedicion;
import vistasFrame.FrameSobreMi;
import vistasFrame.FrameVistasPaneles;

//Importa estas clases para leer un JSON
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class PanelPrincipal extends JPanel {

	private PanelEncabezado panelEncabezado;
	private PanelContenidoPrincipal panelContenidoPrincipal;
	private PanelPieDePaginaPrincipal panelPieDePaginaPrincipal;

	// ########## Definir Elementos a usar de cada panel ##########

	// ##### Elementos panel encabezado superior #####
	private JMenuItem jMIEstablecerConexion;
	private JMenuItem jMICerrarConexion;
	private JMenuItem jMIExportar;
	private JMenuItem jMIExportarComo;
	private JMenuItem jMILimpiarPaneles;
	private JMenuItem jMICerrar;

	private JMenuItem jMIFormatoMedicion;
	private JMenuItem jMIEditarPaneles;
	private JMenuItem jMIDatosPredeterminados;
	private JMenuItem jMIEditarPath;
	private JMenuItem jMIReiniciarPath;
    private JMenuItem jMICargarPuertos;
    
    private JMenuItem jMISobreMi;

	// ##### Elementos panel encabezado inferior #####
	private JLabel lblConectar;
	private JLabel lblDesconectar;
	private JLabel lblExportarExcel;
	private JLabel lblLimpiarPaneles;

	// ##### Elementos panel DatosBalanza #####
	private JLabel lblDesconectado;
	private JComboBox<Object> cbPuerto;
	private JComboBox<Object> cbBaudRate;
	private JComboBox<Object> cbDataBits;
	private JComboBox<Object> cbStopBits;
	private JComboBox<Object> cbParity;
	private JComboBox<Object>  cbFlowC;
	private JComboBox<Object> cbVelocidadDeLectura;
	private JButton btnConectar;
	private JButton btnDesconectar;

	private JComboBox<Object> cbBalanza;
	private JTextField tfCliente;
	private JTextField tfIdmuestra;  // El tamaño ya lo hemos establecido
	private JComboBox<Object> cbCapsula;
	private JComboBox<Object> cbTipo; // Montaje o Desmontaje
    private JTextField tfEnsayo; 
    private JTextField tfMedioContacto;
    private JComboBox<Object> cbIdentificacion;
    private JSpinner spinnerAreaVolumen;
    private JTextField tfTemperatura;

	private JLabel lblPesoBalanza;
	private JButton btnObtenerPeso;
	private JButton btnDescartarPeso;

	// ##### Elementos panel TextoBalanza #####
	private JEditorPane epDatosRecibidos;
	private JButton buttonLimpiarEditorPane;

	// ##### Elementos panel ExportarDatos #####

	private TablaPersonalizada tablaDatos;
	private JButton btnExportar;

	// ##### Elementos panel ResumenExportados #####

	private DefaultTableModel modeloTablaResultados;
	
	// ########## ###################################### ##########

	// ########## Definir Elementos a usar del frame EstablecerConexion ##########

	FrameEstablecerConexion frameEstablecerConexion;

	private JLabel FEClblDesconectado;
	private JComboBox<Object> FECcbPuerto;
	private JComboBox<Object> FECcbBaudRate;
	private JComboBox<Object> FECcbDataBits;
	private JComboBox<Object> FECcbStopBits;
	private JComboBox<Object> FECcbParity;
	private JComboBox<Object> FECcbFlowC;
	private JComboBox<Object> FECcbVelocidadDeLectura;
	private JButton FECbtnConectar;
	private JButton FECbtnDesconectar;

	// ########## ###################################### ##########

	// ########## Definir Elementos a usar del frame VistasPaneles ##########

	private FrameVistasPaneles frameVistaPaneles;

	private JCheckBox chckbxPanelDatos;
	private JCheckBox chckbxPanelSenalObtenida;
	private JCheckBox chckbxPanelDatosFiltrados;
	private JCheckBox chckbxPanelArchivosExportados;

	// ########## ###################################### ##########
	
	// ########## Definir Elementos a usar del frame SistemaMedicion ##########

	private FrameSistemaMedicion frameSistemaMedicion;
	private JSpinner spEnteraMg;
	private JSpinner spDecimalMg;
	private JRadioButton rbMg;

	private JSpinner spEnteraG;
	private JSpinner spDecimalG;
	private JRadioButton rbG;
			
	private JSpinner spEnteraKg;
	private JSpinner spDecimalKg;
	private JRadioButton rbKg;
	
	private JRadioButton ultimoRadioSeleccionado;
    private int valorEntero; 
    private int valorDecimal ; 
    private String unidad;
    private JButton btnGuardarFormato;
	
	// ########## ###################################### ##########
    
	// ########## Definir Elementos a usar del frame frameDatosPredeterminados ##########

	private FrameDatosPredeterminados frameDatosPredeterminados;
	
    private JTextField txtBalanzaDP;
    private JTextField txtUsuarioDP;
    private JTextField txtMuestraDP;
    private JTextField txtEnsayoDP;
    private JTextField txtMContactoDP;
    private JTextField txtTemperaturaDP;
    private JSpinner spinnerAreaVolumenDP;
    private JComboBox<Object> cbCapsulaDP;
    private JComboBox<Object> cbTipoDP;
    private JComboBox<Object> cbIdentificacionDP;
    private JButton btnGuardarDP;
    private JButton btnRestablecerDP;
    
	private String valorModificadoBalanza = "";
    private String valorModificadoUsuario = "";
    private String valorModificadoMuestra = "";
    private String valorModificadoCapsula = "";
    private String valorModificadoTipo = "";
    private String valorModificadoEnsayo = "";
    private String valorModificadoMContacto = "";
    private String valorModificadoIdentificacion = "";
    private String valorModificadoAreaVolumen = "";
    private String valorModificadoTemperatura = "";
    
    private  File archivoJson;
    private  Gson gson;
    
    private static final String OUTPUT_PATH = "archivosComplementarios/configuracion.json";

	// ########## ###################################### ##########
        
	// ########## Definir Elementos a usar del frame frameSobreMi ##########

	private FrameSobreMi framesobreMi;
	
	// ########## ###################################### ##########
    
	public ConectarsePuertoCOM conectarsePuertoCOM;
	public String cadenaDatos = ""; // Variable para almacenar la info de la balanza

	private int contadorRegistrosTablaDatos = 1;
	private String nombreCapsulsaTablaDatos = "";
	private String pesoTextoTablaDatos = "";
	private String fechaTextoTablaDatos = "";
	private String horaTextoTablaDatos = "";
	private String nombreClienteTablaDatos = "";
	private String serialBalanzaTablaDatos = "";
	private String idMuestraTablaDatos;
	private String tipoTablaDatos; // Montaje o Desmontaje
	private String ensayoTablaDatos;
	private String medioContactoTablaDatos;
	private String identificacionTablaDatos;
	private Double areaVolumenTablaDatos;
	private String areaVolumenTablaDatosString;
	private String temperaturaTablaDatos;

	private ArrayList<Object[]> datosFiltrados = new ArrayList<>();

	private int contadorRegistroTablaResultado = 1;
	private String userHome = System.getProperty("user.home"); // Obtener el directorio raiz del usuario actual del pc
	private String nomArchivoExcel = "pesaje";
	private String fechaTablaResultados = "";
	private String extension = ".xlsx";
	private String desktopPath = userHome + "\\Desktop\\" + nomArchivoExcel + "_" + fechaTablaResultados + extension;

	private Pattern pattern;
	private String regex;
	
	public PanelPrincipal() {
		setLayout(new BorderLayout(0, 0));

		panelEncabezado = new PanelEncabezado();
		panelContenidoPrincipal = new PanelContenidoPrincipal(datosFiltrados);
		panelPieDePaginaPrincipal = new PanelPieDePaginaPrincipal();
		panelContenidoPrincipal.getPCP_ResumenExportados().setVisible(false);

		add(panelEncabezado, BorderLayout.NORTH);
		add(panelContenidoPrincipal, BorderLayout.CENTER);
		add(panelPieDePaginaPrincipal, BorderLayout.SOUTH);

		// Inicializar JavaFX si no ha sido inicializado
		Platform.startup(() -> {
			// Esto asegura que JavaFX esté configurado
		});

		forceRepaint();

		// ##### Inicializar variables del panel encabezado superior #####

		jMIEstablecerConexion = panelEncabezado.getPanelEncabezadoSuperior().getjMIEstablecerConexion();
		jMICerrarConexion = panelEncabezado.getPanelEncabezadoSuperior().getjMICerrarConexion();
		jMIExportar = panelEncabezado.getPanelEncabezadoSuperior().getjMIExportar();
		jMIExportarComo = panelEncabezado.getPanelEncabezadoSuperior().getjMIExportarComo();
		jMILimpiarPaneles = panelEncabezado.getPanelEncabezadoSuperior().getjMILimpiarPaneles();
		jMICerrar = panelEncabezado.getPanelEncabezadoSuperior().getjMICerrar();

		jMIFormatoMedicion = panelEncabezado.getPanelEncabezadoSuperior().getjMIFormatoMedicion();
		jMIEditarPaneles = panelEncabezado.getPanelEncabezadoSuperior().getjMIEditarPaneles();
		jMIDatosPredeterminados = panelEncabezado.getPanelEncabezadoSuperior().getjMIDatosPredeterminados();
		jMIEditarPath = panelEncabezado.getPanelEncabezadoSuperior().getjMIEditarPath();
		jMIReiniciarPath = panelEncabezado.getPanelEncabezadoSuperior().getjMIReiniciarPath();
	    jMICargarPuertos = panelEncabezado.getPanelEncabezadoSuperior().getjMICargarPuertos();
	    
	    jMISobreMi = panelEncabezado.getPanelEncabezadoSuperior().getjMISobreMi();
		// ##### Inicializar variables del panel encabezado inferior #####

		lblConectar = panelEncabezado.getPanelEncabezadoInferior().getLblConectar();
		lblDesconectar = panelEncabezado.getPanelEncabezadoInferior().getLblDesconectar();
		lblExportarExcel = panelEncabezado.getPanelEncabezadoInferior().getLblExportarExcel();
		lblLimpiarPaneles = panelEncabezado.getPanelEncabezadoInferior().getLblLimpiarPaneles();

		// ############ Inicializar variables del panel contenido principal // #############

		// ##### Inicializar variables del panel DatosBalanza #####

		lblDesconectado = panelContenidoPrincipal.getPCP_DatosBalanza().getLblDesconectado();
		cbPuerto = panelContenidoPrincipal.getPCP_DatosBalanza().getCbPuerto();
		cbBaudRate = panelContenidoPrincipal.getPCP_DatosBalanza().getCbBaudRate();
		cbDataBits = panelContenidoPrincipal.getPCP_DatosBalanza().getCbDataBits();
		cbStopBits = panelContenidoPrincipal.getPCP_DatosBalanza().getCbStopBits();
		cbParity = panelContenidoPrincipal.getPCP_DatosBalanza().getCbParity();
		cbFlowC = panelContenidoPrincipal.getPCP_DatosBalanza().getCbFlowC();
		cbVelocidadDeLectura = panelContenidoPrincipal.getPCP_DatosBalanza().getCbVelocidadDeLectura();
		btnConectar = panelContenidoPrincipal.getPCP_DatosBalanza().getBtnConectar();
		btnDesconectar = panelContenidoPrincipal.getPCP_DatosBalanza().getBtnDesconectar();

		cbBalanza = panelContenidoPrincipal.getPCP_DatosBalanza().getCbBalanza();
		tfCliente = panelContenidoPrincipal.getPCP_DatosBalanza().getTfUsuario();
		tfIdmuestra = panelContenidoPrincipal.getPCP_DatosBalanza().getTfIdmuestra();
		cbCapsula = panelContenidoPrincipal.getPCP_DatosBalanza().getCbCapsula();
		cbTipo = panelContenidoPrincipal.getPCP_DatosBalanza().getCbTipo();
		tfEnsayo= panelContenidoPrincipal.getPCP_DatosBalanza().getTfEnsayo();
		tfMedioContacto= panelContenidoPrincipal.getPCP_DatosBalanza().getTfMedioContacto();
		cbIdentificacion= panelContenidoPrincipal.getPCP_DatosBalanza().getCbIdentificacion();
		spinnerAreaVolumen= panelContenidoPrincipal.getPCP_DatosBalanza().getSpinnerAreaVolumen();
		tfTemperatura = panelContenidoPrincipal.getPCP_DatosBalanza().getTfTemperatura();
	

		lblPesoBalanza = panelContenidoPrincipal.getPCP_DatosBalanza().getLblPesoBalanza();
		btnObtenerPeso = panelContenidoPrincipal.getPCP_DatosBalanza().getBtnObtenerPeso();
		btnDescartarPeso = panelContenidoPrincipal.getPCP_DatosBalanza().getBtnDescartarPeso();

		// ##### Inicializar variables del panel TextoBalanza #####

		epDatosRecibidos = panelContenidoPrincipal.getPCP_TextoBalanza().getEpDatosRecibidos();
		inicializarEditorPane();
		
		buttonLimpiarEditorPane = panelContenidoPrincipal.getPCP_TextoBalanza().getButtonLimpiarEditorPane();

		// ##### Inicializar variables del panel ExportarDatos #####

	
		tablaDatos = panelContenidoPrincipal.getPCP_ExportarDatos().getTablaDatos();
		btnExportar = panelContenidoPrincipal.getPCP_ExportarDatos().getBtnExportar();

		// ##### Inicializar variables del panel ResumenExportados #####

		modeloTablaResultados = panelContenidoPrincipal.getPCP_ResumenExportados().getModeloTablaResultados();

		// ########################### ################### ###########################

		// ##### Inicializar variables del FrameEstablecerConexion ####

		frameEstablecerConexion = new FrameEstablecerConexion();

		FEClblDesconectado = frameEstablecerConexion.getLblDesconectado();
		FECcbPuerto = frameEstablecerConexion.getCbPuerto();
		FECcbBaudRate = frameEstablecerConexion.getCbBaudRate();
		FECcbDataBits = frameEstablecerConexion.getCbDataBits();
		FECcbStopBits = frameEstablecerConexion.getCbStopBits();
		FECcbParity = frameEstablecerConexion.getCbParity();
		FECcbFlowC = frameEstablecerConexion.getCbFlowC();
		FECcbVelocidadDeLectura = frameEstablecerConexion.getCbVelocidadDeLectura();
		FECbtnConectar = frameEstablecerConexion.getBtnConectar();
		FECbtnDesconectar = frameEstablecerConexion.getBtnDesconectar();
		// #############################################################

		// ##### Inicializar variables del FrameVistasPaneles ####
		frameVistaPaneles = new FrameVistasPaneles();

		chckbxPanelDatos = frameVistaPaneles.getChckbxPanelDatos();
		chckbxPanelSenalObtenida = frameVistaPaneles.getChckbxPanelSenalObtenida();
		chckbxPanelDatosFiltrados = frameVistaPaneles.getChckbxPanelDatosFiltrados();
		chckbxPanelArchivosExportados = frameVistaPaneles.getChckbxPanelArchivosExportados();

		// #############################################################

		// ########################### ################### ###########################

		// ##### Inicializar variables del FrameSistemaMedicion ####

		frameSistemaMedicion = new FrameSistemaMedicion();
		
		spEnteraMg = frameSistemaMedicion.getSpEnteraMg();
		spDecimalMg = frameSistemaMedicion.getSpDecimalMg();
		rbMg = frameSistemaMedicion.getRbMg();

		spEnteraG = frameSistemaMedicion.getSpEnteraG();
		spDecimalG = frameSistemaMedicion.getSpDecimalG();
		rbG = frameSistemaMedicion.getRbG();
				
		spEnteraKg = frameSistemaMedicion.getSpEnteraKg();
		spDecimalKg = frameSistemaMedicion.getSpDecimalKg();
		rbKg = frameSistemaMedicion.getRbKg();
	
		ultimoRadioSeleccionado = frameSistemaMedicion.getUltimoRadioSeleccionado();
	    valorEntero = frameSistemaMedicion.getValorEntero();
	    valorDecimal = frameSistemaMedicion.getValorDecimal();
	    unidad = frameSistemaMedicion.getUnidad();
	    btnGuardarFormato = frameSistemaMedicion.getBtnGuardarFormato();
		
		// ########################### ################### ###########################
	    
	    // ##### Inicializar variables del FrameDatosPredeterminados ####
	    frameDatosPredeterminados = new FrameDatosPredeterminados();

	    txtBalanzaDP = frameDatosPredeterminados.getTxtBalanza();
		txtUsuarioDP = frameDatosPredeterminados.getTxtUsuario();
		txtMuestraDP = frameDatosPredeterminados.getTxtMuestra();
		txtEnsayoDP = frameDatosPredeterminados.getTxtEnsayo();
		txtMContactoDP = frameDatosPredeterminados.getTxtMContacto();
		txtTemperaturaDP = frameDatosPredeterminados.getTxtTemperatura();
		spinnerAreaVolumenDP = frameDatosPredeterminados.getSpinnerAreaVolumen();
		cbCapsulaDP = frameDatosPredeterminados.getCbCapsula();
		cbTipoDP = frameDatosPredeterminados.getCbTipo();
		cbIdentificacionDP = frameDatosPredeterminados.getCbIdentificacion();
		btnGuardarDP = frameDatosPredeterminados.getBtnGuardar();
		btnRestablecerDP = frameDatosPredeterminados.getBtnRestablecer();
		
	 	// #############################################################
		
	    // ##### Inicializar variables del FrameSobreMi ####
		framesobreMi = new FrameSobreMi();
		
		// ########################### ################### ###########################
		
		
		// Definir el patron de busqueda
		regex = "(?<=\\D|^)\\d{1,"+ valorEntero +"}\\.\\d{"+ valorDecimal + "}\\s"+unidad+"(?=\\D|$)";
		//regex = "(?<=\\D|^)\\d{1,2}\\.\\d{4}(?=\\D|$)";
		//regex = "^-?\\d+(\\.\\d+)?$";
		//regex = "[a-zA-Z0-9_ .,]+";

		// Crear los patrones
		pattern = Pattern.compile(regex);
		
	 // ########################### ################### ###########################
		crearGSON();
		
		leerGSON();
		
		verificarCopiaDatosExcelAlmacenados();

		verificarPuertosDisponibles();
		
		lblPesoBalanza.setText("0.0 " + unidad);
		
		btnConectar.addActionListener(e -> {
			conectar(true);
		});

		FECbtnConectar.addActionListener(e -> {
			conectar(false);
		});

		// Evento para cerrar la conexion al puerto seleccionado
		btnDesconectar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				desconectar();
			}
		});

		// Evento para cerrar la conexion al puerto seleccionado
		FECbtnDesconectar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				desconectar();
			}
		});


		// Evento para pasar el peso obtenido a la tabla de datos a importar
		btnObtenerPeso.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Verificar si el puerto sigue disponible
		        if (conectarsePuertoCOM.isPortAvailable() && conectarsePuertoCOM.isPortOpen()) {
		            // Si el puerto sigue disponible y está abierto, proceder con la lectura
		        	
		        	 // ⬅️ PRIMERO AUMENTAMOS el contador ANTES de usarlo
		        	// Usa la cantidad actual de filas - encabezados
		        	contadorRegistrosTablaDatos = tablaDatos.getRowCount() - 2 + 1; // -2 por los encabezados, +1 porque empiezas desde 1

		            
		            nombreCapsulsaTablaDatos = (String) cbCapsula.getSelectedItem();
		            pesoTextoTablaDatos = lblPesoBalanza.getText();
		            fechaTextoTablaDatos = Fecha.obtenerFechaActual();
		            horaTextoTablaDatos = Fecha.obtenerHoraActual();
		            nombreClienteTablaDatos = tfCliente.getText();
		            serialBalanzaTablaDatos = obtenerSerial((String) cbBalanza.getSelectedItem());
		            idMuestraTablaDatos = tfIdmuestra.getText();    
		        	tipoTablaDatos = (String) cbTipo.getSelectedItem();
		        	ensayoTablaDatos = tfEnsayo.getText();
		        	medioContactoTablaDatos = tfMedioContacto.getText();
		        	identificacionTablaDatos = (String) cbIdentificacion.getSelectedItem();
		        	areaVolumenTablaDatos = (Double) spinnerAreaVolumen.getValue();
		        	areaVolumenTablaDatosString = String.format("%.1f", areaVolumenTablaDatos);
		        	temperaturaTablaDatos = tfTemperatura.getText();

		            // Crea una copia de los datos:
		            String filePath = "archivosComplementarios/datos_incrementales.xlsx";
		            // Agregar varias filas dinámicamente
		            DynamicExcelWriter.appendRowToExcel(filePath,
		                    Arrays.asList(contadorRegistrosTablaDatos, 
		                    		nombreCapsulsaTablaDatos, 
		                    		tipoTablaDatos, 
		                    		idMuestraTablaDatos, 
		                    		ensayoTablaDatos, 
		                    		medioContactoTablaDatos, 
		                    		identificacionTablaDatos , 
		                    		areaVolumenTablaDatos,
		                    		pesoTextoTablaDatos,
		                    		temperaturaTablaDatos,
		                            fechaTextoTablaDatos,
		                            horaTextoTablaDatos, 
		                            nombreClienteTablaDatos, 
		                            serialBalanzaTablaDatos
		                            ));

		            
		            
		            // Este es el objeto que se va a exportar a excel
		            Object[] nuevaFila = new Object[] { 
		            		contadorRegistrosTablaDatos, 
                    		nombreCapsulsaTablaDatos, 
                    		tipoTablaDatos, 
                    		idMuestraTablaDatos, 
                    		ensayoTablaDatos, 
                    		medioContactoTablaDatos, 
                    		identificacionTablaDatos , 
                    		areaVolumenTablaDatos,
                    		pesoTextoTablaDatos,
                    		temperaturaTablaDatos,
                            fechaTextoTablaDatos,
                            horaTextoTablaDatos, 
                            nombreClienteTablaDatos, 
                            serialBalanzaTablaDatos,
                           
                            };
		            
		            datosFiltrados.add(nuevaFila);
		            
		            		            		         		            
		            // Este es el objeto que se va a mostrar los datos en el JTable (Molesta esta variable: areaVolumenTablaDatosString)
		            Object[] nuevaFila2 = new Object[] { contadorRegistrosTablaDatos, 
                    		nombreCapsulsaTablaDatos, 
                    		tipoTablaDatos, 
                    		idMuestraTablaDatos, 
                    		ensayoTablaDatos, 
                    		medioContactoTablaDatos, 
                    		identificacionTablaDatos , 
                    		areaVolumenTablaDatosString,
                    		pesoTextoTablaDatos,
                    		temperaturaTablaDatos,
                            fechaTextoTablaDatos,
                            horaTextoTablaDatos, 
                            nombreClienteTablaDatos, 
                            serialBalanzaTablaDatos,
                            
                       
                    };

		            ((TablaPersonalizada) tablaDatos).addRow(nuevaFila2);

		            lblPesoBalanza.setText("0.0 " + unidad);

		        } else {
		            // Si el puerto COM no está disponible o abierto, mostrar un mensaje de error
		            JOptionPane.showMessageDialog(null, "No se ha establecido una conexión con el puerto COM.",
		                    "Error de conexión", JOptionPane.ERROR_MESSAGE);
		        }
		    }
		});


		btnDescartarPeso.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				lblPesoBalanza.setText("0.0 " + unidad);

			}
		});

		// Evento para exportar los datos a un arhivo de Excel
		btnExportar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				exportar();
			}
		});

		buttonLimpiarEditorPane.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				epDatosRecibidos.setText("");
				cadenaDatos = "";
			}
		});

		jMIEstablecerConexion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {

							frameEstablecerConexion.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});

		jMICerrarConexion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (conectarsePuertoCOM != null) {
					desconectar();
				} else {
					// JOptionPane.showMessageDialog(null, "La conexión no está
					// inicializada.","Error", JOptionPane.ERROR_MESSAGE);
					return;
				}

			}
		});

		jMIExportar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				exportar();
			}
		});

		jMIExportarComo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				exportarComo();
			}
		});

		jMILimpiarPaneles.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Mostrar el cuadro de confirmación
				int respuesta = JOptionPane.showConfirmDialog(null, // Componente padre, null para que aparezca centrado
						"¿Estás seguro de que deseas limpiar los paneles?", // Mensaje
						"Confirmar Limpieza", // Título
						JOptionPane.YES_NO_OPTION, // Opciones de Sí y No
						JOptionPane.QUESTION_MESSAGE // Icono de pregunta
				);

				// Evaluar la respuesta del usuario
				if (respuesta == JOptionPane.YES_OPTION) {
					limpiarPaneles(); // Ejecutar la operación si elige "Sí"
				}
			}
		});

		jMICerrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		jMIFormatoMedicion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							frameSistemaMedicion.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});

		jMIEditarPaneles.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							frameVistaPaneles.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		jMIDatosPredeterminados.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							frameDatosPredeterminados.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		jMISobreMi.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        EventQueue.invokeLater(new Runnable() {
		            public void run() {
		                try {
		                    framesobreMi.reiniciarEscena();  // Reiniciar la escena
		                    framesobreMi.setVisible(true);   // Hacer visible la ventana
		                } catch (Exception e) {
		                    e.printStackTrace();
		                }
		            }
		        });
		    }
		});


		chckbxPanelDatos.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					panelContenidoPrincipal.getPCP_DatosBalanza().setVisible(true);
					// Reconfigurar los componentes en el SplitPane
					panelContenidoPrincipal.getSplitPaneHorizontal()
							.setLeftComponent(panelContenidoPrincipal.getPCP_DatosBalanza());
				} else {
					panelContenidoPrincipal.getPCP_DatosBalanza().setVisible(false);
					// Eliminar el componente del SplitPane
					panelContenidoPrincipal.getSplitPaneHorizontal().setLeftComponent(null);
				}

				// Forzar la actualización del SplitPane
				panelContenidoPrincipal.getSplitPaneHorizontal().revalidate();
				panelContenidoPrincipal.getSplitPaneHorizontal().repaint();
			}
		});

		chckbxPanelSenalObtenida.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					// Mostrar PCP_TextoBalanza
					panelContenidoPrincipal.getPCP_TextoBalanza().setVisible(true);

					// Asegurarse de que PCP_TextoBalanza se añada correctamente al SplitPane
					panelContenidoPrincipal.getSplitPaneHorizontal()
							.setRightComponent(panelContenidoPrincipal.getPCP_TextoBalanza());
				} else {
					// Ocultar PCP_TextoBalanza
					panelContenidoPrincipal.getPCP_TextoBalanza().setVisible(false);

					// Eliminar PCP_TextoBalanza del SplitPane
					panelContenidoPrincipal.getSplitPaneHorizontal().setRightComponent(null);
				}

				// Forzar la actualización del SplitPane
				panelContenidoPrincipal.getSplitPaneHorizontal().revalidate();
				panelContenidoPrincipal.getSplitPaneHorizontal().repaint();
			}
		});

		chckbxPanelDatosFiltrados.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					// Mostrar el panel de exportar datos
					panelContenidoPrincipal.getPCP_ExportarDatos().setVisible(true);

					// Reconfigurar el SplitPane si es necesario
					panelContenidoPrincipal.getSplitPaneHorizontal2()
							.setRightComponent(panelContenidoPrincipal.getPCP_ExportarDatos());
				} else {
					// Ocultar el panel de exportar datos
					panelContenidoPrincipal.getPCP_ExportarDatos().setVisible(false);

					// Eliminar el panel del SplitPane si es necesario
					panelContenidoPrincipal.getSplitPaneHorizontal2().setRightComponent(null);
				}

				// Forzar la actualización del SplitPane
				panelContenidoPrincipal.getSplitPaneHorizontal2().revalidate();
				panelContenidoPrincipal.getSplitPaneHorizontal2().repaint();
			}
		});

		chckbxPanelArchivosExportados.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					// Mostrar el panel de resumen exportados
					panelContenidoPrincipal.getPCP_ResumenExportados().setVisible(true);

					// Reconfigurar el SplitPane si es necesario
					panelContenidoPrincipal.getSplitPaneVertical()
							.setBottomComponent(panelContenidoPrincipal.getPCP_ResumenExportados());
				} else {
					// Ocultar el panel de resumen exportados
					panelContenidoPrincipal.getPCP_ResumenExportados().setVisible(false);

					// Eliminar el panel del SplitPane si es necesario
					panelContenidoPrincipal.getSplitPaneVertical().setBottomComponent(null);
				}

				// Forzar la actualización del SplitPane
				panelContenidoPrincipal.getSplitPaneVertical().revalidate();
				panelContenidoPrincipal.getSplitPaneVertical().repaint();
			}
		});

		jMIEditarPath.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				javafx.application.Platform.runLater(() -> {
					DirectoryChooser selectorDeCarpeta = new DirectoryChooser();
					selectorDeCarpeta.setTitle("Seleccionar Carpeta de Exportación");
					selectorDeCarpeta.setInitialDirectory(new File(System.getProperty("user.home")));
					File carpetaSeleccionada = selectorDeCarpeta.showDialog(null);

					if (carpetaSeleccionada != null) {
						String rutaSeleccionada = carpetaSeleccionada.getAbsolutePath();
						RutaGuardada.guardarRuta(rutaSeleccionada); // Guardar la nueva ruta
						JOptionPane.showMessageDialog(null, "La ruta fue cambiada con éxito.", "Éxito",
								JOptionPane.INFORMATION_MESSAGE);
						// System.out.println("Ruta seleccionada guardada: " + rutaSeleccionada);
					} else {
						// System.out.println("No se seleccionó ninguna carpeta.");
						JOptionPane.showMessageDialog(null, "No se seleccionó ninguna carpeta.", "Advertencia",
								JOptionPane.INFORMATION_MESSAGE);
					}
				});
			}
		});

		jMIReiniciarPath.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					// Intentar eliminar el fichero
					boolean eliminado = RutaGuardada.eliminarFichero();

					// Imprimir mensaje según el resultado
					if (eliminado) {
						JOptionPane.showMessageDialog(null,
								"La ruta fue reiniciada con éxito. El programa usará el Escritorio por defecto.",
								"Éxito", JOptionPane.INFORMATION_MESSAGE);
						// System.out.println("El fichero de la ruta guardada ha sido eliminado. El
						// programa usará el Escritorio por defecto.");
					} else {
						JOptionPane.showMessageDialog(null,
								"La ruta fue reiniciada con éxito. El programa usará el Escritorio por defecto.",
								"Éxito", JOptionPane.INFORMATION_MESSAGE);
						// System.out.println("No se encontró el fichero para eliminar. Se sigue
						// utilizando el Escritorio por defecto.");
					}
				} catch (Exception ex) {
					// Mostrar un único mensaje de error en caso de que falle algo
					// System.err.println("Error al intentar reiniciar el path: " +
					// ex.getMessage());
					JOptionPane.showMessageDialog(null,ex.getMessage(),"Error", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		
		jMICargarPuertos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				verificarPuertosDisponibles();
			}
		});

		/*
		 * // Otra forma para reiniciar el path
		 * 
		 * jMIReiniciarPath.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) { try { // Obtener la
		 * ruta del escritorio String rutaEscritorio = System.getProperty("user.home") +
		 * "\\Desktop";
		 * 
		 * // Sobreescribir el fichero con la ruta de Escritorio
		 * RutaGuardada.guardarRuta(rutaEscritorio);
		 * 
		 * System.out.println("El path ha sido reiniciado al Escritorio: " +
		 * rutaEscritorio); } catch (Exception ex) {
		 * System.err.println("Error al reiniciar el path: " + ex.getMessage());
		 * ex.printStackTrace(); } } });
		 * 
		 */

		lblConectar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (!lblConectar.isEnabled()) {
					return; // Ignorar el clic si el JLabel está deshabilitado
				}

				conectar(true);
			}
		});

		lblDesconectar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (!lblDesconectar.isEnabled()) {
					return; // Ignorar el clic si el JLabel está deshabilitado
				}

				desconectar();
			}
		});

		lblExportarExcel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exportar();
			}
		});

		lblLimpiarPaneles.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Mostrar el cuadro de confirmación
				int respuesta = JOptionPane.showConfirmDialog(null, // Componente padre, null para que aparezca centrado
						"¿Estás seguro de que deseas limpiar los paneles?", // Mensaje
						"Confirmar Limpieza", // Título
						JOptionPane.YES_NO_OPTION, // Opciones de Sí y No
						JOptionPane.QUESTION_MESSAGE // Icono de pregunta
				);

				// Evaluar la respuesta del usuario
				if (respuesta == JOptionPane.YES_OPTION) {
					limpiarPaneles(); // Ejecutar la operación si elige "Sí"
				}
			}
		});
		
		
		// Agregar ActionListener a los botones
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (rbMg.isSelected()) {
             
                    spEnteraMg.setEnabled(true);
                    spDecimalMg.setEnabled(true);
                    
                    spEnteraG.setEnabled(false);
                    spDecimalG.setEnabled(false);
                    
                    spEnteraKg.setEnabled(false);
                    spDecimalKg.setEnabled(false);
                    
                    ultimoRadioSeleccionado = rbMg;
                   
                } else if (rbG.isSelected()) {
              
                    spEnteraMg.setEnabled(false);
                    spDecimalMg.setEnabled(false);
                    
                    spEnteraG.setEnabled(true);
                    spDecimalG.setEnabled(true);
                    
                    spEnteraKg.setEnabled(false);
                    spDecimalKg.setEnabled(false);
                    
                    ultimoRadioSeleccionado = rbG;
                    
                } else if (rbKg.isSelected()) {
                  
                    spEnteraMg.setEnabled(false);
                    spDecimalMg.setEnabled(false);
                    
                    spEnteraG.setEnabled(false);
                    spDecimalG.setEnabled(false);
                    
                    spEnteraKg.setEnabled(true);
                    spDecimalKg.setEnabled(true);
                    
                    ultimoRadioSeleccionado = rbKg;
                }
            }
        };

        // Añadir el ActionListener a cada botón
        rbMg.addActionListener(listener);
        rbG.addActionListener(listener);
        rbKg.addActionListener(listener);

        btnGuardarFormato.addActionListener(new ActionListener() {
        	
        	public void actionPerformed(ActionEvent e) {
        		if(ultimoRadioSeleccionado.getText().equals("mg")) {
        			
        			valorEntero = (int) spEnteraMg.getValue();
        			valorDecimal = (int) spDecimalMg.getValue();
        			unidad = ultimoRadioSeleccionado.getText();
                
        		}else if(ultimoRadioSeleccionado.getText().equals("g")) {
        			
        			valorEntero = (int) spEnteraG.getValue();
        			valorDecimal = (int) spDecimalG.getValue();
        			unidad = ultimoRadioSeleccionado.getText();
        			
        		}else {
        			
        			valorEntero = (int) spEnteraKg.getValue();
        			valorDecimal = (int) spDecimalKg.getValue();
        			unidad = ultimoRadioSeleccionado.getText();
        		}
        		
        		if(valorDecimal > 0) {
        			// Definir el patron de busqueda
            		regex = "(?<=\\D|^)\\d{1,"+ valorEntero +"}\\.\\d{"+ valorDecimal + "}\\s"+unidad+"(?=\\D|$)";
        		}else {
        			regex = "(?<=\\D|^)\\d{1,"+ valorEntero +"}\\d{"+ valorDecimal + "}\\s"+unidad+"(?=\\D|$)";
        		}
        	
    
        		// Crear los patrones
        		pattern = Pattern.compile(regex);
        		lblPesoBalanza.setText("0.0 " + unidad);
        		JOptionPane.showMessageDialog(null, "Formato estabecido con Éxito \n El formato actual es: \n \n" + "Unidad de masa: " + unidad + "\n" + "Cantidad de enteros: " + valorEntero + "\n" + "Cantidad de decimales: "+ valorDecimal, "Información", JOptionPane.INFORMATION_MESSAGE);
        		//System.out.println(valorEntero + " " + unidad);
        		//System.out.println(valorDecimal + " " + unidad);
        	}
        });
        
        
        btnGuardarDP.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                Map<String, Map<String, String>> datosExistentes = new LinkedHashMap<>();

                // Leer JSON existente
                try (Reader reader = new FileReader(OUTPUT_PATH)) {
                    java.lang.reflect.Type tipo = new TypeToken<Map<String, Map<String, String>>>() {}.getType();
                    datosExistentes = gson.fromJson(reader, tipo);
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "No se pudo leer el archivo existente.\nSe creará uno nuevo.");
                }

                // Actualizar solo valorModificado con los datos actuales
                if (datosExistentes.containsKey("balanza")) datosExistentes.get("balanza").put("valorModificado", txtBalanzaDP.getText());
                if (datosExistentes.containsKey("usuario")) datosExistentes.get("usuario").put("valorModificado", txtUsuarioDP.getText());
                if (datosExistentes.containsKey("muestra")) datosExistentes.get("muestra").put("valorModificado", txtMuestraDP.getText());
                if (datosExistentes.containsKey("capsula")) datosExistentes.get("capsula").put("valorModificado", cbCapsulaDP.getSelectedItem().toString());
                if (datosExistentes.containsKey("tipo")) datosExistentes.get("tipo").put("valorModificado", cbTipoDP.getSelectedItem().toString());
                if (datosExistentes.containsKey("ensayo")) datosExistentes.get("ensayo").put("valorModificado", txtEnsayoDP.getText());
                if (datosExistentes.containsKey("mContacto")) datosExistentes.get("mContacto").put("valorModificado", txtMContactoDP.getText());
                if (datosExistentes.containsKey("identificacion")) datosExistentes.get("identificacion").put("valorModificado", cbIdentificacionDP.getSelectedItem().toString());
                if (datosExistentes.containsKey("areaVolumen")) datosExistentes.get("areaVolumen").put("valorModificado", spinnerAreaVolumenDP.getValue().toString());
                if (datosExistentes.containsKey("temperatura")) datosExistentes.get("temperatura").put("valorModificado", txtTemperaturaDP.getText());
   
                
                valorModificadoBalanza = datosExistentes.get("balanza").get("valorModificado");
                valorModificadoUsuario = datosExistentes.get("usuario").get("valorModificado");
                valorModificadoMuestra = datosExistentes.get("muestra").get("valorModificado");
                valorModificadoCapsula = datosExistentes.get("capsula").get("valorModificado");
                valorModificadoTipo = datosExistentes.get("tipo").get("valorModificado");
                valorModificadoEnsayo = datosExistentes.get("ensayo").get("valorModificado");
                valorModificadoMContacto = datosExistentes.get("mContacto").get("valorModificado");
                valorModificadoIdentificacion = datosExistentes.get("identificacion").get("valorModificado");
                valorModificadoAreaVolumen = datosExistentes.get("areaVolumen").get("valorModificado");
                valorModificadoTemperatura = datosExistentes.get("temperatura").get("valorModificado");

                // Si el valor no está en la lista, lo agregamos al modelo
                if (cbBalanza.getItemCount() > 0 && !itemExists(cbBalanza, valorModificadoBalanza)) {
                	cbBalanza.addItem(valorModificadoBalanza); // Agregar el nuevo valor
                }            
                cbBalanza.setSelectedItem(valorModificadoBalanza);
                
                //cbBalanza.setSelectedItem(valorModificadoBalanza);
        		tfCliente.setText(valorModificadoUsuario);
        		tfIdmuestra.setText(valorModificadoMuestra);	
        		cbCapsula.setSelectedItem(valorModificadoCapsula);
        		cbTipo.setSelectedItem(valorModificadoTipo);
        		tfEnsayo.setText(valorModificadoEnsayo);
        		tfMedioContacto.setText(valorModificadoMContacto);
        		cbIdentificacion.setSelectedItem(valorModificadoIdentificacion);

        	    double numero = Double.parseDouble(valorModificadoAreaVolumen);
        		spinnerAreaVolumen.setValue(numero);
        		tfTemperatura.setText(valorModificadoTemperatura);

                // Guardar nuevamente el JSON
                try (Writer writer = new FileWriter(OUTPUT_PATH)) {
                    gson.toJson(datosExistentes, writer);
                    JOptionPane.showMessageDialog(null, "Datos guardados correctamente.");
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al guardar datos:\n" + ex.getMessage());
                }
            }
        });
        
        
        btnRestablecerDP.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                File file = new File(OUTPUT_PATH);
                if (!file.exists()) {
                    JOptionPane.showMessageDialog(null, "No se encontró un archivo de configuración para restablecer.");
                    return;
                }

                try (FileReader reader = new FileReader(file)) {
                    Gson gson = new Gson();
                    java.lang.reflect.Type type = new TypeToken<Map<String, Map<String, String>>>(){}.getType();
                    Map<String, Map<String, String>> datos = gson.fromJson(reader, type);

                    // Restablecer valorModificado = valorOriginal
                    for (Map.Entry<String, Map<String, String>> entry : datos.entrySet()) {
                        String valorOriginal = entry.getValue().get("valorOriginal");
                        entry.getValue().put("valorModificado", valorOriginal);
                    }

                    // Guardar cambios en el JSON
                    try (FileWriter writer = new FileWriter(OUTPUT_PATH)) {
                        Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
                        prettyGson.toJson(datos, writer);
                    }

                    // ACTUALIZAR COMPONENTES SWING CON valorModificado
                    txtBalanzaDP.setText(datos.get("balanza").get("valorModificado"));
                    txtUsuarioDP.setText(datos.get("usuario").get("valorModificado"));
                    txtMuestraDP.setText(datos.get("muestra").get("valorModificado"));
                    cbCapsulaDP.setSelectedItem(datos.get("capsula").get("valorModificado"));
                    cbTipoDP.setSelectedItem(datos.get("tipo").get("valorModificado"));
                    txtEnsayoDP.setText(datos.get("ensayo").get("valorModificado"));
                    txtMContactoDP.setText(datos.get("mContacto").get("valorModificado"));
                    cbIdentificacionDP.setSelectedItem(datos.get("identificacion").get("valorModificado"));
                    spinnerAreaVolumenDP.setValue(Double.parseDouble(datos.get("areaVolumen").get("valorModificado")));
                    txtTemperaturaDP.setText(datos.get("temperatura").get("valorModificado"));

         
                    cbBalanza.setSelectedItem(datos.get("balanza").get("valorModificado"));
            		tfCliente.setText(datos.get("usuario").get("valorModificado"));
            		tfIdmuestra.setText(datos.get("muestra").get("valorModificado"));	
            		cbCapsula.setSelectedItem(datos.get("capsula").get("valorModificado"));
            		cbTipo.setSelectedItem(datos.get("tipo").get("valorModificado"));
            		tfEnsayo.setText(datos.get("ensayo").get("valorModificado"));
            		tfMedioContacto.setText(datos.get("mContacto").get("valorModificado"));
            		cbIdentificacion.setSelectedItem(datos.get("identificacion").get("valorModificado"));
            		spinnerAreaVolumen.setValue(Double.parseDouble(datos.get("areaVolumen").get("valorModificado")));
            		tfTemperatura.setText(datos.get("temperatura").get("valorModificado"));
                    
                    
                    JOptionPane.showMessageDialog(null, "Valores restablecidos y campos actualizados correctamente.");

                } catch (IOException | NumberFormatException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al restablecer valores:\n" + ex.getMessage());
                }
            }
        });

        
		// Fin de la logica de programacion
	}
	
    private Map<String, String> crearCampo(String valor) {
        Map<String, String> campo = new HashMap<>();
        campo.put("valorOriginal", valor);
        campo.put("valorModificado", valor);
        return campo;
    }
    
    // Método para verificar si el ítem ya está en la lista
    private boolean itemExists(JComboBox<Object> comboBox, String item) {
        for (int i = 0; i < comboBox.getItemCount(); i++) {
            if (comboBox.getItemAt(i).equals(item)) {
                return true;
            }
        }
        return false;
    }


	private void crearGSON() {
		    archivoJson = new File(OUTPUT_PATH);
	        if (!archivoJson.exists()) {
	            // Crear estructura del JSON con orden
	            Map<String, Map<String, String>> datos = new LinkedHashMap<>();

	            datos.put("balanza", crearCampo("MT_1229520536"));
	            datos.put("usuario", crearCampo(""));
	            datos.put("muestra", crearCampo(""));
	            datos.put("capsula", crearCampo("cápsula 1"));
	            datos.put("tipo", crearCampo("Montaje"));
	            datos.put("ensayo", crearCampo(""));
	            datos.put("mContacto", crearCampo(""));
	            datos.put("identificacion", crearCampo("Blanco Volumen 1"));
	            datos.put("areaVolumen", crearCampo("0.6"));
	            datos.put("temperatura", crearCampo(""));

	            // Crear carpetas si no existen
	            archivoJson.getParentFile().mkdirs();

	            // Guardar archivo JSON con formato bonito
	            try (FileWriter writer = new FileWriter(archivoJson)) {
	                Gson gson = new GsonBuilder().setPrettyPrinting().create();
	                gson.toJson(datos, writer);
	                //System.out.println("Archivo JSON creado con formato legible.");
	            } catch (IOException e) {
	                e.printStackTrace();
	                JOptionPane.showMessageDialog(this, "Error al crear archivo JSON:\n" + e.getMessage());
	            }
	        }
	}
	
	private void leerGSON() {
		   // Leer el archivo JSON existente
        gson = new Gson();
        try (FileReader reader = new FileReader(archivoJson)) {
        	java.lang.reflect.Type type = new TypeToken<Map<String, Map<String, String>>>() {}.getType();
            Map<String, Map<String, String>> datos = gson.fromJson(reader, type);

            // Rescatar los valores modificados
            valorModificadoBalanza = datos.get("balanza").get("valorModificado");
            valorModificadoUsuario = datos.get("usuario").get("valorModificado");
            valorModificadoMuestra = datos.get("muestra").get("valorModificado");
            valorModificadoCapsula = datos.get("capsula").get("valorModificado");
            valorModificadoTipo = datos.get("tipo").get("valorModificado");
            valorModificadoEnsayo = datos.get("ensayo").get("valorModificado");
            valorModificadoMContacto = datos.get("mContacto").get("valorModificado");
            valorModificadoIdentificacion = datos.get("identificacion").get("valorModificado");
            valorModificadoAreaVolumen = datos.get("areaVolumen").get("valorModificado");
            valorModificadoTemperatura = datos.get("temperatura").get("valorModificado");
            
            
            txtBalanzaDP.setText(valorModificadoBalanza);  
            txtUsuarioDP.setText(valorModificadoUsuario);
            txtMuestraDP.setText(valorModificadoMuestra);
            txtEnsayoDP.setText(valorModificadoEnsayo);
            txtMContactoDP.setText(valorModificadoMContacto);
            txtTemperaturaDP.setText(valorModificadoTemperatura);
            double numero = Double.parseDouble(valorModificadoAreaVolumen);
            spinnerAreaVolumenDP.setValue(numero);

         // Si el valor no está en la lista, lo agregamos al modelo
            if (cbIdentificacionDP.getItemCount() > 0 && !itemExists(cbIdentificacionDP, valorModificadoIdentificacion)) {
            	cbIdentificacionDP.addItem(valorModificadoIdentificacion); // Agregar el nuevo valor
            }            
            cbIdentificacionDP.setSelectedItem(valorModificadoIdentificacion);
            
            
            // Si el valor no está en la lista, lo agregamos al modelo
            if (cbCapsulaDP.getItemCount() > 0 && !itemExists(cbCapsulaDP, valorModificadoCapsula)) {
            	cbCapsulaDP.addItem(valorModificadoCapsula); // Agregar el nuevo valor
            }

            // Establecer el valor seleccionado
            cbCapsulaDP.setSelectedItem(valorModificadoCapsula);
            
            // Establecer el valor seleccionado
            cbTipoDP.setSelectedItem(valorModificadoTipo);
          
            ////////////////////////////////////////////////////////
            
            cbBalanza.setSelectedItem(valorModificadoBalanza);
    		tfCliente.setText(valorModificadoUsuario);
    		tfIdmuestra.setText(valorModificadoMuestra);	
    		cbCapsula.setSelectedItem(valorModificadoCapsula);
    		cbTipo.setSelectedItem(valorModificadoTipo);
    		tfEnsayo.setText(valorModificadoEnsayo);
    		tfMedioContacto.setText(valorModificadoMContacto);
    		cbIdentificacion.setSelectedItem(valorModificadoIdentificacion);
    		spinnerAreaVolumen.setValue(numero);
    		tfTemperatura.setText(valorModificadoTemperatura);
            
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al leer archivo JSON:\n" + e.getMessage());
        }
	}

	private void establecerCamposF(String puertoSeleccionado, String baudRate, String dataBits, String stopBits,
			String parity, String flowControl, String velocidadDeLectura) {
		cbPuerto.setSelectedItem(puertoSeleccionado);
		cbBaudRate.setSelectedItem(baudRate);
		cbDataBits.setSelectedItem(dataBits);
		cbStopBits.setSelectedItem(stopBits);
		cbParity.setSelectedItem(parity);
		cbFlowC.setSelectedItem(flowControl);
		cbVelocidadDeLectura.setSelectedItem(velocidadDeLectura);
	}

	private void establecerCamposFEC(String puertoSeleccionado, String baudRate, String dataBits, String stopBits,
			String parity,String flowControl, String velocidadDeLectura) {
		FECcbPuerto.setSelectedItem(puertoSeleccionado);
		FECcbBaudRate.setSelectedItem(baudRate);
		FECcbDataBits.setSelectedItem(dataBits);
		FECcbStopBits.setSelectedItem(stopBits);
		FECcbParity.setSelectedItem(parity);
		FECcbFlowC.setSelectedItem(flowControl);
		FECcbVelocidadDeLectura.setSelectedItem(velocidadDeLectura);
	}

	private void actualizarEstadoComponentes(boolean conectado, String puertoSeleccionado) {
		
		if(puertoSeleccionado != null) {
		
			ImageIcon iconoOriginal = new ImageIcon(PCP_DatosBalanza.class.getResource("/recursos/usb_conectadax25.png"));
			Image imagen = iconoOriginal.getImage();
			Image imagenEscalada = imagen.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
			ImageIcon iconoRedimensionado = new ImageIcon(imagenEscalada);
			
			lblDesconectado.setText("Conectado: " + puertoSeleccionado);
			lblDesconectado.setIcon(iconoRedimensionado);
			
			FEClblDesconectado.setText("Conectado: " + puertoSeleccionado);
			FEClblDesconectado.setIcon(iconoRedimensionado);
		}else {
			
			ImageIcon iconoOriginal = new ImageIcon(
			PCP_DatosBalanza.class.getResource("/recursos/usb_desconectadax25.png"));
			Image imagen = iconoOriginal.getImage();
			Image imagenEscalada = imagen.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
			ImageIcon iconoRedimensionado = new ImageIcon(imagenEscalada);
			
			lblDesconectado.setText("Desconectado:");
			lblDesconectado.setIcon(iconoRedimensionado);
			
			FEClblDesconectado.setText("Desconectado:");
			FEClblDesconectado.setIcon(iconoRedimensionado);
		}
		
		
		jMICargarPuertos.setEnabled(!conectado);
		
		lblConectar.setEnabled(!conectado);
		lblDesconectar.setEnabled(conectado);
		
		// Deshabilitar o habilitar componentes según el estado de la conexión
		cbPuerto.setEnabled(!conectado);
		cbBaudRate.setEnabled(!conectado);
		cbDataBits.setEnabled(!conectado);
		cbStopBits.setEnabled(!conectado);
		cbParity.setEnabled(!conectado);
		cbFlowC.setEnabled(!conectado);
		cbVelocidadDeLectura.setEnabled(!conectado);
		btnConectar.setEnabled(!conectado);
		btnDesconectar.setEnabled(conectado);
		
		// Actualiza también los componentes de FEC
		FECcbPuerto.setEnabled(!conectado);
		FECcbBaudRate.setEnabled(!conectado);
		FECcbDataBits.setEnabled(!conectado);
		FECcbStopBits.setEnabled(!conectado);
		FECcbParity.setEnabled(!conectado);
		FECcbFlowC.setEnabled(!conectado);
		FECcbVelocidadDeLectura.setEnabled(!conectado);
		FECbtnConectar.setEnabled(!conectado);
		FECbtnDesconectar.setEnabled(conectado);
		
		btnObtenerPeso.setEnabled(conectado);
		btnDescartarPeso.setEnabled(conectado);
	}
	
	// CODIGO QUE SI FUNCIONA (SOLUCION 1)	

	public void conectar(boolean framePrincipal) {

	    String puertoSeleccionado = "";
	    String baudRate = "";
	    String dataBits = "";
	    String stopBits = "";
	    String parity = "";
	    String flowC = "";
	    String velocidadDeLectura = "";

	    if (framePrincipal) {
	        puertoSeleccionado = (String) cbPuerto.getSelectedItem();
	        baudRate = (String) cbBaudRate.getSelectedItem();
	        dataBits = (String) cbDataBits.getSelectedItem();
	        stopBits = (String) cbStopBits.getSelectedItem();
	        parity = (String) cbParity.getSelectedItem();
	        flowC = (String) cbFlowC.getSelectedItem();
	        velocidadDeLectura = (String) cbVelocidadDeLectura.getSelectedItem();
	    } else {
	        puertoSeleccionado = (String) FECcbPuerto.getSelectedItem();
	        baudRate = (String) FECcbBaudRate.getSelectedItem();
	        dataBits = (String) FECcbDataBits.getSelectedItem();
	        stopBits = (String) FECcbStopBits.getSelectedItem();
	        parity = (String) FECcbParity.getSelectedItem();
	        flowC = (String) FECcbFlowC.getSelectedItem();
	        velocidadDeLectura = (String) FECcbVelocidadDeLectura.getSelectedItem();
	    }

	    if (puertoSeleccionado == null || puertoSeleccionado.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Por favor selecciona un puerto.", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    // Verificar si ya hay una conexión abierta en otro puerto
	    if (conectarsePuertoCOM != null && conectarsePuertoCOM.getPort().isOpen()) {
	        JOptionPane.showMessageDialog(this, "Ya hay una conexión abierta. Desconéctate primero.", "Advertencia",
	                JOptionPane.WARNING_MESSAGE);
	        return;
	    }

	    // Crear un nuevo objeto ConectarsePuertoCOM
	    conectarsePuertoCOM = new ConectarsePuertoCOM(puertoSeleccionado, baudRate, dataBits, stopBits, parity,
	    		flowC, velocidadDeLectura);

	    // Intentar abrir el puerto
	    if (conectarsePuertoCOM.getPort().openPort()) {

	        establecerCamposF(puertoSeleccionado, baudRate, dataBits, stopBits, parity, flowC, velocidadDeLectura);
	        establecerCamposFEC(puertoSeleccionado, baudRate, dataBits, stopBits, parity, flowC, velocidadDeLectura);
	        actualizarEstadoComponentes(true, puertoSeleccionado);

	        conectarsePuertoCOM.establecerConexionPuerto();

	        // Iniciar la lectura y mostrar los datos en los paneles  
	        
	        conectarsePuertoCOM.startReadingData(conectarsePuertoCOM.getPort(), data -> {
	            SwingUtilities.invokeLater(() -> {
	                try {
	                    if (data == null || data.isEmpty()) {
	                        epDatosRecibidos.setText(epDatosRecibidos.getText() + "\n  [Error] Datos vacíos o nulos recibidos.\n");
	                        return;
	                    }

	                    String[] byteStrings = data.replaceAll("[^01\\s]", "").trim().split("\\s+");
	                    StringBuilder htmlTable = new StringBuilder();
	                    StringBuilder asciiOutputLabel = new StringBuilder();
	                    
	                    // Construcción de la tabla HTML
	                    htmlTable.append("<html><body style=\"font-family: 'Courier New', monospace; font-size: 9px; line-height: 1.1;\">")
	                            .append("<table border=\"0\" cellspacing=\"0\" cellpadding=\"1\" style=\"border-collapse: collapse; margin-bottom: 5px;\">")
	                            .append("<tr style=\"border-bottom: 1px solid black;\">")
	                            .append("<th style=\"text-align: center; width: 65px; padding-right: 5px;\">BINARIO</th>")
	                            .append("<th style=\"text-align: center; width: 80px; padding-right: 5px;\">DECIMAL</th>")
	                            .append("<th style=\"text-align: center; width: 45px; padding-right: 5px;\">HEX</th>")
	                            .append("<th style=\"text-align: center; width: 55px; padding-right: 5px;\">UNICODE</th>")
	                            .append("<th style=\"text-align: center; width: 70px; padding-right: 5px;\">ISO-8859-1</th>")
	                            .append("<th style=\"text-align: center; width: 55px; padding-right: 5px;\">CP437</th>")
	                            .append("<th style=\"text-align: center; width: 65px; padding-right: 5px;\">WIN-1252</th>")
	                            .append("<th style=\"text-align: center; width: 55px;\">ASCII</th>")
	                            .append("</tr>");

	                    for (String byteString : byteStrings) {
	                        if (byteString.length() != 8) continue;

	                        try {
	                            int decimalValue = Integer.parseInt(byteString, 2);
	                            byte b = (byte) decimalValue;
	                            
	                            String hex = String.format("0x%02X", decimalValue);
	                           
	                            // Caracteres escapados para HTML
	                            String unicode = (decimalValue >= 32 && decimalValue <= 126) ?
	                                    escapeHtml(String.valueOf((char) decimalValue)) : "�";
	                            
	                            String iso = escapeHtml(getSafeChar(decimalValue, "ISO-8859-1"));
	                            String cp437 = escapeHtml(getSafeChar(decimalValue, "CP437"));
	                            String win1252 = escapeHtml(getSafeChar(decimalValue, "Windows-1252"));
	                            String ascii = (decimalValue >= 32 && decimalValue <= 126) ? 
	                                          escapeHtml(String.valueOf((char) decimalValue)) : "[NPI]";

	                            htmlTable.append("<tr>")
	                                    .append(String.format("<td style=\"width: 65px; padding-right: 5px; text-align: center;\">%s</td>", byteString))
	                                    .append(String.format("<td style=\"width: 80px; padding-right: 5px; text-align: center;\">S:%3d|U:%3d</td>", b, decimalValue & 0xFF))
	                                    .append(String.format("<td style=\"width: 45px; padding-right: 5px; text-align: center;\">%s</td>", hex))
	                                    .append(String.format("<td style=\"width: 55px; padding-right: 5px; text-align: center;\">%s</td>", unicode))
	                                    .append(String.format("<td style=\"width: 65px; padding-right: 5px; text-align: center;\">%s</td>", iso))
	                                    .append(String.format("<td style=\"width: 55px; padding-right: 5px; text-align: center;\">%s</td>", cp437))
	                                    .append(String.format("<td style=\"width: 65px; padding-right: 5px; text-align: center;\">%s</td>", win1252))
	                                    .append(String.format("<td style=\"width: 55px; text-align: center;\">%s</td>", ascii))
	                                    .append("</tr>");

	                            asciiOutputLabel.append(getSafeChar(decimalValue, "ISO-8859-1"));
	                        } catch (Exception e) {
	                            System.err.println("Error procesando: " + byteString);
	                        }
	                    }

	                    // Cerrar tabla y añadir mensaje ASCII
	                    htmlTable.append("</table>")
	                            .append("<div style=\"margin: 10px 0; font-family: 'Courier New'; font-size: 10px;\">")
	                            .append("Texto ASCII limpio: \"")
	                            .append(escapeHtml(asciiOutputLabel.toString()))
	                            .append("\"</div>")
	                            .append("</body></html>");

	                    // Enviar al editor
	                    appendHtmlContent(epDatosRecibidos, htmlTable.toString());
	                    lblPesoBalanza.setText(filtrarDatos(asciiOutputLabel.toString()));
	                    
	                } catch (Exception e) {
	                    epDatosRecibidos.setText(epDatosRecibidos.getText() + "\n[Error] " + e.getMessage() + "\n");
	                }
	            });
	        });

	    } else {
	    	
	        JOptionPane.showMessageDialog(this, "No se pudo abrir el puerto", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}
	
	private void desconectar() {
	
		actualizarEstadoComponentes(false, null);
		conectarsePuertoCOM.cerrarConexion();
	}

	private void limpiarPaneles() {
	    lblPesoBalanza.setText("0.0 " + unidad);
	    contadorRegistrosTablaDatos = 1;
	    epDatosRecibidos.setText("");
	    cadenaDatos = "";
	    
	    // Vaciar el ArrayList en lugar de crear uno nuevo
	    datosFiltrados.clear(); // Esto vacía el ArrayList sin crear uno nuevo

	    eliminarCopiaDatosExcel();

	    tablaDatos.limpiarFilas();
	}


	private void exportar() {
		try {
			// Leer la ruta guardada
			String rutaGuardada = RutaGuardada.leerRuta();

			// Validar si la ruta guardada es válida; si no, usar el Escritorio por defecto
			String rutaFinal;
			if (rutaGuardada != null && !rutaGuardada.isEmpty()) {
				File carpeta = new File(rutaGuardada);
				if (carpeta.exists() && carpeta.isDirectory()) {
					rutaFinal = rutaGuardada;
				} else {
					// System.out.println("La ruta guardada no es válida. Usando Escritorio por
					// defecto.");
					rutaFinal = System.getProperty("user.home") + "\\Desktop";
				}
			} else {
				// System.out.println("No se encontró ruta guardada. Usando Escritorio por
				// defecto.");
				rutaFinal = System.getProperty("user.home") + "\\Desktop";
			}

			// Formatear la fecha actual
			fechaTablaResultados = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());

			// Generar la ruta completa para guardar el archivo
			desktopPath = rutaFinal + "\\" + nomArchivoExcel + "_" + fechaTablaResultados + extension;

			// System.out.println("Ruta completa para el archivo Excel: " + desktopPath);

			// Crear el archivo Excel
			Excel.crearExcelXlsx(datosFiltrados, nomArchivoExcel, desktopPath);

			// Actualizar la tabla con la información del archivo exportado
			listarArchivosExcelExportados();

			// Ejecutar macro en el archivo generado
			//ejecutarMacroExcel(desktopPath, "miMacro");
			
			// Limpiar los paneles
			limpiarPaneles();
			
			

		} catch (Exception ex) {
			// System.err.println("Error al exportar el archivo Excel: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	private void exportarComo() {
		// Ejecutar la lógica de JavaFX en el hilo adecuado
		javafx.application.Platform.runLater(() -> {
			// Crear el selector de carpetas
			DirectoryChooser selectorDeCarpeta = new DirectoryChooser();
			selectorDeCarpeta.setTitle("Seleccionar Carpeta de Exportación");

			// Carpeta inicial (opcional)
			selectorDeCarpeta.setInitialDirectory(new File(System.getProperty("user.home")));

			// Mostrar el selector de carpetas
			File carpetaSeleccionada = selectorDeCarpeta.showDialog(null);

			// Verificar si se seleccionó una carpeta
			if (carpetaSeleccionada != null) {
				// System.out.println("Carpeta seleccionada: " +
				// carpetaSeleccionada.getAbsolutePath());

				fechaTablaResultados = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());

				desktopPath = carpetaSeleccionada.getAbsolutePath() + "\\" + nomArchivoExcel + "_"
						+ fechaTablaResultados + extension;

				Excel.crearExcelXlsx(datosFiltrados, nomArchivoExcel, desktopPath);

				listarArchivosExcelExportados();

				limpiarPaneles();

			} else {
				JOptionPane.showMessageDialog(null, "No se seleccionó ninguna carpeta.", "Advertencia", JOptionPane.WARNING_MESSAGE);
			}
		});
	}

	// Funcion para colocar los datos exportados en la tabla de Resultados
	private void listarArchivosExcelExportados() {
		// Crear una fila de datos
		Object[] nuevaFila = new Object[] { contadorRegistroTablaResultado,
				nomArchivoExcel + "_" + fechaTablaResultados + extension, desktopPath, fechaTablaResultados };

		modeloTablaResultados.addRow(nuevaFila);

		contadorRegistroTablaResultado++;

	}
	
	public void ejecutarMacroExcel(String rutaArchivo, String nombreMacro) {
	    ActiveXComponent excel = new ActiveXComponent("Excel.Application");
	    try {
	        excel.setProperty("Visible", new Variant(false)); // No mostrar Excel

	        Dispatch workbooks = excel.getProperty("Workbooks").toDispatch();
	        Dispatch workbook = Dispatch.call(workbooks, "Open", rutaArchivo).toDispatch();

	        // Ejecutar la macro
	        excel.invoke("Run", new Variant(nombreMacro));

	        // Cerrar sin guardar (o true si quieres guardar)
	        Dispatch.call(workbook, "Close", new Variant(false));
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        excel.invoke("Quit", new Variant[] {});
	    }
	}

	
	
	private String filtrarDatos(String cadena) {	
		// Crear los matchers
		Matcher matcher = pattern.matcher(cadena);

		// Variable para almacenar el dato filtrado
		String datoFiltrado = null;

		// Buscar gramos
		while (matcher.find()) {
			datoFiltrado = matcher.group(); // Si se encuentra un valor en gramos, lo guarda
		}

		// Si no se encuentra ninguna coincidencia, asignar "0.0"
		if (datoFiltrado == null) {
			datoFiltrado = "0.0 " + unidad;
		}

		return datoFiltrado;
	}
	
	// Método para escapar caracteres HTML (debe estar en tu clase)
	private String escapeHtml(String input) {
	    if (input == null) return "";
	    return input.replace("&", "&amp;")
	                .replace("<", "&lt;")
	                .replace(">", "&gt;")
	                .replace("\"", "&quot;");
	                //.replace("'", "&apos;");
	}

    // Método auxiliar para caracteres seguros
	private String getSafeChar(int decimalValue, String charsetName) {
	    try {
	        byte[] bytes = {(byte) decimalValue};
	        String str = new String(bytes, Charset.forName(charsetName));
	        char c = str.charAt(0);
	        
	        if (Character.isISOControl(c)) {
	            return "[CTRL]";
	        } else if (!Character.isDefined(c)) {
	            return "[UND]";
	        } else if (c > 127 && c < 160) {
	            return String.format("[%03d]", decimalValue);
	        }
	        return str;
	    } catch (Exception e) {
	        return String.format("[ERR:%02X]", decimalValue);
	    }
	}
	
	/*
	 	// Método auxiliar para obtener caracteres seguros (ya lo tenías)
		private String getSafeChar(int decimalValue, String charsetName) {
		    try {
		        byte[] bytes = {(byte) decimalValue};
		        return new String(bytes, charsetName);
		    } catch (Exception e) {
		        return "�";
		    }
		}
	 */
	
	
	// 1. INICIALIZACIÓN (en tu constructor o método setup):
	private void inicializarEditorPane() {
	    epDatosRecibidos.setEditorKit(new HTMLEditorKit());
	    epDatosRecibidos.setContentType("text/html");
	    // Documento inicial con estilos CSS embebidos
	    epDatosRecibidos.setText("<html><head><style>"
	            + "body { font-family: 'Courier New', monospace; font-size: 10px; line-height: 1.1; background: white; }"
	            + "table { border-collapse: collapse; margin-bottom: 10px; }"
	            + "th, td { text-align: center; padding: 2px 5px; }"
	            + "hr { margin: 5px 0; }"
	            + "</style></head><body></body></html>");
	}
	
	
	private void appendHtmlContent(JEditorPane editor, String newHtml) {
	    SwingUtilities.invokeLater(() -> {
	        try {
	            String bodyContent = newHtml.replaceAll("(?si).*?<body.*?>(.*?)</body>.*", "$1");
	            HTMLEditorKit kit = (HTMLEditorKit) editor.getEditorKit();
	            HTMLDocument doc = (HTMLDocument) editor.getDocument();
	            
	            if (doc.getLength() > 0) {
	                // SOLO CAMBIA ESTA LÍNEA - Añade espacio invisible:
	                kit.insertHTML(doc, doc.getLength(), 
	                    "<div style='height: 25px;'></div>", // 25px de espacio (ajusta este valor)
	                    0, 0, null);
	            }
	            
	            kit.insertHTML(doc, doc.getLength(), bodyContent, 0, 0, null);
	            editor.setCaretPosition(doc.getLength());
	            
	        } catch (Exception e) {
	            String current = editor.getText().replace("</body></html>", "");
	            editor.setText(current + newHtml);
	            System.err.println("Error al añadir HTML: " + e.getMessage());
	        }
	    });
	}
	
	private String obtenerSerial(String balanza) {
		Balanzas miBalanza = null;
		String serial;
		if (balanza.equals("MT_1229520536")) {
			miBalanza = Balanzas.MT_1229520536;
			serial = miBalanza.getNumSerial();
		}else {
			serial = balanza;
		}
		
		return serial;
	}

	
	private void verificarCopiaDatosExcelAlmacenados() {
	    // Ruta del archivo Excel
	    String filePath = "archivosComplementarios/datos_incrementales.xlsx";
	    File file = new File(filePath);

	    // Verificar si el archivo existe
	    if (!file.exists()) {
	        contadorRegistrosTablaDatos = 0; // Iniciar desde cero si no existe archivo
	        return;
	    }

	    // Leer el archivo Excel
	    List<Object[]> filasLeidas = DynamicExcelReader.leerExcel(filePath);

	    // Verificar si el archivo tiene datos
	    if (filasLeidas == null || filasLeidas.isEmpty()) {
	        contadorRegistrosTablaDatos = 0; // Iniciar desde cero si el archivo está vacío
	        return;
	    }

	    int maxContador = 0; // Para llevar el control del número más alto

	    for (Object[] fila : filasLeidas) {
	        if (fila == null || fila.length < 13) continue;

	        try {
	            int contador = (int) fila[0];
	            String nombreCapsulsa = (String) fila[1];
	            String tipo = (String) fila[2];
	            String idMuestra = (String) fila[3];
	            String ensayo = (String) fila[4];
	            String medioContacto = (String) fila[5];
	            String identificacion = (String) fila[6];
	            Double volumenDouble = (Double) fila[7];
	            String areaVolumenTablaDatosString = String.format("%.1f", volumenDouble);
	            String pesoStr = (String) fila[8];
	            String temperatura = (String) fila[9];
	            String fecha = (String) fila[10];
	            String hora = (String) fila[11];
	            String nombreUsuario = (String) fila[12];
	            String serialBalanza = (String) fila[13];

	            // Actualizar el máximo contador si es necesario
	            if (contador > maxContador) {
	                maxContador = contador;
	            }

	            // Fila para lógica interna
	            Object[] nuevaFila = new Object[] {
	                contador,
	                nombreCapsulsa,
	                tipo,
	                idMuestra,
	                ensayo,
	                medioContacto,
	                identificacion,
	                volumenDouble,
	                pesoStr,
	                temperatura,
	                fecha,
	                hora,
	                nombreUsuario,
	                serialBalanza
	            };

	            // Fila para mostrar en la tabla
	            Object[] nuevaFila2 = new Object[] {
	                contador,
	                nombreCapsulsa,
	                tipo,
	                idMuestra,
	                ensayo,
	                medioContacto,
	                identificacion,
	                areaVolumenTablaDatosString,
	                pesoStr,
	                temperatura,
	                fecha,
	                hora,
	                nombreUsuario,
	                serialBalanza
	            };

	            // Agregar datos
	            datosFiltrados.add(nuevaFila);
	            ((TablaPersonalizada) tablaDatos).addRow(nuevaFila2);

	        } catch (Exception e) {
	            System.err.println("Error al leer una fila del archivo Excel: " + e.getMessage());
	            e.printStackTrace();
	        }
	    }

	    // Actualizar el contador con el valor más alto encontrado
	    contadorRegistrosTablaDatos = maxContador;
	}



	private void verificarPuertosDisponibles() {
	    // Limpiamos el contenido de los combo boxes
	    cbPuerto.removeAllItems();
	    FECcbPuerto.removeAllItems();
	    
	    cbPuerto.addItem("");
	    FECcbPuerto.addItem("");
	    
	    // Cargamos los puertos disponibles
	    ConectarsePuertoCOM.cargarPuertosDisponibles();

	    // Llenamos los combo boxes con los puertos disponibles
	    for (String puerto : ConectarsePuertoCOM.obtenerPuertos()) {
	        cbPuerto.addItem(puerto);
	        FECcbPuerto.addItem(puerto);
	    }
	}

	// Metodo elimina la copia de los datos obtenidos (Esta funcion es llamada
	// dentro de la funcion "limpiarPaneles()")
	private void eliminarCopiaDatosExcel() {
		// Ruta del archivo a eliminar
		String rutaArchivo = "archivosComplementarios/datos_incrementales.xlsx";
		// Llamar a la función para eliminar el archivo
		boolean resultado = Excel.eliminarArchivo(rutaArchivo);

		if (resultado) {
			// System.out.println("El archivo fue eliminado correctamente.");
		} else {
			// System.err.println("No se pudo eliminar el archivo.");
		}
	}

	/*
	 * Esta funcion la he creado debido a que he creamo mi propia clase layout
	 * (MyCustomLayout) y al agregar componentes swing a ese layout hay un punto en
	 * que no se terminan de pintar bien y solo lo hacen de forma correcta cuando
	 * redimenciono el Frame principal.
	 */
	private void forceRepaint() {

		// Forzar actualización del layout y redibujar
		SwingUtilities.invokeLater(() -> {
			revalidate(); // Recalcula los tamaños
			repaint(); // Redibuja los componentes
			doLayout(); // Forzar cálculo del layout
		});
	}

}
