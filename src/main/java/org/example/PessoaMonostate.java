package org.example;

import org.example.model.pessoa.Pessoa;

public class PessoaMonostate {

    // Acho que acabei de descobrir que isto aqui na verdade é o Monostate

    private static Pessoa pessoa = new Pessoa();

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa novaPessoa) {
        pessoa = novaPessoa;
    }

}
