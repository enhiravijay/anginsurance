package MyAngularpos.AngularPos;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.paulhammant.ngwebdriver.NgWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class AngInsPage {
	
	public static WebDriver driver;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		NgWebDriver ngdriver = new NgWebDriver(js);
		driver.get("https://www.policyboss.com/Motor/car_insurance");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//p[contains(text(),"I DON'T REMEMBER MY VEHICLE NO")]
		Thread.sleep(3000);
		//driver.close();
		driver.findElement(By.xpath("//p[contains(text(),\"I DON'T REMEMBER MY VEHICLE NO\")]")).click();
		driver.findElement(By.xpath("//input[@id=\"spanvalue\"]")).click();
		driver.findElement(By.xpath("//img[@id=\"HONDA\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='model_71']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[contains(text(),'PETROL')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[contains(text(),'1.5 S MT (1497CC)')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='Registvalue']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[contains(text(),'MH')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[contains(text(),'MH01')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"datepicker2\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/select[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")).sendKeys("2018");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/select[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")).sendKeys("Oct");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr[3]/td[5]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='inputBox block_head']/div[1]/div/div/div/label/div/span[contains(text(),'Yes')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='datepicker3']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/select[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")).sendKeys("2022");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/select[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")).sendKeys("Feb");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr[5]/td[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//select[@id='PreviousINS']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//select[@id='PreviousINS']")).sendKeys("Bharti Axa");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='inputBox claimblock_head']/div/div/div/div[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='Full_Name']")).click();
		driver.findElement(By.xpath("//input[@id='Full_Name']")).clear();
		driver.findElement(By.xpath("//input[@id='Full_Name']")).sendKeys("Test Vijay Kumar");
		driver.findElement(By.xpath("//input[@id='MobileNo']")).click();
		driver.findElement(By.xpath("//input[@id='MobileNo']")).clear();
		driver.findElement(By.xpath("//input[@id='MobileNo']")).sendKeys("9967192155");
		driver.findElement(By.xpath("//input[@id='email']")).click();
		driver.findElement(By.xpath("//input[@id='email']")).clear();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("policybossqa@gmail.com");
		Thread.sleep(3000);	
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='txtotp']")).sendKeys("8888");
		driver.findElement(By.xpath("//button[contains(text(),'Verify')]")).click();
		//Thread.sleep(2000);
		//driver.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
				
		
		

	}
	
	/*private void selectMonth(WebElement monthEle,String monthValue) throws Exception {
		//String mon;

		System.out.println("selecting month ");
		System.out.println("month to be selected"+ExcelUtils.getMapData("SelectRegMonth"));
		String actMonthArray [] = new String [] {"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
		String expMonthArray [] = new String [] {"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
		
		System.out.println("month showing is "+ monthEle.getText());
		String actMonthTxt;
		
		int strActMonindex = 0;
		for(int i = 0;i<actMonthArray.length;i++) {
			String strArrActMonth = actMonthArray[i];
			actMonthTxt = monthEle.getText();
			System.out.println(strArrActMonth);
			if(strArrActMonth.equalsIgnoreCase(actMonthTxt)) {
				System.out.println(actMonthArray[i].indexOf(strArrActMonth));
				break;
			}else {
				strActMonindex++;
			}
		}
		int strExpMonindex = 0;
		for(int i = 0;i<expMonthArray.length;i++) {
			String strArrExpMonth = expMonthArray[i];
			if(strArrExpMonth.equalsIgnoreCase(monthValue)) {
				break;
			}else {
				strExpMonindex++;
			}
		}
		
		for(int y = 0;y<13;y++) {
			String monthh = monthEle.getText();
			
			if(strActMonindex == strExpMonindex) {
				System.out.println(monthh + "this is p mon");
				break;
			}else if (strActMonindex < strExpMonindex) {
				waitHandle(driver, CLickNextMonth,20000);
				//CLickNextMonth.click();
				break;
			}else if (strActMonindex > strExpMonindex){
				waitHandle(driver, CLickPreMonth,20000);
				//CLickPreMonth.click();
				break;
			}
		}
		
		
		String monthh = monthEle.getText();
		System.out.println(monthh + "this is p mon");
		String mon;
		System.out.println("Hello ");
		System.out.println(ExcelUtils.getMapData("SelectRegMonth"));
		for (int i = 0; i <= 12; i++) {
			mon = monthEle.getText();
			System.out.println(mon);
			if (mon.equalsIgnoreCase(monthValue)) {
				System.out.println(mon + " mon value is equal to " + monthValue);
				break;
			} else {
				CLickNextMonth.click();
				i++;
			}

		}*/
	}


