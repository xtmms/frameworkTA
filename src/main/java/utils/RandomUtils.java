package utils;

import java.util.Random;

public class RandomUtils {

    private static Random random = new Random();

    // Genera un numero casuale tra min e max
    public static int generateRandomNumber(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }

    // Genera una stringa casuale di una certa lunghezza
    public static String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }
        return sb.toString();
    }

    // Genera un'email casuale
    public static String generateRandomEmail() {
        return generateRandomString(8) + "@example.com";
    }
}
