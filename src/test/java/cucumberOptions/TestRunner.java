package cucumberOptions;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@Test
@CucumberOptions(
		features = "src/test/java/features"
		, glue = "stepdefinitions"
		//, stepNotifications = true
		,monochrome = true
		//,publish = true
		//,dryRun = true
		,tags= "@slidertest"
		,plugin =  {"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"})

public class TestRunner extends AbstractTestNGCucumberTests{
	@Override
	@DataProvider(parallel = true)
    public Object[][] scenarios() {
    	return super.scenarios();
    }
}
/*public class TestRunner{
	
}*/
