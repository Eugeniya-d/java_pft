package ru.mantis.pft.tests;

import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.mantis.pft.models.MailMessage;
import ru.mantis.pft.models.UserData;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class ChangePasswordTest extends TestBase{


  //  @BeforeMethod
    //public void startMailServer() {
      //  app.mail().start();
    //}

    @Test
    public void testChangePassword() throws IOException, MessagingException {
        app.changePassword().login(new UserData().withUsername("administrator").withPassword("root"));
        UserData user = app.db().users().stream().filter((m) -> m.getId() > 1).collect(Collectors.toList()).iterator().next();
        System.out.println(user);
     //  app.changePassword().start(user,email);
       // List<MailMessage> mailMessages = app.mail().waitForMail(2, 10000);
        //String confirmationMail = findConfirmationLink(mailMessages, email);
        //app.registration().finish(confirmationMail, password);
        //assertTrue(app.newSession().login(user,password));
    }

    private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
        MailMessage mailMessage = mailMessages.stream().filter((m)-> m.to.equals(email)).findFirst().get();
        VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
        return regex.getText(mailMessage.text);
    }

 //   @AfterMethod(alwaysRun = true)
 //   public void stopMailServer() {
   //     app.mail().stop();
    //}
}

