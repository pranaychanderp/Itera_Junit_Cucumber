package test_runner;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import io.cucumber.java.AfterStep;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "Features",
		glue = {"step_definition","Utilities","hooks"},
//		dryRun = true,
//		tags = "@signup",
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
	
		
		)
public class Runner_Junit {
	
}
