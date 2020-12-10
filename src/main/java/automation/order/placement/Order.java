package automation.order.placement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Order {

    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver","C:\\MyFolder\\myProgramming\\SeleniumDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(); //creating chrome driver objects

        String baseUrl = "https://www.argos.co.uk/";
        // launch Chrome and direct it to the Base URL
        driver.get(baseUrl);
    }
}
