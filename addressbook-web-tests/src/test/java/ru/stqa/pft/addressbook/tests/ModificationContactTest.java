package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ModificationContactTest extends TestBase {

    @Test
    public void testModificationContact() throws Exception {
        app.getNavigationHelper().goToContactHomePage();
        app.getContactHelper().selectContact();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactFields(new ContactData("1Eugeniya", "Davydova", "+77777777777", "ea@test.test"));
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToHomePage();
    }

}
