package vistasFrame;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Toolkit;

public class FrameSobreMi extends JFrame {

    private JFXPanel fxPanel;

    public FrameSobreMi() {
        setTitle("Sobre Mí");
        setSize(850, 440);
        java.awt.Image icono = Toolkit.getDefaultToolkit().getImage(Frame.class.getResource("/recursos/balanza1.png"));
        setIconImage(icono);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // Mantén DISPOSE_ON_CLOSE
        setLayout(new BorderLayout());
        setResizable(false); // 🚫 No redimensionable

        // Inicializa el JFXPanel (no es necesario si lo reinicias al abrir)
        fxPanel = new JFXPanel();
        add(fxPanel, BorderLayout.CENTER);

        Platform.runLater(this::initFX);
    }



    private void initFX() {
        String rutaImagen = "/recursos/presentacion5.png";

        // Parte izquierda con imagen
        ImageView imageView = new ImageView(new Image(rutaImagen));
        imageView.setFitWidth(500);
        imageView.setFitHeight(400);
        imageView.setPreserveRatio(false);
        imageView.setSmooth(true);

        // Efectos estilo Instagram
        ColorAdjust desaturar = new ColorAdjust();
        desaturar.setSaturation(0); // Colores ligeramente apagados (ajustar entre -1 y 1)
        desaturar.setBrightness(0); // Aumentar un poco el brillo (ajustar entre 0 y 1)
        desaturar.setContrast(0); // Sutil aumento en el contraste (ajustar entre 0 y 1)
        
        // Desenfoque suave (ajustar el valor para más o menos desenfoque)
        GaussianBlur blur = new GaussianBlur(0); // Valor más alto = más desenfoque (ajustar entre 0 y 1)
        desaturar.setInput(blur);

        // Aplicamos el efecto de imagen
        imageView.setEffect(desaturar);
        imageView.setOpacity(1); // Opacidad al 85% (ajustable) (ajustar entre 0 y 1)

        StackPane panelIzquierdo = new StackPane(imageView);
        panelIzquierdo.setPrefWidth(400);
        panelIzquierdo.setAlignment(Pos.CENTER);

        // Parte derecha con texto
        Label nombre = new Label("RODRIGO CANTOR VASQUEZ");
        nombre.setFont(Font.font("Arial", FontWeight.BOLD, 20)); // Agregar FontWeight.BOLD
        nombre.setTextFill(Color.web("#2E8B57"));

        Label profesion = new Label("INGENIERO DE SISTEMAS");
        profesion.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        profesion.setTextFill(Color.web("#000000"));

        Label correo = new Label("cantorrodrigov@gmail.com");
        correo.setFont(Font.font("Arial", 14));
        correo.setTextFill(Color.web("#555"));

        Label whatsapp = new Label("WhatsApp: +57 3151961952");
        whatsapp.setFont(Font.font("Arial", 14));
        whatsapp.setTextFill(Color.web("#555"));

        Label descripcion = new Label("\n\n\n\"Crear cosas útiles con código.\"");
        descripcion.setWrapText(true);
        descripcion.setFont(Font.font("Arial", 13));
        descripcion.setTextFill(Color.web("#444"));

        VBox boxTexto = new VBox(10, nombre, profesion, correo, whatsapp, descripcion);
        boxTexto.setAlignment(Pos.CENTER); // Centrar el contenido verticalmente
        boxTexto.setPadding(new Insets(20));
        boxTexto.setStyle("-fx-background-color: linear-gradient(to right, #ffffff, #e6f0ff);");
        boxTexto.setPrefWidth(400);

        // Parte principal (centrar el VBox dentro del HBox)
        HBox root = new HBox(panelIzquierdo, boxTexto);
        root.setPrefSize(800, 400);
        root.setStyle("-fx-background-radius: 10;");
        root.setAlignment(Pos.CENTER); // Centrar el HBox si es necesario

        Scene scene = new Scene(root);
        fxPanel.setScene(scene);
    }
    
    // Método para reiniciar la escena
    public void reiniciarEscena() {
        // Destruir el JFXPanel si ya existe
        if (fxPanel != null) {
            remove(fxPanel);
        }

        // Crear un nuevo JFXPanel y añadirlo al JFrame
        fxPanel = new JFXPanel();
        add(fxPanel, BorderLayout.CENTER);

        // Inicializar la escena de JavaFX
        Platform.runLater(this::initFX);
    }

}
