package tytarchuk;


import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class NewsPage extends Header {
    public NewsPage openStartDateDropDown(){
        Selenide.$x("//input[@id = 'start_date']").click();
        return this;
    }

    public NewsPage chooseStartMonthNumber(int startMonthNumber){
        Selenide.$x("//select[@class = 'ui-datepicker-month']").selectOption(startMonthNumber-1);
        return this;
    }

    public NewsPage chooseStartYear(String startYear){
        Selenide.$x("//select[@class = 'ui-datepicker-year']").selectOption(startYear);
        return this;
    }

    public NewsPage chooseDate(String date) {
        SelenideElement dateFrom = Selenide.$x(String.format("//table[@class = 'ui-datepicker-calendar']/tbody/tr/td/a[text()='%s']", date));
        if (dateFrom.isDisplayed()) {
            dateFrom.click();
        } else throw new IllegalArgumentException("Invalid date: "+date);
        return this;
    }

    public NewsPage openEndDateDropDown(){
        Selenide.$x("//input[@id = 'end_date']").click();
        return this;
    }

    public NewsPage chooseEndMonthNumber(int endMonthNumber){
        Selenide.$x("//select[@class = 'ui-datepicker-month']").selectOption(endMonthNumber-1);
        return this;
    }

    public NewsPage chooseEndYear(String endYear){
        Selenide.$x("//select[@class = 'ui-datepicker-year']").selectOption(endYear);
        return this;
    }

}
