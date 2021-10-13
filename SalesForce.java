package week2.day2;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForce {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.salesforce.com/in/form/signup/freetrial-sales/?d=70130000000Enyk");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.xpath("//input[@name='UserFirstName']")).sendKeys("Kumaresan");
		driver.findElement(By.xpath("//input[@name='UserLastName']")).sendKeys("L");
		driver.findElement(By.xpath("//input[contains(@id,'UserEmail')]")).sendKeys("Kumaresan@gmail.com");
		driver.findElement(By.xpath("//input[@name='CompanyName']")).sendKeys("TCS");
		driver.findElement(By.xpath("//input[@name='UserPhone']")).sendKeys("8939689729");
		WebElement eleJobTitle = driver.findElement(By.xpath("//select[@name='UserTitle']"));
		Select selectJobTitle = new Select(eleJobTitle);
		selectJobTitle.selectByValue("Developer");
		WebElement eleEmployees = driver.findElement(By.xpath("//select[@name='CompanyEmployees']"));
		Select selectEmployees = new Select(eleEmployees);
		selectEmployees.selectByIndex(3);
		WebElement eleCountry = driver.findElement(By.xpath("//select[@name='CompanyCountry']"));
		Select selectCountry = new Select(eleCountry);
		selectCountry.selectByValue("IN");
		driver.findElement(By.xpath("//input[@id='SubscriptionAgreement']/following-sibling::div[1]")).click();
		driver.close();
	}
}
