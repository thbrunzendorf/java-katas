package de.thbrunzendorf.schools.london;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class AccountTests {

    @Test
    void should_add_StatementLine_of_deposit_to_Statement() {
        Statement statement = mock(Statement.class);
        Transaction transaction = new Transaction(LocalDate.of(2012, 1, 13), 1000);
        Account account = new Account(statement);
        account.deposit(LocalDate.of(2012, 1, 13), 1000);
        verify(statement).addLine(transaction, 1000);
    }
}
