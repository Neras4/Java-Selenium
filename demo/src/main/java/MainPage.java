import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver = driver;

    }
    

    private By signInButton = By.xpath("//a[@href='/login']");
    private By signUpButton = By.xpath("//div[@class='d-lg-flex flex-items-center px-3 px-lg-0 text-center text-lg-left']/a");
    private By insertEmail = By.xpath("//input[@name='user_email']");
    private By buttonSignUp = By.xpath("//button[contains(text(), 'Sign up for GitHub')]");

    public LoginPage clickSignIn() {
        driver.findElement(signInButton).click();
        return new LoginPage(driver);
    }

    public SignUpPage clickSignUp() {
        driver.findElement(signUpButton).click();
        return new SignUpPage(driver);
    }

    public SignUpPage clickButtonSignUp() {
        driver.findElement(buttonSignUp).click();
        return new SignUpPage(driver);
    }

    public MainPage typeEmail(String email) {
        driver.findElement(insertEmail).sendKeys(email);
        return this;
    }

    public SignUpPage registerWithEmail (String email) {
        this.typeEmail(email);
        this.clickButtonSignUp();
        return new SignUpPage(driver);
    }




    
}
