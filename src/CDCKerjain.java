
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CDCKerjain {
    public static String browser = "chrome";
    public static WebDriver driver;
    public static String url = "";

    @BeforeClass
    public void setup() {
        if(browser.equals("Firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else if(browser.equals("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }

        else if(browser.equals("edge"))
        {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        url = "https://kerjain-team1.herokuapp.com/";
        driver.get(url);

        driver.manage().window().maximize();
    }
    @Test(priority = 1)
    public void filterWorker() {
        WebDriverWait wait = new WebDriverWait(driver,5);

        //findJob
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]")).click();

        // click filter
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[3]/div/div[2]/div/div[1]/div[2]/div/div/button")).click();

        // Select filter
        driver.findElement(By.xpath("//div[contains(text(), 'Cheapest')]")).click();



    }
}