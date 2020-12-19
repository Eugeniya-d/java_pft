package ru.mantis.pft.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.mantis.pft.models.MailMessage;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class RegistrationTest extends TestBase{

    @BeforeMethod
    public void startMailServer() {
        app.mail().start();
    }


    @Test
    public void testRegistration() throws IOException, MessagingException {
        long now = System.currentTimeMillis();
        String email = String.format("user%s@localhost",now);
        String user = "user" + now;
        String password = String.format("user%s",now);
        app.registration().start(user,email);
        List<MailMessage> mailMessages = app.mail().waitForMail(1, 10000);
        String confirmationMail = findConfirmationLink(mailMessages, email);
        app.registration().finish(confirmationMail, password);
        assertTrue(app.newSession().login(user,password));
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
