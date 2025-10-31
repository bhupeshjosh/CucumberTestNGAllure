package pom;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;



public class LoginPage extends PageBase{
	private WebDriver driver ;

	private By username = By.id("userName");
	private By password = By.id("password");
	private By btnLogin = By.id("login");
	private By deleteRow = By.xpath("//div[./div[text()='Kierra']]//span[@title='Delete']");
	private By element = By.xpath("//div[text()='Elements']");
	private By webTable = By.xpath("//span[text()='Web Tables']");
	private By logout = By.xpath("//button[@id='submit']");
	private By userlabel = By.xpath("//label[contains(text(),'User Name : ')]/following-sibling::label");

	LoginPage(WebDriver d) {
		// TODO Auto-generated constructor stub
		super(d);
		this.driver = d;
	}

	public void Launch() {
		driver.get("https://demoqa.com/login");		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.pollingEvery(Duration.ofMillis(10))
				.withTimeout(Duration.ofSeconds(10))
				.ignoring(Exception.class)
				.withMessage("Page not loaded after 10 seconds");

		Function<WebDriver , WebElement> f = (d) -> {
			System.out.println("ˍˍˍˍˍˍˍˍelement search start----------");
			WebElement e = d.findElement(btnLogin);
			if (e == null) {
				System.out.println("login btn not found");
			}

			if (e != null) {
				System.out.println("ˍˍˍˍˍˍˍˍelement search end----------");
			}			
			return e;			
		};

		wait.until(f);		
		System.out.println("***********login page found*************");		

	}
	
	
	public void loginWithCredentials(String arg1, String arg2) {
		new Actions(driver).scrollToElement(waitForElement(btnLogin)).scrollByAmount(0, 200).build().perform();
		waitForElement(username).sendKeys(arg1);
		waitForElement(password).sendKeys(arg2);				
	}
	
	public void clickLoginButton() {
		waitForElement(btnLogin).click();
		acceptAlert();
		waitForElement(ExpectedConditions.invisibilityOfElementLocated(btnLogin));
		
	}
	public void verifyUserLabel() {
		String ulabel = waitForElement(userlabel).getText();	
		Assert.assertEquals(ulabel, "testuser");
		if(ulabel.equals("testuser"));
		{
			System.out.println("User is logged in and HomePage is displayed");
		}
	}
	public void navigateToWebTable() {
		waitForElement(element).click();
		waitForElement(webTable).click();
		waitForElement(deleteRow);
	}

	public WebElement logout() {
		WebElement logoutButton = waitForElement(logout);
		logoutButton.click();
		WebElement userNameElement = waitForElement(username);
		return userNameElement;
	}

}
