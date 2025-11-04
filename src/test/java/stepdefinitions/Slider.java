package stepdefinitions;

import io.cucumber.java.en.Then;
import pom.PomManager;

public class Slider {
	private PomManager p;
	private Hooks c;
	public Slider(Hooks c) {
		this.p = c.getPOM();
		this.c = c;
	}
	
	@Then("Set Slider value to \"([^\"]*)")
	public void set_slider_value(String arg0) {
	    // Write code here that turns the phrase above into concrete actions
	    p.getTablePage().deleteRow();
		c.getScreenshot();
	}
}
