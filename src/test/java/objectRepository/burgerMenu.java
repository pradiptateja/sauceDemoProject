package objectRepository;

import org.openqa.selenium.By;

public class burgerMenu {

    By buttonAllItems = By.xpath("//a[@id='inventory_sidebar_link']");

    public By getButtonAllItems() {
        return buttonAllItems;
    }

    By buttonAbout = By.xpath("//a[@id='about_sidebar_link']");

    public By getButtonAbout() {
        return buttonAbout;
    }

    By buttonLogout = By.xpath("//a[@id='logout_sidebar_link']");

    public By getButtonLogout() {
        return buttonLogout;
    }
}
