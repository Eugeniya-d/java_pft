package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class CreateContactTest extends TestBase {


    @Test
    public void testCreateContact() throws Exception {
        goToNewContactPage();
        fillContactFields(new ContactData("Eugeniya", "Davydova", "+77777777777", "ea@test.test"));
        submitNewContactCreation();
        goToHomePage();
    }
}
