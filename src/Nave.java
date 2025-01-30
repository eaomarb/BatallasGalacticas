import java.util.Scanner;

public abstract class Nave {
	char letra;

	public Nave(String nave) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Equipo para la nave " + nave + " (Alfa/Beta):");
		String equipo = scanner.nextLine();

		while (!equipo.equalsIgnoreCase("alfa") && !equipo.equalsIgnoreCase("beta")) {
			System.out.println("Equipo para la nave " + nave + " (Alfa/Beta):");
			equipo = scanner.nextLine();
		}

		scanner.close();
		
		if (equipo.equalsIgnoreCase("alfa")) {
			letra = 'D';
		} else {
			letra = 'd';
		}
	}

}