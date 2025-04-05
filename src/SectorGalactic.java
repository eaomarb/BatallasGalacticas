import java.util.Scanner;

public class SectorGalactic {
    private final char[][] tablero;

    private int filaOrigen;
    private int filaDestino;
    private int columnaOrigen;
    private int columnaDestino;

    public SectorGalactic(char[][] tablero) {
        this.tablero = tablero;
    }


    private boolean esPosicionValida(int fila, int columna, boolean esOrigen, char equipoActual) {
        if (fila < 1 || fila > 8 || columna == -1) {
            System.out.println("Posición fuera del tablero.");
            return false;
        }

        if (esOrigen) {
            if (tablero[fila - 1][columna] == '.') {
                System.out.println("No hay ninguna nave en esa posicion.");
                return false;
            }

            boolean esNaveDelEquipo;
            if (equipoActual == 'a') {
                esNaveDelEquipo = Character.isUpperCase(tablero[fila - 1][columna]);
            } else {
                esNaveDelEquipo = Character.isLowerCase(tablero[fila - 1][columna]);
            }

            if (!esNaveDelEquipo) {
                System.out.println("Esa nave pertenece al equipo contrario");
                return false;
            }
        }

        // Verifica que la fila y columna de origen como las de destino sean correctas
        // Mirar columnaANumero()
        if (filaOrigen != 0 && columnaOrigen != -1 && filaDestino != 0 && columnaDestino != -1) {
            if (filaOrigen == filaDestino && columnaOrigen == columnaDestino) {
                System.out.println("La posicion de destino no puede ser la misma que la posicion de origen");
                return false;
            }
        }

        return true;
    }

    private Nave obtenerNave(int fila, int columna) {
        char tipoNave = Character.toLowerCase(tablero[fila - 1][columna]);
        char equipo;
        if (Character.isUpperCase(tablero[fila - 1][columna])) {
            equipo = 'a';
        } else {
            equipo = 'b';
        }

        return switch (tipoNave) {
            case 'm' -> new MadreComandante(equipo);
            case 'f' -> new Fragata(equipo);
            case 'c' -> new Cazabombarderos(equipo);
            case 'e' -> new Exploradora(equipo);
            case 'd' -> new DronesCombate(equipo);
            default -> null;
        };
    }

    private boolean esMovimientoValido() {
        Nave nave = obtenerNave(filaOrigen, columnaOrigen);
        if (nave == null) {
            return false;
        }

        boolean movimientoValido = nave.movimientoValido(filaOrigen, columnaOrigen,
                filaDestino, columnaDestino,
                tablero);
        if (!movimientoValido) {
            System.out.println("Movimiento no valido para esta nave.");
            return false;
        }

        char naveDestino = tablero[filaDestino - 1][columnaDestino];
        if (naveDestino != '.') {
            if (!nave.puedeAtacar()) {
                System.out.println("Esta nave no puede atacar");
                return false;
            }

            boolean naveOrigenAlfa = Character.isUpperCase(tablero[filaOrigen - 1][columnaOrigen]);
            boolean naveDestinoAlfa = Character.isUpperCase(naveDestino);
            if (naveOrigenAlfa == naveDestinoAlfa) {
                System.out.println("No puedes atacar a tus propias naves.");
                return false;
            }
        }

        return true;
    }

    private void mover() {
        char naveActual = tablero[filaOrigen - 1][columnaOrigen];
        tablero[filaDestino - 1][columnaDestino] = naveActual;
        tablero[filaOrigen - 1][columnaOrigen] = '.';
    }


    public void preguntarPosicion(char equipoActual) {
        Scanner scanner = new Scanner(System.in);
        boolean posicionOrigenValida;
        boolean posicionDestinoValida;
        boolean seguirJugando = true;
        String posicion;

        System.out.println("Elige que nave quieres mover (por ejemplo: a1):");
        System.out.println("Puedes escribir Q en cualquier momento para volver a seleccionar una nave");

        while (seguirJugando) {
            posicionOrigenValida = false;
            posicionDestinoValida = false;

            while (!posicionOrigenValida) {
                try {
                    System.out.println("Elige que nave quieres mover (por ejemplo: a1):");
                    posicion = scanner.next();

                    if (posicion.length() == 2) {
                        char letraColumna = posicion.charAt(0);
                        char numeroFila = posicion.charAt(1);

                        if (letraColumna >= 'a' && letraColumna <= 'h' && numeroFila >= '1' && numeroFila <= '8') {
                            columnaOrigen = columnaANumero(String.valueOf(letraColumna));
                            filaOrigen = numeroFila - '0';

                            if (esPosicionValida(filaOrigen, columnaOrigen, true, equipoActual)) {
                                posicionOrigenValida = true;
                                System.out.println("Coordenada origen: " + letraColumna + numeroFila);
                            }
                        } else {
                            System.out.println("Posicion invalida.");
                        }
                    } else {
                        System.out.println("La posicion tiene que ser una letra y un numero (por ejemplo: a1)");
                    }
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }

            while (!posicionDestinoValida && posicionOrigenValida) {
                try {
                    System.out.println("A donde quieres mover la nave? (por ejemplo: a1):");
                    posicion = scanner.next().toLowerCase();

                    if (posicion.equalsIgnoreCase("q")) {
                        posicionOrigenValida = false;
                    } else if (posicion.length() == 2) {
                        char letraColumna = posicion.charAt(0);
                        char numeroFila = posicion.charAt(1);

                        if (letraColumna >= 'a' && letraColumna <= 'h' && numeroFila >= '1' && numeroFila <= '8') {
                            columnaDestino = columnaANumero(String.valueOf(letraColumna));
                            filaDestino = numeroFila - '0';

                            if (esPosicionValida(filaDestino, columnaDestino, false, equipoActual) && esMovimientoValido()) {
                                posicionDestinoValida = true;
                                mover();
                                System.out.println("Coordenada destino: " + letraColumna + numeroFila);
                                seguirJugando = false;
                            }
                        } else {
                            System.out.println("Posicion invalida.");
                        }
                    } else {
                        System.out.println("La posicion tiene que ser una letra y un numero (por ejemplo: a1)");
                    }
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }
    }

    public boolean comprobarFinPartida() {
        boolean existeMadreAlfa = false;
        boolean existeMadreBeta = false;

        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] == 'M') {
                    existeMadreAlfa = true;
                } else if (tablero[i][j] == 'm') {
                    existeMadreBeta = true;
                }
            }
        }

        if (!existeMadreAlfa) {
            System.out.println("Equipo Beta ganador!!!");
            return true;
        } else if (!existeMadreBeta) {
            System.out.println("Equipo Beta ganador!!!");
            return true;
        }

        return false;
    }


    public void mostrarTablero() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                if (tablero[i][j] == '.') {
                    System.out.print(" · ");
                } else {
                    System.out.print(" " + tablero[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    private int columnaANumero(String columnaString) {
        columnaString = columnaString.toLowerCase();

        return switch (columnaString) {
            case "a" -> 0;
            case "b" -> 1;
            case "c" -> 2;
            case "d" -> 3;
            case "e" -> 4;
            case "f" -> 5;
            case "g" -> 6;
            case "h" -> 7;
            default -> -1;
        };
    }
}
