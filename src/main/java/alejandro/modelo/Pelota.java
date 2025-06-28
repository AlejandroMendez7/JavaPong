package alejandro.modelo;

import javafx.geometry.Dimension2D;
import javafx.geometry.Point2D;

public class Pelota extends Dimension2D {
    private static final double WIDTH = 20;
    private static final double HEIGHT = 20;
    private Point2D posicion;
    private Velocidad velocidad;
    private double direccion;

    public Pelota(Point2D posicion) {
        super(WIDTH, HEIGHT);
        this.posicion = posicion;
    }

    public Point2D getPosicion() {
        return posicion;
    }

    // calcularPos() ?
    public void setPosicion(Point2D posicion) {
        this.posicion = posicion;
    }

    public Velocidad getVelocidad() {
        return velocidad;
    }

    // contacto() ?
    public void setVelocidad(Velocidad velocidad) {
        this.velocidad = velocidad;
    }

    public double getDireccion() {
        return direccion;
    }
}
