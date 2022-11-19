package objectRepository;

import org.openqa.selenium.By;

public class completeOrderPage {

    By textTitlePage = By.xpath("//span[@class='title']");
    public By getTextTitlePage() {
        return textTitlePage;
    }

    By textCompleteOrder = By.xpath("//h2[@class='complete-header']");

    public By getTextCompleteOrder() {
        return textCompleteOrder;
    }
}
