public class DronesCombate extends Nave {
    public DronesCombate(char equipo) {
        super(equipo, true);
    }

    @Override
    public boolean movimientoValido(int filaOrigen, int columnaOrigen, int filaDestino, int columnaDestino, char[][] tablero) {
        int direccion;
        if (getEquipo() == 'a') {
            direccion = -1;
        } else {
            direccion = 1;
        }

        boolean movimientoRecto = (filaDestino == filaOrigen + direccion) && (columnaDestino == columnaOrigen);

        // Solo ataca en diagonal y si hay un enemigo
        boolean posicionAtaque = (filaDestino == filaOrigen + direccion) && (Math.abs(columnaDestino - columnaOrigen) == 1);


        if (posicionAtaque) {
            char naveDestino = tablero[filaDestino - 1][columnaDestino];
            if (naveDestino == '.') {
                return false; // No puede moverse en diagonal si no hay ningun enemigo
            }
            // Se comprueba si hay una nave enemiga
            boolean esNaveOrigenAlfa = getEquipo() == 'a';
            boolean esNaveDestinoAlfa = Character.isUpperCase(naveDestino);
            // Devuelve true solo si la nave destino es enemiga
            return esNaveOrigenAlfa != esNaveDestinoAlfa;
        }

        return movimientoRecto && tablero[filaDestino - 1][columnaDestino] == '.';
    }
}