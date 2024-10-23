package utils;

public class EnvUtils {

    // Ottiene una variabile d'ambiente, o un valore di default se non esiste
    public static String getEnv(String variableName, String defaultValue) {
        String value = System.getenv(variableName);
        return value != null ? value : defaultValue;
    }

    // Ottiene una variabile d'ambiente obbligatoria
    public static String getRequiredEnv(String variableName) {
        String value = System.getenv(variableName);
        if (value == null) {
            throw new IllegalArgumentException("Variabile d'ambiente mancante: " + variableName);
        }
        return value;
    }
}

