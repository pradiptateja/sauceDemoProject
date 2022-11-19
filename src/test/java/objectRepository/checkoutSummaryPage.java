package objectRepository;

import org.openqa.selenium.By;

public class checkoutSummaryPage {

    By textTitlePage = By.xpath("//span[@class='title']");
    public By getTextTitlePage() {
        return textTitlePage;
    }

    By textProductName = By.xpath("//div[@class='inventory_item_name']");
    public By getTextProductName() {
        return textProductName;
    }

    By textProductPrice = By.xpath("//div[@class='inventory_item_price']");
    public By getTextProductPrice() {
        return textProductPrice;
    }

    By buttonFinish = By.xpath("//button[@id='finish']");
    public By getButtonFinish() {
        return buttonFinish;
    }


}
