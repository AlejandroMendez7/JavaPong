package alejandro.modelo;

import javafx.geometry.BoundingBox;
import javafx.geometry.Point2D;

public class Mesa {
    private static final int MIN_WIDTH = 400;
    private static final int MIN_HEIGHT = 400;
    private static final double MULT_VELOCIDAD = 1.1;
    private static final int GIRO_COMPLETO = 2;

    // ph
    private double width;
    private double height;

    // coords
    private Point2D medioMesa;
    private Point2D posPaletaIzquierda;
    private Point2D posPaletaDerecha;

    // marcador
    private int puntosPaletaIzquierda;
    private int puntosPaletaDerecha;

    // Mesa
    private BoundingBox tablero;  // cambiar nombre ?
    private Pelota pelota;
    private Paleta paletaIzquierda;
    private Paleta paletaDerecha;

    // mas adelante
    // private boolean unJugador;


    public Mesa(double width, double height) {
        tablero = new BoundingBox(MIN_WIDTH, MIN_HEIGHT, width, height);

        // TODO: EMPROLIJAR
        medioMesa = new Point2D(width/2, height/2);
        posPaletaIzquierda = new Point2D( 30, medioMesa.getY());
        posPaletaDerecha = new Point2D((medioMesa.getX() * 2) - 30 , medioMesa.getY());


        pelota = new Pelota(medioMesa);
        paletaIzquierda = new Paleta(posPaletaIzquierda);
        paletaDerecha = new Paleta(posPaletaDerecha);
        puntosPaletaIzquierda = 0;
        puntosPaletaDerecha = 0;

    }

    public void actualizarEstadoMesa() {
        moverPelota();
        moverPaletas();
        actualizarPelota();
    }

    private void moverPelota() {

    }

    private void moverPaletas() {

    }

    private void actualizarPelota() {
    }

    private void actualizarMarcador(Direccion direccion) {

    }

    private void sacarDelMedio() {

    }
}
