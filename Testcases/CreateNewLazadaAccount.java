package Testcases;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.support.ui.Select;


@SuppressWarnings("deprecation")
public class CreateNewLazadaAccount {

	public static void main(String[] args) 
	{
		
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\huynd\\workspace\\Test Practise\\src\\Testcases\\chromedriver.exe");	
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.lazada.vn/customer/account/create/");
	
	driver.manage().window().maximize();
	
	//gender
	driver.findElement(By.id("RegistrationForm_gender_0")).click();
	
	//driver.findElement(By.id("RegistrationForm_gender_1")).click();
	
	//fill the customer name
	
	driver.findElement(By.id("RegistrationForm_first_name")).sendKeys("Huy");
	
	//	select date of birth
	
	Select seldate = new Select(driver.findElement(By.id("RegistrationForm_day")));
	
	seldate.selectByIndex(01);
	
	Select selmonth = new Select(driver.findElement(By.id("RegistrationForm_month")));
	selmonth.selectByIndex(01);
	
	Select selyear = new Select(driver.findElement(By.id("RegistrationForm_year")));
	selyear.selectByVisibleText("2000");;
	
	//Passwork fill
	
	driver.findElement(By.id("RegistrationForm_password")).sendKeys("abcd123456");
	driver.findElement(By.id("RegistrationForm_password2")).sendKeys("abcd123456");
	
	//email register
	String emailadd = "dinhhuyvt0005@gmail.com";
	
	driver.findElement(By.id("RegistrationForm_email")).sendKeys(emailadd);
	
	driver.findElement(By.id("send")).click();
	
	//if(driver.findElement(By.cssSelector("div.message-box._text")).getText().contains("Customer email already exist"))
	
	if(driver.getTitle().contains("Lazada - Create new customer account"))
	{
		driver.findElement(By.cssSelector("div.message-box._text")).getText().contains("Customer email already exist");
		System.out.println(emailadd + " had been used, please assign another email address");
	}
	
	else
		
	{
		/*
		String actualTitle = driver.getTitle();
		String expectedTitle = "Lazada - My account";
		Assert.assertEquals(expectedTitle,actualTitle);
		*/
		Assert.assertEquals("Lazada - My account", driver.getTitle());
				
		System.out.println("Your lazada account is registered successful");
		
		
	}
	
	
	}
	
	

}
