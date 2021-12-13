package wrappers;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class Input {

    WebDriver driver;
    String label;

    public Input(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void writeInFields(String text) {
        log.debug("Send text '{}' to input '{}'", text, label);
        driver.findElement(By.xpath(String.format(
                "//*[contains(text(),'%s')]/../input[contains(@class,'form-fields')]", label))).sendKeys(text);
    }

    public void writeNextFields(String text) {
        log.debug("Send text '{}' to input '{}'", text, label);
        driver.findElement(By.xpath(String.format(
                "//*[@class='form-description form-description-full' and contains(text(),'%s')]" +
                        "/..//*[contains(@class,'form-control ')]", label))).sendKeys(text);
    }
}
