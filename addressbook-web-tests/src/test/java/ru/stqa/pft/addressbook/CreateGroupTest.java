package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class CreateGroupTest extends TestBase {


    @Test
    public void testCreateGroup() throws Exception {
        goToGroupPage();
        initGroupCreation();
        fillGroupFields(new GroupData("MyTestGroup", "Test", "Test"));
        submitGroupCreation();
        returnToGroupPage();

    }

}
