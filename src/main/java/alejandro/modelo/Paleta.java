package alejandro.modelo;

import javafx.geometry.Dimension2D;
import javafx.geometry.Point2D;

public class Paleta extends Dimension2D {
    private static final double WIDTH = 30;
    private static final double HEIGHT = 70;
    private Point2D posicion;
    private double velocidadVertical; // ver de usar solo un double -> Vel vertical

    public Paleta(Point2D posicion) {
        super(WIDTH, HEIGHT);
        this.posicion = posicion;
    }

    public Point2D getPosicion() {
        return posicion;
    }

    public double getVelocidad() {
        return velocidadVertical;
    }

    public void setVelocidad(double velocidadVertical) {
        this.velocidadVertical = velocidadVertical;
    }

    public void setPosicion(Point2D posicion) {
        this.posicion = posicion;
    }
}
