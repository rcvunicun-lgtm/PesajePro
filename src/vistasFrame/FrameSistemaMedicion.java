package vistasFrame;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import vistasPanel.PCP_TextoBalanza;
import java.awt.BorderLayout;
import java.awt.Image;
import javax.swing.JLabel;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import java.awt.Color;

public class FrameSistemaMedicion extends JFrame {

	private JPanel contentPane;
																// valIcial, valMinimo, valMax, Paso 
    private SpinnerNumberModel spinnerModel1 = new SpinnerNumberModel(4, 1, 5, 1);
    private SpinnerNumberModel spinnerModel2 = new SpinnerNumberModel(1, 1, 4, 1);
    
    private SpinnerNumberModel spinnerModel3 = new SpinnerNumberModel(2, 1, 5, 1);
    private SpinnerNumberModel spinnerModel4 = new SpinnerNumberModel(4, 1, 5, 1);
    
    private SpinnerNumberModel spinnerModel5 = new SpinnerNumberModel(2, 1, 4, 1);
    private SpinnerNumberModel spinnerModel6 = new SpinnerNumberModel(0, 0, 4, 1);
    
    private JSpinner spEnteraMg;
    private JSpinner spDecimalMg;
	private JRadioButton rbMg;

	private JSpinner spEnteraG;
	private JSpinner spDecimalG;
	private JRadioButton rbG;
		
	private JSpinner spEnteraKg;
	private JSpinner spDecimalKg;
	private JRadioButton rbKg;
    
    private JButton btnGuardarFormato;
    
	private JRadioButton ultimoRadioSeleccionado;
    
    private int valorEntero; 
    private int valorDecimal ; 
    private String unidad;
    
	public FrameSistemaMedicion() {
		setTitle("Formato de medición");
		Image icono = Toolkit.getDefaultToolkit().getImage(Frame.class.getResource("/recursos/balanza2.png"));
	    setIconImage(icono);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 498, 283);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel PSMPrincipal = new JPanel();
		contentPane.add(PSMPrincipal, BorderLayout.CENTER);
		PSMPrincipal.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTiluto = new JLabel("FORMATO DE MEDICIÓN");
		lblTiluto.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTiluto.setBackground(new Color(192, 192, 192)); // Puedes usar cualquier color
		lblTiluto.setOpaque(true); // Hacer que el JLabel sea opaco para que el color de fondo sea visible
		lblTiluto.setHorizontalAlignment(SwingConstants.CENTER);
		PSMPrincipal.add(lblTiluto, BorderLayout.NORTH);
		
		JPanel PSMContenido = new JPanel();
		PSMPrincipal.add(PSMContenido, BorderLayout.CENTER);
		PSMContenido.setLayout(null);
		
		JLabel lblUnidades = new JLabel("Unidades de masa");
		lblUnidades.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUnidades.setBounds(24, 21, 121, 17);
		PSMContenido.add(lblUnidades);
		
		JLabel lblNewLabel = new JLabel("Cantidad entera");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(163, 21, 106, 17);
		PSMContenido.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cantidad decimal");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(286, 23, 115, 13);
		PSMContenido.add(lblNewLabel_1);
		
		////////////////////////////////////////////////////////////////
		
		JLabel lblNewLabel_2 = new JLabel("Miligramos");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(67, 65, 67, 19);
		PSMContenido.add(lblNewLabel_2);
		
		spEnteraMg = new JSpinner(spinnerModel1);
		spEnteraMg.setBounds(163, 67, 98, 20);
		spEnteraMg.setEnabled(false);
		PSMContenido.add(spEnteraMg);
		
		spDecimalMg = new JSpinner(spinnerModel2);
		spDecimalMg.setBounds(286, 67, 98, 20);
		spDecimalMg.setEnabled(false);
		PSMContenido.add(spDecimalMg);
		
		rbMg = new JRadioButton("mg");
		rbMg.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rbMg.setBounds(418, 66, 61, 21);
		PSMContenido.add(rbMg);
		
		////////////////////////////////////////////////////////////////
		
		JLabel lblNewLabel_3 = new JLabel("Gramos");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(84, 105, 79, 17);
		PSMContenido.add(lblNewLabel_3);
		
