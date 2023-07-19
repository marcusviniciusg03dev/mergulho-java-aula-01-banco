package banco.app;

import banco.modelo.CaixaEletronico;
import banco.modelo.Conta;
import banco.modelo.ContaEspecial;
import banco.modelo.ContaInvestimento;
import banco.modelo.Pessoa;

public class Principal {
    public static void main(String[] args) {

        CaixaEletronico caixaEletronico = new CaixaEletronico();

        Pessoa titular1 = new Pessoa();
        titular1.setNome("Marcus Vinicius");
        titular1.setDocumento("10000000000");

        Pessoa titular2 = new Pessoa();
        titular2.setNome("Maria Abadia");
        titular2.setDocumento("20000000000");

        ContaInvestimento minhaConta = new ContaInvestimento(titular1, 100, 100);
        ContaEspecial suaConta = new ContaEspecial(titular2, 101, 101, 1000);

        minhaConta.depositar(15000);
        minhaConta.sacar(1000);
        minhaConta.creditarRendimentos(.8);
        minhaConta.debitarTarifaMensal();

        suaConta.depositar(20_000);
        suaConta.sacar(100);
        suaConta.debitarTarifaMensal();

        caixaEletronico.imprimirSaldo(minhaConta);
        System.out.println();
        caixaEletronico.imprimirSaldo(suaConta);
    }
}
