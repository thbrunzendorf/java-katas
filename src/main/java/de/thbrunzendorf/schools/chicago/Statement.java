package de.thbrunzendorf.schools.chicago;

import java.util.ArrayList;
import java.util.List;

public class Statement {
    public static final String HEADER = "Date\tAmount\tBalance";

    private final Account account;

    public Statement(Account account) {
        this.account = account;
    }

    private List<StatementLine> createStatementLines() {
        List<StatementLine> statementLines = new ArrayList<>();
        int balance = 0;
        for (Transaction transaction : account.transactions) {
            balance += transaction.amount;
            statementLines.add(new StatementLine(transaction, balance));
        }
        return statementLines;
    }

    @Override
    public String toString() {
        String statementAsString = HEADER;
        for (StatementLine statementLine : createStatementLines()) {
            statementAsString += "\n" + statementLine.toString();
        }
        return statementAsString;
    }
}
