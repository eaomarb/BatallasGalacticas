import java.util.ArrayList;

public class SectorGalactic {
    private char[][] tablero = {{'c', 'd', 'd', 'e', 'f', 'm', 'f', 'd'}, {'d', 'f', 'e', '.', '.', 'e', 'f', 'd'},
            {'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.'},
            {'D', 'F', 'E', '.', '.', 'E', 'F', 'D'}, {'C', 'D', 'D', 'E', 'F', 'M', 'F', 'D'}};

    public char[][] getTablero() {
        return tablero;
    }

    public void mostrarTablero() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                System.out.print(tablero[i][j]);
            }
            System.out.println();
        }
    }

    TableroInicial tableroInicial = new TableroInicial();

    ArrayList<Nave> navesAlfa = tableroInicial.instanciarNavesAlfa(tablero);
    ArrayList<Nave> navesBeta = tableroInicial.instanciarNavesBeta(tablero);

}
