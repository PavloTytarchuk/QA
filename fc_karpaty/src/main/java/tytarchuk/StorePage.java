package tytarchuk;


import com.codeborne.selenide.Selenide;

public class StorePage extends Header {
    public StorePage popularItemsScrollToRight(){
        Selenide.$x("//div[@class = 'fm box_for_gal test']//a[@class = 'nextPage browse right']").click();
        return this;
    }

    public StorePage latestItemsScrollToRight(){
        Selenide.$x("//div[@class = 'fm box_for_gal']//a[@class = 'nextPage browse right']").click();
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
        return Selenide.page(ProductOverviewPage.class);
    }
}
