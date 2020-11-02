package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class CreateGroupTest extends TestBase {


    @Test
    public void testCreateGroup() throws Exception {
        app.goToGroupPage();
        app.initGroupCreation();
        app.fillGroupFields(new GroupData("MyTestGroup", "Test", "Test"));
        app.submitGroupCreation();
        app.returnToGroupPage();

    }

}