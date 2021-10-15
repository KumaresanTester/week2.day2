package week2.day2;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBoxPageLeafGround {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/checkbox.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.xpath("//div[text()='Java']/input")).click();
		driver.findElement(By.xpath("//div[text()='VB']/input")).click();
		boolean eleSeleniumCheckBox = driver.findElement(By.xpath("//div[text()='Selenium']/input")).isSelected();
		if (eleSeleniumCheckBox == true) {
			System.out.println("Selenium Checkbox Selected");
		} else {
			System.out.println("Selenium Checkbox Not Selected");
		}
		boolean eleCheckbox1 = driver.findElement(By.xpath("//div[text()='Not Selected']/input")).isSelected();
		if (eleCheckbox1 == true) {
			driver.findElement(By.xpath("//div[text()='Not Selected']/input")).click();
			System.out.println("Deselected the Not Selected Option");
		}
		boolean eleCheckbox2 = driver.findElement(By.xpath("//div[text()='I am Selected']/input")).isSelected();
		if (eleCheckbox2 == true) {
			driver.findElement(By.xpath("//div[text()='I am Selected']/input")).click();
			System.out.println("Deselected the I am Selected Option");
		}
		driver.findElement(By.xpath("//div[text()='Option 1']/input")).click();
		driver.findElement(By.xpath("//div[text()='Option 2']/input")).click();
		driver.findElement(By.xpath("//div[text()='Option 3']/input")).click();
		driver.findElement(By.xpath("//div[text()='Option 4']/input")).click();
		driver.findElement(By.xpath("//div[text()='Option 5']/input")).click();
		driver.close();
	}
}
