package de.thbrunzendorf.schools.chicago;

import static de.thbrunzendorf.schools.chicago.Functions.formattedDate;

public class StatementLine {
    private final Transaction transaction;
    private final int balance;

    public StatementLine(Transaction transaction, int balance) {
        this.transaction = transaction;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return formattedDate(transaction.date) + "\t" + "+" + transaction.amount + "\t" + balance;
    }
}
