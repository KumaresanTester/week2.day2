package week2.day2;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ButtonPageLeafGround {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/Button.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		System.out.println(driver.findElement(By.id("home")).getAttribute("onclick"));
		driver.findElement(By.id("home")).click();		
		driver.findElement(By.xpath("//h5[text()='Button']/following-sibling::img")).click();
		System.out.println(driver.findElement(By.id("position")).getLocation());
		System.out.println(driver.findElement(By.id("color")).getCssValue("background-color"));
		driver.findElement(By.id("size")).getSize();
		driver.close();

	}

}
