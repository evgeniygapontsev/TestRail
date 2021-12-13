package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Dropdown {

    WebDriver driver;
    String label;

    public Dropdown(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void selectOption(String option) {
        driver.findElement(By.xpath(String.format
                ("//*[contains(text(),'%s')]/..//*[@class='chzn-container chzn-container-single']", label))).click();
        driver.findElement(By.xpath(String.format
                ("//*[@class='chzn-drop']/*/*[contains(text(),'%s')]", option))).click();
    }
}

