package stepDefinitions;

import config.setup;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;

public class hooks extends setup {

    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        String webURL = "https://www.saucedemo.com/";
        driver.get(webURL);

    }

    @After
    public void after() {
        driver.quit();
    }
}
