/*package microsoftTest.vaparawindows;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.*;

public class VaParaWindowsTests {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Chrome Drive\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
    }

    @Test
    public void testMicrosoftHomePage() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.microsoft.com/en-us/");

        // Localiza o botão pelo atributo "id" usando o localizador By.id
        WebElement botaoWindows = driver.findElement(By.id("uhfCatLogoButton"));
        botaoWindows.click();




        // Imprime todos os elementos no menu suspenso
        List<WebElement> dropdownElements = driver.findElements(By.xpath("//div[@aria-labelledby='smSiteHeaderVersionDropdownLabel']//a[@role='menuitem']"));
        for (WebElement element : dropdownElements) {
            System.out.println(element.getText());
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

 */

