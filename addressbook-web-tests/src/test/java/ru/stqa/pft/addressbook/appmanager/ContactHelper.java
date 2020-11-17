package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {


    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void fillContactFields(ContactData contactData) {
        type(By.name("firstname"), contactData.getName());
        type(By.name("lastname"), contactData.getSurname());
        type(By.name("mobile"), contactData.getMobilePhone());
        type(By.name("email"), contactData.getEmail());
    }


    public void allertWindow() {
        wd.switchTo().alert().accept();
    }

    public void submitNewContactCreation() {
        click(By.xpath("(//input[@name='submit'])[2]"));
    }

    public void initNewContactPage() {
        click(By.linkText("add new"));
    }

    public void selectContact() {
        click(By.name("selected[]"));
    }

    public void initContactModification() {
        click(By.cssSelector("img[alt='Edit']"));
    }

    public void submitContactModification() {
        click(By.name("update"));
    }

    public void initContactDelete() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void returnToHomePage() {
        click(By.linkText("home page"));
    }

    public void createContact(ContactData contact) {
        initNewContactPage();
        fillContactFields(contact);
        submitNewContactCreation();
        returnToHomePage();
    }

    public boolean isThereContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public List<ContactData> getContactList() {
        List<ContactData> contacts = new ArrayList<>();
        List<WebElement> elements = wd.findElements(By.className("entry"));

        for (WebElement element : elements) {
            String surname = element.findElement(By.xpath("td[2]")).getText();
            String name = element.findElement(By.xpath("td[3]")).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
            ContactData contact = new ContactData(id, name, surname, null, null);
            contacts.add(contact);
        }
        return contacts;
    }
}

