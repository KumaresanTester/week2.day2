package week2.day2;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//div[@class='_6ltg']/a")).click();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Kumaresan");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Loganatha");
		driver.findElement(By.xpath("//div[contains(text(),'Mobile number or')]/following-sibling::input")).sendKeys("8939689729");
		driver.findElement(By.id("password_step_input")).sendKeys("Kumar@123");
		WebElement eleDay = driver.findElement(By.id("day"));
		Select selectDay = new Select(eleDay);
		selectDay.selectByValue("29");

		WebElement eleMonth = driver.findElement(By.id("month"));
		Select selectMonth = new Select(eleMonth);
		selectMonth.selectByVisibleText("Jul");

		WebElement eleYear = driver.findElement(By.id("year"));
		eleYear.click();
		driver.findElement(By.xpath("//option[@value='1989']")).click();

		driver.findElement(By.xpath("//label[text()='Female']/following-sibling::input")).click();

	}

}
