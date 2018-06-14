package selenium_learning;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ExplictwaitExample {

	@Test
	public void start() {
		try {
			System.setProperty(
					"webdriver.chrome.driver",
					"D:/SeleniumPractice/selenium_learning/driver/chromedriver.exe");
			WebDriver driver = new FirefoxDriver();
			driver.get("https://www.gmail.com");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement we = driver.findElement(By.id("identifierId"));
			we.sendKeys("n.swathi509");
			driver.findElement(By.id("identifierNext")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement webElement = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By
							.xpath("//input[@name='password']")));
			webElement.sendKeys("--");
			driver.findElement(By.id("passwordNext")).click();
		} catch (Exception ex) {
			System.out.println("exception occured");
		}

	}
}
