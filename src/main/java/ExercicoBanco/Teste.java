package ExercicoBanco;

public class Teste {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente(); // Instanciando um objeto da classe Cliente
        Cliente cliente2 = new Cliente(); // Instanciando um objeto da classe Cliente

//        Cliente clientes[] = new Cliente[10]; // Criando um array de objetos da classe Cliente

        ContaCorrente conta1 = new ContaCorrente(); // Instanciando um objeto da classe ContaCorrente
        ContaCorrente conta2 = new ContaCorrente(); // Instanciando um objeto da classe ContaCorrente

        conta1.depositar(1000);
        conta1.depositar(500);
        conta2.depositar(2000);

        System.out.println("Saldo da conta 1: " + conta1.getSaldo());

    }
}
