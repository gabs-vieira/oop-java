package ListaExerciciosIniciais;

public class Exercicio5_OrdenacaoNumerosAleatorios {

    public static void main(String[] args) {

        int vetor[] = new int[500];
        //Pegar numeros aleatórios e salvar no vetor
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = (int) (Math.random()*1000);
        }

        long tempoInicialBubble = System.currentTimeMillis();
        bubbleSort(vetor);
        long tempoFinalBubble = System.currentTimeMillis();
        System.out.println("Tempo total para o BubbleSort: " + (tempoFinalBubble-tempoInicialBubble) + "ms");

//        long tempoInicialInsert = System.currentTimeMillis();
//        insertSort(vetor);
//        long tempoFinalInsert = System.currentTimeMillis();
//        System.out.println("Tempo total para o InsertSort: " + (tempoFinalInsert-tempoInicialInsert) + "ms");

        for (int i = 0; i < vetor.length; i++) {
            System.out.println(vetor[i]);
        }
    }


    public static void bubbleSort(int[] vetor){
        //BubbleSort
        for (int i = 0; i < vetor.length; i++) {
            for (int j = i; j < vetor.length; j++) {

                if (vetor[i] > vetor[j]) {
                    int aux = vetor[j];
                    vetor[j] = vetor[i];
                    vetor[i] = aux;
                }
            }
        }
    }

    public static void insertSort(int[] vetor){
        int i, key, j;

        for ( j = 1; j < vetor.length; j++) {

            key = vetor[j]; //Segundo valor do vetor
            for( i = j-1; (i >= 0) && (vetor[i] > key); i-- ){
                vetor[i+1] = vetor[i];
            }
            vetor[i+1] = key;
        }
    }
}


/**
 * O insertionSort e Bubblesort é classificado em casos em referencia ao seu tempo de operação
 * Insert = quanto mais elementos para ordenar, em melhor caso variam de 0 a 8ms, e em casos médios, de 0 a 20.272ms
 * bubble = melhor caso variam de 0 a 4ms, e em casos médios, de 0 a 81.659ms
 * */
