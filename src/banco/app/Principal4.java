package banco.app;

import java.math.BigDecimal;
import java.util.List;

import banco.modelo.Banco;
import banco.modelo.Conta;
import banco.modelo.Pessoa;

public class Principal4 {
    public static void main(String[] args) {
        Banco banco = new Banco();

        List<Pessoa> titulares = banco.getContas()
            .stream()
            .map(Conta::getTitular)
            .distinct()
            .toList();
            //.collect(Collectors.toList());

        System.out.println(titulares);

        BigDecimal saldoTotal = banco.getContas().stream()
            .map(Conta::getSaldo)
            .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println(saldoTotal);

        banco.getContas().stream()
            .filter(conta -> conta.getSaldo().compareTo(new BigDecimal("50")) > 0)
            .filter(conta -> conta.getNumero() > 200)
            .distinct()
            .map(Conta::getTitular)
            // .sorted(Comparator.comparingInt(Conta::getNumero))
            .forEach(System.out::println);
    }
}
