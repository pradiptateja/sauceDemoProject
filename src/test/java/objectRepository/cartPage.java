package objectRepository;

import org.openqa.selenium.By;

public class cartPage {

    By listProductOnCart =  By.xpath("//div[@class=\"cart_item\"]");
    public By getListProductOnCart() {
        return listProductOnCart;
    }

    By textProductNameOnList = By.xpath("//div[@class=\"inventory_item_name\"]");
    public By getTextProductNameOnList() {
        return textProductNameOnList;
    }

    By buttonCheckout = By.xpath("//button[@id=\"checkout\"]");
    public By getButtonCheckout() {
        return buttonCheckout;
    }
}