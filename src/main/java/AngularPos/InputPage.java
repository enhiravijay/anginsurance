package AngularPos;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePage.BasePage;
import utility.ExcelUtils;



public class InputPage extends BasePage {

	@FindBy(xpath = "//span[contains(text(),'Comprehensive Plan (1 Yr)')]")
	WebElement selectCPlan;

	@FindBy(xpath = "//span[contains(text(),'O.D. Only (1 Yr)')]")
	WebElement selectOdPlan;

	@FindBy(xpath = "//span[contains(text(),'T.P. Only (1 Yr)')]")
	WebElement selectTpPlan;

	@FindBy(xpath = "//p[contains(text(),\"I DON'T REMEMBER MY VEHICLE NO\")]")
	WebElement renewLink;

	@FindBy(xpath = "//p[contains(text(),\"I HAVE NEW CAR\")]")
	WebElement newLink;

	@FindBy(xpath = "//input[@id=\"spanvalue\"]")
	WebElement selectMMVfield;

	//dynamic make handled in selectMakemthd
	//@FindBy(xpath = "//img[@id=\"HONDA\"]")
	//WebElement selectMake;

	@FindBy(xpath = "//div[@id='model_71']")
	WebElement selectModel;

	@FindBy(xpath = "//div[contains(text(),'PETROL')]")
	WebElement selectFuel;

	@FindBy(xpath = "//div[contains(text(),'1.5 S MT (1497CC)')]")
	WebElement selectVariant;

	@FindBy(xpath = "//input[@id='Registvalue']")
	WebElement selectRegField;

	@FindBy(xpath = "//div[contains(text(),'MH')]")
	WebElement selectState;

	@FindBy(xpath = "//div[contains(text(),'MH01')]")
	WebElement selectStateCode;

	@FindBy(xpath = "//*[@id=\"datepicker2\"]")
	WebElement selectDateofRegField;

	//this xpath directly use in mthd
	@FindBy(xpath = "//input[@id='claimno']/parent::*")
	WebElement selectCpExistYes;

	@FindBy(xpath = "//input[@id='claimyes']/parent::*")
	WebElement selectCpExistNo;

	@FindBy(xpath = "//div[@class='ErrpopupSection1']/button[@class='OK_Btn']")
	WebElement selectCpNoPopup;

	@FindBy(xpath = "//input[@id='datepicker3']")
	WebElement selectExpDateFld;

	@FindBy(xpath = "//select[@id='PreviousINS']/option")
	List<WebElement> preInsOptions;

	@FindBy(xpath = "//select[@id='PreviousINS']")
	WebElement selectPreInsFld;

	@FindBy(xpath = "//select[@id=\"NoClaimBonus\"]/option")
	List<WebElement> NcbOption;


	@FindBy(xpath = "//input[@id='radio_no']/parent::*")
	WebElement selectNcbNoopn;

	@FindBy(xpath = "//input[@id='radio_btn']/parent::*")
	WebElement selectNcbYesopn;

	//this xpath directly us in mthd
	@FindBy(xpath = "//select[@id='NoClaimBonus']/option[contains(text(),'20')]")
	WebElement selectNcbperc;

	@FindBy(xpath = "//input[@id='Full_Name']")
	WebElement enterFullName;

	@FindBy(xpath = "//input[@id='MobileNo']")
	WebElement enterMobileNo;

	@FindBy(xpath = "//input[@id='email']")
	WebElement enterEmailId;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement clickSubmit;

	//Enter otp in case wout login
	@FindBy(xpath = "//input[@id='txtotp']")
	WebElement enterOtp;

	@FindBy(xpath = "//button[contains(text(),'Verify')]")
	WebElement clickVerifyotpbtn;

	public InputPage() {
		super();
		PageFactory.initElements(driver, this);
	}

