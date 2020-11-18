package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;

public class CreateContactTest extends TestBase {


    @Test
    public void testCreateContact() throws Exception {
        app.getNavigationHelper().goToContactHomePage();
        ContactData contact = new ContactData("Eugeniya", "Davydova", "+77777777777", "ea@test.test");
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().createContact(contact);
        app.getNavigationHelper().goToContactHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);


        int max = 0;
        for (ContactData c  : after) {
            if (c.getId() > max){
                max = c.getId();
            }
        }

contact.setId(max);
       before.add(contact);
        Assert.assertEquals(new HashSet<>(before), new HashSet<>(after));
       /* Comparator<? super ContactData> byId = Comparator.comparingInt(ContactData::getId);
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);*/
    }
}
