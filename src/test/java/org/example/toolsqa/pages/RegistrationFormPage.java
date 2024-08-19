package org.example.toolsqa.pages;

import org.example.toolsqa.AllureLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

import java.io.File;

public class RegistrationFormPage {
    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(RegistrationFormPage.class));
    WebDriver driver;

    @FindBy(css = "input[id='firstName']")
    private WebElement firstNameField;

    @FindBy(css = "input[id='lastName']")
    private WebElement lastNameField;

    @FindBy(css = "input[id='userEmail']")
    private WebElement emailField;

    @FindBy(css = "[for='gender-radio-1']")
    private WebElement genderCheckBoxMale;

    @FindBy(css = "#userNumber")
    private WebElement mobileFiled;

    @FindBy(xpath = "//input[@id='dateOfBirthInput']")
    private WebElement dateOfBirthFiled;

    @FindBy(xpath = "//option[contains(@value,'1997')]")
    private WebElement selectYear;

    @FindBy(xpath = "(//option[contains(@value,'0')])[1]")
    private WebElement selectMonth;

    @FindBy(css = "[class='react-datepicker__day react-datepicker__day--016']")
    private WebElement selectDay;

    @FindBy(css = "#subjectsInput")
    private WebElement subjectFiled;

    @FindBy(css = "#currentAddress")
    private WebElement currentAddress;

    @FindBy(css = "#uploadPicture")
    private WebElement selectPictureButton;

    @FindBy(xpath = "//div[@id='state']//input")
    private WebElement selectStateDropDownList;

    @FindBy(css = "#react-select-4-input")
    private WebElement selectCityDropDownList;

    @FindBy(xpath = "//button[@id='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//div[contains(text(),'Thanks for submitting the form')]")
    private WebElement newWindowAfterSubmitting;

    @FindBy(css = "[class='table table-dark table-striped table-bordered table-hover']>tbody")
    private WebElement textOnWindowAfterSubmitting;

    public void inputTextIntoFirstNameField(String text) {
        firstNameField.sendKeys(text);
        LOG.info("Enter first name: " + text);
    }

    public void inputTextIntoLastNameField(String text) {
        lastNameField.sendKeys(text);
        LOG.info("Enter last name: " + text);
    }

    public void inputTextIntoEmailField(String text) {
        emailField.sendKeys(text);
        LOG.info("Enter email: " + text);
    }

    public void clickGenderCheckBox() {
        genderCheckBoxMale.click();
        LOG.info("Click on the 'Male' in the Gender check box");
    }

    public void inputTextIntoMobileFiled(String text) {
        mobileFiled.sendKeys(text);
        LOG.info("Enter mobile: " + text);
    }

    public void selectDateOfBirth() {
        dateOfBirthFiled.click();
        selectYear.click();
        selectMonth.click();
        selectDay.click();

        LOG.info("Select the date of birth");
    }

    public void inputTextIntoSubjectFiled(String text) {
        for (char letter : text.toCharArray()) {
            subjectFiled.sendKeys(String.valueOf(letter));
        }

        subjectFiled.sendKeys("\n");
        LOG.info("Enter subject: " + text);
    }

    public void uploadPicture() {
        String filePath = new File("src/test/resources/SimbirSoft.png").getAbsolutePath();

        selectPictureButton.sendKeys(filePath);
        LOG.info("Upload the picture");
    }

    public void inputTextIntoCurrentAddress(String text) {
        currentAddress.sendKeys(text);
        LOG.info("Enter address: " + text);
    }

    public void selectState(String text) {
        selectStateDropDownList.sendKeys(text + "\n");
        LOG.info("Select state: " + text);
    }

    public void selectCity(String text) {
        selectCityDropDownList.sendKeys(text + "\n");
        LOG.info("Select city: " + text);
    }

    public void clickSubmitButton() {
        submitButton.click();
        LOG.info("Click on the Submit button");
    }

    public String checkNewWindowAfterSubmitting() {
        LOG.infoWithScreenshot("Check whether the window 'Thanks for submitting the form' is opened");
        return newWindowAfterSubmitting.getText();
    }

    public String checkTextOnWindowAfterSubmitting() {
        LOG.infoWithScreenshot("Check whether the previously entered data match or not");
        return textOnWindowAfterSubmitting.getText();
    }

    public RegistrationFormPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
