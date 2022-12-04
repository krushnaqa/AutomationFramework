package Runner;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import org.testng.annotations.DataProvider;

@CucumberOptions(
		features="@target1/cucumber-reports/rerun.txt",
		glue= {"stepDefinitions"},
		//tags="@Regression",
		//dryRun=true,
		monochrome=true,
		plugin= {
				"pretty",
				"html:target2/cucumber-reports/cucumber-pretty.html",
				"json:target2/cucumber-reports/Cucumber.json",
				"rerun:target2/cucumber-reports/rerun.txt"
		})
public class CucumberRerunner extends AbstractTestNGCucumberTests{
	@Override
	@DataProvider(parallel = true)
		public Object[][] scenarios(){
		return super.scenarios();
			
		}
}
