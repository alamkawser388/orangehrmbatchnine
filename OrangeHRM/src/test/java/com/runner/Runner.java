

package com.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = "src/test/resources",
		glue= {"com.stepDef"},
		tags = {"@regressiontest"},
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/report.html"},
		monochrome = true
			
		
		
)

public class Runner {

}
