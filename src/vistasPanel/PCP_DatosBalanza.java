package vistasPanel;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

public class PCP_DatosBalanza extends JPanel {
	// Variables del panelFila1 para su uso externo
     private JLabel lblDesconectado;
     private JComboBox<Object> cbPuerto;
	 private JComboBox<Object>  cbBaudRate;
	 private JComboBox<Object>  cbDataBits;
	 private JComboBox<Object>  cbStopBits;
	 private JComboBox<Object>  cbParity;
	 private JComboBox<Object>  cbFlowC;
	 private JComboBox<Object>  cbVelocidadDeLectura;
	 private JButton btnConectar ; 
	 private JButton btnDesconectar;
  
	 
	// Variables del panelFila2 para su uso externo
     private JComboBox<Object> cbBalanza;
     private JTextField tfUsuario;  // El tamaño ya lo hemos establecido
     private JTextField tfIdmuestra;  // El tamaño ya lo hemos establecido
     private JComboBox<Object> cbCapsula;
	 private JComboBox<Object> cbTipo; // Montaje o Desmontaje
     private JTextField tfEnsayo; 
     private JTextField tfMedioContacto;
     private JComboBox<Object> cbIdentificacion;
     private SpinnerNumberModel spAreaVolumen;
     private JSpinner spinnerAreaVolumen;
     private JTextField tfTemperatura;
     
	// Variables del panelFila3 para su uso externo
     private JLabel lblPesoBalanza;
     private JButton btnObtenerPeso;
     private JButton btnDescartarPeso;
   
 
	 private GridBagConstraints gbc_cbBalanza;
	 private GridBagConstraints gbc_tfCliente;
	 private GridBagConstraints gbc_tfUsuario;
	 private GridBagConstraints gbc_cbCapsula;
	 private GridBagConstraints gbc_lblDesconectado;


    public PCP_DatosBalanza() {
        setLayout(new BorderLayout(0, 0));
        setMinimumSize(new Dimension(290, 50));
        
        // Panel superior en el norte
        JPanel panel = new JPanel();
        add(panel, BorderLayout.NORTH);
        
        JLabel lblNewLabel = new JLabel("ADMINISTRADOR DE PESAJE");
        panel.add(lblNewLabel);

        // Panel de contenido en el centro
        JPanel panelContenido = new JPanel();

        // Configurar GridBagLayout para el panelContenido
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0}; // Tres filas
        gridBagLayout.columnWeights = new double[]{1.0};
        gridBagLayout.rowWeights = new double[]{0.2, 0.2, 0.2}; // Tamaño relativo de las filas

        panelContenido.setLayout(gridBagLayout);

        //################################ Primera fila ################################
        JPanel panelFila1 = new JPanel();
        panelFila1.setLayout(new BorderLayout(0, 0));
        //panelFila1.setBackground(Color.CYAN); // Color para distinguir visualmente
        
        GridBagConstraints gbc_pf1 = new GridBagConstraints();
        gbc_pf1.insets = new Insets(5, 5, 5, 5); // Espaciado opcional
        gbc_pf1.fill = GridBagConstraints.BOTH;
        gbc_pf1.gridx = 0;
        gbc_pf1.gridy = 0;
        
        JLabel lblTitulo_pan_fil1 = new JLabel("Configuración del puerto COM");
        lblTitulo_pan_fil1.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo_pan_fil1.setBackground(Color.LIGHT_GRAY);
        lblTitulo_pan_fil1.setOpaque(true); // Hacer que el fondo sea visible
        panelFila1.add(lblTitulo_pan_fil1, BorderLayout.NORTH);
        
        JPanel pan_cont_fl_lay_fil1 = new JPanel();
        panelFila1.add(pan_cont_fl_lay_fil1, BorderLayout.WEST);
               
        JPanel pan_cont_gr_bag_lay_fil1 = new JPanel();
        pan_cont_gr_bag_lay_fil1.setLayout(new GridBagLayout());
        
        pan_cont_fl_lay_fil1.add(pan_cont_gr_bag_lay_fil1);
      
        // Crear las etiquetas
        JLabel lblEstado = new JLabel("Estado: ");
        lblEstado.setHorizontalAlignment(SwingConstants.CENTER);
        
