// classe abstrata que contém o objeto WebDriver, que é compartilhado por todas as classes de página.
package microsoftTest.pages;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    // Métodos comuns que podem ser utilizados em todas as classes de página
    // ...
}

