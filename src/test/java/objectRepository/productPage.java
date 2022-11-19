package objectRepository;

import org.openqa.selenium.By;

public class productPage {

    By buttonCart = By.xpath("//a[@class=\"shopping_cart_link\"]");
    public By getButtonCart() {
        return buttonCart;
    }

    By buttonMenu = By.id("react-burger-menu-btn");
    public By getButtonMenu() {
        return buttonMenu;
    }

    By buttonSort = By.xpath("//select[@data-test=\"product_sort_container\"]");
    public By getButtonSort() {
        return buttonSort;
    }

    By listProductPrice = By.xpath("//div[@class='inventory_item_price']");
    public By getListProductPrice() {
        return listProductPrice;
    }

    By listProductName = By.xpath("//div[@class=\"inventory_list\"]/div/div[@class=\"inventory_item_description\"]/div[@class=\"inventory_item_label\"]/a/div[@class=\"inventory_item_name\"]");
    public By getListProductName() {
        return listProductName;
    }

    By sortByPriceLoHi = By.xpath("//option[@value=\"lohi\"]");
    public By getSortByPriceLoHi() {
        return sortByPriceLoHi;
    }

    By sortByNameZA = By.xpath("//option[@value=\"za\"]");
    public By getSortByNameZA() {
        return sortByNameZA;
    }

    By buttonAddToCart = By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']");
    public By getButtonAddToCart() {
        return buttonAddToCart;
    }

    By buttonRemoveProductFromCart = By.xpath("//button[@class='btn btn_secondary btn_small btn_inventory']");
    public By getButtonRemoveProductFromCart() {
        return buttonRemoveProductFromCart;
    }

    By symbolBadgeCart = By.xpath("//span[@class='shopping_cart_badge']");
    public By getSymbolBadgeCart() {
        return symbolBadgeCart;
    }
}
