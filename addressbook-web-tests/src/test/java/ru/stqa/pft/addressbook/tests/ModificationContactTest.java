package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ModificationContactTest extends TestBase {

    @Test
    public void testModificationContact() throws Exception {
        app.getNavigationHelper().goToContactHomePage();
        ContactData contact = new ContactData("Eugeniya", "Davydova", "+77777777777", "ea@test.test");
        if (! app.getContactHelper().isThereContact()){
            app.getContactHelper().createContact(contact));
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size()-1);
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactFields(contact);
        List<ContactData> after = app.getContactHelper().getContactList();
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToHomePage();
    }

}
