package pages;

//import org.apache.logging.log4j.core.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;



public class HomePage {
    WebDriver driver;

    // Locators
    @FindBy(xpath = "//strong[text()='Congratulations student. You successfully logged in!']")
    private WebElement welcomeMessage;
//    private By welcomeMessage = By.xpath("//strong[text()='Congratulations student. You successfully logged in!']");

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
//    public LoginPage(WebDriver driver) {
//        this.driver = driver;
//        PageFactory.initElements(driver, this); // Initialize elements with PageFactory
//    }

    // Method to get the welcome message
    public void getWelcomeMessage() {
        String welcomMsg = welcomeMessage.getText();
        System.out.println("This is welcome message" + welcomMsg);
        System.out.println("get title is printing" + driver.getTitle());

        Assert.assertTrue(driver.getTitle().contains("Practice Test Automation"));

    }
}
