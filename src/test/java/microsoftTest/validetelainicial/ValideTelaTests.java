

package microsoftTest.validetelainicial;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import microsoftTest.factories.PageFactory;
import microsoftTest.pages.HomePage;
import microsoftTest.pages.VisualStudioSubscriptionPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ValideTelaTests {

    private WebDriver driver;
    private HomePage homePage;
    private VisualStudioSubscriptionPage vsSubscriptionPage;
    private PageFactory pageFactory;

    @Given("que acesso a página principal da Microsoft")
    public void accessMicrosoftHomePage() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Chrome Drive\\chromedriver_win32\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Criar a instância da PageFactory e passar o WebDriver para ela
        pageFactory = new PageFactory(driver);

        // Utilizar a PageFactory para criar a instância da HomePage
        homePage = pageFactory.createHomePage();
        homePage.accessHomePage();
    }

    @Then("todos os seguintes itens do menu estão presentes:")
    public void validateMenuItems(List<String> menuItems) {
        // Utilize a instância homePage para realizar as ações na página inicial
        homePage.validateMenuItems(menuItems);
    }


    @When("clico no botão Windows no menu")
    public void clickWindowsButton() {
        WebElement botaoWindows = driver.findElement(By.id("uhfCatLogoButton"));
        botaoWindows.click();
    }

    @Then("verifico que o menu Sobre o Windows está presente")
    public void verifySobreWindowsMenuPresent() {
        WebElement menuSobreWindows = driver.findElement(By.linkText("Sobre o Windows"));
        assert(menuSobreWindows.isDisplayed());
    }

    @And("imprimo todos os elementos no menu suspenso do Sobre o Windows")
    public void printElementsSobreWindowsMenu() {
        WebElement menuSobreWindows = driver.findElement(By.linkText("Sobre o Windows"));
        menuSobreWindows.click();

        // Imprime todos os elementos no menu suspenso do Sobre o Windows
        List<WebElement> dropdownElements = driver.findElements(By.xpath("//div[@aria-labelledby='smSiteHeaderVersionDropdownLabel']//a[@role='menuitem']"));
        for (WebElement element : dropdownElements) {
            System.out.println(element.getText());
        }
    }

    @When("clico no link Pesquisar ao lado do link Entrar")
    public void clickSearchLink() {
        WebElement searchLink = driver.findElement(By.id("search"));
        searchLink.click();
    }

    @And("pesquiso por {string}")
    public void searchForItem(String item) {
        WebElement searchInput = driver.findElement(By.id("cli_shellHeaderSearchInput"));
        searchInput.sendKeys(item);
        searchInput.submit();
    }

    @Then("verifico o preço do elemento selecionado e armazeno o preço")
    public void verifyAndStorePrice() {
        WebElement selectedElement = driver.findElement(By.xpath("//span[@data-m='101531']"));
        String price = selectedElement.getText();
        System.out.println("O preço do elemento selecionado é: " + price);
    }

    @When("clico em \"Get a Visual Studio Enterprise Subscription\"")
    public void clickGetEnterpriseSubscription() {
        WebElement getEnterpriseSubscriptionButton = driver.findElement(By.linkText("Get a Visual Studio Enterprise Subscription"));
        getEnterpriseSubscriptionButton.click();
    }

    @Then("valido que os preços individuais não são iguais")
    public void verifyIndividualPricesNotEqual() {
        WebElement individualPrice1 = driver.findElement(By.xpath("//span[contains(text(), 'Preço individual')]/following-sibling::span"));
        WebElement individualPrice2 = driver.findElement(By.xpath("//span[contains(text(), 'Preço individual')]/following-sibling::span[2]"));
        String price1 = individualPrice1.getText();
        String price2 = individualPrice2.getText();
        assert(!price1.equals(price2));
    }

    @And("clico em \"Adicionar ao carrinho\"")
    public void clickAddToCart() {
        WebElement addToCartButton = driver.findElement(By.id("buttonPanel_AddToCartButton"));
        addToCartButton.click();
    }

    @And("verifico se os 3 valores de preço (Individual, Itens, Total) são os mesmos")
    public void verifyPricesAreEqual() {
        WebElement individualPrice = driver.findElement(By.xpath("//span[contains(text(), 'Preço individual')]/following-sibling::span"));
        WebElement itemsPrice = driver.findElement(By.xpath("//span[contains(text(), 'Itens')]/following-sibling::span"));
        WebElement totalPrice = driver.findElement(By.xpath("//span[contains(text(), 'Total')]/following-sibling::span"));

        String individualPriceText = individualPrice.getText();
        String itemsPriceText = itemsPrice.getText();
        String totalPriceText = totalPrice.getText();

        assert(individualPriceText.equals(itemsPriceText) && itemsPriceText.equals(totalPriceText));
    }

    @Given("que acesso a página de detalhes da Visual Studio Enterprise Subscription")
    public void accessVisualStudioSubscriptionPage() {
        // Navega para a página de detalhes da assinatura do Visual Studio Enterprise
        driver.get("https://www.microsoft.com/en-us/store/b/visualstudiocompare");
    }

    @When("seleciono {int} itens no menu suspenso # de itens")
    public void selectItemCount(int count) {
        WebElement itemCountDropdown = driver.findElement(By.xpath("//select[@aria-label='# de itens']"));
        itemCountDropdown.sendKeys(String.valueOf(count));
    }

    @Then("verifico se o valor total é Preço unitário * {int}")
    public void verifyTotalPrice(int count) {
        WebElement individualPrice = driver.findElement(By.xpath("//span[contains(text(), 'Preço individual')]/following-sibling::span"));
        String individualPriceText = individualPrice.getText();
        double individualPriceValue = Double.parseDouble(individualPriceText.replace("$", ""));

        WebElement totalPrice = driver.findElement(By.xpath("//span[contains(text(), 'Total')]/following-sibling::span"));
        String totalPriceText = totalPrice.getText();
        double totalPriceValue = Double.parseDouble(totalPriceText.replace("$", ""));

        double expectedTotalPrice = individualPriceValue * count;
        assert(totalPriceValue == expectedTotalPrice);

        driver.quit();
    }
}

