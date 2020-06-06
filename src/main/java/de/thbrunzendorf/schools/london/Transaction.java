package de.thbrunzendorf.schools.london;

import java.time.LocalDate;
import java.util.Objects;

public class Transaction {
    private final LocalDate date;
    private final int amount;

    public Transaction(LocalDate date, int amount) {
        this.date = date;
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return amount == that.amount &&
                date.equals(that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, amount);
    }
}
