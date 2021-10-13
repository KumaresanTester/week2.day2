package week2.day2;


import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		String newCompanyName = "TCS";
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
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		driver.findElement(By.xpath("//div[@class='x-form-item x-tab-item']//input[@name='firstName']"))
				.sendKeys("Kumaresan");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a")).click();
		String titlePage = driver.getTitle();

		if (titlePage.contains("View Lead")) {
			System.out.println("Expected Title Page : " + titlePage);
		} else {
			System.out.println("Actual Title Page : " + titlePage);
		}

		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		WebElement eleCompanyName = driver.findElement(By.id("updateLeadForm_companyName"));
		eleCompanyName.clear();
		eleCompanyName.sendKeys(newCompanyName);
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		String updatedCompanyName = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		String[] split = updatedCompanyName.split(" ");	
		String updatedCompany = split[0].toString();

		if (newCompanyName.equalsIgnoreCase(updatedCompany)) {
			System.out.println("Changed Company Name Updated Sucessfully : " + newCompanyName);
		} else {
			System.out.println("Changes Company Name Not Updated : " + newCompanyName);
		}
		
		driver.close();
	}

}
