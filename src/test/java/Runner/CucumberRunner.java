package Runner;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import org.testng.annotations.DataProvider;

@CucumberOptions(
		features="src/main/java/Features",
		glue= {"stepDefinitions"},
		//tags="@Regression",
		//dryRun=true,
		monochrome=true,
		plugin= {
				"pretty",
				"html:target1/cucumber-reports/cucumber-pretty.html",
				"json:target1/cucumber-reports/Cucumber.json",
				"rerun:target1/cucumber-reports/rerun.txt"
		})
public class CucumberRunner extends AbstractTestNGCucumberTests{
	@Override
	@DataProvider(parallel = true)
		public Object[][] scenarios(){
		return super.scenarios();
			
		}
}
