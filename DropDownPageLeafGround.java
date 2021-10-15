package week2.day2;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownPageLeafGround {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/Dropdown.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebElement eleDropDown1 = driver.findElement(By.id("dropdown1"));
		Select dropDown1 = new Select(eleDropDown1);
		dropDown1.selectByIndex(1);

		WebElement eleDropDown2 = driver.findElement(By.name("dropdown2"));
		Select dropDown2 = new Select(eleDropDown2);
		dropDown2.selectByVisibleText("Selenium");

		WebElement eleDropDown3 = driver.findElement(By.id("dropdown3"));
		Select dropDown3 = new Select(eleDropDown3);
		dropDown3.selectByValue("1");

		WebElement eleGetOption = driver.findElement(By.className("dropdown"));
		Select getOption = new Select(eleGetOption);
		List<WebElement> options = getOption.getOptions();
		System.out.println("Number of Dropdown Option are " + options.size());

		driver.findElement(By.xpath("//option[text()='You can also use sendKeys to select']/parent::select"))
				.sendKeys("Selenium");
		driver.findElement(By.xpath("//option[text()='Select your programs']/following-sibling::option[1]")).click();

	}

}
