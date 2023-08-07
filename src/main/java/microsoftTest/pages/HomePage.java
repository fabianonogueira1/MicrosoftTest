package microsoftTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }


    public WebElement getWindowsButton() {
        return driver.findElement(By.id("uhfCatLogoButton"));
    }

    public WebElement getSobreWindowsMenu() {
        return driver.findElement(By.linkText("Sobre o Windows"));
    }


}
