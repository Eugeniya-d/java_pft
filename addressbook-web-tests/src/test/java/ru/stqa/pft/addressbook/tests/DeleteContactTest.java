package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class DeleteContactTest extends TestBase {

    @Test
    public void testDeletContact() throws Exception{
        app.getNavigationHelper().goToContactHomePage();
        if (! app.getContactHelper().isThereContact()){
            app.getContactHelper().createContact(new ContactData("Eugeniya", "Davydova", "+77777777777", "ea@test.test"));
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().initContactDelete();
        app.getContactHelper().allertWindow();
        app.getNavigationHelper().goToContactHomePage();
    }

}
