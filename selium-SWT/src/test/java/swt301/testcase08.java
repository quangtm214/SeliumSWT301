package swt301;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import driver.driverFactory;

public class testcase08 {
    @Test
    public void testChangeReorderProduct() {
        // 1. Initialize the WebDriver
        WebDriver driver = driverFactory.getChromeDriver();

        try {
            // 2. Navigate to the website
            driver.get("http://live.techpanda.org/");

            // 3. Click on the "Account" link
            WebElement accountLink = driver
                    .findElement(By.xpath("//span[@class='label'][normalize-space()='Account']"));
            accountLink.click();

            // 4. Click on the "Log In" link
            WebElement loginLink = driver.findElement(By.xpath("//a[@title='Log In']"));
            loginLink.click();

            // 5. Fill in the email address field
            WebElement emailInput = driver.findElement(By.xpath("//input[@id='email']"));
            emailInput.sendKeys("phucthien0410@gmail.com");

            // 6. Fill in the password field
            WebElement passwordInput = driver.findElement(By.xpath("//input[@id='pass']"));
            passwordInput.sendKeys("maylaconcho123");

            // 7. Submit the login form
            WebElement loginButton = driver.findElement(By.xpath("//button[@id='send2']"));
            loginButton.click();

            // Wait for the login to complete (replace with appropriate wait)
            Thread.sleep(5000);

            // 5. Click on 'REORDER' link
            WebElement reorderLink = driver.findElement(By.xpath("//a[@class='link-reorder']"));
            reorderLink.click();

            // 6. Change the quantity (QTY = 10)
            WebElement qtyInput = driver.findElement(By.xpath("//input[@title='Qty']"));
            qtyInput.clear();
            qtyInput.sendKeys("10");

            // Click the "Update" button
            WebElement updateButton = driver
                    .findElement(By.xpath("//button[@title='Update']//span//span[contains(text(),'Update')]"));
            updateButton.click();

            // Wait for the update to complete (replace with appropriate wait)
            Thread.sleep(5000);

            // 7. Verify Grand Total is changed
            WebElement grandTotal = driver.findElement(By.xpath("//strong[normalize-space()='Grand Total']"));
            String actualGrandTotal = grandTotal.getText();
            // String expectedGrandTotal = "$XXX.XX"; // Replace with the expected grand
            // total

            // Use TestNG assertion to verify
            // Assert.assertEquals(expectedGrandTotal, actualGrandTotal);

            // 8. Complete Billing & Shipping Information (add your code here)

            // 9. Verify order is generated and note the order number (add your code here)

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 10. Quit the browser session
            driver.quit();
        }
    }
}
