import static org.testng.Assert.assertTrue;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ArticlePageNavigation {
	public static void main(String args[]) {

        System.setProperty("webdriver.chrome.driver","E:\\6th SEMESTER\\Test Automation\\Lab Work\\Softwares\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.navigate().to("https://www.ajio.com");  
	    
		WebElement search = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/header/div[3]/div[2]/form/div/div/input"));
		search.sendKeys("NIKE Revolution 5 Lace-Up Sports Shoes");
		  
		WebElement searchbutton = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/header/div[3]/div[2]/form/div/button/span"));
		searchbutton.click();

		WebElement image = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div/div[2]/div[2]/div[3]/div[1]/div/div[1]/a/div/div[1]/img"));
		image.click();
		
		ArrayList<String> nTabs = new ArrayList<String>(driver.getWindowHandles());
		System.out.println("No of Tabs: " + nTabs.size());
		driver.switchTo().window(nTabs.get(1));
		
		//For MRP
		WebElement mrpElement = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div[2]/div/div[3]/div/div[1]/div"));
		boolean mrp = mrpElement.isDisplayed();
		System.out.println("mrpElement is dispayed: "+ mrp);
		String txt = mrpElement.getText(); 
		System.out.println("Original price is: " + txt);
		
		//For Description
		WebElement about = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div[2]/div/div[3]/div/section/h3"));
		boolean text = about.isDisplayed();
		System.out.println("Tag is displayed: " + text);
		
		//For Add to bag button
		WebElement bagbtn = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div[2]/div/div[3]/div/div[9]/div[1]/div[1]/div/span[2]"));
		boolean bag = bagbtn.isDisplayed();
		System.out.println("Add to bag button is displayed:  "+ bag);

		//Save to closet button
		WebElement closetbtn = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div[2]/div/div[3]/div/div[9]/div[2]"));
		boolean closet = closetbtn.isEnabled();
		System.out.println("Save to closet button is visible:  "+ closet);
		
	}
}
