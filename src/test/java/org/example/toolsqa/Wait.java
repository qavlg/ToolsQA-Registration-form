package org.example.toolsqa;

import org.example.toolsqa.tests.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Wait {
    private WebDriverWait wait;

    public static Wait myWait(int seconds) {
        return new Wait(seconds);
    }

    public Wait(int seconds) {
        wait = new WebDriverWait(BaseTest.getDriver(), Duration.ofSeconds(seconds));
    }

    public WebElement clickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}

