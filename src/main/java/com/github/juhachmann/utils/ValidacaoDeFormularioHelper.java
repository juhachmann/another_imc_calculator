package com.github.juhachmann.utils;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class ValidacaoDeFormularioHelper {

    public static boolean validar(List<Control> campos) {
        var camposValidados = new ArrayList<Boolean>();
        for(Control campo : campos) {
            if (campo instanceof TextField casted) {
                camposValidados.add(validar(casted));
            }
            if (campo instanceof ChoiceBox<?> casted) {
                 camposValidados.add(validar(casted));
            }
        }
        for (Boolean campoValidado : camposValidados) {
            if (!campoValidado) return false;
        }
        return true;
    }

    public static boolean validar(TextField campo) {
        if(campo.getText().isEmpty() || campo.getText().isBlank()) {
            return false;
        } else {
            try{
                double valorNumerico = Double.parseDouble(campo.getText());
                if (valorNumerico <= 0.0) {
                    System.out.println("Números devem ser maiores do que 0");
                    campo.setText("");
                    return false;
                }
            }
            catch (NumberFormatException ignored) {
            }
        }
        return true;
    }

    public static boolean validar(ChoiceBox<?> choiceBox) {
        return choiceBox.getValue() != null;
    }

}
