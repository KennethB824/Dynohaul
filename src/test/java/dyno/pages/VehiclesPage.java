package dyno.pages;

import dyno.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VehiclesPage extends BasePage{

    @FindBy(xpath = "//div[@class='btn-group']/a")
    public WebElement exportGridDropdown;

    @FindBy(xpath = "//div[@class='pagination pagination-centered']/label[2]")
    public WebElement middleOfPage;

    @FindBy(xpath = "//a[@title='Grid Settings']")
    public WebElement gridSettingsBtn;

    @FindBy(xpath = "//i[@class='fa-repeat']/..")
    public WebElement refreshBtn;

    @FindBy(xpath = "//a[@title='Reset']")
    public WebElement resetBtn;

    @FindBy(xpath = "//div[@class='loader-mask']")
    public WebElement gridLoader;

    @FindBy(xpath = "//div[@class='actions-panel pull-right form-horizontal']")
    public WebElement rightPanel;

    @FindBy(xpath = "//input[@type='number']")
    private WebElement recordsPage;

//    @FindBy(xpath = "//i[contains(text(), 'Next')]/..")
//    public WebElement nextBtn;

    /**
     * Click previous or next records in Vehicles page
     * @param str Options: 'Prev' or 'Next'
     */
    public void clickPrevOrNext(String str){
        WebElement direction = Driver.getDriver().findElement(By.xpath("//i[contains(text(), '"+str+"')]/.."));
        direction.click();
    }

    /**
     * Gets the page of records in Vehicles page
     * @return
     */
    public String getPageOfRecords(){
        return recordsPage.getAttribute("value");
    }
}
