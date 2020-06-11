package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 15L);

		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(id="j_username")
	WebElement userNameBox;
	
	@FindBy(xpath="/html/body/div/div/form/div[2]/input")
	WebElement passwordBox;
	
	@FindBy(xpath="/html/body/div/div/form/div[3]/input")
	WebElement signIn;
	
	@FindBy(xpath="//*[@id=\"loginIntroDefault\"]/h1")
	WebElement welcomeMessage;
	
	public boolean areWeThereYet() {
		try {
			wait.until(ExpectedConditions.textToBePresentInElement(welcomeMessage, "Welcome to Jenkins!"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return false;
		}
		
		return true;
	}
	
	public void clickLogIn(String username, String password) {
		userNameBox.sendKeys(username);
		passwordBox.sendKeys(password);
		signIn.click();
	}
}
