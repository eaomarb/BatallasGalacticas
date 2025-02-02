import java.util.ArrayList;

public class SectorGalactic {
	TableroInicial tableroInicial = new TableroInicial();
	BatalletesGalactiques batalletesGalactiques = new BatalletesGalactiques();

	char[][] tablero = batalletesGalactiques.getTablero();

	ArrayList<Nave> navesAlfa = tableroInicial.instanciarNavesAlfa(tablero);

}
