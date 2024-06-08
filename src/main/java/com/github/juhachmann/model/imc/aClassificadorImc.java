package com.github.juhachmann.model.imc;

public abstract class aClassificadorImc {

    private String categoria;

    public aClassificadorImc(String categoria) {
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public abstract eClassificacaoIMC classificar(double imc);

}
