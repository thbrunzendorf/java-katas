package de.thbrunzendorf.schools.munich;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Statement {

    private final String HEADER;

    private List<String> statementLines;

    public Statement(Account account) {
        HEADER = "Date\tAmount\tBalance";
        statementLines = List.of(
                "10.1.2012\t+1000\t1000",
                "13.1.2012\t+2000\t3000");
    }

    @Override
    public String toString() {
        // original starting point
//        return "Date\tAmount\tBalance\n" +
//                "10.1.2012\t+1000\t1000\n" +
//                "13.1.2012\t+2000\t3000";
        List<String> lines = new ArrayList<>();
        lines.addAll(List.of(HEADER));
        lines.addAll(this.statementLines);
        return lines.stream().collect(Collectors.joining("\n"));
    }
}
