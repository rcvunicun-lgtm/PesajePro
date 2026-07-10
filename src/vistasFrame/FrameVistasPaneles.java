package vistasFrame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Font;

public class FrameVistasPaneles extends JFrame {

    private JPanel contentPane;

    // Declaración de los JCheckBox como variables privadas
    private JCheckBox chckbxPanelDatos;
    private JCheckBox chckbxPanelSenalObtenida;
    private JCheckBox chckbxPanelDatosFiltrados;
    private JCheckBox chckbxPanelArchivosExportados;

     public FrameVistasPaneles() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 293, 190);
        setTitle("Paneles visibles");
        Image icono = Toolkit.getDefaultToolkit().getImage(Frame.class.getResource("/recursos/balanza1.png"));
        setIconImage(icono);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        
        JLabel lblNewLabel = new JLabel("Paneles visibles");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel.setBackground(new Color(192, 192, 192));
        lblNewLabel.setOpaque(true);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblNewLabel, BorderLayout.NORTH);
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        contentPane.add(panel, BorderLayout.CENTER);
        
        JLabel lblPanelDatos = new JLabel("Panel Datos");
        lblPanelDatos.setBounds(92, 24, 74, 13);
        panel.add(lblPanelDatos);
        
        chckbxPanelDatos = new JCheckBox("Visible");
        chckbxPanelDatos.setSelected(true);
        chckbxPanelDatos.setBounds(180, 24, 66, 21);
        panel.add(chckbxPanelDatos);
        
        JLabel lblPanelSenalObtenida = new JLabel("Panel Señal Obtenida");
        lblPanelSenalObtenida.setBounds(38, 48, 150, 13);
        panel.add(lblPanelSenalObtenida);
        
        chckbxPanelSenalObtenida = new JCheckBox("Visible");
        chckbxPanelSenalObtenida.setSelected(true);
        chckbxPanelSenalObtenida.setBounds(180, 48, 93, 21);
        panel.add(chckbxPanelSenalObtenida);
        
        JLabel lblPanelDatosFiltrados = new JLabel("Panel Datos Filtrados");
        lblPanelDatosFiltrados.setBounds(38, 72, 150, 13);
        panel.add(lblPanelDatosFiltrados);
        
        chckbxPanelDatosFiltrados = new JCheckBox("Visible");
        chckbxPanelDatosFiltrados.setSelected(true);
        chckbxPanelDatosFiltrados.setBounds(180, 72, 93, 21);
        panel.add(chckbxPanelDatosFiltrados);
        
        JLabel lblPanelArchivosExportados = new JLabel("Panel Archivos Exportados");
        lblPanelArchivosExportados.setBounds(8, 96, 155, 13);
        panel.add(lblPanelArchivosExportados);
        
        chckbxPanelArchivosExportados = new JCheckBox("Visible");
        chckbxPanelArchivosExportados.setSelected(false);
        chckbxPanelArchivosExportados.setBounds(180, 96, 93, 21);
        panel.add(chckbxPanelArchivosExportados);
    }

    // Métodos getter para acceder a los JCheckBox
    public JCheckBox getChckbxPanelDatos() {
        return chckbxPanelDatos;
    }

    public JCheckBox getChckbxPanelSenalObtenida() {
        return chckbxPanelSenalObtenida;
    }

    public JCheckBox getChckbxPanelDatosFiltrados() {
        return chckbxPanelDatosFiltrados;
    }

    public JCheckBox getChckbxPanelArchivosExportados() {
        return chckbxPanelArchivosExportados;
    }
}
