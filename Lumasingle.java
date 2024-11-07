package lumatests;


import java.awt.AWTException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Lumasingle {ChromeDriver driver;
String emailid=new String("arun.jc011@gmail.com");
String password=new String("jos1aruaju@123");

@BeforeTest
public  void setup() {
 
	driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.get("https://magento.softwaretestingboard.com/");//Loading URL
	driver.manage().window().maximize();
	
}
@Test(priority=1)
public void Createaccount() throws InterruptedException {
	
	driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[3]/a")).click();//To click "Create an account" link
	driver.findElement(By.xpath("//*[@id=\"firstname\"]")).sendKeys("Arun ");
	driver.findElement(By.xpath("//*[@id=\"lastname\"]")).sendKeys("Jose ");
	
	driver.findElement(By.xpath("//*[@id=\"email_address\"]")).sendKeys(emailid);
	driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
	driver.findElement(By.xpath("//*[@id=\"password-confirmation\"]")).sendKeys(password);
	driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button/span")).click();
	Thread.sleep(5000);
	
}
@Test(priority=2)
	public void Logout() throws InterruptedException//Logout
	{
	driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button")).click();
	driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a")).click();
	Thread.sleep(5000);
	}
@Test(priority=3)
public void Signin() throws InterruptedException	//Sign in
{
	driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a")).click();
	driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(emailid);
	driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys(password);
	driver.findElement(By.xpath("//*[@id=\"send2\"]/span")).click();
	Thread.sleep(3000);
}
@Test(priority=4)
public void Addaddress() throws InterruptedException
{
	driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button")).click();//click customer drop-down
	driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[1]/a")).click();//click My account
	driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[1]/div[4]/div[1]/a/span")).click();//click manage address
	driver.findElement(By.xpath("//*[@id=\"telephone\"]")).sendKeys("465-3333");//Add phone number
	driver.findElement(By.xpath("//*[@id=\"street_1\"]")).sendKeys("123 Boston Street");//add street address
	driver.findElement(By.xpath("//*[@id=\"city\"]")).sendKeys("Indian");//Enter city
	
	
	
	Select provinceSelect = new Select(driver.findElement(By.xpath("//*[@id=\"region_id\"]")));//Select province drop-down
	Thread.sleep(3000);
	provinceSelect.selectByVisibleText("Alaska");//Select province by visible text
	driver.findElement(By.xpath("//*[@id=\"zip\"]")).sendKeys("99540");//Enter zip-code
	
	Select countrySelect = new Select(driver.findElement(By.xpath("//*[@id=\"country\"]")));//Select city drop-down
	countrySelect.selectByVisibleText("United States");//Select country by visible text
	
	driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button/span")).click();//click save address tab
	Thread.sleep(3000);
		
	
	
}
@Test(priority=5)
public void Searchpurchase() throws InterruptedException, AWTException
{
	driver.findElement(By.xpath("//*[@id=\"search\"]")).sendKeys("yoga shorts");//Click and type input in search box
	//Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button")).click();//click search button
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div[2]/ol/li[1]/div/a/span/span/img")).click();//productlink  click
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id=\"option-label-size-143-item-171\"]")).click();//Select size
	driver.findElement(By.xpath("//*[@id=\"option-label-color-93-item-50\"]")).click();//Select color
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]/span")).click();//Add to cart
	driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div/div[1]/div[5]/div/a[1]/span")).click();//Add to wish-list.
	driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div[1]/a")).click();//Click show cart button
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id=\"top-cart-btn-checkout\"]")).click();//Click proceed to checkout
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id=\"checkout-shipping-method-load\"]/table/tbody/tr[1]/td[1]/input")).click();//select shipping method
	driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button")).click();//click next
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button/span")).click();//Click place order button
	//Thread.sleep(3000);

}

	

@AfterClass
public void Close()
    {
	//driver.close();
	}


}






