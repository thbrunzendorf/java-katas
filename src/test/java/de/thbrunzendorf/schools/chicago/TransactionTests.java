package de.thbrunzendorf.schools.chicago;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class TransactionTests {

    @Test
    void transaction_should_hold_date_and_amount() {
        LocalDate date = LocalDate.of(2019, 1, 10);
        int amount = 1200;
        Transaction transaction = new Transaction(date, amount);
        assertThat(transaction.date).isEqualTo(date);
        assertThat(transaction.amount).isEqualTo(amount);
    }
}
