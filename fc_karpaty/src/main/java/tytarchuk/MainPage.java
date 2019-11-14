package tytarchuk;

import com.codeborne.selenide.Selenide;

public class MainPage extends Header {
    public MainPage openPage(){
        Selenide.open("https://fckarpaty.com");
        return this;
    }
}
