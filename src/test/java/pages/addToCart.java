package pages;

import com.epam.healenium.SelfHealingDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class addToCart {
    public static WebElement element = null;

    public static WebElement SelectExtendedWarranty(SelfHealingDriver driver){
        element = driver.findElement(By.cssSelector("#mbb-offeringID-1"));
        return element;
    }
    public static WebElement ClickAddtoCart(SelfHealingDriver driver){
        element = driver.findElement(By.cssSelector("#add-to-cart-button"));
        return element;
    }

}
