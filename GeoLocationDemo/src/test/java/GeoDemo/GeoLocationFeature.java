package GeoDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

public class GeoLocationFeature {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        Map<String,Object> coordinatesMap = new HashMap<String, Object>();

        coordinatesMap.put("latitude",34.052235);
        coordinatesMap.put("longitude",-118.243683);
        coordinatesMap.put("accuracy",100);

        ((ChromeDriver)(driver)).executeCdpCommand("Emulation.setGeolocationOverride",coordinatesMap);
        driver.get("https://oldnavy.gap.com/stores");

    }
}
