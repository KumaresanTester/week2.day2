package week2.day2;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.name("PASSWORD")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		WebElement eleFindLead = driver.findElement(By.xpath("//a[text()='Find Leads']"));
		eleFindLead.click();
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		driver.findElement(By.name("emailAddress")).sendKeys("Kumaresh@gmail.com");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		WebElement eleLeadId = driver
				.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName'])[1]/a"));
		String leadId = eleLeadId.getText();
		System.out.println(leadId);
		eleLeadId.click();
		driver.findElement(By.xpath("//a[text()='Duplicate Lead']")).click();
		String titlePage = driver.getTitle();
		if (titlePage.contains("Duplicate ")) {
			System.out.println("Expected Text Found in Title Page " + titlePage);
		} else {
			System.out.println("Actual Text Found in Title Page " + titlePage);
		}

		driver.findElement(By.xpath("//input[@value='Create Lead']")).click();
		String eleDuplicateName = driver.findElement(By.id("viewLead_firstName_sp")).getText();

		if (leadId.equalsIgnoreCase(eleDuplicateName)) {

			System.out.println("Duplicated Lead Name is Same");
		} else {
			System.out.println("Duplicated Lead Name is not Same");
		}

		driver.close();
	}

}
