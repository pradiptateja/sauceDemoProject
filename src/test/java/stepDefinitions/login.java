package stepDefinitions;

import config.setup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import objectRepository.loginPage;
import objectRepository.productPage;
import static org.testng.AssertJUnit.assertTrue;

public class login extends setup {

    loginPage elementsLogin = new loginPage();
    productPage elementsProductPage = new productPage();


    @Given("user is at SauceDemo login page")
    public void user_is_at_sauce_demo_login_page() {
        WebElement inputPassword = driver.findElement(elementsLogin.getInputPassword());
        assertTrue(inputPassword.isDisplayed());

        WebElement inputUserName = driver.findElement(elementsLogin.getInputUserName());
        assertTrue(inputUserName.isDisplayed());

        WebElement buttonLogin  = driver.findElement(elementsLogin.getButtonLogin());
        assertTrue(buttonLogin.isDisplayed());

    }

    @When("user inputs standard account username")
    public void user_inputs_standard_account_username() {
        WebElement inputUserName = driver.findElement(elementsLogin.getInputUserName());
        inputUserName.sendKeys("standard_user");

    }

    @When("user inputs standard account password")
    public void user_inputs_standard_account_password() {
        WebElement inputPassword = driver.findElement(elementsLogin.getInputPassword());
        inputPassword.sendKeys("secret_sauce");

    }

    @When("user inputs registered account username (.*)$")
    public void user_inputs_registered_account_username(String username) {
        WebElement inputUserName = driver.findElement(elementsLogin.getInputUserName());
        inputUserName.sendKeys(username);

    }

    @When("user inputs registered account password (.*)$")
    public void user_inputs_registered_account_password(String password) {
        WebElement inputPassword = driver.findElement(elementsLogin.getInputPassword());
        inputPassword.sendKeys(password);

    }

    @And("user clicks login button")
    public void user_clicks_login_button() {
        WebElement buttonLogin  = driver.findElement(elementsLogin.getButtonLogin());
        buttonLogin.click();
    }

    @Then("user is redirected to product page")
    public void user_is_redirected_to_product_page() {
        String assertionProductPage = driver.getCurrentUrl();
        WebElement buttonCart = driver.findElement(elementsProductPage.getButtonCart());
        int duration = 3;
        WebDriverWait wait = new WebDriverWait(driver,duration);
        WebElement buttonMenu = wait.until(ExpectedConditions.presenceOfElementLocated(elementsProductPage.getButtonMenu()));
        WebElement buttonSort = driver.findElement(elementsProductPage.getButtonSort());
        assertTrue(buttonCart.isDisplayed());
        assertTrue((buttonMenu.isDisplayed()));
        assertTrue(buttonSort.isDisplayed());

        if(assertionProductPage.contains("inventory")) {
            System.out.println("Passed: User successfully logged in using standard account");
        } else {
            System.out.println("Failed: user is not redirected to product page");
        }
    }

    @When ("user inputs unregistered account username")
    public void user_inputs_unregistered_account_username() {
        WebElement inputUserName = driver.findElement(elementsLogin.getInputUserName());
        inputUserName.sendKeys("RandomName");

    }

    @And ("user inputs unregistered account password")
    public void user_inputs_unregistered_account_password() {
        WebElement inputPassword = driver.findElement(elementsLogin.getInputPassword());
        inputPassword.sendKeys("RandomPassword");
    }

    @Then ("user is notified error message")
    public void user_is_notified_error_message() {
        int duration = 3;
        WebDriverWait wait = new WebDriverWait(driver,duration);
        WebElement textErrorLogin = wait.until(ExpectedConditions.presenceOfElementLocated(elementsLogin.getTextErrorLogin()));
        String errorMessage = textErrorLogin.getText();

        assertTrue(errorMessage.contains("Epic sadface:"));
    }

    @When("user inputs locked account username")
    public void user_inputs_locked_account_username() {

        WebElement inputUserName = driver.findElement(elementsLogin.getInputUserName());
        inputUserName.sendKeys("locked_out_user");
    }

    @When("user inputs locked account password")
    public void user_inputs_locked_account_password() {
        WebElement inputPassword = driver.findElement(elementsLogin.getInputPassword());
        inputPassword.sendKeys("secret_sauce");
    }

}
