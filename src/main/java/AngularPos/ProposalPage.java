package AngularPos;

import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.paulhammant.ngwebdriver.NgWebDriver;

import basePage.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ProposalPage extends BasePage {
	public static int noofinslist;
	public static String inskeyvalue1;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
				WebDriverManager.chromedriver().setup();
				//System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
				driver = new ChromeDriver();
				JavascriptExecutor js = (JavascriptExecutor) driver;
				NgWebDriver ngdriver = new NgWebDriver(js);
				driver.get("https://www.policyboss.com/car-insurance/proposal?ClientID=2&ARN=ARN-GSMKYRPB-BVYJ-RUO7-NHMI-PYUUTG597DU5_109021480_5211534&POSP=NonPOSP&SsID=0");
				driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
				driver.manage().window().maximize();
				//p[contains(text(),"I DON'T REMEMBER MY VEHICLE NO")]
				Thread.sleep(5000);
				driver.findElement(By.xpath("//a[@id='TabPersonalInfo']/h4 ")).click();
				WebElement salu = driver.findElement(By.xpath("//select[@id='Salutation']"));
				List<WebElement> saluele = driver.findElements(By.xpath("//select[@id='Salutation']/option"));
				//IN RAHEJA SALUTATION IS IN CAPS MR
				handleDropDown(saluele,salu, "Mr");
				driver.findElement(By.xpath("//input[@id='DOBofOwner']")).click();
				WebElement yearele = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
				handleDropDown(yearele, "1982");
				WebElement monthele = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
				handleDropDown(monthele, "Oct");
				Thread.sleep(2000);
				WebElement dayele = driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr[3]/td[5]"));
				selectDay(dayele,"18");
				//married field is not in liberty,newindia
				driver.findElement(By.xpath("//select[@id='MaritalStatus']")).sendKeys("Married");
				//for bajaj,kotak extra occupation field.digit,liberty,newindia dont have
				//need to others caps with "others" occ option in case of bajaj and liberty
				//Kotak=OTHERS,Raheja=Other,
				WebElement occele = driver.findElement(By.xpath("//select[@id='ContactOccupationId']"));
				List<WebElement> occlist = driver.findElements(By.xpath("//select[@id='ContactOccupationId']/option"));
				handleDropDown(occlist, occele, "other");
				// In chola,tata Additional option to select reason for not opting cpa if other option selected it ask for cpa reg date.
				//in chola id is ReasonforCPAChola whereas in tata it is ReasonforCPA,text in tata is Other motor policy with CPA Cover whereas in chola it is CPA available with other Vehicle
				WebElement cpaele = driver.findElement(By.xpath("//select[@id='ReasonforCPA']"));
				handleDropDown(cpaele, "Other motor policy with CPA Cover");
				driver.findElement(By.xpath("//a[@id='TabAddInfo']/h4")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@id='RegisteredAddress']")).click();
				driver.findElement(By.xpath("//input[@id='RegisteredAddress']")).clear();
				driver.findElement(By.xpath("//input[@id='RegisteredAddress']")).sendKeys("abcd");
				driver.findElement(By.xpath("//input[@id='RegisteredAddress2']")).click();
				driver.findElement(By.xpath("//input[@id='RegisteredAddress2']")).clear();
				driver.findElement(By.xpath("//input[@id='RegisteredAddress2']")).sendKeys("efghkl");
				driver.findElement(By.xpath("//input[@id='RegisteredAddress3']")).click();
				driver.findElement(By.xpath("//input[@id='RegisteredAddress3']")).clear();
				driver.findElement(By.xpath("//input[@id='RegisteredAddress3']")).sendKeys("hijklm");
				WebElement pinele = driver.findElement(By.xpath("//input[@id='RegisteredPinCode']"));
				enterChar(pinele, "401105");
				Thread.sleep(2800);
				driver.findElement(By.xpath("//input[@id='RegisteredCityName']")).click();
				//List<WebElement> autoselcityele = driver.findElements(By.xpath("//input[@id='RegisteredCityId']"));
				//WebElement regcityname = driver.findElement(By.xpath("//input[@id='RegisteredCityName']"));
				//enterChar(regcityname, "Thane");
				//Thread.sleep(2000);
				//List<WebElement> autoselcityele = driver.findElements(By.xpath("//ul[@id='ui-id-3']/li]"));
				//selectautooption(autoselcityele, "Thane");
				//below three line is for godigit
				//driver.findElement(By.xpath("//input[@id='RegisteredCityName']")).sendKeys(Keys.ARROW_DOWN);
				//driver.findElement(By.xpath("//input[@id='RegisteredCityName']")).sendKeys(Keys.ARROW_DOWN);
				//driver.findElement(By.xpath("//input[@id='RegisteredCityName']")).sendKeys(Keys.ENTER);
				//selectautooption(autoselcityele, "mumbai");
				//below two line is for bajaj
				WebElement locele = driver.findElement(By.xpath("//select[@id='ddlRegisteredCityId']"));
				Thread.sleep(3000);
				List<WebElement> locoptele = driver.findElements(By.xpath("//select[@id='ddlRegisteredCityId']/option"));
				//In raheja its Bhayander East S.O; allothers BHAYANDER EAST
				handleDropDown(locoptele, locele, "BHAYANDER");
				driver.findElement(By.xpath("//a[@id='TabVehicleAddInfo']/h4")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@id='RegistrationNumberPart2']")).click();
				driver.findElement(By.xpath("//input[@id='RegistrationNumberPart2']")).clear();
				driver.findElement(By.xpath("//input[@id='RegistrationNumberPart2']")).sendKeys("BB");
				driver.findElement(By.xpath("//input[@id='RegistrationNumberPart3']")).click();
				driver.findElement(By.xpath("//input[@id='RegistrationNumberPart3']")).clear();
				driver.findElement(By.xpath("//input[@id='RegistrationNumberPart3']")).sendKeys("0197");
				driver.findElement(By.xpath("//input[@id='EngineNumber']")).click();
				driver.findElement(By.xpath("//input[@id='EngineNumber']")).clear();
				driver.findElement(By.xpath("//input[@id='EngineNumber']")).sendKeys("EN5289754");
				driver.findElement(By.xpath("//input[@id='ChasisNumber']")).click();
				driver.findElement(By.xpath("//input[@id='ChasisNumber']")).clear();
				driver.findElement(By.xpath("//input[@id='ChasisNumber']")).sendKeys("CH8959754");
				driver.findElement(By.xpath("//input[@id='PolicyNumber']")).click();
				driver.findElement(By.xpath("//input[@id='PolicyNumber']")).clear();
				driver.findElement(By.xpath("//input[@id='PolicyNumber']")).sendKeys("PL5986566");
				//vehicle color not there in reliance
				WebElement colorele = driver.findElement(By.xpath("//select[@id='VehicleColor']"));
				handleDropDown(colorele, "White");
				driver.findElement(By.xpath("//label[@id='IsFinancedNo']")).click();
				driver.findElement(By.xpath("//label[@id='PUCC_No_No']")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//a[@id='TabNomineeInfo']/h4")).click();
				WebElement nomrele = driver.findElement(By.xpath("//select[@id='NomineeRelationID']"));
				Thread.sleep(2000);
				//in raheja,unitedindia its wife all others spouse
				//handleDropDown(nomrele, "Wife");
				handleDropDown(nomrele, "Spouse");
				driver.findElement(By.xpath("//input[@id='NomineeName']")).click();
				driver.findElement(By.xpath("//input[@id='NomineeName']")).clear();
				driver.findElement(By.xpath("//input[@id='NomineeName']")).sendKeys("Test sdfsfh lslkd");
				driver.findElement(By.xpath("//input[@id='NomineeDOB']")).click();
				WebElement nomyearele = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
				handleDropDown(nomyearele, "1986");
				WebElement nommonthele = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
				handleDropDown(nommonthele, "Oct");
				Thread.sleep(2000);
				WebElement nomdayele = driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr[3]/td[5]"));
				selectDay(nomdayele,"18");
				driver.findElement(By.xpath("//a[@id='TabTermsConditions']/h4")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//label[@id='lbliagree']")).click();
				driver.findElement(By.xpath("//button[@class='btn_no']")).click();
				driver.findElement(By.xpath("//input[@id='PaymentLink' and @value = 'Online Payment']")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//input[@id='proceed_confirmation' and @value = 'Pay Now']")).click();
				//in liberty it ask for otp on click on confirm payment.
				//driver.findElement(By.xpath("//input[@id='txtotp']")).sendKeys("8888");
				//driver.findElement(By.xpath("//button[@class='verifyotp']")).click();
				//**raheja we have to click proceed for paymentgateway
				//driver.findElement(By.xpath("//input[@id='btnproceed']")).click();	
				//** in reliance you get both the option to select for payment "ccavenue and payu
				//Thread.sleep(5000);
				//driver.findElement(By.xpath("//input[@id='payu1']")).click();
				//Thread.sleep(3000);
				//driver.findElement(By.xpath("//input[@id='btnPayNow']")).click();
				//**in case of shriram it shows payment confirm page 3i infotech
				//Thread.sleep(3000);
				//driver.findElement(By.xpath("//input[@id='cmdPay']")).click();
				//**iffco tokio has multiple payment gateway option
				//Thread.sleep(3000);
				//driver.findElement(By.xpath("//span[@id='button']")).click();
	}
}

/*
 * === select contact details tab
 *  //a[@id='TabPersonalInfo']/h4 
 *  ===salutation and send saltn
 *  //select[@id='Salutation']
 *  ==select dob field 
 *  //input[@id='DOBofOwner']
 *  ==select dobyear and send year
 *  //select[@class='ui-datepicker-year']
 *  ==select dobmonth and send month
 *  //select[@class='ui-datepicker-month']
 *  ====selec dobday and send day
 *  //table[@class='ui-datepicker-calendar']/tbody/tr[3]/td[5]
 *  ==select marital status and send marstatus
 *   //select[@id='MaritalStatus']
 *   ==**bajaj has extra occupation field**==
 *   //select[@id='ContactOccupationId']
 *   ==select address tab
 *    //a[@id='TabAddInfo']/h4
 *   ==enter address one
 *    //input[@id='RegisteredAddress']
 *  ==enter address two
 *    //input[@id='RegisteredAddress2']
 *  ==enter address three
 *    //input[@id='RegisteredAddress3']
 *  ==enter pincode
 *   //input[@id='RegisteredPinCode']
 *  ==select locality and send regcity
 *   //select[@id='ddlRegisteredCityId']
 *  ==select vehicle details tab
 *   //a[@id='TabVehicleAddInfo']/h4       
 *  ==enter vehicle 3rd fields details
 *   //input[@id='RegistrationNumberPart2']
 *  ==enter vehicle 4th fields details 
 *   //input[@id='RegistrationNumberPart3']
 *   ==enter engine number
 *   //input[@id='EngineNumber']
 *   ==enter chasis number
 *   //input[@id='ChasisNumber']
 *   ==enter policy number
 *   //input[@id='PolicyNumber']
 *   ==select vehicle color and send color
 *   //select[@id='VehicleColor']
 *   ==select vehcle finan option button
 *   //label[@id='IsFinancedNo']
 *   ==select pucc no option button
 *   //label[@id='PUCC_No_No']
 *   ==select nominee info tab
 *   //a[@id='TabNomineeInfo']/h4
 *   ==select nominee relations and send nomkey
 *   //select[@id='NomineeRelationID']
 *   ==enter nominee name
 *   //input[@id='NomineeName']
 *   ==select nominee dob field
 *   //input[@id='NomineeDOB']
 *   ==select dobyear field and pass year 
 *  //select[@class='ui-datepicker-year']
 *   ==dobmonth field and pass month
 *  //select[@class='ui-datepicker-month']
 *  ==select dobday and pass day
 *  //table[@class='ui-datepicker-calendar']/tbody/tr[3]/td[5]
 * ==select terms and conditions fields
 * //a[@id='TabTermsConditions']/h4
 * ==select label field
 * //label[@id='lbliagree']
 * ==select whatsapp no button         
 * //button[@class='btn_no']        
 * ==select online payment option
 * //input[@id='proceed_confirmation' and @value = 'Pay Now']
 *         ******notes******
 *         bajaj has occupation as an extra field in contact details.
 *         1)while we enter pincode in digit it will not autopopulate city..we have to autoselect city by entering city in city field.
 *         2)In bajaj we enter pincode and city and state is auto populated. 
 *         In digit dont have select locality option
 *         in bajaj spouse is written as Spouse where as in digit it is spouse i.e is first letter small
 *         //in liberty it ask for otp on click on confirm payment.
 *         == chola in contact tab have additional option to select reason for not opting cpa
 *         ==vehicle color not there in reliance 
 *         kotak=payu
 *         bajaj=bajicpay
 *         digit=digitpaymaymentgateway
 *         raheja=payu
 *         reliance = ccavenue and payu
 *         edelweise = payu
 *         tataaig = tataaig
 *         shreeram = pgi.billdesk.com
 *         hdfc = pgi.billdesk.com
 *         newindia = pgi.billdesk.com
 *         oriental = pgi.billdesk.com
 *  */


