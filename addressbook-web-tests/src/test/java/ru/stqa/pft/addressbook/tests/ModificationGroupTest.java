package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ModificationGroupTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        if (app.db().groups().size() == 0){
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("MyTestGroup").withHeader("Test").withFooter("Test"));
        }
    }

    @Test
    public void testModificationGroup() throws Exception {
        Groups before = app.db().groups();
        GroupData modifiedGroup = before.iterator().next();
        GroupData group = new GroupData().withId(modifiedGroup.getId()).withName("Test").withHeader("Test").withFooter("Test");
        app.goTo().groupPage();
        app.group().modify(group);
        Groups after = app.db().groups();
        assertEquals(after.size(), before.size());

        assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));
    }

}
