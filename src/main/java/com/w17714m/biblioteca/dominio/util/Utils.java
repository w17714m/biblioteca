package com.w17714m.biblioteca.dominio.util;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    public static LocalDate calcularDiasSinDomingos(LocalDate fecha, int dias) {
        LocalDate retorno = fecha;
        int diasAgregados = 0;
        while (diasAgregados < dias) {
            retorno = retorno.plusDays(1);
            if (!(retorno.getDayOfWeek() == DayOfWeek.SUNDAY)) {
                ++diasAgregados;
            }
        }
        return retorno;
    }

    public static boolean esPalindromo(String isbn) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(isbn);
        String reverse = stringBuilder.reverse().toString();
        return isbn.equals(reverse);
    }

    public static float sumaNumerosIsbn(String isbn) {
        Pattern pattern = Pattern.compile("\\d");
        Matcher matcher = pattern.matcher(isbn);
        float sum = 0l;
        while (matcher.find()) {
            sum = sum + Float.parseFloat(isbn.substring(matcher.start(), matcher.end()));
        }
        return sum;
    }
}
