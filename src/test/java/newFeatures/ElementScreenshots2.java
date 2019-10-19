package newFeatures;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementScreenshots2 {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebElement gLogo = driver.findElement(By.id("hplogo"));
		WebElement gSearchBar = driver.findElement(By.name("q"));
		gSearchBar.sendKeys("Jigar");
		WebElement gBtn = driver.findElement(By.cssSelector("input.gNO89b"));
		WebElement gFeelingBtn = driver.findElement(By.cssSelector("input.RNmpXc"));
		
		takeScreenShot(gLogo, "gLogo");
		takeScreenShot(gSearchBar, "gSearchBar");
		takeScreenShot(gBtn, "gBtn");
		takeScreenShot(gFeelingBtn, "gFeelingBtn");
			
		driver.close();
	}
	
	public static void takeScreenShot(WebElement element, String imageName) {
		TakesScreenshot srcShot = ((TakesScreenshot)element);
		File scrFile = srcShot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File("./target/srcshot/"+imageName+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
