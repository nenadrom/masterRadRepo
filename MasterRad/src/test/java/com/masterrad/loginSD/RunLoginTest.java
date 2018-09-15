package com.masterrad.loginSD;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		
		monochrome = true,
		//dryRun = false,
		
					
		features = {"src/test/resources/com/masterrad/loginFF/"},
		glue = {"com/masterrad/loginSD/"},
		
		plugin = {"pretty", 
				  "html:target/cucumber-htmlreport",
				  "json:target/cucumber-reprot.json",
				  "com.cucumber.listener.ExtentCucumberFormatter:target/ExtentReport.html",
		}
	
		
		)





public class RunLoginTest {

}
