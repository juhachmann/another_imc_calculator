package org.example.model.imc;

import org.example.model.imc.exception.ClassificadorNaoEncontradoException;

import java.util.List;

public class ClassificadorInfantilFeminino extends aClassificadorImc {

    // Referências IMC Infantil: http://cintiacercato.com.br/como-calcular-o-imc-infantil/
    // idade: (normal, sobrepeso, obesidade) -> valores mínimos

    // Solução com objetos

    private final List<ValorReferenciaInfantil> VALORES_REFERENCIA = List.of(
            new ValorReferenciaInfantil(6, 14.3, 16.1, 17.4),
            new ValorReferenciaInfantil(7, 14.9, 17.1, 18.9),
            new ValorReferenciaInfantil(8, 15.6, 18.1, 20.3),
            new ValorReferenciaInfantil(9, 16.3, 19.1, 21.7),
            new ValorReferenciaInfantil(10, 17D, 20.1, 23.2),
            new ValorReferenciaInfantil(11, 17.6, 21.1, 24.5),
            new ValorReferenciaInfantil(12, 18.3, 22.1, 25.9),
            new ValorReferenciaInfantil(13, 18.9, 23D, 27.7),
            new ValorReferenciaInfantil(14, 19.3, 23.8, 27.9),
            new ValorReferenciaInfantil(15, 19.6, 24.2, 28.8)
    );


    private int idade;

    public ClassificadorInfantilFeminino(int idade) {
        super("Infantil Feminino");
        this.idade = idade;
    }

    @Override
    public eClassificacaoIMC classificar(double imc) {
        for(ValorReferenciaInfantil referencia : VALORES_REFERENCIA) {
            if(idade == referencia.getIdade()) {
                if (imc < referencia.getLimiteNormal())
                    return eClassificacaoIMC.ABAIXO;
                if (imc < referencia.getLimiteSobrepeso())
                    return eClassificacaoIMC.NORMAL;
                if (imc < referencia.getLimiteObesidade())
                    return eClassificacaoIMC.SOBREPESO;
                return eClassificacaoIMC.OBESIDADE;
            }
        }
        throw new ClassificadorNaoEncontradoException("Idade fora do intervalo classificável");
    }

}
