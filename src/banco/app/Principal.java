package banco.app;

import java.math.BigDecimal;

import banco.modelo.ContaEspecial;
import banco.modelo.ContaInvestimento;
import banco.modelo.Pessoa;
import banco.modelo.TipoPessoa;
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
        titular1.setRendimentoAnual(15_000d);
        titular1.setTipo(TipoPessoa.JURIDICA);

        System.out.println(titular1.getDataUltimaAtualizacao());

        Pessoa titular2 = new Pessoa();
        titular2.setNome("Maria Abadia");
        titular2.setDocumento("20000000000");

        ContaInvestimento minhaConta = new ContaInvestimento(titular1, 100, 100);
        ContaEspecial suaConta = new ContaEspecial(titular2, 101, 101, new BigDecimal("1000"));

        try {
            minhaConta.depositar(new BigDecimal("30000"));
            minhaConta.sacar(new BigDecimal("3000"));
            minhaConta.creditarRendimentos(new BigDecimal("0.8"));
            minhaConta.debitarTarifaMensal();

            suaConta.depositar(new BigDecimal("20000"));
            suaConta.sacar(new BigDecimal("100"));
            suaConta.debitarTarifaMensal();

            Boleto boletoEscola = new Boleto(titular2, new BigDecimal("200"));
            Holerite salarioFuncionario = new Holerite(titular2, new BigDecimal("100"), 160);

            caixaEletronico.pagar(boletoEscola, suaConta);
            caixaEletronico.pagar(salarioFuncionario, suaConta);

            caixaEletronico.estornarPagamento(boletoEscola, suaConta);  

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
