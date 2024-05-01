package ListaExerciciosIniciais;

public class Exercicio3_Fibonacci {

    public static void main(String[] args) {

        int n1 = 1 , n2 = 1, tn;
        System.out.println(n1);
        System.out.println(n2);

        for(int i = 0; i <= 10; i++){
            tn = n1+n2;
            System.out.println(tn);
            n1 = n2;
            n2 = tn;
        }
    }
}

/**
 * Tentei fazer utilizando apenas duas variáveis, mas não é possível.
 * A variável n1 é substituída pela n2 e a n2 é substituída pela tn
 * */