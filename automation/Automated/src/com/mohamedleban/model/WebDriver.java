package com.mohamedleban.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WebDriver
{
    public void run()
    {
        int elementCount = 0;
        ChromeDriver driver = new ChromeDriver();



        String URI = "http://localhost/dotdash-project/index.php";

        driver.get(URI);

        List<WebElement> listElements = driver.findElements(By.cssSelector("div#todos-content ul li"));

        tasksWithoutCategories(listElements, elementCount);
        totalTasks(elementCount, listElements);
        resetElementCounter(elementCount);
        printTaskNames(listElements);
        checkedTasks(listElements, elementCount);






    }

    public void tasksWithoutCategories(List<WebElement> elements, int elementCount)
    {
        for (WebElement element: elements)
        {
            if(element.getCssValue("color") == "#000")
            {
                element.getText();
                elementCount++;
            }

        }

        System.out.println("There are " + elementCount + "tasks without categories.");
    }

    public void totalTasks(int elementCount, List<WebElement> elements)
    {
        for(WebElement element: elements)
        {
            elementCount++;

            System.out.println(elementCount + ") " + element.getText());
        }

        resetElementCounter(elementCount);
    }

    //Checks if the task has been completed
    public void checkedTasks(List<WebElement> elements, int elementCount)
    {
        for(WebElement element: elements)
        {
            boolean isCompleted = element.findElement(By.tagName("strike")).isDisplayed();

            if(isCompleted)
            {

                elementCount++;
                System.out.println(element.getText());
            }

        }

        resetElementCounter(elementCount);
    }

    public void printTaskNames(List<WebElement> elements)
    {
        for(WebElement element: elements)
        {
            System.out.printf(element.getText());
        }
    }

    public void resetElementCounter(int elementCount)
    {
        elementCount = 0;

    }





}