        lblDesconectado= new JLabel("Desconectado");
        lblDesconectado.setHorizontalAlignment(SwingConstants.CENTER);
        ImageIcon iconoOriginal = new ImageIcon(PCP_DatosBalanza.class.getResource("/recursos/usb_desconectadax25.png"));
        Image imagen = iconoOriginal.getImage();
        Image imagenEscalada = imagen.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado = new ImageIcon(imagenEscalada);
        lblDesconectado.setIcon(iconoRedimensionado);

        JLabel lblPuerto = new JLabel("Port");
        JLabel lblBaudRate = new JLabel("Baud Rate");
        JLabel lblDataBits = new JLabel("Data Bits");
        JLabel lblStopBits = new JLabel("Stop Bits");
        JLabel lblParity = new JLabel("Parity");
        JLabel lblFlowControl = new JLabel("Flow Control");
        JLabel lblVelocidadDeLectura = new JLabel("Waiting Time");

        // Crear JComboBox y JTextField
        cbPuerto = new JComboBox<Object>(new String[] {""});
        cbPuerto.setBackground(Color.WHITE); // Color de fondo
        cbPuerto.setForeground(Color.DARK_GRAY); // Color del texto
        
        cbBaudRate = new JComboBox<Object>(new String[] {
        	    "100", "300", "600", "1200", "2400", "4800", "9600", "14400", "19200", "38400", 
        	    "56000", "57600", "115200", "128000", "256000"
        	});
        cbBaudRate.setSelectedItem("2400");
        cbBaudRate.setBackground(Color.WHITE); // Color de fondo
        cbBaudRate.setForeground(Color.DARK_GRAY); // Color del texto
        
        cbDataBits = new JComboBox<Object>(new String[] {"5" ,"6", "7", "8"});
        cbDataBits.setSelectedItem("7");
        cbDataBits.setBackground(Color.WHITE); // Color de fondo
        cbDataBits.setForeground(Color.DARK_GRAY); // Color del texto
        
        cbStopBits = new JComboBox<Object>(new String[] {"1.0", "1.5", "2.0"});
        cbStopBits.setSelectedItem("1.0");
        cbStopBits.setBackground(Color.WHITE); // Color de fondo
        cbStopBits.setForeground(Color.DARK_GRAY); // Color del texto
        
        cbParity = new JComboBox<Object>(new String[] {"NO_PARITY", "EVEN_PARITY", "ODD_PARITY", "MARK_PARITY", "SPACE_PARITY"});
        cbParity.setSelectedItem("EVEN_PARITY");
        cbParity.setBackground(Color.WHITE); // Color de fondo
        cbParity.setForeground(Color.DARK_GRAY); // Color del texto
        
        cbFlowC = new JComboBox<Object>(new String[] {"NONE", "Hardware (RTS/CTS)", "Hardware (CTS only)", "Hardware (DSR/DTR)", "Hardware (DTR only)", "Soft (XON/XOFF entrada)", "Soft (XON/XOFF salida)", "Combinación RTS + CTS"});
        cbFlowC.setSelectedItem("NONE");
        cbFlowC.setBackground(Color.WHITE); // Color de fondo
        cbFlowC.setForeground(Color.DARK_GRAY); // Color del texto
        
        cbVelocidadDeLectura = new JComboBox<Object>(new String[] {
        	    "100", "200", "300", "400", "500", "600", "700", "800", "900", "1000",
        	    "1100", "1200", "1300", "1400", "1500", "1600", "1700", "1800", "1900", "2000",
        	    "2100", "2200", "2300", "2400", "2500", "2600", "2700", "2800", "2900", "3000",
        	    "3100", "3200", "3300", "3400", "3500", "3600", "3700", "3800", "3900", "4000",
        	    "4100", "4200", "4300", "4400", "4500", "4600", "4700", "4800", "4900", "5000"
        	});
        cbVelocidadDeLectura.setSelectedItem("100");
        cbVelocidadDeLectura.setBackground(Color.WHITE); // Color de fondo
        cbVelocidadDeLectura.setForeground(Color.DARK_GRAY); // Color del texto
        
        // Establecer tamaño preferido de los campos de texto y combo
        Dimension preferredSizeDer = new Dimension(150, 25);  // Tamaño similar para todos los componentes que estan a la derecha
        Dimension preferredSizeIzq = new Dimension(100, 25);  // Tamaño similar para todos los componentes que estan a la izquierda
        
        lblVelocidadDeLectura.setPreferredSize(preferredSizeIzq);
        
