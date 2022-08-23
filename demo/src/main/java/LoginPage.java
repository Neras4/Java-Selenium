import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    
    WebDriver driver;

    public LoginPage(WebDriver driver){

        this.driver = driver;
    }

    private By loginField = By.xpath("//input[@name='login']");
    private By passwordField = By.xpath("//input[@name='password']");
    private By submit = By.xpath("//input[@name='commit']");
    private By heading = By.xpath("//div[contains(@class, 'auth-form-header p-0')]");  
    private By error = By.xpath("//div[@class='flash flash-full flash-error  ']/div");
    private By createAcc = By.xpath("//a[text()='Create an account']");
    
    
    public LoginPage typeUsername (String username) {
        driver.findElement(loginField).sendKeys(username);
        return this;
    }

    public LoginPage typePassword (String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public LoginPage loginWithCreds (String username, String password) {
        this.typeUsername(username);
        this.typePassword(password);
        driver.findElement(submit).click();
        return new LoginPage(driver);
    }

    public String getHeadigText() {
        return driver.findElement(heading).getText();
    }

    public String getErrorText() {
        return driver.findElement(error).getText();
    }

    public SignUpPage createAcc() {
        driver.findElement(createAcc).click();
        return new SignUpPage(driver);
    }
}
