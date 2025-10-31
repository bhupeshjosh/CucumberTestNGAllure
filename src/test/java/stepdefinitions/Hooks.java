package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import pom.PomManager;

public class Hooks {
	private WebDriver d;
	private PomManager p;

	
	public Hooks() {
		System.out.println("************Hooks constructor called************");
	}
	public WebDriver getdriver() {
		return this.d;
	}
	
	public PomManager getPOM() {
		return this.p;
	}
		
	@Before
	public void CreateWebDriverInstance(Scenario s) {
		System.out.println("************Setting driver instance in container************");
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		d = new ChromeDriver(option);
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		p = new PomManager(d);	
	}	

	@After
	public void cleanup() {		
		System.out.println("************Quit driver instance in container************");
		d.quit();
	}

	
	@Attachment(value = "screenshot", type = "image/png", fileExtension = ".png")
	public byte[] getScreenshot() {
	  return((TakesScreenshot)d).getScreenshotAs(OutputType.BYTES);
	}
	
}
