package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class DeleteGroupTest extends TestBase {

    @Test
    public void testDeleteGroup() throws Exception {
        goToGroupPage();
        selectGroup();
        deleteSelectedGroup();
        returnToGroupPage();
    }
}
