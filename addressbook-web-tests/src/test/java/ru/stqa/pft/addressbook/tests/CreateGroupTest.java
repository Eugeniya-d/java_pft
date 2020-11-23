package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CreateGroupTest extends TestBase {


    @Test
    public void testCreateGroup() {
        app.goTo().groupPage();
        Set<GroupData> before = app.group().all();
        GroupData group = new GroupData().withName("MyTestGroup").withHeader("Test").withFooter("Test");
        app.group().create(group);
        Set<GroupData> after = app.group().all();
        assertThat(after.size(),equalTo( before.size() + 1));


        group.withId(after.stream().mapToInt(g -> g.getId()).max().getAsInt());
        before.add(group);
        assertThat(after, equalTo(before.withAdded(group)));
    }

}
