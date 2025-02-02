public class BatalletesGalactiques {
	private char[][] tablero = { { 'c', 'd', 'd', 'e', 'f', 'm', 'f', 'd' }, { 'd', 'f', 'e', '.', '.', 'e', 'f', 'd' },
			{ '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '.', '.', '.' },
			{ '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '.', '.', '.' },
			{ 'D', 'F', 'E', '.', '.', 'E', 'F', 'D' }, { 'C', 'D', 'D', 'E', 'F', 'M', 'F', 'D' } };

	public char[][] getTablero() {
		return tablero;
	}

	public void setTablero(char[][] tablero) {
		this.tablero = tablero;
	}

	public static void main(String[] args) {

		SectorGalactic sectorGalactic = new SectorGalactic();
		TableroInicial tableroInicial = new TableroInicial();

		Jugador jugadorAlfa = new Jugador();
		Jugador jugadorBeta = new Jugador();

	}

}