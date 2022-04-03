package MyAngularpos.AngularPos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.paulhammant.ngwebdriver.NgWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class QuotePage {
	
	public static WebDriver driver;
	public static int noofinslist;
	public static String inskeyvalue1;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		NgWebDriver ngdriver = new NgWebDriver(js);
		driver.get("https://www.policyboss.com/Motor/quotes?SID=SRN-SNR2D9TY-TEHY-2VFX-MCQR-9TPXSGJQRX06_4924776&ClientID=2");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//p[contains(text(),"I DON'T REMEMBER MY VEHICLE NO")]
		Thread.sleep(5000);
		System.out.println(getinsCount());
		System.out.println("value from main " + isInsPresent("tata"));
		buyIns("tata");
		Thread.sleep(5000);
		System.out.println(noofinslist);
		driver.close();
		
	}
	
	/*
	 * public static boolean isinsurerpresent(boolean instextvalue) {
	 * 
	 * boolean Ispresent=false; for(int i = 0;) if(instextvalue)
	 * 
	 * 
	 * return Ispresent;
	 * 
	 * }
	 */
	
	public static int getinsCount() {
	  List<WebElement> insurer = driver.findElements(By.xpath("//div[@class='quoteBox ng-star-inserted'][contains(@id, \"insurer\")]"));
	  int insSize = insurer.size();
	  System.out.println("insurer size is "+ insurer.size());
	return insSize;
	}
	
	//@SuppressWarnings("null")
	public static Map<Integer, String> getinsnames() {
		Map<Integer, String> lismap = new HashMap<Integer, String>();
		int inscount = getinsCount();
		String insname;
		List<String> listofinsname = new ArrayList<String>();
		
		for(int i=0;i<inscount;i++) {
			 List<WebElement> insurers = driver.findElements(By.xpath("//div[@class='quoteBox ng-star-inserted'][contains(@id, \"insurer\")]/div[1]/span/img"));
			 String insid = driver.findElements(By.xpath("//div[contains(@id, 'insurer')]")).get(i).getAttribute("id");
			 //System.out.println(insurers.get(i).getAttribute("src"));
			 String insurl = insurers.get(i).getAttribute("src");
			 String[] insarray = insurl.split("/");
			 int insarrylen = insarray.length;
			// System.out.println(insarrylen);
			 //System.out.println(insarray[5]);
			 insname = insarray[5];
			 //System.out.println(insname);
			 String[] insn = insname.split("\\.");
			 System.out.println(insn[0]);
			 String addinsname = insn[0];
			 addinsname.concat("/"+insid);
			 lismap.put(i,addinsname);
			}
			return lismap;
		}
	
	@SuppressWarnings("unlikely-arg-type")
	public static boolean isInsPresent(String svalue) {
		Map<Integer, String> lisofinsname = getinsnames();
		System.out.println("==========================");
		boolean inspresent = false;
		for(int i = 0;i<lisofinsname.size();i++) {
			
			String somevalue = lisofinsname.get(i);
			System.out.println(somevalue);
			String valueofins = svalue;
			if(somevalue.contains(svalue)) {
				System.out.println(svalue+ "ins present");
				inspresent = true;
				noofinslist=i;
				inskeyvalue1=somevalue;
				System.out.println(inskeyvalue1);				
				break;
				
			}
			noofinslist++;
			System.out.println("insurance is not present");
		}
		//System.out.println(inspresent);
		return inspresent;
	}
	
	public static void buyIns(String svalue) {
		Map<Integer, String> lisofinsname = getinsnames();
		System.out.println("==========================");
		boolean inspresent = false;
		for(int i = 0;i<lisofinsname.size();i++) {
			
			String somevalue = lisofinsname.get(i);
			System.out.println(somevalue);
			String valueofins = svalue;
			//List<WebElement> premlist = driver.findElements(By.xpath("//span[@class='btn_box']/span[1]"));
			//List<WebElement> premlist2 = driver.findElements(By.xpath("//span[@class='btn_box']/div[1]"));
			List<WebElement> tolele = driver.findElements(By.xpath("//div[contains(@id, 'insurer')]"));
			System.out.println(tolele.get(i).getAttribute("id"));
			//premlist.addAll(premlist2);
			if(svalue.contains(inskeyvalue1)) {
				//div[contains(@id, 'insurer')]/div[4]/span[1]/div[1]
				
				WebElement elepre = tolele.get(6).findElement(By.xpath("//span[@class='btn_box']/div[1]"));
				if(elepre.isDisplayed()) {
					elepre.click();
				}else {
					tolele.get(6).findElement(By.xpath("//span[@class='btn_box']/span[1]")).click();
				}
				
		}
		//span[@class='btn_box']/span[1]
		//span[@class='btn_box']/div[1]
		
	}
	
	
	
	

}
}
