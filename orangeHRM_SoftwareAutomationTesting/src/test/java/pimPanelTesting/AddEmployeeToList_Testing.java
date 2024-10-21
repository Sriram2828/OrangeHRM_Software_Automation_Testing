package pimPanelTesting;

import securityTesting.AuthenticationTesting; // user define function

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddEmployeeToList_Testing {
	
	static WebElement element;
	
	//method to add a new user into the user-management
	public static void addNewUserLoginEnabled(WebDriver driver, String fName, String mName, String lName, String uName, String password, String confirmPassword){
		try { 
			// move to Pim-panel
			element = driver.findElement(By.xpath("//a[@href='/web/index.php/pim/viewPimModule']"));
			element.click();
						
			Thread.sleep(2000);
			//select the add employee button
			element = driver.findElement(By.xpath("html/body/div/div[1]/div[1]/header/div[2]/nav/ul/li[3]/a")); 
			element.click();
			
			Thread.sleep(4000);
			
			//fill the first name 
			element = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[1]/div/div/div[2]/div[1]/div[2]/input"));
			element.sendKeys(fName);
			
			//fill the middle name 
			element = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[1]/div/div/div[2]/div[2]/div[2]/input"));
			element.sendKeys(mName);
			
			//fill the last name 
			element = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[1]/div/div/div[2]/div[3]/div[2]/input"));
			element.sendKeys(lName);
			
			//enable the create login option
			element = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[2]/div/label/span"));
			element.click();
				
			Thread.sleep(2000);
				
			//fill the user name
			element = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[3]/div/div[1]/div/div[2]/input"));
			element.sendKeys(uName);
			//fill the password
			element = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[4]/div/div[1]/div/div[2]/input"));
			element.sendKeys(password);
			//fill the confirm password
			element = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[4]/div/div[2]/div/div[2]/input"));
			element.sendKeys(confirmPassword);
			
			//save the employee in the list
			element = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]"));
			element.click();
			
			Thread.sleep(10000);
			
			//validating the result checking for the mistakes in the user input
			String addEmpUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/pim/addEmployee";
			if(!addEmpUrl.equals(driver.getCurrentUrl())) {
				System.out.println("\n"+fName+" is added into Employee-list successfully");
			}else{
				System.out.println("\n");
				if(!password.equals(confirmPassword)) {
					System.out.println("Passwords do not match with the confirmPassword");
				}
				if(password.length()<7) {
					System.out.println("Should have at least 7 characters");
				}
				System.out.println("\nCheck for the incomplete required field");
			}
			
			Thread.sleep(2000);
			
			//back to the employee list page
			element = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/header/div[2]/nav/ul/li[2]/a"));
			element.click();
			
		}catch(Exception error) {
			error.printStackTrace();
		}
	}

	public static void addNewUserLoginDisabled(WebDriver driver, String fName, String mName, String lName){
		try { 
			// move to Pim-panel
			element = driver.findElement(By.xpath("//a[@href='/web/index.php/pim/viewPimModule']"));
			element.click();
						
			Thread.sleep(2000);
			//select the add employee button
			element = driver.findElement(By.xpath("html/body/div/div[1]/div[1]/header/div[2]/nav/ul/li[3]/a")); 
			element.click();
			
			Thread.sleep(4000);
		
			//fill the first name 
			element = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[1]/div/div/div[2]/div[1]/div[2]/input"));
			element.sendKeys(fName);
		
			//fill the middle name 
			element = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[1]/div/div/div[2]/div[2]/div[2]/input"));
			element.sendKeys(mName);
		
			//fill the last name 
			element = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[1]/div/div/div[2]/div[3]/div[2]/input"));
			element.sendKeys(lName);
			
			Thread.sleep(2000);	

			//save the employee in the list
			element = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]"));
			element.click();
		
			Thread.sleep(8000);
		
			//validating the result checking for the mistakes in the user input
			String addEmpUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/pim/addEmployee";
			if(!addEmpUrl.equals(driver.getCurrentUrl())) {
				System.out.println("\n"+fName+" is added into Employee-list successfully");
			}else{	
				System.out.println("\nCheck for the incomplete required field");
			}
		
			Thread.sleep(3000);
		
			//back to the employee list page
			element = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/header/div[2]/nav/ul/li[2]/a"));
			element.click();
		
		}catch(Exception error) {
			error.printStackTrace();
		}
	}
	

	public static void main(String[] args) {
		try {
			WebDriver driver = new ChromeDriver();
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			
			Thread.sleep(2000);
			
			AuthenticationTesting.logIn(driver, "Admin", "admin123");//calling the user-define function to login
			
			Thread.sleep(2000);
			
			//add a new user into the user-management 
			addNewUserLoginEnabled(driver, "xxx", "yyy", "zzz", "xyzxyz", "testuser123$567", "testuser123$567");
			
			Thread.sleep(2000);
			
			AuthenticationTesting.logOut(driver);//calling the logout function from the another file
			
			Thread.sleep(2000);
					
			AuthenticationTesting.logIn(driver, "xyzxyz", "testuser123$567");//calling the user-define function to login
			
			Thread.sleep(2000);
			
			AuthenticationTesting.logOut(driver);
			
			Thread.sleep(8000);
			
			driver.quit();
			
		}catch(Exception error) {
			error.printStackTrace();
		}
	}

}
