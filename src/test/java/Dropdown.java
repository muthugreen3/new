import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;
public class Dropdown {
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://greenscart.in/#/login?returnUrl=%2F");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		WebElement register = driver.findElement(By.xpath("//input[@value='Register']"));
				register.click();
				WebElement month = driver.findElement(By.id("month"));
		month.click();
				Select select = new Select(month);
		List<WebElement> options = select.getOptions();
// for (WebElement x : options) {
//	String attribute2 = x.getAttribute("value");
//	Syse3tem.out.println(attribute2);
		File file = new File("C:\\Users\\muthu\\eclipse-workspace\\ProjectExcelScroll\\Excelfile\\muthugreen.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook1 = new XSSFWorkbook(stream);
		Sheet sheet = workbook1.getSheet("Muthu");
		
		for (int i = 0; i <options.size(); i++) {
			WebElement element = options.get(i);
			String text = element.getText();
			Row createRow = sheet.createRow(i);
			Cell cell = createRow.createCell(0);
			
			cell.setCellValue(text);
			System.out.println(text);
			
			
			
			
//			Row createRow = sheet.createRow(i);
////			Cell cell = row.getCell(i);
//		Cell cells = createRow.createCell(j);
//		cells.setCellValue(attribute2);
	}
		FileOutputStream o = new FileOutputStream(file);
		workbook1.write(o);

		System.out.println("completed");
	
}
}