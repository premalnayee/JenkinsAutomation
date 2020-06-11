package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManagePage {

	WebDriver driver;
	WebDriverWait wait;
	
	public ManagePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 15L);

		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="/html/body/div[4]/div[2]/div[16]/a/dl/dt")
	WebElement manageUsersButton;
	
	public void clickManageUsers() {
		manageUsersButton.click();
	}
	
}
