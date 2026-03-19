import services.Tragamonedas;
import services.TragamonedasImpl;

public final class TheMain {
    private static final java.util.Scanner IN = new java.util.Scanner(System.in);

    public static void main(String[] args){
        System.out.println("Bienvenido al Tragamonedas v2.0");
        System.out.println("============================================");
        System.out.print("Ingrese su saldo inicial: ");
        int saldoInicial = IN.nextInt();
        System.out.println();

        final Tragamonedas tg = new TragamonedasImpl(saldoInicial);

        while (tg.getSaldo() != 0) {

            System.out.printf("Su saldo actual es de $%s. ¿Cuanto desea apostar? ", tg.getSaldo());

            int apuesta = IN.nextInt();
            System.out.println();

            if (apuesta == 0) {
                System.out.printf("Muchas gracias por jugar. Su saldo final es de $%s.%n", tg.getSaldo());
                break;
            } else {
                int premio = tg.realizarApuesta(apuesta);

                StringBuilder sb = new StringBuilder("+---+---+---+\n");
                for (Character c : tg.getRuedasValues()) {
                    sb.append("| ").append(c).append(" ");
                }
                sb.append("|\n").append("+---+---+---+\n");
                System.out.println(sb);

                if (premio > 0) {
                    System.out.printf("Ud. obtiene $%s ;)%n", premio);
                }

            }

            if (tg.getSaldo() == 0) {
                System.out.println("Muchas Gracias por jugar, su saldo es cero. Mejor suerte la próxima vez.");
            }
        }
    }
}
