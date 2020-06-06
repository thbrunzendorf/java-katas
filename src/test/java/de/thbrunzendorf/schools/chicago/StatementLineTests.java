package de.thbrunzendorf.schools.chicago;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class StatementLineTests {

    @Test
    void toString_should_return_a_formatted_string() {
        Transaction transaction = new Transaction(LocalDate.of(2019, 1, 10), 1000);
        StatementLine statementLine = new StatementLine(transaction, 3000);
        assertThat(statementLine.toString()).isEqualTo("10.1.2019\t+1000\t3000");
    }

    @Test
    void toString_returns_a_formatted_string_for_2nd_transaction() {
        Transaction transaction = new Transaction(LocalDate.of(2019, 1, 14), 500);
        StatementLine statementLine = new StatementLine(transaction, 2000);
        assertThat(statementLine.toString()).isEqualTo("14.1.2019\t+500\t2000");
    }
}
