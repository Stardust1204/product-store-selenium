package example.ProductStore.MainUtility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {

    public static void waitElement(WebElement webElement, WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public static void writeText(WebElement webElement, String inputContent) {
        webElement.sendKeys(inputContent);
    }

}
