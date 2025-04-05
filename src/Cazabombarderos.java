public class Cazabombarderos extends Nave {
    public Cazabombarderos(char equipo) {
        super(equipo, true);
    }

    @Override
    public boolean movimientoValido(int filaOrigen, int columnaOrigen,
                                    int filaDestino, int columnaDestino,
                                    char[][] tablero) {
        // Movimiento en L como el caballo, 2 en una direccoin y 1 en otra
        int distanciaFila = Math.abs(filaDestino - filaOrigen);
        int distanciaColumna = Math.abs(columnaDestino - columnaOrigen);

        return (distanciaFila == 2 && distanciaColumna == 1) ||
                (distanciaFila == 1 && distanciaColumna == 2);
    }
}
