
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.input.Input;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.ISelect;
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

        // click filter1
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[3]/div/div[2]/div/div[1]/div[2]/div/div/button")).click();

        // Select filter cheapest
        driver.findElement(By.xpath("//div[contains(text(), 'Cheapest')]")).click();

        // click filter1
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[3]/div/div[2]/div/div[1]/div[2]/div/div/button")).click();

        // Select filter expensive
        driver.findElement(By.xpath("//div[contains(text(), 'Expensive')]")).click();

        // click filter worker specialty
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[3]/div/div[1]/div/div[2]/div[2]/div/div/input")).click();

        // select worker specialty field
        driver.findElement((By.xpath("//body/div[@id='root']/div[@class='flex flex-col min-h-screen pb-1 bg-main bg-opacity-10']/div[@class='px-2 py-5 text-center bg-transparent font-main']/div[@class='flex flex-col gap-8 sm:px-4 sm:flex-row']/div[1]"))).click();

        driver.findElement(By.xpath("(//input[@placeholder='Choose a specialty...'])")).sendKeys("Cleaning");
        driver.findElement(By.xpath("(//input[@placeholder='Choose a specialty...'])")).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.xpath("(//input[@placeholder='Choose a specialty...'])")).sendKeys(Keys.ENTER);

        // select worker age
        driver.findElement((By.xpath("//*[@id=\"root\"]/div[1]/div[3]/div/div[1]/div/div[4]/div[3]/input[1]"))).click();
        driver.findElement((By.xpath("//*[@id=\"root\"]/div[1]/div[3]/div/div[1]/div/div[4]/div[3]/input[1]"))).sendKeys("20");
        driver.findElement((By.xpath("//*[@id=\"root\"]/div[1]/div[3]/div/div[1]/div/div[4]/div[3]/input[1]"))).sendKeys(Keys.ENTER);

        // select worker sex
        driver.findElement((By.xpath("/html/body/div[2]/div[1]/div[3]/div/div[1]/div/div[5]/div[2]/div[2]/label/input"))).click();

        // worker pay rate
        driver.findElement((By.xpath("/html/body/div[2]/div[1]/div[3]/div/div[1]/div/div[6]/div[3]/input[1]"))).sendKeys("5");

        // click worker detail on worker card
        driver.findElement((By.xpath("//*[contains(@class, 'w-5 text-black transform cursor-pointer hover:scale-110')]"))).click();












    }
}