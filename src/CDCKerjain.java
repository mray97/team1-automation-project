
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.IExpectedExceptionsHolder;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class CDCKerjain {
    public static String browser = "chrome";
    public static WebDriver driver;
    public static String url = "";

    @BeforeClass
    public void setup() {
        if (browser.equals("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        url = "https://kerjain-team1.herokuapp.com/";
        driver.get(url);

        driver.manage().window().maximize();


    }

    @Test(priority = 1)
    public void loginPage() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        sleep(2000);
        //click login button redirect to login page
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/button[1]")).click();
        sleep(2000);
        //input email
        driver.findElement(By.xpath("//*/input[@name='email']")).sendKeys("richiesambora4@mailinator.com");
        sleep(2000);
        //input password
        driver.findElement(By.xpath("//*/input[@name='password']")).sendKeys("1234#Qwe");
        sleep(2000);
        //click login button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        sleep(2000);
        WebElement loginPage = driver.findElement(By.xpath("//div[@id='root']/div[1]/div"));
        Assert.assertEquals(true, loginPage.isDisplayed());
        System.out.println("User Successfully Login");

    }

    @Test(priority = 2)
    public void workerListing() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        //click worker listing

        sleep(2000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]")).click();
        WebElement workerListing = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[3]"));
        Assert.assertTrue(workerListing.isDisplayed());
        System.out.println("Worker Listing Page Displayed");
    }

    @Test(priority = 3)
    public void relevanceFilter() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        //select worker relevance filter

        sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[3]/div/div[2]/div/div[1]/div[2]/div/div/button")).click();
        sleep(2000);
        driver.findElement(By.xpath("//div[contains(text(), 'Cheapest')]")).click();
        sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[3]/div/div[2]/div/div[1]/div[2]/div/div/button")).click();
        sleep(2000);
        driver.findElement(By.xpath("//div[contains(text(), 'Expensive')]")).click();
        WebElement relevanceFilter = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[3]/div/div[2]/div/div[1]/div[2]/div/div/button"));
        Assert.assertEquals(true, relevanceFilter.isDisplayed());
        System.out.println("Relevance Filter Drop Down can be selected");


    }

    @Test(priority = 4)
    public void workerSpecialty() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        //select worker specialty

        sleep(2000);
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[3]/div/div[1]/div/div[2]/div[2]/div/div/input")).click();
        sleep(2000);
        driver.findElement((By.xpath("//body/div[@id='root']/div[@class='flex flex-col min-h-screen pb-1 bg-main bg-opacity-10']/div[@class='px-2 py-5 text-center bg-transparent font-main']/div[@class='flex flex-col gap-8 sm:px-4 sm:flex-row']/div[1]"))).click();
        sleep(2000);
        driver.findElement(By.xpath("(//input[@placeholder='Choose a specialty...'])")).sendKeys("No Specialty");
        sleep(2000);
        driver.findElement(By.xpath("(//input[@placeholder='Choose a specialty...'])")).sendKeys(Keys.ARROW_DOWN);
        sleep(2000);
        driver.findElement(By.xpath("(//input[@placeholder='Choose a specialty...'])")).sendKeys(Keys.ENTER);
        WebElement workerSpecialty = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[3]/div/div[1]/div/div[2]/div[2]/div/div/input"));
        Assert.assertEquals(true, workerSpecialty.isDisplayed());
        System.out.println("Worker Specialty can be selected");
    }

    @Test(priority = 5)
    public void workerAge() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        //select worker age

        sleep(2000);
        driver.findElement((By.xpath("//*[@id=\"root\"]/div[1]/div[3]/div/div[1]/div/div[4]/div[3]/input[1]"))).click();
        driver.findElement((By.xpath("//*[@id=\"root\"]/div[1]/div[3]/div/div[1]/div/div[4]/div[3]/input[1]"))).sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, "20");
        driver.findElement((By.xpath("//*[@id=\"root\"]/div[1]/div[3]/div/div[1]/div/div[4]/div[3]/input[1]"))).sendKeys(Keys.ENTER);
        WebElement workerAge = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[3]/div/div[1]/div/div[4]/div[1]"));
        Assert.assertEquals(true, workerAge.isDisplayed());
        System.out.println("Worker Age can be selected");

    }

    @Test(priority = 6)
    public void workerSex() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        //select worker sex

        sleep(2000);
        driver.findElement((By.xpath("/html/body/div[2]/div[1]/div[3]/div/div[1]/div/div[5]/div[2]/div[2]/label/input"))).click();
        WebElement workerSex = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[3]/div/div[1]/div/div[5]/div[2]/div[2]/label/input"));
        Assert.assertEquals(true, workerSex.isDisplayed());
        System.out.println("Worker Sex can be selected");

    }

    @Test(priority = 7)
    public void workerPayrate() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        //select worker pay rate

        sleep(2000);
        driver.findElement((By.xpath("/html/body/div[2]/div[1]/div[3]/div/div[1]/div/div[6]/div[3]/input[1]"))).sendKeys(Keys.BACK_SPACE, "10000");
        WebElement workerPayrate = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[3]/div/div[1]/div/div[6]/div[3]/input[1]"));
        Assert.assertEquals(true, workerPayrate.isDisplayed());
        System.out.println("Worker Pay Rate can be selected");

    }

    @Test(priority = 8)
    public void workerDetail() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        //click worker detail on worker card

        sleep(2000);
        driver.findElement((By.xpath("//*[contains(@class, 'w-5 text-black transform cursor-pointer hover:scale-110')]"))).click();
        WebElement workerDetail = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[3]"));
        Assert.assertEquals(true, workerDetail.isDisplayed());
        System.out.println("Worker Details Displayed");

    }

    @Test(priority = 9)
    public void logOut() throws InterruptedException{
        WebDriverWait wait=new WebDriverWait(driver, 5);
        sleep(2000);
        //select user profile button
        driver.findElement(By.xpath("//div[@class='inline-flex gap-2']//*[name()='svg']")).click();
        //select LogOut button, redirect to landing page
        sleep(2000);
        driver.findElement(By.xpath("//div[contains(text(),'Logout')]")).click();
        WebElement logoutButton=driver.findElement(By.xpath("//div[@class='lg:p-10']"));
        Assert.assertEquals(true, logoutButton.isDisplayed());
        System.out.println("user log out successfully & redirect to landing page ");

    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }

}
