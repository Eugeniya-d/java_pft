package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class HelperBase {
    protected WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    protected void click(By locator) {
        wd.findElement(locator).click();
    }

    protected void type(By locator, String name) {
        click(locator);
        if (name != null) {
            String existingText = wd.findElement(locator).getAttribute("value");
            if (!name.equals(existingText)) {
                wd.findElement(locator).clear();
                wd.findElement(locator).sendKeys(name);
            }
        }
    }


    public boolean isElementPresent(By by) {
        try {
            wd.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }

    }
}
