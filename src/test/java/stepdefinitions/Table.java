package stepdefinitions;

import io.cucumber.java.en.When;
import pom.PomManager;

public class Table {
	private PomManager p;
	private Hooks c;
	public Table(Hooks c) {
		this.p = c.getPOM();
		this.c = c;
	}
	
	@When("User Deletes a Row")
	public void user_deletes_a_row() {
	    // Write code here that turns the phrase above into concrete actions
	    p.getTablePage().deleteRow();
		c.getScreenshot();
	}
}
