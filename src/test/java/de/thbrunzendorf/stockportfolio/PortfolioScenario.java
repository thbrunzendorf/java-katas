package de.thbrunzendorf.stockportfolio;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PortfolioScenario {

    public static final String OLD_SCHOOL_WATERFALL_SOFTWARE_LTD = "Old School Waterfall Software LTD";
    public static final String CRAFTER_MASTERS_LIMITED = "Crafter Masters Limited";
    public static final String XP_PRACTIONEERS_INCORPORATED = "XP Practioneers Incorporated";

    private StockExchange stockExchange = new FakeStockExchange();
    private ConsolePrinter printer = mock(ConsolePrinter.class);
    private Broker broker = new Broker(stockExchange, new StockRepository());

    @Test
    @Disabled("Acceptance Test not working yet")
    void printPortfolioCriteria() {

        // given
        i_bought_shares(OLD_SCHOOL_WATERFALL_SOFTWARE_LTD, 1000, LocalDate.of(1990, 2, 14));
        i_bought_shares(CRAFTER_MASTERS_LIMITED, 400, LocalDate.of(2016, 6, 9));
        i_bought_shares(XP_PRACTIONEERS_INCORPORATED, 700, LocalDate.of(2018, 12, 10));
        i_sold_shares(OLD_SCHOOL_WATERFALL_SOFTWARE_LTD, 500, LocalDate.of(2018, 12, 11));
        current_share_value_of(OLD_SCHOOL_WATERFALL_SOFTWARE_LTD, Dollar.of(5, 75));
        current_share_value_of(CRAFTER_MASTERS_LIMITED, Dollar.of(17, 25));
        current_share_value_of(XP_PRACTIONEERS_INCORPORATED, Dollar.of(25, 55));

        // when
        i_print_my_current_portfolio();

        // then
        String expectedOutcome = "company | shares | current price | current value | last operation\n" +
                "Old School Waterfall Software LTD | 500 | $5.75 | $2,875.00 | sold 500 on 11/12/2018\n" +
                "Crafter Masters Limited | 400 | $17.25 | $6,900.00 | bought 400 on 09/06/2016\n" +
                "XP Practitioners Incorporated | 700 | $25.55 | $17,885.00 | bought 700 on 10/12/2018";
        the_outcome_displayed_should_be(expectedOutcome);

        //assertThat(1).isEqualTo(2);


    }

    private void current_share_value_of(String stock, Dollar amount) {
        stockExchange.setShareValueOf(stock, amount);
    }

    private void i_print_my_current_portfolio() {
        broker.printCurrentPortfolio(printer);
    }

    private void the_outcome_displayed_should_be(String expectedOutcome) {
        verify(printer).print(expectedOutcome);
    }

    private void i_sold_shares(String stock, int count, LocalDate date) {
        broker.sellShares(stock, count, date);
    }

    private void i_bought_shares(String stock, int count, LocalDate date) {
        broker.buyShares(stock, count, date);
    }
}
