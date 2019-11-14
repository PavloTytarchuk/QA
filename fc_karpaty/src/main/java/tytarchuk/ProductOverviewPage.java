package tytarchuk;


import com.codeborne.selenide.Selenide;

public class ProductOverviewPage {
    public ProductOverviewPage chooseQuantity(int quantity){
        Selenide.$x("//select[@id  = 'cart_product_count']").selectOption(quantity-1);
        return this;
    }

    public ProductOverviewPage chooseSize(String size){
        Selenide.$x("//select[@id  = 'cart_product_size']").selectOption(size);
        return this;
    }

    public ProductOverviewPage addToShoppingBag(){
        Selenide.$x("//button[text() = 'Додати в кошик']").click();
        return this;
    }

    public ShoppingBagPage goToShoppingBagPage(){
        Selenide.$x("//a[text() = 'Кошик ']").click();
        return Selenide.page(ShoppingBagPage.class);
    }
}
