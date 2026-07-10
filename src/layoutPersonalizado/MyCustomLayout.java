package layoutPersonalizado;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;

public class MyCustomLayout implements LayoutManager {
    private int marginTop;          // Margen superior
    private int marginBottom;      // Margen inferior
    private int marginLeft;       // Margen izquierdo
    private int marginRight;      // Margen derecho
    private int horizontalSpacing; // Espacio horizontal entre componentes
    private int verticalSpacing;  // Espacio vertical entre componentes
    
    public MyCustomLayout() {
        marginTop = 5;         
        marginBottom = 5;    
        marginLeft = 10;      
        marginRight = 10;      
        horizontalSpacing = 15; 
        verticalSpacing = 10;
    }
    
    public MyCustomLayout(int marginTop,int marginBottom, int marginLeft, int marginRight, int horizontalSpacing, int verticalSpacing) {
        this.marginTop = marginTop;
        this.marginBottom = marginBottom;
        this.marginLeft = marginLeft;
        this.marginRight = marginRight;
        this.horizontalSpacing = horizontalSpacing;
        this.verticalSpacing = verticalSpacing;
    }
    
    @Override
    public void addLayoutComponent(String name, Component comp) {
        // No es necesario implementar
    }

    @Override
    public void removeLayoutComponent(Component comp) {
        // No es necesario implementar
    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        return calculateSize(parent);
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        return calculateSize(parent);
    }

    @Override
    public void layoutContainer(Container parent) {
        int containerWidth = parent.getWidth();
        int componentCount = parent.getComponentCount();

        int x = marginLeft;
        int y = marginTop;
        int rowHeight = 0;
        int maxWidth = containerWidth - marginLeft - marginRight; // Espacio máximo para los componentes

        for (int i = 0; i < componentCount; i++) {
            Component comp = parent.getComponent(i);
            Dimension compSize = comp.getPreferredSize();

            // Si el siguiente componente no cabe en la fila actual, saltamos a la siguiente fila
            if (x + compSize.width > maxWidth) {
                x = marginLeft; // Reiniciar x al principio de la nueva fila
                y += rowHeight + verticalSpacing; // Mover a la siguiente fila
                rowHeight = 0; // Reiniciar la altura de la fila
            }

            // Colocamos el componente
            comp.setBounds(x, y, compSize.width, compSize.height);

            // Actualizamos x y rowHeight
            x += compSize.width + horizontalSpacing; // Espaciado horizontal entre elementos
            rowHeight = Math.max(rowHeight, compSize.height); // Altura de la fila
        }

        // Agregar margen inferior al final del diseño
        y += rowHeight + marginBottom;
    }

    private Dimension calculateSize(Container parent) {
        int width = parent.getWidth();
        int x = marginLeft;
        int y = marginTop;
        int rowHeight = 0;

        for (Component comp : parent.getComponents()) {
            Dimension preferredSize = comp.getPreferredSize();

            if (x + preferredSize.width > width - marginLeft - marginRight) {
                x = marginLeft;
                y += rowHeight + verticalSpacing;
                rowHeight = 0;
            }

            x += preferredSize.width + horizontalSpacing;
            rowHeight = Math.max(rowHeight, preferredSize.height);
        }

        y += rowHeight + marginBottom; // Añadir altura de la última fila con margen inferior

        return new Dimension(width, y);
    }
}
