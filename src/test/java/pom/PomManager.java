package pom;

import org.openqa.selenium.WebDriver;

public class PomManager {

	private WebDriver d;
	
	public PomManager(WebDriver d) {
		this.d = d;
	}
	public LoginPage getLoginPage() {
		return new LoginPage(d);
	}

	public TablePage getTablePage() {
		return new TablePage(d);
	}
}
