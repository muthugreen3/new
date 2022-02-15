import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseClass {

	WebDriver driver;

	public WebElement findLocatorById(String AttributeValue) {
		WebElement element = driver.findElement(By.id("AttributeValue"));
		return element;

	}

	public WebElement findLocatorByName(String AttributeValue) {

		WebElement element = driver.findElement(By.name("AttributeValue"));
		return element;

	}

	public void btn(WebElement element) {
		element.click();
	}

	public void key(WebElement element, String name) {
		element.sendKeys("name");
	}

}
