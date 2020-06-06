package de.thbrunzendorf.schools.modern;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static de.thbrunzendorf.schools.modern.Functions.germanDateFormat;
import static org.assertj.core.api.Assertions.assertThat;

public class FunctionTests {
    @Test
    void germanDateFormat_should_return_a_string_for_a_Date_formatted_to_the_German_standard() {
        String formattedDate = germanDateFormat(LocalDate.of(2019, 1, 10));
        assertThat(formattedDate).isEqualTo("10.1.2019");
    }
}
