package newFeatures;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.support.locators.RelativeLocator ;

import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;;

public class RelativeLoc {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://opensource-demo.orangehrmlive.com/");

		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");

//		WebElement loginBtn = driver.findElement(RelativeLocator.withTagName("input").below(By.id("txtPassword")));
//		loginBtn.click();

		// driver.findElement(RelativeLocator.withTagName("input").below(By.id("txtPassword"))).click();

		WebElement loginBtn = driver.findElement(withTagName("input").below(By.id("txtPassword")));
		loginBtn.click();

		driver.quit();

	}
}
