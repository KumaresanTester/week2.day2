package week2.day2;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class EditPageLeafGround {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/Edit.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.id("email")).sendKeys("Kumaresh@gmail.com");
		WebElement eleAppend = driver.findElement(By.xpath("//input[@value='Append ']"));
		eleAppend.sendKeys("Kumar");
		eleAppend.sendKeys(Keys.TAB);
		System.out.println(driver.findElement(By.xpath("//input[@value='TestLeaf']")).getAttribute("value"));
		driver.findElement(By.xpath("//label[text()='Clear the text']/following-sibling::input")).clear();
		WebElement eleEnableorDisable = driver.findElement(
				By.xpath("//label[text()='Confirm that edit field is disabled']/following-sibling::input"));
		boolean enabledOrDisabled = eleEnableorDisable.isEnabled();

		if (enabledOrDisabled == false) {
			System.out.println("Edit Field is Disabled");
		} else {
			System.out.println("Edit field is Enabled");
		}
		driver.close();

	}

}
