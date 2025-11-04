package pom;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {
	
	private WebDriver driver ;
	
	PageBase(WebDriver d){
		this.driver = d;
	}
	
	public String GetPageTitle() {
		return driver.getTitle();
	}
	
	WebElement waitForElement(By by  ){
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		.pollingEvery(Duration.ofMillis(10))
		.withTimeout(Duration.ofSeconds(10))
		.ignoring(Exception.class)
		.withMessage("Element not loaded after 10 seconds");
		
		WebElement ele = null;
		
		ele = wait.until(d1 -> {
			WebElement ele1 = d1.findElement(by);
			if(ele1 == null) {
				System.out.println("Element not found");
			}else if(ele1.isDisplayed()){
				System.out.println("Element found");
			}
			return ele1;		
			
		});
		new Actions(driver).moveToElement(ele,0,200);
		return ele;
	}
	
	<T> T waitForElement(ExpectedCondition<T> exp){
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(10));
		return wait.until(exp);
	}
	
	void acceptAlert() {
		try {
			Alert x = waitForElement(ExpectedConditions.alertIsPresent());
			x.accept();
		}
		catch(NoAlertPresentException | TimeoutException ex) {
			System.out.println("Alert Not Present");
		}
	}
	
	void scrollElement(By by) {
		WebElement ele = waitForElement(by);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",ele);
	}
}
