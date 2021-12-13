package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Input {

    WebDriver driver;
    String label;

    public Input(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void writeInFields(String text) {
        driver.findElement(By.xpath(String.format(
                "//*[contains(text(),'%s')]/../input[contains(@class,'form-fields')]", label))).sendKeys(text);
    }

    public void writeNextFields(String text) {
        driver.findElement(By.xpath(String.format(
                "//*[contains(text(), '')]//*[contains(@class, 'form-control-full field-editor')]", label))).sendKeys(text);
    }
}
