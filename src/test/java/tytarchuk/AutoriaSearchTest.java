package tytarchuk;

import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AutoriaSearchTest extends ChromeSettings {
    @BeforeTest
    protected void setUpBrowser() {
        super.setUpBrowser();
    }


    @Test
    public void searchByAllFieldsToFindOldestAndCheapestCar() throws InterruptedException {
        AutoriaStartPage openAndLoginAutoriaPage = new AutoriaStartPage();
        openAndLoginAutoriaPage.openAutoria();
        AutoriaLoginPage autoriaLoginPage = openAndLoginAutoriaPage.enterLoginPage();
        SearchByCriteriaPage searchByCriteriaPage = autoriaLoginPage.login("380663877198", "159753000");
        searchByCriteriaPage.chooseCarByCategory("Любой");
        searchByCriteriaPage.chooseCarByBrand("BMW").chooseByModel("320");
        searchByCriteriaPage.chooseByRegion("Львов");
        searchByCriteriaPage.chooseYearFrom("2000").chooseYearTo("2016");
        searchByCriteriaPage.chooseByPriceFrom("10000").chooseByPriceTo("25000");
        AutoriaResultPage autoriaResultPage = searchByCriteriaPage.clickSearchButton();
        autoriaResultPage.goThroughAllPagesAndCollectData();
        Assert.assertTrue(autoriaResultPage.getLowestPrice() > 10000 && autoriaResultPage.getLowestPrice() < 25000, "Actual lowest price is out of search bounds");
        Assert.assertTrue(autoriaResultPage.getOldestCar() > 2000 && autoriaResultPage.getOldestCar() < 2016, "Actual oldest car is out of search bounds");
    }

    @Test
    public void getResultsOfTeam(){
        Selenide.open("https://fckarpaty.com");
        FCKarpatyTable table=new FCKarpatyTable();
        Assert.assertEquals(table.getValueWithHeading("Карпати", "О"),"8","Expected and actual number of points doesn't match");//column name to ENUM
    }
}
