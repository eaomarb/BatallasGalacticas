import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class SectorGalactic {
	private int filaOrigen;
	private int filaDestino;

	private int columnaOrigen;
	private int columnaDestino;

	private boolean existeMadreComandanteAlfa = false;
	private boolean existeMadreComandanteBeta = false;

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
		for (int i = 0; i < 1; i++) {
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

		return tableroCorrecto;
	}

	public void instanciarNaves(char[][] tablero) {
		boolean tableroCorrecto = comprobarTableroInicial(tablero);

		if (tableroCorrecto) {
			System.out.println("Tablero correcto");
		} else {
			System.out.println("El tablero es incorrecto.");
			System.out.println(
					"Debe ser 8x8 y las naves deben estar colocadas simetricamente frente a las otras, ocupando solamente las 2 primeras filas de cada jugador");
		}

	}
}
