package tytarchuk;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class AutoriaResultPage {
    private List<Integer> prices = new ArrayList<>();
    private List<Integer> years = new ArrayList<>();

    public void goThroughAllPagesAndCollectData() throws InterruptedException {
        List<String> stringsOfPrices = new ArrayList<>();
        List<String> stringsOfDates = new ArrayList<>();

        while (!Selenide.$x("//a[@class = 'page-link js-next disabled']").isDisplayed()) {
            WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), 50);
            wait.until((ExpectedCondition<Boolean>) wd ->
                    ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
            SelenideElement forwardButton = Selenide.$x("//a[text() ='Вперед →']").scrollTo();
            stringsOfPrices.addAll(Selenide.$$x("//section[contains(@class, 'ticket-item new__ticket t') and not (contains(@class, '_loading hide'))]//span[@class ='size15']/span[@class = 'bold green size22' and @data-currency]").texts());
            stringsOfDates.addAll(Selenide.$$x("//section[contains(@class, 'ticket-item new__ticket t') and not (contains(@class, '_loading hide'))]//div[@class='head-ticket']//a[@class = 'address']").texts());
            forwardButton.scrollTo().click();
        }

        for (String s : stringsOfPrices) {
            s = s.replaceAll("\\s+", "");
            if (!s.isEmpty() && !s.contains("org.openqa")) {
                prices.add(Integer.parseInt(s));
            }
        }

        for (String s : stringsOfDates) {
            s = s.substring(s.length() - 4, s.length());
            years.add(Integer.parseInt(s));
        }

        Collections.sort(prices);
        Collections.sort(years);
    }

    public int getLowestPrice() {
        return prices.get(0);
    }

    public int getOldestCar() {
        return years.get(0);
    }
}
