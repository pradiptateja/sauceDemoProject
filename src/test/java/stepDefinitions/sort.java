package stepDefinitions;

import config.setup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import objectRepository.productPage;


import java.util.List;

import static org.testng.AssertJUnit.*;


public class sort extends setup {

    productPage elementProductPage = new productPage();
    String[] listPriceInitial;
    String[] listNameInitial;
    int nameProductSizeBef;
    int priceProductSizeBef;


    @When("user see current product view")
    public void user_see_current_product_view() {
        List<WebElement> textPriceBefore = driver.findElements(elementProductPage.getListProductPrice());
        priceProductSizeBef = textPriceBefore.size();
        listPriceInitial = new String[priceProductSizeBef];
        int i = 1;

        for (WebElement listPriceBefore : textPriceBefore) {
            String priceBefore = listPriceBefore.getText();
            listPriceInitial[i-1] = priceBefore;
            i++;
        }

        List<WebElement> textProductBefore = driver.findElements(elementProductPage.getListProductName()) ;
        nameProductSizeBef = textProductBefore.size();
        listNameInitial = new String[nameProductSizeBef];
        int k = 1;

        for (WebElement listNameBefore : textProductBefore) {
            String nameBefore = listNameBefore.getText();
            listNameInitial[k-1]= nameBefore;
            k++;
        }

    }

    @And("user clicks sort button")
    public void user_clicks_sort_button() {

        WebElement buttonSort = driver.findElement(elementProductPage.getButtonSort());
        buttonSort.click();

    }

    @And("user chooses sort product by price low to high")
    public void user_chooses_sort_product_by_price_low_to_high() throws InterruptedException {
        WebElement optionSortLohi = driver.findElement(elementProductPage.getSortByPriceLoHi());
        optionSortLohi.click();
        Thread.sleep(3000);
    }

    @Then("user successfully rearranges the product list by price")
    public void user_successfully_rearranges_the_product_list_by_price() {

        List<WebElement> textPriceAfter = driver.findElements(elementProductPage.getListProductPrice());
        int priceProductSizeAf = textPriceAfter.size();
        String[] listPriceAfter = new String[priceProductSizeAf];
        int i = 1;

        for (WebElement listPrice : textPriceAfter) {
            String priceBefore = listPrice.getText();
            listPriceAfter[i-1] = priceBefore;
            i++;
        }

        System.out.println("Initial price is:");
        for (String testInitial : listPriceInitial) {
            System.out.println(testInitial);
        }

        System.out.println("After price is:");
        for (String testAfter : listPriceAfter) {
            System.out.println(testAfter);
        }

        assertEquals(priceProductSizeBef, priceProductSizeAf);
        for (int k = 0; k < priceProductSizeAf; k++)
            assertNotSame(listPriceInitial[k], listPriceAfter[k]);

    }

    @When("user chooses sort product by price Z to A")
    public void user_chooses_sort_product_by_price_z_to_a() throws InterruptedException {
        WebElement optionSortZtoA = driver.findElement(elementProductPage.getSortByNameZA());
        optionSortZtoA.click();
        Thread.sleep(3000);
    }

    @Then("user successfully rearranges the product list by name")
    public void user_successfully_rearranges_the_product_list_by_name() {
        List<WebElement> textProductAfter = driver.findElements(elementProductPage.getListProductName()) ;
        int nameProductSizeAf = textProductAfter.size();
        String[] listNameAfter = new String[nameProductSizeAf];
        int i = 1;

        for (WebElement listNameAf : textProductAfter) {
            String nameAfter = listNameAf.getText();
            listNameAfter[i-1]= nameAfter;
            i++;
        }

        System.out.println("Initial product arrangement is:");
        for (String test : listNameInitial) {
            System.out.println(test);
        }


        System.out.println("After product arrangement is:");
        for (String testAfter : listNameAfter) {
            System.out.println(testAfter);
        }

        assertEquals(nameProductSizeBef, nameProductSizeAf);
        for (int k = 0; k < nameProductSizeAf; k++)
            assertFalse(listNameInitial[k]==(listNameAfter[k]));
    }
}
