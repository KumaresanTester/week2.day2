package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioPageLeafGround {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/radio.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.id("yes")).click();
		boolean eleUnChecked = driver.findElement(By.xpath("//label[@for='Unchecked']/input")).isSelected();

		if (eleUnChecked == true) {
			System.out.println("Unchecked Radio Button Selected in Default");
		}
		boolean eleChecked = driver.findElement(By.xpath("//label[@for='Checked']/input")).isSelected();

		if (eleChecked == true) {
			System.out.println("Checked Radio Button Selected in Default");
		}

		driver.findElement(By.xpath("//input[@value='2']/preceding-sibling::input[@value='1']")).click();
		driver.close();
	}

}
