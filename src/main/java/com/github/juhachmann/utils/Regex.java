package com.github.juhachmann.utils;

import java.util.regex.Pattern;

public class Regex {

    public static final Pattern NOME_HUMANO_GLOBAL = Pattern.compile("^([\\p{L}'-]+(\\s?))*+$");
    public static final Pattern INTEIRO_POSITIVO = Pattern.compile("([0-9]*)?");
    public static final Pattern DECIMAL_POSITIVO = Pattern.compile("([0-9]*([.][0-9]*)?)");

}
