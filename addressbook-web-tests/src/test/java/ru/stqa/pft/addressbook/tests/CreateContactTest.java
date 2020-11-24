package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CreateContactTest extends TestBase {


    @Test
    public void testCreateContact() throws Exception {
        app.goTo().contactHomePage();
        Contacts before = app.contact().all();
        ContactData contact = new ContactData().
                withName("Eugeniya").withSurname("Davydova").withMobilePhone("+77777777777").withEmail("ea@test.test");
        app.contact().create(contact);
        Contacts after = app.contact().all();
        assertThat(after.size(), equalTo(before.size()+1));

        assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt(g -> g.getId()).max().getAsInt()))));
    }
}
