package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class DeleteGroupTest extends TestBase {

    @Test
    public void testDeleteGroup() throws Exception {
        app.goToGroupPage();
        app.selectGroup();
        app.deleteSelectedGroup();
        app.returnToGroupPage();
    }
}
