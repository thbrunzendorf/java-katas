package de.thbrunzendorf.schools.chicago;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class StatementTests {

    @Test
    void should_print_a_blank_Statement() {
        Account account = new Account();
        Statement statement = new Statement(account);
        assertThat(statement.toString()).isEqualTo(
                "Date\tAmount\tBalance");
    }

    @Test
    void should_print_a_Statement_with_1_Transaction() {
        Account account = new Account();
        account.deposit(LocalDate.of(2019, 1, 10), 1000);
        Statement statement = new Statement(account);
        assertThat(statement.toString()).isEqualTo(
                "Date\tAmount\tBalance\n" +
                        "10.1.2019\t+1000\t1000");
    }

    @Test
    void should_print_a_Statement_with_2_Transactions() {
        Account account = new Account();
        account.deposit(LocalDate.of(2019, 1, 10), 1000);
        account.deposit(LocalDate.of(2019, 1, 13), 2000);
        Statement statement = new Statement(account);
        assertThat(statement.toString()).isEqualTo(
                "Date\tAmount\tBalance\n" +
                        "10.1.2019\t+1000\t1000\n" +
                        "13.1.2019\t+2000\t3000");
    }
}
