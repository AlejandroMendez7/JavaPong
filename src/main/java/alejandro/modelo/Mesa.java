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
        Point2D posicion = this.pelota.getPosicion();
        Velocidad velocidad = pelota.getVelocidad();

        double velocidadHorizontal = velocidad.getVelocidadX();
        double velocidadVertical = velocidad.getVelocidadY();
        double posX = posicion.getX();
        double posY = posicion.getY();

        posX *= velocidadHorizontal;
        posY *= velocidadVertical;

        Point2D nuevaPosicion = new Point2D(posX, posY);
        pelota.setPosicion(nuevaPosicion);
    }

    private void moverPaletas() {
        Point2D posicionPaletaIzquierda = this.paletaIzquierda.getPosicion();
        Point2D posicionPaletaDerecha = this.paletaDerecha.getPosicion();
        double velocidadVerticalPaletaIzquierda = this.paletaIzquierda.getVelocidad();
        double velocidadVerticalPaletaDerecha = this.paletaDerecha.getVelocidad();

        double posXPaletaIzquierda = posicionPaletaIzquierda.getX();
        double posXPaletaDerecha = posicionPaletaDerecha.getX();
        double posYPaletaIzquierda = posicionPaletaIzquierda.getY();
        double posYPaletaDerecha = posicionPaletaDerecha.getY();

        posYPaletaIzquierda *= velocidadVerticalPaletaIzquierda;
        posYPaletaDerecha *= velocidadVerticalPaletaDerecha;

        Point2D nuevaPosicionPaletaIzquierda = new Point2D(posXPaletaIzquierda, posYPaletaIzquierda);
        Point2D nuevaPosicionPaletaDerecha = new Point2D(posXPaletaDerecha, posYPaletaDerecha);

        paletaIzquierda.setPosicion(nuevaPosicionPaletaIzquierda);
        paletaDerecha.setPosicion(nuevaPosicionPaletaDerecha);
    }

    private void actualizarPelota() {
        // datos pelota
        Point2D posicionPelota = this.pelota.getPosicion();
        Velocidad velocidadPelota = pelota.getVelocidad();
        double posXPelota = posicionPelota.getX();
        double posYPelota = posicionPelota.getY();
        double velocidadHorizontalPelota = velocidadPelota.getVelocidadX();
        double velocidadVerticalPelota = velocidadPelota.getVelocidadY();
        double direccionPelota = pelota.getDireccion();

        //datos paletaIzquierda
        Point2D posicionPaletaIzquierda = this.paletaIzquierda.getPosicion();
        double velocidadPaletaIquierda = this.paletaIzquierda.getVelocidad();

        //datos paletaDerecha
        Point2D posicionPaletaDerecha = this.paletaDerecha.getPosicion();
        double velocidadPaletaDerecha = this.paletaDerecha.getVelocidad();

        // veo si es punto y para quien
        if (posXPelota + (pelota.getWidth() / 2) >= width) {
            actualizarMarcador(Direccion.IZQUIERDA);
            sacarDelMedio();
        } else if (posXPelota - (pelota.getWidth() / 2) <= 0) {
            actualizarMarcador(Direccion.DERECHA);
            sacarDelMedio();
        }

        // contra bordes superiores
        if (posYPelota + (pelota.getHeight() / 2) >= height || posYPelota - (pelota.getHeight() / 2) <= 0) {
            velocidadHorizontalPelota *= MULT_VELOCIDAD;
            velocidadVerticalPelota *= MULT_VELOCIDAD;
            Velocidad nuevaVelocidad = new Velocidad(velocidadHorizontalPelota, velocidadVerticalPelota);
            pelota.setVelocidad(nuevaVelocidad);

            direccionPelota = GIRO_COMPLETO - direccionPelota;
            pelota.setDireccion(direccionPelota);
        }

        // contra paletas
        if (false) {
            // ...
        }
    }

    private void actualizarMarcador(Direccion direccion) {
        if (direccion == Direccion.IZQUIERDA) {puntosPaletaIzquierda++;}
        else {puntosPaletaDerecha++;}
    }

    private void sacarDelMedio() {
        posPaletaIzquierda = new Point2D( 30, medioMesa.getY());
        posPaletaDerecha = new Point2D((medioMesa.getX() * 2) - 30 , medioMesa.getY());

        pelota.setPosicion(medioMesa);
        paletaIzquierda.setPosicion(posPaletaIzquierda);
        paletaDerecha.setPosicion(posPaletaDerecha);
    }
}
