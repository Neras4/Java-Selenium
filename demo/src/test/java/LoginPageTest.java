import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.junit.Assert;

public class LoginPageTest {
    
    private WebDriver driver;
    private LoginPage loginPage;
   
    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "D:\\Programming\\ProjectJava\\demo\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://github.com/login");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginWithEmptyCreds() {
        LoginPage newLogin = loginPage.loginWithCreds("", "");
        String error = newLogin.getErrorText();
        Assert.assertEquals("Incorrect username or password.", error);
    }

    @Test
    public void loginWithIncorrectCreds() {
        LoginPage newLogin = loginPage.loginWithCreds("qa", "qa");
        String error = newLogin.getErrorText();
        Assert.assertEquals("Incorrect username or password.", error);
    }
    @Test
    public void checkCreateAccLink() {
        SignUpPage checkAcc = loginPage.createAcc();
        String text = checkAcc.checkText();
        Assert.assertEquals("Welcome to GitHub!", text);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
