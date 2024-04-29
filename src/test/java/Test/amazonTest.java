package Test;
import pages.*;
import com.epam.healenium.SelfHealingDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class amazonTest {
    public static SelfHealingDriver driver;
    public static ChromeOptions options;
    public static WebDriverWait wait;

    @BeforeTest
    public void setup(){
//        options = new ChromeOptions();
        WebDriver delegate = new ChromeDriver();
        driver = SelfHealingDriver.create(delegate);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");
    }
    @AfterTest
    public void teardown(){
        driver.quit();
    }

    @Test(priority = 1)
    public void SearchAndClickFirstItem(){
        searchTab.textBox(driver).sendKeys("Gopro", Keys.ENTER);
        searchTab.SearchButton(driver).click();
        Assert.assertTrue(driver.getTitle().contains("Amazon.in : Gopro"));

        //Click on the First Product
        searchTab.ClickFirstProduct(driver).click();

        Set<String> handle = driver.getWindowHandles();
        Iterator<String> it = handle.iterator();
        String parentwindowid = it.next();
        System.out.println("your parent window is : " + parentwindowid);

        String childwindowid = it.next();
        System.out.println("your child window is : " + childwindowid);

        driver.switchTo().window(childwindowid);
        String title1 = driver.getTitle();
        System.out.println(title1);
    }

    @Test(priority = 2)
    public void AddToCart(){
        System.out.println("Title is" + driver.getTitle());
        String ActualTitle = "GoPro HERO12 Waterproof Action Camera with Front & Rear LCD Screens, 5.3K60 Ultra HD Video, HyperSmooth 6.0 + AutoBoost, Live Streaming with Enduro Battery (1-Yr International + 1-Yr India Warranty) : Amazon.in: Electronics";
        String ExpTitle = driver.getTitle();
        Assert.assertEquals(ExpTitle,ActualTitle);
        addToCart.SelectExtendedWarranty(driver).click();
        addToCart.ClickAddtoCart(driver).click();
    }

    @Test(priority = 3)
    public void ClickProceedToBuy(){
        proceedToBuy.ClickProceedToCheckout(driver).click();
        String ActualTitle = "Amazon Sign In";
        String ExpTitle = driver.getTitle();
        Assert.assertEquals(ExpTitle , ActualTitle);
    }

}
