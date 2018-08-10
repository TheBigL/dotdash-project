package com.mohamedleban.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class WebDriverTest {



    @Test
    void tasksWithoutCategories(ChromeDriver driver)
    {
        int elementCount = 0;


        String URI = "http://localhost/dotdash-project/index.php";
        driver.get(URI);
        List<WebElement> listElements = driver.findElements(By.cssSelector("div#todos-content ul li"));
        for (WebElement element: listElements)
        {
            if(element.getCssValue("color") == "#000")
            {
                element.getText();
                elementCount++;
            }

        }
    }
}