		spEnteraG = new JSpinner(spinnerModel3);
		spEnteraG.setBounds(163, 106, 98, 20);
		PSMContenido.add(spEnteraG);
		
		spDecimalG = new JSpinner(spinnerModel4);
		spDecimalG.setBounds(286, 106, 98, 20);
		PSMContenido.add(spDecimalG);
		
		rbG = new JRadioButton("g");
		rbG.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rbG.setBounds(418, 103, 61, 21);
		PSMContenido.add(rbG);
		
		////////////////////////////////////////////////////////////////
		
		JLabel lblNewLabel_4 = new JLabel("Kilogramos");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(66, 138, 79, 21);
		PSMContenido.add(lblNewLabel_4);
		
		spEnteraKg = new JSpinner(spinnerModel5);
		spEnteraKg.setBounds(163, 141, 98, 20);
		spEnteraKg.setEnabled(false);
		PSMContenido.add(spEnteraKg);
		
		spDecimalKg = new JSpinner(spinnerModel6);
		spDecimalKg.setBounds(286, 141, 98, 20);
		spDecimalKg.setEnabled(false);
		PSMContenido.add(spDecimalKg);
		
		rbKg = new JRadioButton("kg");
		rbKg.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rbKg.setBounds(418, 138, 61, 21);
		PSMContenido.add(rbKg);
		
		////////////////////////////////////////////////////////////////

	    // Establecer la selección predeterminada
		rbG.setSelected(true); // Opción 2 seleccionada por defecto
		
		// Establecer por defecto el radioButton seleccionado
		ultimoRadioSeleccionado = rbG;
		
		// Establecer valores por defecto de variables
		valorEntero = (int) spEnteraG.getValue();
		valorDecimal = (int) spDecimalG.getValue();
	    unidad = ultimoRadioSeleccionado.getText();

		 // Agrupar los botones
        ButtonGroup group = new ButtonGroup();
        group.add(rbMg);
        group.add(rbG);
        group.add(rbKg);
        
        btnGuardarFormato = new JButton("Guardar");
        btnGuardarFormato.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnGuardarFormato.setBounds(286, 179, 178, 25);
      
        // Cargar la imagen excel
        ImageIcon originalIconText = new ImageIcon(PCP_TextoBalanza.class.getResource("/recursos/guardar.png"));

        // Redimensionar la imagen
        Image imgText = originalIconText.getImage();
        Image resizedImgText = imgText.getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH); // Ajusta el tamaño (16x16 en este caso)

        // Crear un nuevo ImageIcon con la imagen redimensionada
        ImageIcon resizedIconText = new ImageIcon(resizedImgText);
        
        // Establecer el ícono al botón
        btnGuardarFormato.setIcon(resizedIconText);
        
        // Configurar la posición del ícono para que esté a la izquierda del texto
        btnGuardarFormato.setHorizontalTextPosition(SwingConstants.RIGHT); // Texto a la derecha
        btnGuardarFormato.setVerticalTextPosition(SwingConstants.CENTER);  // Centrado verticalmente
        
        PSMContenido.add(btnGuardarFormato);
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JSpinner getSpEnteraMg() {
		return spEnteraMg;
	}

	public JSpinner getSpDecimalMg() {
		return spDecimalMg;
	}

	public JRadioButton getRbMg() {
		return rbMg;
	}

	public JSpinner getSpEnteraG() {
		return spEnteraG;
	}

	public JSpinner getSpDecimalG() {
		return spDecimalG;
	}

	public JRadioButton getRbG() {
		return rbG;
	}

	public JSpinner getSpEnteraKg() {
		return spEnteraKg;
	}

	public JSpinner getSpDecimalKg() {
		return spDecimalKg;
	}

	public JRadioButton getRbKg() {
		return rbKg;
	}

	public JRadioButton getUltimoRadioSeleccionado() {
		return ultimoRadioSeleccionado;
	}

	public int getValorEntero() {
		return valorEntero;
	}

	public int getValorDecimal() {
		return valorDecimal;
	}

	public String getUnidad() {
		return unidad;
	}
	
	public JButton getBtnGuardarFormato() {
			return btnGuardarFormato;
	}
}