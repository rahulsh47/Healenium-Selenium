package pages;

import com.epam.healenium.SelfHealingDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class searchTab {
    public static WebElement element = null;

    public static WebElement textBox(SelfHealingDriver driver){
        element = driver.findElement(By.id("twotabsearchtextbox"));
        return element;
    }

    public static WebElement SearchButton(SelfHealingDriver driver){
        element = driver.findElement(By.cssSelector(".nav-input.nav-progressive-attribute:nth-child(1)"));
        return element;
    }

    public static WebElement ClickFirstProduct(SelfHealingDriver driver){
        element = driver.findElement(By.xpath("//div[contains(@class,'rush-component s-featured-result-item')]//span[@class='a-size-medium a-color-base a-text-normal'][contains(text(),'GoPro HERO12 Waterproof Action Camera with Front &')]"));
        return element;
    }

    public static WebElement GoToCart(SelfHealingDriver driver){
        element = driver.findElement(By.cssSelector(".nav-cart-icon.nav-sprite"));
        return element;
    }
}
