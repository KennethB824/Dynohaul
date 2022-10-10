package dyno.steps;

import dyno.pages.LoginPage;
import dyno.pages.VehiclesPage;
import dyno.utilities.BrowserUtils;
import dyno.utilities.ConfigurationReader;
import dyno.utilities.Driver;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.io.File;
import java.io.IOException;

public class Vehicles_Steps {

    VehiclesPage vehiclesPage = new VehiclesPage();
    LoginPage loginPage = new LoginPage();

    @Given("user is on login page")
    public void user_is_on_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
    }
    @When("user enters credentials and clicks log in button")
    public void user_enters_credentials_and_clicks_log_in_button() {
        loginPage.login(ConfigurationReader.getProperty("store.user"), ConfigurationReader.getProperty("password"));
    }
    @Then("user should be logged in and on base page")
    public void user_should_be_logged_in_and_on_base_page() {
        BrowserUtils.waitForPageToLoad(10);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().equals("https://qa2.vytrack.com/"));
    }
    @When("user hovers over {string} module and clicks on {string} page")
    public void user_hovers_over_module_and_clicks_on_button(String module, String page) {
        BrowserUtils.waitFor(2);
        vehiclesPage.navigateToPage(module, page);
    }
    @When("user is on Vehicles page")
    public void user_is_on_vehicles_page() {
        BrowserUtils.waitForPageToLoad(10);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().equals("https://qa2.vytrack.com/entity/Extend_Entity_Carreservation"));
    }
    @Then("{string} is on the {string} side of the page")
    public void is_on_the_side_of_the_page(String button, String side) throws IOException {

        switch (side){
            case "left":
                BrowserUtils.waitForVisibility(vehiclesPage.exportGridDropdown, 10);
                Point leftLocation = vehiclesPage.exportGridDropdown.getLocation();
                int leftXcord = leftLocation.getX();

                Point middleLocation = vehiclesPage.middleOfPage.getLocation();
                int xOfMiddle = middleLocation.getX();

                System.out.println("x coordinate of export grid is " + leftXcord + ". Middle of the page is " + xOfMiddle);

                Assert.assertTrue(leftXcord < xOfMiddle);
                break;

            case "right":
                BrowserUtils.waitForVisibility(vehiclesPage.gridSettingsBtn, 10);
                Point rightLocation = vehiclesPage.gridSettingsBtn.getLocation();
                int rightXcord = rightLocation.getX();

                Point middleLocation2 = vehiclesPage.middleOfPage.getLocation();
                int xOfMiddle2 = middleLocation2.getX();

                System.out.println("x coordinate of grid settings is " + rightXcord + ". Middle of the page is " + xOfMiddle2);

                Assert.assertTrue(rightXcord > xOfMiddle2);
                break;

            default:
                System.out.println("There isn't such a side");
        }
    }
    @Then("user is able to click Export Grid dropdown")
    public void user_is_able_to_click_export_grid_dropdown() throws IOException {
        BrowserUtils.waitForClickablility(vehiclesPage.exportGridDropdown, 10);
        vehiclesPage.exportGridDropdown.click();
        WebElement gridDropdown = Driver.getDriver().findElement(By.xpath("//ul[@class='dropdown-menu']/li/a[@title='CSV']/../.."));
        BrowserUtils.getScreenshotOfElement(gridDropdown);
    }
    @Then("user should be able to click Grid Settings button")
    public void user_should_be_able_to_click_grid_settings_button() throws IOException {
        BrowserUtils.waitForClickablility(vehiclesPage.gridSettingsBtn, 10);
        vehiclesPage.gridSettingsBtn.click();
        WebElement gridSettingsDropdown = Driver.getDriver().findElement(By.xpath("//div[@class='dropdown-menu']"));
        BrowserUtils.getScreenshotOfElement(gridSettingsDropdown);
    }
    @Then("user should be able to click {string} button")
    public void user_should_be_able_to_click_button(String button) throws IOException {
        switch (button){
            case "refresh":
                BrowserUtils.waitForClickablility(vehiclesPage.refreshBtn, 10);
                vehiclesPage.refreshBtn.click();
                Assert.assertTrue(vehiclesPage.gridLoader.isEnabled());
                break;

            case "reset":
                BrowserUtils.waitForClickablility(vehiclesPage.resetBtn, 10);
                vehiclesPage.clickPrevOrNext("Next");
                String beforeReset = vehiclesPage.getPageOfRecords();
                vehiclesPage.resetBtn.click();
                BrowserUtils.waitFor(2);
                String afterReset = vehiclesPage.getPageOfRecords();
                Assert.assertNotEquals(afterReset, beforeReset);
                break;

            default:
                System.out.println("No such button");
        }
    }
    @Then("{string} button should be on the {string} side of Reset button")
    public void buttonShouldBeOnTheSideOfResetButton(String button, String side) throws IOException {
        switch (side){
            case "left":
                BrowserUtils.waitForClickablility(vehiclesPage.resetBtn, 10);
                WebElement leftBtn = Driver.getDriver().findElement(RelativeLocator.with(By.tagName("a")).toLeftOf(By.xpath("//a[@title='Reset']")));
                String attribute = leftBtn.getText();
                Assert.assertTrue(attribute.contains(button));
                BrowserUtils.getScreenshotOfElement(vehiclesPage.rightPanel);
                break;

            case "right":
                BrowserUtils.waitForClickablility(vehiclesPage.resetBtn, 10);
                WebElement rightBtn = Driver.getDriver().findElement(RelativeLocator.with(By.tagName("a")).toRightOf(By.xpath("//a[@title='Reset']")));
                String text = rightBtn.getAttribute("title");
                Assert.assertTrue(text.contains(button));
                BrowserUtils.getScreenshotOfElement(vehiclesPage.rightPanel);
                break;

            default:
                System.out.println("No such side");
        }
    }
}