        cbPuerto.setPreferredSize(preferredSizeDer);
        cbBaudRate.setPreferredSize(preferredSizeDer);
        cbDataBits.setPreferredSize(preferredSizeDer);
        cbStopBits.setPreferredSize(preferredSizeDer);
        cbParity.setPreferredSize(preferredSizeDer);
        cbFlowC.setPreferredSize(preferredSizeDer);
        cbVelocidadDeLectura.setPreferredSize(preferredSizeDer);
        
        // Configurar las restricciones
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);  // Espaciado entre componentes

        // Configurar la primera columna (columna 0)
        gbc.gridx = 0;
        gbc.weightx = 0.3;  // Primera columna será más estrecha
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 0.0; // No queremos que esta columna ocupe mucho espacio vertical

        GridBagConstraints gbcLbl;

        // Agregar etiquetas en la primera columna
        gbcLbl = new GridBagConstraints();
        gbcLbl.gridx = 0;
        gbcLbl.gridy = 0;
        gbcLbl.fill = GridBagConstraints.HORIZONTAL;
        pan_cont_gr_bag_lay_fil1.add(lblEstado, gbcLbl);

        gbcLbl = new GridBagConstraints();
        gbcLbl.gridx = 0;
        gbcLbl.gridy = 1;
        gbcLbl.fill = GridBagConstraints.HORIZONTAL;
        pan_cont_gr_bag_lay_fil1.add(lblPuerto, gbcLbl);

        gbcLbl = new GridBagConstraints();
        gbcLbl.gridx = 0;
        gbcLbl.gridy = 2;
        gbcLbl.fill = GridBagConstraints.HORIZONTAL;
        pan_cont_gr_bag_lay_fil1.add(lblBaudRate, gbcLbl);

        gbcLbl = new GridBagConstraints();
        gbcLbl.gridx = 0;
        gbcLbl.gridy = 3;
        gbcLbl.fill = GridBagConstraints.HORIZONTAL;
        pan_cont_gr_bag_lay_fil1.add(lblDataBits, gbcLbl);

        gbcLbl = new GridBagConstraints();
        gbcLbl.gridx = 0;
        gbcLbl.gridy = 4;
        gbcLbl.fill = GridBagConstraints.HORIZONTAL;
        pan_cont_gr_bag_lay_fil1.add(lblStopBits, gbcLbl);

        gbcLbl = new GridBagConstraints();
        gbcLbl.gridx = 0;
        gbcLbl.gridy = 5;
        gbcLbl.fill = GridBagConstraints.HORIZONTAL;
        pan_cont_gr_bag_lay_fil1.add(lblParity, gbcLbl);

        gbcLbl = new GridBagConstraints();
        gbcLbl.gridx = 0;
        gbcLbl.gridy = 6;
        gbcLbl.fill = GridBagConstraints.HORIZONTAL;
        pan_cont_gr_bag_lay_fil1.add(lblFlowControl, gbcLbl);
        
        gbcLbl = new GridBagConstraints();
        gbcLbl.gridx = 0;
        gbcLbl.gridy = 7;
        gbcLbl.fill = GridBagConstraints.HORIZONTAL;
        pan_cont_gr_bag_lay_fil1.add(lblVelocidadDeLectura, gbcLbl);

        // Configurar la segunda columna (columna 1)
        gbc.gridx = 1;
        gbc.weightx = 0.7;  // Segunda columna será más ancha
        gbc.fill = GridBagConstraints.HORIZONTAL;

        GridBagConstraints gbcComp;

        // Colocar los componentes en la segunda columna
        gbc_lblDesconectado = new GridBagConstraints();
        gbc_lblDesconectado.gridx = 1;
        gbc_lblDesconectado.gridy = 0;
        gbc_lblDesconectado.insets = new Insets(4, 5, 4, 5); // Espaciado vertical ligeramente mayor
        gbc_lblDesconectado.fill = GridBagConstraints.HORIZONTAL;
        pan_cont_gr_bag_lay_fil1.add(lblDesconectado, gbc_lblDesconectado);

        gbcComp = new GridBagConstraints();
        gbcComp.gridx = 1;
        gbcComp.gridy = 1;
        gbcComp.insets = new Insets(4, 5, 4, 5); // Espaciado vertical ligeramente mayor
        gbcComp.fill = GridBagConstraints.HORIZONTAL;
        pan_cont_gr_bag_lay_fil1.add(cbPuerto, gbcComp);

        gbcComp = new GridBagConstraints();
        gbcComp.gridx = 1;
        gbcComp.gridy = 2;
        gbcComp.insets = new Insets(4, 5, 4, 5); // Espaciado vertical ligeramente mayor
        gbcComp.fill = GridBagConstraints.HORIZONTAL;
        pan_cont_gr_bag_lay_fil1.add(cbBaudRate, gbcComp);

        gbcComp = new GridBagConstraints();
        gbcComp.gridx = 1;
        gbcComp.gridy = 3;
        gbcComp.insets = new Insets(4, 5, 4, 5); // Espaciado vertical ligeramente mayor
        gbcComp.fill = GridBagConstraints.HORIZONTAL;
        pan_cont_gr_bag_lay_fil1.add(cbDataBits, gbcComp);

        gbcComp = new GridBagConstraints();
        gbcComp.gridx = 1;
        gbcComp.gridy = 4;
        gbcComp.insets = new Insets(4, 5, 4, 5); // Espaciado vertical ligeramente mayor
        gbcComp.fill = GridBagConstraints.HORIZONTAL;
        pan_cont_gr_bag_lay_fil1.add(cbStopBits, gbcComp);

        gbcComp = new GridBagConstraints();
        gbcComp.gridx = 1;
        gbcComp.gridy = 5;
        gbcComp.insets = new Insets(4, 5, 4, 5); // Espaciado vertical ligeramente mayor
        gbcComp.fill = GridBagConstraints.HORIZONTAL;
        pan_cont_gr_bag_lay_fil1.add(cbParity, gbcComp);

        gbcComp = new GridBagConstraints();
        gbcComp.gridx = 1;
        gbcComp.gridy = 6;
        gbcComp.insets = new Insets(4, 5, 4, 5); // Espaciado vertical ligeramente mayor
        gbcComp.fill = GridBagConstraints.HORIZONTAL;
        pan_cont_gr_bag_lay_fil1.add(cbFlowC, gbcComp);
        
        gbcComp = new GridBagConstraints();
        gbcComp.gridx = 1;
        gbcComp.gridy = 7;
        gbcComp.insets = new Insets(4, 5, 4, 5); // Espaciado vertical ligeramente mayor
        gbcComp.fill = GridBagConstraints.HORIZONTAL;
        pan_cont_gr_bag_lay_fil1.add(cbVelocidadDeLectura, gbcComp);

        JPanel pan_cont_footer_fil1 = new JPanel();
        panelFila1.add(pan_cont_footer_fil1, BorderLayout.SOUTH);
        
        btnConectar = new JButton("Conectar");
        pan_cont_footer_fil1.add(btnConectar);
        
        btnDesconectar= new JButton("Desconectar");
        btnDesconectar.setEnabled(false);
        pan_cont_footer_fil1.add(btnDesconectar);

        panelContenido.add(panelFila1, gbc_pf1);
          
        //################################ Segunda fila ################################
        JPanel panelFila2 = new JPanel();
        panelFila2.setLayout(new BorderLayout(0, 0));
        //panelFila2.setBackground(Color.ORANGE); // Color para distinguir visualmente
        
        GridBagConstraints gbc_fila2 = new GridBagConstraints();
        gbc_fila2.insets = new Insets(5, 5, 5, 5); // Espaciado opcional
        gbc_fila2.fill = GridBagConstraints.BOTH;
        gbc_fila2.gridx = 0;
        gbc_fila2.gridy = 1;
        
        panelContenido.add(panelFila2, gbc_fila2);
        
        JLabel lblTitulo_pan_fil2 = new JLabel("Campos usuario");
        lblTitulo_pan_fil2.setBackground(Color.LIGHT_GRAY);
        lblTitulo_pan_fil2.setOpaque(true); // Hacer que el fondo sea visible
        lblTitulo_pan_fil2.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo_pan_fil2.setHorizontalAlignment(SwingConstants.CENTER);
   
        panelFila2.add(lblTitulo_pan_fil2, BorderLayout.NORTH);
        
        JPanel pan_cont_fl_lay_fil2 = new JPanel();
        panelFila2.add(pan_cont_fl_lay_fil2, BorderLayout.WEST);
        
        JPanel pan_cont_gr_bag_lay_fil2 = new JPanel();
        pan_cont_gr_bag_lay_fil2.setLayout(new GridBagLayout());  // Usamos GridBagLayout
        pan_cont_fl_lay_fil2.add(pan_cont_gr_bag_lay_fil2);
      

        // Crear las etiquetas
        JLabel lblBalanza = new JLabel("Balanza");
        JLabel lblUsuario = new JLabel("Usuario");
        JLabel lblIdmuestra = new JLabel("Id_muestra");
        JLabel lblCapsula = new JLabel("Cápsula");
        JLabel lblTipo = new JLabel("Tipo");
        JLabel lblEnsayo = new JLabel("Ensayo");
        JLabel lblMedio = new JLabel("Medio Contacto");
        JLabel lblIdentificacion = new JLabel("Identificación");
        JLabel lblArea = new JLabel("A Vol [dm 2/L]");
        JLabel lblTemperatura = new JLabel("Temperatura");
        

        // Crear los JComboBox y JTextField
        cbBalanza = new JComboBox<Object> (new String[] {"MT_1229520536"});
        cbBalanza.setEditable(true);
        cbBalanza.setBackground(Color.WHITE); // Color de fondo
        cbBalanza.setForeground(Color.DARK_GRAY); // Color del texto
        
        tfUsuario = new JTextField(10);  // El tamaño ya lo hemos establecido
        
        tfIdmuestra = new JTextField(10);  // El tamaño ya lo hemos establecido
        
        cbCapsula = new JComboBox<Object> (new String[] {
        	    "cápsula 1", "cápsula 2", "cápsula 3", "cápsula 4", "cápsula 5", "cápsula 6",
        	    "cápsula 7", "cápsula 8", "cápsula 9", "cápsula 10", "cápsula 11", "cápsula 12",
        	    "cápsula 13", "cápsula 14", "cápsula 15", "cápsula 16", "cápsula 17", "cápsula 18",
        	    "cápsula 19", "cápsula 20", "cápsula 21", "cápsula 22", "cápsula 23", "cápsula 24",
        	    "cápsula 25", "cápsula 26", "cápsula 27", "cápsula 28", "cápsula 29", "cápsula 30",
        	    "cápsula 31", "cápsula 32", "cápsula 33", "cápsula 34", "cápsula 35", "cápsula 36",
        	    "cápsula 37", "cápsula 38", "cápsula 39", "cápsula 40", "cápsula 41", "cápsula 42",
        	    "cápsula 43", "cápsula 44", "cápsula 45", "cápsula 46", "cápsula 47", "cápsula 48",
        	    "cápsula 49", "cápsula 50"
        	});

        cbCapsula.setBackground(Color.WHITE); // Color de fondo
        cbCapsula.setForeground(Color.DARK_GRAY); // Color del texto
        cbCapsula.setEditable(true);
        
        cbTipo = new JComboBox<Object> (new String[] {"Montaje", "Desmontaje"});
        cbTipo.setBackground(Color.WHITE); // Color de fondo
        cbTipo.setForeground(Color.DARK_GRAY); // Color del texto
        
        tfEnsayo = new JTextField(10);
        tfEnsayo.setText("");
        
        tfMedioContacto = new JTextField(10);
        tfMedioContacto.setText("");
        
        cbIdentificacion  = new JComboBox<Object> (new String[] {
        	    "Blanco Volumen 1", "Blanco Volumen 2", "Control 1", "Control 2", "Otro"
        	});
        cbIdentificacion.setBackground(Color.WHITE); // Color de fondo
        cbIdentificacion.setForeground(Color.DARK_GRAY); // Color del texto
        cbIdentificacion.setEditable(true);
        
        // Valor inicial: 0.0, mínimo: 0.0, máximo: 10.0, paso: 0.1
        spAreaVolumen = new SpinnerNumberModel(0.6, 0.0, 2.0, 0.1);
        spinnerAreaVolumen = new JSpinner(spAreaVolumen);
      
        tfTemperatura = new JTextField(10);
        tfTemperatura.setText("");
        
        // Establecer tamaño preferido de los campos de texto y combo
        Dimension preferredSize1 = new Dimension(150, 25);  // Tamaño similar para todos los componentes
        cbBalanza.setPreferredSize(preferredSize1);
        cbCapsula.setPreferredSize(preferredSize1);
        tfUsuario.setPreferredSize(preferredSize1);
        tfIdmuestra.setPreferredSize(preferredSize1);      
        cbTipo.setPreferredSize(preferredSize1);
        tfEnsayo.setPreferredSize(preferredSize1); 
        tfMedioContacto.setPreferredSize(preferredSize1);
        cbIdentificacion.setPreferredSize(preferredSize1);
        spinnerAreaVolumen.setPreferredSize(preferredSize1); // Por ejemplo
        tfTemperatura.setPreferredSize(preferredSize1);
        
        lblBalanza.setPreferredSize(new Dimension(100, 25));

        // Configurar las restricciones
        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.insets = new Insets(5, 5, 5, 5);  // Espaciado entre componentes

        // Configurar la primera columna (columna 0)
        gbc1.gridx = 0;
        gbc1.weightx = 0.3;  // Primera columna será más estrecha
        gbc1.fill = GridBagConstraints.HORIZONTAL;
        gbc1.weighty = 0.0; // No queremos que esta columna ocupe mucho espacio vertical

        GridBagConstraints gbcLbl1;

        // Agregar etiquetas en la primera columna
        gbcLbl1 = new GridBagConstraints();
        gbcLbl1.gridx = 0;
        gbcLbl1.gridy = 0;
        gbcLbl1.fill = GridBagConstraints.HORIZONTAL;
        pan_cont_gr_bag_lay_fil2.add(lblBalanza, gbcLbl1);

        gbcLbl1 = new GridBagConstraints();
        gbcLbl1.gridx = 0;
        gbcLbl1.gridy = 1;
        gbcLbl1.fill = GridBagConstraints.HORIZONTAL;
        pan_cont_gr_bag_lay_fil2.add(lblUsuario, gbcLbl1);
        
        gbcLbl1 = new GridBagConstraints();
        gbcLbl1.gridx = 0;
        gbcLbl1.gridy = 2;
        gbcLbl1.fill = GridBagConstraints.HORIZONTAL;
        pan_cont_gr_bag_lay_fil2.add(lblIdmuestra, gbcLbl1);

        gbcLbl1 = new GridBagConstraints();
        gbcLbl1.gridx = 0;
        gbcLbl1.gridy = 3;
        gbcLbl1.fill = GridBagConstraints.HORIZONTAL;
        pan_cont_gr_bag_lay_fil2.add(lblCapsula, gbcLbl1);
        
        gbcLbl1 = new GridBagConstraints();
        gbcLbl1.gridx = 0;
        gbcLbl1.gridy = 4;
        gbcLbl1.fill = GridBagConstraints.HORIZONTAL;
        pan_cont_gr_bag_lay_fil2.add(lblTipo, gbcLbl1);
    
        gbcLbl1 = new GridBagConstraints();
        gbcLbl1.gridx = 0;
        gbcLbl1.gridy = 5;
        gbcLbl1.fill = GridBagConstraints.HORIZONTAL;
        pan_cont_gr_bag_lay_fil2.add(lblEnsayo, gbcLbl1);
    
        gbcLbl1 = new GridBagConstraints();
        gbcLbl1.gridx = 0;
        gbcLbl1.gridy = 6;
        gbcLbl1.fill = GridBagConstraints.HORIZONTAL;
        pan_cont_gr_bag_lay_fil2.add(lblMedio, gbcLbl1);
        

        gbcLbl1 = new GridBagConstraints();
        gbcLbl1.gridx = 0;
        gbcLbl1.gridy = 7;
        gbcLbl1.fill = GridBagConstraints.HORIZONTAL;
        pan_cont_gr_bag_lay_fil2.add(lblIdentificacion, gbcLbl1);
 
        gbcLbl1 = new GridBagConstraints();
        gbcLbl1.gridx = 0;
        gbcLbl1.gridy = 8;
        gbcLbl1.fill = GridBagConstraints.HORIZONTAL;
        pan_cont_gr_bag_lay_fil2.add(lblArea, gbcLbl1);

        gbcLbl1 = new GridBagConstraints();
        gbcLbl1.gridx = 0;
        gbcLbl1.gridy = 9;
        gbcLbl1.fill = GridBagConstraints.HORIZONTAL;
        pan_cont_gr_bag_lay_fil2.add(lblTemperatura, gbcLbl1);
 
        // Configurar la segunda columna (columna 1)
        gbc1.gridx = 1;
        gbc1.weightx = 0.7;  // Segunda columna será más ancha
        gbc1.fill = GridBagConstraints.HORIZONTAL;

        // Colocar los componentes en la segunda columna
        gbc_cbBalanza = new GridBagConstraints();
        gbc_cbBalanza.gridx = 1;
        gbc_cbBalanza.gridy = 0;
        gbc_cbBalanza.insets = new Insets(4, 5, 4, 5); // Espaciado vertical ligeramente mayor
        gbc_cbBalanza.fill = GridBagConstraints.HORIZONTAL;
        pan_cont_gr_bag_lay_fil2.add(cbBalanza, gbc_cbBalanza);

        gbc_tfCliente = new GridBagConstraints();
        gbc_tfCliente.gridx = 1;
        gbc_tfCliente.gridy = 1;
        gbc_tfCliente.insets = new Insets(4, 5, 4, 5); // Espaciado vertical ligeramente mayor
        gbc_tfCliente.fill = GridBagConstraints.HORIZONTAL;
        pan_cont_gr_bag_lay_fil2.add(tfUsuario, gbc_tfCliente);
        
        gbc_tfUsuario = new GridBagConstraints();
        gbc_tfUsuario.gridx = 1;
        gbc_tfUsuario.gridy = 2;
        gbc_tfUsuario.insets = new Insets(4, 5, 4, 5); // Espaciado vertical ligeramente mayor
        gbc_tfUsuario.fill = GridBagConstraints.HORIZONTAL;
        pan_cont_gr_bag_lay_fil2.add(tfIdmuestra, gbc_tfUsuario);
       
        gbc_cbCapsula = new GridBagConstraints();
        gbc_cbCapsula.gridx = 1;
        gbc_cbCapsula.gridy = 3;
        gbc_cbCapsula.insets = new Insets(4, 5, 4, 5); // Espaciado vertical ligeramente mayor
        gbc_cbCapsula.fill = GridBagConstraints.HORIZONTAL;
        pan_cont_gr_bag_lay_fil2.add(cbCapsula, gbc_cbCapsula);
        
        gbc_cbCapsula = new GridBagConstraints();
        gbc_cbCapsula.gridx = 1;
        gbc_cbCapsula.gridy = 4;
        gbc_cbCapsula.insets = new Insets(4, 5, 4, 5); // Espaciado vertical ligeramente mayor
        gbc_cbCapsula.fill = GridBagConstraints.HORIZONTAL;
        pan_cont_gr_bag_lay_fil2.add(cbTipo, gbc_cbCapsula);
        
        gbc_cbCapsula = new GridBagConstraints();
        gbc_cbCapsula.gridx = 1;
        gbc_cbCapsula.gridy = 5;
        gbc_cbCapsula.insets = new Insets(4, 5, 4, 5); // Espaciado vertical ligeramente mayor
        gbc_cbCapsula.fill = GridBagConstraints.HORIZONTAL;
        pan_cont_gr_bag_lay_fil2.add(tfEnsayo, gbc_cbCapsula);
        
        gbc_cbCapsula = new GridBagConstraints();
        gbc_cbCapsula.gridx = 1;
        gbc_cbCapsula.gridy = 6;
        gbc_cbCapsula.insets = new Insets(4, 5, 4, 5); // Espaciado vertical ligeramente mayor
        gbc_cbCapsula.fill = GridBagConstraints.HORIZONTAL;
        pan_cont_gr_bag_lay_fil2.add(tfMedioContacto, gbc_cbCapsula);

        gbc_cbCapsula = new GridBagConstraints();
        gbc_cbCapsula.gridx = 1;
        gbc_cbCapsula.gridy = 7;
        gbc_cbCapsula.insets = new Insets(4, 5, 4, 5); // Espaciado vertical ligeramente mayor
        gbc_cbCapsula.fill = GridBagConstraints.HORIZONTAL;
        pan_cont_gr_bag_lay_fil2.add(cbIdentificacion, gbc_cbCapsula);
        
        gbc_cbCapsula = new GridBagConstraints();
        gbc_cbCapsula.gridx = 1;
        gbc_cbCapsula.gridy = 8;
        gbc_cbCapsula.insets = new Insets(4, 5, 4, 5); // Espaciado vertical ligeramente mayor
        gbc_cbCapsula.fill = GridBagConstraints.HORIZONTAL;
        pan_cont_gr_bag_lay_fil2.add(spinnerAreaVolumen, gbc_cbCapsula);
        
        gbc_cbCapsula = new GridBagConstraints();
        gbc_cbCapsula.gridx = 1;
        gbc_cbCapsula.gridy = 9;
        gbc_cbCapsula.insets = new Insets(4, 5, 4, 5); // Espaciado vertical ligeramente mayor
        gbc_cbCapsula.fill = GridBagConstraints.HORIZONTAL;
        pan_cont_gr_bag_lay_fil2.add(tfTemperatura, gbc_cbCapsula);
     
        //################################ Tercera fila ################################
        JPanel panelFila3 = new JPanel();
        //panelFila3.setBackground(Color.GREEN); // Color para distinguir visualmente
        GridBagConstraints gbc_panelFila3 = new GridBagConstraints();
        gbc_panelFila3.insets = new Insets(5, 5, 5, 5); // Espaciado opcional
        gbc_panelFila3.fill = GridBagConstraints.BOTH;
        gbc_panelFila3.gridx = 0;
        gbc_panelFila3.gridy = 2;
        panelContenido.add(panelFila3, gbc_panelFila3);
        panelFila3.setLayout(new BorderLayout(0, 0));

        // Configuración para la tercera fila (conteniendo lo que estaba en la fila 1)
        JLabel lblTitulo_pan_fil3 = new JLabel("Peso Balanza");
        lblTitulo_pan_fil3.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo_pan_fil3.setOpaque(true); // Hacer que el fondo sea visible
        lblTitulo_pan_fil3.setBackground(Color.LIGHT_GRAY); // Cambiar el color de fondo
        panelFila3.add(lblTitulo_pan_fil3, BorderLayout.NORTH);

        lblPesoBalanza = new JLabel("0.0");
        lblPesoBalanza.setHorizontalAlignment(SwingConstants.CENTER);
        lblPesoBalanza.setOpaque(true); // Hacer que el fondo sea visible
        lblPesoBalanza.setBackground(Color.WHITE); // Cambiar el color de fondo
        lblPesoBalanza.setFont(new Font("Arial", Font.BOLD, 32));
        panelFila3.add(lblPesoBalanza, BorderLayout.CENTER);

        JPanel pan_cont_footer_fil2 = new JPanel();
        panelFila3.add(pan_cont_footer_fil2, BorderLayout.SOUTH);

        btnObtenerPeso = new JButton(" Obtener ");
        btnObtenerPeso.setEnabled(false);
        pan_cont_footer_fil2.add(btnObtenerPeso);

        btnDescartarPeso = new JButton("Descartar");
        btnDescartarPeso.setEnabled(false);
        pan_cont_footer_fil2.add(btnDescartarPeso);
        
        
        // Colocar todo el contenido que hay en PCP_DatosBalanza dentro de un scroll
        JScrollPane scrollPane = new JScrollPane(panelContenido);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); // La barra de desplazamiento se muestra solo si es necesario
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // Desactivar la barra de desplazamiento horizontal
        add(scrollPane, BorderLayout.CENTER);  // Agregar el JScrollPane al panel principal

    }

	 public JComboBox<Object> getCbFlowC() {
		return cbFlowC;
	}

	public void setCbFlowC(JComboBox<Object> cbFlowC) {
		this.cbFlowC = cbFlowC;
	}

	public JTextField getTfIdmuestra() {
		return tfIdmuestra;
	}

	public JLabel getLblDesconectado() {
		return lblDesconectado;
	}

	public JButton getBtnConectar() {
		return btnConectar;
	}

	public JButton getBtnDesconectar() {
		return btnDesconectar;
	}

	public JComboBox<Object> getCbPuerto() {
		return cbPuerto;
	}

	public JComboBox<Object> getCbBaudRate() {
		return cbBaudRate;
	}

	public JComboBox<Object> getCbDataBits() {
		return cbDataBits;
	}

	public JComboBox<Object> getCbStopBits() {
		return cbStopBits;
	}

	public JComboBox<Object> getCbParity() {
		return cbParity;
	}

	public JComboBox<Object> getCbVelocidadDeLectura() {
		return cbVelocidadDeLectura;
	}

	public JComboBox<Object> getCbBalanza() {
		return cbBalanza;
	}

	public JTextField getTfUsuario() {
		return tfUsuario;
	}

	public JComboBox<Object> getCbCapsula() {
		return cbCapsula;
	}
	
    public JComboBox<Object> getCbTipo() {
		return cbTipo;
	}

	public JTextField getTfEnsayo() {
		return tfEnsayo;
	}

	public JTextField getTfMedioContacto() {
		return tfMedioContacto;
	}

	public JComboBox<Object> getCbIdentificacion() {
		return cbIdentificacion;
	}

	public JSpinner getSpinnerAreaVolumen() {
		return spinnerAreaVolumen;
	}

	public JTextField getTfTemperatura() {
		return tfTemperatura;
	}

	public JLabel getLblPesoBalanza() {
		return lblPesoBalanza;
	}

	public JButton getBtnObtenerPeso() {
		return btnObtenerPeso;
	}

	public JButton getBtnDescartarPeso() {
		return btnDescartarPeso;
	}
}