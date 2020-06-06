package de.thbrunzendorf.schools.chicago;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static de.thbrunzendorf.schools.chicago.Functions.formattedDate;
import static org.assertj.core.api.Assertions.assertThat;

public class FunctionTests {

    @Test
    void formattedDate_formats_a_string_for_a_date() {
        String formattedDate = formattedDate(LocalDate.of(2019, 1, 10));
        assertThat(formattedDate).isEqualTo("10.1.2019");
    }
}
