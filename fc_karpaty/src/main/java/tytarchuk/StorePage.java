package tytarchuk;


import com.codeborne.selenide.Selenide;

public class StorePage extends Header {

    private static final String NEXT_PAGE_XPATH_TEMPLATE = "//div[@class = 'fm box_for_gal%s']//a[@class = 'nextPage browse right']";

    public StorePage popularItemsScrollToRight(){
        Selenide.$x(String.format(NEXT_PAGE_XPATH_TEMPLATE, " test")).click();
        return this;
    }

    public StorePage latestItemsScrollToRight(){
        Selenide.$x(String.format(NEXT_PAGE_XPATH_TEMPLATE, "")).click();
        return this;
    }

    public StorePage popularItemsScrollToLeft(){
        Selenide.$x("//div[@class = 'fm box_for_gal test']//a[@class = 'prevPage browse left']").click();
        return this;
    }

    public StorePage latestItemsScrollToLeft(){
        Selenide.$x("//div[@class = 'fm box_for_gal']//a[@class = 'prevPage browse left']").click();
        return this;
    }

    public ProductOverviewPage previewMiddleSizeBag(){
        Selenide.$x("//a[@class = 'product_link' and text() = 'Сумка (середня)']").click();
        return new ProductOverviewPage();
    }
}
