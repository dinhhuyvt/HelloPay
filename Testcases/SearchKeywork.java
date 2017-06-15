package Testcases;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchKeywork {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\huynd\\workspace\\Test Practise\\src\\Testcases\\chromedriver.exe");	
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.lazada.vn");
		
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("test");
		driver.findElement(By.cssSelector("button.c-header-search__input-group-button.c-header-search__input-group-button_type_search")).click();
		
		//verify function
		StringBuffer errorBuffer = new StringBuffer();
		
		try{ 
			
		Assert.assertTrue(driver.getPageSource().contains("Kết quả tìm kiếm của \"test\""));
		Assert.assertTrue(driver.getPageSource().contains("Sản Phẩm Được Tìm Thấy"));
		
		}catch(AssertionError e){           
	        errorBuffer.append(e.getMessage() + "\n");      
	    }       

	}

}
