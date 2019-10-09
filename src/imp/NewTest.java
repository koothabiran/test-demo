package imp;

import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

public class NewTest 
{
	public static WebDriver driver;
    public static WebDriverWait wait;
    public static XSSFWorkbook workbook;
    public static XSSFSheet sheet;
    public static XSSFCell cell;

@BeforeTest
 public void TestSetup()
{
	// Set the path of the chrome driver.
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Mathivathani\\Desktop\\drivers\\chromedriver.exe");
    driver = new ChromeDriver();
    // Enter url.
	driver.get("http://www.linkedin.com/");
	driver.manage().window().maximize();
}
	@Test
	 public void ReadData() throws IOException, InterruptedException
	{
	// Import excel sheet.
	File src=new File("C:\\Users\\Mathivathani\\Desktop\\sele.xlsx");
	// Load the file.
	FileInputStream finput = new FileInputStream(src);
	// Load the workbook.
	workbook = new XSSFWorkbook(finput);
	// Load the sheet in which data is stored.
	sheet= workbook.getSheetAt(0);
	
	int rc=sheet.getLastRowNum();
	
	for(int i=1;i<=rc;i++)
		
	{
		
		cell = sheet.getRow(i).getCell(1);
		cell.setCellType(Cell.CELL_TYPE_STRING);
		System.out.println(cell.getStringCellValue());
		driver.findElement(By.id("login-email")).sendKeys(cell.getStringCellValue());
		Thread.sleep(2000);
		
		
		cell = sheet.getRow(i).getCell(2);
		cell.setCellType(Cell.CELL_TYPE_STRING);
		System.out.println(cell.getStringCellValue());
		driver.findElement(By.id("login-password")).sendKeys(cell.getStringCellValue());
		Thread.sleep(2000);
		
		
		driver.findElement(By.xpath(".//*[@id='login-submit']")).click();
		Thread.sleep(2000);
		
		
		FileOutputStream fos = new FileOutputStream(src);
		String pass = "Pass";
		String fail = "Fail";
		
		
		//String c = driver.findElement(By.id("mynetwork-tab-icon")).getText();
		int a = driver.findElements(By.id("mynetwork-tab-icon")).size();
		System.out.println(a);
		
		if (a==1)
		{
			sheet.getRow(i).createCell(3).setCellValue(pass);
		}
		else
		{
			sheet.getRow(i).createCell(3).setCellValue(fail);
		}
		
		workbook.write(fos);
		
		fos.close();
		
		
		int b = driver.findElements(By.xpath(".//*[@id='nav-settings__dropdown-trigger']")).size();
		System.out.println(b);
		
		if(b==1)
		{
			driver.findElement(By.xpath(".//*[@id='nav-settings__dropdown-trigger']")).click();
			Thread.sleep(4000);
		//driver.findElement(By.xpath(".//*[@id='nav-settings__dropdown-trigger']")).click();
			//driver.findElement(By.xpath("//*[@id=\"ember3071\"]"));
				
			driver.findElement(By.xpath("html/body/nav/div/ul[1]/li[6]/div/ul/li[4]/ul/li/a")).click();
		
			
		
	}
		else
		{
		driver.get("http://www.google.com/");
		Thread.sleep(5000);
		driver.get("https://www.linkedin.com");
	
			}
	
}
	}
}
