package tytarchuk;


import com.codeborne.selenide.Selenide;

public abstract class Header {
    public NewsPage openNewsPage(){
        Selenide.$x("//nav/li/a[@target='_self' and text() = 'Новини']").click();
        Selenide.$x("//nav/li/ul/li/a[text()= 'Новини']").click();
        return Selenide.page(NewsPage.class);
    }

    public StorePage openStorePage(){
        Selenide.$x("//nav/li/a[@target='_self' and text() = 'Магазин']").click();
        Selenide.$x("//nav/li/ul/li/a[text()= 'Інтернет-магазин']").click();
        return Selenide.page(StorePage.class);
    }
}
