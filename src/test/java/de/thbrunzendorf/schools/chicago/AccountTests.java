package de.thbrunzendorf.schools.chicago;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Consumer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

public class AccountTests {

    @Test
    void should_add_new_Transactions_on_Deposit() {
        Account account = new Account();
        account.deposit(LocalDate.of(2019, 1, 10), 2000);
        assertThat(account.transactions).isEqualTo(List.of(
                new Transaction(LocalDate.of(2019, 1, 10), 2000)));
    }

    @Test
    void should_add_2_new_Transactions_on_2_Deposits() {
        Account account = new Account();
        account.deposit(LocalDate.of(2019, 1, 10), 2000);
        account.deposit(LocalDate.of(2019, 1, 14), 1000);
        assertThat(account.transactions).isEqualTo(List.of(
                new Transaction(LocalDate.of(2019, 1, 10), 2000),
                new Transaction(LocalDate.of(2019, 1, 14), 1000)));
    }

    @Test
    void should_print_a_Statement() {
        Consumer<String> printFn = Mockito.mock(Consumer.class);
        Account account = new Account();
        account.deposit(LocalDate.of(2019, 1, 10), 2000);
        account.deposit(LocalDate.of(2019, 1, 14), 1000);
        account.print(printFn);
        verify(printFn).accept(new Statement(account).toString());
    }
}
