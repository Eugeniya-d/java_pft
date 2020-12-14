package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

public class AddContactToGroupTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().contacts().size() == 0) {
            app.goTo().contactHomePage();
            app.contact().create(new ContactData().
                    withName("Eugeniya").withSurname("Davydova").withMobilePhone("+77777777777").withEmail("ea@test.test"));
        }
    }


    @Test
    public void testAddContactToGroup() throws Exception {
        Contacts contactList = app.db().contacts();
        ContactData selectContact = contactList.iterator().next();
        Groups groupList = app.db().groups();
        GroupData selectGroup = groupList.iterator().next();
        app.goTo().contactHomePage();
        app.contact().addToSelectedGroup(selectContact,selectGroup);

    }

}
