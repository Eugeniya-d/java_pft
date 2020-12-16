package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class RemoveContactFromGroupTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData()
                    .withName("MyTestGroup").withHeader("Test").withFooter("Test"));
        }

        Contacts allContacts = app.db().contacts();
        Groups allGroups = app.db().groups();
        List<GroupData> withoutUsedGroups = new ArrayList<>();
        for (GroupData group : allGroups) {
            if (group.getContacts().size() != 0) {
                withoutUsedGroups.add(group);
            }
        }
        if (withoutUsedGroups.size() == 0 && allContacts.size() != 0) {
            ContactData selectContact = allContacts.iterator().next();
            GroupData selectGroup = allGroups.iterator().next();
            app.goTo().contactHomePage();
            app.contact().addToSelectedGroup(selectContact, selectGroup);
        }
        if (allContacts.size() == 0) {
            app.goTo().contactHomePage();
            app.contact().create(new ContactData().withName("Eugeniya7").withSurname("Davydova")
                    .withMobilePhone("+77777777777").withEmail("ea@test.test"));
        }
    }


    @Test
    public void testRemoveContactFromGroup() {
        Groups allGroups = app.db().groups();
        List<GroupData> withUsedGroups = new ArrayList<>();
        for (GroupData group : allGroups) {
            if (group.getContacts().size() != 0) {
                withUsedGroups.add(group);
            }
        }

        GroupData selectGroup = withUsedGroups.iterator().next();
        ContactData selectContact = selectGroup.getContacts().iterator().next();
        app.goTo().contactHomePage();
        Contacts beforeContact = selectGroup.getContacts();
        Groups beforeGroup = selectContact.getGroups();
        app.contact().removeFromSelectedGroup(selectContact, selectGroup);
        Contacts afterContacts = app.db().group(selectGroup.getId()).getContacts();
        Groups afterGroups = app.db().contact(selectContact.getId()).getGroups();


        assertThat(afterContacts.size(), equalTo(beforeContact.size() - 1));
        assertThat(afterGroups.size(), equalTo(beforeGroup.size() - 1));

    }
}
