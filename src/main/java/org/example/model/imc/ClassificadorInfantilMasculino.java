package org.example.model.imc;


import org.example.model.imc.exception.ClassificadorNaoEncontradoException;

import java.util.List;
import java.util.Map;

public class ClassificadorInfantilMasculino extends aClassificadorImc{

    // Referências IMC Infantil: http://cintiacercato.com.br/como-calcular-o-imc-infantil/
    // idade: (normal, sobrepeso, obesidade) -> valores mínimos

    // Solução com Map
    // Observação: essa estrutura de dados ficou muito confusa!
    // É nessas horas que Python brilha <3
    // TODO: melhorar o mapa de valores referência para crianças

    private final Map<Integer, List<Double>> MASC_AGE_VALUES =
            Map.ofEntries(
                Map.entry(6, List.of(14.5, 16.6, 18D)),
                Map.entry(7, List.of(15D, 17.3, 19.1)),
                Map.entry(8, List.of(15.6, 16.7, 20.3)),
                Map.entry(9, List.of(16.1, 18.8, 21.4)),
                Map.entry(10, List.of(16.7, 19.6, 22.5)),
                Map.entry(11, List.of(17.2, 20.3, 23.7)),
                Map.entry(12, List.of(17.8, 21.1, 24.8)),
                Map.entry(13, List.of(18.5, 21.9, 25.9)),
                Map.entry(14, List.of(19.2, 22.7, 26.9)),
                Map.entry(15, List.of(19.9, 23.6, 27.7))
    );

    private int idade;

    public ClassificadorInfantilMasculino(int idade) {
        super("Infantil Masculino");
        this.idade = idade;
    }

    @Override
    public eClassificacaoIMC classificar(double imc) {
        if(MASC_AGE_VALUES.containsKey(idade)) {
            var referenceValues = MASC_AGE_VALUES.get(idade);
            if (imc < referenceValues.get(0))
                return eClassificacaoIMC.ABAIXO;
            if (imc < referenceValues.get(1))
                return eClassificacaoIMC.NORMAL;
            if (imc < referenceValues.get(2))
                return eClassificacaoIMC.SOBREPESO;
            return eClassificacaoIMC.OBESIDADE;
        }
        throw new ClassificadorNaoEncontradoException("Idade fora do intervalo classificável");
    }

}
