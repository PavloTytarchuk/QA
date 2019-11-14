package tytarchuk;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;


public class AutoriaStartPage {
    private SelenideElement login = Selenide.$x("//span[text()=\"Вход в кабинет\"]");

    public AutoriaStartPage openAutoria() {
        Selenide.open("http://auto.ria.com");
        return this;
    }

    public AutoriaLoginPage enterLoginPage() {
        Selenide.$x("//span[text()=\"Вход в кабинет\"]").click();
        return Selenide.page(AutoriaLoginPage.class);
    }

}
