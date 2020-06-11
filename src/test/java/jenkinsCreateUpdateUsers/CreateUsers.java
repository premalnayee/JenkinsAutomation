package jenkinsCreateUpdateUsers;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import pages.CreateUserFormPage;
import pages.LandingPage;
import pages.LoginPage;
import pages.ManagePage;
import pages.ManageUsersPage;

public class CreateUsers {
	
	WebDriver driver;
	private static ExtentReports report;
	private ExtentTest test;
	
	ArrayList<String> usernames = new ArrayList<String>();
	ArrayList<String> fullName = new ArrayList<String>();
	ArrayList<String> passwords = new ArrayList<String>();
	ArrayList<String> emailaddress = new ArrayList<String>();
	
	@BeforeClass
	public static void setup() {
		report = new ExtentReports();
		ExtentHtmlReporter htmlReport = new ExtentHtmlReporter("test-reports/CreateUser/extentReport.html");
		htmlReport.config().setAutoCreateRelativePathMedia(true);
		report.attachReporter(htmlReport);
	}
	
	@Before
	public void init() {
		driver = new ChromeDriver();
	}

	@Test
	public void createUsers() {
		
		// Get the usernames and passwords from the excel sheet
		try {
			readExcel("AssessmentFriday.xls", "C:\\Users\\premal\\Google Drive\\QAC\\Melium\\JenkinsAutomation", "Sheet1");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		driver.get("http://localhost:8080/");
		LoginPage loginPage = new LoginPage(driver);
		assertTrue(loginPage.areWeThereYet());
		
		loginPage.clickLogIn("NTortImp", "alG20$m$x2BvG^X^NAa3");
		
		LandingPage landingPage = new LandingPage(driver);
		landingPage.clickManageJenkins();
		ManagePage managePage = new ManagePage(driver);
		managePage.clickManageUsers();
		
		for (int i=0; i<usernames.size(); i++) {
			ManageUsersPage manageUsersPage = new ManageUsersPage(driver);
			manageUsersPage.clickCreateUser();
			CreateUserFormPage createUserFormPage = new CreateUserFormPage(driver);
			createUserFormPage.fillInForm(usernames.get(i), passwords.get(i), fullName.get(i), emailaddress.get(i));
		}
	}
	
	public void readExcel(String fileName, String filePath, String sheetName) throws IOException {

		//		Create object of file

		File file = new File(filePath +"\\" + fileName);

		//		Create fileinputstream
		FileInputStream inputStream;

		inputStream = new FileInputStream(file);

		Workbook workbook;

		workbook = new HSSFWorkbook(inputStream);

		Sheet sheet = workbook.getSheet("Sheet1");

		int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();

		for (int i = 1; i < rowCount+1; i++) {

			Row row = sheet.getRow(i);

			// Assign values to array
			usernames.add(row.getCell(0).getStringCellValue());
			fullName.add(row.getCell(1).getStringCellValue());
			passwords.add(row.getCell(2).getStringCellValue());
			emailaddress.add(row.getCell(4).getStringCellValue());
			
			System.out.println(emailaddress.get(i-1).toString());
		}
	}

}