	public void selectPlan() throws Exception {
		
		String splan = ExcelUtils.getMapData("Plan");
		try {
			if(splan=="Comp") {
				selectCPlan.click();
			}else if (splan=="Tp") {
				selectTpPlan.click();
			}else if (splan=="Od") {
				selectOdPlan.click();
			}else {
				System.out.println("plan not present");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void selectcase() throws IOException {
		CaseNewRenew(ExcelUtils.getMapData("Case"));
	}

	public void CaseNewRenew(String plan) {

		try {
			
			//String plan = ExcelUtils.getMapData("Case");
			
			if(plan.equalsIgnoreCase("Renew")) {
				renewLink.click();
			}else {

				newLink.click();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
			e.printStackTrace();
		}

	}

	public void selectmmfv() throws Exception {
		//"HONDA,CITY,Petrol,1.5 S MT (1497CC)
		selectMake();
		selectModel();
		selectFuel();
		selectVariant();

	}



	public void selectMake() throws Exception {

		clickEle(selectMMVfield);
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//img[@id = '"+ ExcelUtils.getMapData("Make") +"']"))));
			try {
				BasePage.ngdriver.waitForAngularRequestsToFinish();
				driver.findElement(By.xpath("//img[@id= '"+  ExcelUtils.getMapData("Make") +"']")).click();
			} catch (WebDriverException e) {
				System.out.println("An exceptional.case Make element not found");
			}
		} catch (TimeoutException e) {
			System.out.println("WebDriver couldn’t locate the Make element");
		}		
	}

	public void selectModel() throws Exception {

		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[@id='Modelval' and text()= '"+ ExcelUtils.getMapData("Model") + "']"))));
			try {
				BasePage.ngdriver.waitForAngularRequestsToFinish();
				driver.findElement(By.xpath("//span[@id='Modelval'and text()= '" + ExcelUtils.getMapData("Model") + "'] ")).click();
			} catch (WebDriverException e) {
				System.out.println("An exceptional.case model element not found");
			}
		} catch (TimeoutException e) {
			System.out.println("WebDriver couldn’t locate the Model element");
		}	
	}

	public void selectFuel() throws Exception {

		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@id='"+ ExcelUtils.getMapData("FuelType") +"']"))));
			try {
				BasePage.ngdriver.waitForAngularRequestsToFinish();
				driver.findElement(By.xpath("//div[@id='"+ExcelUtils.getMapData("FuelType") +"'] ")).click();

			} catch (WebDriverException e) {
				System.out.println("An exceptional.case fuel element not found");
			}
		} catch (TimeoutException e) {
			System.out.println("WebDriver couldn’t locate the Model element");
		}	
	}


