public class Fragata extends Nave {
    public Fragata(char equipo) {
        super(equipo, true);
    }

    @Override
    public boolean movimientoValido(int filaOrigen, int columnaOrigen,
                                    int filaDestino, int columnaDestino,
                                    char[][] tablero) {
        // Se calcula la distancia en filas y columnas
        int distanciaFila = Math.abs(filaDestino - filaOrigen);
        int distanciaColumna = Math.abs(columnaDestino - columnaOrigen);

        // Se mueve en linea recta (horizontal o vertical) hasta 2 casillas
        boolean movimientoValido;
        if (distanciaFila == 0 && distanciaColumna <= 2) {
            movimientoValido = true;
        } else movimientoValido = distanciaColumna == 0 && distanciaFila <= 2;

        // Si es un movimiento valido y es de 2 casillas, se compruba que no haya naves en medio
        if (movimientoValido) {
            if (distanciaFila == 2 || distanciaColumna == 2) {
                int dirFila; // 1 para arriba y -1 para abajo
                int dirColumna; // 1 para la derecha y -1 para la izquierda

                if (filaDestino > filaOrigen) {
                    dirFila = 1;
                } else {
                    dirFila = -1;
                }

                if (columnaDestino > columnaOrigen) {
                    dirColumna = 1;
                } else {
                    dirColumna = -1;
                }

                // Si el movimiento es horizontal, la direccion de la fila es 0
                if (distanciaFila == 0) {
                    dirFila = 0;
                }
                // Si el movimiento es vertical, la direccion de la columna es 0
                if (distanciaColumna == 0) {
                    dirColumna = 0;
                }

                // Se comprueba la casilla intermedia
                int filaIntermedia = filaOrigen - 1 + dirFila;
                int columnaIntermedia = columnaOrigen + dirColumna;

                if (tablero[filaIntermedia][columnaIntermedia] != '.') {
                    return false;
                }
            }
        }

        return movimientoValido;
    }
}
