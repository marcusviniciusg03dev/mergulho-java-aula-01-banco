package banco.app;

import java.util.Comparator;
import java.util.function.ToIntFunction;

import banco.modelo.Banco;
import banco.modelo.Conta;

public class Principal3 {
    public static void main(String[] args) {
        Banco banco = new Banco();

        ToIntFunction<Conta> function = (Conta conta) -> {
            return conta.getNumero();
        };

        banco.getContas().sort(Comparator.comparingInt(function));

        for (Conta conta: banco.getContas()) {
            System.out.println(conta.getAgencia() + "/" + conta.getNumero());
        }
    }
}
