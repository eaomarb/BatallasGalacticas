public class Exploradora extends Nave {
    public Exploradora(char equipo) {
        super(equipo, false); // No puede atacar
    }

    @Override
    public boolean movimientoValido(int filaOrigen, int columnaOrigen,
                                    int filaDestino, int columnaDestino,
                                    char[][] tablero) {
        // Movimiento en diagonal
        int distanciaFila = Math.abs(filaDestino - filaOrigen);
        int distanciaColumna = Math.abs(columnaDestino - columnaOrigen);

        // Si las distancias no son iguales, no es un movimiento diagonal
        if (distanciaFila != distanciaColumna) {
            return false;
        }

        // Comprobar que la casilla de destino este vacia
        if (tablero[filaDestino - 1][columnaDestino] != '.') {
            return false;
        }

        // Determinar la direccion en la que se mueve la nave
        int dirFila;
        if (filaDestino > filaOrigen) {
            dirFila = 1;
        } else {
            dirFila = -1;
        }

        int dirColumna;
        if (columnaDestino > columnaOrigen) {
            dirColumna = 1;
        } else {
            dirColumna = -1;
        }

        // Comprobar las casillas intermedias
        int filaActual = filaOrigen + dirFila;
        int columnaActual = columnaOrigen + dirColumna;

        // Recorremos las casillas intermedias entre la posición de origen y destino
        while (filaActual != filaDestino) {
            if (tablero[filaActual][columnaActual] != '.') {
                return false;
            }
            filaActual += dirFila;
            columnaActual += dirColumna;
        }

        return true;
    }
}
