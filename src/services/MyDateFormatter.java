package services;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class MyDateFormatter {
    public static DateTimeFormatter getFormatter(boolean bornBefore2000) {
        DateTimeFormatter formatter;

        if (bornBefore2000) {
            formatter = new DateTimeFormatterBuilder()
                    .appendValueReduced(ChronoField.YEAR_OF_ERA, 2, 2, 1900)
                    .appendPattern("MMdd")
                    .toFormatter();
        } else {
            formatter = DateTimeFormatter.ofPattern("yyMMdd");
        }

        return formatter;
    }

    public static String removeSlashFromId(String id) {
        if (id.length() == 11) {
            id = id.substring(0, 6) + id.substring(7);
        }

        return id;
    }
}