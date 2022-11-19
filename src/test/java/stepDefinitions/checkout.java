package stepDefinitions;

import com.github.javafaker.Faker;
import config.setup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objectRepository.*;
import org.openqa.selenium.WebElement;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;


public class checkout extends setup {

    Faker faker = new Faker();
    cartPage elementCartPage = new cartPage();
    personalInfoPage elementPersonalInfoPage = new personalInfoPage();
    checkoutSummaryPage elementCheckoutSummaryPage = new checkoutSummaryPage();
    completeOrderPage elementCompleteOrderPage = new completeOrderPage();


    @When("user clicks checkout button")
    public void user_clicks_checkout_button() {
        WebElement buttonCheckout = driver.findElement(elementCartPage.getButtonCheckout());
        buttonCheckout.click();
    }

    @When("user fills personal information")
    public void user_fills_personal_information() {
        String firstName = faker.name().firstName();
        WebElement inputFirstName = driver.findElement(elementPersonalInfoPage.getInputFirstName());
        inputFirstName.sendKeys(firstName);

        String lastName = faker.name().firstName();
        WebElement inputLastName = driver.findElement(elementPersonalInfoPage.getInputLastName());
        inputLastName.sendKeys(lastName);

        String postalCode = faker.address().zipCode();
        WebElement inputPostalCode = driver.findElement(elementPersonalInfoPage.getInputPostalCode());
        inputPostalCode.sendKeys(postalCode);

    }

    @When("user clicks continue on personal information page")
    public void user_clicks_continue_on_personal_information_page() {
        WebElement buttonContinue = driver.findElement(elementPersonalInfoPage.getButtonContinue());
        buttonContinue.click();
    }

    @Then("user will be directed to summary checkout page")
    public void user_will_be_directed_to_summary_checkout_page() {
        String currentURL = driver.getCurrentUrl();
        assertTrue(currentURL.contains("step-two"));

        WebElement textTitlePage = driver.findElement(elementCheckoutSummaryPage.getTextTitlePage());
        String titlePage = textTitlePage.getText();
        assertTrue(titlePage.contains("OVERVIEW"));
    }

    @Then("user can see the desired product name")
    public void user_can_see_the_desired_product_name() {

        WebElement textProductName = driver.findElement(elementCheckoutSummaryPage.getTextProductName());
        String currentProductName = textProductName.getText();
        assertEquals(productName,currentProductName);
    }

    @Then("user can see the similar product price")
    public void user_can_see_the_similar_product_price() {

        WebElement textProductPrice = driver.findElement(elementCheckoutSummaryPage.getTextProductPrice());
        String currentProductPrice = textProductPrice.getText();
        assertEquals(productPrice,currentProductPrice);

    }

    @Then("user will be notified error message to fill the form")
    public void user_will_be_notified_error_message_to_fill_the_form() {
        WebElement textErrorMessage = driver.findElement(elementPersonalInfoPage.getTextErrorMessage());

        String errorMessage = textErrorMessage.getText();
        assertTrue(errorMessage.contains("Error:"));

    }

    @Then("user will not be directed to summary checkout page")
    public void user_will_not_be_directed_to_summary_checkout_page() {
        String currentURL = driver.getCurrentUrl();
        assertTrue(currentURL.contains("step-one"));
    }

    @When("user clicks finish button")
    public void user_clicks_finish_button() {
        WebElement buttonFinish = driver.findElement(elementCheckoutSummaryPage.getButtonFinish());
        buttonFinish.click();
    }

    @Then("user will be notified order complete")
    public void user_will_be_notified_order_complete() {

    }
    @Then("user will see thank you message")
    public void user_will_see_thank_you_message() {

        WebElement textTitlePage = driver.findElement(elementCompleteOrderPage.getTextTitlePage());
        String titlePage = textTitlePage.getText();
        assertTrue(titlePage.contains("COMPLETE!"));

        WebElement textCompleteOrder = driver.findElement(elementCompleteOrderPage.getTextCompleteOrder());
        String completeOrder = textCompleteOrder.getText();
        assertTrue(completeOrder.contains("THANK YOU FOR YOUR ORDER"));

    }
}
