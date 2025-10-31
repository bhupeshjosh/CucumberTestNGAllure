package pom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TablePage extends PageBase{
	private WebDriver driver ;
	private WebDriverWait wait = null;
	
	public TablePage(WebDriver d) {
		super(d);
		this.driver = d;		
	}
	
	private By activerows = By.xpath("//span[@title='Delete']");
	private By deleteRow = By.xpath("//div[./div[text()='Kierra']]//span[@title='Delete']");
	
	public void deleteRow(){
		System.out.println("############Row count Before = "+ getActiveRowsCount());
		WebElement delRow = driver.findElement(deleteRow);
		new Actions(driver).scrollToElement(delRow).scrollByAmount(0,200).moveToElement(delRow).click().build().perform();
		//driver.findElement(deleteRow).click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(deleteRow));
		System.out.println("#############Row count AFter delete = "+ getActiveRowsCount());		
	}
	
	private int getActiveRowsCount() {
		return driver.findElements(activerows).size();
	}

}
