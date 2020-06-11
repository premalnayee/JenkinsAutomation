package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManageUsersPage {

	WebDriver driver;
	WebDriverWait wait;
	ArrayList<String> webUserNames = new ArrayList<String>();
	List<WebElement> webUsers = driver.findElements(By.xpath("//*[@id=\"people\"]/tbody/tr[*]/td[2]/a"));
	
	public ManageUsersPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 15L);

		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="/html/body/div[4]/div[1]/div/div[3]/a[2]")
	WebElement createUserButton;
	
	@FindBy(xpath = "//*[@id=\"main-panel\"]/h1")
	WebElement title;
	
	public boolean areWeThereYet() {
		return title.getText().equals("Users");
	}
	
	public void clickCreateUser() {
		createUserButton.click();
	}
	
	public boolean findParticularUser(String username) {

		for (WebElement webUser : webUsers) {
			webUserNames.add(webUser.getText());
		}

		return webUserNames.contains(username);
	}
	
	public void clickUserName(String username) {
		if(findParticularUser(username)) {
			int userIndex = webUserNames.indexOf(username);
			
			 webUsers.get(userIndex).click();
		}
	}
}
