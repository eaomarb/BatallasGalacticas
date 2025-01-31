import java.util.Scanner;

public class SectorGalactic {
	private char[][] tablero = { { 'c', 'd', 'd', 'e', 'f', 'm', 'f', 'd' }, { 'd', 'f', 'e', '.', '.', 'e', 'f', 'd' },
			{ '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '.', '.', '.' },
			{ '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '.', '.', '.' },
			{ 'D', 'F', 'E', '.', '.', 'E', 'F', 'D' }, { 'C', 'D', 'D', 'E', 'F', 'M', 'F', 'D' } };

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

	public void actualizarTablero() {
	}

	public int columnaANumero(String columnaString) {
		int columna;

		switch (columnaString) {
		case "a":
			columna = 0;
			break;
		case "b":
			columna = 1;
		case "c":
			columna = 2;
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

	public void preguntarPosicion() {
		int filaOrigen;
		String columnaOrigenString;
		int columnaOrigen;
		boolean esColumnaOrigenCorrecto = true;

		int filaDestino;
		String columnaDestinoString;
		int columnaDestino;

		Scanner scanner = new Scanner(System.in);

		System.out.println("Filas: 1-8 | Columnas: A-H");
		System.out
				.println("Escribe que nave quieres mover, con un espacio entre la fila y columna, por ejemplo (2 H):");

		filaOrigen = scanner.nextInt();
		columnaOrigenString = scanner.next();
		columnaOrigenString.toLowerCase();

		columnaDestino = columnaANumero(columnaDestinoString);

		while (filaOrigen < 1 || filaOrigen > 8) {
			System.out.println("Filas: 1-8");
			System.out.println("Columnas: A-H");
			System.out.println("Por favor, revisa que sea una fila valida (1-8):");

			filaOrigen = scanner.nextInt();
			columnaOrigenString = scanner.next();
			columnaOrigenString.toLowerCase();
		}

		while (columnaDestino == -1) {
			System.out.println();
		}

		System.out.println("Fila: " + filaOrigen);
		System.out.println("Columna: " + columnaOrigen);

	}

}