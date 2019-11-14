package tytarchuk;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FCKarpatyTest extends ChromeSettings {
    @BeforeTest
    protected void setUpBrowser(){
        super.setUpBrowser();
    }

    @Test
    public void verifyResultsOfTeam() {
        MainPage mainPage = new MainPage();
        mainPage.openPage();
        FCKarpatyTable table = new FCKarpatyTable();
        Assert.assertEquals(table.getValueByLineNameAndColumnName("Карпати", ColumnNames.POINTS),"10","Expected and actual number of points are different");
    }

    @Test
    public void verifyNewsPageAndStorePageWorkingCapacity(){
        MainPage mainPage = new MainPage();
        mainPage.openPage();
        NewsPage newsPage = mainPage.openNewsPage();
        newsPage.openStartDateDropDown().chooseStartMonthNumber(7).chooseStartYear("2016").chooseDate("14");
        newsPage.openEndDateDropDown().chooseEndMonthNumber(10).chooseEndYear("2018").chooseDate("20");
        StorePage storePage = newsPage.openStorePage();
        ProductOverviewPage overviewPage = storePage.popularItemsScrollToRight().popularItemsScrollToRight().previewMiddleSizeBag();
        overviewPage.chooseQuantity(2).addToShoppingBag();
    }
}
