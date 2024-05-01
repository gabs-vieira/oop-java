package ListaExerciciosIniciais;

public class Exercicio2_Primo {

    public static void main(String[] args) {

        int numero = 9;
        boolean primo = true; // Assume que o número é primo

        for (int i = 2; i < (numero/2); i++) {
            if (numero % i == 0) {
                primo = false;
                break;
            }
        }

        if (primo) {
            System.out.println("O número " + numero + " é primo.");
        } else {
            System.out.println("O número " + numero + " não é primo.");
        }

    }
}