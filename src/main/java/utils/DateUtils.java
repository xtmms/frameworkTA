package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    // Restituisce la data corrente in un formato specificato
    public static String getCurrentDate(String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date());
    }

    // Aggiunge giorni alla data corrente
    public static String addDaysToDate(int days, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date currentDate = new Date();
        long newTime = currentDate.getTime() + (days * 24L * 60 * 60 * 1000); // Aggiungi giorni
        return sdf.format(new Date(newTime));
    }
}
