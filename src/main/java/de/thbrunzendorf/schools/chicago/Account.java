package de.thbrunzendorf.schools.chicago;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Account {
    public List<Transaction> transactions = new ArrayList();

    public void deposit(LocalDate date, int amount) {
        transactions.add(new Transaction(date, amount));
    }

    public void print(Consumer<String> printFn) {
        Statement statement = new Statement(this);
        printFn.accept(statement.toString());
    }
}
