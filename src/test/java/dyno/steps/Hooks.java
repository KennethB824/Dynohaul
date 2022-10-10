package dyno.steps;

import dyno.utilities.ConfigurationReader;
import dyno.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void setUpScenario(){
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
    }

    @After
    public void tearDownScenario(Scenario scenario){

        if (scenario.isFailed()){
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

    Driver.closeDriver();
    }
}
