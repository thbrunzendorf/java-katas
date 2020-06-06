package de.thbrunzendorf.schools.chicago;

import java.time.LocalDate;

public class Functions {

    public static String formattedDate(LocalDate date) {
        return date.getDayOfMonth() + "." + date.getMonthValue() + "." + date.getYear();
    }

}
