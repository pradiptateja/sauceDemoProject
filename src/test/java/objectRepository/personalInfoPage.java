package objectRepository;

import org.openqa.selenium.By;

public class personalInfoPage {

    By inputFirstName = By.xpath("//input[@id=\"first-name\"]");
    public By getInputFirstName() {
        return inputFirstName;
    }

    By inputLastName = By.xpath("//input[@id=\"last-name\"]");

    public By getInputLastName() {
        return inputLastName;
    }

    By inputPostalCode = By.xpath("//input[@id=\"postal-code\"]");

    public By getInputPostalCode() {
        return inputPostalCode;
    }

    By buttonContinue = By.xpath("//input[@id='continue']");

    public By getButtonContinue() {
        return buttonContinue;
    }

    By textErrorMessage = By.xpath("//h3[@data-test='error']");

    public By getTextErrorMessage() {
        return textErrorMessage;
    }
}
