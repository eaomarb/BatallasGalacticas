import java.util.ArrayList;

public class TableroInicial {
    private boolean existeMadreComandanteAlfa = false;
    private boolean existeMadreComandanteBeta = false;

    public TableroInicial() {
    }

    /**
     * Este metodo comprueba que el tablero inicial sea valido.
     *
     * @param tablero
     * @return true si es valido, de lo contrario, false
     */
    private boolean comprobarTableroInicial(char[][] tablero) {
        char[][] tableroInvertido = new char[8][8];
        boolean tableroCorrecto = true;

        if (tablero.length != 8 || tablero[0].length != 8) {
            tableroCorrecto = false;
        }

        // Revisar que las filas 3-6 esten vacias
        for (int i = 2; i < 5; i++) {
            for (int j = 0; j < tablero.length; j++) {
                if (tablero[i][j] != '.') {
                    tableroCorrecto = false;
                }
            }
        }

        // Invertir tablero
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tableroInvertido[8 - 1 - i][j] = tablero[i][j];
            }
        }

        // Revisar que las naves sean las mismas simetricamente
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (Character.toLowerCase(tablero[i][j]) != Character.toLowerCase(tableroInvertido[i][j])) {
                    tableroCorrecto = false;
                }
            }
        }

        // Revisar que los caracteres de cada nave sean validas y exista la nave
        // MadreComandante(equipo Beta)
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 8; j++) {
                if (tablero[i][j] != 'c' && tablero[i][j] != 'd' && tablero[i][j] != 'e' && tablero[i][j] != 'f'
                        && tablero[i][j] != 'm' && tablero[i][j] != '.') {
                    System.out.println("Hay alguna nave no valida en el equipo Beta");
                    tableroCorrecto = false;
                }

                if (tablero[i][j] == 'm') {
                    existeMadreComandanteBeta = true;
                }

            }
        }

        // Revisar que los caracteres de cada nave sean validas y exista la nave
        // MadreComandante(equipo Alfa)
        for (int i = 6; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (tablero[i][j] != 'C' && tablero[i][j] != 'D' && tablero[i][j] != 'E' && tablero[i][j] != 'F'
                        && tablero[i][j] != 'M' && tablero[i][j] != '.') {
                    System.out.println("Hay alguna nave no valida en el equipo Alfa");
                    tableroCorrecto = false;
                }

                if (tablero[i][j] == 'M') {
                    existeMadreComandanteAlfa = true;
                }

            }
        }

        if (!existeMadreComandanteAlfa) {
            System.out.println("Falta la nave Madre Comandante en el equipo Alfa");
        }

        if (!existeMadreComandanteBeta) {
            System.out.println("Falta la nave Madre Comandante en el equipo Beta");
        }

        if (!tableroCorrecto) {
            System.out.println("El tablero es incorrecto.");
            System.out.println(
                    "Debe ser 8x8 y las naves deben estar colocadas simetricamente frente a las otras, ocupando solamente las 2 primeras filas de cada jugador");

        }

        return tableroCorrecto;
    }

    /**
     * Este metodo recorre las 2 filas del equipo Alfa y comprueba que las naves sean validas.
     * Si son validas se añaden al array
     *
     * @param tablero
     * @return ArrayList con las naves del equipo alfa
     */
    public ArrayList<Nave> instanciarNavesAlfa(char[][] tablero) {
        ArrayList<Nave> naves = new ArrayList<>();

        if (comprobarTableroInicial(tablero)) {
            for (int i = 6; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    switch (tablero[i][j]) {
                        case 'C':
                            naves.add(new Cazabombarderos('a'));
                            break;
                        case 'D':
                            naves.add(new DronesCombate('a'));
                            break;
                        case 'E':
                            naves.add(new Exploradora('a'));
                            break;
                        case 'F':
                            naves.add(new Fragata('a'));
                            break;
                        case 'M':
                            naves.add(new MadreComandante('a'));
                            break;
                    }
                }
            }
        }

        return naves;
    }

    /**
     * Este metodo recorre las 2 filas del equipo Beta y comprueba que las naves sean validas.
     * Si son validas se añaden al array
     *
     * @param tablero
     * @return ArrayList con las naves del equipo Beta
     */
    public ArrayList<Nave> instanciarNavesBeta(char[][] tablero) {
        ArrayList<Nave> naves = new ArrayList<>();

        if (comprobarTableroInicial(tablero)) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 8; j++) {
                    switch (tablero[i][j]) {
                        case 'C':
                            naves.add(new Cazabombarderos('b'));
                            break;
                        case 'D':
                            naves.add(new DronesCombate('b'));
                            break;
                        case 'E':
                            naves.add(new Exploradora('b'));
                            break;
                        case 'F':
                            naves.add(new Fragata('b'));
                            break;
                        case 'M':
                            naves.add(new MadreComandante('b'));
                            break;
                    }
                }

            }
        }

        return naves;
    }
}