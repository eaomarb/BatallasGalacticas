public class BatalletesGalactiques {
    private static final char[][] tablero = {
            {'c', 'd', 'd', 'e', 'f', 'm', 'f', 'd'},
            {'d', 'f', 'e', '.', '.', 'e', 'f', 'd'},
            {'.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.'},
            {'D', 'F', 'E', '.', '.', 'E', 'F', 'D'},
            {'C', 'D', 'D', 'E', 'F', 'M', 'F', 'D'}
    };

    public static void main(String[] args) {
        TableroInicial tableroInicial = new TableroInicial();
        boolean tableroValido = tableroInicial.comprobarTableroInicial(tablero);

        if (tableroValido) {
            boolean partidaAcabada = false;
            SectorGalactic sectorGalactic = new SectorGalactic(tablero);

            while (!partidaAcabada) {
                System.out.println();
                sectorGalactic.mostrarTablero();
                System.out.println();

                System.out.println("Turno equipo Alfa:");
                sectorGalactic.preguntarPosicion('a');
                partidaAcabada = sectorGalactic.comprobarFinPartida();

                if (!partidaAcabada) {
                    System.out.println();
                    sectorGalactic.mostrarTablero();
                    System.out.println();

                    System.out.println("Turno equipo Beta:");
                    sectorGalactic.preguntarPosicion('b');
                    partidaAcabada = sectorGalactic.comprobarFinPartida();
                }
            }
        } else {
            System.out.println("El tablero inicial no es válido. El juego no puede comenzar.");
        }
    }
}
