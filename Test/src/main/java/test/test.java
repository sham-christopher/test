package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.ChromeDriverManager;

import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class test {
	
    static //Insert userids into a list
    ArrayList<Object> UserIDs = new ArrayList<>();
	static String URL = "http://www.google.com";
	String Browser = "Chrome";
	static WebDriver driver;
	static String filePath = "C:\\Users\\Jonappan\\Desktop";
	static String fileName = "test.xls";
	
	public static void main(String[] args) throws IOException {

	    //Call read file method of the class to read data
		readExcel(filePath,fileName);
	    System.out.println("\n"+UserIDs);

	    for(int i=0;i<UserIDs.size();i++) {
			launchBrowser();
			WebElement username =  driver.findElement(By.id("lst-ib"));
			System.out.println("Entering "+ UserIDs.get(i));
			String UserID = UserIDs.get(i).toString();
			username.sendKeys(UserID);
			
			driver.findElement(By.id(id))
		}
		
}

	public static void readExcel(String filePath,String fileName) throws IOException{

	    //Create an object of File class to open xlsx file
	    File file =    new File(filePath+"\\"+fileName);

	    //Create an object of FileInputStream class to read excel file
	    FileInputStream inputStream = new FileInputStream(file);
	    Workbook Workbook = null;

	    //Find the file extension by splitting file name in substring  and getting only extension name
	    String fileExtensionName = fileName.substring(fileName.indexOf("."));

	    //Check condition if the file is xls file
	    if(fileExtensionName.equals(".xls")){
	        //If it is xls file then create object of XSSFWorkbook class
	        Workbook = new HSSFWorkbook(inputStream);
	    }

	    //Read sheet inside the workbook by its name
	    Sheet Sheet = Workbook.getSheet("Sheet1");

	    //Find number of rows in excel file
	    int rowCount = Sheet.getLastRowNum()-Sheet.getFirstRowNum();

	    //Create a loop over all the rows of excel file to read it
	    for (int i = ; i < rowCount+1; i++) {
	        Row row = Sheet.getRow(i);
	        //System.out.print(row.getCell(0).toString()+"\n");
            UserIDs.add(row.getCell(0).toString());
            System.out.println(UserIDs);
	    }
	}
	
	public static void launchBrowser() {
		System.out.println("Initialising Chrome driver");
		
		//Open Chrome in Incognito mode
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		
		//Navigate to the Website
		ChromeDriverManager.getInstance().setup();
		driver = new ChromeDriver(capabilities);
		System.out.println("Driver used is "+ driver);
		System.out.println("Navigating to "+URL);
		driver.navigate().to(URL);
		driver.manage().window().maximize();
	}
}
