package ru.mantis.pft.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.mantis.pft.models.MailMessage;
import ru.mantis.pft.models.UserData;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class ChangePasswordTest extends TestBase {


    @BeforeMethod
    public void startMailServer() {
        app.mail().start();
    }

    @Test
    public void testChangePassword() throws IOException, MessagingException {
        String password = "password1";
        app.changePassword().login(new UserData().withUsername("administrator").withPassword("root"));
        UserData user = app.db().users().stream().filter((d) -> d.getId() > 1).collect(Collectors.toList()).iterator().next();
        int id = user.getId();
        String email = user.getEmail();
        String username = user.getUsername();
        app.changePassword().change(id);
        List<MailMessage> mailMessages = app.mail().waitForMail(1, 10000);
        String confirmationLink = findConfirmationLink(mailMessages, email);
        app.changePassword().finishChanges(confirmationLink, password);
        Assert.assertTrue(app.newSession().login(username, password));
    }


    private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
        MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
        VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
        return regex.getText(mailMessage.text);
    }

    @AfterMethod(alwaysRun = true)
    public void stopMailServer() {
        app.mail().stop();
    }
}

