package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String URL = "http://www.google.com";
		String Browser = "Chrome";
		WebDriver driver;
/*		
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
*/		
		String filePath = "C:\\Users\\Jonappan\\Desktop";
		String fileName = "test.xls";

	    //Call read file method of the class to read data
		readExcel(filePath,fileName);
		
}

	public static void readExcel(String filePath,String fileName) throws IOException{

	    //Create an object of File class to open xlsx file

	    File file =    new File(filePath+"\\"+fileName);

	    //Create an object of FileInputStream class to read excel file

	    FileInputStream inputStream = new FileInputStream(file);

	    Workbook guru99Workbook = null;

	    //Find the file extension by splitting file name in substring  and getting only extension name

	    String fileExtensionName = fileName.substring(fileName.indexOf("."));

	    //Check condition if the file is xlsx file
/*
	    if(fileExtensionName.equals(".xlsx")){

	    //If it is xlsx file then create object of XSSFWorkbook class

	    guru99Workbook = new XSSFWorkbook(inputStream);

	    }
*/
	    //Check condition if the file is xls file

	    if(fileExtensionName.equals(".xls")){

	        //If it is xls file then create object of XSSFWorkbook class

	        guru99Workbook = new HSSFWorkbook(inputStream);

	    }

	    //Read sheet inside the workbook by its name

	    Sheet guru99Sheet = guru99Workbook.getSheet("Sheet1");

	    //Find number of rows in excel file

	    int rowCount = guru99Sheet.getLastRowNum()-guru99Sheet.getFirstRowNum();

	    //Create a loop over all the rows of excel file to read it

	    for (int i = 0; i < rowCount+1; i++) {

	        Row row = guru99Sheet.getRow(i);

	        //Create a loop to print cell values in a row

	        for (int j = 0; j < row.getLastCellNum(); j++) {

	            //Print Excel data in console

	            System.out.print(row.getCell(j).getStringCellValue()+"|| ");

	        }

	        System.out.println();

	    }

	    

	    }

	    
/*
	    //Main function is calling readExcel function to read data from excel file

	    public static void main(String...strings) throws IOException{

	    //Create an object of ReadGuru99ExcelFile class

	    ReadGuru99ExcelFile objExcelFile = new ReadGuru99ExcelFile();

	    //Prepare the path of excel file

	    String filePath = System.getProperty("user.dir")+"\\src\\excelExportAndFileIO";

	    //Call read file method of the class to read data

	    objExcelFile.readExcel(filePath,"ExportExcel.xlsx","ExcelGuru99Demo");

	    }

	}
*/	
}
