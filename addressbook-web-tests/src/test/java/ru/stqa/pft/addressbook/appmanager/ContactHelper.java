package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

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
        type(By.name("email2"), contactData.getEmail2());
        type(By.name("email3"), contactData.getEmail3());
        type(By.name("home"), contactData.getHomePhone());
        type(By.name("mobile"), contactData.getMobilePhone());
        type(By.name("work"), contactData.getWorkPhone());
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


    public void submitContactModification() {
        click(By.name("update"));
    }

    public void initContactDelete() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void returnToHomePage() {
        click(By.linkText("home page"));
    }

    public void returnToHome() {
        click(By.linkText("home"));
    }

    public void create(ContactData contact) {
        initNewContactPage();
        fillContactFields(contact);
        submitNewContactCreation();
        returnToHomePage();
    }

    public void modify(ContactData contact) {
        initContactModificationById(contact.getId());
        fillContactFields(contact);
        submitContactModification();
        returnToHome();
    }

    public void delete(ContactData contact) {
        selectContactById(contact.getId());
        initContactDelete();
        allertWindow();
        returnToHome();
    }

    private void selectContactById(int id) {
        wd.findElement(By.cssSelector("input[value ='" + id + "']")).click();
    }

    public void initContactModificationById(int id) {
        wd.findElement(By.cssSelector("a[href='edit.php?id=" + id + "']")).click();
    }

    public boolean isThereContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public Contacts all() {
        Contacts contacts = new Contacts();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            String name = element.findElement(By.xpath("td[3]")).getText();
            String surname = element.findElement(By.xpath("td[2]")).getText();
            String allPhones = element.findElement(By.xpath("td[6]")).getText();
            String[] address = element.findElement(By.xpath("td[4]")).getText().split("\n");
            String allMails = element.findElement(By.xpath("td[5]")).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
            ContactData contact = new ContactData().withId(id).withName(name).withSurname(surname).
                    withAllPhones(allPhones).withAllMails(allMails).withAddress(address[0]);
            contacts.add(contact);
        }
        return contacts;
    }

    public ContactData infoFromEditedForm(ContactData contact) {
        initContactModificationById(contact.getId());
        String name = wd.findElement(By.name("firstname")).getAttribute("value");
        String surname = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        String email = wd.findElement(By.name("email")).getAttribute("value");
        String email2 = wd.findElement(By.name("email2")).getAttribute("value");
        String email3 = wd.findElement(By.name("email3")).getAttribute("value");
        String[] address = wd.findElement(By.name("address")).getAttribute("value").split("\n");
        wd.navigate().back();
        return new ContactData().withId(contact.getId()).withName(name).withSurname(surname).
                withMobilePhone(mobile).withHomePhone(home).withWorkPhone(work).withAddress(address[0]).
                withEmail(email).withEmail2(email2).withEmail3(email3);

    }
}

