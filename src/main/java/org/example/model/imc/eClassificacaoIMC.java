package org.example.model.imc;

public enum eClassificacaoIMC {

    ABAIXO("Abaixo do Peso", ""),
    NORMAL("Peso Normal", ""),
    SOBREPESO("Sobrepeso", ""),
    OBESIDADE("Obesidade", ""),
    OBESIDADE_GRAVE("Obesidade Grave", "");

    private String name;
    private String description;

    eClassificacaoIMC(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

}
