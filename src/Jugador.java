import java.util.Scanner;

public class Jugador {
	private int filaOrigen;
	private int filaDestino;

	private int columnaOrigen;
	private int columnaDestino;

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

	public void mostrarTablero(char[][] tablero) {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				System.out.print(tablero[i][j]);
			}
			System.out.println();
		}
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
	
	public void preguntarPosicion() {
		Scanner scanner = new Scanner(System.in);

		String columnaOrigenString;
		String columnaDestinoString;

		System.out.println("Filas: 1-8 | Columnas: A-H");

		do {
			System.out.println(
					"Elige que nave quieres mover, con un espacio entre la fila y columna, por ejemplo (2 H):");
			filaOrigen = scanner.nextInt();
			columnaOrigenString = scanner.next();

			columnaOrigenString = columnaOrigenString.toLowerCase();

			columnaOrigen = columnaANumero(columnaOrigenString);
		} while (filaOrigen < 1 || filaOrigen > 8 || columnaOrigen == -1);

		System.out.println("Coordenada origen: " + filaOrigen + columnaOrigen);

		do {
			System.out.println("A que posicion quieres mover la nave?");
			filaDestino = scanner.nextInt();

			columnaDestinoString = scanner.next();
			columnaDestinoString = columnaDestinoString.toLowerCase();

			columnaDestino = columnaANumero(columnaDestinoString);

			if (filaDestino == filaOrigen && columnaDestino == columnaOrigen) {
				System.out.println("La posicion no puede ser la misma que la actual!");
			}
		} while (filaDestino < 1 || filaDestino > 8 || columnaDestino == -1
				|| (filaDestino == filaOrigen && columnaDestino == columnaOrigen));

		System.out.println("Coordenada destino: " + filaDestino + columnaDestino);

		scanner.close();
	}
}
