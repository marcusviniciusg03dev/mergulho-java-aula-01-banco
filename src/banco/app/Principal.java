package banco.app;

import banco.modelo.Conta;
import banco.modelo.Pessoa;

public class Principal {
    public static void main(String[] args) {

        Pessoa titular1 = new Pessoa();
        titular1.setNome("Marcus Vinicius");
        titular1.setDocumento("10000000000");

        Pessoa titular2 = new Pessoa();
        titular2.setNome("Maria Abadia");
        titular2.setDocumento("20000000000");

        Conta minhaConta = new Conta(titular1, 100, 100);
        Conta suaConta = new Conta(titular2, 101, 101);
        
        minhaConta.depositar(150);
        suaConta.depositar(3000);

        minhaConta.sacar(100);
        suaConta.sacar(100);

        System.out.println("Titular: " + minhaConta.getTitular().getNome());
        System.out.println("Saldo: " + minhaConta.getSaldo());

        System.out.println("Titular: " + suaConta.getTitular().getNome());
        System.out.println("Saldo: " + suaConta.getSaldo());

    }
}
