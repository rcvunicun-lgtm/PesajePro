package renderizarBotonJTable;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import principal.DynamicExcelWriter;
import vistasFrame.FrameActualizarDatosRegistro;

public class BotonActualizarEditor extends DefaultCellEditor {
    private JButton button;
    private JTable table;
    private int row;
    private  FrameActualizarDatosRegistro frame;


    public BotonActualizarEditor(JCheckBox checkBox, ArrayList<Object[]> datosFiltrados) {
        super(checkBox);
    
        button = new JButton();
        button.setOpaque(true);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped(); // Importante para cerrar el editor

                int indexDatosFiltrados = row - 2;

                if (indexDatosFiltrados >= 0 && indexDatosFiltrados < datosFiltrados.size()) {
                    Object[] datosFila = datosFiltrados.get(indexDatosFiltrados);

                    SwingUtilities.invokeLater(() -> {
                        frame = FrameActualizarDatosRegistro.getInstancia();
                        JButton btnActualizar = frame.getBtnActualizar();
                        JButton btnCerrar = frame.getBtnCerrar();
                        
                        // Seteamos los datos en el frame
                        frame.setDatosRegistro(
                            String.valueOf(datosFila[0]),  // contador
                            String.valueOf(datosFila[1]),  // capsula
                            String.valueOf(datosFila[2]),  // tipo
                            String.valueOf(datosFila[3]),  // muestra
                            String.valueOf(datosFila[4]),  // ensayo
                            String.valueOf(datosFila[5]),  // medio
                            String.valueOf(datosFila[6]),  // identificacion
                            String.valueOf(Double.parseDouble(datosFila[7].toString())),  // area (convertido a double)
                            String.valueOf(datosFila[9]),  // temperatura
                            String.valueOf(datosFila[12]), // usuario
                            String.valueOf(datosFila[13])  // serial
                        );

                        frame.setVisible(true);

                     // Limpiar ActionListeners anteriores
                        for (ActionListener al : btnActualizar.getActionListeners()) {
                            btnActualizar.removeActionListener(al);
                        }
                        for (ActionListener al : btnCerrar.getActionListeners()) {
                            btnCerrar.removeActionListener(al);
                        }
                        
                        btnActualizar.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                // Obtenemos los nuevos valores desde el frame
                                String capsula = (String) frame.getCbCapsula().getSelectedItem();
                                String tipo = (String) frame.getCbTipo().getSelectedItem();
                                String muestra = frame.getTxtMuestra().getText();
                                String ensayo = frame.getTxtEnsayo().getText();
                                String medio = frame.getTxtMContacto().getText();
                                String identificacion = (String) frame.getCbIdentificacion().getSelectedItem();
                                double areaVol = (Double) frame.getSpinnerAreaVolumen().getValue();
                                String balanza = frame.getTxtBalanza().getText();
                                String usuario = frame.getTxtUsuario().getText();
                                String temperatura = frame.getTxtTemperatura().getText();

                                // Actualizamos el array de datos
                                Object[] filaActualizada = datosFiltrados.get(indexDatosFiltrados);
                                filaActualizada[1] = capsula;
                                filaActualizada[2] = tipo;
                                filaActualizada[3] = muestra;
                                filaActualizada[4] = ensayo;
                                filaActualizada[5] = medio;
                                filaActualizada[6] = identificacion;
                                filaActualizada[7] = areaVol;
                                filaActualizada[9] = temperatura;
                                filaActualizada[12] = usuario;
                                filaActualizada[13] = balanza;

                                // Actualizamos el JTable visualmente
                             // Actualizamos el JTable visualmente
                                for (int col = 1; col <= 7; col++) {
                                    Object valor = filaActualizada[col];

                                    // Si es el área (columna 7), formateamos con coma
                                    if (col == 7 && valor instanceof Number) {
                                        double numero = ((Number) valor).doubleValue();
                                        String numeroConComa = String.valueOf(numero).replace('.', ',');
                                        table.setValueAt(numeroConComa, row, col);
                                    } else {
                                        table.setValueAt(valor, row, col);
                                    }
                                }

                                table.setValueAt(filaActualizada[9], row, 9);   // temperatura
                                table.setValueAt(filaActualizada[12], row, 12); // usuario
                                table.setValueAt(filaActualizada[13], row, 13); // serial/balanza

                                // Actualizamos el Excel
                                DynamicExcelWriter.recrearArchivoExcelSinFilasVacias(
                                    "archivosComplementarios/datos_incrementales.xlsx",
                                    datosFiltrados
                                );

                                frame.dispose();
                            }
                        });
                        
                        btnCerrar.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                               
                                frame.dispose();
                            }
                        });
                    });
                }
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
}
