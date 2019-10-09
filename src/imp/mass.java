package imp;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class mass 
{
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static WebElement element1,element2;

//@Test(priority=1)
 public void TestSetup() throws InterruptedException
{
	// Set the path of the Chrome driver.
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Mathivathani\\Desktop\\drivers\\chromedriver.exe");
    driver = new ChromeDriver();
    // Enter url.
    
    
	driver.get("https://www.guru99.com/become-an-instructor.html");
	Thread.sleep(2000);
	driver.manage().window().maximize();
	Actions action=new Actions(driver);
	WebElement element= driver.findElement(By.xpath(".//*[@id='gbw']/div/div/div[1]/div[2]/a"));
	action.contextClick(element).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN);
	driver.findElement(By.linkText("Images")).sendKeys(selectLinkOpeninNewTab);
	
	String parent=driver.getWindowHandle();
	
	Set <String> s1=driver.getWindowHandles();
	
	Iterator <String> I1= s1.iterator();
	while(I1.hasNext())
	{
	 String child_window=I1.next();
	System.out.println(child_window);
	 if(!parent.equals(child_window))
		{
		driver.switchTo().window(child_window);
		 System.out.println(driver.switchTo().window(child_window).getTitle());
		 driver.switchTo().window(parent);
		 
		}
	}
}
//@Test(priority=3)
public void dragger() throws InterruptedException
{
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Mathivathani\\Desktop\\drivers\\chromedriver.exe");
    driver = new ChromeDriver();	
    driver.get("http://jqueryui.com/droppable/#default");
	Thread.sleep(2000);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	element1=driver.findElement(By.xpath("html/body/div[1]"));
	element2=driver.findElement(By.xpath("html/body/div[2]"));
	Actions builder = new Actions(driver);
	Action dragAndDrop = builder.clickAndHold(element1)
	.moveToElement(element2)
	.release(element2)
	.build();
	dragAndDrop.perform();
}

	@Test(priority=1)
public void upload() throws InterruptedException, IOException
{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Mathivathani\\Desktop\\drivers\\chromedriver.exe");
	    driver = new ChromeDriver();
	    // Enter url.
	    
	    
		driver.get("https://www.guru99.com/become-an-instructor.html");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		//scrolldown(".//*[@id='cid_7']/div/div/div/div[3]/input");
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='cid_7']/div/div/div/div[3]/input")).click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("D:\\AutoIt3\\FileUpload.exe");
		
		
}
	public void scrolldown(String xpath1) 
    {  
        
      JavascriptExecutor JE = (JavascriptExecutor) driver;  
    WebElement scroll= driver.findElement(By.xpath(".//*[@id='cid_7']/div/div/div/div[3]/input"));
    JE.executeScript("arguments[0].scrollIntoView(true);",scroll);    
    scroll.click(); 
   
    } 
	
}
	
	
   


