package vistasPanel;

import javax.swing.JPanel;
import java.awt.BorderLayout;

public class PanelEncabezado extends JPanel {
	
	private PanelEncabezadoSuperior panelEncabezadoSuperior;
	private PanelEncabezadoInferior panelEncabezadoInferior;
	
	public PanelEncabezado() {
			
		setLayout(new BorderLayout(0,0));
			
		panelEncabezadoSuperior = new PanelEncabezadoSuperior();
		panelEncabezadoInferior = new PanelEncabezadoInferior();
		
		add(panelEncabezadoSuperior,BorderLayout.NORTH);
		add(panelEncabezadoInferior,BorderLayout.SOUTH);
		
	}
	
	public PanelEncabezadoSuperior getPanelEncabezadoSuperior() {
		return this.panelEncabezadoSuperior;
	}

	public PanelEncabezadoInferior getPanelEncabezadoInferior() {
		return this.panelEncabezadoInferior;
	}
	
}