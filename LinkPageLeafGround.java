package week2.day2;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LinkPageLeafGround {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/Link.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.linkText("Go to Home Page")).click();
		driver.findElement(By.xpath("//h5[text()='HyperLink']/following-sibling::img")).click();
		System.out.println("This link will go to "
				+ driver.findElement(By.xpath("//a[text()='Find where am supposed to go without clicking me?']"))
						.getAttribute("href"));
		driver.findElement(By.linkText("Verify am I broken?")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		String titlePage = driver.getTitle();
		if (titlePage.contains("Not Found")) {
			System.out.println("Clicked Link is Broken");
		} else {
			System.out.println("Clicked Link is Working");
		}
		driver.navigate().back();
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Number of Links present in this Webpage " + links.size());
		driver.close();

	}

}
