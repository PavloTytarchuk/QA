package tytarchuk;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.page;

public class SearchByCriteriaPage {

    public SearchByCriteriaPage chooseCarByCategory(String carCategory) {
        Selenide.$x("//select[@id = 'categories']").selectOption(carCategory);
        return this;
    }

    public SearchByCriteriaPage chooseCarByBrand(String brandOfCar) {
        Selenide.$x("//div[@id = 'brandTooltipBrandAutocomplete-brand']/input").setValue(brandOfCar);
        Selenide.$x(String.format("//a[text() = '%s']", brandOfCar)).click();
        return this;
    }

    public SearchByCriteriaPage chooseByModel(String modelOfCar) {
        Selenide.$x("//div[@id = 'brandTooltipBrandAutocomplete-model']/input").setValue(modelOfCar);
        Selenide.$x(String.format("//a[text() = '%s']", modelOfCar)).click();
        return this;
    }

    public SearchByCriteriaPage chooseByRegion(String yourRegion) {
        Selenide.$x("//div[@id ='brandTooltipBrandAutocomplete-region']/input").setValue(yourRegion);
        Selenide.$x(String.format("//a[text() = '%s']", yourRegion)).click();
        return this;
    }

    public SearchByCriteriaPage chooseYearFrom(String yearFrom) {
        Selenide.$x(String.format("//select[@id = 'yearFrom']")).selectOption(yearFrom);
        return this;
    }

    public SearchByCriteriaPage chooseYearTo(String yearTo) {
        Selenide.$x("//select[@id = 'yearTo']").selectOption(yearTo);
        return this;
    }

    public SearchByCriteriaPage chooseByPriceFrom(String priceFrom) {
        Selenide.$x("//input[@id = 'priceFrom']").setValue(priceFrom);
        return this;
    }

    public SearchByCriteriaPage chooseByPriceTo(String priceTo) {
        Selenide.$x("//input[@id = 'priceTo']").setValue(priceTo);
        return this;
    }

    public AutoriaResultPage clickSearchButton() {
        Selenide.$x("//button[@type = 'submit']").click();
        return Selenide.page(AutoriaResultPage.class);
    }
}
