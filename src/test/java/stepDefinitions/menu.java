package stepDefinitions;

import config.setup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objectRepository.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.AssertJUnit.assertTrue;

public class menu extends setup {

    productPage elementProductPage = new productPage();
    burgerMenu elementBurgerMenu = new burgerMenu();

    int duration = 3;
    WebDriverWait wait = new WebDriverWait(driver,duration);

    @When("user clicks burger menu button")
    public void user_clicks_burger_menu_button() {
        WebElement buttonMenu = driver.findElement(elementProductPage.getButtonMenu());
        buttonMenu.click();
    }

    @When("user clicks all-item option")
    public void user_clicks_all_item_option() {

        WebElement buttonAllItem = wait.until(ExpectedConditions.elementToBeClickable(elementBurgerMenu.getButtonAllItems()));
        buttonAllItem.click();
    }

    @When("user clicks about option")
    public void user_clicks_about_option() {
        WebElement buttonAbout = wait.until(ExpectedConditions.elementToBeClickable(elementBurgerMenu.getButtonAbout()));
        buttonAbout.click();
    }

    @When("user clicks Logout option")
    public void user_clicks_logout_option() {
        WebElement buttonLogout = wait.until((ExpectedConditions.elementToBeClickable(elementBurgerMenu.getButtonLogout())));
        buttonLogout.click();
    }

    @Then("user will be directed to SauceLab website")
    public void user_will_be_directed_to_sauce_lab_website() {
        String currentURL = driver.getCurrentUrl();
        assertTrue(currentURL.contains("https://saucelabs.com/"));

    }
}
