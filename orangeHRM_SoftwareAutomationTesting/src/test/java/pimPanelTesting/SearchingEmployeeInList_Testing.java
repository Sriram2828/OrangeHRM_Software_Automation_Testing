package pimPanelTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import securityTesting.AuthenticationTesting;

public class SearchingEmployeeInList_Testing {
	
	static WebElement element;
	
	//method to search employee using name
	public static String searchUsingName(WebDriver driver, String employeeName) {
		String searchResult = "";
		try {
			//navigate to Pim-panel
			element = driver.findElement(By.xpath("//a[@href='/web/index.php/pim/viewPimModule']"));
			element.click();
			
			Thread.sleep(5000);
			//giving the input for search
			element = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div/input"));
			element.sendKeys(employeeName);
			driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]")).click();
			Thread.sleep(8000);
			searchResult = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/span")).getText();
		}catch(Exception error) {
			error.printStackTrace();
		}
		return searchResult;
	}
	
	public static void main(String[] args) {
		try {
			WebDriver driver = new ChromeDriver();
			
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			
			Thread.sleep(3000);
			
			//calling the login function from AddEmployeeToList_Testing file
			AuthenticationTesting.logIn(driver, "admin", "admin123");
			
			Thread.sleep(3000);			
			//Adding an employee in the employee list 
			AddEmployeeToList_Testing.addNewUserLoginDisabled(driver, "aaa", "bbb", "ccc");
			
			Thread.sleep(3000);
			//calling the search function using employee name
			System.out.println(searchUsingName(driver, "aaa"));
			
			Thread.sleep(2000);
			
			AuthenticationTesting.logOut(driver);
			
			Thread.sleep(8000);
			
			driver.quit();
			
		}catch(Exception error) {
			error.printStackTrace();
		}
	}

}
