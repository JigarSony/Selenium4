package newFeatures;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SendKeysCharSequence {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://app.hubspot.com/login");
		WebElement email = driver.findElement(By.id("username"));
		
		//1. String
		//email.sendKeys("abc");
		
		//2. String Builder
		StringBuilder username = new StringBuilder()
				.append("JAck")
				.append(" ")
				.append("MA")
				.append(" ")
				.append("Ali")
				.append(" ")
				.append("Baba");
		
		//email.sendKeys(username);
		
		//3. String buffer
		StringBuffer username1 = new StringBuffer()
				.append("JAck")
				.append(" ")
				.append("MA")
				.append(" ")
				.append("Ali")
				.append(" ")
				.append("Baba");
		
		//email.sendKeys(username1);
		
		//4. String Builder, String Buffer, String
		StringBuilder SBusername = new StringBuilder()
				.append("JAck")
				.append(" ")
				.append("MA")
				.append(" ")
				.append("Ali")
				.append(" ")
				.append("Baba");
		
		String SBspace = " ";
		
		StringBuffer SBBusername = new StringBuffer()
				.append("Jicky")
				.append(" ")
				.append("BABA");
		
		// email.sendKeys(SBBusername+SBspace+SBBusername);
		email.sendKeys(SBBusername, SBspace, SBBusername, SBspace, Keys.TAB);
	}

}
