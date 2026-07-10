package vistasFrame;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import vistasPanel.PCP_DatosBalanza;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class FrameEstablecerConexion extends JFrame {

	private JPanel contentPane;
	private JLabel lblDesconectado;
	private JComboBox<Object> cbPuerto;
	private JComboBox<Object> cbBaudRate;
	private JComboBox<Object> cbDataBits;
	private JComboBox<Object> cbStopBits;
	private JComboBox<Object> cbParity;
	private JComboBox<Object> cbFlowC;
	private JComboBox<Object> cbVelocidadDeLectura;
	private JButton btnConectar;
	private JButton btnDesconectar;

	private GridBagConstraints gbc_lblDesconectado;

	public FrameEstablecerConexion() {
		setTitle("Configuración COM");
		Image icono = Toolkit.getDefaultToolkit().getImage(Frame.class.getResource("/recursos/balanza1.png"));
	    setIconImage(icono);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 300, 375);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panelFila1 = new JPanel();
		panelFila1.setLayout(new BorderLayout(0, 0));
		panelFila1.setBackground(Color.CYAN); // Color para distinguir visualmente

		GridBagConstraints gbc_pf1 = new GridBagConstraints();
		gbc_pf1.insets = new Insets(5, 5, 5, 5); // Espaciado opcional
		gbc_pf1.fill = GridBagConstraints.BOTH;
		gbc_pf1.gridx = 0;
		gbc_pf1.gridy = 0;

		JLabel lblTitulo_pan_fil1 = new JLabel("Configuración del puerto COM");
		lblTitulo_pan_fil1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTitulo_pan_fil1.setHorizontalAlignment(SwingConstants.CENTER);
		panelFila1.add(lblTitulo_pan_fil1, BorderLayout.NORTH);

		JPanel pan_cont_fl_lay_fil1 = new JPanel();
		panelFila1.add(pan_cont_fl_lay_fil1, BorderLayout.CENTER);

		JPanel pan_cont_gr_bag_lay_fil1 = new JPanel();
		pan_cont_gr_bag_lay_fil1.setLayout(new GridBagLayout());

		pan_cont_fl_lay_fil1.add(pan_cont_gr_bag_lay_fil1);

		// Crear las etiquetas
		JLabel lblEstado = new JLabel("Estado: ");
		lblEstado.setHorizontalAlignment(SwingConstants.CENTER);

		lblDesconectado = new JLabel("Desconectado");
		lblDesconectado.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon iconoOriginal = new ImageIcon(
				PCP_DatosBalanza.class.getResource("/recursos/usb_desconectadax25.png"));
		Image imagen = iconoOriginal.getImage();
		Image imagenEscalada = imagen.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		ImageIcon iconoRedimensionado = new ImageIcon(imagenEscalada);
		lblDesconectado.setIcon(iconoRedimensionado);

		JLabel lblPuerto = new JLabel("Puerto");
		JLabel lblBaudRate = new JLabel("Baud Rate");
		JLabel lblDataBits = new JLabel("Data Bits");
		JLabel lblStopBits = new JLabel("Stop Bits");
		JLabel lblParity = new JLabel("Parity");
		JLabel lblFlowControl = new JLabel("Flow Control");
		JLabel lblVelocidadDeLectura = new JLabel("Waiting Time");

		// Crear JComboBox y JTextField
		cbPuerto = new JComboBox<Object>(new String[] { "" });
		cbBaudRate = new JComboBox<Object>(new String[] { "100", "300", "600", "1200", "2400", "4800", "9600", "14400",
				"19200", "38400", "56000", "57600", "115200", "128000", "256000" });
		cbBaudRate.setSelectedItem("9600");
		cbDataBits = new JComboBox<Object>(new String[] { "5", "6", "7", "8" });
		cbDataBits.setSelectedItem("8");
		cbStopBits = new JComboBox<Object>(new String[] { "1.0", "1.5", "2.0" });
		cbStopBits.setSelectedItem("2.0");
		cbParity = new JComboBox<Object>(
				new String[] { "NO_PARITY", "EVEN_PARITY", "ODD_PARITY", "MARK_PARITY", "SPACE_PARITY" });
		cbParity.setSelectedItem("NO_PARITY");
		
        cbFlowC = new JComboBox<Object>(new String[] {"NONE", "Hardware (RTS/CTS)", "Hardware (CTS only)", "Hardware (DSR/DTR)", "Hardware (DTR only)", "Soft (XON/XOFF entrada)", "Soft (XON/XOFF salida)", "Combinación RTS + CTS"});
        cbFlowC.setSelectedItem("NONE");
        cbFlowC.setForeground(Color.DARK_GRAY); // Color del texto
		
		cbVelocidadDeLectura = new JComboBox<Object>(new String[] { "100", "200", "300", "400", "500", "600", "700",
				"800", "900", "1000", "1100", "1200", "1300", "1400", "1500", "1600", "1700", "1800", "1900", "2000",
				"2100", "2200", "2300", "2400", "2500", "2600", "2700", "2800", "2900", "3000", "3100", "3200", "3300",
				"3400", "3500", "3600", "3700", "3800", "3900", "4000", "4100", "4200", "4300", "4400", "4500", "4600",
				"4700", "4800", "4900", "5000" });
		cbVelocidadDeLectura.setSelectedItem("100");

		// Establecer tamaño preferido de los campos de texto y combo
		Dimension preferredSizeDer = new Dimension(150, 25); // Tamaño similar para todos los componentes que estan a la
																// derecha
		Dimension preferredSizeIzq = new Dimension(100, 25); // Tamaño similar para todos los componentes que estan a la
																// izquierda

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
		gbc.insets = new Insets(5, 5, 5, 5); // Espaciado entre componentes

		// Configurar la primera columna (columna 0)
		gbc.gridx = 0;
		gbc.weightx = 0.3; // Primera columna será más estrecha
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
		gbc.weightx = 0.7; // Segunda columna será más ancha
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

		btnDesconectar = new JButton("Desconectar");
		btnDesconectar.setEnabled(false);
		pan_cont_footer_fil1.add(btnDesconectar);

		getContentPane().add(panelFila1, BorderLayout.CENTER);
	}
	


	public JLabel getLblDesconectado() {
		return lblDesconectado;
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
	
	 public JComboBox<Object> getCbFlowC() {
		return cbFlowC;
	}

	public JComboBox<Object> getCbVelocidadDeLectura() {
		return cbVelocidadDeLectura;
	}

	public JButton getBtnConectar() {
		return btnConectar;
	}

	public JButton getBtnDesconectar() {
		return btnDesconectar;
	}
}