public abstract class Nave {
    private final char equipo;
    private final boolean puedeAtacar;

    public abstract boolean movimientoValido(int filaOrigen, int columnaOrigen,
                                             int filaDestino, int columnaDestino,
                                             char[][] tablero);

    public char getEquipo() {
        return equipo;
    }

    public boolean puedeAtacar() {
        return puedeAtacar;
    }

    public Nave(char equipo, boolean puedeAtacar) {
        this.equipo = equipo;
        this.puedeAtacar = puedeAtacar;
    }
}