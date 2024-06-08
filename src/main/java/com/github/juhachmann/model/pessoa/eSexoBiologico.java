package com.github.juhachmann.model.pessoa;

public enum eSexoBiologico {

    FEMININO("Feminino"),
    MASCULINO("Masculino");

    private String name;

    eSexoBiologico(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
