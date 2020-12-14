package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;

public class AddContactToGroupTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().contacts().size() == 0) {
            app.goTo().contactHomePage();
            app.contact().create(new ContactData().
                    withName("Eugeniya7").withSurname("Davydova").withMobilePhone("+77777777777").withEmail("ea@test.test"));
        }
        if (app.db().groups().size() == 0 ){
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("MyTestGroup").withHeader("Test").withFooter("Test"));
        }
    }


    @Test
    public void testAddContactToGroup() throws Exception {
        app.goTo().contactHomePage();
        ContactData selectContact = app.db().contacts().iterator().next();
        GroupData selectGroup = new GroupData();
        Groups groups = app.db().groups();
        for (GroupData group : groups) {
            if (!selectContact.getGroups().contains(group)) {
                selectGroup = group;
            }
        }
        Contacts beforeContacts = selectGroup.getContacts();
        app.goTo().contactHomePage();
        app.contact().addToSelectedGroup(selectContact,selectGroup);
        Contacts afterContacts = app.db().group(selectGroup.getId()).getContacts();
        assertThat(afterContacts.size(), equalTo(beforeContacts.size()+1));
        assertThat(afterContacts, equalTo(beforeContacts.withAdded(selectContact)));
    }

}
