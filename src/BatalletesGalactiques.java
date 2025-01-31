public class BatalletesGalactiques {

	public static void main(String[] args) {
		char[][] tablero = { { 'c', 'd', 'd', 'e', 'f', 'm', 'f', 'd' }, { 'd', 'f', 'e', '.', '.', 'e', 'f', 'd' },
				{ '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '.', '.', '.' },
				{ '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '.', '.', '.' },
				{ 'D', 'F', 'E', '.', '.', 'E', 'F', 'D' }, { 'C', 'D', 'D', 'E', 'F', 'M', 'F', 'D' } };
		
		SectorGalactic sectorGalactic = new SectorGalactic();
		
		sectorGalactic.mostrarTablero();
		sectorGalactic.preguntarPosicion();

	}

}