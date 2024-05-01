package ListaExerciciosIniciais;

public class Exercicio1_NumeroPerfeito {

    public static void main(String[] args) {

        /**
         * Elabore um programa para gerar e escrever os 5 primeiros números perfeitos.
         * Um número perfeito é aquele que é igual à soma dos seus divisores
         * (exceto o próprio número).*/

        int somaDivisores;
        int numero = 1;
        int contador = 0;

        while (contador < 5) {
            somaDivisores = 0;
            for (int i = 1; i < numero; i++) {
                if (numero % i == 0) {
                    somaDivisores += i;
                }
            }
            if (somaDivisores == numero) {
                System.out.println(numero);
                contador++;
            }
            numero++;
        }

    }
}

/**
 * Soma todos os divisores de um número
 * Caso o número for igual a soma dos divisores, significa que é um Número perfeito
 **/
