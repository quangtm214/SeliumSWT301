package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class checkoutPage {
    private WebDriver driver;

    public checkoutPage(WebDriver driver) {
        this.driver = driver;

    }

    public WebElement getCouponCodeTextField() {
        return driver.findElement(By.id("coupon_code"));
    }

    public WebElement getApplyButton() {
        return driver.findElement(By.xpath("//span[contains(text(),'Apply')]"));
    }

    public WebElement getSubtotalElement() {
        return driver.findElement(By.xpath("//*[@id=\"shopping-cart-totals-table\"]/tbody/tr[1]/td[2]/span"));
    }

    public WebElement getDiscountElement() {
        return driver.findElement(By.xpath("//*[@id=\"shopping-cart-totals-table\"]/tbody/tr[2]/td[2]/span"));
    }

    public WebElement getGrandTotalElement() {
        return driver.findElement(By.xpath("//*[@id=\"shopping-cart-totals-table\"]/tfoot/tr/td[2]/strong/span"));
    }
}
