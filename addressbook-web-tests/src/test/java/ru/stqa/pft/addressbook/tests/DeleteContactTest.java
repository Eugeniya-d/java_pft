package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class DeleteContactTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().contactHomePage();
        if (app.contact().list().size() == 0) {
            app.contact().create(new ContactData().withName("Eugeniya").withSurname("Davydova").withMobilePhone("+77777777777").withEmail("ea@test.test"));
        }
    }

    @Test
    public void testDeleteContact() throws Exception{
        List<ContactData> before = app.contact().list();
        int index = before.size()-1;
        app.contact().delete(index);
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size()-1);

        before.remove(index);
        Assert.assertEquals(before, after);
    }



}
