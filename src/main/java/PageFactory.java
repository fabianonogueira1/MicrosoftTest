import microsoftTest.pages.HomePage;
import microsoftTest.pages.VisualStudioSubscriptionPage;
import org.openqa.selenium.WebDriver;

public class PageFactory {
    private final WebDriver driver;

    public PageFactory(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage createHomePage() {
        return new HomePage(driver);
    }

    public VisualStudioSubscriptionPage createVisualStudioSubscriptionPage() {
        return new VisualStudioSubscriptionPage(driver);
    }

    private class InternalVisualStudioSubscriptionPage {
        public InternalVisualStudioSubscriptionPage(WebDriver driver) {
        }
    }
}

