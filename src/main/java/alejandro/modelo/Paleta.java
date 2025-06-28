package alejandro.modelo;

import javafx.geometry.Dimension2D;
import javafx.geometry.Point2D;

public class Paleta extends Dimension2D {
    private static final double WIDTH = 30;
    private static final double HEIGHT = 70;
    private Point2D posicion;
    private Velocidad velocidad; // ver de usar solo un double -> Vel vertical

    public Paleta(Point2D posicion) {
        super(WIDTH, HEIGHT);
        this.posicion = posicion;
    }

    public Point2D getPosicion() {
        return posicion;
    }

    public Velocidad getVelocidad() {
        return velocidad;
    }

    // mover()
}
