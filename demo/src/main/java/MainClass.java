import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class MainClass {
    static WebDriver driver;
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "D:\\Programming\\ProjectJava\\demo\\drivers\\geckodriver.exe");

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://github.com");

        //MainPage mainPage = new MainPage(driver);

        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.registerWithEmail("ilya@gmail.com");
    }
    
}
