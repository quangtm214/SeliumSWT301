package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MobilePage {
    private WebDriver driver;

    public MobilePage(WebDriver driver) {
        this.driver = driver;

    }

    public WebElement getMobileLink() {
        return driver.findElement(By.xpath("//a[normalize-space()='Mobile']"));
    }

    public WebElement getAddToCartButton() {
        return driver.findElement(By.xpath("//li[3]//div[1]//div[3]//button[1]//span[1]//span[1]"));
    }

}
