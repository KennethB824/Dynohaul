package dyno.pages;

import dyno.utilities.BrowserUtils;
import dyno.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//li[@id='user-menu']/a")
    public WebElement fullName;


    /**
     * Method to click base menu and to click specific option given in the params
     * Options that can be given in param are:
     * My User
     * My Configuration
     * My Calendar
     * Logout
     */
    public void clickBaseMenu(String option){
        fullName.click();
        Driver.getDriver().findElement(By.linkText(option)).click();
    }

    /**
     * Navigates to page by hovering over module given in first param and making dropdown menu appear.
     * Then clicks page given in second param
     * @param module - hover over this
     * @param page - click this button
     */
    public void navigateToPage(String module, String page){
        WebElement moduleBtn = Driver.getDriver().findElement(By.xpath("(//span[contains(text(), '"+module+"')])[1]"));
        WebElement pageBtn = Driver.getDriver().findElement(By.xpath("//span[text() = '"+page+"']"));

        BrowserUtils.hover(moduleBtn);
        BrowserUtils.waitForClickablility(pageBtn, 10);
        pageBtn.click();
    }
}
