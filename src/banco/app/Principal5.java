package banco.app;

import java.math.BigDecimal;

import banco.modelo.Banco;
import banco.modelo.Conta;

public class Principal5 {
    public static void main(String[] args) {
        Banco banco = new Banco();
        
        /*
        // ifPresent
        banco
            .buscar(123, 222)
            .ifPresent(conta -> System.out.println(conta.getSaldo()));

        // isPresent
        if (contaEncontrada.isPresent()) {
            System.out.println(contaEncontrada.get().getSaldo());
        }

        // orElseThrow
        Conta contaEncontrada = banco
            .buscar(123, 222)
            .orElseThrow(() -> new RuntimeException("Conta não encontrada"));

            System.out.println(contaEncontrada.getSaldo());
        */

        BigDecimal saldo = banco
            .buscar(123, 333)
            .map(Conta::getSaldo)
            .orElse(BigDecimal.ZERO);

        System.out.println(saldo);
    }
}
