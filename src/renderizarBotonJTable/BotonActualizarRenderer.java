package renderizarBotonJTable;

import java.awt.Component;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import vistasPanel.PanelPrincipal;

public class BotonActualizarRenderer extends JButton implements TableCellRenderer {
	private ImageIcon iconoBasurero;

    public BotonActualizarRenderer() {
        setOpaque(true);

        // Cargar ícono solo una vez
        ImageIcon originalBasurero = new ImageIcon(PanelPrincipal.class.getResource("/recursos/lapiz3.png"));
        Image imgBasurero = originalBasurero.getImage();
        Image resizedImgBasurero = imgBasurero.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        iconoBasurero = new ImageIcon(resizedImgBasurero);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {

        if (row < 2) {
            return new JLabel(); // Ocultar botón en encabezados visuales
        }

        setIcon(iconoBasurero);
        setText(""); // Por si acaso el botón tiene texto
        return this;
    }
}
