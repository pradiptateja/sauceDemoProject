package stepDefinitions;

import config.setup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;
import objectRepository.*;

public class cart extends setup {

    productPage elementProductPage = new productPage();
    cartPage elementCartPage = new cartPage();
    int badgeCount;


    @When("user clicks Add-to-card button")
    public void user_clicks_add_to_card_button() {

        boolean isPresent = driver.findElements(elementProductPage.getSymbolBadgeCart()).size() > 0;

        if (isPresent) {
            badgeCount = Integer.parseInt(driver.findElement(elementProductPage.getSymbolBadgeCart()).getText());
        } else {
            badgeCount = 0;}

        WebElement buttonAddCart = driver.findElement(elementProductPage.getButtonAddToCart());
        buttonAddCart.click();
        badgeCount++;


        WebElement textProductName = driver.findElement(elementProductPage.getListProductName()) ;
        productName = textProductName.getText();

        WebElement textProductPrice = driver.findElement(elementProductPage.getListProductPrice());
        productPrice = textProductPrice.getText();

    }

    @Then("user founds increment at cart badge")
    public void user_founds_increment_at_cart_badge() {
        WebElement badgeCart = driver.findElement(elementProductPage.getSymbolBadgeCart());
        int badgeAfter = Integer.parseInt(badgeCart.getText());

        assertEquals(badgeAfter,badgeCount);
    }

    @When("user clicks remove button")
    public void user_clicks_remove_button() {
        boolean isPresent = driver.findElements(elementProductPage.getButtonRemoveProductFromCart()).size() > 0;
        if (isPresent) {
            driver.findElement(elementProductPage.getButtonRemoveProductFromCart()).click();
            badgeCount--;
        } else {
            driver.findElement(elementProductPage.getButtonAddToCart()).click();
            badgeCount++;
            driver.findElement(elementProductPage.getButtonRemoveProductFromCart()).click();
            badgeCount--;
        }

    }
    @Then("user founds decrement at card badge")
    public void user_founds_decrement_at_card_badge() {
        int badgeAfter;
        boolean isPresent = driver.findElements(elementProductPage.getSymbolBadgeCart()).size() > 0;
        if (isPresent) {
            badgeAfter = Integer.parseInt(driver.findElement(elementProductPage.getSymbolBadgeCart()).getText());
        } else {
            badgeAfter = 0;}

        assertEquals(badgeAfter,badgeCount);
    }

    @When("user clicks cart button")
    public void user_clicks_cart_button() {
        WebElement buttonCart = driver.findElement(elementProductPage.getButtonCart());
        buttonCart.click();
    }

    @Then("user will be directed to cart page")
    public void user_will_be_directed_to_cart_page() {
        String currentURL = driver.getCurrentUrl();
        assertTrue(currentURL.contains("cart"));
        WebElement productList = driver.findElement(elementCartPage.getListProductOnCart());
        assertTrue(productList.isDisplayed());
    }

    @Then("user will see the added product on the cart page")
    public void user_will_see_the_added_product_on_the_cart_page() {
        WebElement productNameOnList = driver.findElement(elementCartPage.getTextProductNameOnList());
        String productNameOnCart = productNameOnList.getText();

        System.out.println(productName);
        System.out.println(productNameOnCart);

        assertEquals(productName, productNameOnCart);

    }

}
