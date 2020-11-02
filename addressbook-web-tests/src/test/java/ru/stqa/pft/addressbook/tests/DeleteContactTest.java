package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class DeleteContactTest extends TestBase {

    @Test
    public void testDeletContact() throws Exception{
        app.getNavigationHelper().goToContactHomePage();
        app.getContactHelper().selectContact();
        app.getContactHelper().initContactDelete();
        app.getContactHelper().allertWindow();
        app.getNavigationHelper().goToContactHomePage();
    }

}
