package alejandro.vista;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VistaPrincipal {
    private final Stage stage;

    public VistaPrincipal(Stage stage) {
        this.stage = stage;

        actualizarVista();
    }

    public void actualizarVista() {
        Scene nuevaEscena;

        // ph
        VBox layout = new VBox();
        nuevaEscena = new Scene(layout);

        // stage.setScene(nuevaEscena);
        stage.show();
    }
}
