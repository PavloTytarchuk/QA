package tytarchuk;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.*;


public class FCKarpatyTable {
    private SelenideElement table = Selenide.$x("//div[@class='tab current']/table/tbody");

    public List<SelenideElement> getLines() {
        List<SelenideElement>lines = Selenide.$$x("//div[@class='tab current']/table/tbody/tr");
        List<SelenideElement>l1nes = new ArrayList<>();
        l1nes.addAll(lines);
        l1nes.remove(0);
        return l1nes;
    }

    public ElementsCollection getHeadings() {
        return Selenide.$$x("//div[@class='tab current']/table/tbody//tr[1]/th");
    }

    public List<List<WebElement>> getLinesWithColumns() {
        List<SelenideElement> lines = getLines();
        List<List<WebElement>> linesWithColumns = new ArrayList<>();
        lines.forEach(line -> {
            List<WebElement> lineWithColumns = line.findElements(By.xpath(".//td"));
            linesWithColumns.add(lineWithColumns);});
        return linesWithColumns;
    }

    public List<Map<String, WebElement>> getLinesWithColumnsByHeadings(){
        List<List<WebElement>> linesWithColumns = getLinesWithColumns();
        List<Map<String , WebElement>> linesWithColumnsByHeading = new ArrayList<>();
        Map<String, WebElement> lineByHeading;
        ElementsCollection headingColumns = getHeadings();
        for(List<WebElement> line: linesWithColumns){
            lineByHeading=new HashMap<>();
            for (int i = 0; i < headingColumns.size(); i++) {
                String heading = headingColumns.get(i).getText();
                WebElement cell = line.get(i);
                lineByHeading.put(heading,cell);
            }
            linesWithColumnsByHeading.add(lineByHeading);
        }
        return linesWithColumnsByHeading;
    }

    public String getValueWithHeading(String teamName, String columnName){
        int counter=0;
        Map<String, Integer> numberByTeamName=new LinkedHashMap<>();
        ElementsCollection teamNames=Selenide.$$x("//div[@class='tab current']/table/tbody/tr/td[1]");
        for(SelenideElement names: teamNames){ //remake with regex
            String team=names.text();
            int startIndex=team.indexOf("«");
            int lastIndex=team.lastIndexOf("»");
            team=team.substring(startIndex+1,lastIndex);
            numberByTeamName.put(team,counter);
            counter++;
        }
        List<Map<String, WebElement>> linesWithColumnsByHeadings = getLinesWithColumnsByHeadings();
        return linesWithColumnsByHeadings.get(numberByTeamName.get(teamName)).get(columnName).getText();
    }
}
