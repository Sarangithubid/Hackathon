package testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {".//FeatureFiles\\Identify_Course.feature"},
		glue="stepDefinitionFiles",
		plugin= {"pretty","html:reports//myReport.html",
				"json:report/MyReport.json"},
		dryRun=false,
		monochrome=true,
		publish=true
		)
public class TestRun {

}
