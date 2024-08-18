package org.example.toolsqa.tests;

import org.example.toolsqa.Extension;
import org.example.toolsqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@ExtendWith(Extension.class)

public class RegistrationForm extends BaseTest {

    RegistrationFormPage rfp;

    @BeforeEach
    @Override
    public void setUp() {
        super.setUp();
        getDriver().get("https://demoqa.com/automation-practice-form");
        rfp = new RegistrationFormPage(getDriver());
    }


    @Test
    @DisplayName("#1. After entering valid data - registration is successful")
    public void titleLogin() {
        String firstName = "Aleksei";
        String lastName = "Sheichenko";
        String email = "sheichenko@example.ru";
        long mobile = 8987998778L;
        String subject = "test.test";
        String address = "Russia, Samara, Frunze st. 5";

        rfp.inputTextIntoFirstNameField(firstName);
        rfp.inputTextIntoLastNameField(lastName);
        rfp.inputTextIntoEmailField(email);
        rfp.clickGenderCheckBox();
        rfp.inputTextIntoMobileFiled(String.valueOf(mobile));
        rfp.selectDateOfBirth();
        rfp.inputTextIntoSubjectFiled(subject);
        rfp.uploadPicture();
        rfp.inputTextIntoCurrentAddress(address);

        rfp.clickSubmitButton();



        assertEquals("Student Name Aleksei Sheichenko\n" +
                "Student Email sheichenko@example.ru\n" +
                "Gender Male\n" +
                "Mobile 8987998778\n" +
                "Date of Birth 16 January,1997\n" +
                "Subjects\n" +
                "Hobbies\n" +
                "Picture picture.jpg\n" +
                "Address Russia, Samara, Frunze st. 5\n" +
                "State and City", rfp.checkTextOnWindowAfterSubmitting());
        assertEquals("Thanks for submitting the form", rfp.checkNewWindowAfterSubmitting(), "Incorrect title");
    }




}
