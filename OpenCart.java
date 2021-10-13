package week2.day2;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenCart {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.opencart.com/index.php?route=account/register");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("input-username")).sendKeys("KumaresanL");
		driver.findElement(By.id("input-firstname")).sendKeys("Kumaresan");
		driver.findElement(By.id("input-lastname")).sendKeys("Loganathan");
		driver.findElement(By.id("input-email")).sendKeys("Kumaresh@gmail.com");
		WebElement eleCountry = driver.findElement(By.id("input-country"));
		Select country = new Select(eleCountry);
		country.selectByVisibleText("India");
		driver.findElement(By.id("input-password")).sendKeys("Kumar@123");
		driver.close();

	}

}
