package swt301;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import POM.LoginForm;
import POM.MobilePage;
import POM.checkoutPage;
import driver.driverFactory;

public class testcase09 {
    @Test
    public void testVerifyDiscount() {
        WebDriver driver = driverFactory.getChromeDriver();

        // Step 1: Go to http://live.techpanda.org/
        driver.get("http://live.techpanda.org/");
        MobilePage mobilepage = new MobilePage(driver);
        checkoutPage chechout = new checkoutPage(driver);
        // Add sleep
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // a[normalize-space()='Mobile']
        // 2. Go to Mobile and add IPHONE to cart
        WebElement mobile = mobilepage.getMobileLink();
        mobile.click();

        // Add sleep
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement addToCartIphone = mobilepage.getAddToCartButton();
        addToCartIphone.click();

        // Add sleep
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 3. Enter Coupon Code
        WebElement coupon_codeText = chechout.getCouponCodeTextField();
        coupon_codeText.sendKeys("GURU50");
        ;

        // Add sleep
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement applyHref = chechout.getApplyButton();
        applyHref.click();

        // Add sleep
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 4. Verify the discount generated
        WebElement SUBTOTAL = chechout.getSubtotalElement();

        WebElement DISCOUNT = chechout.getDiscountElement();

        WebElement GRANDTOTAL = chechout.getGrandTotalElement();

        String subtotalValue = SUBTOTAL.getText();
        subtotalValue = subtotalValue.replace("$", "");
        String discountValue = DISCOUNT.getText();
        discountValue = discountValue.replace("$", "");
        discountValue = discountValue.replace("-", "");
        String grandTotalValue = GRANDTOTAL.getText();
        grandTotalValue = grandTotalValue.replace("$", "");
        double subtotal = Double.parseDouble(subtotalValue);
        double discount = Double.parseDouble(discountValue);
        double grandTotal = Double.parseDouble(grandTotalValue);
        double expectedDiscountedPrice = subtotal - (subtotal * 0.05);

        Assert.assertTrue(expectedDiscountedPrice == grandTotal);

        // Close the browser
        driver.quit();
    }

}
