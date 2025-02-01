public class BatalletesGalactiques {

	public static void main(String[] args) {
		char[][] tablero = { { 'c', 'd', 'd', 'e', 'f', 'm', 'f', 'd' }, { 'd', 'f', 'e', '.', '.', 'e', 'f', 'd' },
				{ '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '.', '.', '.' },
				{ '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '.', '.', '.' },
				{ 'D', 'F', 'E', '.', '.', 'E', 'F', 'D' }, { 'C', 'D', 'D', 'E', 'F', 'M', 'F', 'D' } };

		SectorGalactic sectorGalactic = new SectorGalactic();
		Jugador jugador1 = new Jugador("alfa");
		Jugador jugador2 = new Jugador("beta");

		// sectorGalactic.mostrarTablero(tablero);
		sectorGalactic.instanciarNaves(tablero);

	}

}