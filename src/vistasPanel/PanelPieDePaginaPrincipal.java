package vistasPanel;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class PanelPieDePaginaPrincipal extends JPanel {

	public PanelPieDePaginaPrincipal() {
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("© 2025 Aplicación de Pesaje - Creado por: Rodrigo Cantor Vasquez");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 9));
		add(lblNewLabel, BorderLayout.CENTER);

	}
}
