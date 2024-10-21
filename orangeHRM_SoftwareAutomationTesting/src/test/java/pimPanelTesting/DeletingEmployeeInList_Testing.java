package pimPanelTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import securityTesting.AuthenticationTesting;

public class DeletingEmployeeInList_Testing {
	static WebElement element;
	
	public static void deleteEmployee(WebDriver driver, String employeeName) {
		try {
			//search for the employee
			String searchResult = SearchingEmployeeInList_Testing.searchUsingName(driver, employeeName);
			Thread.sleep(3000);
			if(!searchResult.equals("No Records Found")) {
				Thread.sleep(2000);
				element = driver.findElements(By.xpath("//button[@class='oxd-icon-button oxd-table-cell-action-space']")).get(1);
				element.click();
				Thread.sleep(2000);
				element = driver.findElement(By.xpath("/html/body/div/div[3]/div/div/div/div[3]/button[2]"));
				element.click();
				Thread.sleep(2000);
				System.out.println("Element is deleted");
			}else {
				System.out.println("No Records Found");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		try {
			WebDriver driver = new ChromeDriver();
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			
			Thread.sleep(5000);			
			//login into the web-site as admin-dashbord
			AuthenticationTesting.logIn(driver, "Admin", "admin123");
			
			Thread.sleep(5000);		
			//create a sample employee and add it to the list
			AddEmployeeToList_Testing.addNewUserLoginDisabled(driver, "sample111", "", "1");
			
			Thread.sleep(5000);
			//delete the employee from the list
			deleteEmployee(driver, "sample111");
			
			Thread.sleep(2000);
			
			AuthenticationTesting.logOut(driver);
			
			Thread.sleep(8000);
			
			driver.quit();
			
		}catch(Exception error) {
			error.printStackTrace();
		}
	}

}
