package de.thbrunzendorf.schools.munich;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTests {

    @Test
    void should_print_the_correct_statement_after_withdraws_and_deposits() {
        Account account = new Account();
        account.deposit(LocalDate.of(2012, 1, 10), 1000);
        account.deposit(LocalDate.of(2012, 1, 13), 2000);
        assertThat(new Statement(account).toString()).isEqualTo("Date\tAmount\tBalance\n" +
                "10.1.2012\t+1000\t1000\n" +
                "13.1.2012\t+2000\t3000");
    }
}
