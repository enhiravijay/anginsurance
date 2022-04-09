package utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.paulhammant.ngwebdriver.NgWebDriver;

import basePage.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DateFunction extends BasePage{

	//public static WebDriver driver;
	
	
//	public static void main(String[] args) throws Exception {
//		
//		//driver = openBrowser();
//		// TODO Auto-generated method stub
//		/*
//		 * WebDriverManager.chromedriver().setup();
//		 * //System.setProperty("webdriver.chrome.driver",
//		 * "src\\test\\resources\\drivers\\chromedriver.exe"); driver = new
//		 * ChromeDriver(); JavascriptExecutor js = (JavascriptExecutor) driver;
//		 * NgWebDriver ngdriver = new NgWebDriver(js);
//		 * driver.get("https://www.policyboss.com/Motor/car_insurance");
//		 * driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
//		 * driver.manage().window().maximize();
//		 */
//		//p[contains(text(),"I DON'T REMEMBER MY VEHICLE NO")]
//		driver.findElement(By.xpath("//p[contains(text(),\"I DON'T REMEMBER MY VEHICLE NO\")]")).click();
//		Thread.sleep(3000);
//		//driver.findElement(By.xpath("https://www.policyboss.com/car-insurance/"));
//		selectDate("2018", "Oct");
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr[3]/td[5]")).click();
//		selectDay("18");
//		
//
//	}
	
	public static void selectDay(String dayValue) {
		WebElement dayelem=driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/table/tbody/tr/td/a[contains(.,'" + dayValue + "')]"));
		//WebElement dayelem=driver.findElement(By.xpath("//table[@class='table dtp-picker-days']/tbody/tr/td/a[contains(.,'" + dayValue + "')]"));
		
		WebElement GetFirstRegDay = driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/table/tbody/tr/td/a"));
		int intcalday = Integer.parseInt(GetFirstRegDay.getText());
		System.out.println(intcalday);
		for (int i = 0; i <= 31; i++) {
			if (intcalday == Integer.parseInt(dayValue)) {
				System.out.println(intcalday + " mon value is equal to " + dayValue);
				dayelem.click();
				break;
			} else if(intcalday <= Integer.parseInt(dayValue)){
				intcalday++;
				//GetFirstRegPrevYearBtn.click();
			}
			System.out.println(intcalday);

		}
	}
	
	public static void selectDate(String Year,String Month) throws Exception {
		
		//driver.findElement(By.xpath("//*[@id=\"datepicker2\"]")).click();
		Thread.sleep(3000);
		//select year dropdown box
		driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/select[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")).sendKeys(Year);
		Thread.sleep(2000);
		//select month dropdown box
		driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/select[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")).sendKeys(Month);
		Thread.sleep(2000);
		
	}


}
