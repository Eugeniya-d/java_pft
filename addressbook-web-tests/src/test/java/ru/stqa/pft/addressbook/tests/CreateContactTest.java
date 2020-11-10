package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class CreateContactTest extends TestBase {


    @Test
    public void testCreateContact() throws Exception {
        app.getNavigationHelper().goToContactHomePage();
        app.getContactHelper().createContact(new ContactData("Eugeniya", "Davydova", "+77777777777", "ea@test.test"));
    }
}
