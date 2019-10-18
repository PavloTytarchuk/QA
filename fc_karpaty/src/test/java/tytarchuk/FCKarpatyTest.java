package tytarchuk;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FCKarpatyTest extends ChromeSettings {
    @BeforeTest
    protected void setUpBrowser(){
        super.setUpBrowser();
    }

    @Test
    public void getResultsOfTeam() {
        Selenide.open("https://fckarpaty.com");
        FCKarpatyTable table = new FCKarpatyTable();
        System.out.println(table.getValueByLineNameAndColumnName("Карпати", ColumnNames.POINTS));
    }

    @Test
    public void newsPageCheck(){
        Selenide.open("https://fckarpaty.com");
        MainPage mainPage = new MainPage();
        NewsPage newsPage = mainPage.moveToNewsPage();
        newsPage.openStartDateDropDown().chooseStartMonthNumber(7).chooseStartYear("2016").chooseStartDate("14");
        newsPage.openEndDateDropDown().chooseEndMonthNumber(10).chooseEndYear("2018").chooseEndDate("20");
        StorePage storePage = newsPage.moveToStorePage();
        ProductOverviewPage overviewPage = storePage.popularItemsScrollToRight().popularItemsScrollToRight().previewMiddleSizeBag();
        overviewPage.chooseQuantity(2).addToShoppingBag();
    }
}
