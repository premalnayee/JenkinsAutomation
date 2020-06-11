package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateUserFormPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public CreateUserFormPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 15L);

		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id=\"username\"]")
	WebElement usernameBox;
	
	@FindBy(xpath = "/html/body/div[4]/div[2]/form/div[1]/table/tbody/tr[2]/td[2]/input")
	WebElement passwordBox;
	
	@FindBy(xpath = "/html/body/div[4]/div[2]/form/div[1]/table/tbody/tr[3]/td[2]/input")
	WebElement confirmPasswordBox;
	
	@FindBy(xpath = "/html/body/div[4]/div[2]/form/div[1]/table/tbody/tr[4]/td[2]/input")
	WebElement fullnameBox;
	
	@FindBy(xpath = "/html/body/div[4]/div[2]/form/div[1]/table/tbody/tr[5]/td[2]/input")
	WebElement emailBox;
	
	@FindBy(xpath = "//*[@id=\"yui-gen1-button\"]")
	WebElement createUserBox;
	
	public void fillInForm(String username, String password, String fullName, String emailAddress) {
		usernameBox.sendKeys(username);
		passwordBox.sendKeys(password);
		confirmPasswordBox.sendKeys(password);
		fullnameBox.sendKeys(fullName);
		emailBox.sendKeys(emailAddress);
		
		createUserBox.click();
	}
	
}
