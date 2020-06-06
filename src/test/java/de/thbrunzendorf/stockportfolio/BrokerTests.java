package de.thbrunzendorf.stockportfolio;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BrokerTests {

    @Test
    void shouldStoreSharesWhenIBuyThem() {
        // arrange
        StockExchange stockExchange = mock(StockExchange.class);
        StockRepository repository = mock(StockRepository.class);
        Broker broker = new Broker(stockExchange, repository);
        // act
        broker.buyShares("someStock", 42, LocalDate.of(2020, 02, 07));
        // assert
        verify(repository).store("someStock", 42, LocalDate.of(2020, 02, 07));
    }

    @Test
    void shouldStoreSharesWhenISellThem() {
        // arrange
        StockExchange stockExchange = mock(StockExchange.class);
        StockRepository repository = mock(StockRepository.class);
        Broker broker = new Broker(stockExchange, repository);
        // act
        broker.sellShares("someStock", 42, LocalDate.of(2020, 02, 07));
        // assert
        verify(repository).store("someStock", -42, LocalDate.of(2020, 02, 07));
    }

    @Test
    void shouldInvokePrinterWithHeadlineAndEmptySharesWhenNoSharesArePresent() {
        // arrange
        StockExchange stockExchange = mock(StockExchange.class);
        StockRepository repository = mock(StockRepository.class);
        Broker broker = new Broker(stockExchange, repository);
        // act
        ConsolePrinter printer = mock(ConsolePrinter.class);
        broker.printCurrentPortfolio(printer);
        // assert
        verify(printer).print("company | shares | current price | current value | last operation");
    }

    @Test
    @Disabled("WIP")
    void shouldInvokePrinterWithHeadlineAndOneEntryWhenOneStockBought() {
        // arrange
        StockExchange stockExchange = mock(StockExchange.class);
        StockRepository repository = mock(StockRepository.class);
        Broker broker = new Broker(stockExchange, repository);
        broker.buyShares("someStock", 10, LocalDate.of(2020, 02, 07));
        // act
        ConsolePrinter printer = mock(ConsolePrinter.class);
        broker.printCurrentPortfolio(printer);
        // assert
        verify(printer).print("company | shares | current price | current value | last operation\n" +
                "someStock | 10 | $12.50 | $125.00 | bought 10 on 07/02/2020");
    }
}
