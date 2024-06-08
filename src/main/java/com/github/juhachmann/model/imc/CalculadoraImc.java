package com.github.juhachmann.model.imc;

public class CalculadoraImc {
    public static double calcular(double peso, double altura) {
        return peso / Math.pow(altura, 2);
    }

}
