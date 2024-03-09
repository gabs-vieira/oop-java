package ListaExerciciosIniciais;

import java.util.Scanner;

public class Exercicio6_Strings {

    public static void main(String[] args) {

        String frase = "Em um belo dia de primavera, um programador Java decidiu criar um aplicativo de gerenciamento de tarefas usando o framework Spring, implementando um design elegante e eficiente, garantindo que seu código fosse limpo, modular e altamente escalável, enquanto colaborava com sua equipe usando Git e Jira para acompanhar o progresso do projeto, sempre buscando aprender novas técnicas e padrões de programação para aprimorar suas habilidades e criar software de alta qualidade.";

//        contarEspacos(frase);
//        contarCaracter(frase, 'a');
//        comprimentoString(frase);
//        inverterString(frase);
            reorganizarNome();
    }

    public static void contarEspacos( String s){

        int contadorEspacos = 0;
        for (int i = 0; i < s.length(); i++){

            if (s.charAt(i) == ' '){
                contadorEspacos++;
            }
        }

        System.out.println("Número de espaços em branco: " + contadorEspacos);
    }

    public static void contarCaracter( String s, Character c){

        int contador = 0;
        for (int i = 0; i < s.length(); i++){

            if (s.charAt(i) == c){
                contador++;
            }
        }
        System.out.println("Número de caracter" + c +"é:"+ contador);
    }

    public static void comprimentoString( String s){

        //usando método length()
        System.out.println("Tamanho string, contando os espaços, usando método: " + s.length());


        int comprimento = 0;
        char[] caracteres = s.toCharArray();
        for (char c: caracteres){
            if (c=='\0'){
                break;
            }
            comprimento++;
        }
        System.out.println("Tamanho string, contando os espaços de forma manual:" + comprimento);
    }

    public static void inverterString(String s) {
        StringBuilder reversed = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            reversed.append(s.charAt(i));
        }
        System.out.println(reversed.toString());

        /**
         * StringBuilder é uma classe que serve para criar string mutáveis.
         * É mais eficiente a nível de desempenho utilizar este método do que concatenar.
         *
         * Ao contrário das strings normais em Java (que são imutáveis), StringBuilder permite modificar o conteúdo da string sem criar novas instâncias de string, o que pode ser mais eficiente em termos de memória e desempenho. Isso faz com que StringBuilder seja uma escolha melhor para construir strings dinamicamente em situações em que você precisa fazer muitas alterações ou concatenações.
         * */
    }

    public static boolean verificarPalindromo(String palavra ){

        for (int i = 0; i < (palavra.length()/2); i++){

            if(palavra.charAt(i) != palavra.charAt( palavra.length() -1 -i )) {
                 return false;
            }
        }
        return true;
    }


    public static void reorganizarNome(){

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o nome completo: ");
        String nomeCompleto = sc.nextLine(); //nextLine serve para ler uma linha toda até encontrar um caracter de nova linha (Enter)

        String[] partesNome = nomeCompleto.split(" "); //Split é separar em partes... por isso.
        int tamanho = partesNome.length;

        if(tamanho >= 2){
            String sobrenome = partesNome[tamanho-1];
            String primeiroNome = partesNome[0];

            StringBuilder nomeFormatado = new StringBuilder();
            nomeFormatado.append(sobrenome).append(", ").append(primeiroNome.charAt(0)).append(".");

            for(int i = 1; i < tamanho-1; i++){
                nomeFormatado.append(" ").append(partesNome[i]);
            }
            System.out.println("Nome reorganizado: " + nomeFormatado.toString());
        }else {
            System.out.println("Nome inválido. Informe nome e sobrenome.");
        }

        sc.close();
    }
}