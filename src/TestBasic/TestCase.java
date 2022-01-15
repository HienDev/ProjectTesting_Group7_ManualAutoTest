/**
 * 
 */
package TestBasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author Admin
 *
 */
public class TestCase {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\Selenium\\chromedriver.exe");
		String url = "https://www.selenium.dev/";
		WebDriver driver = new ChromeDriver();
		
		driver.get(url);
		
		driver.navigate().to("https://www.selenium.dev/documentation/webdriver/elements/finders/");
		
		String dinhdanh = driver.getWindowHandle();
		System.out.println(dinhdanh);
		System.out.println(driver.getCurrentUrl());
		
		driver.navigate().back();
		driver.navigate().forward();
		
		driver.navigate().refresh();
		
		System.out.println(driver.getTitle());
		
		driver.findElement(By.linkText("locator strategies")).click();
		System.out.println(driver.getWindowHandles());
		
//		
//		for(String windowHandle : driver.getWindowHandles()) {
//			if(!dinhdanh.contentEquals(windowHandle)) {
//				driver.switchTo().window(windowHandle);
//				System.out.println(driver.getWindowHandle());
//				driver.close();
//				break;
//			}
//		}
		driver.quit();

	}

}
