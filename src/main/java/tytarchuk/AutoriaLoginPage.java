package tytarchuk;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.page;


public class AutoriaLoginPage {
    public SearchByCriteriaPage login(String username, String password) throws InterruptedException {
        Selenide.switchTo().frame("login_frame");
        Selenide.$(By.id("emailloginform-email")).sendKeys(username);
        Selenide.$(By.id("emailloginform-password")).sendKeys(password);
        Selenide.$x("//button[text()='Войти']").click();
        Selenide.switchTo().defaultContent();
        Selenide.$(By.id("autoRiaLogo")).waitUntil(Condition.exist, 120000).click(); //time to solve CAPTCHA
        return page(SearchByCriteriaPage.class);
    }
}
