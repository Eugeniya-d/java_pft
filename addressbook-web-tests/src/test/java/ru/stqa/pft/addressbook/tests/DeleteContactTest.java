package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class DeleteContactTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().contacts().size() == 0) {
            app.goTo().contactHomePage();
            app.contact().create(new ContactData().
                    withName("Eugeniya").withSurname("Davydova").withMobilePhone("+77777777777").withEmail("ea@test.test"));
        }
    }

    @Test
    public void testDeleteContact() throws Exception{
        Contacts before = app.db().contacts();
        ContactData deletedContact = before.iterator().next();
        app.goTo().contactHomePage();
        app.contact().delete(deletedContact);
        Contacts after = app.db().contacts();
        assertEquals(after.size(), before.size()-1);

        assertThat(after, equalTo(before.without(deletedContact)));
    }
}
