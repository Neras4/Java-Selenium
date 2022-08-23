import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SignUpPage {
    
    WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    private By email = By.xpath("//input[@id='email']");
    private By password = By.xpath("//input[@id='password']");
    private By login = By.xpath("//input[@id='login']");
    private By continueEmail = By.xpath("//button[@data-continue-to='password-container']");
    private By continuePassword = By.xpath("//button[@data-continue-to='username-container']");
    private By continueUsername = By.xpath("//button[@data-continue-to='opt-in-container']");
    private By headingText = By.xpath("//span[contains(text(), 'Welcome to GitHub!')]");

    public String checkText() {
        return driver.findElement(headingText).getText();
    }
    


    public SignUpPage typeEmail (String emailMy) {
        driver.findElement(email).sendKeys(emailMy);
        driver.findElement(continueEmail).click();
        return this;
    } 

    public SignUpPage typePassword (String passwordMy) {
        driver.findElement(password).sendKeys(passwordMy);
        driver.findElement(continuePassword).click();
        return this;
    } 

    public SignUpPage typeUsername (String username) {
        driver.findElement(login).sendKeys(username);
        driver.findElement(continueUsername).click();
        return this;
    } 

    public boolean registerPage (String emailMy, String passwordMy, String username) {
        this.typeEmail(emailMy);
        this.typePassword(passwordMy);
        this.typeUsername(username);

        return driver.findElement(By.xpath("//label[contains(text(), 'Would you like to receive')]")).isDisplayed();
        
    }

}
