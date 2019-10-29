package newFeatures;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class NewTabORWindow {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		System.out.println(driver.getTitle());
		driver.switchTo().newWindow(WindowType.TAB); //open new Tab
		
		//driver.switchTo().newWindow(WindowType.WINDOW); //open new Window
		
		Set<String> handles = driver.getWindowHandles();
		
		List<String> ls = new ArrayList<String>(handles);
		
		String parentWindowId = ls.get(0);
		String childWindowId = ls.get(1);
		
		System.out.println(parentWindowId);
		System.out.println(childWindowId);
		
		driver.get("https://www.facebook.com");
		System.out.println(driver.getTitle());
		
		driver.close(); //close tab
		
		driver.switchTo().window(parentWindowId);
		
		System.out.println(driver.getTitle()); // -- driver is lost if close before switch
		
	}
}
