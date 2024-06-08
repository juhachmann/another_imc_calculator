package com.github.juhachmann.model.pessoa;

public class Pessoa {

    private String nome;
    private int idade;
    private double peso;
    private double altura;
    private eSexoBiologico eSexoBiologico;

    public Pessoa() {
    }

    public Pessoa(String nome, int idade, double peso, double altura, eSexoBiologico eSexoBiologico) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.altura = altura;
        this.eSexoBiologico = eSexoBiologico;
    }


    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public double getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
    }

    public eSexoBiologico getSexoBiologico() {
        return eSexoBiologico;
    }


}
