package renderizarBotonJTable;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import principal.DynamicExcelWriter;

public class BotonEliminarEditor extends DefaultCellEditor {
	  private JButton button;
	    private JTable table;
	    private int row;
	    private ArrayList<Object[]> datosFiltrados; // <- 🔹 Aquí guardás la referencia al ArrayList

	    public BotonEliminarEditor(JCheckBox checkBox, ArrayList<Object[]> datosFiltrados) {
	        super(checkBox);
	        this.datosFiltrados = datosFiltrados; // <- 🔹 Lo recibís por el constructor

	        button = new JButton();
	        button.setOpaque(true);

	        button.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                fireEditingStopped(); // Importante para cerrar el editor

	                int rowParaEliminarExcel = row - 1;

	                SwingUtilities.invokeLater(() -> {
	                    if (table != null) {
	                        DefaultTableModel model = (DefaultTableModel) table.getModel();

	                        if (row >= 2 && row < model.getRowCount()) {
	                            int confirm = JOptionPane.showConfirmDialog(
	                                    null,
	                                    "¿Estás seguro que deseas eliminar el registro # " + rowParaEliminarExcel + "?",
	                                    "Confirmación",
	                                    JOptionPane.YES_NO_OPTION
	                            );

	                            if (confirm == JOptionPane.YES_OPTION) {
	                                int indexDatosFiltrados = row - 2;

	                                if (indexDatosFiltrados >= 0 && indexDatosFiltrados < datosFiltrados.size()) {
	                                    datosFiltrados.remove(indexDatosFiltrados);
	                                }

	                                model.removeRow(row);
	                                
	                                actualizarConsecutivos();

	                                // 🔄 Actualiza la columna 0 del JTable
	                                for (int i = 2; i < table.getRowCount(); i++) {
	                                    table.setValueAt(i-1, i, 0);
	                                }

	                                // 💥 Reescribe el Excel completo sin la fila eliminada
	                                DynamicExcelWriter.recrearArchivoExcelSinFilasVacias(
	                                    "archivosComplementarios/datos_incrementales.xlsx",
	                                    datosFiltrados
	                                );
	                            }


	                        }
	                    }
	                });
	            }
	        });
	    }

	    @Override
	    public Component getTableCellEditorComponent(JTable table, Object value,
	                                                 boolean isSelected, int row, int column) {
	        this.table = table;
	        this.row = row;

	        if (value instanceof JButton) {
	            JButton original = (JButton) value;
	            button.setIcon(original.getIcon());
	        } else {
	            button.setText((value == null) ? "" : value.toString());
	        }

	        return button;
	    }

	    @Override
	    public Object getCellEditorValue() {
	        return button;
	    }
	    
	    private void actualizarConsecutivos() {
	        for (int i = 0; i < datosFiltrados.size(); i++) {
	            datosFiltrados.get(i)[0] = i + 1;
	        }
	    }
}
