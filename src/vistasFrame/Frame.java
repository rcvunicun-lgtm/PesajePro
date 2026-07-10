package vistasFrame;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import vistasPanel.PanelPrincipal;

public class Frame extends JFrame {

	private JPanel contentPane;

	public PanelPrincipal panelPrincipal;

	public Frame() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("PesajePro V1.0.0");
        Image icono = Toolkit.getDefaultToolkit().getImage(Frame.class.getResource("/recursos/balanza1.png"));
        setIconImage(icono);
		setSize(500, 300); // Tamaño inicial de la ventana
		setExtendedState(JFrame.MAXIMIZED_BOTH);

		contentPane = new JPanel();
		// contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0)); // quitar el borde entre el jframe y el panel principal
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		panelPrincipal = new PanelPrincipal();

		contentPane.add(panelPrincipal, BorderLayout.CENTER);

	}
}