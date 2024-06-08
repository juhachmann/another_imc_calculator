package org.example.model.imc;

public class ClassificadorAdulto extends aClassificadorImc {

    public ClassificadorAdulto() {
        super("Adulto");
    }

    @Override
    public eClassificacaoIMC classificar(double imc) {
        if(imc < 18.5) return eClassificacaoIMC.ABAIXO;
        if(imc < 25.0) return eClassificacaoIMC.NORMAL;
        if(imc < 30.0) return eClassificacaoIMC.SOBREPESO;
        if(imc < 40.0) return eClassificacaoIMC.OBESIDADE;
        if(imc >= 40.0) return eClassificacaoIMC.OBESIDADE_GRAVE;
        return null;
    }

}
