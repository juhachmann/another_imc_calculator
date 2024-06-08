package org.example.model.imc;

public class ValorReferenciaInfantil {

    private int idade;
    private double limiteNormal;
    private double limiteSobrepeso;
    private double limiteObesidade;

    public ValorReferenciaInfantil(int idade, double limiteNormal, double limiteSobrepeso, double limiteObesidade) {
        this.idade = idade;
        this.limiteNormal = limiteNormal;
        this.limiteSobrepeso = limiteSobrepeso;
        this.limiteObesidade = limiteObesidade;
    }

    public int getIdade() {
        return idade;
    }

    public double getLimiteNormal() {
        return limiteNormal;
    }

    public double getLimiteSobrepeso() {
        return limiteSobrepeso;
    }

    public double getLimiteObesidade() {
        return limiteObesidade;
    }

}
