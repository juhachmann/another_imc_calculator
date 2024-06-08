package org.example.model.imc;

import org.example.model.imc.exception.ClassificadorNaoEncontradoException;
import org.example.model.pessoa.Pessoa;

public class ClassificadorImcFactory {

    public static aClassificadorImc create(Pessoa pessoa) {
        // Precisaria implementar os outros classificadores de Imc
        // Referências IMC Infantil: http://cintiacercato.com.br/como-calcular-o-imc-infantil/

        if(pessoa.getIdade() >= 6 && pessoa.getIdade() <= 15) {
            return switch (pessoa.getSexoBiologico()) {
                case FEMININO -> new ClassificadorInfantilFeminino(pessoa.getIdade());
                case MASCULINO -> new ClassificadorInfantilMasculino(pessoa.getIdade());
                default -> throw new ClassificadorNaoEncontradoException("Classificador não encontrado para a idade: '%d' e sexo biológico: '%s'".formatted(pessoa.getIdade(), pessoa.getSexoBiologico().getName()));
            };
        }

        if(pessoa.getIdade() >= 18)
            return new ClassificadorAdulto();

        throw new ClassificadorNaoEncontradoException("Classificador não encontrado para a idade: " + pessoa.getIdade());

    }

}
