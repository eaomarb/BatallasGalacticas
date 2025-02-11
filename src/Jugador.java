import java.util.Scanner;

public class Jugador {
    private char equipo;

    private int filaOrigen;
    private int filaDestino;
    private int columnaOrigen;
    private int columnaDestino;

    public char getEquipo() {
        return equipo;
    }

    public int getFilaOrigen() {
        return filaOrigen;
    }

    public int getFilaDestino() {
        return filaDestino;
    }

    public int getColumnaOrigen() {
        return columnaOrigen;
    }

    public int getColumnaDestino() {
        return columnaDestino;
    }

    public Jugador(char equipo) {
        this.equipo = equipo;
    }

    public int columnaANumero(String columnaString) {
        int columna;
        columnaString = columnaString.toLowerCase();

        switch (columnaString) {
            case "a":
                columna = 0;
                break;
            case "b":
                columna = 1;
                break;
            case "c":
                columna = 2;
                break;
            case "d":
                columna = 3;
                break;
            case "e":
                columna = 4;
                break;
            case "f":
                columna = 5;
                break;
            case "g":
                columna = 6;
                break;
            case "h":
                columna = 7;
                break;
            default:
                columna = -1;
                break;
        }

        return columna;
    }

    private boolean esPosicionValida(int fila, int columna) {
        return fila >= 1 && fila <= 8 && columna != -1;
    }

    private boolean esMismaPosicion() {
        if (filaDestino == filaOrigen && columnaDestino == columnaOrigen) {
            System.out.println("La posición no puede ser la misma que la actual!");
            return true;
        }
        return false;
    }

    // TODO: Combinar con los moviminetos de las naves
    private boolean esMovimientoValido() {
        return true;
    }

    public boolean preguntarPosicion() {
        Scanner scanner = new Scanner(System.in);
        String columnaOrigenString, columnaDestinoString;

        System.out.println("Filas: 1-8 | Columnas: A-H");

        do {
            System.out.println("Elige que nave quieres mover (ejemplo: 2 H):");
            filaOrigen = scanner.nextInt();
            columnaOrigenString = scanner.next().toLowerCase();
            columnaOrigen = columnaANumero(columnaOrigenString);
        } while (!esPosicionValida(filaOrigen, columnaOrigen));

        System.out.println("Coordenada origen: " + filaOrigen + " " + columnaOrigen);

        do {
            System.out.println("A que posición quieres mover la nave?");
            filaDestino = scanner.nextInt();
            columnaDestinoString = scanner.next().toLowerCase();
            columnaDestino = columnaANumero(columnaDestinoString);
        } while (!esPosicionValida(filaDestino, columnaDestino) || esMismaPosicion());

        System.out.println("Coordenada destino: " + filaDestino + " " + columnaDestino);
        scanner.close();
        return esMovimientoValido();
    }


}
