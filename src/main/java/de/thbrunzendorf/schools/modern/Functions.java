package de.thbrunzendorf.schools.modern;

import java.time.LocalDate;

public class Functions {
    public static String germanDateFormat(LocalDate date) {
        return date.getDayOfMonth() + "." + date.getMonthValue() + "." + date.getYear();
    }
}
