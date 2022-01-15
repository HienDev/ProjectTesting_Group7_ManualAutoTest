/**
 * 
 */
package TestBasic;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author Admin
 *
 */
public class TestEcomerce {

	/**
	 * @param args
	 */
	
//	NHÓM 7
	/*
	 * Viết kịch bản kiểm thử cho chức năng mua hàng trên hệ thống pltpro.net
	 * 1. Người dùng chọn sản phẩm mình cần, click vào chuyển hướng tới trang chi tiết sản phẩm
	 * 2. Người dùng nhấn vào thêm sản phẩm vào giỏ hàng --> chuyển hướng tới trang giỏ hàng của bạn, cập nhật số lượng
	 * 3. Nhập thông tin giao hàng của mình
	 * 4. Kết thúc Testcase, đóng trình duyệt và đặt hành thành công
	 */
	WebDriver driver;
	
	
	@Before
	public void connect() {
		System.out.println("Bat dau ket noi ChromeDriver de thuc thi");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		String url = "https://pltpro.net/";
		driver.manage().window().maximize();
		driver.get(url);

	}
	
	@Test
	public void main() {
		String data [][] = new String[3][4];
		// Sản phẩm 1
		data[0][0] = "//a[contains(text(),'LAPTOP CORE I3-3217U 14INCH GỌN GÀNG MẠNH MẼ,...')]";
		data[0][1] = "//input[@id='quantity_842']";
		data[0][2] = "3";
		data[0][3] = "//tbody/tr[1]/td[3]/div[1]/span[1]/button[1]";
	
		// Sản phẩm 3
		data[1][0] = "//a[contains(text(),'LAPTOP HP NHẬT LIKE NEW 2 TRONG 1, CORE M THẾ...')]";
		data[1][1] = "//input[@id='quantity_831']";
		data[1][2] = "5";
		data[1][3] = "//tbody/tr[2]/td[3]/div[1]/span[1]/button[1]";
		
		// Sản phẩm 2
		data[2][0] = "//a[contains(text(),'BOSTON AUDIO PA-1500 CHÍNH HÃNG HÀNG NHẬP, 8 ...')]";
		data[2][1] = "//input[@id='quantity_111']";
		data[2][2] = "4";
		data[2][3] = "//tbody/tr[3]/td[3]/div[1]/span[1]/button[1]";
		
	
		
		String[] user = {"Hoàng Đức Hiền", "0934717617", "hien43162@donga.edu.vn", "Thôn Hà Úc 4, Xã Vinh An, Huyện Phú Vang, Tỉnh Thừa Thiên Huế",
		"Mong Shop vận chuyển nhanh, và chú ý hàng dễ vỡ, giao trước ngày tết âm lịch giúp em, xin cám ơn!"};
		
		for(int i = 0; i<data.length; i++) {
			buy(data[i]);
			if(i + 1 == data.length) {
				driver.findElement(By.xpath("//tbody/tr[1]/td[2]/input[1]")).sendKeys(user[0]);
				driver.findElement(By.xpath("//tbody/tr[2]/td[2]/input[1]")).sendKeys(user[1]);
				driver.findElement(By.xpath("//tbody/tr[3]/td[2]/input[1]")).sendKeys(user[2]);
				driver.findElement(By.xpath("//tbody/tr[4]/td[2]/input[1]")).sendKeys(user[3]);
				driver.findElement(By.xpath("//tbody/tr[5]/td[2]/textarea[1]")).sendKeys(user[4]);
				driver.findElement(By.xpath("//button[contains(text(),'Hoàn tất đặt hàng')]")).click();
			}
			else {
				driver.findElement(By.xpath("//a[contains(text(),'Tiếp tục mua hàng')]")).click();
			}
		}
	}
	
	public void buy(String[] data) {
		// Chọn sản phẩm
		driver.findElement(By.xpath(data[0])).click();
		// Tăng số lượng
		driver.findElement(By.xpath("//body/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/a[1]")).click();
		driver.findElement(By.xpath("//body/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/a[1]")).click();
		// Giảm số lượng
		driver.findElement(By.xpath("//body/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/a[2]")).click();

		// Thêm vào giỏ hàng
		driver.findElement(By.xpath("//button[@id='button-cart']")).click();

		// Chỉnh sửa số lượng sản phẩm trong giỏ hàng
		driver.findElement(By.xpath(data[1])).clear();
		driver.findElement(By.xpath(data[1])).sendKeys(data[2]);
		// Cập nhật số lượng chỉnh sửa trong giỏ hàng
		driver.findElement(By.xpath(data[3])).click();
		
		
	}
	
	@After
	public void closeBrower() {
		System.out.println("Ket thuc Testcase");
		driver.quit();
	}

}
