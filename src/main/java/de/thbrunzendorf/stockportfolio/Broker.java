package de.thbrunzendorf.stockportfolio;

import java.time.LocalDate;

public class Broker {
    private StockRepository repository;

    public Broker(StockExchange stockExchange, StockRepository repository) {
        this.repository = repository;
    }

    public void buyShares(String stock, int count, LocalDate date) {
        repository.store(stock, count, date);
    }

    public void sellShares(String stock, int count, LocalDate date) {
        repository.store(stock, -count, date);
    }

    public void printCurrentPortfolio(ConsolePrinter printer) {
        printer.print("company | shares | current price | current value | last operation");
    }
}
