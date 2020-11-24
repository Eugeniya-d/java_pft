package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ModificationContactTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().contactHomePage();
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData().
                    withName("Eugeniya").withSurname("Davydova").withMobilePhone("+77777777777").withEmail("ea@test.test"));
        }
    }

    @Test
    public void testModificationContact() throws Exception {
        Contacts before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData().withId(modifiedContact.getId())
                .withName("Eugeniya2000").withSurname("Davydova").withMobilePhone("+77777777777").withEmail("ea@test.test");
        app.contact().modify(contact);
        Contacts after = app.contact().all();
        assertEquals(before.size(), after.size());

        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    }
}
