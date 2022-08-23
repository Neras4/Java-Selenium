import java.time.Duration;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class MainClassTest {

    private WebDriver driver;
    private MainPage mainPage;
   
    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "D:\\Programming\\ProjectJava\\demo\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://github.com");
        mainPage = new MainPage(driver);
    }

    @Test
    public void signIn() {
        LoginPage loginPage = mainPage.clickSignIn();
        String heading = loginPage.getHeadigText();
        Assert.assertEquals("Sign in to GitHub", heading);
    }

    @Test
    public void checkSingUpWithEmail() {
        SignUpPage signUpPage = mainPage.registerWithEmail("ilya@gmail.com");
        String text = signUpPage.checkText();
        Assert.assertEquals("Welcome to GitHub!", text);
    }


    @Test
    public void checkSingUp() {
        SignUpPage clickSignUp = mainPage.clickSignUp();
        String text = clickSignUp.checkText();
        Assert.assertEquals("Welcome to GitHub!", text);
    }


    @After
    public void tearDown() {
        driver.quit();
    }

    }
    

