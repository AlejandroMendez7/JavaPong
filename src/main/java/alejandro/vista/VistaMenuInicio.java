package alejandro.vista;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;

public class VistaMenuInicio {

    private final Scene escena;

    public VistaMenuInicio() {
        VBox layout = new VBox();
        escena = new Scene(layout, 1000, 300);
    }
}
