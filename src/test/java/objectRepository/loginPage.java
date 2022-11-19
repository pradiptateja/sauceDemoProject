package objectRepository;

import org.openqa.selenium.By;

public class loginPage {

    By inputUserName = By.xpath("//input[@id=\"user-name\"]");
    public By getInputUserName() {
        return inputUserName;
    }

    By inputPassword = By.xpath("//input[@id=\"password\"]");
    public By getInputPassword() {
        return inputPassword;
    }

    By buttonLogin = By.xpath("//input[@id=\"login-button\"]");

    public By getButtonLogin() {
        return buttonLogin;
    }

    By textErrorLogin = By.xpath("//h3[@data-test=\"error\"]");

    public By getTextErrorLogin() {
        return textErrorLogin;
    }
}
