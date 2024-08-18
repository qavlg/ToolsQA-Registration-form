package org.example.toolsqa.pages;

import org.example.toolsqa.AllureLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

import java.io.File;

import static org.example.toolsqa.Wait.myWait;

public class RegistrationFormPage {

    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(RegistrationFormPage.class));

    WebDriver driver;

    @FindBy(css = "input[id='firstName']")
    private WebElement firstNameField;

    @FindBy(css = "input[id='lastName']")
    private WebElement lastNameField;

    @FindBy(css = "input[id='userEmail']")
    private WebElement emailField;

    @FindBy(css = "[for=\"gender-radio-1\"]")
    private WebElement genderCheckBoxMale;

    @FindBy(xpath = "//input[@placeholder='Mobile Number']")
    private WebElement mobileFiled;

    @FindBy(xpath = "//input[@id='dateOfBirthInput']")
    private WebElement dateOfBirthFiled;

    @FindBy(xpath = "//option[contains(@value,'1997')]")
    private WebElement selectYear;

    @FindBy(xpath = "(//option[contains(@value,'0')])[1]")
    private WebElement selectMonth;

    @FindBy(css = "[class=\"react-datepicker__day react-datepicker__day--016\"]")
    private WebElement selectDay;

    @FindBy(xpath = "(//input[@autocapitalize='none'])[1]")
    private WebElement subjectFiled;

    @FindBy(css = "#currentAddress")
    private WebElement currentAddress;

    @FindBy(css = "#uploadPicture")
    private WebElement selectPictureButton;

    @FindBy(xpath = "(//div[@class=' css-1hwfws3'])[1]")
    private WebElement selectStateDropDownList;

    @FindBy(xpath = "(//div[@class=' css-tlfecz-indicatorContainer'])[2]")
    private WebElement selectCityDropDownList;

    @FindBy(xpath = "//button[@id='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//div[contains(text(),'Thanks for submitting the form')]")
    private WebElement newWindowAfterSubmitting;

    @FindBy(css = "[class='table table-dark table-striped table-bordered table-hover']>tbody")
    private WebElement textOnWindowAfterSubmitting;


    public void inputTextIntoFirstNameField(String text) {
        firstNameField.sendKeys(text);

        LOG.info("Entering text into the first name field");
    }

    public void inputTextIntoLastNameField(String text) {
        lastNameField.sendKeys(text);

        LOG.info("Entering text into the last name field");
    }

    public void inputTextIntoEmailField(String text) {
        emailField.sendKeys(text);

        LOG.info("Entering text into the email field");
    }

    public void clickGenderCheckBox() {
       genderCheckBoxMale.click();

       LOG.info("Clicking on the gender check box");
    }

    public void inputTextIntoMobileFiled(String text) {
        mobileFiled.sendKeys(text);

        LOG.info("Entering text into the mobile field");
    }

    public void selectDateOfBirth() {
        dateOfBirthFiled.click();
        selectYear.click();
        selectMonth.click();
        selectDay.click();

        LOG.info("Selecting the date of birth");
    }

    public void inputTextIntoSubjectFiled(String text) {
        subjectFiled.sendKeys(text);

        LOG.info("Entering text into the subject field");
    }


    public void uploadPicture() {
        //selectPictureButton.click();
        String filePath = new File("src/test/resources/picture.jpg").getAbsolutePath();
        selectPictureButton.sendKeys(filePath);

        LOG.info("Uploading picture");
    }

    public void inputTextIntoCurrentAddress(String text) {
        currentAddress.sendKeys(text);

        LOG.info("Entering text into the current address field");
    }

    public void clickSubmitButton() {
        submitButton.click();

        LOG.info("Clicking on the submit button");
    }

    public String checkNewWindowAfterSubmitting() {

        LOG.infoWithScreenshot("Checking if the window 'Thanks for submitting the form' is opened");
        return newWindowAfterSubmitting.getText();
    }

    public String checkTextOnWindowAfterSubmitting() {

        LOG.infoWithScreenshot("Checking if the window 'Thanks for submitting the form' is opened");
        return textOnWindowAfterSubmitting.getText();
    }




    public RegistrationFormPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
