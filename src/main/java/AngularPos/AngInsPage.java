package AngularPos;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.paulhammant.ngwebdriver.NgWebDriver;

import basePage.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AngInsPage extends BasePage {
	
	//public static WebDriver driver;
	
	@FindBy(xpath = "//p[contains(text(),\"I DON'T REMEMBER MY VEHICLE NO\")]")
	WebElement RenewLink;
	
	@FindBy(xpath = "//input[@id=\"spanvalue\"]")
	WebElement SelectMMVfield;
	
	@FindBy(xpath = "//img[@id=\"HONDA\"]")
	WebElement SelectMake;
	
	@FindBy(xpath = "//div[@id='model_71']")
	WebElement SelectModel;
	
	@FindBy(xpath = "//div[contains(text(),'PETROL')]")
	WebElement SelectFuel;
	
	@FindBy(xpath = "//div[contains(text(),'1.5 S MT (1497CC)')]")
	WebElement SelectVariant;
	
	@FindBy(xpath = "//input[@id='Registvalue']")
	WebElement SelectRegField;
	
	@FindBy(xpath = "//div[contains(text(),'MH')]")
	WebElement SelectState;
	
	@FindBy(xpath = "//div[contains(text(),'MH01')]")
	WebElement SelectStateCode;
	
	@FindBy(xpath = "//*[@id=\"datepicker2\"]")
	WebElement SelectDateofRegField;
	
	//this xpath directly use in mthd
	@FindBy(xpath = "//div[@class='inputBox block_head']/div[1]/div/div/div/label/div/span[contains(text(),'Yes')]")
	WebElement SelectExisCPOptn;
	
	@FindBy(xpath = "//input[@id='datepicker3']")
	WebElement SelectExpDateFld;
	
	@FindBy(xpath = "//select[@id='PreviousINS']")
	WebElement SelectPreInsFld;
	
	@FindBy(xpath = "//div[@class='inputBox claimblock_head']/div/div/div/div[2]")
	WebElement SelectNcbNoopn;
	
	@FindBy(xpath = "//div[@class='inputBox claimblock_head']/div/div/div/div[1]")
	WebElement SelectNcbYesopn;
	
	//this xpath directly us in mthd
	@FindBy(xpath = "//select[@id='NoClaimBonus']/option[contains(text(),'20')]")
	WebElement SelectNcbperc;
	
	@FindBy(xpath = "//input[@id='Full_Name']")
	WebElement EnterFullName;
	
	@FindBy(xpath = "//input[@id='MobileNo']")
	WebElement EnterMobileNo;
	
	@FindBy(xpath = "//input[@id='email']")
	WebElement EnterEmailId;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement ClickSubmit;
	
	//Enter otp in case wout login
	@FindBy(xpath = "//input[@id='txtotp']")
	WebElement EnterOtp;
	
	@FindBy(xpath = "//button[contains(text(),'Verify')]")
	WebElement ClickVerifyotpbtn;
	
	
	public AngInsPage() {
		super();
		//this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//***please pass make model and variant from method instead of hardcoding it in path)
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		openBrowser();
		
//		WebDriverManager.chromedriver().setup();
//		//System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
//		driver = new ChromeDriver();
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		NgWebDriver ngdriver = new NgWebDriver(js);
//		driver.get("https://www.policyboss.com/Motor/car_insurance");
//		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
//		driver.manage().window().maximize();
//		//p[contains(text(),"I DON'T REMEMBER MY VEHICLE NO")]
//		Thread.sleep(3000);
//		//driver.close();
//		//driver.findElement(By.xpath("//p[contains(text(),\"I DON'T REMEMBER MY VEHICLE NO\")]")).click();
//		//driver.findElement(By.xpath("//input[@id=\"spanvalue\"]")).click();
//		//driver.findElement(By.xpath("//img[@id=\"HONDA\"]")).click();
//		Thread.sleep(2000);
//		//driver.findElement(By.xpath("//div[@id='model_71']")).click();
//		Thread.sleep(3000);
//		//driver.findElement(By.xpath("//div[contains(text(),'PETROL')]")).click();
//		Thread.sleep(3000);
//		//driver.findElement(By.xpath("//div[contains(text(),'1.5 S MT (1497CC)')]")).click();
//		Thread.sleep(3000);
//		//driver.findElement(By.xpath("//input[@id='Registvalue']")).click();
//		Thread.sleep(3000);
//		//driver.findElement(By.xpath("//div[contains(text(),'MH')]")).click();
//		Thread.sleep(3000);
//		//driver.findElement(By.xpath("//div[contains(text(),'MH01')]")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//*[@id=\"datepicker2\"]")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/select[2]")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")).sendKeys("2018");
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/select[1]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")).sendKeys("Oct");
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr[3]/td[5]")).click();
//		Thread.sleep(2000);
		//driver.findElement(By.xpath("//div[@class='inputBox block_head']/div[1]/div/div/div/label/div/span[contains(text(),'Yes')]")).click();
//		Thread.sleep(2000);
		//driver.findElement(By.xpath("//input[@id='datepicker3']")).click();
	//	Thread.sleep(3000);
	//	driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/select[2]")).click();
	//	Thread.sleep(2000);
	//	driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")).sendKeys("2022");
	//	Thread.sleep(2000);
	//	driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/select[1]")).click();
	//	Thread.sleep(2000);
	//	driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")).sendKeys("Apr");
	//	Thread.sleep(2000);
	//	driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr[5]/td[2]")).click();
	//	Thread.sleep(2000);
	//	driver.findElement(By.xpath("//select[@id='PreviousINS']")).click();
	//	Thread.sleep(2000);
	//	driver.findElement(By.xpath("//select[@id='PreviousINS']")).sendKeys("Bharti Axa");
	//	Thread.sleep(2000);
	//	driver.findElement(By.xpath("//div[@class='inputBox claimblock_head']/div/div/div/div[2]")).click();
	//	Thread.sleep(2000);
		//driver.findElement(By.xpath("//input[@id='Full_Name']")).click();
	//	driver.findElement(By.xpath("//input[@id='Full_Name']")).clear();
	//	driver.findElement(By.xpath("//input[@id='Full_Name']")).sendKeys("Test Vijay Kumar");
	//	driver.findElement(By.xpath("//input[@id='MobileNo']")).click();
	//	driver.findElement(By.xpath("//input[@id='MobileNo']")).clear();
	//	driver.findElement(By.xpath("//input[@id='MobileNo']")).sendKeys("9967192155");
	//	driver.findElement(By.xpath("//input[@id='email']")).click();
	//	driver.findElement(By.xpath("//input[@id='email']")).clear();
	//	driver.findElement(By.xpath("//input[@id='email']")).sendKeys("policybossqa@gmail.com");
	//	Thread.sleep(3000);	
	//	driver.findElement(By.xpath("//button[@type='submit']")).click();
	//	Thread.sleep(2000);
	//	driver.findElement(By.xpath("//input[@id='txtotp']")).sendKeys("8888");
	//	driver.findElement(By.xpath("//button[contains(text(),'Verify')]")).click();
		//Thread.sleep(2000);
		//driver.close();
		
	}

}
