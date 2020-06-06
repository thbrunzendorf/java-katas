package de.thbrunzendorf.schools.london;

import de.thbrunzendorf.schools.london.Account;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.function.Consumer;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class AcceptanceTests {

    @Test
    @Disabled
    void should_print_a_Statement_with_two_Deposits() {
        Consumer<String> printerFn = mock(Consumer.class);
        Account account = new Account();
        account.deposit(LocalDate.of(2012, 1, 10), 1000);
        account.deposit(LocalDate.of(2012, 1, 13), 2000);
        account.print(printerFn);
        verify(printerFn).accept("Date\tAmount\tBalance\n" +
                "10.1.2012\t+1000\t1000\n" +
                "13.1.2012\t+2000\t3000\n");
    }
}
