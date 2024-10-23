package core;

import utils.CryptoUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {

    private static final Properties properties = new Properties();

    static {
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/config/config.properties");
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static String getDecryptedProperty(String key) {
        try {
            String encryptedValue = properties.getProperty(key);
            return CryptoUtils.decrypt(encryptedValue);  // Decifra il valore
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Metodo per ottenere una proprietà come intero
    public static int getIntProperty(String key) {
        String value = properties.getProperty(key);
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            System.err.println("Errore: la proprietà " + key + " non è un numero intero valido.");
            return -1; // Valore di fallback in caso di errore
        }
    }
}
