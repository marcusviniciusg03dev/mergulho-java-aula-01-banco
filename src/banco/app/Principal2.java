package banco.app;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import banco.modelo.Pessoa;

public class Principal2 {
    public static void main(String[] args) {
        Pessoa pessoa1 = new Pessoa("João da Silva", "12345678912");
        Pessoa pessoa2 = new Pessoa("Maria das Couves", "12345678912");

        // List<Pessoa> pessoas = new ArrayList<Pessoa>();
        Set<Pessoa> pessoas = new HashSet<Pessoa>();

        pessoas.add(pessoa1);
        pessoas.add(pessoa2);

        System.out.println(pessoas);

        // System.out.println(pessoas.get(1));

        for (Pessoa pessoa: pessoas) {
            System.out.println(pessoa.getNome());
        }

        Pessoa pessoa3 = new Pessoa("Maria das Couves", "12345678912");

        System.out.println(pessoas.contains(pessoa3));
        System.out.println(pessoa1.equals(pessoa3));
    }
}
