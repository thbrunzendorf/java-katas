package de.thbrunzendorf.schools.modern;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class StatementLineTests {

    @Test
    void should_return_a_formatted_string() {
        Transaction transaction = Mockito.mock(Transaction.class);
        when(transaction.getDate()).thenReturn(LocalDate.of(2019, 1, 10));
        when(transaction.getAmount()).thenReturn(1000);

        Function<LocalDate, String> germanDateFormat = Mockito.mock(Function.class);
        when(germanDateFormat.apply(any(LocalDate.class))).thenReturn("10.1.2019");

        StatementLine statementLine = new StatementLine(transaction, 3000);
        assertThat(statementLine.toString(germanDateFormat)).isEqualTo("10.1.2019\t+1000\t3000");
    }
}
