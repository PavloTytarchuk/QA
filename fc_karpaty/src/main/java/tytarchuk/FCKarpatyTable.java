package tytarchuk;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.val;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class FCKarpatyTable extends Table {
    public FCKarpatyTable() {
        super(Selenide.$x("//div[@class='tab current']/table/tbody"));
    }

    public String getValueByLineNameAndColumnName(String teamName, Enum columnName) {
        val pattern = Pattern.compile("(«)(.+)(»)");
        val columnNumber = 0;
        int counter = 0;
        Map<String, Integer> numberByTeamName = new LinkedHashMap<>();
        ElementsCollection teamNames = Selenide.$$x("//div[@class='tab current']/table/tbody/tr/td[1]");

        for (SelenideElement names : teamNames) {
            Matcher matcher = pattern.matcher(names.text());
            if (matcher.find()) numberByTeamName.put(matcher.group(2), counter);
            counter++;
        }
        for (ColumnNames columnNames : ColumnNames.values()) {
            if (columnName.equals(columnNames)) {
                columnNumber = columnNames.getColumnNumber();
            }
        }
        List<ElementsCollection> linesWithColumns = getLinesWithColumns();
        return linesWithColumns.get(numberByTeamName.get(teamName)).get(columnNumber).getText();
    }
}
