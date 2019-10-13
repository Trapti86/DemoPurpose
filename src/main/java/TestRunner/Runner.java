package TestRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
@CucumberOptions(
features = "D:\\Workspace\\BDDFramework\\src\\main\\java\\Features\\Login.feature",
glue = {"StepDefination"},
dryRun=false,
tags = {"~@Ignore"},
format = {
"pretty",



                "html:target/cucumber-reports/cucumber-pretty",



                "json:target/cucumber-reports/CucumberTestReport.json",



                "rerun:target/cucumber-reports/rerun.txt"



        },plugin = "json:target/cucumber-reports/CucumberTestReport.json")





public class Runner {

}
