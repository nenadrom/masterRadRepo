package com.masterrad.addEditEmployeeSD;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		
		monochrome = true,
		//dryRun = false,
		
					
		features = {"src/test/resources/com/masterrad/addEditEmployeeFF/"},
		glue = {"com/masterrad/addEditEmployeeSD/"},
		
		plugin = {"pretty", 
				  "html:target/cucumber-htmlreport",
				  "json:target/cucumber-reprot.json",
				  "com.cucumber.listener.ExtentCucumberFormatter:target/Add_Edit_Employee_ExtentReport.html",
		}
	
		
		)





public class RunAddEditEmployeeTest {

}
