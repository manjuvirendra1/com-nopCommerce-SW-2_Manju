package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {

    //This is the Browser setup code class

    public static WebDriver driver;

        //Creating self method
    public void openBrowser(String baseUrl) {
        driver = new ChromeDriver();
        //launch the URL
        driver.get(baseUrl);
        //Maximise window
        driver.manage().window().maximize();
        //Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

      public void closeBrowser() {
        //closing all the instances
        driver.quit();
    }
}
