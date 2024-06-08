package org.example.utils;

import javafx.scene.control.TextFormatter;

import java.util.function.UnaryOperator;
import java.util.regex.Pattern;

public class CriadorDeFiltro {

    public UnaryOperator<TextFormatter.Change> fromRegex(Pattern regex) {
        return change -> {
            String newText = change.getControlNewText();
            if (regex.matcher(newText).matches()) {
                return change;
            } else {
                return null;
            }
        };
    }


    public UnaryOperator<TextFormatter.Change> fromRegex(Pattern regex, double minValue, double maxValue) {
        return change -> {
            String newText = change.getControlNewText();
            if(newText.isEmpty()) {
                return change;
            }
            if (regex.matcher(newText).matches()) {
                var numericValue = tryToParseNumber(newText);
                if (numericValue != null) {
                    if (checkIfNumberIsWithinRange(numericValue, minValue, maxValue))
                        return change;
                }
            }
            return null;
        };
    }

    private Double tryToParseNumber(String numberAsText) {
        try {
            return Double.parseDouble(numberAsText);
        } catch (NumberFormatException ignored) {
            return null;
        }
    }

    private <T extends Number> boolean checkIfNumberIsWithinRange(T newValue, T min, T max) {
        return  (newValue.doubleValue() >= min.doubleValue() && newValue.doubleValue() <= max.doubleValue());
    }


}
