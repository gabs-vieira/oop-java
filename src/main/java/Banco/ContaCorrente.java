package Banco;

public class ContaCorrente {

        private int numero;
        private double saldo;

        public void depositar(double valor){
            saldo += valor;
        }

    public String getSaldo() {
        return "Saldo: " + saldo;
    }

}
