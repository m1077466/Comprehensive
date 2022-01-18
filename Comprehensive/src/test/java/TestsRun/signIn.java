package TestsRun;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.SignIn;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterTest;

import Resources.Base;

public class signIn extends Base{
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void runSignIn() throws IOException
	{
		Logger log = LogManager.getLogger(signIn.class);
        PropertyConfigurator.configure("log4j.properties");
		
		//Taking data from excel file
		FileInputStream fileInput = null;
		File search = new File("C:\\Users\\M1077466\\eclipse-workspace\\Comprehensive\\src\\test\\java\\ExcelSheet\\DataRHy.xlsx");
		FileInputStream fis = new FileInputStream(search);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		String Email = sheet.getRow(1).getCell(0).getStringCellValue();
		String Password = sheet.getRow(1).getCell(1).getStringCellValue();
		
		
		SignIn s = new SignIn(driver);
		s.Sign().click();
		s.Email().sendKeys(Email);
		s.Pass().sendKeys(Password);
		s.Login().click();
		System.out.println(s.Error().isDisplayed());
		System.out.println(s.Error().getText());
		log.info("Sign in with details");
	}
	
	 @AfterTest
	public void teardown()
	{
		driver.close();
		driver = null;
	} 
}
