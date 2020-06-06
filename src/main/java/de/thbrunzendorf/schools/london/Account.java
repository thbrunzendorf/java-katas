package de.thbrunzendorf.schools.london;

import java.time.LocalDate;
import java.util.function.Consumer;

public class Account {

    private Statement statement;

    public Account() {
        this(new Statement());
    }

    Account(Statement statement) {

        this.statement = statement;
    }

    public void deposit(LocalDate date, int amount) {
        this.statement.addLine(new Transaction(date, amount), amount);
    }

    public void print(Consumer<String> printerFn) {

    }
}
