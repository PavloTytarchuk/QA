package tytarchuk;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private final SelenideElement table;

    public Table(SelenideElement table) {
        this.table = table;
    }

    public List<SelenideElement> getLines() {
        return table.$$x(".//tr[position()>1]");
    }

    public List<ElementsCollection> getLinesWithColumns() {
        List<ElementsCollection> linesWithColumns = new ArrayList<>();
        getLines().forEach(line -> {
            ElementsCollection lineWithColumns = line.$$x(".//td");
            linesWithColumns.add(lineWithColumns);
        });
        return linesWithColumns;
    }
}
