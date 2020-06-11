package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 15L);

		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="/html/body/div[4]/div[1]/div[1]/div[4]/a[2]")
	WebElement manageJenkinsButton;
	
	public void clickManageJenkins() {
		manageJenkinsButton.click();
	}

}
