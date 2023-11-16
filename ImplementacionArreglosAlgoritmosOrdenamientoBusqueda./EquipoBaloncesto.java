import java.util.Scanner;
import java.util.Arrays;

public class EquipoBaloncesto {

    static class Jugador {
        String nombre;
        int estatura;
        int edad;
        int velocidadMaxima;
        int alcanceSalto;
        int peso;
        int envergadura;

        public Jugador(String nombre, int estatura, int edad, int velocidadMaxima, int alcanceSalto, int peso, int envergadura) {
            this.nombre = nombre;
            this.estatura = estatura;
            this.edad = edad;
            this.velocidadMaxima = velocidadMaxima;
            this.alcanceSalto = alcanceSalto;
            this.peso = peso;
            this.envergadura = envergadura;
        }

        public int calcularCompleto() {
            int completo = (int) (0.25 * estatura + 0.25 * velocidadMaxima + 0.2 * alcanceSalto + 0.1 * peso + 0.2 * envergadura);
            return completo;
        }

        public double calcularIMC() {
            double estaturaMetros = estatura / 100.0;
            double imc = peso / (estaturaMetros * estaturaMetros);
            return imc;
        }

        public boolean puedeClavarBalon() {
            double alturaAro = 305.0;
            double fuerzaNecesaria = alturaAro - estatura + ((envergadura / 2.0) * 0.7) + alcanceSalto;
            return fuerzaNecesaria <= 0;
        }

        @Override
        public String toString() {
            return nombre;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Jugador[] jugadores = new Jugador[5];

        for (int i = 0; i < 5; i++) {
            System.out.println("Ingrese el nombre del jugador " + (i + 1) + ": ");
            String nombre = scanner.nextLine();
            System.out.println("Ingrese la estatura del jugador (cm): ");
            int estatura = Integer.parseInt(scanner.nextLine());
            System.out.println("Ingrese la edad del jugador: ");
            int edad = Integer.parseInt(scanner.nextLine());
            System.out.println("Ingrese la velocidad máxima del jugador (km/h): ");
            int velocidadMaxima = Integer.parseInt(scanner.nextLine());
            System.out.println("Ingrese el alcance en salto del jugador (cm): ");
            int alcanceSalto = Integer.parseInt(scanner.nextLine());
            System.out.println("Ingrese el peso del jugador (Kg): ");
            int peso = Integer.parseInt(scanner.nextLine());
            System.out.println("Ingrese la envergadura del jugador (cm): ");
            int envergadura = Integer.parseInt(scanner.nextLine());
            System.out.println(" ");

            jugadores[i] = new Jugador(nombre, estatura, edad, velocidadMaxima, alcanceSalto, peso, envergadura);
        }

        Arrays.sort(jugadores, (a, b) -> a.velocidadMaxima - b.velocidadMaxima);
        System.out.println("Jugadores ordenados por velocidad:");
        for (Jugador jugador : jugadores) {
            System.out.println(jugador);
        }

        int sumaEstaturas = 0;
        for (Jugador jugador : jugadores) {
            sumaEstaturas += jugador.estatura;
        }
        double promedioEstatura = sumaEstaturas / 5.0;
        System.out.println("Promedio de estatura: " + promedioEstatura);

        Jugador jugadorMasCompleto = jugadores[0];
        for (Jugador jugador : jugadores) {
            if (jugador.calcularCompleto() > jugadorMasCompleto.calcularCompleto()) {
                jugadorMasCompleto = jugador;
            }
        }
        System.out.println("Jugador más completo: " + jugadorMasCompleto);

        System.out.println("Jugadores que pueden clavar el balón:");
        for (Jugador jugador : jugadores) {
            if (jugador.puedeClavarBalon()) {
                System.out.println(jugador);
            }
        }

        Arrays.sort(jugadores, (a, b) -> Double.compare(a.calcularIMC(), b.calcularIMC()));
        System.out.println("Jugadores ordenados por IMC:");
        for (Jugador jugador : jugadores) {
            System.out.println(jugador);
        }
    }
}