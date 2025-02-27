package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class LoginPage{
	
    WebDriver driver;
    Logger logger = LogManager.getLogger(LoginPage.class);

    // Locators using @FindBy
    @FindBy(id = "username")
    WebElement usernameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "submit")
    WebElement loginButton;
    
    @FindBy(xpath = "//a[text()='Home']")
    WebElement homeButton;
    
    @FindBy(xpath = "(//input[@type='email'])[2]")
    WebElement emailIDField;

    // Constructor to initialize WebElements
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initialize elements with PageFactory
    }

    // Actions
    public void enterUsername(String username) {
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLogin() {
        loginButton.click();
    }
    public void clickOnHomeButton() {
    	logger.info("clicking on home button");
    	homeButton.click();
    }
    
    public void enterEmailID(String email) {
    	emailIDField.sendKeys(email);
    }  
}
