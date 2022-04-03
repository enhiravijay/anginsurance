package MyAngularpos.AngularPos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.paulhammant.ngwebdriver.NgWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_quote {

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
		driver.get("https://www.policyboss.com/Motor/quotes?SID=SRN-CCBQRDUQ-T7V8-N19A-ZQVY-50QTILVBANMH_4953987&ClientID=2");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//p[contains(text(),"I DON'T REMEMBER MY VEHICLE NO")]
		Thread.sleep(5000);
		//System.out.println(getinsCount());
		//System.out.println("value from main " + isInsPresent("tata"));
		//buyIns("tata");
		Thread.sleep(5000);
		System.out.println(noofinslist);
		boolean bvalue = iselementpresent(getidvalue("chola"));
		//String insiddvalueis = getidvalue("tata");
		System.out.println(bvalue);
		buyIns("chola");
		Thread.sleep(5000);
		//getinsnames();
		//driver.close();

	}
		
	public static int getinsCount() {
		  List<WebElement> insurer = driver.findElements(By.xpath("//div[@class='quoteBox ng-star-inserted'][contains(@id, \"insurer\")]"));
		  int insSize = insurer.size();
		  System.out.println("insurer size is "+ insurer.size());
		return insSize;
		}
	
	@SuppressWarnings("unlikely-arg-type")
	public static boolean isInsPresent(String svalue) {
		Map<Integer, String> lisofinsname = getinsnames();
		System.out.println("==========================");
		boolean inspresent = false;
		for(int i = 0;i<lisofinsname.size();i++) {
			
			String somevalue = lisofinsname.get(i);
			System.out.println("somevalue is "+somevalue);
			String valueofins = svalue;
			if(somevalue.contains(svalue)) {
				System.out.println(svalue+ "ins present");
				inspresent = true;
				noofinslist=i;
				inskeyvalue1=somevalue;
				System.out.println("inskeyvalue is "+inskeyvalue1);				
				break;
				
			}
			noofinslist++;
			System.out.println("insurance is not present");
		}
		//System.out.println(inspresent);
		return inspresent;
	}
	
	public static Map<Integer, String> getinsnames() {
		Map<Integer, String> lismap = new HashMap<Integer, String>();
		StringBuilder str = new StringBuilder();
		int inscount = getinsCount();
		String insname;
		//List<String> listofinsname = new ArrayList<String>();
		
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
			 String arr;
			 String addinsname = insn[0];
				/*
				 * str.append(addinsname); str.append("/"); str.append(insid);
				 * System.out.println("to check insid"+insid);
				 * System.out.println("final addins name"+addinsname);
				 * System.out.println(str.toString()); arr = str.toString();
				 */
			 lismap.put(i,driver.findElements(By.xpath("//div[contains(@id, 'insurer')]")).get(i).getAttribute("id")+"/"+addinsname);
			 //arr="";
			 
			 
			 
			}
			return lismap;
		}
	
	public static String getidvalue(String svalue) {
		Map<Integer, String> mvalue = getinsnames();
		int insnum;
		String insidvalueis = null;
		for (Entry<Integer, String> entry : mvalue.entrySet()) {
            Integer k = entry.getKey();
            String v = entry.getValue();
           String[] vvalue=  v.split("/");
            String insname = vvalue[1];
            //System.out.println("Key: " + k + ", Value: " + v);
            if(insname.contains(svalue)) {
            	insidvalueis=vvalue[0];
            	break;
            	
            }
        }
		//return insidvalueis;
		return insidvalueis;
	}
	
	public static void buyIns(String yvalue) throws Exception {
		String insiddvalueis = getidvalue(yvalue);
		boolean bvalue = iselementpresent(insiddvalueis);
		if(bvalue) {
			System.out.println(insiddvalueis);
			//Object weele = driver.findElement(By.xpath("//div[@id='\"+insiddvalueis+\"' and @class='quoteBox ng-star-inserted'] /div[4]/span/div[1]")).click();
			 driver.findElement(By.xpath("//div[@id='"+insiddvalueis+"' and @class='quoteBox ng-star-inserted'] /div[4]/span/div[1]")).click();
			 Thread.sleep(2000);
			 driver.findElement(By.xpath("//div[@class='buyNow_btn ng-star-inserted']/span")).click();
			 
		}else {
			driver.findElement(By.xpath("//div[@id='"+insiddvalueis+"' and @class='quoteBox ng-star-inserted'] /div[4]/span/span[1]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@class='buyNow_btn ng-star-inserted']/span")).click();
		}
	}
	
	public static boolean iselementpresent(String id) {
		
		boolean idispresentt=false;
		int elesize = driver.findElements(By.xpath("//div[@id='"+id+"' and @class='quoteBox ng-star-inserted'] /div[4]/span/div[1]")).size();
		System.out.println(elesize);
		 if(driver.findElements(By.xpath("//div[@id='"+id+"' and @class='quoteBox ng-star-inserted'] /div[4]/span/div[1]")).size()!=0){
			    //THEN CLICK ON THE SUBMIT BUTTON
			 idispresentt=true;
			}else{
			    //DO SOMETHING ELSE AS SUBMIT BUTTON IS NOT THERE
			}
		return idispresentt;
	}
	//div[@id='\"+insiddvalueis+\"' and @class='quoteBox ng-star-inserted'] /div[4]/span/div[1]
	//div[@id='insurer_11' and @class='quoteBox ng-star-inserted'] /div[4]/span/div[1]
	

}
//Go_Digit,lvgi,kotak,raheja,chola,edelweiss,tata_aig,shriram,United,hdfc,new_india,Iffco_Tokio_General,BajajAllianzGeneral,