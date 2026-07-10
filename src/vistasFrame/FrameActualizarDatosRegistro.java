package vistasFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class FrameActualizarDatosRegistro extends JFrame {

	private static FrameActualizarDatosRegistro instancia = null;
	
	private JPanel contentPane;
	
	private JComboBox<Object> cbCapsula;
	private JComboBox<Object> cbTipo;
	private JTextField txtMuestra;
	private JTextField txtEnsayo;
	private JTextField txtMContacto;
	private JComboBox<Object> cbIdentificacion;
	private JSpinner spinnerAreaVolumen;	 
    private JTextField txtBalanza;
    private JTextField txtUsuario;
    private JTextField txtTemperatura;
   
	private JButton btnActualizar;
    private JButton btnCerrar;
    
    private JLabel lblTitulo;

    private  FrameActualizarDatosRegistro() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 384, 465);
        setTitle("ACTUALIZAR REGISTRO");
        Image icono = Toolkit.getDefaultToolkit().getImage(Frame.class.getResource("/recursos/balanza1.png"));
        setIconImage(icono);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        lblTitulo = new JLabel("Actualizar registro");
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblTitulo.setBackground(new Color(192, 192, 192));
        lblTitulo.setOpaque(true);
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblTitulo, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        contentPane.add(panel, BorderLayout.CENTER);

        JLabel lblBalanza = new JLabel("Balanza");
        lblBalanza.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblBalanza.setBounds(66, 19, 82, 19);
        panel.add(lblBalanza);

        txtBalanza = new JTextField();
        txtBalanza.setFont(new Font("Tahoma", Font.PLAIN, 16));
        txtBalanza.setText("");
        txtBalanza.setBounds(154, 18, 179, 23);
        txtBalanza.setColumns(10);
        panel.add(txtBalanza);
  

        JLabel lblUsuario = new JLabel("Usuario");
        lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblUsuario.setBounds(66, 51, 82, 19);
        panel.add(lblUsuario);

        txtUsuario = new JTextField();
        txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
        txtUsuario.setText("");
        txtUsuario.setColumns(10);
        txtUsuario.setBounds(154, 50, 179, 23);
        panel.add(txtUsuario);

        JLabel lblMuestra = new JLabel("Muestra");
        lblMuestra.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblMuestra.setBounds(66, 83, 82, 19);
        panel.add(lblMuestra);

        txtMuestra = new JTextField();
        txtMuestra.setFont(new Font("Tahoma", Font.PLAIN, 16));
        txtMuestra.setText("");
        txtMuestra.setColumns(10);
        txtMuestra.setBounds(154, 82, 179, 23);
        panel.add(txtMuestra);

        JLabel lblCapsula = new JLabel("Cápsula");
        lblCapsula.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblCapsula.setBounds(66, 115, 82, 19);
        panel.add(lblCapsula);

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
        cbCapsula.setFont(new Font("Tahoma", Font.PLAIN, 16));
      
        cbCapsula.setBackground(Color.WHITE); // Color de fondo
        cbCapsula.setForeground(Color.DARK_GRAY); // Color del texto
        cbCapsula.setEditable(true);
        cbCapsula.setBounds(154, 114, 179, 23);
        panel.add(cbCapsula);
        
        JLabel lblTipo = new JLabel("Tipo");
        lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblTipo.setBounds(93, 148, 49, 19);
        panel.add(lblTipo);

        cbTipo = new JComboBox<Object> (new String[] {"Montaje", "Desmontaje"});
        cbTipo.setFont(new Font("Tahoma", Font.PLAIN, 16));
        cbTipo.setSelectedItem("");
        cbTipo.setBackground(Color.WHITE); // Color de fondo
        cbTipo.setForeground(Color.DARK_GRAY); // Color del texto
        cbTipo.setEditable(true);
        cbTipo.setBounds(154, 146, 179, 23);
        panel.add(cbTipo);
        
        JLabel lblEnsayo = new JLabel("Ensayo");
        lblEnsayo.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblEnsayo.setBounds(72, 180, 82, 19);
        panel.add(lblEnsayo);

        txtEnsayo = new JTextField();
        txtEnsayo.setFont(new Font("Tahoma", Font.PLAIN, 16));
        txtEnsayo.setText("");
        txtEnsayo.setColumns(10);
        txtEnsayo.setBounds(154, 178, 179, 23);
        panel.add(txtEnsayo);

        JLabel lblMContacto = new JLabel("M Contacto");
        lblMContacto.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblMContacto.setBounds(40, 212, 101, 19);
        panel.add(lblMContacto);

        txtMContacto = new JTextField();
        txtMContacto.setFont(new Font("Tahoma", Font.PLAIN, 16));
        txtMContacto.setText("");
        txtMContacto.setColumns(10);
        txtMContacto.setBounds(154, 210, 179, 23);
        panel.add(txtMContacto);

        JLabel lblIdentificacion = new JLabel("Identificación");
        lblIdentificacion.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblIdentificacion.setBounds(27, 244, 114, 19);
        panel.add(lblIdentificacion);

        cbIdentificacion = new JComboBox<Object> (new String[] {
        	    "Blanco Volumen 1", "Blanco Volumen 2", "Control 1", "Control 2", "Otro"
        	});
        cbIdentificacion.setFont(new Font("Tahoma", Font.PLAIN, 16));
        
        
        cbIdentificacion.setBackground(Color.WHITE); // Color de fondo
        cbIdentificacion.setForeground(Color.DARK_GRAY); // Color del texto
        cbIdentificacion.setEditable(true);
        cbIdentificacion.setBounds(154, 243, 179, 23);
        panel.add(cbIdentificacion);

        JLabel lblAreaVolumen = new JLabel("A Vol [dm / 2]");
        lblAreaVolumen.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblAreaVolumen.setBounds(18, 275, 124, 19);
        panel.add(lblAreaVolumen);

        //double numero = Double.parseDouble(valorModificadoAreaVolumen);
        SpinnerNumberModel spAreaVolumen = new SpinnerNumberModel(0.6, 0.0, 2.0, 0.1);
        spinnerAreaVolumen = new JSpinner(spAreaVolumen);
        spinnerAreaVolumen.setFont(new Font("Tahoma", Font.PLAIN, 16));
        spinnerAreaVolumen.setBounds(154, 275, 179, 23);
        panel.add(spinnerAreaVolumen);

        JLabel lblTemperatura = new JLabel("Temperatura");
        lblTemperatura.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblTemperatura.setBounds(34, 307, 104, 19);
        panel.add(lblTemperatura);

        txtTemperatura = new JTextField();
        txtTemperatura.setFont(new Font("Tahoma", Font.PLAIN, 16));
        txtTemperatura.setText("");
        txtTemperatura.setColumns(10);
        txtTemperatura.setBounds(154, 307, 179, 23);
        panel.add(txtTemperatura);

        btnActualizar = new JButton("Actualizar");
        btnActualizar.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnActualizar.setBounds(28, 353, 133, 24);
        panel.add(btnActualizar);

        btnCerrar = new JButton("Cancelar");
        btnCerrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnCerrar.setBounds(197, 353, 133, 24);
        panel.add(btnCerrar);
	}
	
	public void setDatosRegistro(
			String contadorRegistrosTablaDatos, 
			String nombreCapsulsaTablaDatos,
			String tipoTablaDatos,
			String idMuestraTablaDatos,
			String ensayoTablaDatos,
			String medioContactoTablaDatos,
			String identificacionTablaDatos,
			String areaVolumenTablaDatosString,
			String temperaturaTablaDatos,
			String nombreClienteTablaDatos,
			String serialBalanzaTablaDatos
		
			) {
		
			txtBalanza.setText(serialBalanzaTablaDatos);
			txtUsuario.setText(nombreClienteTablaDatos);
			txtMuestra.setText(idMuestraTablaDatos);
			cbCapsula.setSelectedItem(nombreCapsulsaTablaDatos);
			cbTipo.setSelectedItem(tipoTablaDatos);
			txtEnsayo.setText(ensayoTablaDatos);
			txtMContacto.setText(medioContactoTablaDatos);
			cbIdentificacion.setSelectedItem(identificacionTablaDatos);
			spinnerAreaVolumen.setValue(Double.parseDouble(areaVolumenTablaDatosString));
			txtTemperatura.setText(temperaturaTablaDatos);
			
			lblTitulo.setText("Actualizar registro # " + contadorRegistrosTablaDatos);
	}
	
    // Método estático para obtener la única instancia
    public static FrameActualizarDatosRegistro getInstancia() {
        if (instancia == null) {
            instancia = new FrameActualizarDatosRegistro();
        }
        return instancia;
    }

    public JButton getBtnActualizar() {
		return btnActualizar;
	}

	public JButton getBtnCerrar() {
		return btnCerrar;
	}

	public JTextField getTxtBalanza() {
		return txtBalanza;
	}

	public JTextField getTxtUsuario() {
		return txtUsuario;
	}

	public JTextField getTxtMuestra() {
		return txtMuestra;
	}

	public JTextField getTxtEnsayo() {
		return txtEnsayo;
	}

	public JTextField getTxtMContacto() {
		return txtMContacto;
	}

	public JTextField getTxtTemperatura() {
		return txtTemperatura;
	}

	public JSpinner getSpinnerAreaVolumen() {
		return spinnerAreaVolumen;
	}

	public JComboBox<Object> getCbCapsula() {
		return cbCapsula;
	}

	public JComboBox<Object> getCbTipo() {
		return cbTipo;
	}

	public JComboBox<Object> getCbIdentificacion() {
		return cbIdentificacion;
	}

}
