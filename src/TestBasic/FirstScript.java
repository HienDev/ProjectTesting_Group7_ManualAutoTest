/**
 * 
 */
package TestBasic;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;


/**
 * @author Admin
 *
 */
public class FirstScript {
	
//	NHÓM 7
//	Yêu cầu
	/* Kịch bản kiểm thử cho chức năng đăng nhập trên hệ thống my.uda.vn
	 * 1. Khi người dùng đăng nhập vào username không tồn tại. Hệ thống thông báo. "Kiểm tra lại tên hay password!"
	 * 2. Khi người dùng đăng nhập vào username và mật khẩu không đùng. Hệ thống thông báo "Kiểm tra lại tên hay password!"
	 * 
	 */
	
//	Viết TestScrit
	/*
	 * 1. Xây dựng repository
	 * 	- HTML Attribute
	 * 	- CSS Selector
	 *  - XPATH
	 *  
	 * 2. Sử dụng các lệnh của Selenium thay thế cho các hoạt động bằng tay
	 * 3. Tạo kiểm tra để ghi nhận kết quả test
	 */
	
	
	
	
	WebDriver driver;
	@Before
	public void InitTest() {
		// Khoi tao Driver
		System.out.println("Bat dau ket noi ChromeDriver de thuc thi");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		String url = "http://my.uda.edu.vn/sv/svlogin";
		driver.manage().window().maximize();
		driver.get(url);
		//Mở trang web
		
	}

	
	@Test
	public void FirstMethod() throws InterruptedException  {
		//1. Xác định các control nhập dữ liệu
		WebElement txtUsername = driver.findElement(By.name("User"));
		WebElement txtPassword = driver.findElement(By.name("Password"));

		
		//2. Nhập dữ liệu là username không tồn tại
		txtUsername.sendKeys("hien431623@donga.edu.vn");
		txtPassword.sendKeys("12345678");
		
		
//		//3. Click vào login
		WebElement btnLogin = driver.findElement(By.id("Lnew1"));
		btnLogin.click();
		
//		//4. Kiểm tra message
		WebElement lbNotify = driver.findElement(By.id("Ltbao"));
		Assert.assertEquals(lbNotify.getText(), "Kiểm tra lại tên hay password!");
	}
	
	
	@After
	public void CloseTest() {
		System.out.println("Ket thuc Testcase");
		
	}

}
