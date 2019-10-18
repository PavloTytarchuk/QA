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
        ElementsCollection lines = table.$$x(".//tr");
        List<SelenideElement> l1nes = new ArrayList<>();
        l1nes.addAll(lines);
        l1nes.remove(0);
        return l1nes;
    }

    public List<ElementsCollection> getLinesWithColumns() {
        List<SelenideElement> lines = getLines();
        List<ElementsCollection> linesWithColumns = new ArrayList<>();
        lines.forEach(line -> {
            ElementsCollection lineWithColumns = line.$$x(".//td");
            linesWithColumns.add(lineWithColumns);
        });
        return linesWithColumns;
    }
}
