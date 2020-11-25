package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

public class VerifyContactTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().contactHomePage();
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData().withName("Eugeniya").withSurname("Davydova")
                    .withMobilePhone("+77777777777").withEmail("ea@test.test"));
        }
    }

    @Test
    public void testVerifyContact() {
        app.goTo().contactHomePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditedForm = app.contact().infoFromEditedForm(contact);

        MatcherAssert.assertThat(contact.getAllPhones(), CoreMatchers.equalTo(mergePhones(contactInfoFromEditedForm)));
        MatcherAssert.assertThat(contact.getAllMails(), CoreMatchers.equalTo(mergeEmails(contactInfoFromEditedForm)));
    MatcherAssert.assertThat(contact.getAddress(), CoreMatchers.equalTo(contactInfoFromEditedForm.getAddress()));

    }

    private String mergeEmails(ContactData contact) {
        return Arrays.asList(contact.getEmail(),contact.getEmail2(),contact.getEmail3())
                .stream().filter((s) -> !s.equals(""))
                .map(VerifyContactTest::cleanedEmails)
                .collect(Collectors.joining("\n"));
    }

    private String mergePhones(ContactData contact) {
      return Arrays.asList(contact.getMobilePhone(),contact.getHomePhone(),contact.getWorkPhone())
              .stream().filter((s) -> !s.equals(""))
              .map(VerifyContactTest::cleanedPhones)
              .collect(Collectors.joining("\n"));
    }

    public static String cleanedPhones(String phone) {
        return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
    }

    public static String cleanedEmails(String email) {
        return email.replaceAll("\\s", "");
    }
}
