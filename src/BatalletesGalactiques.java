public class BatalletesGalactiques {
    public static void main(String[] args) {
        boolean partidaAcabada = false;

        SectorGalactic sectorGalactic = new SectorGalactic();

        Jugador jugadorAlfa = new Jugador('a');
        Jugador jugadorBeta = new Jugador('b');

        while (!partidaAcabada) {
            sectorGalactic.mostrarTablero();
            System.out.println("Turno equipo Alfa:");
            jugadorAlfa.preguntarPosicion();
            System.out.println("Turno equipo Beta:");
            jugadorBeta.preguntarPosicion();

        }
    }
}