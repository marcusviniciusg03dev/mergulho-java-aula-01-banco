package banco.modelo.pagamento;

import banco.modelo.Pessoa;

public class Boleto implements DocumentoPagavel, DocumentoEstornavel {
    private Pessoa beneficiario;
    private double valor;
    private boolean pago;

    public Boleto(Pessoa beneficiario, double valor) {
        this.beneficiario = beneficiario;
        this.valor = valor;
        this.pago = pago;
    }

    @Override
    public boolean estaPago() {
        return pago;
    }

    @Override
    public double getValorTotal() {
        return valor;
    }

    @Override
    public void quitarPagamento() {
        pago = true;
    }

    @Override
    public void estornarPagamento() {
        pago = false;
    }
}
