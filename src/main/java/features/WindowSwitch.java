package features;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowSwitch {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Asus\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
        driver.get("https://www.google.com/");

        // open a new window
        driver.switchTo().newWindow(WindowType.WINDOW);
        //navigate to a URL on newly opened window
        driver.navigate().to("https://www.youtube.com/");

        // get the window ids to switch between them
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String googleWindow = it.next();
        String youtubeWindow = it.next();
        System.out.println(driver.getTitle());

        // switch the control to the google window
        driver.switchTo().window(googleWindow);
        System.out.println(driver.getTitle());

        // open a new tabbed window
        driver.switchTo().newWindow(WindowType.TAB);
        //navigate to a URL on newly opened tabbed window
        driver.navigate().to("https://www.gmail.com/");
        System.out.println(driver.getTitle());

        driver.switchTo().window(youtubeWindow);
        System.out.println(driver.getTitle());

        driver.quit();
	}
	
}
