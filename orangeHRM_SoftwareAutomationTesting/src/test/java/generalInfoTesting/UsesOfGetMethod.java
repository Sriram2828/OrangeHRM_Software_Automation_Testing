package generalInfoTesting;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class UsesOfGetMethod {

	public static void main(String[] args) {
		try {
			//setting-up the browser drivers
			WebDriver driver = new ChromeDriver();
			
			//use the get method to go to the specified URL in the browser
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			
			//get-current-url() method is used to get the current URL of the web-site
			String siteURL = driver.getCurrentUrl();
			System.out.println("current url of the site: "+siteURL);
			
			//get-title() method is used to get the title of the current web-site
			String siteTitle = driver.getTitle();
			System.out.println("\ntitle of the website: "+siteTitle);
			
			//get-page-source() method is used to get the entire page source and store in a string value
			String pageSource = driver.getPageSource();
			//System.out.println(pageSource);
			
			//get-window-handle() method is used to get the hexadecimal handle value of the current window
			String parentPage = driver.getWindowHandle();
			System.out.println("the hexa handle of the parent page: "+parentPage);
			
			Thread.sleep(3000);
			//click() action method
			WebElement element;
			element = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[3]/div[2]/p[2]/a"));
			element.click();
			
			//get-window-handles() method is used to get all the open window handles of the browser
			Set<String> handles = driver.getWindowHandles();
			
			//iterator object is used to enumerate all element in the collection 
			Iterator<String> iterate = handles.iterator();
			
			while(iterate.hasNext()) {
				String childPage = iterate.next();
				
				if(!parentPage.equals(childPage)) {
					driver.switchTo().window(childPage);
					
					System.out.println("\ntitle of the child page: "+driver.switchTo().window(childPage).getTitle());
					System.out.println("the hexa handle of the child page: "+childPage);
					
					driver.close();	// to only terminate the current window
				}
			}
			driver.switchTo().window(parentPage);
			
			Thread.sleep(10000); //to put the current execution in 8sec sleep
			
			driver.quit(); // closes the entire session and all browser	that is opened	
			
		}catch(Exception error) {
			error.printStackTrace();
		}
	}

}
