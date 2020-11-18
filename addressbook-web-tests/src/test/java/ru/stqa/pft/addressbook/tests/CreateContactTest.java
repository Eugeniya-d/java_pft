package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class CreateContactTest extends TestBase {


    @Test
    public void testCreateContact() throws Exception {
        app.getNavigationHelper().goToContactHomePage();
        ContactData contact = new ContactData("Eugeniya", "Davydova", "+77777777777", "ea@test.test");
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().createContact(contact);
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);

       /* before.add(contact);
        Comparator<? super ContactData> byId = Comparator.comparingInt(ContactData::getId);
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
   */ }
}
