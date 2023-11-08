package swt301;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.driverFactory;

public class testcase10 {
    @Test
    public void testExportAllOrdersToCSV() {
        // 1. Initialize the WebDriver
        WebDriver driver = driverFactory.getChromeDriver();

        try {
            // 2. Navigate to the backend login page
            driver.get("http://live.techpanda.org/index.php/backendlogin");

            // 3. Log in with provided credentials
            WebElement userIdInput = driver.findElement(By.xpath("//input[@id='username']"));
            userIdInput.sendKeys("user01");
            WebElement passwordInput = driver.findElement(By.xpath("//input[@id='login']"));
            passwordInput.sendKeys("guru99com");
            WebElement loginButton = driver.findElement(By.xpath("//input[@title='Login']"));

            // userIdInput.sendKeys("user01");
            // passwordInput.sendKeys("guru99com");
            loginButton.click();

            // Wait for login to complete
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            WebElement closeButton = driver.findElement(By.xpath("//span[normalize-space()='close']"));
            closeButton.click();

            // 4. Go to Sales -> Orders menu

            WebElement saleButton = driver.findElement(By.xpath("//span[normalize-space()='Sales']"));
            saleButton.click();
            WebElement orderButton = driver.findElement(By.xpath("//span[normalize-space()='Orders']"));
            orderButton.click();
            // 5.input

            WebElement fromDate = driver
                    .findElement(By.cssSelector(
                            "body > div:nth-child(1) > div:nth-child(5) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > table:nth-child(1) > thead:nth-child(2) > tr:nth-child(2) > th:nth-child(3) > div:nth-child(1) > div:nth-child(1) > input:nth-child(2)"));
            fromDate.sendKeys("11/06/2023"); // Input the date in the "MM/DD/YYYY" format

            WebElement toDate = driver
                    .findElement(By.cssSelector(
                            "body > div:nth-child(1) > div:nth-child(5) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > table:nth-child(1) > thead:nth-child(2) > tr:nth-child(2) > th:nth-child(3) > div:nth-child(1) > div:nth-child(2) > input:nth-child(2)"));
            toDate.sendKeys("11/07/2023"); // Input the date in the "MM/DD/YYYY" format

            WebElement orderID = driver.findElement(By.xpath("//input[@id='sales_order_grid_filter_real_order_id']"));
            orderID.sendKeys("100021110");

            WebElement searchButton = driver.findElement(By.xpath("//span[contains(text(),'Search')]"));
            searchButton.click();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("src/main/resources/screenshots/screenshot_tc10.png"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 7. Quit the browser session
            driver.quit();
        }
    }
}
