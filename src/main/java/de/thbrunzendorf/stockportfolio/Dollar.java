package de.thbrunzendorf.stockportfolio;

import java.util.Objects;

public class Dollar {
    private final int dollars;
    private final int cents;

    public Dollar(int dollars, int cents) {
        this.dollars = dollars;
        this.cents = cents;
    }

    public static Dollar of(int dollars, int cents) {
        return new Dollar(dollars, cents);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dollar dollar = (Dollar) o;
        return dollars == dollar.dollars &&
                cents == dollar.cents;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dollars, cents);
    }
}
