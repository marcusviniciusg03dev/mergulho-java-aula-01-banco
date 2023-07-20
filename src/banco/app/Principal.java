package banco.app;

import banco.modelo.ContaEspecial;
import banco.modelo.ContaInvestimento;
import banco.modelo.Pessoa;
import banco.modelo.atm.CaixaEletronico;
import banco.modelo.exceptions.SaldoInsuficienteException;
import banco.modelo.pagamento.Boleto;
import banco.modelo.pagamento.Holerite;

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

        try {
            minhaConta.depositar(30000);
            minhaConta.sacar(31_000);
            minhaConta.creditarRendimentos(.8);
            minhaConta.debitarTarifaMensal();

            suaConta.depositar(20_000);
            suaConta.sacar(100);
            suaConta.debitarTarifaMensal();

            Boleto boletoEscola = new Boleto(titular2, 200);
            Holerite salarioFuncionario = new Holerite(titular1, 100, 160);

            caixaEletronico.pagar(boletoEscola, minhaConta);
            caixaEletronico.pagar(salarioFuncionario, minhaConta);

            caixaEletronico.estornarPagamento(boletoEscola, minhaConta);  

            boletoEscola.imprimirRecibo();
            salarioFuncionario.imprimirRecibo();
        } catch (SaldoInsuficienteException exception) {
            System.out.println("Erro ao executar operação na conta: " + exception.getMessage());
        }

        caixaEletronico.imprimirSaldo(minhaConta);
        System.out.println();
        caixaEletronico.imprimirSaldo(suaConta);
    }
}
