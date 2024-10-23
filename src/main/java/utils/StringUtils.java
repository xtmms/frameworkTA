package utils;

public class StringUtils {

    // Verifica se una stringa è vuota o nulla
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    // Converte la prima lettera di una stringa in maiuscolo
    public static String capitalizeFirstLetter(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }

    // Sostituisce caratteri speciali
    public static String replaceSpecialCharacters(String str) {
        return str.replaceAll("[^a-zA-Z0-9]", "");
    }
}
