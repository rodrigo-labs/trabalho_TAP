package br.com.integrador.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Utils {

    private static int ID = 1;

    public static int getProximoID() {
        return ID++;
    }

    public static String dataDeHoje() {
        LocalDate hoje = LocalDate.now();
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return hoje.format(formatador);
    }
}
