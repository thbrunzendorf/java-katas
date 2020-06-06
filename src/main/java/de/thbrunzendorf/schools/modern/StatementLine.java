package de.thbrunzendorf.schools.modern;

import java.time.LocalDate;
import java.util.function.Function;

public class StatementLine {
    private final Transaction transaction;
    private final int balance;

    public StatementLine(Transaction transaction, int balance) {
        this.transaction = transaction;
        this.balance = balance;
    }

    public String toString(Function<LocalDate, String> dateFormat) {
        return dateFormat.apply(transaction.getDate()) + "\t" + "+" + transaction.getAmount() + "\t" + balance;
    }
}