	public void selectVariant() throws IOException {


		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[contains(text(),'"+ ExcelUtils.getMapData("Variant")  +"')]"))));
			try {
				BasePage.ngdriver.waitForAngularRequestsToFinish();
				driver.findElement(By.xpath("//div[contains(text(),'"+ ExcelUtils.getMapData("Variant")  +"')]")).click();

			} catch (WebDriverException e) {
				System.out.println("An exceptional.case variant element not found");
			}
		} catch (TimeoutException e) {
			System.out.println("WebDriver couldn’t locate the variant element");
		}	
	}

	public void selectPlaceofReg() throws InterruptedException, IOException {


		clickEle(selectRegField);

		try {
			BasePage.ngdriver.waitForAngularRequestsToFinish();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[contains(text(),'"+ ExcelUtils.getMapData("State")   +"')]")).click();

		} catch (WebDriverException e) {
			System.out.println("An exceptional.case state not found");
		}
		try {
			BasePage.ngdriver.waitForAngularRequestsToFinish();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[contains(text(),'"+ ExcelUtils.getMapData("StateCode") +"')]")).click();

		} catch (WebDriverException e) {
			System.out.println("An exceptional.case stateCode not found");
		}


	}

	public void enterVehDetails() throws Exception {

		selectPlaceofReg();
		selectDateofReg();



	}

	public void selectDateofReg() throws Exception {
		BasePage.ngdriver.waitForAngularRequestsToFinish();
		Thread.sleep(2000);
		clickEle(selectDateofRegField);
		BasePage.ngdriver.waitForAngularRequestsToFinish();
		utility.DateFunction.selectDate(ExcelUtils.getMapData("SelectRegYear"),ExcelUtils.getMapData("SelectRegMonth"));
		BasePage.ngdriver.waitForAngularRequestsToFinish();
		utility.DateFunction.selectDay(ExcelUtils.getMapData("SelectRegDay"));
	}

	public void enterExistingPolicyDetails() throws Exception {
		BasePage.ngdriver.waitForAngularRequestsToFinish();
		boolean polstatus = policyExist();
		if (polstatus) {

			clickEle(selectCpExistYes);

		}else {
			clickEle(selectCpExistNo);
			clickEle(selectCpNoPopup);
		}

		BasePage.ngdriver.waitForAngularRequestsToFinish();
		selectPolicyExpDate(ExcelUtils.getMapData("SelectPolicyExpYear"), ExcelUtils.getMapData("SelectPolicyExpMonth"), ExcelUtils.getMapData("SelectPolicyExpDay"));
		BasePage.ngdriver.waitForAngularRequestsToFinish();
		clickEle(selectPreInsFld);
		BasePage.ngdriver.waitForAngularRequestsToFinish();
		WebElement preInsj = driver.findElement(By.xpath("//select[@id='PreviousINS']/option[contains(text(),'" + ExcelUtils.getMapData("SelectPreviousInsurer") + "')]"));
		handleDropDown(preInsOptions, preInsj, ExcelUtils.getMapData("SelectPreviousInsurer"));
		//handleDropDown(preInsj, preIns);
		//driver.findElement(By.xpath("//select[@id='PreviousINS']/option[contains(text(),'" + preIns + "')]")).click();
		selectNcbOption();
		enterPsnlDetails(ExcelUtils.getMapData("EnterFullName"),ExcelUtils.getMapData("EnterMobileNo"),ExcelUtils.getMapData("EnterEmailId"));
		submitInput();
		



	}

	public void selectPolicyExpDate(String Year,String Month, String Day) throws Exception {

		clickEle(selectExpDateFld);
		utility.DateFunction.selectDate(Year, Month);
		utility.DateFunction.selectDay(Day);



	}

	public boolean policyExist() throws IOException {
		
		boolean polstatus = false;
		if(ExcelUtils.getMapData("SelectComprehensivePolicy").equalsIgnoreCase("Yes")) {
			polstatus = true;
			System.out.println("Comp policy already exist");
		}else {
			polstatus = false;
			System.out.println("Comp pol not exist");
		}

		return polstatus;


	}
	
	public boolean ncbYNo(String CpYesNo) {
		boolean Polexist = false;

		if(CpYesNo == "Yes") {
			Polexist = false;
			System.out.println("Comp policy already exist");
		}else if (CpYesNo == "No") {
			Polexist = true;
			System.out.println("Comp pol not exist");
		}

		return Polexist;


	}

	public void selectNcbOption() throws Exception {

		//boolean ncbStat = ncbYNo(ncbyn);

		if(ExcelUtils.getMapData("SelectClaimOnLastYearPolicy").equalsIgnoreCase("No")) {
			Thread.sleep(1500);
			clickEle(selectNcbNoopn);
			handleDropDown(NcbOption,selectCPlan, ExcelUtils.getMapData("SelectNcbPerc"));
		} else {
			clickEle(selectNcbYesopn);

		}

	}

	public void enterPsnlDetails(String FullName,String Mobile,String Email) {

		enterFullName.sendKeys(FullName);
		enterMobileNo.sendKeys(Mobile);
		enterEmailId.sendKeys(Email);
		
	}
	
	public boolean isLogin(String loginyn) {
		
		boolean loginy = false;
		
		if(loginyn == "Yes") {
			loginy=true;
		} else {
			loginy=false;
		}
		return loginy;
	}

	
	public void submitInput() throws InterruptedException, Exception {
		
		//boolean islogn = isLogin(loginyn);
		if(ExcelUtils.getMapData("Login").equalsIgnoreCase("Yes")) {
			clickEle(clickSubmit);
		}else {
			clickEle(clickSubmit);
			Thread.sleep(1500);
			clickEle(enterOtp);
			enterOtp.sendKeys("8888");
			clickEle(clickVerifyotpbtn);
			
		}
	}





}
