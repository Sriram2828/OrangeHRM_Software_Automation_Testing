package securityTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthenticationTesting {
	static WebElement element;
	public static void logOut(WebDriver driver) {
		
		try {
			//clicking the logout option
			element = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/header/div[1]/div[3]/ul/li/span/i"));
			element.click();
			Thread.sleep(3000);
			element = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/header/div[1]/div[3]/ul/li/ul/li[4]/a"));
			element.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void logIn(WebDriver driver, String username, String password) {
		
		try {
			//selecting the element for login
			element = driver.findElement(By.xpath("//input[@name='username' and @placeholder='Username']"));
			element.sendKeys(username);
			element = driver.findElement(By.xpath("//input[@name='password' and @placeholder='Password']"));
			element.sendKeys(password);
			//select the login button
			element = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
			element.click();
			
			Thread.sleep(2000);
			if((username.equals("Admin") || username.equals("admin")) && password.equals("admin123")) {
				System.out.println("Successfully logged-in as Administrator");
			}else {
				System.out.println("Successfully logged-in as user("+username+")");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		try {
			WebDriver driver = new ChromeDriver();
			
			//use the get method to go to the specified URL in the browser
			String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
			driver.get(url);
			
			//generating the multiple test-cases to test the authentication part Credentials user-name:password
			String[] username = {"user","User","Username","uname","Admin","root","admin"};
			String[] password = {"user123","User098","Password123","passwd1234","admin123","root","admin"};
			
			Thread.sleep(5000);
			
			String validUsername = "";
			String validPassword = "";
			
			//checking for the valid credentials
			for(int i=0; i<username.length; i++) {
				//selecting the element for user-name
				element = driver.findElement(By.xpath("//input[@name='username' and @placeholder='Username']"));
				element.sendKeys(username[i]);
				//selecting the element for password
				element = driver.findElement(By.xpath("//input[@name='password' and @placeholder='Password']"));
				element.sendKeys(password[i]);
				//select the login button
				element = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
				element.click();
				
				Thread.sleep(4000);
				
				//verifying
				if(!url.equals(driver.getCurrentUrl())) {
					System.out.println("Valid Credentials -> Username=>"+username[i]+" Password=>"+password[i]);
					validUsername = username[i];
					validPassword = password[i];
					
					logOut(driver);//calling the user-defined function for logout
					
				}else{
					//error message
					element = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p"));
					String errmsg = element.getText();
					System.out.println(errmsg);
					driver.navigate().refresh();
				}
				
				Thread.sleep(4000);
			}
			
			Thread.sleep(5000);
			
			logIn(driver, validUsername, validPassword);//calling the user-defined function for login
			
			Thread.sleep(10000);
			
			driver.quit(); //terminate all the open window and Sessions 
			
		}catch(Exception error) {
			error.printStackTrace();
		}
	}

}