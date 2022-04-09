package basePage;

import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.paulhammant.ngwebdriver.NgWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.Config;
//import utility.WebEventListener;


public class BasePage {

	public static WebDriver driver;
	public boolean bResult;
	public static Properties prop;
	// public Login login;
	public static Config con;
	//public  static EventFiringWebDriver e_driver;
	//public static WebEventListener eventListener;
	public static WebDriverWait wait;
	
	public static NgWebDriver ngdriver;

	public BasePage() {
		// BasePage.driver = driver;
		bResult = true;
		Config con = new Config();
		BasePage.con = con;

	}

	public static void handleDropDown(List<WebElement> salele,WebElement ele, String Value) throws Exception {
		Thread.sleep(5000);
		int salsize = salele.size();
		for(int i = 0;i<salsize;i++) {
			String saltext = salele.get(i).getText();
			String sallower = saltext.toLowerCase();
			String valulower = Value.toLowerCase();
			if(sallower.contains(valulower)) {
				salele.get(i).click();
				//Select selectByVisibleText = new Select(ele);
				//selectByVisibleText.selectByVisibleText(saltext);
				break;
			}
		}
	}

	public static void handleDropDown(WebElement ele, String Value) throws Exception {
		Thread.sleep(5000);
		Select selectByVisibleText = new Select(ele);
		selectByVisibleText.selectByVisibleText(Value); 

	}

	public static void selectDay(WebElement dayele,String dayValue) {
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

	public static void enterChar(WebElement ele, String value) throws Exception{
		String val = value; 
		ele.clear();

		for (int i = 0; i < val.length(); i++){
			char c = val.charAt(i);
			Thread.sleep(1000);
			String s = new StringBuilder().append(c).toString();
			ele.sendKeys(s);
		}       
	}

	public static void selectautooption(List<WebElement> optionsToSelect,String textToSelect) {

		for(WebElement option : optionsToSelect){
			System.out.println(option);
			if(option.getText().equals(textToSelect)) {
				System.out.println("Trying to select: "+textToSelect);
				optionsToSelect.get(1).click();
				//option.click();
				break;
			}
		}
	}

	public static WebDriver openBrowser() throws Exception {
		System.out.println("inside open browser method");
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//NgWebDriver ngdriver = mew NgWebDriver
		ngdriver = new NgWebDriver(js);
		driver.get("https://www.policyboss.com/Motor/car_insurance");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		System.out.println("Open browser completed");
		return driver;
	}

	
	public NgWebDriver getNGDriver() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return (new NgWebDriver(js));
	}
	
	public void waitForAngularRequestToFinish() {
		try {
			getNGDriver().waitForAngularRequestsToFinish();
		} catch (Exception e) {
			Assert.fail("Error While Waiting For Angular Request To Finish: " + e.getMessage());
		}
	}
	public static void clickEle(WebElement ele) {

		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			try {
				ele.click();
			} catch (WebDriverException e) {
				System.out.println("An exceptional.case");
			}
		} catch (TimeoutException e) {
			System.out.println("WebDriver couldn’t locate the element");
		}

	}

	
	public static void multipleEle(String EleName) {
		
		
		
	}



}
