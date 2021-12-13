package wrappers;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class Dropdown {

    WebDriver driver;
    String label;

    public Dropdown(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void selectOption(String option) {
        log.debug("Select option '{}' in dropdown '{}'", option, label);
        driver.findElement(By.xpath(String.format
                ("//*[contains(text(),'%s')]/..//*[@class='chzn-container chzn-container-single']", label))).click();
        driver.findElement(By.xpath(String.format
                ("//*[@class='chzn-drop']/*/*[contains(text(),'%s')]", option))).click();
    }
}

