package newFeatures;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.support.locators.RelativeLocator ;
import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;;

public class RelativeLoc2 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		List<WebElement> socialImg = driver.findElements(withTagName("img").below(By.xpath("//a[text()='OrangeHRM, Inc']")));

		System.out.println("Total Count is "+ socialImg.size());
		
		for(WebElement ele:socialImg) {
			System.out.println(ele.getAttribute("alt"));
		}

		driver.quit();
		
		/*
		 * In Location
		 * document.getElemetnByID('txtUsername')
		 * document.getElemetnByID('txtUsername').getBoundingClientRect() -- 
		 */

	}
}
