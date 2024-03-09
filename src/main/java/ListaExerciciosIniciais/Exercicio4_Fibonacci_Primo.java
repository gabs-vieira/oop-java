package ListaExerciciosIniciais;

public class Exercicio4_Fibonacci_Primo {

    public static void main(String[] args) {

        int n1 = 1 , n2 = 1, tn;
        System.out.println(n1 + "Não é considerado composto nem primo");
        System.out.println(n2 + "Não é considerado composto nem primo");

        for(int i = 0; i <= 10; i++){
            tn = n1+n2;

            if (verificarPrimo(tn)){
                System.out.println( tn + " É primo" );
            } else {
                System.out.println( tn + " Não é primo" );
            }

            n1 = n2;
            n2 = tn;
        }

    }

    public static boolean verificarPrimo( int numero ) {

        for (int i = 2; i < (numero/2); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true ;
    }
}
