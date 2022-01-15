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
public class VerifyLogin {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\Selenium\\chromedriver.exe");
		String url = "http://my.uda.edu.vn/sv/svlogin";
		WebDriver driver = new ChromeDriver();
		
		driver.get(url);
		
		
		//Link Text
//		driver.findElement(By.linkText("Quên pass")).click();
		//InputText Username
		driver.findElement(By.id("User")).sendKeys("43162");
		//InputText Password
		driver.findElement(By.name("Password")).sendKeys("sinhviendonga43162");
		//Button "Log in"
		driver.findElement(By.id("Lnew1")).click();
		//Radio Button
		driver.findElement(By.xpath("//a[@id='MainContent_GV2_LB5_0']")).click();
		//Check Box
		System.out.println(driver.getTitle());
		//DropDown List
	}

}
