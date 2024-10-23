package core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.File;

//Livelli di log:
//INFO: Informazioni generali sul flusso dell'applicazione.
//DEBUG: Messaggi dettagliati utili per il debugging.
//ERROR: Messaggi di errore per eccezioni o problemi critici.
//WARN: Messaggi di avviso per segnalare potenziali problemi.
//CRITICAL: Può essere usato per segnalare problemi particolarmente gravi.

public class LoggerManager {

    // Logger condiviso
    private static final Logger logger = LogManager.getLogger(LoggerManager.class);

    static {
        createLogsDirectory();
        logger.info("LoggerManager inizializzato correttamente");
    }

    // Metodo per creare la directory logs se non esiste
    private static void createLogsDirectory() {
        File logDir = new File("target/logs");
        if (!logDir.exists()) {
            boolean isCreated = logDir.mkdirs();
            if (isCreated) {
                System.out.println("Directory 'target/logs' creata con successo.");
            } else {
                System.err.println("Errore nella creazione della directory 'target/logs'.");
            }
        }
    }

    // Metodo per loggare messaggi informativi
    public static void info(String message) {
        logger.info(message);
    }

    // Metodo per loggare messaggi di debug
    public static void debug(String message) {
        logger.debug(message);
    }

    // Metodo per loggare messaggi di errore
    public static void error(String message) {
        logger.error(message);
    }

    // Metodo per loggare un'eccezione con messaggio di errore
    public static void error(String message, Throwable throwable) {
        logger.error(message, throwable);
    }

    // Metodo per loggare messaggi di avviso (warning)
    public static void warn(String message) {
        logger.warn(message);
    }

    // Metodo per loggare messaggi critici
    public static void critical(String message) {
        logger.fatal("CRITICAL: " + message);
    }
}

