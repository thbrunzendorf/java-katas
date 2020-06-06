package de.thbrunzendorf.stockportfolio;

import java.util.HashMap;
import java.util.Map;

public class FakeStockExchange implements StockExchange {

    private Map latestShareValue = new HashMap();

    @Override
    public void setShareValueOf(String stock, Dollar amount) {
        latestShareValue.put(stock, amount);
    }
}
