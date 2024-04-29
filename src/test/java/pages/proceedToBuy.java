package pages;

import com.epam.healenium.SelfHealingDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class proceedToBuy {
    public static WebElement element = null;

    public static WebElement ClickProceedToCheckout(SelfHealingDriver driver){
        element = driver.findElement(By.cssSelector("input[name='proceedToRetailCheckout']"));
        return element;
    }
}
