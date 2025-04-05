public class MadreComandante extends Nave {
    public MadreComandante(char equipo) {
        super(equipo, true);
    }

    @Override
    public boolean movimientoValido(int filaOrigen, int columnaOrigen,
                                    int filaDestino, int columnaDestino,
                                    char[][] tablero) {
        // Se mueve una casilla en cualquier direccion
        return Math.abs(filaDestino - filaOrigen) <= 1 &&
                Math.abs(columnaDestino - columnaOrigen) <= 1;
    }
}
